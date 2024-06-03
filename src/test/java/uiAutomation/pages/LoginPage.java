package uiAutomation.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiAutomation.utilities.Driver;

public class LoginPage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement usernameInputBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@class='mtr-button']")
    public WebElement logInButton;

    @FindBy(xpath = "//span[text()='Email is invalid']")
    public WebElement errorMessage;

    public void login(String usernameEmail, String password)  {
        try{
            LOGGER.info("Attempting to log in with username: " + usernameEmail);
            usernameInputBox.sendKeys(usernameEmail);
            LOGGER.debug("Username entered in the input box.");
            passwordInputBox.sendKeys(password);
            LOGGER.debug("Password entered in the input box.");
            logInButton.click();
            LOGGER.info("Sign in button clicked.");
        } catch (Exception e) {
            LOGGER.error("Error occurred while trying to log in.", e);
            throw e;
        }

    }
}
