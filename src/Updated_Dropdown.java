/*** Automation practice for "https://rahulshettyacademy.com/dropdownsPractise/" WebPage >> Automate various DropDowns and CheckBox  ***/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Updated_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		//*** Code for CheckBox locator finding and to know the its status whether its selected or not

		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // assertFalse >> Checks if Condition is returning False result only
		//** Commented below line of code due to above alternate line of code of TestNG Assertion (assertFalse) to validate if CheckBox is selected or not
		//System.out.println("Status of CheckBox (When Not Selected): "+driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // isSelected >> To know if the CheckBox is NOT selected and print the information accordingly on console

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click(); // id* >> Partial ID value is used for getting CheckBox element by CssSelector with * (which represents regular expression into cssSelector)

		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // assertTrue >> Checks if Condition is returning True result only
		//** Commented below line of code due to above alternate line of code of TestNG Assertion (assertTrue) to validate if CheckBox is selected or not
		//System.out.println("Status of CheckBox (When Selected): "+driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected()); // isSelected >> To know if the CheckBox is Selected and print the information accordingly on console


		//*** Code for getting the status of Radio buttons & Calendars (Enabled/Disabled) present on the WebPage

		System.out.println("Return Date Calendar field status before Radio button Selection is: "+driver.findElement(By.id("Div1")).getDomAttribute("style"));

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		System.out.println("Return Date Calendar field status post Radio button Selection is: "+driver.findElement(By.id("Div1")).getDomAttribute("style"));

		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("1")) // getDomAttribute & contains >> Used for getting the changing attribute value based on Selection of radio buttons
		{
			System.out.println("Calendar field of Return Date is Enabled...");
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}


		//*** Code for to get the total count of CheckBoxes present on the WebPage

		System.out.println("Count of the total number of CheckBoxes are: "+driver.findElements(By.cssSelector("input[type='checkbox']")).size()); // findElements and size methods >> Used for getting all the CheckBoxes present on the WebPage and print its size on the console


		// *** Continued code for DropDown functionalities ***//
		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(1000);
		/*
		int i=1;
		while (i < 5) //Condition To click Passengers field- Adult + button 4 times
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		} */

		System.out.println("Passengers dropdown text value without selection is: "+driver.findElement(By.id("divpaxinfo")).getText()); // To print the text of Passengers field without any selections on console

		for (int i=1; i < 5; i++) //Condition To click Passengers field- Adult + button 4 times (Instead of While-Loop we used For-Loop)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click(); // To click DONE button post selecting 4 Adults

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult"); // assertEquals >> (Actual Text, "Expected Text")
		//** Commented below line of code due to above alternate line of code of TestNG Assertion (assertEquals) to validate if DropDown value post selection is showing expected text or not
		//System.out.println("Passengers dropdown text value post selection is: "+driver.findElement(By.id("divpaxinfo")).getText()); // To print the text of Passengers field after selecting 4 Adults on console


		driver.quit();
	}

}
