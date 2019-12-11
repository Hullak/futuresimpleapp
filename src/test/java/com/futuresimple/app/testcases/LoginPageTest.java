package com.futuresimple.app.testcases;

import com.futuresimple.app.AppConstants;
import com.futuresimple.app.pages.*;

import com.futuresimple.app.utility.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest {

    public static final String LEAD_NAME = "Kolodziej";
    public static final String STATUS_NEW = "New";
    public static final String NEW_STATUS_NAME = "Nowy";
    WebDriver driver;
    WebDriverWait wait;
    ConfigDataProvider configDataProvider;
    LoginPage lp;

    @BeforeMethod
    public void setUp() throws IOException {
        configDataProvider = new ConfigDataProvider();
        driver = BrowserFactory.startApplication(driver, configDataProvider.getBrowser(), configDataProvider.getStringURL());
        wait = new WebDriverWait(driver, AppConstants.TIMEOUT, AppConstants.POLLING);
        lp = new LoginPage(driver, wait);
    }


    @Test (priority = 1)
    public void createLeadTest() {
        DashboardPage dp = lp.correctLogin();
        LeadPopup leadPopup = dp.clickAddButton();
        LeadPage leadPage = leadPopup.addLead(LEAD_NAME);
        Assert.assertEquals(leadPage.getLeadStatus(), STATUS_NEW);
    }


    @Test (priority = 2)
    public void changeLeadStatusInSettings() {
        DashboardPage dp = lp.correctLogin();
        SettingsPage settingsPage = dp.openSettings();
        settingsPage.changeStatusName(NEW_STATUS_NAME);
        LeadsPage leadsPage = settingsPage.openLeadsPage();
        LeadPage leadPage = leadsPage.clickLead(LEAD_NAME);
        driver.navigate().refresh();
        Assert.assertEquals(leadPage.getLeadStatus(), NEW_STATUS_NAME);
    }

//    @AfterMethod
//    public void tearDown() {
//        BrowserFactory.quitBrowser(driver);
//    }
}


