/***    Assignment Exercise on RealTime Automation Practice   ***/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sec11_Assignment_Exercise_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();

		String var = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[3]")).getText();

		System.out.println(var);

		WebElement staticDropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));

		Select dropdown = new Select(staticDropdown);

		dropdown.selectByVisibleText(var);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(var);
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#alertbtn")).click();

		Thread.sleep(2000);

		String alertText = driver.switchTo().alert().getText();

		if (alertText.contains(var)) {

			System.out.println("Alert message text contains expected data " + var);
		} else
			System.out.println("Alert message text is not as expected");

		driver.quit();
	}

}
