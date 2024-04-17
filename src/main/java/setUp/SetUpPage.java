package setUp;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetUpPage {
    public static WebDriver driver;
    ChromeOptions options = new ChromeOptions();
    EdgeOptions edgeoptions = new EdgeOptions();
	
    @Parameters("browser")
	@BeforeMethod
	public void setUpMethod(String browser) throws IOException, InterruptedException
	{
    	if(browser.equalsIgnoreCase("chrome")) {
    		WebDriverManager.chromedriver().setup();
    		driver = new ChromeDriver();
    		System.out.println("Chrome driver launch");
    	}
    	
    	else if(browser.equalsIgnoreCase("edge"))
    	{
    		WebDriverManager.edgedriver().setup();
    		driver = new EdgeDriver();
    		System.out.println("Edge driver launch");
    	}
    	
    	driver.get("https://applitools.com/helloworld/");
    	Thread.sleep(5000);
//        driver = new ChromeDriver();
////        ChromeOptions options = new ChromeOptions();
////		options.addArguments("--headless");
////		driver = new ChromeDriver(options);
         
	}
	
	 @AfterMethod
	    public void tearUp()
	    {
	    	  driver.quit();
	    }
}
