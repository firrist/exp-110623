package definitions;

import cucumber.api.java.en.Given;
import org.openqa.selenium.Dimension;

import static support.TestContext.getDriver;

public class JavaExperimentsSteps2 {
    @Given("we test our web application2")
    public void weTestOurWebApplication() throws InterruptedException {
        getDriver().get("https://google.com");
        getDriver().manage().window().setSize(new Dimension(800, 600));
        String windowTitle = getDriver().getTitle();
       // assertThat(windowTitle).isEqualTo("Google");
        System.out.println(windowTitle);
        Thread.sleep(2000);
    }
}
