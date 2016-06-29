package com.edexsoft.postroad.domain;

import java.util.List;
import com.edexsoft.postroad.domain.Product;

public interface ProductService {

	Product findById(long id);
	Product findByName(String name);
	List<Product> findAll();
    void save(Product entity);     
    void update(Product entity);     
    void deleteById(long id); 
    void deleteAll();     
    public boolean isExist(Product entity);
	
}
