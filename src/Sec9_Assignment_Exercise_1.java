/***    Assignment Exercise on E2ELogin_Ecom_ExplicitWait   ***/

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sec9_Assignment_Exercise_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// For handling GoogleChrome Password Manager Alert Pop-up
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("password_manager_enabled", false);
		Map<String, Object> profile = new HashMap<String, Object>();
		profile.put("password_manager_leak_detection", false);
		prefs.put("profile", profile);
		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);

		// Explicit wait declaration
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// Store User Name displayed on WebPage into one variable
		String userName = driver.findElement(By.xpath("//p[@class='text-center text-white'] //b [1]")).getText();
		// Store Password displayed on WebPage into one variable
		String password = driver.findElement(By.xpath("//p[@class='text-center text-white'] //b [2]")).getText();

		// Enter User Name dynamically
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);

		// Enter Password dynamically
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys(password);

		// Select User radio button
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();

		// Explicit wait condition
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='okayBtn']")));

		// Click on Alert Popup's Okay button
		driver.findElement(By.cssSelector("button[id='okayBtn']")).click();

		// Select DropDown value
		WebElement staticDropDown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(staticDropDown);
		dropdown.selectByVisibleText("Consultant");

		// Select CheckBox
		driver.findElement(By.cssSelector("input[name='terms']")).click();

		// Click on Sign In button
		driver.findElement(By.id("signInBtn")).click();

		// Static method to perform Checkout operations on the added items
		addSKU(driver, wait);

		driver.quit();

	}

	public static void addSKU (WebDriver driver, WebDriverWait wait) {

		// Explicit wait condition
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-info']")));

		// Store all the items into List type variable
		List<WebElement> sku = driver.findElements(By.xpath("//button[@class='btn btn-info']"));

		for (int i = 0; i < sku.size(); i++) 
		{
			sku.get(i).click();
		}

		// Store all the items into List type variable for printing name of each item
		// added to the cart
		List<WebElement> skuName = driver.findElements(By.xpath("//h4[@class='card-title']"));

		// Print all names of items which are added to the cart
		for (WebElement name : skuName) 
		{
			System.out.println("Item added to the cart is: " + name.getText());
		}

		// Click on Checkout button
		driver.findElement(By.cssSelector("a.nav-link.btn.btn-primary")).click();

	}

}
