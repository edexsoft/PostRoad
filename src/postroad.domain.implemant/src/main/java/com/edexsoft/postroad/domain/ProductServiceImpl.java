package com.edexsoft.postroad.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edexsoft.postroad.domain.Product;
import com.edexsoft.postroad.domain.ProductService;
 
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
	private static final AtomicLong counter = new AtomicLong();
    
    private static List<Product> entities;
     
    static{
        entities= populateDummyProducts();
    }
  
    public Product findById(long id) {
        for(Product entity : entities){
            if(entity.getId() == id){
                return entity;
            }
        }
        return null;
    }
     
    public Product findByName(String name) {
        for(Product entity : entities){
            if(entity.getName().equalsIgnoreCase(name)){
                return entity;
            }
        }
        return null;
    }
    
    public List<Product> findAll() {
        return entities;
    }
     
    public void save(Product entity) {
        entity.setId(counter.incrementAndGet());
        entities.add(entity);
    }
 
    public void update(Product entity) {
        int index = entities.indexOf(entity);
        entities.set(index, entity);
    }
 
    public void deleteById(long id) {
         
        for (Iterator<Product> iterator = entities.iterator(); iterator.hasNext(); ) {
            Product entity = iterator.next();
            if (entity.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isExist(Product entity) {
        return findByName(entity.getName())!=null;
    }
 
    private static List<Product> populateDummyProducts(){
    	List<Product> lstEntity= new ArrayList<Product>();
        
        Product oEntity = new Product();
		oEntity.setId(1);
		oEntity.setName("product_1");
		Product oEntity2 = new Product();
		oEntity2.setId(2);
		oEntity2.setName("product_2");
		Product oEntity3 = new Product();
		oEntity3.setId(3);
		oEntity3.setName("product_3");
		Product oEntity4 = new Product();
		oEntity4.setId(4);
		oEntity4.setName("product_4");
		
		lstEntity.add(oEntity);
		lstEntity.add(oEntity2);
		lstEntity.add(oEntity3);
		lstEntity.add(oEntity4);
        
        return lstEntity;
    }
 
    public void deleteAll() {
        entities.clear();
    }
}