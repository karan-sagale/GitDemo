/*** Automation practice for "https://rahulshettyacademy.com/dropdownsPractise/" WebPage >> Parent <=> Automate various DropDowns  ***/


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Static_Dropdowns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();

		//driver.manage().window().maximize(); // To view the Browser window in Maximized mode

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		//To find the locator of static dropdown from web page we have to use WebElement and store it into an variable to pass it into Select method as done below
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(staticDropdown); // Select is used for static dropdown having select tag in its locator

		dropdown.selectByIndex(3); // selectByIndex - To select the desired option from static dropdown by passing index value [Where index value starts from 0(zero)]

		System.out.println("Selected option from the static dropdown is: "+dropdown.getFirstSelectedOption().getText()); // To print the selected option on console

		dropdown.selectByVisibleText("AED"); // selectByVisibleText - To select the desired option from static dropdown by passing the visible text value of the dropdown options

		System.out.println("Selected option from the static dropdown is: "+dropdown.getFirstSelectedOption().getText()); // To print the selected option on console

        dropdown.selectByValue("INR"); // selectByValue - To select the desired option from static dropdown by passing the value from HTML/WebPage code present against value attribute

		System.out.println("Selected option from the static dropdown is: "+dropdown.getFirstSelectedOption().getText()); // To print the selected option on console

		
		driver.quit();
	}

}
