package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    WebDriver driver;

    //Constructor
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_badge");
    By productItems = By.className("inventory_item");
    By firstProductName = By.className("inventory_item_name");
    By firstProductPrice = By.className("inventory_item_price");
    By cartIconButton = By.className("shopping_cart_link");
    By removeButton = By.id("remove-sauce-labs-backpack");

    //Associate Methods
    public void clickOnAddToCartButton () {
        driver.findElement(addToCartButton).click();
    }
    public String cartIconText (){ return driver.findElement(cartIcon).getText(); }
    public int getAllProductCount() { return driver.findElements(productItems).size(); }
    public String getFirstProductName() { return driver.findElement(firstProductName).getText(); }
    public String getFirstProductPrice() { return driver.findElement(firstProductPrice).getText(); }
    public void clickOnCartIcon() { driver.findElement(cartIcon).click();}
    public void clickOnRemoveButton() {driver.findElement(removeButton).click();
    }
}