package com.naresh.service.product;

import com.naresh.dao.ProductDAO;
import com.naresh.dao.ProductDAOImpl;
import com.naresh.model.Product;
import com.naresh.service.ProductService;

public class DeleteProductServiceTest {

	public static void main(String[] args) {

		ProductService productService = new ProductService();
		try {
			//productService.deleteProduct(1);
			System.out.println("Successfully deleted product");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
		}
	}

}
