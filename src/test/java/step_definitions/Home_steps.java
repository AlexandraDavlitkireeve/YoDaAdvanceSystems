package step_definitions;

import io.cucumber.java.en.Given;
import utils.BrowserUtils;

public class Home_steps {
    @Given("Navigate to Home page")
    public void navigate_to_home_page() {
        BrowserUtils.getDriver();
    }
}
