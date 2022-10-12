package runner;


import base.TestBase;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = {"steps"},
        monochrome = true)

public class CucumberRunner extends TestBase {

    @AfterClass
    public static void writeExtentReport() {
        driver.close();
    }
}
