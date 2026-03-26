package testclasses;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobject.CartPage;
import pageobject.LoginPage;
import pageobject.ProductPage;
import utils.BaseTest;

public class CartTest extends BaseTest {
	
	ProductPage product;
    CartPage cart;

    @BeforeMethod
    public void validLogin() {
        LoginPage login = new LoginPage(driver);
        login.login("test@qabrains.com", "Password123");

        product = new ProductPage(driver);
        cart = new CartPage(driver);

        // Add product to cart
        product.addProductToCart("Sample Jacket Name");
        //product.addToCart();
    }

    @Test(priority = 1)
    public void verifyProductAddedToCart() {

        cart.clickCartIcon();

        String actualProduct = cart.getProductName();
        Assert.assertEquals(actualProduct, "Sample Jacket Name",
                "Product name mismatch in cart");
    }

    @Test(priority = 2)
    public void verifyProductDisplayedInCart() {

        cart.clickCartIcon();

        Assert.assertTrue(cart.getProductName().contains("Sample Jacket Name"),
                "Product not displayed in cart");
    }

   
    @Test(priority = 3)
    public void verifyRemoveProductFromCart() {
        cart.clickCartIcon();

        // Wait for product to appear before trying to remove
        Assert.assertTrue(cart.getProductName().contains("Sample Jacket Name"),
                "Product not visible before removal");

        cart.removeProduct();

        Assert.assertTrue(cart.isCartEmpty(), "Product was not removed from cart");
    }


    @Test(priority = 4)
    public void verifyCheckoutButton() {

        cart.clickCartIcon();
        cart.clickCheckout();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"),
                "Checkout page not opened");
    }
}

	