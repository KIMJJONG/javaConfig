package sample.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.egovframe.rte.psl.dataaccess.mapper.MapperConfigurer;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	
	@Autowired
	ApplicationContext applicationContext;

	@Bean
    public DataSource mariaDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
        dataSource.setUrl("jdbc:mariadb://127.0.0.1:3306/mysql");
        dataSource.setUsername("root");
        dataSource.setPassword("test1!@#");
        return dataSource;
    }
	
	@Bean
    public DataSource postgresDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("test1!@#");
        return dataSource;
    }
	
	@Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:C:/eGovFrame/workspace/sqlite/solider.db");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin");
        return dataSource;
    }
	
	@Bean
	public SqlSessionFactoryBean mariaSqlSession(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setConfigLocation(applicationContext.getResource("classpath:/sqlmap/sql-mapper-config.xml"));
		factoryBean.setMapperLocations(applicationContext.getResources("classpath:/sqlmap/maria/*Mapper.xml"));
		return factoryBean;
	}
	
	@Bean
	public SqlSessionFactoryBean postgresSqlSession(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setConfigLocation(applicationContext.getResource("classpath:/sqlmap/sql-mapper-config.xml"));
		factoryBean.setMapperLocations(applicationContext.getResources("classpath:/sqlmap/postgres/*Mapper.xml"));
		return factoryBean;
	}
	
	@Bean
	public SqlSessionFactoryBean sqlSession(DataSource dataSource) throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setConfigLocation(applicationContext.getResource("classpath:/sqlmap/sql-mapper-config.xml"));
		factoryBean.setMapperLocations(applicationContext.getResources("classpath:/sqlmap/sqlite/*Mapper.xml"));
		return factoryBean;
	}

	@Bean
	public MapperConfigurer mariaMapperConfigurer() {
		MapperConfigurer mapperConfigurer = new MapperConfigurer();
		mapperConfigurer.setSqlSessionFactoryBeanName();
		mapperConfigurer.setBasePackage("sample.mapper.maria");
		return mapperConfigurer;
	}
	
	@Bean
	public MapperConfigurer postgresMapperConfigurer() {
		MapperConfigurer mapperConfigurer = new MapperConfigurer();
		mapperConfigurer.setSqlSessionFactoryBeanName();
		mapperConfigurer.setBasePackage("sample.mapper.postgres");
		return mapperConfigurer;
	}
	
	@Bean
	public MapperConfigurer sqliteMapperConfigurer() {
		MapperConfigurer mapperConfigurer = new MapperConfigurer();
		mapperConfigurer.setSqlSessionFactoryBeanName();
		mapperConfigurer.setBasePackage("sample.mapper.sqlite");
		return mapperConfigurer;
	}

}
