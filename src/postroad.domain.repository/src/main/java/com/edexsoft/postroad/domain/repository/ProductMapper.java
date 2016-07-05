package com.edexsoft.postroad.domain.repository;

import java.util.List;

import com.edexsoft.postroad.domain.Product;

public interface ProductMapper {
	Product findById(Integer id);
	Product findByAccount(String account);
	List<Product> findAll();
	void insert(Product entity);
	void update(Product entity);
	void delete(Integer id);
	void deleteAll();
	boolean isExist(Product entity);
}