/*** Automation practice for WebPage >> Browser Activities (Maximize/Navigate/Back/Forward) ***/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_Activites {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new FirefoxDriver();

		//driver.manage().window().maximize(); // To view the Browser window in Maximized mode

		driver.get("https://www.google.com");

		driver.navigate().to("https://rahulshettyacademy.com/"); // To navigate to another URL from current browser window

		driver.navigate().back(); // To navigate back to the previous WebPage from current browser window
		
		driver.navigate().forward(); // To navigate forward to again to the 2nd URL from current browse window
		
		
		driver.quit();
	}

}
