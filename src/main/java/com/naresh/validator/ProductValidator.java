package com.naresh.validator;

import com.naresh.exception.ValidationException;
import com.naresh.model.Product;

public class ProductValidator {

	public static void validate(Product product) throws ValidationException {

		if (product.getName() == null || product.getName().trim().equals("")) {
			throw new ValidationException("Invalid Product Name"); // Problem Rise - shout
		} else if (product.getPrice() < 0) {
			throw new ValidationException("Invalid Price");
		}
		System.out.println("Validation Success");

	}

}
