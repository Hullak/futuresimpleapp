package com.futuresimple.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeadPopup extends BasePage {

    @FindBy(id = "form_item_id_56")
    private WebElement lastNameField;

    @FindBy (xpath = "//button[@data-action='save-and-visit']")
    private WebElement saveViewButton;

    public LeadPopup(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public LeadPage addLead(String lastName){
        lastNameField.sendKeys(lastName);
        saveViewButton.click();
        return new LeadPage(driver, wait);
    }

}
