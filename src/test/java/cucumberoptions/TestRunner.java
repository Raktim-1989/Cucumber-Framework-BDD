package cucumberoptions;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
glue = "stepdefinitions",
format = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
		"json:target/cucumber-reports/CucumberTestReport.json",
		"rerun:target/cucumber-reports/rerun.txt"},
plugin = "json:target/cucumber-reports/CucumberTestReport.json"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
