package com.saucedemo.testcases;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.utilities.PropertiesUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import static com.saucedemo.constants.AssertionConstants.*;
import static com.saucedemo.constants.GlobalConstants.*;

public class LoginTest extends BaseTest{

@Test(dataProvider = "Login data" , groups = {"smokeTest"})
public void loginWithValidUser(String username, String password){
    SoftAssert assertion = new SoftAssert();
    LoginPage loginPage = new LoginPage(driver);
    loginPage.loginToApplication(username, password);
    String currentUrl = loginPage.getCurrentPageUrl();
    assertion.assertTrue(currentUrl.contains(INVENTORY_URL_ROUTE), INCORRECT_PAGE_URL);

    assertion.assertAll();
}

    @DataProvider(name = "Login data")
    public Object[][] getLoginCredentials(){
        Object[][] loginData = {
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
        return loginData;




}

}
