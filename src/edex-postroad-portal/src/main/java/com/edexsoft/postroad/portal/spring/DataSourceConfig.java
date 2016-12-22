//package com.edexsoft.postroad.portal.spring;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.jndi.JndiObjectFactoryBean;
//
//@Configuration
//@PropertySource({ "classpath:jdbc.properties" })
//public class DataSourceConfig {
//	@Autowired
//	private Environment env;
//
//	@Bean
//	@Profile("javaee")
//	public JndiObjectFactoryBean dataSource() throws IllegalArgumentException {
//		JndiObjectFactoryBean dataSource = new JndiObjectFactoryBean();
//		dataSource.setExpectedType(DataSource.class);
//		dataSource.setJndiName(env.getProperty("jdbc.jndiDataSource"));
//		return dataSource;
//	}
//
//	@Bean
//	@Profile("test")
//	public DataSource testDataSource() {
//		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
//	}
//}
