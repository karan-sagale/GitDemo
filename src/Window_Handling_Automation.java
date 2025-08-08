/*** Automation practice for "https://rahulshettyacademy.com/loginpagePractise/" WebPage >> Window (Parent-Child) Handling ***/

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Window_Handling_Automation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		driver.findElement(By.cssSelector(".blinkingText")).click();

		Set <String> windows = driver.getWindowHandles(); // To store all the Windows opened by Selenium Driver into Set interface type variable

		Iterator<String> it = windows.iterator(); // To iterate all the windows using Iterator interface

		String parentID = it.next(); // To store Parent Window ID using next() method

		String childID = it.next(); // To store Child Window ID using next() method again

		driver.switchTo().window(childID); // To switch the driver to the Child Window ID

		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

		driver.findElement(By.cssSelector(".im-para.red")).getText();

		String emailID = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		
		driver.switchTo().window(parentID);
		
		driver.findElement(By.id("username")).sendKeys(emailID);
	}

}