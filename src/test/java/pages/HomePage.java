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


    @FindBy(xpath = "//h2[@class='white-heading']")
    public WebElement headerParallax ;

    @FindBy(xpath = "//a[text()='Read More']")
    public WebElement moreButton;

    @FindBy(xpath = "//div[@class='tp-mask-wrap']//div[@class='text'][1]")
    public WebElement description;

    // TODO @ASY-8
    @FindBy(xpath = "//a[@href='https://facebook.com']")
    public WebElement faceBookBtn;

    @FindBy(xpath = "//a[@href='https://twitter.com']")
    public WebElement twitterBtn;

    @FindBy(xpath = "//a[@href='https://instagram.com']")
    public WebElement instagramBtn;

    @FindBy(xpath = "//a[@href='https://linkedin.com']")
    public WebElement linkedInBtn;

    // TODO @ASY-9
    @FindBy(xpath = "")
    public WebElement mainBar;




    // TODO @ASY-10
    @FindBy(xpath = "//a[text()='Join Now']")
    public WebElement joinNowBtn;

    @FindBy(xpath = "//div/h1[text()='Join Us']")
    public WebElement joinUsTxt;

    // TODO @ASY-11



}
