package retryAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class LoginTest {

	WebDriver driver;
	String userName;
	String url = "http://leaftaps.com/opentaps";

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test(dataProvider = "fetchData", retryAnalyzer = retryAssignment.Retry.class)
	public void loginTaps(String userName,String pwd) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String text = driver.findElement(By.xpath("//div[@class='crmsfa']")).getText();
		System.out.println(text);


	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	@DataProvider(name="fetchData")
	public Object[][] testData() {
		//Faker fake = new Faker();
		userName = "newuser";//fake.name().username();
		return new Object[][] {{userName,"crmsfa"},
			{Retry.getTestData(), "crmsfa"}	
		};
	}

}
