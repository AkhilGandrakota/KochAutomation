import Utils.DriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * This is the runner class which runs with cucumber options and runs tests for every scenario
 *
 * @author gandrakotaakhil@gmail.com
 */
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefs"}, monochrome = true,
        format = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json"},
        plugin = ("json:target/cucumber-reports/CucumberTestReport.json")
)
public class Runner extends AbstractTestNGCucumberTests {
    /**
     * This method sets up the driver instance
     */
    @BeforeSuite(alwaysRun = true)
    public void setupClass() {
        DriverManager.setDriver(SetupClass.createDriver());
    }

    /**
     * This method terminates the driver instance
     */
    @AfterSuite
    public void tearDownClass() {
        DriverManager.getDriver().quit();
    }
}
