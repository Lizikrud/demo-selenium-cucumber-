package uiAutomation.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private static final Logger LOGGER = LogManager.getLogger(WaitHelper.class);

    public static void shortWait() {
        LOGGER.info("Short wait (5 seconds) initiated.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            LOGGER.error("An exception occurred during shortWait", e);
            Thread.currentThread().interrupt();
        }
    }

    public static void mediumWait() {
        LOGGER.info("Medium wait (15 seconds) initiated.");
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            LOGGER.error("An exception occurred during mediumWait", e);
            Thread.currentThread().interrupt();
        }
    }
    public static void longWait() {
        LOGGER.info("Long wait (30 seconds) initiated.");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            LOGGER.error("An exception occurred during longWait", e);
            Thread.currentThread().interrupt();
        }
    }

    public static void wait(int secs) {
        LOGGER.info("Waiting for " + secs + " seconds.");
        try {
            Thread.sleep(1000L * secs);
        } catch (InterruptedException e) {
            LOGGER.error("An exception occurred during wait", e);
            Thread.currentThread().interrupt();
        }
    }

    public static void waitForVisibility(WebElement element, int timeToWaitInSec) {
        LOGGER.info("Waiting for visibility of element for " + timeToWaitInSec + " seconds.");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            LOGGER.error("An exception occurred while waiting for element visibility: " + e.getMessage(), e);
            throw e;
        }
    }
}
