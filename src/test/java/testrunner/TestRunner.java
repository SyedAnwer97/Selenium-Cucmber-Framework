package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = {"src/test/java/features/"},
        dryRun = !true,
        glue = "steps",
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty",
                "html:cucumber-reports/report.html",
                "json:cucumber-reports/report.json",
                "junit:cucumber-reports/report.xml"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
