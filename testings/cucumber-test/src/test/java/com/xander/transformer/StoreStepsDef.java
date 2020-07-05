package com.xander.transformer;

import com.xander.store.Product;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import java.util.List;

/**
 * @author Kevin Azangue
 */
public class StoreStepsDef {

    @Given("the store with the following products:")
    public void the_store_with_the_following_products(List<Product> data) {
//        List<List<String>> products = data.asLists(String.class);
//        for(List<String> product : products){
//            System.out.println(product.get(1));
//        }
    }

    @DataTableType
    public Product defineProduct(DataTable table) {
        List<List<String>> product = table.asLists(String.class);
        return new Product("s");
    }
}
