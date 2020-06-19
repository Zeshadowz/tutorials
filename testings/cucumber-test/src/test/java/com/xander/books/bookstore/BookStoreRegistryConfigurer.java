package com.xander.books.bookstore;

import com.xander.books.Book;
import com.xander.books.BookCatalog;
import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.DataTableTypeRegistry;
import io.cucumber.datatable.DataTableTypeRegistryTableConverter;
import io.cucumber.datatable.TableTransformer;

/**
 * @author Kevin Azangue
 */
public class BookStoreRegistryConfigurer implements TypeRegistryConfigurer {

    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(
                new DataTableType(BookCatalog.class, new BookTableTransformer())
        );
    }

    private static class BookTableTransformer implements TableTransformer<BookCatalog> {

        @Override
        public BookCatalog transform(DataTable table) throws Throwable {

            BookCatalog catalog = new BookCatalog();

            table.cells()
                    .stream()
                    .skip(1)        // Skip header row
                    .map(fields -> new Book(fields.get(0), fields.get(1)))
                    .forEach(catalog::addBook);

            return catalog;
        }

    }
}
