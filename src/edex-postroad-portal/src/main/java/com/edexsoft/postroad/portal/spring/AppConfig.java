package com.edexsoft.postroad.portal.spring;

import javax.annotation.PostConstruct;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

// https://github.com/keke77/spring-configuration-sample/blob/master/bakery-spring-web-api-config/src/main/java/com/gmind7/bakery/config/WebRestConfig.java

//@Configuration
//@Import(value = {
//	WebMvcConfig.class,
//	DataSourceConfig.class, 
//	WebSecurityConfig.class//,
//	InfrastructureConfig.class, 
//	RepositoryConfig.class, 
//	ServiceConfig.class
//})
//@ImportResource("classpath:spring-mybatis.xml")
@ComponentScan(basePackages = { 
		"com.edexsoft.security,"+
		"com.edexsoft.postroad.domain"})
public class AppConfig {

	private static final Logger logger = LogManager.getLogger(AppConfig.class);

	@Autowired
	private Environment env;
	
	@PostConstruct
    public void initApp() {
        logger.debug("Looking for Spring profiles...");
        if (env.getActiveProfiles().length == 0) {
            logger.info("No Spring profile configured, running with default configuration.");
        } else {
            for (String profile : env.getActiveProfiles()) {
                logger.info(String.format("Detected Spring profile: %s", profile));
            }
        }
    }
}
