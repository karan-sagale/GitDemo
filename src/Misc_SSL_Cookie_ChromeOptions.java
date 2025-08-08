//*** Automation practice for WebPage >> Handling Bad SSL / ChromeOptions Feature / Cookie Handling WebPages  ***/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;

public class Misc_SSL_Cookie_ChromeOptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    // Mandatory steps for Expired SSL Certificate Bypass
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);

	//	FirefoxOptions options1 = new FirefoxOptions();
	//	options1.setAcceptInsecureCerts(true);		
			
		WebDriver driver = new ChromeDriver(options); // Mandatory to pass options object into WebDriver
		
	//	WebDriver driver = new FirefoxDriver(options1);
 		
		driver.manage().window().maximize(); // To maximize the Browser Window
		
		driver.manage().deleteAllCookies(); // To delete ALL the Cookies from Browser before execution
		
		driver.manage().deleteCookieNamed("ABC"); // To delete specific Cookie based on Name before execution
		
		
		
		driver.get("https://expired.badssl.com/");
		
		System.out.println(driver.getTitle());
		
		driver.quit();

	}

}
