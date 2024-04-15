package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementScreenshot {
	
	
    @Test
	public void setup() {
		
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	
    	driver.get("https://automationtesting.in");
    	Shutterbug.shootPage(driver).withName("First Screenshot");
	}
}
