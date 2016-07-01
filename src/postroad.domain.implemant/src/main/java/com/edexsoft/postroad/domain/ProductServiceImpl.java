package com.edexsoft.postroad.domain;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edexsoft.postroad.domain.Product;
import com.edexsoft.postroad.domain.ProductService;
import com.edexsoft.postroad.domain.repository.ProductDao;
 
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
//	private static final AtomicLong counter = new AtomicLong();
	
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	public Product findById(Integer id){
		return this.productDao.findById(id);
	}
	
	public Product findByName(String name){
		return this.productDao.findByAccount(name);
	}
	public List<Product> findAll(){
		return this.productDao.findAll();
	}
	public void save(Product entity){
		this.productDao.insert(entity);
	} 
	public void update(Product entity){
		this.productDao.update(entity);
	}
	public void delete(Integer id){
		this.productDao.delete(id);
	}
	public void deleteAll(){
		this.productDao.deleteAll();
	}
    public boolean isExist(Product entity){
    	return false;
    }
}