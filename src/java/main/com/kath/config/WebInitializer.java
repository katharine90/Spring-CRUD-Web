package com.kath.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/**
 * This class describes the root application context (I use this class instead for web.xml)
 * @author KitKat
 *
 */
public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * Returns configuration class
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {WebConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	/**
	 * Describes path mapping
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

}