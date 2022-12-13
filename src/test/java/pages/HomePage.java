package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class HomePage {
    public HomePage() {
        PageFactory.initElements(BrowserUtils.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@class='white-heading']")
    public WebElement firstHeaderParallax;

    @FindBy(xpath = "//a[contains(text(), 'Read More')]")
    public WebElement readMoreBtn;

    @FindBy(xpath = "//div[contains(@data-x,'right')]//a[text()='Read More']")
    public WebElement secondMoreButton;

    @FindBy(xpath = "//div[@class='tp-mask-wrap']//div[@class='text'][1]")
    public WebElement description;

    @FindBy(xpath = "//div[@class='tp-caption']//div[contains(text(), 'Lorem')]")
    public WebElement secondDescription;

    @FindBy(xpath = "//h2[text()='Words from our Clients']")
    public WebElement headerTxt;

    @FindBy(xpath = "//div[@class='owl-item']//div[contains(text(), 'Lorem')]")
    public List<WebElement> testMsg;

    @FindBy(xpath = "//div[@class='testimonial-outer']")
    public WebElement activeMsg;

    @FindBy(xpath = "//div[@class='header-lower']")
    public WebElement mainBar;

    @FindBy(xpath = "//a[text()='Join Now']")
    public WebElement joinNowBtn;

    @FindBy(xpath = "//div/h1[text()='Join Us']")
    public WebElement joinUsTxt;

    @FindBy(xpath = "//div[contains(@class, 'six-item-carousel')]")
    public WebElement listOfCompany;

    @FindBy(xpath = "//ul[@class='list-info']")
    public WebElement footerInfo1;

    @FindBy(xpath = "//span[@class='icon']")
    public WebElement languageSelection;

    @FindBy(xpath = "//h2[contains(text(), 'Think Big')]")
    public WebElement secondHeader;

    @FindBy(xpath = "//div[@class='flex-box']//div[@class='inner-box']")
    public List<WebElement> item;

}