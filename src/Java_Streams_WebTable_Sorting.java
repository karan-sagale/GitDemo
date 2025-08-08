//*** Automation practice for WebPage >> https://rahulshettyacademy.com/seleniumPractise/#/offers >> Sorting+Pagination of WebTables using Java Stream  ***/

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Java_Streams_WebTable_Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on required column of WebTable which needs to checked if its sorted or
		// not
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// Capture all the WebElements into List
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

		// Using Java Streams- Capture text of all WebElements into new (Original) list

		List<String> originalList = elementsList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Sort on the Original list as per above step >> To get Sorted List

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// Compare Original List vs Sorted List
		Assert.assertTrue(originalList.equals(sortedList));

		// Scan the Name column with getText >> If text returns "Beans" >> Print the
		// price of that item
		// Also click on Pagination buttons if required item is not matched until it matches and print the price value for the same
		List<String> price;

		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

			price = rows.stream().filter(s -> s.getText().contains("Orange")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			price.forEach(a -> System.out.println("Price value is: " + a)); // To print the price value of the required
																			// item

			if (price.size() < 1) {

				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}
		} while (price.size() < 1);

		driver.quit();
	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return priceValue;
	}

}
