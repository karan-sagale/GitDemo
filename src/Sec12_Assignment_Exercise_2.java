
/*** Assignment Exercise on Automatic_DropDown_Practice ***/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec12_Assignment_Exercise_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("autocomplete")).sendKeys("aus");

		Thread.sleep(1000);

		driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);

		System.out.println("Selected value from Autocomplete DropDown is: "
				+ driver.findElement(By.id("autocomplete")).getAttribute("value"));

		driver.quit();

	}

}
