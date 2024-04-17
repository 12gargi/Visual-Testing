package appTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.percy.selenium.Percy;



//import io.percy.selenium.Percy;

public class AppTest {
    private static final String TEST_URL = "https://todomvc.com/examples/react/dist/";
    private static WebDriver driver;
    private static Percy percy;

    @BeforeEach
    public void startAppAndOpenBrowser() throws IOException {
 
    	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
//    	ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
//        driver = new ChromeOptions(options);
        driver = new ChromeDriver();
        driver.get(TEST_URL);
      
        driver.manage().window().maximize();
 
      
        percy = new Percy(driver);
    }

    @AfterEach
    public void closeBrowser() {
     
        driver.quit();
               
    }

    @Test
    public void loadsHomePage() {
        
        WebElement element = driver.findElement(By.className("todoapp"));
        assertNotNull(element);

        percy.snapshot("Home Page");
    }

    @Test
    public void acceptsANewTodo() {
        

        List<WebElement> todoEls = driver.findElements(By.cssSelector(".todo-list li"));
        assertEquals(0, todoEls.size());

        WebElement newTodoEl = driver.findElement(By.className("new-todo"));
        newTodoEl.sendKeys("A todo tool!");
        newTodoEl.sendKeys(Keys.RETURN);

        todoEls = driver.findElements(By.cssSelector(".todo-list li"));
        assertEquals(1, todoEls.size());

        percy.snapshot("One todo", Arrays.asList(768, 992, 1200));
    }

    @Test
    public void letsYouCheckOffATodo() {
        

        WebElement newTodoEl = driver.findElement(By.className("new-todo"));
        newTodoEl.sendKeys("A new todo ");
        newTodoEl.sendKeys(Keys.RETURN);

        WebElement todoCountEl = driver.findElement(By.className("todo-count"));
        assertEquals("1 item left!", todoCountEl.getText());

        driver.findElement(By.cssSelector("input.toggle")).click();

        todoCountEl = driver.findElement(By.className("todo-count"));
        assertEquals("0 items left!", todoCountEl.getText());

        
        percy.snapshot("Checked off todo", null, 2000);
    }
}