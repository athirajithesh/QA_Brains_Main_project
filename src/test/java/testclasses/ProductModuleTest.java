package testclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobject.LoginPage;
import pageobject.ProductPage;
import utils.BaseTest;

public class ProductModuleTest extends BaseTest {

	
	@BeforeMethod
	public void verifyLoginPageOpens() {
	    LoginPage login = new LoginPage(driver);
	    login.login("test@qabrains.com", "Password123");

	}
	
	@Test
	public void verifyProductPageOpens() {

	    ProductPage product = new ProductPage(driver);
	    product.openProduct();

	    Assert.assertTrue(product.isProductTitleDisplayed(),
	            "Product page did not open");
	}
	
	@Test
	public void verifyAddToCartButtonDisplayed() {

	    ProductPage product = new ProductPage(driver);
	    product.openProduct();

	    WebElement addToCartBtn = driver.findElement(By.cssSelector(".add-cart button"));

	    Assert.assertTrue(addToCartBtn.isDisplayed(),
	            "Add to Cart button not visible");
	}
	
	@Test
	public void verifyProductAddedToCart() {

	    ProductPage product = new ProductPage(driver);

	    product.openProduct();
	    product.addToCart();

	    WebElement cartCount = driver.findElement(By.xpath("//span[contains(@class,'rounded')]"));

	    Assert.assertTrue(cartCount.isDisplayed(),
	            "Product not added to cart");
	}
	
	@Test
	public void verifyProductImageDisplayed() {

	    ProductPage product = new ProductPage(driver);
	    product.openProduct();

	    WebElement productImage = driver.findElement(By.tagName("img"));

	    Assert.assertTrue(productImage.isDisplayed(),
	            "Product image not displayed");
	}
	
	@Test
	public void verifyProductTitleDisplayed() {

	    ProductPage product = new ProductPage(driver);
	    product.openProduct();

	    WebElement productTitle = driver.findElement(By.tagName("h1"));

	    Assert.assertTrue(productTitle.isDisplayed(),
	            "Product title not displayed");
	}
	
	@Test
	public void verifyProductPriceDisplayed() {

	    ProductPage product = new ProductPage(driver);
	    product.openProduct();

	    WebElement productPrice = driver.findElement(By.xpath("//*[contains(text(),'$')]"));

	    Assert.assertTrue(productPrice.isDisplayed(),
	            "Product price not displayed");
	}
	
	@Test
	public void verifyMultipleProductsAddedToCart() {

	    ProductPage product = new ProductPage(driver);

	    product.addProductToCart("Sample Jacket Name");
	    product.addProductToCart("Sample Shirt Name");

	    Assert.assertTrue(product.isCartUpdated(),
	            "Multiple products not added to cart");
	}
	
}
