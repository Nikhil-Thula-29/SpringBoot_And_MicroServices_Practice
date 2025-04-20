package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.offers.Offers;
import com.nt.entity.prod.Product;
import com.nt.repository.offers.IOffersRepository;
import com.nt.repository.prod.IProductRepository;


@Service("prodservice")
public class ProductManagementServiceImpl implements IProductManagementService {

	@Autowired
	private IProductRepository prodrepo;
	@Autowired
	private IOffersRepository offerrepo;
	
	@Override
	public String registerProducts(List<Product> list) {
		prodrepo.saveAll(list);
		return list.size()+" products are saved.";
	}

	@Override
	public String registerOffers(List<Offers> list) {
		offerrepo.saveAll(list);
		return list.size()+" offers are saved.";
	}

	@Override
	public List<Product> showAllProducts() {
		return prodrepo.findAll();
	}

	@Override
	public List<Offers> showAllOffers() {
		return offerrepo.findAll();
	}

}
