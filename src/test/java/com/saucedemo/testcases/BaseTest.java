package com.saucedemo.testcases;

import com.saucedemo.utilities.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.saucedemo.constants.GlobalConstants.*;

public class BaseTest {

     public static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setup() throws IOException {
        launchBrowser();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-features=PasswordLeakDetection");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(
                PropertiesUtils.readFromProperties(IMPLICIT_WAIT))));
        driver.get(PropertiesUtils.readFromProperties(URL));
    }

    private void launchBrowser() throws IOException {
        String browserValue = PropertiesUtils.readFromProperties("browser");
        if(browserValue.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            String incognitoValue = PropertiesUtils.readFromProperties("incognito");
            if(incognitoValue.equalsIgnoreCase("true")){
                options.addArguments("--incognito");
            }
            driver = new ChromeDriver(options);
        } else if (browserValue.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            String incognitoValue = PropertiesUtils.readFromProperties("incognito");
            if(incognitoValue.equalsIgnoreCase("true")){
                options.addArguments("-private");
            }
            driver = new FirefoxDriver(options);
        } else {
            System.out.println("Invalid browser name !!! ");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
            driver.quit();
        }


}
