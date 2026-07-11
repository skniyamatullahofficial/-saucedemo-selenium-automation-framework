package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver; }

    By cartProductName = By.className("inventory_item_name");
    By cartProductPrice = By.className("inventory_item_price");
    By cartItems = By.className("cart_item");
    By removeButton = By.id("remove-sauce-labs-backpack");

    public String getCartProductName() {
        return driver.findElement(cartProductName).getText();
    }
    public String getCartProductPrice() {
        return driver.findElement(cartProductPrice).getText();
    }
    public int getCartItemCount() { return driver.findElements(cartItems).size();}
    public void clickOnRemoveButton() { driver.findElement(removeButton).click();
    }
}
