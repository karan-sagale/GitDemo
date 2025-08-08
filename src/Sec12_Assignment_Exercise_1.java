
/***    Assignment Exercise on Web_Table_Automation Practice  ***/

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec12_Assignment_Exercise_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		Thread.sleep(1000);

		// To initialize and cast driver into JavaScript Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// To provide Vertical scroll to the WebPage using JavaScript window.scrollBy
		// feature with desired coordinates
		js.executeScript("window.scrollBy(0,600)");

		Thread.sleep(1000);

		WebElement webTable = driver.findElement(By.cssSelector(".table-display"));

		System.out.println("Total count of rows of the WebTable is: " + webTable.findElements(By.tagName("tr")).size());

		System.out.println("Total count of columns of the WebTable is: "
				+ webTable.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());

		List<WebElement> secondRow = webTable.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

		System.out.println("Data of Second row's 1st column value is: " + secondRow.get(0).getText());

		System.out.println("Data of Second row's 2nd column value is: " + secondRow.get(1).getText());

		System.out.println("Data of Second row's 3rd column value is: " + secondRow.get(2).getText());

		driver.quit();

	}

}
