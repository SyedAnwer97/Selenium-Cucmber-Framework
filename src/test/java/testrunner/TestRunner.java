package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import static io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = {"src/test/java/features/"},
        dryRun = !true,
        glue = {"steps", "hooks"},
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        plugin = {"html:cucumber-reports/report.html",
                "json:cucumber-reports/report.json",
                "junit:cucumber-reports/report.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "(@smoke) or (@reg) and (@dev) or (@test)"

)

public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }


}
