/***    Assignment Exercise on DropDown handling using Select and Edit boxes, links & button selections   ***/

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class Sec7_Assignment_Exercise_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String name= "ABC";

		String email= "ABC@gmail.com";

		String password= "Testing@123";

		String dob= "01-05-1990";

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// To enter Name
		driver.findElement(By.xpath("//input[@name='name'] [@minlength='2']")).sendKeys(name);
		Thread.sleep(300);

		// To enter Email
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
		Thread.sleep(300);

		// To enter Password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
		Thread.sleep(300);

		// To click CheckBox
		driver.findElement(By.cssSelector("input[id='exampleCheck1']")).click();
		Thread.sleep(300);

		System.out.println("The status of CheckBox selection is: "+driver.findElement(By.cssSelector("input[id='exampleCheck1']")).isSelected());

		// To select option from DropDown
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));

		Select value = new Select(dropdown);
		Thread.sleep(300);

		value.selectByVisibleText("Female");

		System.out.println("Current Selected Value in the DropDown is: "+value.getFirstSelectedOption().getText());
		Assert.assertEquals(value.getFirstSelectedOption().getText(), "Female");

		// To select RadioButton
		driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
		Thread.sleep(300);

		System.out.println("Status of Student Radio Button selection is: "+driver.findElement(By.xpath("//input[@id='inlineRadio1']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='inlineRadio1']")).isSelected());

		// To enter Date of Birth
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys(dob);
		Thread.sleep(300);

		// To click on Submit button
		driver.findElement(By.className("btn-success")).click();
		Thread.sleep(300);

		Actions act = new Actions(driver); // To Scroll the WebPage Up using Actions class
		act.sendKeys(Keys.PAGE_UP).perform();
		Thread.sleep(700);

		// To print the final success message on console (Excluding "x")

		String text1= driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText().substring(1).trim();

		System.out.println("Final message post submission of ProtoCommerce form for "+name+" is: "+text1); 


		driver.quit();

	}

}
