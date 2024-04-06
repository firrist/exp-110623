package definitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LandingPageJava {
    @Then("I verify page title is {string}")
    public void iVerifyPageTitleIs(String title) {
        String windowTitle = getDriver().getTitle();
        assertThat(windowTitle).isEqualTo(title);
    }

   @Then("I verify product category {string} is displayed")
    public void iVerifyProductCategory(String category) {
        String xpath = "//ul[@id='menu-main']//a[contains(text(),'" + category + "')]";
        getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }

    @Then("I verify cart icon is displayed")
    public void iVerifyCartIconIsDisplayed() {
        String xpath = "//ul[@id='site-header-cart']//span[@class='count']";
        getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }

    @Then("I verify image slider is displayed")
    public void iVerifyImageSliderIsDisplayed() {
        String xpath = "//div[@class='swiper-wrapper']";
        getDriver().findElement(By.xpath(xpath)).isDisplayed();
    }
}
