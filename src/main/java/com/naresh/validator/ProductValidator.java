package com.naresh.validator;

import com.naresh.model.Product;

public class ProductValidator {

	public static void validate(Product product) throws Exception {		
		
		if(product.name == null || product.name.trim().equals("") ) {
			throw new Exception("Invalid Product Name");
		}
		else if (product.price <=0) {
			throw new Exception ("Invalid Price");
		}
		
	}
}
