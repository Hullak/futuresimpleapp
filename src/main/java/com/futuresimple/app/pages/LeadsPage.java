package com.futuresimple.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LeadsPage extends BasePage {

    public LeadsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LeadPage clickLead(String leadName){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> clearAll = driver.findElements(By.xpath("//button[./div/text()='Clear All']"));
        if(!clearAll.isEmpty()){
            clearAll.get(0).click();
        }
        List<WebElement> newLead = driver.findElements(By.xpath("//a[./div/span/text()='"+ leadName +"']"));
        if(!newLead.isEmpty()) {
            newLead.get(0).click();
        }
        newLead = driver.findElements(By.xpath("//a[./div/span/strong/text()='"+ leadName +"']"));
        if(!newLead.isEmpty()) {
            newLead.get(0).click();
        }
        return new LeadPage(driver,wait);
    }
}
