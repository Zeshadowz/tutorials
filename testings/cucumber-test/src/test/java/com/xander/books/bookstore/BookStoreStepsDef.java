package com.xander.books.bookstore;

import com.xander.books.Book;
import com.xander.books.BookCatalog;
import com.xander.books.BookStore;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Assert;

/**
 * @author Kevin Azangue
 */
public class BookStoreStepsDef {

    private BookStore store;
    private List<Book> foundBooks;
    private Book foundBook;

    @Before
    public void setUp() {
        store = new BookStore();
        foundBooks = new ArrayList<>();
    }

    @Given("I have the following books in the store")
    public void iHaveTheFollowingBooksInTheStore(DataTable table) {
        iHaveTheFollowingBooksInTheStoreByList(table);
    }

    @Given("I have the following books in the store by list")
    public void iHaveTheFollowingBooksInTheStoreByList(DataTable table) {
        List<List<String>> rows = table.asLists(String.class);
        for (List<String> columns : rows) {
            store.addBook(new Book(columns.get(0), columns.get(1)));
        }
    }

    @Given("I have the following books in the store by map")
    public void iHaveTheFollowingBooksInTheStoreByMap(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);

        for (Map<String, String> map : rows) {
            store.addBook(new Book(map.get("title"), map.get("author")));
        }
    }

    @Given("I have the following books in the store with transformer")
    public void iHaveTheFollowingBooksInTheStoreWithTransformer(BookCatalog catalog) {
        this.store.addAllBooks(catalog.getBooks());
    }

    @When("I search for books by author (.+)$")
    public void iSearchForBooksByAuthor(String author) {
        foundBooks = store.booksByAuthor(author);
    }

    @Then("I find {int} books")
    public void iFindBooks(int count) {
        Assert.assertEquals(count, foundBooks.size());
    }

    @When("I search for a book titled (.+)$")
    public void iSearchForABookTitled(String title) {
        foundBook = store.bookByTitle(title).orElse(null);
    }

    @Then("I find no book")
    public void iFindNoBook() {
        Assert.assertNull(foundBook);
    }
}
