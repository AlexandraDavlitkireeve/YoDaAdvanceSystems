package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.CommonPage;
import pages.Social_Media_page;
import utils.BrowserUtils;

public class Social_Media_steps implements CommonPage
{
    Social_Media_page page;
    public Social_Media_steps()
    {
        page = new Social_Media_page();
    }

    @Then("Verify button {string} is clickable")
    public void verify_button_is_clickable(String btn)
    {
        switch (btn.toLowerCase())
        {
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


}
