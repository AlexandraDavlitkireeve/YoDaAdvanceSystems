package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.BrowserUtils;
import utils.CucumberLogUtils;
import utils.Screenshot;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        //BrowserUtils.getDriver();
        CucumberLogUtils.initScenario(scenario);

    }

    @After
    public void tearDown(Scenario scenario) {
        if (BrowserUtils.checkDriverStatus() != null) {

            if (scenario.isFailed()) {

                CucumberLogUtils.logFail("Scenario failed", true);
            } else {
                CucumberLogUtils.logPass("Scenario passed", true);

            }
        }
        BrowserUtils.quitDriver();
    }

}
