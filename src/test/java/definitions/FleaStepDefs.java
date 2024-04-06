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

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class FleaStepDefs {
    @Given("I visit FLEA Market in the {string} Environment")
    public void iVisitFLEAMarketInTheEnvironment(String env) {
        if(env.equalsIgnoreCase("Stage")) {
            getDriver().get("http://store-stage.portnov.com/");
        } else if(env.equalsIgnoreCase("qa")) {
            getDriver().get("http://store-qa.portnov.com/");
        } else {
            System.out.println("BAD URL");
        }
    }
    @Then("I verify title is {string} for the page")
    public void iVerifyTitleIsForThePage(String title) {
        assertThat(getDriver().getTitle()).isEqualTo(title);
    }

    @Then("I verify title of the page contains {string}")
    public void iVerifyTitleOfThePageContains(String title) {
        assertThat(getDriver().getTitle()).containsIgnoringCase(title);
    }

    @When("I wait and click on a product {string} on the Landing Page")
    public void iClickOnAProductOnTheLandingPage(String product) {
        String xpath = "//img[@title='"+product +"']";
        WebDriverWait waits = new WebDriverWait(getDriver(), 10);
        waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        getDriver().findElement(By.xpath(xpath)).click();
        iVerifyTitleOfThePageContains(product);
        assertThat(getDriver().findElement(By.xpath("//*[text()='"+product+"']")).getText()).containsIgnoringCase(product);
    }

    @Then("I verify Cart Icon is present")
    public void iWaitForCartToAppear() {
        WebElement element = getDriver().findElement(By.xpath("//*[@id='site-header-cart']"));
        element.isDisplayed();
    }

    @Then("I verify Image Slider is present")
    public void iVerifyImageSliderIsPresent() {
        WebElement element = getDriver().findElement(By.xpath("//*[@class='swiper swiper-cube swiper-3d swiper-initialized swiper-horizontal swiper-pointer-events']"));
        element.isDisplayed();
    }

    public void WaitForElement(WebElement element) {
        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOf(element));
    }

    @Then("I wait {int} sec")
    public void iWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 1000);
    }

    @Then("I verify Contact button functionality")
    public void iVerifyContactButtonFunctionality() throws Exception {
        getDriver().findElement(By.xpath("//div[@data-title='Contact Us']")).click();
        WebElement name = getDriver().findElement(By.xpath("//input[@name='name']"));
        WaitForElement(name);
        name.sendKeys("Tester");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
        getDriver().findElement(By.xpath("//textarea[@id='chaty-name']")).sendKeys("Blah Blah Blah");
        iWaitForSec(2);
        getDriver().findElement(By.xpath("//button[contains(text(), 'Send')]")).click();
        iWaitForSec(2);
        assertThat(getDriver().findElement(By.xpath("//div[@class='chaty-ajax-success-message']")).getText()).isEqualTo("Your message was sent successfully");
    }

    @When("I verify and Click on {string} Category on the Top Bar")
    public void iVerifyAndClickOnCategoryOnTheTopBar(String name) {
        WebElement category = getDriver().findElement(By.xpath("//ul[@id='menu-main']//a[text()='"+name+"']"));
        WaitForElement(category);
        category.click();
        iVerifyTitleOfThePageContains(name);
        assertThat(getDriver().findElement(By.xpath("//header//h1")).getText()).isEqualToIgnoringCase(name);
    }

    @Then("I find the Product with {string} and click it")
    public void iFindTheProductWithAndClickIt(String product) {
        System.out.println(product);
        getDriver().findElement(By.xpath("//h2[@class='woocommerce-loop-product__title' and text() = '"+product+"']")).click();
    }

    @Then("I verify product description page contains product {string}")
    public void iVerifyProductDescriptionPageContainsProduct(String product) {
        getDriver().findElement(By.xpath("//h1[@class='product_title entry-title' and text() = '"+product+"']")).isDisplayed();
    }

    @Then("I increase the counter and add to cart")
    public void iIncreaseTheCounterAndAddToCart() throws InterruptedException {
        Thread.sleep(100);
        getDriver().findElement(By.xpath("//input[@class='input-text qty text']")).sendKeys(Keys.ARROW_UP);
        getDriver().findElement(By.xpath("//button[@name='add-to-cart']")).click();
    }

    @Then("I verify product {string} has been added")
    public void iVerifyProductHasBeenAdded(String product) {
        getDriver().findElement(By.xpath("//div[@class='woocommerce-message' and text() = ' 2 × “"+product+"” have been added to your cart.\t']")).isDisplayed();
    }

    @Given("I add {string} to cart from landing page")
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

    @Then("I click view cart and verify {string} is in cart")
    public void iClickViewCartAndVerifyIsInCart(String product)  {
        WebElement viewCartWebElement = getDriver().findElement(By.xpath("//a[@title='View cart']"));
        WaitForElement(viewCartWebElement);
        viewCartWebElement.click();
        String productXpath = "//form[@class='woocommerce-cart-form']//tbody//td[@class='product-name']//a[contains(text(),'"+product+"')]";
        WebElement productWebElement = getDriver().findElement(By.xpath(productXpath));
        WaitForElement(productWebElement);
        productWebElement.isDisplayed();
    }

    @Then("I change the quantity of the {string} to {string} and click update")
    public void iChangeTheQuantityOfTheToAndClickUpdate(String product, String quantity) throws InterruptedException {
        String quantityXpath = "//form[@class='woocommerce-cart-form']//tbody//td[@class='product-name']//a[contains(text(),'"+product+"')]/../..//td[@class='product-quantity']//input[@type='number']";

        WebElement quantityWebElement = getDriver().findElement(By.xpath(quantityXpath));
        quantityWebElement.clear();
        quantityWebElement.sendKeys(quantity);

        getDriver().findElement(By.xpath("//button[@name='update_cart']")).click();
        Thread.sleep(5_000);
    }

    @Then("I verify items are updated")
    public void iVerifyItemsAreUpdated() {
        WebElement alertWebElement = getDriver().findElement(By.xpath("//div[@role='alert']"));
        WaitForElement(alertWebElement);
        assertThat(alertWebElement.getText()).containsIgnoringCase("cart updated.");
    }

    @Then("I click the remove icon and verify {string} is updated")
    public void iClickTheRemoveIconAndVerifyIsUpdated(String product) throws InterruptedException {
        String xpath = "//form[@class='woocommerce-cart-form']//tbody//td[@class='product-name']//a[contains(text(),'"+product+"')]/../..//td[@class='product-remove']//a[@aria-label='Remove this item']";
        getDriver().findElement(By.xpath(xpath)).click();

        Thread.sleep(3_000);

        WebElement alertWebElement = getDriver().findElement(By.xpath("//div[@role='alert']"));
        WaitForElement(alertWebElement);
        assertThat(alertWebElement.getText()).containsIgnoringCase("removed");
    }
}
