package testclasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobject.CartPage;
import pageobject.CheckoutPage;
import pageobject.LoginPage;
import pageobject.ProductPage;
import utils.BaseTest;

public class CheckoutTest extends BaseTest {
	
	@Test
	
	public void checkoutTestWithZipCode() {
		
		LoginPage login = new LoginPage(driver);
		ProductPage product = new ProductPage(driver);
		CartPage cart = new CartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		
		login.login("test@qabrains.com", "Password123");
		
		product.openProduct();
		product.addToCart();
		
		cart.clickCartIcon();
		cart.clickCheckout();
	
		checkout.enterFirstName("Manju");
		checkout.enterLastName("Praveen");
		checkout.enterZipCode("12345");
		checkout.placeOrder();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement successMsg = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//*[contains(text(),'Thank you for your order')]")));

	    Assert.assertTrue(successMsg.isDisplayed(), "Checkout is unsuccessful");
		
	}
	
	@Test
	public void checkoutWithoutZipCodeTest() {
	    LoginPage login = new LoginPage(driver);
	    ProductPage product = new ProductPage(driver);
	    CartPage cart = new CartPage(driver);
	    CheckoutPage checkout = new CheckoutPage(driver);

	    // Login
	    login.login("test@qabrains.com", "Password123");

	    // Add product to cart and go to checkout
	    product.openProduct();
	    product.addToCart();
	    cart.clickCartIcon();
	    cart.clickCheckout();

	    // Enter only first and last name, skip Zip Code
	    checkout.enterFirstName("Manju");
	    checkout.enterLastName("Praveen");
	    checkout.placeOrder();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement successMsg = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//*[contains(text(),'Thank you for your order')]")));

	    Assert.assertTrue(successMsg.isDisplayed(), "Checkout is unsuccessful");
	}
	 
}
