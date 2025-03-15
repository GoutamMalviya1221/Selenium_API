package WindowHandles;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class WindowHandle {

	public static void main(String[] args) {
       
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#Open%20New%20Tab");
        driver.manage().window().maximize();

        
        String mainWindow = driver.getWindowHandle();

    
        WebElement openNewWindowLink = driver.findElement(By.xpath("//a[text()='Click Here']"));
        openNewWindowLink.click();

      
        Set<String> allWindows = driver.getWindowHandles();

      
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

       
        System.out.println("New Window Title: " + driver.getTitle());

       
        driver.switchTo().window(mainWindow);
        System.out.println("Switched back to Main Window: " + driver.getTitle());

        driver.quit();
    }

}
