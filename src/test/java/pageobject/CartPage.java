package pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

 // Locators
    By cartIcon = By.xpath("//*[name()='path' and contains(@d,'M528.12 30')]"); 
    By productName = By.xpath("//div[contains(@class,'cart')]//h3");
    By removeButton = By.xpath("//button[contains(@class,'text-red')]");
   // By confirmRemove = By.xpath("//button[contains(text(),'Remove')]");
    By confirmRemove = By.xpath("//div[@role='dialog']//button[contains(text(),'Remove')]");
    By checkoutBtn = By.xpath("//button[normalize-space()='Checkout']");
    By emptyCartMsg = By.xpath("//h1[normalize-space()='Your cart is empty.']");
    //By cartCount = By.xpath("//span[contains(@class,'rounded-2xl') and text()]");

    // Click cart icon
    public void clickCartIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
    }

    // Get product name
    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    // Remove product
    public void removeProduct() {

        // Click remove icon
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();

        // Wait for confirm popup button
        WebElement confirmBtn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(confirmRemove)
        );

        //Click confirm using JS 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", confirmBtn);

        //Wait for empty cart message
        wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMsg));
    }
    
    // Verify cart empty
    public boolean isCartEmpty() {
        return driver.findElements(productName).isEmpty();
    }
    
    // Click checkout
    public void clickCheckout() {

        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();

        wait.until(ExpectedConditions.urlContains("checkout"));
    }
  
}
	