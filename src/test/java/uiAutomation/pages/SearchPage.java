package uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiAutomation.utilities.Driver;

public class SearchPage {
    public SearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='search']")
    public WebElement searchField;

    @FindBy(xpath = "//button[text()='search']")
    public WebElement searchButton;
}
