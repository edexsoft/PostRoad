package com.edexsoft.postroad.domain.repository;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.edexsoft.postroad.domain.Product;

public class ProductDaoImpl extends SqlSessionDaoSupport implements ProductDao{
	
//	@Override
	public Product findById(Integer id){
		return (Product) getSqlSession().selectOne("com.edexsoft.postroad.domain.repository.ProductDao.findById", id);
	}
	public Product findByAccount(String account){
		return (Product) getSqlSession().selectOne("com.edexsoft.postroad.domain.repository.ProductDao.findByAccount", account);
	}
	public List<Product> findAll(){
		return (List<Product>) getSqlSession().<Product>selectList("com.edexsoft.postroad.domain.repository.ProductDao.findAll");
	}
	public void insert(Product entity){
		getSqlSession().insert("com.edexsoft.postroad.domain.repository.ProductDao.insert", entity);
	}
	public void update(Product entity){
		getSqlSession().update("com.edexsoft.postroad.domain.repository.ProductDao.update", entity);
	}
	public void delete(Integer id){
		getSqlSession().delete("com.edexsoft.postroad.domain.repository.ProductDao.delete", id);
	}
	public void deleteAll(){
		getSqlSession().delete("com.edexsoft.postroad.domain.repository.ProductDao.deleteAll");
	}
	public boolean isExist(Product entity){
		return false;
	}
}
