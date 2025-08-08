/*** Automation practice for "https://rahulshettyacademy.com/AutomationPractice/" WebPage >> Parent <=> Child + Sibling to Sibling Traverse ***/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Xpath to Traverse from Parent to Child & then to Sibling
		System.out.println("Approach 1: "+driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		
		// Xpath to Traverse from Child to Parent & then to Sibling
		System.out.println("Approach 2: "+driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());


	}

}
