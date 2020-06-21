package com.xander.transformer.shopping;

import com.xander.shopping.Grocery;
import com.xander.shopping.Price;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;

/**
 * @author Kevin Azangue
 */
public class GroceryListStepsDef {

    private Map<String, Grocery> stock;
    private int price;

    @Before
    public void init() {
        stock = new HashMap<>();
    }

    @Given("the following groceries:")
    public void the_following_groceries(List<Grocery> groceries) {
        for (Grocery grocery : groceries) {
            stock.put(grocery.getName(), grocery);
        }
    }

    @When("i check the price of the {}")
    public void i_check_the_price_of_the_milk(String grocery) {
        price = stock.get(grocery).getPrice().getValue();
    }

    @Then("i become {int}")
    public void i_become(Integer expected) {
        Assert.assertEquals(expected.intValue(), price);
    }

    @DataTableType
    public Grocery defineGrocery(Map<String, String> entry) {
        return new Grocery(entry.get("name"), new Price(Integer.parseInt(entry.get("price"))));
    }
}
