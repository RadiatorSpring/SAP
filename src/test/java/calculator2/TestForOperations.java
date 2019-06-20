package calculator2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestForOperations {
	@Test
	public void testCalculatorFindingOperationsShouldReturnMinus() {
		String testString = "1-2";
		Calculator calculator = new Calculator();
		Assert.assertEquals(calculator.findOperations(testString).get(0),"-");
	}
	@Test
	public void testCalculatorFindingOperationsShouldReturnMultiplication() {
		String testString = "1100*2";
		Calculator calculator = new Calculator();
		Assert.assertEquals(calculator.findOperations(testString).get(0),"*");
	}
	@Test
	public void testCalculatorFindingOperationsShouldReturnDivision() {
		String testString = "1100/2";
		Calculator calculator = new Calculator();
		Assert.assertEquals(calculator.findOperations(testString).get(0),"/");
	}
	@Test
	public void testCalculatorFindingOperationsShouldReturnAdding() {
		String testString = "1100+2";
		Calculator calculator = new Calculator();
		Assert.assertEquals(calculator.findOperations(testString).get(0),"+");
	}
}
