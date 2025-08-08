/*** End to End automation practice for "https://rahulshettyacademy.com/locatorspractice/" WebPage >> Login to Logout ***/

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;





public class Locators_2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String name = "Dynamic Username Password"; // string variable for passing name into user name field

		//WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.edge.driver", "C:\\Users\\admin\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		/* To provide Implicit wait for WebDriver which Specifies the amount of time the driver should wait 
		when searching for an element if it is not immediately present. */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3)); 

		String password = getPassword(driver);

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).sendKeys(name); // To enter the user name in Username field using "id" locator

		driver.findElement(By.name("inputPassword")).sendKeys(password); // To enter the password in Password field using "name" locator

		driver.findElement(By.className("signInBtn")).click(); // To click on the Sign In button using "className" locator

		Thread.sleep(2000); // To pause the execution flow for 1 second using "Thread.sleep" method 

		System.out.println(driver.findElement(By.tagName("p")).getText());
		//TestNG assertion
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");

		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		//TestNG assertion
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");

		driver.findElement(By.xpath("//*[text()='Log Out']")).click(); // Based on logout button's text- Xpath with * is used to bypass tagname (**This syntax is Not available in CssSelector)

		driver.close(); // To quit the browser
	}

	public static String getPassword(WebDriver driver) throws InterruptedException // Method to get password dynamically
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.linkText("Forgot your password?")).click(); // To click on Forgot Password using "linkText" locator

		Thread.sleep(1000);

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();// To click on Reset Login button using "CssSelector - .className" locator

		String passwordText = driver.findElement(By.cssSelector("form p")).getText(); // To get the text using "CssSelector - ParentTagname ChildTagname" locator

		// Text to be split >> Please use temporary password 'rahulshettyacademy' to Login.

		String [] passwordArray = passwordText.split("'"); // Split the text using first single quote and store it into one array variable

		String password = passwordArray[1].split("'")[0]; // Again split the 1st index using second single quote and store the 0th index into String variable

		//First Split Mechanism
		//0th index - Please use temporary password
		//1st index - rahulshettyacademy' to Login.

		//Second Split Mechanism
		//0th index - rahulshettyacademy
		//1st index - to Login.

		return password; // To return the password into main method 
	}

}
