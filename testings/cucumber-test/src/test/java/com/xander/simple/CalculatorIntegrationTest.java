package com.xander.simple;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Kevin Azangue
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/simple/calculator.feature", "classpath:features/simple/calculator-outline.feature"},
        glue = "com.xander.simple",
        plugin = {"pretty"},
        tags = "@CalculatorFeature"
)
public class CalculatorIntegrationTest {

}
