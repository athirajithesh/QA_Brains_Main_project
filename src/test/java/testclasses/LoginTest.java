package testclasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.LoginPage;
import utils.BaseTest;


public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void loginTest1() {

        LoginPage login = new LoginPage(driver);
        login.login("test@qabrains.com", "Password123");
        
        String currentUrl =driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("ecommerce"), "Login test 1 failed");
       
    }

    @Test(priority = 2)
    public void loginTest2() {

        LoginPage login = new LoginPage(driver);
        login.login("practice@qabrains.com", "Password123");
        
        String currentUrl =driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("ecommerce"), "Login test 2 failed");

    }

    @Test(priority = 3)
    public void loginTest3() {

        LoginPage login = new LoginPage(driver);
        login.login("student@qabrains.com", "Password123");
        
        String currentUrl =driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("ecommerce"), "Login test 3 failed");

    }

    @Test(priority = 4)
    public void invalidLoginTest() {

        LoginPage login = new LoginPage(driver);
        login.login("abc@gmail.com", "pass123");
        
        String currentUrl =driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("ecommerce"), "Invalid Login test failed");

    }

    @Test(priority = 5)
    public void blankInputs() {

        LoginPage login = new LoginPage(driver);
        login.login("", "");
        
        String currentUrl =driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("ecommerce"), "Blank input test failed");

    }
}
