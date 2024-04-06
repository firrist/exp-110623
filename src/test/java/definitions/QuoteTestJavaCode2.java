package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteTestJavaCode2 {
    @Given("I visit Quote Page in the {string} Environment")
    public void iVisitQuotePageInTheEnvironment(String environment) {
        if (environment.equals("Stage")) {
            getDriver().get("https://quote-stage.portnov.com/");
        }
    }

    @When("I enter {string} for the Username field")
    public void iEnterForTheUsernameField(String username) {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(username);
    }

    @And("I enter {string} for first name and {string} for the last name in the Name field")
    public void iEnterForFirstNameAndForTheLastNameInTheNameField(String firstName, String lastName) {
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
        getDriver().findElement(By.xpath("//button[@type='button']//span[contains(text(),'Save')]")).click();
    }

    @And("I enter {string} for the Email field")
    public void iEnterForTheEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys(email);

    }

    @When("I enter {string} for the Password field")
    public void iEnterForThePasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("I enter {string} for the Confirm Password field")
    public void iEnterForTheConfirmPasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(password);
    }

    @Then("I {string} the Privacy Policy Policy checkbox")
    public void iThePrivacyPolicyPolicyCheckbox(String action) {
        if (action.equals("check")) {
            getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        }
    }

    @When("I click on the {string} button at the bottom of the page")
    public void iClickOnTheButtonAtTheBottomOfThePage(String buttonName) {
        if (buttonName.equals("Submit")) {
            getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
        }
    }

    @Then("I verify username is {string}, first name is {string}, last name is {string}, email is {string}, and password is {string}")
    public void iVerifyUsernameIsFirstNameIsLastNameIsEmailIsAndPasswordIs(String username, String firstName, String lastName, String email, String password) {
        String actualUsername = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        assertThat(actualUsername).isEqualTo(username);
        String actualFirstName = getDriver().findElement(By.xpath("//b[@name='firstName']")).getText();
        assertThat(actualFirstName).isEqualTo(firstName);
        String actualLastName = getDriver().findElement(By.xpath("//b[@name='lastName']")).getText();
        assertThat(actualLastName).isEqualTo(lastName);
        String actualEmail = getDriver().findElement(By.xpath("//b[@name='email']")).getText();
        assertThat(actualEmail).isEqualTo(email);
        String actualPassword = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(actualPassword).isEqualTo("[entered]");
    }
}
