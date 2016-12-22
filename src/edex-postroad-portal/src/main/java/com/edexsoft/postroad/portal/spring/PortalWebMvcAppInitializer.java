package com.edexsoft.postroad.portal.spring;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.IntrospectorCleanupListener;
import org.springframework.web.util.WebAppRootListener;

public class PortalWebMvcAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	private static int times=0;
	
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        
        logger.info(String.format("WebMvcAppInitializer startup, times: %s", ++times));
        
        // 参数
        servletContext.setInitParameter("webAppRootKey", "postroad.portal");
        
        // 监听器
		servletContext.addListener(new IntrospectorCleanupListener());	// 防止Spring内存溢出监听器
		servletContext.addListener(new WebAppRootListener());			// 负责将 Web 应用根目录以 webAppRootKey 上下文参数指定的属性名添加到系统参数中 
    }
	
	
	// WebApplicationContext, 根应用上下文
	@Override
	protected Class<?>[] getRootConfigClasses() {		
		return new Class[] { AppConfig.class, WebSecurityConfig.class };
	}
	
	// DispatcherServlet, Servlet应用上下文
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	// 过滤器
	@Override
    protected Filter[] getServletFilters() {
		// 指定Servlet级别的Filter
		HttpPutFormContentFilter httpPutFormContentFilter = new HttpPutFormContentFilter();
		httpPutFormContentFilter.setBeanName("HttpPutFormContentFilter");
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setBeanName("CharacterEncodingFilter");
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		
//		return new Filter[] { new DelegatingFilterProxy("springSecurityFilterChain") };
		
		return new Filter[]{httpPutFormContentFilter, characterEncodingFilter};
	}
	
}
