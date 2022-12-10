package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
public class Social_Media_page
{
    public Social_Media_page()
    {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='https://facebook.com']")
    public WebElement faceBookBtn;

    @FindBy(xpath = "//a[@href='https://twitter.com']")
    public WebElement twitterBtn;

    @FindBy(xpath = "//a[@href='https://google.com']")
    public WebElement googleBtn;

    @FindBy(xpath = "//a[@href='https://linkedin.com']")
    public WebElement linkedInBtn;
}
