
/*** Automation practice for "https://www.amazon.com/" WebPage >> Actions Handling  ***/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_Automation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");

		// To click Continue Shopping button in order to land on Home Page of Amazon.com
		// WebSite
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// To click DISMISS button of Delivery Location Suggestion pop-up
		driver.findElement(By.xpath("//input[@data-action-type='DISMISS']")).click();

		WebElement move = driver.findElement(By.cssSelector("div[id='nav-link-accountList'] a"));

		// Actions class used for different interactions which are supposed to by done
		// by Keyboard or Mouse
		Actions a = new Actions(driver);

		// Use of keyDown(Keys.SHIFT) method to Hold SHIFT button to enter required text
		// into CAPTIAL letters
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
				.doubleClick().build().perform();

		// Moves mouse to Specific element on WebPage using build().perform() methods of
		// Actions class
		// contextClick() methods performs Right-Click mouse operation
		a.moveToElement(move).contextClick().build().perform();

	}

}
