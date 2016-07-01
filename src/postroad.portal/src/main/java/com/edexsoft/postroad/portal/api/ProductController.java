package com.edexsoft.postroad.portal.api;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.edexsoft.postroad.domain.Product;
import com.edexsoft.postroad.domain.ProductService;


@RestController
public class ProductController {
	
	 @Autowired
	 ProductService productService;
	
	// 分页查询
	@RequestMapping("/api/products")
    public ResponseEntity<List<Product>> list() {
		List<Product> lstEntity = productService.findAll();
        if(lstEntity.isEmpty()){
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		
		return new ResponseEntity<List<Product>>(lstEntity, HttpStatus.OK);
    }

//	// 批量插入
//	@RequestMapping(value = "/api/products/", method = RequestMethod.POST)
//    public ResponseEntity<Void> batch(@RequestBody List<Product> entities, UriComponentsBuilder ucBuilder) {
//        HttpHeaders headers = new HttpHeaders();
////        headers.setLocation(ucBuilder.path("/products").buildAndExpand(entities.select.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//	
//	// 全部删除
//	@RequestMapping(value = "/api/products/", method = RequestMethod.DELETE)
//    public ResponseEntity<Product> clear() { 
////        userService.deleteAllUsers();
//        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
//    }

	
	
	@RequestMapping(value = "/api/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> get(@PathVariable("id") int id){		
		Product oEntity = productService.findById(id);
        if (oEntity == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<Product>(oEntity, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/product/", method = RequestMethod.POST)
    public ResponseEntity<Void> post(@RequestBody Product entity, UriComponentsBuilder ucBuilder) {
        if (productService.isExist(entity)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        productService.save(entity);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(entity.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/api/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> put(@PathVariable("id") int id, @RequestBody Product entity) {
		Product oEntity = productService.findById(id);
         
        if (oEntity==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
 
        oEntity.setName(entity.getName());
//        oEntity.setAge(entity.getAge());
//        oEntity.setSalary(entity.getSalary());
         
        productService.update(oEntity);
		
        return new ResponseEntity<Product>(oEntity, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> delete(@PathVariable("id") int id) { 
		Product oEntity = productService.findById(id);
        if (oEntity == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
 
        productService.delete(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }	
}
