package com.edexsoft.postroad.portal.api.root;

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

import com.edexsoft.framework.security.User;
import com.edexsoft.framework.security.UserService;


@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	// 分页查询
	@RequestMapping("/api/users")
    public ResponseEntity<List<User>> list() {
		List<User> lstEntity = userService.findAll();
        if(lstEntity.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
		
		return new ResponseEntity<List<User>>(lstEntity, HttpStatus.OK);
    }

//		// 批量插入
//		@RequestMapping(value = "/api/users/", method = RequestMethod.POST)
//	    public ResponseEntity<Void> batch(@RequestBody List<User> entities, UriComponentsBuilder ucBuilder) {
//	        HttpHeaders headers = new HttpHeaders();
////	        headers.setLocation(ucBuilder.path("/users").buildAndExpand(entities.select.getId()).toUri());
//	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//	    }
//	
//		// 全部删除
//		@RequestMapping(value = "/api/users/", method = RequestMethod.DELETE)
//	    public ResponseEntity<User> clear() { 
////	        userService.deleteAllUsers();
//	        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//	    }

	
	
	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> get(@PathVariable("id") int id){		
		User oEntity = userService.findById(id);
        if (oEntity == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<User>(oEntity, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> post(@RequestBody User entity, UriComponentsBuilder ucBuilder) {
        if (userService.isExist(entity)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        userService.save(entity);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(entity.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> put(@PathVariable("id") int id, @RequestBody User entity) {
		User oEntity = userService.findById(id);
         
        if (oEntity==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        oEntity.setNickName(entity.getNickName());
//	        oEntity.setAge(entity.getAge());
//	        oEntity.setSalary(entity.getSalary());
         
        userService.update(oEntity);
		
        return new ResponseEntity<User>(oEntity, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> delete(@PathVariable("id") int id) { 
		User oEntity = userService.findById(id);
        if (oEntity == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userService.delete(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }	
}
