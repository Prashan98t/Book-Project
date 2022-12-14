package com.HDAO.dao;

import java.util.List;

import com.HDAO.model.Product;

public interface ProductDAO 
{
	
	public boolean addProduct(Product p);
	public boolean updateProduct(Product p);
	public boolean deleteProduct(Product p);
	public List<Product> displayProduct();
	public Product displayProductById(int bookid);

}
