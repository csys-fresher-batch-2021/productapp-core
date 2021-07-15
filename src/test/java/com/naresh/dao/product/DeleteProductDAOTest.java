package com.naresh.dao.product;

import com.naresh.dao.ProductDAO;
import com.naresh.dao.ProductDAOImpl;
import com.naresh.model.Product;

public class DeleteProductDAOTest {

	public static void main(String[] args) {

		ProductDAO productDAO = new ProductDAOImpl();
		try {
			productDAO.deleteProduct(1);
			System.out.println("Successfully deleted product");
		} catch (Exception e) {
			String errorMessage = e.getMessage();
			System.out.println("Failure:" + errorMessage);
			e.printStackTrace();
		}
	}

}
