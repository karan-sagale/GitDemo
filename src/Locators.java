/*** Automation practice for "https://rahulshettyacademy.com/locatorspractice/" WebPage >> Usage of Locators ***/


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		/* To provide Implicit wait for WebDriver which Specifies the amount of time the driver should wait 
		when searching for an element if it is not immediately present. */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).sendKeys("rahul"); // To enter the user name in Username field using "id" locator

		driver.findElement(By.name("inputPassword")).sendKeys("pass123"); // To enter the password in Password field using "name" locator

		driver.findElement(By.className("signInBtn")).click(); // To click on the Sign In button using "className" locator

		System.out.println(driver.findElement(By.cssSelector("p.error")).getText()); // To get the text of error message using "CssSelector" locator and print

		driver.findElement(By.linkText("Forgot your password?")).click(); // To click on Forgot Password using "linkText" locator

		Thread.sleep(1000); // To pause the execution flow for 1 second using "Thread.sleep" method 

		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John"); // To enter the name using "xpath" locator

		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@email.com"); // To enter the Email using "CssSelector" locator

		driver.findElement(By.xpath("//input[@type='text'][2]")).clear(); // To clear the entered data using "xpath with Index" locator

		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@gmail.com"); // To enter the Email using "CssSelector" locator

		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876543210"); // To enter the name using "xpath - //ParentTagname/ChildTagme[Index]" locator

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();// To click on Reset Login button using "CssSelector - .className" locator

		System.out.println(driver.findElement(By.cssSelector("form p")).getText()); // To get the text using "CssSelector - ParentTagname ChildTagname" locator

		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click(); // To click on Go To Login button by using "xpath - customized with Parent-Child traverse with Index

		Thread.sleep(1000); // To pause the execution flow for 1 second using "Thread.sleep" method 

		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");// CssSelector - With regular expression >>  * 

		driver.findElement(By.id("chkboxOne")).click();

		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); // Xpath - with regular expression >> contains

	}

}
