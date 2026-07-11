package com.saucedemo.testcases;

import com.aventstack.extentreports.util.Assert;
import com.saucedemo.constants.AssertionConstants;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.CartPage;
import com.saucedemo.utilities.PropertiesUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static com.saucedemo.constants.AssertionConstants.*;
import static com.saucedemo.constants.GlobalConstants.*;
import static com.saucedemo.constants.PageConstants.INVENTORY_PRODUCTS_COUNT;


public class InventoryTest extends BaseTest {

    @Test
    public void verifyProductAddedToCart() throws IOException {
        SoftAssert assertion = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        String username = PropertiesUtils.readFromProperties(USERNAME);
        String password = PropertiesUtils.readFromProperties(PASSWORD);
        loginPage.loginToApplication(username, password);
        String currentUrl = loginPage.getCurrentPageUrl();
        assertion.assertTrue(currentUrl.contains(INVENTORY_URL_ROUTE),
                INCORRECT_PAGE_URL);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnAddToCartButton();
        String addedProductCount = inventoryPage.cartIconText();
        assertion.assertEquals(addedProductCount, "1", PRODUCT_COUNT_MISMATCH);
        assertion.assertAll();
    }

    @Test
    public void verifyAllProductsAreDisplayed() throws IOException {
        SoftAssert assertion = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        String username = PropertiesUtils.readFromProperties(USERNAME);
        String password = PropertiesUtils.readFromProperties(PASSWORD);
        loginPage.loginToApplication(username, password);
        InventoryPage inventoryPage = new InventoryPage(driver);
        int productCount = inventoryPage.getAllProductCount();
        assertion.assertEquals(productCount, INVENTORY_PRODUCTS_COUNT,
                ALL_PRODUCTS_NOT_DISPLAYED);
        assertion.assertAll();
    }
    @Test
    public void verifyProductNameAndPriceInCart() throws IOException {
        SoftAssert assertion = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        String username = PropertiesUtils.readFromProperties(USERNAME);
        String password = PropertiesUtils.readFromProperties(PASSWORD);
        loginPage.loginToApplication(username, password);
        InventoryPage inventoryPage = new InventoryPage(driver);
        String expectedProductName = inventoryPage.getFirstProductName();
        String expectedProductPrice = inventoryPage.getFirstProductPrice();
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnCartIcon();
        CartPage cartPage = new CartPage(driver);
        String actualProductName = cartPage.getCartProductName();
        String actualProductPrice = cartPage.getCartProductPrice();
        assertion.assertEquals(actualProductName, expectedProductName, PRODUCT_NAME_MISMATCH);
        assertion.assertEquals(actualProductPrice, expectedProductPrice, PRODUCT_PRICE_MISMATCH);
        assertion.assertAll();
    }

    @Test
    public void verifyRemoveProductFromCart() throws IOException {
        SoftAssert assertion = new SoftAssert();
        LoginPage loginPage = new LoginPage(driver);
        String username = PropertiesUtils.readFromProperties(USERNAME);
        String password = PropertiesUtils.readFromProperties(PASSWORD);
        loginPage.loginToApplication(username, password);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnAddToCartButton();
        inventoryPage.clickOnCartIcon();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnRemoveButton();
        int actualCartCount = cartPage.getCartItemCount();
        assertion.assertEquals(actualCartCount, 0, PRODUCT_NOT_REMOVED_FROM_CART);
        assertion.assertAll();
    }
}