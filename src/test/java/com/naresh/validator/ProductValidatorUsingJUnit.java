package com.naresh.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.naresh.model.Product;

public class ProductValidatorUsingJUnit {

	// Scenario 1: Valid productname, price
	// Scenario 2: Invalid product name, valid price
	// Scenario 3: Valid product name, invalid price
	@Test
	public void testWithValidProductDetails() {
		Product product = new Product(1, "Sugar", 100);

		try {
			ProductValidator.validate(product);
			System.out.println("Success");
			assertTrue(true);
		} catch (Exception e) {

			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
			fail();
		}

	}

	@Test
	public void testWithInvalidProductName() {
		Product product = new Product(1, "", 100);

		try {
			ProductValidator.validate(product);
			System.out.println("Success");
			System.out.println("Send details to db");
			fail();
		} catch (Exception e) {

			System.out.println("Error:" + e.getMessage());
			e.printStackTrace();
			assertEquals("Invalid Product Name", e.getMessage());
		}

	}

	@Test
	public void testWithInvalidProductPriceAndValidProductName() {
		Product product = new Product(1, "Sugar", -100);// no error = outside try block

		try {
			ProductValidator.validate(product); // exception - try/catch
			System.out.println("Success");
		} catch (Exception e) {
			e.printStackTrace();
			assertEquals("Invalid Price", e.getMessage());
		}

	}
	

	@Test
	public void testWithZeroProductPriceAndValidProductName() {
		Product product = new Product(1, "Sugar", 0);// no error = outside try block
		try {
			ProductValidator.validate(product); // exception - try/catch
			System.out.println("Success");
			assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
}
