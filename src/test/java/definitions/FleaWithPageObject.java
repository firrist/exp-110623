package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.LandingPage;
import page.ProductPage;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class FleaWithPageObject {

    private final LandingPage landingPage = new LandingPage(getDriver());
    private final ProductPage productPage = new ProductPage(getDriver());

    @Given("I visit FLEA Market in the {string} Environment v2")
    public void iVisitFLEAMarketInTheEnvironment(String env) {
        if(env.equalsIgnoreCase("Stage")) {
            getDriver().get("http://store-stage.portnov.com/");
        } else if(env.equalsIgnoreCase("qa")) {
            getDriver().get("http://store-qa.portnov.com/");
        } else {
            System.out.println("BAD URL");
        }
    }
    @Then("I verify title is {string} for the page v2")
    public void iVerifyTitleIsForThePage(String title) {
        assertThat(landingPage.getWebPageTitle()).isEqualTo(title);
    }

    @Then("I verify title of the page contains {string} v2")
    public void iVerifyTitleOfThePageContains(String title) {
        assertThat(landingPage.getWebPageTitle()).containsIgnoringCase(title);
    }

    @When("I wait and click on a product {string} on the Landing Page v2")
    public void iClickOnAProductOnTheLandingPage(String product) {
        String xpath = "//img[@title='"+product +"']";
        WebDriverWait waits = new WebDriverWait(getDriver(), 10);
        waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        getDriver().findElement(By.xpath(xpath)).click();
        iVerifyTitleOfThePageContains(product);
        assertThat(getDriver().findElement(By.xpath("//*[text()='"+product+"']")).getText()).containsIgnoringCase(product);
    }

    @Then("I verify Cart Icon is present v2")
    public void iWaitForCartToAppear() {
        productPage.verifyCartDisplayed();
    }

    @Then("I verify Image Slider is present v2")
    public void iVerifyImageSliderIsPresent() {
        productPage.verifyImageSliderDisplayed();
    }

    public void WaitForElement(WebElement element) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(element));
    }

    @Then("I verify Contact button functionality v2")
    public void iVerifyContactButtonFunctionality() throws Exception {
        productPage.clickOnContactButton()
                .typeName("Tester")
                .typeEmail("test@test.com")
                .typeMessage("Blah Blah Blah")
                .clickSend()
                .verifyMessageWasSent();
    }

    @When("I verify and Click on {string} Category on the Top Bar v2")
    public void iVerifyAndClickOnCategoryOnTheTopBar(String name) {
        landingPage.clickOnCategory(name)
                .verifyWebPageTitle(name)
                .verifyProductHeader(name);
    }

    @Then("I find the Product with {string} and click it v2")
    public void iFindTheProductWithAndClickIt(String product) {
        System.out.println(product);
        getDriver().findElement(By.xpath("//h2[@class='woocommerce-loop-product__title' and text() = '"+product+"']")).click();
    }

    @Then("I verify product description page contains product {string} v2")
    public void iVerifyProductDescriptionPageContainsProduct(String product) {
        getDriver().findElement(By.xpath("//h1[@class='product_title entry-title' and text() = '"+product+"']")).isDisplayed();
    }

    @Then("I increase the counter and add to cart v2")
    public void iIncreaseTheCounterAndAddToCart() throws InterruptedException {
        Thread.sleep(100);
        getDriver().findElement(By.xpath("//input[@class='input-text qty text']")).sendKeys(Keys.ARROW_UP);
        getDriver().findElement(By.xpath("//button[@name='add-to-cart']")).click();
    }

    @Then("I verify product {string} has been added v2")
    public void iVerifyProductHasBeenAdded(String product) {
        getDriver().findElement(By.xpath("//div[@class='woocommerce-message' and text() = ' 2 × “"+product+"” have been added to your cart.\t']")).isDisplayed();
    }

    @Given("I add {string} to cart from landing page v2")
    public void iAddProductToCartFromLandingPage(String product) throws InterruptedException {
        String xpath = "//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart' and contains(@aria-label, '"+product+"')]";

        if (getDriver().findElements(By.xpath(xpath)).isEmpty()) {
            System.out.println("Cannot find Add to cart button");
            // throw new IllegalStateException("Add to cart button is not displayed");

            // how to stop executing test?
            Assert.fail("Add to cart button is not displayed");
        } else {
            getDriver().findElement(By.xpath(xpath)).click();
            Thread.sleep(5_000);
        }
    }

    @Then("I click view cart and verify {string} is in cart v2")
    public void iClickViewCartAndVerifyIsInCart(String product)  {
        WebElement viewCartWebElement = getDriver().findElement(By.xpath("//a[@title='View cart']"));
        WaitForElement(viewCartWebElement);
        viewCartWebElement.click();
        String productXpath = "//form[@class='woocommerce-cart-form']//tbody//td[@class='product-name']//a[contains(text(),'"+product+"')]";
        WebElement productWebElement = getDriver().findElement(By.xpath(productXpath));
        WaitForElement(productWebElement);
        productWebElement.isDisplayed();
    }

    @Then("I change the quantity of the {string} to {string} and click update v2")
    public void iChangeTheQuantityOfTheToAndClickUpdate(String product, String quantity) throws InterruptedException {
        String quantityXpath = "//form[@class='woocommerce-cart-form']//tbody//td[@class='product-name']//a[contains(text(),'"+product+"')]/../..//td[@class='product-quantity']//input[@type='number']";

        WebElement quantityWebElement = getDriver().findElement(By.xpath(quantityXpath));
        quantityWebElement.clear();
        quantityWebElement.sendKeys(quantity);

        getDriver().findElement(By.xpath("//button[@name='update_cart']")).click();
        Thread.sleep(5_000);
    }

    @Then("I verify items are updated v2")
    public void iVerifyItemsAreUpdated() {
        WebElement alertWebElement = getDriver().findElement(By.xpath("//div[@role='alert']"));
        WaitForElement(alertWebElement);
        assertThat(alertWebElement.getText()).containsIgnoringCase("cart updated.");
    }

    @Then("I click the remove icon and verify {string} is updated v2")
    public void iClickTheRemoveIconAndVerifyIsUpdated(String product) throws InterruptedException {
        String xpath = "//form[@class='woocommerce-cart-form']//tbody//td[@class='product-name']//a[contains(text(),'"+product+"')]/../..//td[@class='product-remove']//a[@aria-label='Remove this item']";
        getDriver().findElement(By.xpath(xpath)).click();

        Thread.sleep(3_000);

        WebElement alertWebElement = getDriver().findElement(By.xpath("//div[@role='alert']"));
        WaitForElement(alertWebElement);
        assertThat(alertWebElement.getText()).containsIgnoringCase("removed");
    }
}
