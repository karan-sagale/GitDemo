/*** Automation practice for "https://rahulshettyacademy.com/loginpagePractise/" WebPage >> Frames Handling ***/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames_Automation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.manage().window().maximize();
		
		driver.get("https://jqueryui.com/droppable/");
		
		// To switch to Frame using index feature
		driver.switchTo().frame(0);
		
		// To switch to Frame using WebElement feature
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		
		
		Actions a = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		WebElement target = driver.findElement(By.id("droppable"));
		
		a.dragAndDrop(source, target).build().perform(); // dragAndDrop to perform Dragging and Dropping action using Actions Class

		// To switch back to Default content i.e. To switch from Frames to Normal WebPage
		driver.switchTo().defaultContent();
		
		
		driver.quit();
	}

}
