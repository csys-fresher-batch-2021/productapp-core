package com.naresh.validator;

import com.naresh.model.Product;

public class ProductValidatorTest {


	// Scenario 1: Valid productname, price
	// Scenario 2: Invalid product name, valid price
	// Scenario 3: Valid product name, invalid price

	public static void testCase1() {
		Product product = new Product(1, "Sugar", 100);

		try {
			ProductValidator.validate(product);
			System.out.println("Success");
		} catch (Exception e) {

			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void testCase2() {
		Product product = new Product(1, "", 100);

		try {
			ProductValidator.validate(product);
			System.out.println("Success");
			System.out.println("Send details to db");
		} catch (Exception e) {

			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
		}

	}

	public static void testCase3() {
		Product product = new Product(1, "Sugar", -100);// no error = outside try block

		try {
			ProductValidator.validate(product); // exception - try/catch
			System.out.println("Success");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		//testCase1();
		//testCase2();
		//testCase3();
	}

}
