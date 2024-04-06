package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
/*
public class ArslanQuoteAppDef {
    @Given("I visit Quote Page in the {string} environment")
    public void iVisitQuotePageInTheEnvironment(String environment) {
        String url;
        System.out.println(environment.equals("Stage"));
        if(environment.equals("Stage")){
            url= "https://quote-stage.portnov.com/";
            getDriver().get(url);
        }
        else if (environment.equals("QA"))
        {
            System.out.println();
            url = "https://quote-qa.portnov.com/";
            getDriver().get(url);
        }else{
            url ="https://quote-stage.portnov.com/";
            getDriver().get(url);
        }
    }
    @When("I enter {string} for the Username Field")
    public void iEnterForTheUsernameField(String userName) {
        if(!userName.isEmpty()){
            getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
        }
    }
    @And("I enter {string} for the first name and {string} for the last name in the Name field")
    public void iEnterForTheFirstNameAndForTheLastNameInTheNameField(String firstName, String lastName) {
        getDriver().findElement(By.xpath("//input[@name='name']")).click();
        if(getDriver().findElement(By.xpath("//div[@aria-describedby='nameDialog']")).isDisplayed()){
            getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
            getDriver().findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
            getDriver().findElement(By.xpath("//button/span[contains(text(),'Save')]")).click();
        }else {
            System.out.println("Could not find element");
        }
    }
    @And("I enter {string} for the Email field")
    public void iEnterForTheEmailField(String email) {
        getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys(email);
    }
    @When("I enter {string} for the Password field")
    public void iEnterForThePasswordField(String password) {
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(password);
    }
    @And("I enter {string} for the Confirm Password field")
    public void iEnterForTheConfirmPasswordField(String confirmPassword) {
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(confirmPassword);
    }
    @Then("I {string} the Privacy Policy Checkbox")
    public void iThePrivacyPolicyCheckbox(String checkBox) {
        if(checkBox.equals("check"))
            getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        else
            System.out.println("Do nothing");
    }
    @When("I click on the {string} button at the bottom of the Page")
    public void iClickOnTheButtonAtTheBottomOfThePage(String xPath) {
        if(xPath.equals("")){
            getDriver().findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        }else {
            getDriver().findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        }
    }
    @Then("I verify we see the Submitted Application Page")
    public void iVerifyWeSeeTheSubmittedApplicationPage() throws InterruptedException {
        String verifyPage = getDriver().findElement(By.xpath("//legend[contains(text(),'Submitted Application')]")).getText();
        Thread.sleep(30);
        assertThat(verifyPage).contains("Submitted Application");
    }
}
*/