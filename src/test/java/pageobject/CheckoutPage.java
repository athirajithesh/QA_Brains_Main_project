package pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		
		this.driver=driver;
	}
	

	By firstname = By.xpath("//input[@placeholder='Ex. John']");
	By lastname = By.xpath("//input[@placeholder='Ex. Doe']");
	By zipcode = By.xpath("//label[text()='Zip Code']/following-sibling::input");
	By continueBtn = By.xpath("//span[normalize-space()='Continue']/parent::button");
	By finishBtn = By.xpath("//span[normalize-space()='Finish']/parent::button");
	
	public void enterFirstName(String fname) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstname));
		driver.findElement(firstname).sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastname));
		driver.findElement(lastname).sendKeys(lname);
	}
	
	public void enterZipCode(String zip) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement zipInput = wait.until(ExpectedConditions.elementToBeClickable(zipcode));
		zipInput.clear();
		zipInput.sendKeys(zip);
		
	}
	
	public void placeOrder() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btn);
        
        WebElement finishbtn = wait.until(ExpectedConditions.elementToBeClickable(finishBtn));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", finishbtn);
        

	}

}
