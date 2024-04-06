package definitions;

import cucumber.api.java.en.Given;

import static support.TestContext.getDriver;

public class JavaExperimentsSteps {
    @Given("we test our web application")
    public void weTestOurWebApplication() {
        getDriver().get("https://google.com");
    }
}
