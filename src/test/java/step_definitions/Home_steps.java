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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

//    @And("verify header of the page {string}")
//    public void verifyHeaderOfThePage(String title) {
//        BrowserUtils.assertEquals(BrowserUtils.getDriver().getTitle(), title);
//    }

    @Then("Verify header {string} is Displayed")
    public void verifyHeaderIsDisplayed(String headerTxt) {
        BrowserUtils.assertEquals(page.headerTxt.getText(), headerTxt);
    }

    @Then("Verify testimonials, person's name and city are displayed")
    public void verifyTestimonialsPersonSNameAndCityAreDisplayed() throws InterruptedException {

        Map<String, String> map = new LinkedHashMap<>();
        List<String> testimonialNames = new ArrayList<>();
        for (int i = 0; i <=page.nameAndCity.size() ; i++) {


            if (!(testimonialNames.contains(page.activeNameCity.getText()))) {
                testimonialNames.add(page.activeNameCity.getText());
                BrowserUtils.isDisplayed(page.activeNameCity);
                //        map.put(page.activeNameCity.getText(), page.activeMsg.getText());
            }
            else if (testimonialNames.contains(page.activeNameCity.getText())) {
               Thread.sleep(5000);
               BrowserUtils.isDisplayed(page.activeNameCity);
                testimonialNames.add(page.activeNameCity.getText());

            }
            else {
                BrowserUtils.waitFor(5);
            }
        }
        System.out.println(testimonialNames.size());
        for (int i = 0; i <testimonialNames.size() ; i++) {
            System.out.println(testimonialNames.get(i));
        }
//        //    List<WebElement> nameAndCity = page.nameAndCity;
//        List<WebElement> blockTxt = page.blockTxt;
//        Map<String, String> map = new LinkedHashMap<>();
//
//        // Iterator<WebElement> itr = map.keySet().iterator();
//        //   if(!(itr.toString().contains(page.activeNameCity.getText()))){
//        for (int i = 0; i <= page.clonedTestimonials.size(); i++) {
////           if(map.keySet().contains(page.activeNameCity)) {
//
////          for (String key : map.keySet()) {
//            //               if(!(key.contains(page.activeNameCity.getText()))){
//            if ((BrowserUtils.isDisplayed(page.clonedTestimonials.get(i)))) {
//
//                //rowserUtils.isElementDisplayed(page.activeNameCity);
//                System.out.println("========================");
//                System.out.println(page.activeMsg.getText());
//                System.out.println(page.activeNameCity.getText());
//                System.out.println(i);
//                System.out.println("________________");
//                ;
//                //System.out.println(blockTxt.get(i).getText());
//                map.put(page.activeNameCity.getText(), page.activeMsg.getText());
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

        BrowserUtils.assertTrue(page.footerInfo1.getText().contains(info));

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

