package uiAutomation.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiAutomation.constants.Constants;
import uiAutomation.pages.CartFunctionalityPage;
import uiAutomation.utilities.ConfigurationReader;
import uiAutomation.utilities.Driver;

import java.time.Duration;


public class CartFunctionalitySteps {
    private static final Logger LOGGER = LogManager.getLogger(CartFunctionalitySteps.class);
    private String url = ConfigurationReader.getUiProperty(Constants.UI_CONFIG,"bookclubsSearchPage.url");
    private CartFunctionalityPage cartFunctionalityPage = new CartFunctionalityPage();
    private Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(40));
    private String mainTab=Driver.getDriver().getWindowHandle();

    @Given("User landing on book page")
    public void user_landing_on_book_page() {
        Driver.getDriver().get(url);
        LOGGER.info("Browser opened, landed on book page");
    }
    @When("User click on {string}")
    public void user_click_on(String expectedBook) {
        cartFunctionalityPage.LessonsInChemistryBook.click();
        LOGGER.info("Clicked on " + expectedBook);

    }
    @Then("User redirected to that book page {string}")
    public void user_redirected_to_that_book_page(String expectedUrl) {
        wait.until(ExpectedConditions.urlMatches(expectedUrl));
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("Url doesn't match", expectedUrl,actualUrl);
        LOGGER.info("Redirected to: " + expectedUrl);

    }
    @When("User click on BOOKSHOP button")
    public void user_click_on_bookshop_button() {
        cartFunctionalityPage.bookShopButton.click();
        LOGGER.info("Clicked on BOOKSHOP button");
    }
    @Then("User transfer to new tab with option add to cart")
    public void user_transfer_to_new_tab_with_option_add_to_cart() {

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : Driver.getDriver().getWindowHandles()) {
            if (!mainTab.contentEquals(windowHandle)) {
                Driver.getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        String titleIS=Driver.getDriver().getTitle();
        LOGGER.info("Actual title of the second window tab is: "+titleIS);
        boolean expectedTitle=wait.until(ExpectedConditions.titleIs("Lessons in Chemistry a book by Bonnie Garmus"));
        Assert.assertTrue("Tittle doesnt match", expectedTitle);

    }

    @When("Click on ADD TO CART button")
    public void click_on_add_to_cart_button() {
        cartFunctionalityPage.addToCart.click();
        LOGGER.info("Clicked on ADD TO CART button");
    }

    @Then("User see pop-up window with option Keep Shopping and Checkout Out")
    public void user_see_pop_up_window_with_option_keep_shopping_and_checkout_out() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(cartFunctionalityPage.popUpWindow));
        LOGGER.info("POP-UP window visiable");
        Assert.assertTrue("Checkout button not displayed",cartFunctionalityPage.checkOutButton.isDisplayed());
        LOGGER.info("Checkout button displayed");
        Thread.sleep(3000);
    }
    @When("User click on CHECKOUT button")
    public void user_click_on_checkout_button() throws InterruptedException {
        cartFunctionalityPage.checkOutButton.click();
        Thread.sleep(5000);
        LOGGER.info("Check out button clicked");
    }
    @Then("User redirected to Cart Page and see book in cart")
    public void user_redirected_to_cart_page_and_see_book_in_cart() {
        for(WebElement item: cartFunctionalityPage.cart){
            String getItemText=item.getText();
            LOGGER.info("ITEM inside cart: "+getItemText);
        }
    }
}
