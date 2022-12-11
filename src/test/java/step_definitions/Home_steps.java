package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;

import java.util.List;

public class Home_steps implements CommonPage {

    @Given("Navigate to Home page")
    public void navigate_to_home_page() {
        BrowserUtils.getDriver();
    }

    HomePage page;

    public Home_steps() {
        this.page = new HomePage();
    }

    @Then("verify 10090 Main Street is displayed")
    public void verify_10090_Main_Street_is_displayed() {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.streetAddress), "10090 Main Street");
    }

    @And("Verify Fairfax, VA, USA is displayed")
    public void Verify_Fairfax_VA_USA_is_displayed() {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.townAndState), "Fairfax, VA, USA");
    }

    @And("Verify Phone: {string} is displayed")
    public void verifyPhoneIsDisplayed(String phone) {
        BrowserUtils.assertEquals(BrowserUtils.getText(page.phoneNumber), "+1 703-831-3217");
    }

    @Then("Verify button {string} is displayed")
    public void verifyButtonIsDisplayed(String button) {
        BrowserUtils.assertEquals(page.navBtn.getText(), button);
        //BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT_CONTAINS, button))));
    }

    @Then("Verify Title of the homepage should be {string}")
    public void verifyTitleOfTheHomepageShouldBe(String titletext) {
        //BrowserUtils.assertEquals(page.titleHomepage.getText(),titletext);
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), titletext);

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

    @Then("Verify header {string} is Displayed")
    public void verifyHeaderIsDisplayed(String headerTxt) {
        BrowserUtils.assertEquals(page.headerTxt.getText(), headerTxt);
    }

    @Then("Verify testimonials, person's name and city are displayed")
    public void verifyTestimonialsPersonSNameAndCityAreDisplayed() {
        List<WebElement> testimonials = page.testMsg;
        for (WebElement each : testimonials) {
            BrowserUtils.isDisplayed(each);
            System.out.println(page.activeMsg.getText());
        }
    }

    @Then("Verify  {string} buttons are displayed")
    public void verifyButtonsAreDisplayed(String mediaBtn) {

        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_CONTAINS_CLASS, mediaBtn))));
    }

    @Then("Verify button {string} is clickable")
    public void verify_button_is_clickable(String btn) {
        switch (btn.toLowerCase()) {
            case "facebook":
                BrowserUtils.click(page.faceBookBtn);
                break;
            case "twitter":
                BrowserUtils.click(page.twitterBtn);
                break;
            case "instagram":
                BrowserUtils.click(page.instagramBtn);
                break;
            case "linkedin":
                BrowserUtils.click(page.linkedInBtn);
                break;
            default:
                BrowserUtils.click(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_BUTTON))));
        }
    }

    @Then("Verify main navigation bar")
    public void verifyMainNavigationBar() {
    }

    @And("Verify secondary Navigation bar is visible after scroll")
    public void verifyButtonBarIsVisibleAfterScroll() {
    }

    @And("Verify button {string} take the user to corresponding page when click")
    public void verifyButtonTakeTheUserToCorrespondingPageWhenClick(String arg0) {
    }

    @Then("Verify {string} button above the main content of the home page")
    public void verifyButtonAboveTheMainContentOfTheHomePage(String btn) {
        BrowserUtils.click(page.joinNowBtn);
    }

    @And("Verify button should take the user to {string} page")
    public void verifyButtonShouldTakeTheUserToPage(String joinUsTxt) throws InterruptedException {
        BrowserUtils.waitForElementVisibility(page.joinUsTxt);
        BrowserUtils.assertEquals(BrowserUtils.getText(page.joinUsTxt), "Join Us");
    }

    @Then("Verify Company  names are  display in one row")
    public void verifyCompanyNamesAreDisplayInOneRow() {
        BrowserUtils.isDisplayed(page.listOfCompany);
    }

    @Then("Verify {string} is displayed")
    public void verifyIsDisplayed(String info) {

        BrowserUtils.assertTrue(page.footerInfo1.getText().contains(info));

    }
}

