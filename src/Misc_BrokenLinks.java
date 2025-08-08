
//*** Automation practice for WebPage >> https://rahulshettyacademy.com/AutomationPractice/ >> Broken Links handling  ***/

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Misc_BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException, URISyntaxException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

		SoftAssert a = new SoftAssert();

		for (WebElement link : links) {

			String url = link.getAttribute("href");

			// To verify if the Link is broken or not
			HttpURLConnection conn = (HttpURLConnection) new URI(url).toURL().openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println("URL: " + url + " " + "\nResponseCode: " + responseCode);

			// Soft Assert Implemented using object a of SoftAssert
			a.assertTrue(responseCode > 400,
					"The link with Text '" + link.getText() + "' is working with code " + responseCode); // To know
																											// Valid
																											// links
			a.assertTrue(responseCode < 400,
					"The link with Text '" + link.getText() + "' is broken with code " + responseCode); // To know
																										// Broken links

		}

		a.assertAll(); // Mandatory line of code to report the failures caught by SoftAssert

		driver.quit();
	}

}
