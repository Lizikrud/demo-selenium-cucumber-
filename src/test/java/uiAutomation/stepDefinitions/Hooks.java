package uiAutomation.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import uiAutomation.utilities.Driver;

import java.time.Duration;

public class Hooks {
    @Before
    public void setUp(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @After
    public void tearDown(Scenario scanario){
        if(scanario.isFailed()){
            final byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scanario.attach(screenshot, "image/jpeg", "screenshot");
        }
        Driver.quitDriver();
    }
}
