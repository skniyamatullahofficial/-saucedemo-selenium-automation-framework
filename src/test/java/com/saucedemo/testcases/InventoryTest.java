package com.saucedemo.testcases;

import com.aventstack.extentreports.util.Assert;
import com.saucedemo.constants.AssertionConstants;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.PropertiesUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static com.saucedemo.constants.AssertionConstants.INCORRECT_PAGE_URL;
import static com.saucedemo.constants.AssertionConstants.PRODUCT_COUNT_MISMATCH;
import static com.saucedemo.constants.GlobalConstants.*;

public class InventoryTest extends BaseTest{

@Test
public void verifyProductAddedToCart() throws IOException {
    SoftAssert assertion = new SoftAssert();
    LoginPage loginPage = new LoginPage(driver);
    String username = PropertiesUtils.readFromProperties(USERNAME);
    String password = PropertiesUtils.readFromProperties(PASSWORD);
    loginPage.loginToApplication(username,password);
    String currentUrl = loginPage.getCurrentPageUrl();
    assertion.assertTrue(currentUrl.contains(INVENTORY_URL_ROUTE),
            INCORRECT_PAGE_URL);

    InventoryPage inventoryPage = new InventoryPage(driver);
    inventoryPage.clickOnAddToCartButton();
    String addedProductCount = inventoryPage.cartIconText();
    assertion.assertEquals(addedProductCount,"1",PRODUCT_COUNT_MISMATCH);



    assertion.assertAll();



}

}
