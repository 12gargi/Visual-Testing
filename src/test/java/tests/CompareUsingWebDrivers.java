package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CompareUsingWebDrivers {

WebDriver driver;
	
	@BeforeMethod
	public void beforeClass() throws IOException
	{
		WebDriverManager.chromedriver().setup();

       
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
        driver.get("https://applitools.com/helloworld/");

        
	}
	
	@Test
    public void compareImages() throws IOException {

        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File outputFile = new File("C:\\Users\\TESTRIG\\eclipse-workspace\\JavaSeleniumDemo-main\\WebManagerSS\\screenshot1.PNG");
        FileUtils.copyFile(screenshotFile, outputFile);

        File baselineImage = new File("./Screenshots/refrenceImage1.png");
        File actualImage = new File("screenshot1.png");

        boolean imagesMatch = compareImages(baselineImage, actualImage);

        if (imagesMatch ==true) {
            System.out.println("Images match. No differences found.");
        } else {
            System.out.println("Images do not match. Differences found.");
        }

        driver.quit();
    }

    private static boolean compareImages(File baselineImage, File actualImage) {
        try {
            BufferedImage baseline = ImageIO.read(baselineImage);
            BufferedImage actual = ImageIO.read(actualImage);

            if (baseline.getWidth() != actual.getWidth() || baseline.getHeight() != actual.getHeight()) {
                return false;
            }

            for (int x = 0; x < baseline.getWidth(); x++) {
                for (int y = 0; y < baseline.getHeight(); y++) {
                    int rgbBaseline = baseline.getRGB(x, y);
                    int rgbActual = actual.getRGB(x, y);

                    if (rgbBaseline != rgbActual) {
                        return false;
                    }
                }
            }

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @AfterMethod
    public void tearUp()
    {
    	  driver.quit();
    }
}