package com.xander.books.bookstore;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Kevin Azangue
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/books/book-store.feature","classpath:features/books/book-store-background.feature"},
        glue = "com.xander.books",
        plugin = "pretty"
)
public class BookStoreIntegrationTest {

}
