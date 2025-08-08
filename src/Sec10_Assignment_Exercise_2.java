/***    Assignment Exercise on Nested_iFrames_Handling  ***/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec10_Assignment_Exercise_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();

		driver.get("https://the-internet.herokuapp.com/");

		// To click on Nested Frames hyperlink
		driver.findElement(By.linkText("Nested Frames")).click();

		// To Switch to Top Frame
		driver.switchTo().frame("frame-top");

		// To Switch to Middle Frame
		driver.switchTo().frame("frame-middle");
		
		// To print the Static text of Middle Frame
		System.out.println("Static text of Middle Frame is: "+driver.findElement(By.id("content")).getText());

		driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();
		
		
		
		driver.quit();
		
	}

}
