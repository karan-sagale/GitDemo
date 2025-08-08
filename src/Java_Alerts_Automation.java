/*** Automation practice for "https://rahulshettyacademy.com/AutomationPractice/" WebPage >> Java Alerts Handling  ***/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Java_Alerts_Automation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String text = "Automation";

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		Thread.sleep(1000);
		
		// Alert 1 having single option into the Alert Pop-up
		
		driver.findElement(By.id("name")).sendKeys(text);
		
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
		
		Thread.sleep(1000);

		System.out.println(driver.switchTo().alert().getText()); // To print the Alert text message on Console
		
		driver.switchTo().alert().accept(); // switchTo().alert().accept >> Used to Swtich to alert & accept from WebPage
	
		
		// Alert 2 having two options into the Alert Pop-up
		driver.findElement(By.id("confirmbtn")).click();
		
		System.out.println(driver.switchTo().alert().getText()); // To print the Alert text message on Console

		Thread.sleep(1000);

		driver.switchTo().alert().dismiss(); // switchTo().alert().dismiss() >> Used to Switch to alert & decline or dismiss the Alert from WebPage
	
		
		driver.quit();
		
	
	}

}
