package com.futuresimple.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "user_email")
    private WebElement emailField;


    public DashboardPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LeadPopup clickAddButton()    {
        waitForElementToAppear(By.xpath("(//button[contains(@class,'_1AM--Button--Button')])[1]"));
        WebElement addButton = driver.findElement(By.xpath("(//button[contains(@class,'_1AM--Button--Button')])[1]"));
        addButton.click();
        waitForElementToAppear(By.xpath("//div[contains(@class, '_1zW--PopoverBalloon--Popover')]"));
        WebElement leadSelect = driver.findElement(By.xpath("(//div[contains(@class, '_1zW--PopoverBalloon--Popover')]/div/div/div/div)[1]"));
        leadSelect.click();
        return new LeadPopup(driver, wait);
    }

    public SettingsPage openSettings(){
        waitForElementToAppear(By.xpath("(//button[contains(@class, '_1AM--Button--Button')])[2]"));
        WebElement settingsDropdown = driver.findElement(By.xpath("(//button[contains(@class, '_1AM--Button--Button')])[2]"));
        settingsDropdown.click();
        WebElement settingsButton = driver.findElement(By.xpath("(//div[contains(@class, '_2t1--List--List')]/div)[2]"));
        settingsButton.click();
        return new SettingsPage(driver, wait);
    }
}
