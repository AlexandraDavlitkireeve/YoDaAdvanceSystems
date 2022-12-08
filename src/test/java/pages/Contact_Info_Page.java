package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class Contact_Info_Page
{
    public Contact_Info_Page()
    {

        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }
    @FindBy(xpath = "//div[@class='info-box-one']/ul/li/i)[1]")
    public WebElement streetAddress;

    @FindBy(xpath = "//div[@class='info-box-one']/ul/li)[2]/strong")
    public WebElement townAndState;

    @FindBy(xpath = "//div[@class='info-box-one']/ul/li)[4]/strong")
    public WebElement phoneNumber;
}
