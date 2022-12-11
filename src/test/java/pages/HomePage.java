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
    @FindBy(xpath = "//i[contains(text(), '10090 Main Street')]")
    public WebElement streetAddress;

    @FindBy(xpath = "//strong[contains(text(), 'Fairfax, VA, USA')]")
    public WebElement townAndState;

    @FindBy(xpath = "//strong[contains(text(), '+1 703-831-3217')]")
    public WebElement phoneNumber;


    @FindBy (xpath = "//div[@class= 'top-right flex-box-three']")
    public WebElement navBtn;

//    @FindBy (xpath = "//*[contains(text(), 'Advance Systems - Home')]" )
//    public WebElement titleHomepage;

    @FindBy(xpath = "//h2[@class='white-heading']")
    public WebElement headerParallax ;

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

    @FindBy(xpath = "//div[@class='thumb-item']")
    public WebElement eachPerson;

    @FindBy(xpath = "//div[@class='designation']")
    public WebElement city;

    @FindBy(xpath = "//ul[@class='social-icon-six']/li")
    public WebElement mediaBtn;

    @FindBy(xpath = "//div[@class='owl-next']")
    public WebElement nextBtn;
    @FindBy(xpath = "//div[@class='header-lower']")
    public WebElement mainBar;

    @FindBy(xpath = "//div[@class='sticky-header']")
    public WebElement secondBar;

    @FindBy(xpath = "//div[@class='right-col pull-right']//ul[@class='navigation clearfix']//li")
    public WebElement navBar;

//    @FindBy(xpath = "(//div[@class='navbar-collapse collapse clearfix']/ul/li)[1]/a")
//    public WebElement homeBtn;
//
//    @FindBy(xpath = "(//div[@class='navbar-collapse collapse clearfix']/ul/li)[2]/a")
//    public WebElement aboutUsBtn;
//
//    @FindBy(xpath = "(//div[@class='navbar-collapse collapse clearfix']/ul/li)[3]/a")
//    public WebElement servicesBtn;
//
//    @FindBy(xpath = "")
//    public WebElement clientsBtn;
//
//    @FindBy(xpath = "")
//    public WebElement joinUsBtn;

    @FindBy(xpath = "")
    public WebElement contactUsBtn;

    @FindBy(xpath = "//a[text()='Join Now']")
    public WebElement joinNowBtn;

    @FindBy(xpath = "//div/h1[text()='Join Us']")
    public WebElement joinUsTxt;

    @FindBy(xpath = "//div[contains(@class, 'six-item-carousel')]" )
    public WebElement listOfCompany;

    @FindBy(xpath = "//ul[@class='list-info']")
    public WebElement footerInfo1;

}
