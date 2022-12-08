package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }
    @FindBy(xpath = "//i[contains(text(), '10090 Main Street')]")
    public WebElement streetAddress;

    @FindBy(xpath = "//strong[contains(text(), 'Fairfax, VA, USA')]")
    public WebElement townAndState;

    @FindBy(xpath = "//strong[contains(text(), '+1 703-831-3217')]")
    public WebElement phoneNumber;


    @FindBy (xpath = "//div[@class= 'top-right flex-box-three']")
    public WebElement navBtn;

    @FindBy (xpath = "//title" )
    public WebElement titleHomepage;


}
