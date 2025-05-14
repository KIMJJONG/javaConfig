package sample.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {
	
	private static final Logger logger = LoggerFactory.getLogger(WebInitializer.class);
	
	public WebInitializer() {
		logger.debug("WebInitializer 생성자");
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(RootContext.class);
		
		servletContext.addListener(new ContextLoaderListener(context));
		
		AnnotationConfigWebApplicationContext mainServlet = new AnnotationConfigWebApplicationContext();
		mainServlet.register(MainServletConfig.class);
		
		ServletRegistration.Dynamic mainDispatcherServlet = servletContext.addServlet("mainDispatcherServlet", new DispatcherServlet(mainServlet));
		mainDispatcherServlet.setLoadOnStartup(1);
		mainDispatcherServlet.addMapping("*.ao");
		mainDispatcherServlet.addMapping("*.do");
		
		AnnotationConfigWebApplicationContext subServlet = new AnnotationConfigWebApplicationContext();
		subServlet.register(SubServletConfig.class);
		
		ServletRegistration.Dynamic subDispatcherServlet = servletContext.addServlet("subDispatcherServlet", new DispatcherServlet(subServlet));
		subDispatcherServlet.setLoadOnStartup(2);
		subDispatcherServlet.addMapping("*.bo");
		subDispatcherServlet.addMapping("*.co");
	}
	
}
