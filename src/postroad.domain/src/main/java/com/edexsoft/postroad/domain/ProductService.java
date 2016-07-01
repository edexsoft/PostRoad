package com.edexsoft.postroad.domain;

import java.util.List;
import com.edexsoft.postroad.domain.Product;

public interface ProductService {

	Product findById(Integer id);
	Product findByName(String name);
	List<Product> findAll();
    void save(Product entity);     
    void update(Product entity);     
    void delete(Integer id); 
    void deleteAll();     
    public boolean isExist(Product entity);
	
}
