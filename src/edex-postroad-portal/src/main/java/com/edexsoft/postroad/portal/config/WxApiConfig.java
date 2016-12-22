package com.edexsoft.postroad.portal.config;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

// JASYPT

public class WxApiConfig {
	
	private static Logger logger = Logger.getLogger(WxApiConfig.class);

	private static final String RESOURCE_PROPERTIES = "wxapi.properties";
	
	public static final String WX_APP_ID;
	public static final String WX_SECRET;

	static {

		Properties properties = new Properties();

		try {
			InputStream propStreams = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(RESOURCE_PROPERTIES);
			if (propStreams != null) {
				properties.load(propStreams);
			} else {
				// Probably we are running testing
				InputStream propStream = Thread.currentThread().getContextClassLoader()
						.getResourceAsStream("wxapi-text.properties");
				if (propStream != null) {
					try (InputStreamReader isr = new InputStreamReader(propStream, "UTF-8")) {
						properties.load(isr);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}

		WX_APP_ID = properties.getProperty("appid", null);
		WX_SECRET = properties.getProperty("secret", null);
	}
}
