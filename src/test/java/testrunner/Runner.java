package testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import static io.cucumber.testng.CucumberOptions.*;

@CucumberOptions(features = {"src/test/java/features"}, dryRun = !true, glue = "steps", monochrome = true,
        snippets = SnippetType.CAMELCASE)

public class Runner extends AbstractTestNGCucumberTests {

}
