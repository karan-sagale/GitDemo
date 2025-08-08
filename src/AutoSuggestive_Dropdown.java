/*** Automation practice for "https://rahulshettyacademy.com/dropdownsPractise/" WebPage >> Automate Auto-Suggestive DropDowns  ***/


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoSuggestive_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("autosuggest")).sendKeys("ind"); // To find Auto Suggestive dropdown and enter desired search text

		Thread.sleep(2000);

		List <WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); // findElements method returns List type data >> Hence for grabbing all the options from auto suggestive dropdown into an variable of List type based on entered search text


		for (WebElement option : options) //Enhanced For-Loop to verify if the entered search text matches with expected option or not
		{
			if (option.getText().equalsIgnoreCase("India")) //Comparison condition
			{
				option.click();
				break;
			}

		}


        
		driver.quit();







	}

}
