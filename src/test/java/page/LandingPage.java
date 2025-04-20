package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {

    private final WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductPage clickOnCategory(String categoryName) {
        String xpath = "//ul[@id='menu-main']//a[text()='" + categoryName + "']";
        WebElement category = driver.findElement(By.xpath(xpath));
        WaitForElement(category);
        category.click();
        return new ProductPage(driver);
    }
    public String getWebPageTitle() {
        return driver.getTitle();
    }

    private void WaitForElement(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
}
