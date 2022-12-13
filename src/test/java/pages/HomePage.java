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
    public WebElement headerParallax;

    @FindBy(xpath = "//a[text()='Read More']")
    public WebElement moreButton;

    @FindBy(xpath = "//div[@class='tp-mask-wrap']//div[@class='text'][1]")
    public WebElement description;

    @FindBy(xpath = "//h2[text()='Words from our Clients']")
    public WebElement headerTxt;

    @FindBy(xpath = "//div[@class='owl-item']//div[contains(text(), 'These guys')]")
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

    @FindBy(xpath = "//div[@class='flex-box']//div[@class='inner-box']")
    public List<WebElement> item;


    @FindBy(xpath = "//div[@class='owl-item']//div[contains(text(), 'ever since')]")
    public List<WebElement> testimonials;

    @FindBy(xpath = "//div[@class='owl-item']//div[@class='thumb-content']")
    public List<WebElement> nameAndCity;



}