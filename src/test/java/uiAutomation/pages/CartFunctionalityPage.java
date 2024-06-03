package uiAutomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uiAutomation.utilities.Driver;

import java.util.List;

public class CartFunctionalityPage {
    public CartFunctionalityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@href='/books/lessons-in-chemistry-a-novel-137422'][1]")
    public WebElement LessonsInChemistryBook;

    @FindBy(xpath = "//a[@target='_blank'][1]")
    public WebElement bookShopButton;

    @FindBy(xpath = "//*[@class='button primary inline-flex w-full ']")
    public WebElement addToCart;

    @FindBy(xpath = "//*[@class='max-w-sm bg-white border rounded grid grid-cols-2 col-gap-4 row-gap-8 p-4']")
    public WebElement popUpWindow;

    @FindBy(xpath = "//*[contains(text(),'check out')]")
    public WebElement checkOutButton;

    @FindBy(xpath = "//*[@id='line_items']/tr")
    public List<WebElement> cart;

    @FindBy(xpath = "//*[@name='goog_topics_frame']")
    public WebElement iFrameAdd;

    @FindBy(xpath = "//*[@id='title-Close dialog 1']")
    public WebElement closeDialodIframe;
}
