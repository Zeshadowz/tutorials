package com.xander.transformer.shopping;

import com.xander.shopping.Grocery;
import io.cucumber.java.DocStringType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Assert;

/**
 * @author Kevin Azangue
 */
public class ShoppingListStepsDef {

    private List<Grocery> shoppingList;
    private int count;

    @Given("the following shopping list:")
    public void the_following_shopping_list(List<Grocery> groceries) {
        shoppingList = groceries;
    }

    @When("i count the groceries in the list")
    public void i_count_the_groceries_in_the_list() {
        count = shoppingList.size();
    }

    @Then("i should have {int} items")
    public void i_should_have_items(Integer expected) {
        Assert.assertEquals(expected.intValue(), count);
    }

    @DocStringType(contentType = "shopping_list")
    public List<Grocery> defineSoppingList(String docString) {
        return Stream.of(docString.split("\\s")).map(Grocery::new).collect(Collectors.toList());
    }
}
