package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

	
public class DemoBaseTest {
	protected WebDriver driver;		
		@BeforeMethod
		public void setup() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://practice.qabrains.com");
		}
		
		@AfterMethod
		public void teardown() {
			driver.quit();
		}

}
