package com.futuresimple.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage extends BasePage {
    public SettingsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    @FindBy (xpath = "//a[@data-original-title='Leads']")
    private WebElement menuLeads;


    public void changeStatusName(String newStatusName){
        waitForElementToAppear(By.xpath("//li[@class='leads']"));
        WebElement leadsSettings = driver.findElement(By.xpath("//li[@class='leads']"));
        leadsSettings.click();
        WebElement leadStatuses = driver.findElement(By.xpath("(//ul[contains(@class, 'nav-tabs')]/li)[3]"));
        leadStatuses.click();
        WebElement editButton = driver.findElement(By.xpath("(//button[contains(@class, 'edit')])[7]"));
        editButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class, 'controls')]/input)[5]")));
        WebElement editField = driver.findElement(By.xpath("(//div[contains(@class, 'controls')]/input)[5]"));
        editField.clear();
        editField.sendKeys(newStatusName);
        WebElement saveButton = driver.findElement(By.xpath("(//button[contains(@class, 'save')])[2]"));
        saveButton.click();
    }

    public LeadsPage openLeadsPage(){
        menuLeads.click();
        return new LeadsPage(driver,wait) ;
    }
}
