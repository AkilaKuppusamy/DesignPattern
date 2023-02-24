package Feb2023.FebArch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

public class FakerImpl {

	public static void main(String[] args) {

		Faker fake = new Faker();
		String userName = fake.name().username();
		String pwd = "crmsfa";
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String text = driver.findElement(By.xpath("//div[@class='crmsfa']")).getText();
		System.out.println(text);
		}

}

/*
 * driver.findElement(By.xpath("//*[@id=\"j_idt88:name\"]")).sendKeys(buildingNumber);
		String attribute = driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt91\"]")).getAttribute("value");
		System.out.println(attribute);
 */
