package sample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MainServletConfig.class, SubServletConfig.class})
public class ServletContext {
	
	private static final Logger logger = LoggerFactory.getLogger(ServletContext.class);
	
	public ServletContext() {
		logger.debug("ServletContext 생성자");
	}
	
}
