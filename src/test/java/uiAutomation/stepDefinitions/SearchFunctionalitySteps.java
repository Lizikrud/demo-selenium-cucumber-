package uiAutomation.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import uiAutomation.constants.Constants;
import uiAutomation.pages.SearchPage;
import uiAutomation.utilities.ConfigurationReader;
import uiAutomation.utilities.Driver;

public class SearchFunctionalitySteps {
    private SearchPage searchPage = new SearchPage();
    private String url = ConfigurationReader.getUiProperty(Constants.UI_CONFIG,"bookclubsSearchPage.url");

    @Given("User landing on search page of web-application")
    public void user_landing_on_search_page_of_web_application() {
        Driver.getDriver().get(url);
    }
    @When("user enters {string} in search box")
    public void user_enters_in_search_box(String text){
        searchPage.searchField.sendKeys(text);
        searchPage.searchButton.click();
    }
}
