package dev.bhardwaj.simple_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller class exposes APIs for performing basic arithmetic operations 
 * such as addition, subtraction, multiplication, and division.
 * 
 * @author nikhilbhardwaj01
 * @version 1.0
 */

@RestController
public class OperationsController {
	
	/**
	 * A constant string used to prepend to the final answer in the API response.
	 * 
	 * This text is added before the result of the calculation and returned 
	 * as part of the response to the client. For example, if the calculation 
	 * result is 42, the returned response will be: "The answer is: 42".
	 */
	private static final String RESPONSE_TEXT="The answer is: ";
	
	
	/**
	 * Adds two numbers and returns the result as a formatted string response.
	 * 
	 * @param num1 The first number to add.
	 * @param num2 The second number to add.
	 * @return A String in the format "The answer is: [result_of_add_operation]"
	 */
	@GetMapping("/add/{num1}/{num2}")
	public String add(@PathVariable double num1, @PathVariable double num2) {
		double ans = num1 + num2;
		return RESPONSE_TEXT+ans;
	}
	
	/**
	 * Subtracts a number from another and returns the result as a formatted string response.
	 * 
	 * @param num1 The first number from which the other is subtracted.
	 * @param num2 The second number which is subtracted.
	 * @return A String in the format "The answer is: [result_of_subtract_operation]"
	 */
	@GetMapping("/subtract/{num1}/{num2}")
	public String subtract(@PathVariable double num1, @PathVariable double num2) {
		double ans = num1 - num2;
		return RESPONSE_TEXT+ans;
	}
	
	/**
	 * Multiplies two numbers and returns the result as a formatted string response.
	 * 
	 * @param num1 The first number to multiply.
	 * @param num2 The second number to multiply.
	 * @return A String in the format "The answer is: [result_of_multiply_operation]"
	 */
	@GetMapping("/multiply/{num1}/{num2}")
	public String multiply(@PathVariable double num1, @PathVariable double num2) {
		double ans = num1 * num2;
		return RESPONSE_TEXT+ans;
	}
	
	/**
	 * Divides a number by another and returns the result as a formatted string response.
	 * 
	 * @param num1 The first number which is to be divided.
	 * @param num2 The second number which is to divide the first number.
	 * @return A String in the format "The answer is: [result_of_divide_operation]"
	 */
	
	@GetMapping("/divide/{num1}/{num2}")
	public String divide(@PathVariable double num1, @PathVariable double num2) {
		double ans = num1 / num2;
		return RESPONSE_TEXT+ans;
	}
}
