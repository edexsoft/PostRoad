package com.edexsoft.postroad.portal.config;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.edexsoft.framework.utility.JsonHelper;
import com.edexsoft.webmvc.HttpProxy;
import com.fasterxml.jackson.databind.JsonNode;

public class WxApiHelper {

	private static Logger logger = Logger.getLogger(WxApiHelper.class);

	// {"errcode":45009,"errmsg":"api freq out of limit"}
	private static Date s_accessTokenTimestamp = new Date();
	private static String s_accessToken = null;

	private static HttpProxy httpProxy = HttpProxy.getProxy();

	public static String getToken() {

		String sWxUrlGetToken = String.format("%s?grant_type=%s&appid=%s&secret=%s",
				"https://api.weixin.qq.com/cgi-bin/token", "client_credential", WxApiConfig.WX_APP_ID,
				WxApiConfig.WX_SECRET);

		// {"access_token":"wNRlzkNFdxb_AhD4wogmCL9PUBNsxqK_qpe-Rnv5dRQXsckjaR998fnDkhlAVX9H1lrvssX2b82OxMfN0AuKsArukGXCjTv7p3waMq8TK4kF8bGLFGqLlGX4-jeT8wJKKUQcCAAEOK","expires_in":7200}
		String sResult = null;
		try {
			sResult = httpProxy.get(sWxUrlGetToken, "UTF-8");
		} catch (IOException e) {
			logger.error(e.toString());
		}

		if (sResult == null || sResult.trim().isEmpty()) {
			return null;
		}
		
		JsonNode oJsonNode = JsonHelper.readTree(sResult);
		if (oJsonNode == null) {
			return null;
		}
		
		String sAccessToken = oJsonNode.get("access_token").asText();

		return sAccessToken;

	}

	public static String getTicket(String accessToken) {

		// 一个小时以前
		Date date = new Date(System.currentTimeMillis() - (1 * 60 * 60 * 1000));
		
		// {"errcode":45009,"errmsg":"api freq out of limit"}
		if(s_accessToken == null || s_accessToken.trim().isEmpty() || s_accessTokenTimestamp.getTime() < date.getTime()){

			String sWxUrlGetTicket = String.format("%s?access_token=%s&type=%s",
					"https://api.weixin.qq.com/cgi-bin/ticket/getticket", accessToken, "jsapi");

			// {"errcode":0,"errmsg":"ok","ticket":"kgt8ON7yVITDhtdwci0qefgHi5aZwMipfguuBM88tsdWS_PSJ3HlHEKvqp6e0eTaCg08TwYz376WLcKYo-kHhw","expires_in":7200}
			String sResult = null;
			try {
				sResult = httpProxy.get(sWxUrlGetTicket, "UTF-8");
			} catch (IOException e) {
				logger.error(e.toString());
			}
			if (sResult == null || sResult.trim().isEmpty()) {
				return null;
			}
			JsonNode oJsonNode = JsonHelper.readTree(sResult);
			if (oJsonNode == null) {
				return null;
			}
			s_accessToken = oJsonNode.get("ticket").asText();			
		}
		
		
		return s_accessToken;
	}
	
	public static String GetOpenId(String code) {
//		String sUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx7b0499948c3815a9&secret=6cb036d8536f0a423ddfe1f53376d63e&code="
//				+ code + "&grant_type=authorization_code";
		
		String sUrl = String.format("%s?appid=%s&secret=%scode=%s&grant_type=%s",
				"https://api.weixin.qq.com/sns/oauth2/access_token", WxApiConfig.WX_APP_ID,
				WxApiConfig.WX_SECRET, code, "authorization_code");

		HttpProxy oHttpProxy = HttpProxy.getProxy();
		String sReturn = null;
		try {
			sReturn = oHttpProxy.get(sUrl, "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sReturn;
	}
}
