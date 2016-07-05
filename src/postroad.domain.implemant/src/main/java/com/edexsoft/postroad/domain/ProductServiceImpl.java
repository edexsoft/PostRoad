package com.edexsoft.postroad.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edexsoft.postroad.domain.Product;
import com.edexsoft.postroad.domain.ProductService;
import com.edexsoft.postroad.domain.repository.ProductMapper;
 
@Service("productService")
//@Transactional
public class ProductServiceImpl implements ProductService {
//	private static final AtomicLong counter = new AtomicLong();
	
//	@Autowired
	private ProductMapper productMapper;
	
	public void setProductMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}
	
	public Product findById(Integer id){
		return this.productMapper.findById(id);
	}
	
	public Product findByName(String name){
		return this.productMapper.findByAccount(name);
	}
	public List<Product> findAll(){
		return this.productMapper.findAll();
	}
	public void save(Product entity){
		this.productMapper.insert(entity);
	} 
	public void update(Product entity){
		this.productMapper.update(entity);
	}
	public void delete(Integer id){
		this.productMapper.delete(id);
	}
	public void deleteAll(){
		this.productMapper.deleteAll();
	}
    public boolean isExist(Product entity){
    	return false;
    }
}