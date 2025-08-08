/*** Automation practice for "https://rahulshettyacademy.com/dropdownsPractise/" WebPage >> Automate Dynamic DropDowns and Calendars  ***/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // To open and make the options visible for the first dynamic dropdown

		driver.findElement(By.xpath("//a[@value='BLR']")).click(); // To select Bengaluru option from first dynamic dropdown

		Thread.sleep(1000);

		//	driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); // (xpath)[index] format is used for selecting Chennai value from 2nd dynamic dropdown to avoid script failure

		//Alternative for above written Xpath if use of Indexing is prohibited to use then we can use Parent Child Relationship Xpath as written below
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); //(Parent xpath) //(Child xpath)Relationship format is used for selecting Chennai value from 2nd dynamic dropdown to avoid script failure

		//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR'] >> From dropdown Xpath using Parent Child Relationship

		//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA'] >> To dropdown Xpath using Parent Child Relationship
	
	
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click(); // cssSelector >> To select the Current Date from Depart Date calendar field	
	
	   
		driver.quit();
	
	}

}
