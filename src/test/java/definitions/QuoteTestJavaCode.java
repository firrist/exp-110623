package definitions;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteTestJavaCode {
    @Given("I visit Quote Page in the {string} environment v1")
    public void iVisitQuotePageInTheStageEnvironment(String environment) throws InterruptedException {
        if (environment.equals("Stage")) {
            getDriver().get("https://quote-stage.portnov.com/");
        } else {
             throw new IllegalArgumentException("unknown environment: " + environment);
        }
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("tkan");
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Tatyana");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Kan");
        getDriver().findElement(By.xpath("//button[@type='button']//span[contains(text(),'Save')]")).click();
        getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys("tkan@gmail.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("12345abcd");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("12345abcd");
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
       // Thread.sleep(2_000);

        // getDriver().wait(2_000);

        String applicationResultTitle = getDriver().findElement(By.xpath("//legend[@class='applicationResult']")).getText();
        System.out.println(applicationResultTitle);
        assertThat(applicationResultTitle).isEqualTo("Submitted Application");
    }
}
