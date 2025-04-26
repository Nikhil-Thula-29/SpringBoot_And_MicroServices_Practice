package com.nt.service;

import java.util.List;

import com.nt.entity.offers.Offers;
import com.nt.entity.prod.Product;

public interface IProductManagementService {

	public String registerProducts(List<Product> list);
	public String registerOffers(List<Offers> list);
	public List<Product> showAllProducts();
	public List<Offers> showAllOffers();
	
}
