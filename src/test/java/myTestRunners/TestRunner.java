package myTestRunners;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue= {"myStepDefinitions" , "myHooks"},
        plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "timeline:test-output-thread/",
                "rerun:src/test/resources/failedrerun.txt"},
        monochrome = true,
        publish = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
