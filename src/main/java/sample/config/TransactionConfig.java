package sample.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TransactionConfig {

	private static final Logger logger = LoggerFactory.getLogger(TransactionConfig.class);
	
	public TransactionConfig() {
		logger.debug("TransactionConfig 생성자");
	}
	
	@Bean
	@Lazy
	public DataSourceTransactionManager mariaTransactionManager(@Qualifier("mariaDataSource") DataSource dataSource) {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource);
		return manager;
	}
	
	@Bean
	public DataSourceTransactionManager postgresTransactionManager(@Qualifier("postgresDataSource") DataSource dataSource) {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource);
		return manager;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource);
		return manager;
	}
	
}
