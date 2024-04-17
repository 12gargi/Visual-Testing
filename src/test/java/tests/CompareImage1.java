package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import setUp.SetUpPage;
import ru.yandex.qatools.ashot.comparison.ImageDiff;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class CompareImage1 extends SetUpPage {
	
//	WebDriver driver ;

    @Test
    public void testComparePageusingRefrenceImage() throws IOException {
        
    	Screenshot screenshot1 = new AShot().takeScreenshot(driver);
        File outputFile01 = new File("./Screenshots/output01-image.png");
        ImageIO.write(screenshot1.getImage(), "png",outputFile01);
        BufferedImage actualImage = ImageIO.read(outputFile01);
        

        BufferedImage referenceImage = ImageIO.read(new File("./Screenshots/refrenceImage1.png"));
        ImageDiffer differ = new ImageDiffer();
        ImageDiff diff = differ.makeDiff(referenceImage, actualImage); 
        
        if (diff.hasDiff()==true) {
        	File diffImageFile = new File("./Screenshots/DifferenceImage0.png");
            ImageIO.write(diff.getMarkedImage(), "png", diffImageFile);
            System.out.println("Differences found. Output image saved to Screenshots"+Thread.currentThread().getId());
        } else {
            System.out.println("No differences found."+Thread.currentThread().getId());
        }

        
      
    }
    
    
    @Test
    public void validatingForSameScreenshot() throws IOException
    {
    	Screenshot screenshot2 = new AShot().takeScreenshot(driver);
        File outputFile02 = new File("./Screenshots/SameSS_1-image.png");
        ImageIO.write(screenshot2.getImage(), "png",outputFile02);
        BufferedImage refImage = ImageIO.read(outputFile02);
        
        Screenshot screenshot3 = new AShot().takeScreenshot(driver);
        File outputFile03 = new File("./Screenshots/SameSS_2-image.png");
        ImageIO.write(screenshot3.getImage(), "png",outputFile03);
        BufferedImage actuallImage = ImageIO.read(outputFile03);
        
        ImageDiffer differ = new ImageDiffer();
        ImageDiff diff = differ.makeDiff(refImage, actuallImage);
  
        if (diff.hasDiff()==true) {
            System.out.println("Differences found. Output image saved to Screenshots"+Thread.currentThread().getId() );
        } else {
            System.out.println("No differences found."+Thread.currentThread().getId());
        }
       
    }
    
    @Test
    public void validatingForDifferentElemnt() throws IOException
    {
    	WebElement clickMeBtn = driver.findElement(By.xpath("/html/body/div[1]/div[3]/button"));
        clickMeBtn.click();
    	
    	Screenshot screenshot4 = new AShot().takeScreenshot(driver);
        File outputFile02 = new File("./Screenshots/EleNfullSS_1-image.png");
        ImageIO.write(screenshot4.getImage(), "png",outputFile02);
        BufferedImage reffImage = ImageIO.read(outputFile02);
        
        WebElement diff1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/p[2]/a"));
        diff1.click();
        
        Screenshot screenshot5 = new AShot().takeScreenshot(driver);
        File outputFile03 = new File("./Screenshots/EleNFull_2-image.png");
        ImageIO.write(screenshot5.getImage(), "png",outputFile03);
        BufferedImage actImage = ImageIO.read(outputFile03);
        
        ImageDiffer differ = new ImageDiffer();
        ImageDiff diff = differ.makeDiff(reffImage, actImage);
        
        if(diff.hasDiff()==true) {
        	File diffImageFile = new File("./Screenshots/DifferenceImage.png"+Thread.currentThread().getId());
            ImageIO.write(diff.getMarkedImage(), "png", diffImageFile);
            System.out.println("Differences found. Output image saved to Screenshots"+Thread.currentThread().getId() );
        } else {
            System.out.println("No differences found.");
        }
    }
    
    @Test
    public void validatingForComparisonbetweenBaseImageAndActionElement() throws IOException
    {
    	Screenshot screenshot1 = new AShot().takeScreenshot(driver);
        File outputFile1 = new File("./Screenshots/FullPageScreenshot.png");
        ImageIO.write(screenshot1.getImage(), "png", outputFile1);
        BufferedImage referenceImage = ImageIO.read(outputFile1);

       
        WebElement clickMeBtn = driver.findElement(By.xpath("/html/body/div[1]/div[3]/button"));
        clickMeBtn.click();

     
        Screenshot screenshot2 = new AShot().takeScreenshot(driver);
        File outputFile2 = new File("./Screenshots/UpdatedPageScreenshot.png");
        ImageIO.write(screenshot2.getImage(), "png", outputFile2);
        BufferedImage actualImage = ImageIO.read(outputFile2);

       
        ImageDiffer differ = new ImageDiffer();
        ImageDiff diff = differ.makeDiff(referenceImage, actualImage);

        if (diff.hasDiff()) {
            File diffImageFile = new File("./Screenshots/DifferenceImageforEle2.png");
            ImageIO.write(diff.getMarkedImage(), "png", diffImageFile);
            System.out.println("Differences found. Output image saved to Screenshots" +Thread.currentThread().getId());
        } else {
            System.out.println("No differences found."+Thread.currentThread().getId());
        }
    }
    
    @Test
    public void validatingForSameElements() throws IOException
    {
    	WebElement clickMeBtn = driver.findElement(By.xpath("/html/body/div[1]/div[3]/button"));
        clickMeBtn.click();
    	
    	Screenshot screenshot = new AShot().takeScreenshot(driver);
        File outputFile04 = new File("./Screenshots/Clickme_1-image.png");
        ImageIO.write(screenshot.getImage(), "png",outputFile04);
        BufferedImage reffImage = ImageIO.read(outputFile04);
        
        
        Screenshot screenshotsame = new AShot().takeScreenshot(driver);
        File outputFile05 = new File("./Screenshots/Clickme_2-image.png");
        ImageIO.write(screenshotsame.getImage(), "png",outputFile05);
        BufferedImage actualllImage = ImageIO.read(outputFile05);
        
        ImageDiffer differ = new ImageDiffer();
        ImageDiff diff = differ.makeDiff(reffImage, actualllImage);
        
        if (diff.hasDiff()) {
            File diffImageFile = new File("./Screenshots/DifferenceImageSame.png");
            ImageIO.write(diff.getMarkedImage(), "png", diffImageFile);
            System.out.println("Differences found. Output image saved to Screenshots"+Thread.currentThread().getId() );
        } else {
            System.out.println("No differences found."+Thread.currentThread().getId());
        }
        
        
    }
    
    @Test
    public void validatingForDifferentPages() throws IOException
    {
    	WebElement diff1 = driver.findElement(By.xpath("/html/body/div[1]/div[2]/p[2]/a"));
        diff1.click();
        
        Screenshot screenshot6 = new AShot().takeScreenshot(driver);
        File outputFile04 = new File("./Screenshots/diffPage_1-image.png");
        ImageIO.write(screenshot6.getImage(), "png",outputFile04);
        BufferedImage refffImage = ImageIO.read(outputFile04);
    	
    	WebElement diff2 =driver.findElement(By.xpath("/html/body/div[1]/div[2]/p[3]/a"));
    	diff2.click();
    	
    	Screenshot screenshot7 = new AShot().takeScreenshot(driver);
        File outputFile05 = new File("./Screenshots/diffPage_2-image.png");
        ImageIO.write(screenshot7.getImage(), "png",outputFile05);
        BufferedImage actllImage = ImageIO.read(outputFile05);
        
        ImageDiffer differ = new ImageDiffer();
        ImageDiff diff = differ.makeDiff(refffImage, actllImage);
        
        if (diff.hasDiff()) {
            File diffImageFile = new File("./Screenshots/DifferencePage.png");
            ImageIO.write(diff.getMarkedImage(), "png", diffImageFile);
            System.out.println("Differences found. Output image saved to Screenshots"+Thread.currentThread().getId() );
        } else {
            System.out.println("No differences found."+Thread.currentThread().getId());
        }
        
    }
    
    @Test
    public void test_forDiff2AndFullPage() throws IOException
    {
    	
    	Screenshot screenshot1 = new AShot().takeScreenshot(driver);
        File outputFile01 = new File("./Screenshots/output01-image.png");
        ImageIO.write(screenshot1.getImage(), "png",outputFile01);
        BufferedImage actualImage = ImageIO.read(outputFile01);
    	
    	
    	WebElement diff2 =driver.findElement(By.xpath("/html/body/div[1]/div[2]/p[3]/a"));
    	diff2.click();
    	
//    	Screenshot screenshot7 = new AShot().takeScreenshot(driver);
//        File outputFile05 = new File("./Screenshots/diffPagee_2-image.png");
//        ImageIO.write(screenshot7.getImage(), "png",outputFile05);
//        BufferedImage refrenceeImage = ImageIO.read(outputFile05);
    	Screenshot screenshot7 = new AShot().takeScreenshot(driver);
    	String fileName = "./Screenshots/image_" + System.currentTimeMillis() + ".png";
    	File outputFile05 = new File(fileName);
    	ImageIO.write(screenshot7.getImage(), "png", outputFile05);
    	BufferedImage referenceeImage = ImageIO.read(outputFile05);
    	
        
        ImageDiffer differ = new ImageDiffer();
        ImageDiff diff = differ.makeDiff(referenceeImage, actualImage);
        
        
        if (diff.hasDiff()) {
            File diffImageFile = new File("./Screenshots/DifferencePageDynamic.png");
            ImageIO.write(diff.getMarkedImage(), "png", diffImageFile);
            System.out.println("Differences found. Output image saved to Screenshots" +Thread.currentThread().getId());
        } else {
            System.out.println("No differences found."+Thread.currentThread().getId());
        }
        
    }
    
    }
    
   
       
        

        



