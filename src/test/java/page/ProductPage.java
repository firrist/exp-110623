package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductPage {

    private final WebDriver driver;

    @FindBy(xpath = "//header//h1")
    private WebElement productHeader;

    @FindBy(xpath = "//*[@id='site-header-cart']")
    private WebElement cart;

    @FindBy(xpath = "//div[@data-title='Contact Us']")
    private WebElement contactButton;

    @FindBy(xpath = "//*[@class='swiper swiper-cube swiper-3d swiper-initialized swiper-horizontal swiper-pointer-events']")
    private WebElement imageSlider;

    public ProductPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public String getProductTitle() {
        return productHeader.getText();
    }

    public ContactDialog clickOnContactButton() {
        contactButton.click();
        return new ContactDialog(driver);
    }

    public ProductPage verifyCartDisplayed() {
        cart.isDisplayed();
        return this;
    }

    public ProductPage verifyImageSliderDisplayed() {
        imageSlider.isDisplayed();
        return this;
    }

    public ProductPage verifyProductHeader(String header) {
        assertThat(getProductTitle()).isEqualToIgnoringCase(header);
        return this;
    }

    public String getWebPageTitle() {
        return driver.getTitle();
    }

    public ProductPage verifyWebPageTitle(String title) {
        assertThat(getWebPageTitle()).containsIgnoringCase(title);
        return this;
    }
}
