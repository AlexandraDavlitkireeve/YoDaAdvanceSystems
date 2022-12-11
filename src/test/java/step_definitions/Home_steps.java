package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

import javax.sound.sampled.Line;
import java.util.List;

public class Home_steps implements CommonPage
{
    // TODO @ASY-1
    @Given("Navigate to Home page")
    public void navigate_to_home_page() {
        BrowserUtils.getDriver();
    }
    HomePage page;
    public Home_steps()
    {
        this.page = new HomePage();
    }

    // TODO @ASY-3 @smoke
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
    @And("Verify Phone: {string} is displayed")
    public void verifyPhoneIsDisplayed(String phone)
    {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.phoneNumber), "+1 703-831-3217");
    }

    @Then("Verify button {string} is displayed")
    public void verifyButtonIsDisplayed(String button) {
        BrowserUtils.isDisplayed(page.navBtn);
    }

    @Then("Verify Title of the homepage should be {string}")
    public void verifyTitleOfTheHomepageShouldBe(String titletext) {
        BrowserUtils.assertEquals("Advance Systems - Home", titletext);

    }

    @Then("header is displayed")
    public void headerIsDisplayed() {
        BrowserUtils.isDisplayed(page.headerParallax);
    }

    @And("verify description is displayed")
    public void verifyDescriptionIsDisplayed() {
        BrowserUtils.isDisplayed(page.description);
    }

    @And("verify read more button is displayed")
    public void verifyReadMoreButtonIsDisplayed() {
        BrowserUtils.isDisplayed(page.moreButton);
    }






    // TODO @ASY-8 @smoke
    @Then("Verify button {string} is clickable")
    public void verify_button_is_clickable(String btn) {
        switch (btn.toLowerCase()) {
            case "facebook":
                BrowserUtils.click(page.faceBookBtn);
                break;
            case "twitter":
                BrowserUtils.click(page.twitterBtn);
                break;
            case "google":
                BrowserUtils.click(page.googleBtn);
                break;
            case "linkedin":
                BrowserUtils.click(page.linkedInBtn);
                break;
            default:
                BrowserUtils.click(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_BUTTON))));
        }
    }

    // TODO @ASY-9






    // TODO @ASY-10

    @Then("Verify {string} button above the main content of the home page")
    public void verifyButtonAboveTheMainContentOfTheHomePage(String btn)
    {
        BrowserUtils.click(page.joinNowBtn);
    }
    @And("Verify button should take the user to {string} page")
    public void verifyButtonShouldTakeTheUserToPage(String joinUsTxt) throws InterruptedException {
        BrowserUtils.waitForElementVisibility(page.joinUsTxt);
        Thread.sleep(2000);
        BrowserUtils.assertEquals(BrowserUtils.getText(page.joinUsTxt), "Join Us");
    }


    @Then("Then Verify {string} is displayed")
    public void thenVerifyButtonIsDisplayed(String info) {
        List<WebElement> contactInfo = page.footerInfo;
        for (WebElement each : contactInfo) {
            System.out.println(each.getText());
            //BrowserUtils.assertEquals(each.getText(), info);
            System.out.println(info+"expected");
        }


    }


    // TODO @ASY-11

}
