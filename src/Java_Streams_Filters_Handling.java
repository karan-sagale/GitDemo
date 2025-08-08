//*** Automation practice for WebPage >> https://rahulshettyacademy.com/seleniumPractise/#/offers >> Handling Filters of WebTables using Java Stream  ***/

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Java_Streams_Filters_Handling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.id("search-field")).sendKeys("Rice");

		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]")); // Will show 1 result matching with
																				// "Rice"

		List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText().contains("Rice"))
				.collect(Collectors.toList()); // To filter the list with required item to be filtered using contains
												// method of filter

		// To know filter is working correct or not, by comparing the sizes of Original
		// list with filtered list
		Assert.assertEquals(veggies.size(), filteredList.size());
		driver.quit();

	}

}
