/*** Automation practice for "https://rahulshettyacademy.com/seleniumPractise/" WebPage >> GreenKart Dynamic Handling  ***/

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart_Selenium_Waits {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		// Declared Implicit Wait for driver to wait for the given time in Seconds for every line of code throughout the life of driver
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Declared Explicit Wait for the driver to wait for the below written targeted element 
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize();

		// Generic Array for storing required Items to be added into the Cart
		String [] itemsNeeded = {"Cucumber","Brocolli","Beetroot","Tomato","Apple"};

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		Thread.sleep(2000);

		addItems(driver,itemsNeeded);


		driver.findElement(By.cssSelector("img[alt='Cart']")).click(); // Click on Cart Image Button at the top

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click(); // Click on Check Out button

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode"))); // Used Explicit Wait for the Locator to be visible

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy"); // Enter Coupon code

		driver.findElement(By.cssSelector("button.promoBtn")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo"))); // Used Explicit Wait for the Locator to be visible

		System.out.println("\nCoupon Code Text is: "+driver.findElement(By.cssSelector("span.promoInfo")).getText());


		driver.quit();

	}

	public static void addItems(WebDriver driver, String [] itemsNeeded)
	{
		int j = 0;

		// To pull all the Items present of WebPage into the List type Variable using findElements
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) 
		{
			String[] name = products.get(i).getText().split("-"); // Format the name

			String formattedName = name[0].trim(); // Formatted name


			List<String> itemsNeededList = Arrays.asList(itemsNeeded); // Convert the Array into Array List

			if (itemsNeededList.contains(formattedName))  // Condition to check if the Formatted Name matches with the Array List items or not
			{
				// Print only the matched items which are as per Original Array items
				System.out.println("Found the matched item '"+formattedName+"' which is needed, added to the Cart.");

				j++; // Increment this counter in order to achieve exit strategy from this For-Loop once all the required required items matches with the Array List items post comparisons

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); // (Xpath- //Parent/Child) >> To click the ADD TO CART button which corresponds with the matching results only

				if (j == itemsNeeded.length) // Condition to compare if all the items present in the Original Array are added to the cart or not
				{
					System.out.println("\nAll the needed items are successfully added to the Cart..!!");
					break;	// Once all of the Array items present in the Original Array are added to the Cart, Break the loop
				}
			}

		}
	}

}
