package com.specsavers.core;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.webdriver.DriverSource;
import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import net.thucydides.core.webdriver.UnsupportedDriverException;

public class CustomChromeDriver implements DriverSource {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomChromeDriver.class);
    private static final String proxy = "proxy.uk.specsavers.com:8080";
    private static final String binarySetupMessage = "Downloading and setting up chrome WebDriver binary from https://chromedriver.storage.googleapis.com:443";

    private Scenario scenario;

    @Before
    public void setup(Scenario scenario) {
        this.scenario = scenario;
    }

    public void write(String message) {
        scenario.write(message);
    }

    @Override
    public WebDriver newDriver() {
        try {
            setupChromeDriverBinary();

            final ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.addArguments(
                    "--ignore-certificate-errors",
                    "--disable-download-notification",
                    "--no-sandbox",
                    "--disable-gpu");

            if (SystemUtils.IS_OS_LINUX) {
                chromeOptions.addArguments(
                        "--headless",
                        "--allow-running-insecure-content",
                        "--disable-web-security");

                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.acceptInsecureCerts();
            } else if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_WINDOWS) {
                chromeOptions.addArguments(
                        "--incognito",
                        "--start-fullscreen");
            }

            return new ChromeDriver(ChromeDriverService.createDefaultService(), chromeOptions);

        } catch (UnreachableBrowserException e) {
            write("Error due to " + e.getMessage());
            throw new UnreachableBrowserException(e.getMessage());
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

    private void setupChromeDriverBinary() {
        LOGGER.info(binarySetupMessage);
        try {
            if (SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_WINDOWS || SystemUtils.IS_OS_LINUX) {
                LOGGER.info("driver binary setup started...");
/*                ChromeDriverManager.getInstance(DriverManagerType.CHROME).proxy(proxy).setup();
                WebDriverManager.chromedriver().proxy(proxy).setup();*/
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
                WebDriverManager.chromedriver().setup();

            }else {
                System.getenv();
            }
        } catch (Exception e) {
            LOGGER.info("Driver Binary not setup correctly...");
            e.printStackTrace();
        }
    }

}