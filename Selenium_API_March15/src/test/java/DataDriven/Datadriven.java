package DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Datadriven {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://practicetestautomation.com/practice-test-login/");
			
			driver.manage().window().maximize();
			// Step 1: read an external file using  FileInputStream class
			FileInputStream fis= new FileInputStream("C:\\Users\\lenovo\\Documents\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\Selenium_API_March15\\src\\main\\resources\\DataD.xlsx");
			
	       // Step 2: Use APachePoi libraries to connect with excel - WorkcookFactory.
			Workbook Book = WorkbookFactory.create(fis); // this will create a new instance of workbook
			
			// fetch values from excel from
			String Username = Book.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
			String password = Book.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
			
			driver.findElement(By.id("username")).sendKeys(Username);
			driver.findElement(By.id("password")).sendKeys(password);
			
			driver.findElement(By.xpath("//button[@id='submit']")).click();

		
			driver.quit();
		}

}
