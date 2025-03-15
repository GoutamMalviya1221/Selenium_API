package iframe;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe_Screenshot {

	 public static void main(String[] args) {

	      
		 WebDriver driver = new ChromeDriver();
	    
	            // Step 1: Open the webpage
	            driver.get("https://demo.automationtesting.in/Frames.html");
	            driver.manage().window().maximize();

	            // Step 2: Handle Single Frame
	            driver.switchTo().frame("singleframe"); // Switch to single frame
	            WebElement inputField = driver.findElement(By.xpath("//input[@type='text']"));
	            inputField.sendKeys("Testing Single Frame");
	            
	            // Take screenshot of single frame
	            takeScreenshot(driver, "single_frame.png");

	            // Switch back to main content
	            driver.switchTo().defaultContent();

	            // Step 3: Handle Nested Frames
	            WebElement nestedFrameTab = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
	            nestedFrameTab.click();

	            // Switch to outer frame
	            WebElement outerFrame = driver.findElement(By.xpath("//div[@id='Multiple']//iframe"));
	            driver.switchTo().frame(outerFrame);

	            // Switch to inner frame
	            WebElement innerFrame = driver.findElement(By.xpath("//iframe"));
	            driver.switchTo().frame(innerFrame);

	            // Locate input field inside inner frame and enter text
	            WebElement nestedInputField = driver.findElement(By.xpath("//input[@type='text']"));
	            nestedInputField.sendKeys("Testing Nested Frame");

	            // Take screenshot of nested frame
	            takeScreenshot(driver, "nested_frame.png");

	            // Switch back to outer frame, then main content
	            driver.switchTo().parentFrame();
	            driver.switchTo().defaultContent();

	       
	            // Close browser
	            driver.quit();
	        }
	    

	    // Method to take screenshots
	    public static void takeScreenshot(WebDriver driver, String fileName) {
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        try {
	            FileUtils.copyFile(srcFile, new File(fileName));
	            System.out.println("Screenshot saved: " + fileName);
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot: " + e.getMessage());
	        }
	    }

}
