package uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiAutomation.utilities.Driver;

import java.util.List;

public class DashboardPage {
    public DashboardPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//button[@name='PROFILE']")
    public WebElement profileNameButton;

    @FindBy(xpath = "//*[@class='sub-menu place-right']//li")
    public List<WebElement> profileTab;

    public WebElement getTabByName(String tabName){
        for(WebElement tab: profileTab){
            if(tab.getText().equalsIgnoreCase(tabName)){
                return tab;
            }
        }
        throw new RuntimeException("The tab with name element doesn't exist"+tabName);
    }
    public WebElement getTabList(){
        for(WebElement tab: profileTab){
                return tab;
        }
        throw new RuntimeException("The tabe element doesn't exist");
    }

}
