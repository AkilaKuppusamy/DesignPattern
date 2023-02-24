package retryAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BrowserTest {

	WebDriver driver;
	String userName;
	String url = "http://leaftaps.com/opentaps";

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test(retryAnalyzer = retryAssignment.BrowserRetryAnalyzer.class)
	public void loginTaps() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("userName");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pwd");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String text = driver.findElement(By.xpath("//div[@class='crmsfa']")).getText();
		System.out.println(text);


	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	

}
