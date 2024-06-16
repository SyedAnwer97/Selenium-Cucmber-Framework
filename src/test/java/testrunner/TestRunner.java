package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = {"src/test/java/features/"},
        dryRun = !true,
        glue = {"steps","hooks"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty",
                "html:cucumber-reports/report.html",
                "json:cucumber-reports/report.json",
                "junit:cucumber-reports/report.xml"},
        tags = "(@smoke) or (@reg) and (@dev) or (@test)"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}