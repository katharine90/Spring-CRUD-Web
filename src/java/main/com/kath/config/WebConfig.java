package com.kath.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
/**
 * Configurates dataSource with namedParameterJdbcTemplate, configurates Jndi, sets a viewResolver for .jsp files
 * @author KitKat
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.kath") 
public class WebConfig extends WebMvcConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	/**
	 * Configurates namedParameterJdbcTemplate bean
	 * @return
	 */
	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(dataSource);
	}

	/**
	 * Configurates Jndi
	 * @return
	 * @throws NamingException
	 */
	
	@Bean
	public DataSource dataSource() throws NamingException {
		JndiTemplate jndiTemplate = new JndiTemplate();
		DataSource dataSource = (DataSource) jndiTemplate.lookup("java:comp/env/jdbc/springdb");
		return dataSource;
	}
	
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources");
//	}
	
   /**
    * A viewresolver for all .jsp files based in the WE-INF/views folder
    * @return
    */
	@Bean
	public InternalResourceViewResolver viewRsolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		 resolver.setPrefix("/WEB-INF/views/");
		 resolver.setSuffix(".jsp");
		 resolver.setViewClass(JstlView.class);
		 
		 return resolver;
	}
	
	/**
	 * Specifies a welcome file 
	 */
	 @Override
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("member/index");
	  }

}
