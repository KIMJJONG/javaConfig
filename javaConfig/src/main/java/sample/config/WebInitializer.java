package sample.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class WebInitializer implements WebApplicationInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(ApplicationConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(context));
		
		AnnotationConfigWebApplicationContext servlet = new AnnotationConfigWebApplicationContext();
		servlet.register(MainServletConfig.class);
	}
	
}
