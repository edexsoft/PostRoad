package com.edexsoft.postroad.portal.spring;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.UrlBasedViewResolverRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.XmlViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.edexsoft.postroad.portal.config.IPAuthConfig;
import com.edexsoft.webmvc.interceptor.IPAddressAuthorizeInterceptor;

import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;

//@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.edexsoft.postroad.portal," + "com.edexsoft.postroad.portal.controllers,"
		+ "com.edexsoft.postroad.portal.api.controllers," + "com.edexsoft.postroad.portal.api.root.controllers,"
		+ "com.edexsoft.postroad.portal.web.controllers," + "com.edexsoft.postroad.portal.m.controllers,"
		+ "com.edexsoft.postroad.portal.wx.controllers," + "com.edexsoft.postroad.portal.root.controllers" })
//@PropertySource("classpath:portal.properties")
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
//	/**
//     * Ensures that placeholders are replaced with property values
//     * 可以使用 @Value("${webapp.root.key}") 的方式注入portal.properties文件中的配置值
//     */
//    @Bean
//    static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }

	private static final int CACHE_PERIOD = 31556926; // one year

	@Autowired
	ServletContext servletContext;

	// @Autowired
	// private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
	//
	// @PostConstruct
	// public void init() {
	// requestMappingHandlerAdapter.setIgnoreDefaultModelOnRedirect(true);
	// requestHandlerMapping.setAlwaysUseFullPath(true);
	// requestHandlerMapping.setRemoveSemicolonContent(false);
	// }

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// Serving static files using the Servlet container's default Servlet.
		// configurer.enable();
		// configurer.enable("myCustomDefaultServlet");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/favicon.ico").addResourceLocations("/favicon.ico");

		registry.addResourceHandler("/cdn/**").addResourceLocations("/cdn/").setCachePeriod(CACHE_PERIOD);

		registry.addResourceHandler("/static/images/**").addResourceLocations("/uploads/iamges/")
				.setCachePeriod(CACHE_PERIOD);

		registry.addResourceHandler("/MP_verify_vTtj4yW9QDOKTUma.txt")
				.addResourceLocations("/MP_verify_vTtj4yW9QDOKTUma.txt").setCachePeriod(CACHE_PERIOD);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// 默认首页
		registry.addViewController("/").setViewName("forward:/home/index");
		// registry.addViewController("/home/about"); // the about page did not
		// required any controller
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/areas/", ".jsp");

		// registry.enableContentNegotiation(new MappingJackson2JsonView());
		// registry.jsp();
		// registry.freeMarker().cache(false);
		// registry.velocity().cache(false);

	}

	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setDefaultEncoding("utf-8");
		commonsMultipartResolver.setMaxUploadSize(2000000);
		return commonsMultipartResolver;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// Configure the list of HttpMessageConverters to use
		// converters.add(new FormHttpMessageConverter());
		// converters.add(new Jaxb2RootElementHttpMessageConverter());
		converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		converters.add(new MappingJackson2HttpMessageConverter());
	}

	// @Bean
	// public ViewResolver jspViewResolver() {
	// InternalResourceViewResolver viewResolver = new
	// InternalResourceViewResolver();
	// viewResolver.setViewClass(JstlView.class);
	// viewResolver.setPrefix("/areas/");
	// viewResolver.setSuffix(".jsp");
	// return viewResolver;
	// }

	// @Bean
	// public ViewResolver
	// contentNegotiatingViewResolver(ContentNegotiationManager manager) {
	//
	// ContentNegotiatingViewResolver negotiating = new
	// ContentNegotiatingViewResolver();
	//
	// // mediaTypes property
	// Map<String, MediaType> mediaTypes = new HashMap<String, MediaType>();
	// mediaTypes.put("html", MediaType.TEXT_HTML);
	// mediaTypes.put("json", MediaType.APPLICATION_JSON);
	// mediaTypes.put("jsonp", MediaType.APPLICATION_JSON);
	// mediaTypes.put("xml", MediaType.APPLICATION_XML);
	// mediaTypes.put("atom", MediaType.APPLICATION_ATOM_XML);
	//
	// ContentNegotiationStrategy pathExtensionContentNegotiationStrategy = new
	// PathExtensionContentNegotiationStrategy(mediaTypes);
	// ContentNegotiationStrategy headerContentNegotiationStrategy = new
	// HeaderContentNegotiationStrategy();
	// ContentNegotiationManager contentNegotiationManager = new
	// ContentNegotiationManager(pathExtensionContentNegotiationStrategy,
	// headerContentNegotiationStrategy);
	// negotiating.setContentNegotiationManager(contentNegotiationManager);
	//
	// // viewResolvers property
	// List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();
	// viewResolvers.add(new BeanNameViewResolver());
	// viewResolvers.add(thymeleafViewResolver());
	//
	// InternalResourceViewResolver internalResourceViewResolver = new
	// InternalResourceViewResolver();
	// internalResourceViewResolver.setPrefix("/WEB-INF/views/");
	// internalResourceViewResolver.setSuffix(".html");
	//
	// viewResolvers.add(internalResourceViewResolver);
	//
	// negotiating.setViewResolvers(viewResolvers);
	//
	// List<View> JsonView = new ArrayList<View>();
	//
	// MappingJackson2JsonView mappingJackson2JsonView = new
	// MappingJackson2JsonView();
	// mappingJackson2JsonView.setExtractValueFromSingleKeyModel(true);
	// JsonView.add(mappingJackson2JsonView);
	//
	// MappingJackson2JsonpView mappingJackson2JsonpView = new
	// MappingJackson2JsonpView();
	// mappingJackson2JsonpView.setExtractValueFromSingleKeyModel(true);
	// JsonView.add(mappingJackson2JsonpView);
	//
	// negotiating.setDefaultViews(JsonView);
	//
	// negotiating.setOrder(2);
	//
	// return negotiating;
	//
	// }

	// @Override
	// public void configureContentNegotiation(ContentNegotiationConfigurer
	// configurer) {
	// configurer
	// .ignoreAcceptHeader(true)
	// .defaultContentType(MediaType.TEXT_HTML)
	// .mediaType("json", MediaType.APPLICATION_JSON);
	// }

	// @Bean(name = "messageSource")
	// public ReloadableResourceBundleMessageSource
	// reloadableResourceBundleMessageSource() {
	// ReloadableResourceBundleMessageSource messageSource = new
	// ReloadableResourceBundleMessageSource();
	// messageSource.setBasenames("classpath:com/javaetmoi/sample/web/messages");
	// messageSource.setDefaultEncoding("UTF-8");
	// return messageSource;
	// }

	@Override
	public void addFormatters(FormatterRegistry registry) {
		// Add formatters and/or converters
	}

	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// configurer
		// .setUseSuffixPatternMatch(true)
		// .setUseTrailingSlashMatch(false)
		// .setUseRegisteredSuffixPatternMatch(true)
		// .setPathMatcher(antPathMatcher())
		// .setUrlPathHelper(urlPathHelper());
	}

	// @Bean
	// public UrlPathHelper urlPathHelper() {
	// //...
	// }
	//
	// @Bean
	// public PathMatcher antPathMatcher() {
	// //...
	// }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		Map<String, String> mapIPAuth = new HashMap<String, String>();
		mapIPAuth.put("local", IPAuthConfig.LOCAL);
		mapIPAuth.put("wx.api.marketing", IPAuthConfig.WX_API_MARKETING);
		registry.addInterceptor(new IPAddressAuthorizeInterceptor(mapIPAuth)).addPathPatterns("/api/wx/marketing/**");
		// registry.addInterceptor(new LocaleInterceptor());
		// registry.addInterceptor(new
		// ThemeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
		// registry.addInterceptor(new
		// SecurityInterceptor()).addPathPatterns("/secure/*");
		// registry.addInterceptor(new WebAuthorizeInteceptor()); //
		// com.edexsoft.webmvc.interceptor.WebAuthorizeInteceptor
		// registry.addInterceptor(new
		// ApiAuthorizeInteceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
		// // com.edexsoft.webmvc.interceptor.ApiAuthorizeInteceptor
		// registry.addInterceptor(new
		// WxAuthorizeInteceptor()).addPathPatterns("/secure/*"); //
		// com.edexsoft.webmvc.interceptor.ApiAuthorizeInteceptor
	}

	// @Bean
	// public FreeMarkerConfigurer freeMarkerConfigurer() {
	// FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
	// configurer.setTemplateLoaderPath("/WEB-INF/");
	// return configurer;
	// }

	// @Override
	// @Bean
	// public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
	// // Create or let "super" create the adapter
	// // Then customize one of its properties
	// }

	// @Bean(name = "rssViewer")
	// public CustomAtomViewer rssViewer() {
	// return new CustomAtomViewer();
	// }

	// @Override
	// public Validator getValidator() {
	// LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
	// ReloadableResourceBundleMessageSource messageSource = new
	// ReloadableResourceBundleMessageSource();
	// messageSource.setBasename("classpath:message/validation");
	// if (environment.acceptsProfiles("loc")) {
	// messageSource.setCacheSeconds(0);
	// }
	// factory.setValidationMessageSource(messageSource);
	// return factory;
	// }

	// @Bean
	// public HandlerExceptionResolver simpleMappingExceptionResolver() {
	//
	// Properties mappings = new Properties();
	// mappings.put(NoSuchRequestHandlingMethodException.class.getName(),
	// "/error/pageNotFound");
	// mappings.put(HttpRequestMethodNotSupportedException.class.getName(),
	// "/error/pageNotFound");
	// mappings.put(DataAccessException.class.getName(),
	// "/error/dataAccessFailure");
	// mappings.put(TransactionException.class.getName(),
	// "/error/dataAccessFailure");
	//
	// SimpleMappingExceptionResolver exceptionResolver = new
	// SimpleMappingExceptionResolver();
	// exceptionResolver.setExceptionMappings(mappings);
	// exceptionResolver.setDefaultErrorView("/error/defaultError");
	// exceptionResolver.setDefaultStatusCode(HttpStatus.BAD_REQUEST.value());
	// exceptionResolver.setOrder(1);
	//
	// return exceptionResolver;
	// }

}
