/*** Automation practice for "https://rahulshettyacademy.com/AutomationPractice/" WebPage >> RealTime Exercises  ***/

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealtimeExercises_Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Excercise1- To print all the Links i.e. with <a> tag present on the entire
		// WebPage

		System.out.println(
				"Count of Anchor <a> tags present on this WebPage is: " + driver.findElements(By.tagName("a")).size());

		// Excercise2- To print all the Links i.e. with <a> tag present on the Footer of
		// the WebPage

		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

		// Limiting Scope of the driver using footerDriver WebElement as per the below
		// Line of Code to find the all the Links of Footer of this WebPage
		System.out.println("\nCount of Anchor <a> tags present on Footer part of this WebPage is: "
				+ footerDriver.findElements(By.tagName("a")).size());

		// Excercise3- To print all the Links i.e. with <a> tag present on the First
		// Section of the Footer of the WebPage

		// Limiting Scope of the driver using columnDriver WebElement as per the below
		// Line of Code to find the all the Links of First Section of the Footer of this
		// WebPage
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));

		System.out.println("\nCount of Anchor <a> tags present on First Section of the Footer part of this WebPage is: "
				+ columnDriver.findElements(By.tagName("a")).size());

		// Excercise4- To click all the Links i.e. with <a> tag present on the First
		// Section of the Footer of the WebPage are Opening/Working and Print their
		// respective Titles

		for (int i = 1; i < columnDriver.findElements(By.tagName("a")).size(); i++) {

			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(2000L);
		}

		// To open all the Tabs
		Set<String> tabHandle = driver.getWindowHandles();
		Iterator<String> it = tabHandle.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println("\nTitle of the WebPage is: "+driver.getTitle());
		}

		driver.quit();
	}

}
