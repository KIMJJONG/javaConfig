package sample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = "sample", excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Configuration.class}))
public class ApplicationConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);
	
	public ApplicationConfig() {
		logger.debug("ApplicationConfig 생성자");
	}
	
}
