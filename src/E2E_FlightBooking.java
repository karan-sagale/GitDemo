import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E_FlightBooking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click(); // To click on One Way Radio Button

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click(); // To open and make the options visible for the first dynamic dropdown

		driver.findElement(By.xpath("//a[@value='DEL']")).click(); // To select Delhi option from first dynamic dropdown

		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click(); //(Parent xpath) //(Child xpath)Relationship format is used for selecting Chennai value from 2nd dynamic dropdown to avoid script failure


		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click(); // cssSelector >> To select the Current Date from Depart Date calendar field	


		if(driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) // getDomAttribute & contains >> Used for getting the changing attribute value based on Selection of radio buttons
		{
			System.out.println("Calendar field of Return Date is Disabled...");
			Assert.assertTrue(true); // As One Way radio button is selected then Return Date calendar should appear in Disabled state
		}
		else
		{
			Assert.assertTrue(false); //
		}


		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click(); // id* >> Partial ID value is used for getting CheckBox element by CssSelector with * (which represents regular expression into cssSelector)

		driver.findElement(By.id("divpaxinfo")).click();

		Thread.sleep(1000);

		System.out.println("Passengers dropdown text value without selection is: "+driver.findElement(By.id("divpaxinfo")).getText()); // To print the text of Passengers field without any selections on console

		for (int i=1; i < 5; i++) //Condition To click Passengers field- Adult + button 4 times (Instead of While-Loop we used For-Loop)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}

		driver.findElement(By.id("btnclosepaxoption")).click(); // To click DONE button post selecting 4 Adults

		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult"); // assertEquals >> (Actual Text, "Expected Text")

		System.out.println("Passengers dropdown text value post selection is: "+driver.findElement(By.id("divpaxinfo")).getText()); // To print the text of Passengers field after selecting 4 Adults on console


		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(staticDropdown); // Select is used for static dropdown having select tag in its locator

		dropdown.selectByVisibleText("USD"); // selectByVisibleText - To select the desired option from static dropdown by passing the visible text value of the dropdown options

		System.out.println("Selected option from the static dropdown is: "+dropdown.getFirstSelectedOption().getText()); // To print the selected option on console


		Thread.sleep(500);

		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click(); // To click on Search Button

		Thread.sleep(500);


		driver.quit();

	}

}
