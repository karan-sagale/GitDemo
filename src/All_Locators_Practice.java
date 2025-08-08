import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class All_Locators_Practice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		// By id
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");

		// By name
		driver.findElement(By.name("inputPassword")).sendKeys("pass123");

		// By className
		driver.findElement(By.className("signInBtn")).click();

		// By cssSelector >> tagname.className_value
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		// By linkText >> works only for <a> anchor tags
		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(2000);

		// By xpath >> Generic xpath syntax
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

		// By cssSelector >> Generic cssSelector syntax
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@gmail.com");

		// By xpath >> Generic xpath with index syntax
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

		// By cssSelector >> Generic cssSelector with index syntax
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@email.com");

		// By xpath >> Generic xpath with Parent Tag to Child Tag with index syntax
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9876543210");

		// By cssSelector >> Generic cssSelector based on Class Name (Tagname.ClassName) OR (.ClassName)
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		// By cssSelector >> Generic cssSelector with Parent Tag to Child Tag syntax
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		// By xpath >> Generic xpath with Customized Parent Tag to Child Tag with index syntax
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		Thread.sleep(2000);

		// By cssSelector >> cssSelector based on ID value (Tagname#ID_value) OR (.ID_value)
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");

		// By cssSelector >> Generic cssSelector with Regular Expression for partial attribute values
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		// By xpath >> Generic xpath with Regular Expression for partial attribute values
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		Thread.sleep(2000);
		
		// By tagName
		System.out.println(driver.findElement(By.tagName("p")).getText());
		
		// By cssSelector >> Generic cssSelector with Customized Parent Tag to Child Tag with index syntax
        driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        
        // By xpath >> Generic xpath based on Text of the Web Element
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		
		System.out.println("Welcome to Actions American Commit2");
		
		System.out.println("Welcome to Actions develop 2");
		
		System.out.println("Welcome to Actions develop 3 by GitStuff");

driver.quit();
	}

}
