/***    Assignment Exercise on Multiple_Window_Handling  ***/

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Sec10_Assignment_Exercise_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
        driver.manage().window().maximize();
        
        driver.get("https://the-internet.herokuapp.com/");
        
        // To click on Multiple Windows hyperlink
        driver.findElement(By.linkText("Multiple Windows")).click();
     
        // To click on Click Here hyperlink from Parent 
        
        driver.findElement(By.linkText("Click Here")).click();
        
        
        Set<String> window = driver.getWindowHandles();
        
        Iterator<String> it = window.iterator();
        
        // To store Parent Window ID
        String parentID= it.next();
        
        // To store Child Window ID
        String childID= it.next();
		
        // To switch from Parent Window to Child Window
        driver.switchTo().window(childID);
        
        // To print required static text present on Child Window
        System.out.println("Static text on Child Window is: "+driver.findElement(By.tagName("h3")).getText());
        
        // To switch back to Parent Window from Child Window
        driver.switchTo().window(parentID);
        
        // To print required static text present on Parent Window
        System.out.println("Static text on Parent Window is: "+driver.findElement(By.tagName("h3")).getText());

        
        driver.quit();
		
	}

}
