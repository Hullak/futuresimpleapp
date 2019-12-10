package com.futuresimple.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadPage extends BasePage {
    public LeadPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getLeadStatus(){
        waitForElementToAppear(By.className("lead-status"));
        WebElement leadStatus = driver.findElement(By.className("lead-status"));
        return leadStatus.getText();
    }
}
