package com.nopcommerce.tri;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.nopcommerce.tri",
    plugin = {"pretty","html:target/cucumber-report.html", "json:target/cucumber.json"},    // in log đẹp hơn
    monochrome = true      // clear log
)

public class TestRunnerTest {
}
