package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "Features/Assignment.feature",
        tags = "@TestScenario1 or @TestScenario2",
        glue = "stepDefinitions",
        plugin = {"pretty","html:target/cucumber-reports/WikiPage/cucumber-pretty.html"}
)
public class TestRunner {
}
