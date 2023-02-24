package retryAssignment;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int count = 0;
	private static final int MAX_RETRY_COUNT = 1;
	private static ThreadLocal<String> testData = new ThreadLocal<String>();

	public boolean retry(ITestResult result) {
		if (count < MAX_RETRY_COUNT) {
			count++;
			testData.set("demosalesmanager");
			/*Object[] parameters = result.getParameters();
			String a = (String) parameters[0];
			String b = (String) parameters[1];
			parameters[0] = "demosalesmanager"; 
			parameters[1] = b; 
			System.out.println(parameters[0]);
			result.setParameters(parameters);*/
			//new LoginTest().userName = "demosalesmanager";
			return true;
		}
		return false;
	}

	public static String getTestData() {
        return testData.get(); // Get the value for the current thread
    }
}

