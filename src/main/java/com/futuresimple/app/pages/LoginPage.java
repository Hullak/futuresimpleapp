package com.futuresimple.app.pages;

import com.futuresimple.app.AppConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "user_email")
    private WebElement emailField;

    @FindBy(id = "user_password")
    private WebElement passwordField;

    @FindBy(className = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    public DashboardPage correctLogin(){
        emailField.sendKeys(AppConstants.LOGIN);
        passwordField.sendKeys(AppConstants.PASSWORD);
        loginButton.click();
        return new DashboardPage(driver,wait);
    }

}
