package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactDialog {

    private WebDriver driver;

    public ContactDialog(WebDriver driver) {
        this.driver = driver;
    }

    public ContactDialog typeName(String name) {
        WebElement xpath = driver.findElement(By.xpath("//input[@name='name']"));
        WaitForElement(xpath);
        xpath.sendKeys(name);
        return this;
    }

    public ContactDialog typeEmail(String name) {
        WebElement xpath = driver.findElement(By.xpath("//input[@name='email']"));
        WaitForElement(xpath);
        xpath.sendKeys(name);
        return this;
    }

    public ContactDialog typeMessage(String name) {
        WebElement xpath = driver.findElement(By.xpath("//textarea[@id='chaty-name']"));
        WaitForElement(xpath);
        xpath.sendKeys(name);
        return this;
    }

    public ContactDialog clickSend() throws Exception {
        driver.findElement(By.xpath("//button[contains(text(), 'Send')]")).click();
        iWaitForSec(2);
        return this;
    }

    public ContactDialog verifyMessageWasSent() {
        WebElement confirmation = driver.findElement(By.xpath("//div[@class='chaty-ajax-success-message']"));
        assertThat(confirmation.getText()).isEqualTo("Your message was sent successfully");
        return this;
    }

    private void WaitForElement(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

    private void iWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 1000);
    }
}
