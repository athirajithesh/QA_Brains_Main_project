package pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By viewProduct = By.linkText("Sample Jacket Name");
    By addToCartButton = By.cssSelector(".add-cart button");
    By productTitle = By.tagName("h1");
    By productImage = By.tagName("img");
    By productPrice = By.xpath("//*[contains(text(),'$')]");
    By cartIcon = By.xpath("//span[contains(@class,'rounded')]");
  

    // Open product
    public void openProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(viewProduct)).click();
    }

    // Add to cart
    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    // Verify product title
    public boolean isProductTitleDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle)).isDisplayed();
    }

    // Verify product image
    public boolean isProductImageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productImage)).isDisplayed();
    }

    // Verify product price
    public boolean isProductPriceDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).isDisplayed();
    }

    public void addProductToCart(String productName) {

        // Click on the product using dynamic locator
        By productLink = By.linkText(productName);
        wait.until(ExpectedConditions.elementToBeClickable(productLink)).click();

        // Click Add to Cart
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();

        // Navigate back to product list 
        driver.navigate().back();
    }

    public boolean isCartUpdated() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartIcon)).isDisplayed();
    }
    
}
