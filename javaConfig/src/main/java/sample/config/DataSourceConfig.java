package sample.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

	public DataSourceConfig() {
		logger.debug("DataSourceConfig 생성자");
	}
	
	@Bean(destroyMethod="close")
    public DataSource mariaDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://127.0.0.1:3306/mysql");
        dataSource.setUsername("root");
        dataSource.setPassword("test1!@#");
        return dataSource;
    }
	
	@Bean(destroyMethod="close")
    public DataSource postgresDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("test1!@#");
        return dataSource;
    }
	
	@Bean(destroyMethod="close")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:C:/eGovFrame/workspace/sqlite/solider.db");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");
        return dataSource;
    }

}
