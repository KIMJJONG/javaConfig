package sample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CommonConfig.class, DataSourceConfig.class, MapperConfig.class, TransactionConfig.class, LazyConfig.class})
public class RootContext {

	private static final Logger logger = LoggerFactory.getLogger(RootContext.class);
	
	public RootContext() {
		logger.debug("RootContext 생성자");
	}
	
}
