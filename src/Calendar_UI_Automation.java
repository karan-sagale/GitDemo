
/*** Automation practice for "https://rahulshettyacademy.com/seleniumPractise/#/offers" WebPage >> Calendar UI Handling  ***/

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Calendar_UI_Automation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Exercise - To select any random date of Future from Calendar UI with the use
		// of String variables dynamically

		String monthNumber = "1";
		String date = "14";
		String year = "2025";
		String[] expectedList = { monthNumber, date, year };

		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();

		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();

		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month"))
				.get(Integer.parseInt(monthNumber) - 1).click();

		driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

		// To print the Selected Date from the Calendar UI and Assert it with Expected List
		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

		for (int i = 0; i < actualList.size(); i++) {
			System.out.println(actualList.get(i).getAttribute("value"));
			Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
		}
		
		Thread.sleep(500);

		driver.quit();
		
	}

}
