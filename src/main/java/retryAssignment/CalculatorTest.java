package retryAssignment;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class CalculatorTest {

	private Calculator calculator;

	@BeforeClass
	public void setup() {
		calculator = new Calculator();
	}

	@DataProvider(name = "testData")
	public Object[][] testData() {
		return new Object[][] {
			{ 10, 1, 5}

		};
	}

	@Test(dataProvider = "testData", retryAnalyzer = retryAssignment.Retry.class)
	public void testDivide(int a, int b, int expected) {

		int result = calculator.divide(a, b);
		System.out.println(b);
		Assert.assertEquals(result, expected);
	}



}
