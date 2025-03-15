package DataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Datadriven {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() {
		
		driver = new ChromeDriver();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
}
	
	@Test(dataProvider = "data")
	public void herokulogin(String username , String password) {
		
		// For Username
		driver.findElement(By.id("username")).sendKeys(username);
		
		//For PAssword
		driver.findElement(By.id("password")).sendKeys(password);

		//For Clicking on Login Button
		driver.findElement(By.id("submit")).click();		

	}
	
	//Step 2 : Data provider through 2D array
	
	@org.testng.annotations.DataProvider(name = "data")
	public Object[][] data(){
		
		return new Object[][] {
			
			new Object[] {"stu","password"},
			new Object[] {"student","pass123"},
			new Object[] {"student","Password"},
			new Object[] {"","Password123"},
			new Object[] {"student",""},
			new Object[] {"student","Password123"},
	
		};
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		


		driver.close();
		
	}


}
