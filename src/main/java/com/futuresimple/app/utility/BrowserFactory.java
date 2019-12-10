package com.futuresimple.app.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {


    public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl) {
        if (browserName.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {
            System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("We do not support this browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(appUrl);

        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        if (null != driver) {
            driver.quit();
        }
    }
}
