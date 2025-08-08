
/*** Automation practice for "https://rahulshettyacademy.com/AutomationPractice/" WebPage >> JavaScript_Scroll_Grid_Handling  ***/

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScript_Scroll_Grid_Handling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		Thread.sleep(1000);

		// To initialize and cast driver into JavaScript Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// To provide Vertical scroll to the WebPage using JavaScript window.scrollBy
		// feature with desired coordinates
		js.executeScript("window.scrollBy(0,600)");

		Thread.sleep(1000);

		// To provide Vertical scroll inside the Table using JavaScript
		// document.querySelector feature on Table WebElement with the use of scrollTop
		// feature
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

		int sum = 0;

		for (int i = 0; i < values.size(); i++) {

			sum = sum + Integer.parseInt(values.get(i).getText());
		}

		System.out.println("Total is: " + sum);

		int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

		// To validate the Sum & Total
		Assert.assertEquals(sum, total);

		driver.quit();
	}

}
