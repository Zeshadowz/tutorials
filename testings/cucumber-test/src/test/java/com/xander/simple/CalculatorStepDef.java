package com.xander.simple;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * @author Kevin Azangue
 */
public class CalculatorStepDef {

    private int total;
    private Calculator calculator;

    @Given("I have a calculator")
    public void iHaveACalculator() throws Throwable {
        calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void iAddAnd(int num1, int num2) {
        total = calculator.add(num1, num2);
    }

    @Then("the result should be {int}")
    public void theResultShouldBe(int result) {
        Assert.assertEquals(total, result);
    }
}
