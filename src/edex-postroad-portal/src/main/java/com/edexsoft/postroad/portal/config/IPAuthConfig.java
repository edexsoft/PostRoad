package com.edexsoft.postroad.portal.config;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class IPAuthConfig {
	private static Logger logger = Logger.getLogger(IPAuthConfig.class);

	private static final String RESOURCE_PROPERTIES = "ipauth.properties";

	public static final String WX_API_MARKETING;
	public static final String LOCAL;

	static {

		Properties properties = new Properties();

		try {
			InputStream propStreams = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(RESOURCE_PROPERTIES);
			if (propStreams != null) {
				properties.load(propStreams);
			}
		} catch (Exception e) {
			logger.error(e);
		}

		LOCAL=properties.getProperty("local", null);
		WX_API_MARKETING = properties.getProperty("wx.api.marketing", null);		
	}
}
