package com.xander.java8.simple;

import io.cucumber.java8.En;
import org.junit.Assert;

/**
 * @author Kevin Azangue
 */
public class CalculatorStepsDef implements En {

    private int a, b;
    private int result;

    public CalculatorStepsDef() {
        Given("the two number {int} and {int}", (Integer num1, Integer num2) -> {
            this.a = num1;
            this.b = num2;
        });
        When("i add them", () -> result = a + b);

        Then("the result muss be {int}", (Integer expected) -> Assert.assertEquals(expected.intValue(), result));
    }
}
