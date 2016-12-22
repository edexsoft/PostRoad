package com.edexsoft.postroad.portal.config;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PortalConfig {
	private static Logger logger = Logger.getLogger(PortalConfig.class);

	private static final String RESOURCE_PROPERTIES = "portal.properties";

//	public static final String UPLOAD_PATH;
	public static final String WEBAPP_ROOT_KEY;

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

//		UPLOAD_PATH = properties.getProperty("upload_path", null);
		WEBAPP_ROOT_KEY = properties.getProperty("webapp.root.key", null);
	}
}
