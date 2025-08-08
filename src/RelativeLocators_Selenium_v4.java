//*** Automation practice for WebPage >> https://rahulshettyacademy.com/angularpractice/ >> Relative Locators - Selenium 4.0  ***/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators_Selenium_v4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement nameEditBox = driver.findElement(By.cssSelector("[name='name']"));

		// Capturing the WebElement using Relative Locator>> with TagName above() >>
		// method
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());

		WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));

		// Clicking the WebElement using Relative Locator>> with TagName below() >>
		// method
		driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

		WebElement iceCreamLabel = driver
				.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));

		// Clicking the WebElement using Relative Locator>> with TagName toLeftOf() >>
		// method
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();

		WebElement radioButton = driver.findElement(By.id("inlineRadio1"));

		// Capturing the WebElement using Relative Locator>> with TagName toRightOf() >>
		// method
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioButton)).getText());

		
		driver.quit();
	}

}
