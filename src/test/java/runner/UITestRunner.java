package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features="src/test/resources/uiFeatures",
        glue="uiAutomation",
        dryRun = false,
        tags="@profileDropdownValidation",
        plugin = {"html:target/cucumber-html-report",
                "json:target/cucumber.json"},
        monochrome = true
)
public class UITestRunner {
}
