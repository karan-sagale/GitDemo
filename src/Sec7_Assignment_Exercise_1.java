/***    Assignment Exercise on CheckBoxes    ***/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sec7_Assignment_Exercise_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
	   	// Flow for selecting CheckBox 1
		System.out.println("Staus of CheckBox 1 before Selection is: "+driver.findElement(By.id("checkBoxOption1")).isSelected());

		driver.findElement(By.id("checkBoxOption1")).click();

		//Test using Assert - assertTrue
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());

		System.out.println("Staus of CheckBox 1 post Selection is: "+driver.findElement(By.cssSelector("input[value='option1']")).isSelected());

	
		// Flow for De-selecting CheckBox 1 which was already selected

		Thread.sleep(1000);

		driver.findElement(By.id("checkBoxOption1")).click();

		//Test using Assert - assertFalse
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());

		System.out.println("Staus of CheckBox 1 post Deselection is: "+driver.findElement(By.xpath("//input[@name='checkBoxOption1']")).isSelected());

		
		// Count of CheckBoxes present on the WebPage

		System.out.println("Total count of the CheckBoxes Present on WebPage are: "+driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		
		//Test using Assert - assertEquals
		Assert.assertEquals(driver.findElements(By.xpath("//input[@type='checkbox']")).size(),3);

		driver.quit();
	}

}
