package uiAutomation.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiAutomation.constants.Constants;
import uiAutomation.pages.LoginPage;
import uiAutomation.utilities.ConfigurationReader;
import uiAutomation.utilities.Driver;

import java.time.Duration;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();
    private String url = ConfigurationReader.getUiProperty(Constants.UI_CONFIG, "bookclubs.url");
    private String expectedLoginUrl=ConfigurationReader.getUiProperty(Constants.UI_CONFIG,"login.url");
    private String expectedProfileUrl=ConfigurationReader.getUiProperty(Constants.UI_CONFIG,"profile.url");

    @Given("User navigates to web-application")
    public void user_navigates_to_web_application(){
        Driver.getDriver().get(url);
        String actualUrl= Driver.getDriver().getCurrentUrl();
        String expectedMainUrl="https://bookclubs.com/";
        Assert.assertEquals("User wasn't navigate to web-application",
                expectedMainUrl, actualUrl);
    }

    @When("User click on SIGN IN button and transfer to signin page")
    public void user_click_on_sign_in_button_and_transfer_to_signin_page() {
        loginPage.signInButton.click();
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("SignIn Url doesn't match",
                expectedLoginUrl, actualUrl);
    }

    @Then("User logs in with EMAIL {string} and PASSWORD {string}")
    public void user_logs_in_with_email_and_password(String email, String password) {
        loginPage.usernameInputBox.sendKeys(email);
        loginPage.passwordInputBox.sendKeys(password);
    }

    @Then("User clicks on LOG IN button")
    public void user_clicks_on_log_in_button(){
        loginPage.logInButton.click();

    }

    @Then("User is redirected to account page")
    public void user_is_redirected_to_account_page() {
        Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlMatches(ConfigurationReader.getUiProperty(Constants.UI_CONFIG,"profile.url")));
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("Profile url doesn't match",
                expectedProfileUrl, actualUrl);
    }

    @Then("User logs in with invalid EMAIL and invalid PASSWORD")
    public void user_logs_in_with_invalid_email_and_invalid_password(){
        loginPage.usernameInputBox.sendKeys("qwert");
        loginPage.passwordInputBox.sendKeys("jkdsnal");
    }

    @Then("User see error message")
    public void user_see_error_message() {
        String actualErrorMessage=loginPage.errorMessage.getText();
        String expectedErrorMessage="Email is invalid";
        Assert.assertEquals("Message incorrect",
                actualErrorMessage, expectedErrorMessage );
    }
}
