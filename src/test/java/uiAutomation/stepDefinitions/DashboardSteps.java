package uiAutomation.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiAutomation.constants.Constants;
import uiAutomation.pages.DashboardPage;
import uiAutomation.pages.LoginPage;
import uiAutomation.utilities.ConfigurationReader;
import uiAutomation.utilities.Driver;

import java.time.Duration;
import java.util.List;

public class DashboardSteps {
    private static final Logger LOGGER = LogManager.getLogger(DashboardSteps.class);
    private LoginPage loginPage = new LoginPage();
    private DashboardPage dashboardPage = new DashboardPage();
    private String url = ConfigurationReader.getUiProperty(Constants.UI_CONFIG,"bookclubs.url");
    private String username=ConfigurationReader.getUiProperty(Constants.UI_CONFIG, "bookclubs.username");
    private String password=ConfigurationReader.getUiProperty(Constants.UI_CONFIG,"bookclubs.password");
    private Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(40));


    @Given("User landing on Profile page")
    public void user_landing_on_profile_page() {
        Driver.getDriver().get(url);
        LOGGER.info("Browser opened");
        loginPage.signInButton.click();
        LOGGER.info("SignIn button clicked");
        loginPage.login(username,password);
        LOGGER.info("Logged to Profile page");
    }

    @Then("User can see username {string} on profile dropdown button")
    public void user_can_see_username_on_profile_dropdown_button(String expectedUsername) {
        String actualUsername = dashboardPage.profileNameButton.getText();
        Assert.assertEquals("Username doesn't match",
                actualUsername, expectedUsername);
        LOGGER.info("Username verified.");
    }

    @When("User click on username profile")
    public void user_click_on_username_profile() {
        wait.until(ExpectedConditions.visibilityOf(dashboardPage.profileNameButton));
        dashboardPage.profileNameButton.click();
        LOGGER.info("Profile Username Button clicked");
    }

    @Then("User see list of dropdown")
    public void user_see_list_of_dropdown() {
            WebElement currentTab=dashboardPage.getTabList();

            LOGGER.info("Profile dropdown functionality: "+currentTab.getText());

    }
}
