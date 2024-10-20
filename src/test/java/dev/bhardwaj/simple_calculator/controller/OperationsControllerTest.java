package dev.bhardwaj.simple_calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit tests for the OperationsController class.
 * 
 * This test class verifies the functionality of the APIs in the OperationsController
 * for performing basic arithmetic operations such as addition, subtraction, multiplication,
 * and division.
 * 
 * @author nikhilbhardwaj01
 */

@ExtendWith(MockitoExtension.class)
public class OperationsControllerTest {
	
	OperationsController operationsController = new OperationsController();
	
	@ParameterizedTest
	@CsvSource({
        "0,100",
        "-10,-100",
        "10,10",
        "10,-10"
    })
	public void test_add(double a, double b) {
		// 1. arrange: already provided as arguments
		// 2. act
		String response = operationsController.add(a, b);
		// 3. assert
		double expectedAns = a + b;
		assertEquals("The answer is: "+expectedAns, response);
	}
	
	@ParameterizedTest
	@CsvSource({
        "0,100",
        "-10,-100",
        "10,10",
        "10,-10"
    })
	public void test_subtract(double a, double b) {
		// 1. arrange: already provided as arguments
		// 2. act
		String response = operationsController.subtract(a, b);
		// 3. assert
		double expectedAns = a - b;
		assertEquals("The answer is: "+expectedAns, response);
	}
	
	@ParameterizedTest
	@CsvSource({ "0,100", "-10,-100", "10,10", "10,-10" })
	public void test_multiply(double a, double b) {
		// 1. arrange: already provided as arguments
		// 2. act
		String response = operationsController.multiply(a, b);
		// 3. assert
		double expectedAns = a * b;
		assertEquals("The answer is: " + expectedAns, response);

	}
	
	@ParameterizedTest
	@CsvSource({ "0,100", "-10,-100", "10,10", "10,-10" })
	public void test_divide(double a, double b) {
		// 1. arrange: already provided as arguments
		// 2. act
		String response = operationsController.divide(a, b);
		// 3. assert
		double expectedAns = a / b;
		assertEquals("The answer is: " + expectedAns, response);
	}
}
