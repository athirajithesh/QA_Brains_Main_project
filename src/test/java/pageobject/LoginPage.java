package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By email = By.id("email");
    By password = By.id("password");
    By loginBtn = By.xpath("//button[@type='submit']");

    // Methods 
    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        WebElement btn = driver.findElement(loginBtn);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btn);
    }

    // Combined login method
    public void login(String mail, String pass) {
        enterEmail(mail);
        enterPassword(pass);
        clickLogin();
    }
}
