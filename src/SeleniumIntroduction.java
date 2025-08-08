/*** Automation practice for "https://rahulshettyacademy.com/locatorspractice/" WebPage >> Basic commands ***/


import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntroduction {

	public static void main(String[] args) {

		// *** Invoking Browsers using different syntax *** //

		// For invoking GoogleChrome Browser
		// ChromeDriver driver = new ChromeDriver();

		// For invoking MozillaFirefox Browser
		// FirefoxDriver driver = new FirefoxDriver();

		// *** For Invoking GoogleChrome Browser using WebDriver Interface *** //
		WebDriver driver = new ChromeDriver();

		// *** For Invoking MozillaFirefox Browser using WebDriver Interface *** //
		//WebDriver driver = new FirefoxDriver();

		// *** For Invoking MicrosoftEdge Browser using WebDriver Interface *** //
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\admin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		//WebDriver driver = new EdgeDriver();

		// For hitting the URL into the Browser 
		driver.get("https://rahulshettyacademy.com/");

		// For getting & printing the Title of the WebPage on Console
		System.out.println(driver.getTitle());		

		// For getting & printing the Current URL on Console
		System.out.println(driver.getCurrentUrl());

		// For closing the Browser's Current Window only
		driver.close();
		

		// For quitting the Browser's All the associated windows invoked by Selenium 
		//driver.quit();

	}

}
