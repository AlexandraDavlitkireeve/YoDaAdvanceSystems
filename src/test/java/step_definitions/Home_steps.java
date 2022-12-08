package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.HomePage;
import utils.BrowserUtils;

public class Home_steps {
    @Given("Navigate to Home page")
    public void navigate_to_home_page() {
        BrowserUtils.getDriver();
    }
    HomePage page;
    public Home_steps()
    {
        this.page = new HomePage();
    }

    @Then("verify 10090 Main Street is displayed")
    public void verify_10090_Main_Street_is_displayed()
    {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.streetAddress), "10090 Main Street");
    }
    @And("Verify Fairfax, VA, USA is displayed")
    public void Verify_Fairfax_VA_USA_is_displayed()
    {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.townAndState), "Fairfax, VA, USA");
    }
//    @And("Verify Phone 703-831-3217 is displayed")
//    public void Verify_Phone_703_831_3217_is_displayed()
//    {
//        BrowserUtils.assertEquals(BrowserUtils.getText(page.phoneNumber), "+1 703-831-3217");
//    }


    @And("Verify Phone: {string} is displayed")
    public void verifyPhoneIsDisplayed(String phone) {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.phoneNumber), "+1 703-831-3217");
    }
}