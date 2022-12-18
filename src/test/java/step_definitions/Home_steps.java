package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.HomePage;
import utils.BrowserUtils;
import utils.Screenshot;

import java.util.*;

public class Home_steps implements CommonPage {

    @Given("Navigate to Home page")
    public void navigate_to_home_page() {
        BrowserUtils.getDriver();
    }

    HomePage page;

    public Home_steps() {
        this.page = new HomePage();
    }

    @Then("Verify {string} on main page")
    public void verifyOnMainPage(String info) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver()
                .findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT, info))));

    }

    @Then("Verify button {string} is displayed")
    public void verifyButtonIsDisplayed(String button) {

        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT_CONTAINS, button))));
    }

    @Then("Verify Title of the homepage should be {string}")
    public void verifyTitleOfTheHomepageShouldBe(String titletext) {
        //BrowserUtils.assertEquals(page.titleHomepage.getText(),titletext);
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), titletext);

    }

    @Then("header is displayed")
    public void headerIsDisplayed() {
        BrowserUtils.isDisplayed(page.firstHeaderParallax);
    }

    @And("verify description is displayed")
    public void verifyDescriptionIsDisplayed() {
        BrowserUtils.isDisplayed(page.description);
    }

    @And("verify read more button is displayed")
    public void verifyReadMoreButtonIsDisplayed() {
        BrowserUtils.isDisplayed(page.readMoreBtn);
    }

    @And("verify header of the page {string}")
    public void verifyHeaderOfThePage(String title) {
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), title);
    }

    @Then("Verify header {string} is Displayed")
    public void verifyHeaderIsDisplayed(String headerTxt) {
        BrowserUtils.assertEquals(page.headerTxt.getText(), headerTxt);
    }

    @Then("Verify testimonials, person's name and city are displayed")
    public void verifyTestimonialsPersonSNameAndCityAreDisplayed() {
//        List<WebElement> testimonials = page.testMsg;
//        for (WebElement each : testimonials) {
//            BrowserUtils.isDisplayed(each);
//            System.out.println(page.activeMsg.getText());
//        }

        List<WebElement> nameAndCity = page.nameAndCity;
        List<WebElement> blockTxt = page.blockTxt;
        Map<WebElement, WebElement> map = new HashMap<>();
//        for (WebElement each : nameAndCity) {
//            for (WebElement eachTxt : blockTxt) {
//                BrowserUtils.waitUntil(page.activeNameCity);
//                BrowserUtils.waitUntil(page.activeMsg);
        //map.put(nameAndCity.get(each), map.get(eachTxt));
//                BrowserUtils.isDisplayed(each);
//                BrowserUtils.isDisplayed(eachTxt);
//                System.out.println(each.getText());
//                System.out.println(eachTxt.getText());
//            }
//        }

        for (int i = 0; i <= nameAndCity.size() - 1; i++) {
            for (int j = 0; j <= blockTxt.size() - 1; i++) {

                //BrowserUtils.waitUntil(page.activeNameCity);
//                BrowserUtils.isDisplayed(nameAndCity.get(i));
//                BrowserUtils.isDisplayed(blockTxt.get(j));
                if (!(BrowserUtils.isDisplayed(nameAndCity.get(i)))) {
                    if (!(BrowserUtils.isEnabled(blockTxt.get(j))))
                        System.out.println(page.activeNameCity);
                    System.out.println(page.activeMsg.getText());
                    map.put(nameAndCity.get(i), blockTxt.get(j));
//                System.out.println(nameAndCity.get(i).getText());
//                System.out.println(blockTxt.get(j).getText());
                }
            }
        }

//        for (int i = 0; i < nameAndCity.size(); i++) {
//            for (int j = 0; j < blockTxt.size(); i++) {
//                map.put(nameAndCity.get(i), blockTxt.get(j));
//                BrowserUtils.isElementDisplayed(nameAndCity.get(i));
//                BrowserUtils.isElementDisplayed(blockTxt.get(j));
//                System.out.println(nameAndCity.get(i).getText());
//                System.out.println(blockTxt.get(j).getText());
//            }
//        }

    }

    @Then("Verify  {string} buttons are displayed")
    public void verifyButtonsAreDisplayed(String mediaBtn) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_CONTAINS_CLASS, mediaBtn))));
    }

    @Then("Verify button {string} is clickable")
    public void verify_button_is_clickable(String btn) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT2, btn))));
        BrowserUtils.click(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT2, btn))));
        BrowserUtils.assertTrue(BrowserUtils.getDriver().getTitle().toLowerCase().contains(btn));
    }

    @And("Verify page {string} navigate to website")
    public void verifyPageNavigateToWebsite(String btn)
    {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_BUTTON, btn).toLowerCase())));
    }

    @Then("Verify main navigation bar")
    public void verifyMainNavigationBar() {
        BrowserUtils.isDisplayed(page.mainBar);
    }

    @Then("Verify each button click after scroll {string}")
    public void iClickNavigationBar(String navButton) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserUtils.getDriver();
        js.executeScript("window.scrollBy(0, 5000)"); //Scroll vertically down by 1000 pixels

        BrowserUtils.click(
                BrowserUtils.getDriver().findElement(
                        By.xpath(String.format(XPATH_TEMPLATE_TEXT2_CONTAINS, navButton)
                        )));
    }

    @Then("Verify page navigation bar has correct title {string}")
    public void verifyPageNavigationBarHasUrl(String titleText) {
        BrowserUtils.switchToNewWindow();
        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), titleText);
    }

    @Then("Verify {string} button above the main content of the home page")
    public void verifyButtonAboveTheMainContentOfTheHomePage(String btn) {
        BrowserUtils.click(page.joinNowBtn);
    }

    @And("Verify button should take the user to {string} page")
    public void verifyButtonShouldTakeTheUserToPage(String joinUsTxt) {
        BrowserUtils.waitForElementVisibility(page.joinUsTxt);
        BrowserUtils.assertEquals(BrowserUtils.getText(page.joinUsTxt), "Join Us");
    }

    @Then("Verify Company  names are  display in one row")
    public void verifyCompanyNamesAreDisplayInOneRow() {
        BrowserUtils.isDisplayed(page.listOfCompany);
    }

    @Then("Verify {string} is displayed")
    public void verifyIsDisplayed(String info) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver()
                .findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT_CONTAINS, info))));
    }

    @And("Verify links {string} are displayed")
    public void verifyLinksAreDisplayed(String footerLink) {
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_FOOTER_LINKS, footerLink))));

    }

    @And("Verify links {string} are clickable")
    public void verifyLinksAreClickable(String footerLink) {
        BrowserUtils.click(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_FOOTER_LINKS, footerLink))));
    }

    @And("Verify links {string} are opening corresponding page")
    public void verifyLinksAreOpeningCorrespondingPage(String footerLink) {
        BrowserUtils.assertTrue(BrowserUtils.getDriver().getTitle().contains(footerLink));
    }

    @Then("Verify {string} selection")
    public void verifySelection(String language) {
        BrowserUtils.click(page.languageSelection);
        BrowserUtils.isDisplayed(BrowserUtils.getDriver().findElement(By.xpath(String.format(XPATH_TEMPLATE_TEXT_CONTAINS, language))));
    }

    @Then("Verify items are displayed as a header and description under it")
    public void verifyAreDisplayedAsAHeaderAndDescriptionUnderIt() {
        List<WebElement> section = page.item;
        for (WebElement each : section) {
            BrowserUtils.isDisplayed(each);
            System.out.println(each.getText());
        }
    }

    @And("verify user waits {int} milliSeconds")
    public void verifyUserWaitsSeconts(int milliSeconds) throws InterruptedException {
        Thread.sleep(milliSeconds);
        BrowserUtils.waitForElementVisibility(page.description);
    }

    @And("verify second description is displayed")
    public void verifySecondDescriptionIsDisplayed() {

        BrowserUtils.isDisplayed(page.secondDescription);

    }

    @And("verify second header is displayed")
    public void verifySecondHeaderIsDisplayed() {
        BrowserUtils.waitUntil(page.secondHeader);
        BrowserUtils.isDisplayed(page.secondHeader);
    }

    @And("verify second read more button is displayed")
    public void verifySecondReadMoreButtonIsDisplayed() {
        BrowserUtils.isDisplayed(page.secondMoreButton);
    }

}

