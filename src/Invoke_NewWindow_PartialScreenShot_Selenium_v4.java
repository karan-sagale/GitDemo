//*** Automation practice for WebPage >> https://rahulshettyacademy.com/angularpractice/ >> Invoking new window for multitasking & taking Partial Screenshot- Selenium 4.0  ***/

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Invoke_NewWindow_PartialScreenShot_Selenium_v4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// To switch to new TAB or WINDOW either of the below 2 lines of code will work
		// as per the requirement (Selenium v4 onwards)
		driver.switchTo().newWindow(WindowType.TAB);
		// driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();

		String parentWindow = it.next();

		String childWindow = it.next();

		driver.switchTo().window(childWindow);

		driver.get("https://rahulshettyacademy.com/");

		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				.get(1).getText();

		driver.switchTo().window(parentWindow);

		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(courseName);

		// To take Partial Screenshot of particular WebElement
		File file = name.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("PartialSS.png")); // With use of copyFile feature of FileUtils >> Provide file name to SS

		// To Get Height & Width of any WebElement (Selenium v4 onwards)
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());

		driver.quit();

	}

}
