package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    By usernameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");

    //Associate Methods
    public void loginToApplication(String usernameValue, String passwordValue) {
        driver.findElement(usernameField).sendKeys(usernameValue);
        driver.findElement(passwordField).sendKeys(passwordValue);
        driver.findElement(loginButton).click();
    }
    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }
}