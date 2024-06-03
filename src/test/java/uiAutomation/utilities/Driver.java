package uiAutomation.utilities;

import org.openqa.selenium.WebDriver;
import uiAutomation.constants.Constants;

public class Driver {
    private static WebDriver driver;

    private Driver(){
    }

    public static WebDriver getDriver(){
        if(driver == null){
            driver = DriverFactory.getDriver(ConfigurationReader.getUiProperty(Constants.UI_CONFIG,"browserType"));
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
