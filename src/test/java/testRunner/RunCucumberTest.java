package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "classpath:features",
        },
        plugin = {
                "pretty",
                "rerun:rerun/failed_scenarios.txt",
                "json:target/cucumber.json",
        },
        tags = "@regression",
        glue = {
                "config",
                "stepdefinitions"
        })

public class RunCucumberTest {
}