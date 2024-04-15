package tests;
//import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.fluent.Target;



public class TestCase {
    WebDriver driver;
    Eyes eyes;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
    	eyes = new Eyes();
    	eyes.setApiKey(System.getenv("mCrTSzISW6K8FLAjxgA4SVbTgvf46It8cYLFBIGfwQI110"));
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
         driver = new ChromeDriver();
         driver.get("https://applitools.com/helloworld/");
        
         driver.manage().window().maximize();
        
         eyes.open(driver,"Visual Test",testInfo.getTestMethod().get().getName(),new RectangleSize (1000,600));
         

         


         
         
    }
    @Test
    public void myTestCase() {
        
        WebElement numbers = driver.findElement(By.cssSelector("span.primary"));
        WebElement button = driver.findElement(By.cssSelector("div.section:nth-child(3) > button:nth-child(1)"));
        WebElement titleH = driver.findElement(By.cssSelector("div.fancy:nth-child(1) > span:nth-child(1)"));
        WebElement titleD = driver.findElement(By.cssSelector("div.fancy:nth-child(1) > span:nth-child(11)"));

        Assertions.assertEquals(numbers.isDisplayed(), true);
        Assertions.assertEquals(numbers.getText(), "123456");
        Assertions.assertEquals(numbers.getCssValue("color"), "rgba(78, 90, 99, 1)");

        Assertions.assertEquals(button.isDisplayed(), true);
        Assertions.assertEquals(button.getText(), "Click me!");
        Assertions.assertEquals(button.getCssValue("color"), "rgba(255, 255, 255, 1)");

        Assertions.assertEquals(titleH.isDisplayed(), true);
        Assertions.assertEquals(titleH.getText(), "H");
        Assertions.assertEquals(titleH.getCssValue("color"), "rgba(255, 0, 0, 1)");

        Assertions.assertEquals(titleD.isDisplayed(), true);
        Assertions.assertEquals(titleD.getText(), "D");
        Assertions.assertEquals(titleD.getCssValue("color"), "rgba(70, 0, 255, 1)");
        
        eyes.check(Target.window());
    }

    @AfterEach
    public void tearDown() {
    	eyes.closeAsync();
        driver.close();
    }
}
