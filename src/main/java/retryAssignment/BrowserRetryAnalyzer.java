package retryAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import java.util.HashMap;
import java.util.Map;

public class BrowserRetryAnalyzer implements IRetryAnalyzer {

	private static final int MAX_RETRIES = 1;
	private static int retryCount = 0;
	private static Map<String, WebDriver> driverMap = new HashMap<>();

	@Override
	public boolean retry(ITestResult result) {
		if (retryCount < MAX_RETRIES) {
			String browser =  "firefox";
			if (!driverMap.containsKey(browser)) {
				WebDriver driver = null;
				if (browser.equals("firefox")) {
					driver = new FirefoxDriver();
				}
				driver.manage().window().maximize();
				driverMap.put(browser, driver);
			}
			WebDriver driver = driverMap.get(browser);
			result.getTestContext().setAttribute("WebDriver", driver);
			retryCount++;
			System.out.println("Retrying test case " + " with browser " + browser);
			return true;
		}
		return false;
	}
}

