package com.specsavers.core;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class CustomCloudDriver implements DriverSource {

    public WebDriver newDriver() {

        DesiredCapabilities dc = new DesiredCapabilities();

        URL url = null;
        try {
            url = new URL("https://specsavers.experitest.com/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        switch(Properties.expBrowser())
        {
            case "Chrome":
            dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
            break;
            case "Firefox":
            dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
            break;
            default:
            dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        }

        //dc.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
        //dc.setCapability(CapabilityType.BROWSER_VERSION, "76.0.3809.132");
        //dc.setCapability(CapabilityType.PLATFORM, "Windows 7");
        dc.setCapability("accessKey", Properties.experitestKey());
        dc.setCapability("testName", "serenity.bdd-ui Tests");


        try {
            // RemoteWebDriver drivers =
            return new RemoteWebDriver(url, dc);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public boolean takesScreenshots() {
        return false;
    }
}
