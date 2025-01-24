package sample.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.egovframe.rte.psl.dataaccess.mapper.MapperConfigurer;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = {"sample.mapper.*"})
public class MapperConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(MapperConfig.class);
	
	public MapperConfig() {
		logger.debug("MapperConfig 생성자");
	}

	@Bean(name="mariaSqlSession")
	public SqlSessionFactoryBean mariaSqlSession(@Qualifier("mariaDataSource") DataSource dataSource) throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factoryBean.setDataSource(dataSource);
		factoryBean.setConfigLocation(resolver.getResource("classpath:/sqlmap/sql-mapper-config.xml"));
		factoryBean.setMapperLocations(resolver.getResources("classpath:/sqlmap/maria/*Mapper.xml"));
		return factoryBean;
	}
	
	@Bean(name="postgresSqlSession")
	public SqlSessionFactoryBean postgresSqlSession(@Qualifier("postgresDataSource") DataSource dataSource) throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factoryBean.setDataSource(dataSource);
		factoryBean.setConfigLocation(resolver.getResource("classpath:/sqlmap/sql-mapper-config.xml"));
		factoryBean.setMapperLocations(resolver.getResources("classpath:/sqlmap/postgres/*Mapper.xml"));
		return factoryBean;
	}
	
	@Bean(name="sqlSession")
	public SqlSessionFactoryBean sqlSession(@Qualifier("dataSource") DataSource dataSource) throws IOException {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		factoryBean.setDataSource(dataSource);
		factoryBean.setConfigLocation(resolver.getResource("classpath:/sqlmap/sql-mapper-config.xml"));
		factoryBean.setMapperLocations(resolver.getResources("classpath:/sqlmap/sqlite/*Mapper.xml"));
		return factoryBean;
	}
	
	@Bean(name="mariaMapperConfigurer")
	public MapperConfigurer mariaMapperConfigurer() {
		MapperConfigurer mapperConfigurer = new MapperConfigurer();
		mapperConfigurer.setBasePackage("sample.mapper.maria");
		mapperConfigurer.setSqlSessionFactoryBeanName("mariaSqlSession");
		return mapperConfigurer;
	}
	
	@Bean(name="postgresMapperConfigurer")
	public MapperConfigurer postgresMapperConfigurer() {
		MapperConfigurer mapperConfigurer = new MapperConfigurer();
		mapperConfigurer.setBasePackage("sample.mapper.postgres");
		mapperConfigurer.setSqlSessionFactoryBeanName("postgresSqlSession");
		return mapperConfigurer;
	}
	
	@Bean(name="mapperConfigurer")
	public MapperConfigurer mapperConfigurer() {
		MapperConfigurer mapperConfigurer = new MapperConfigurer();
		mapperConfigurer.setBasePackage("sample.mapper.sqlite");
		mapperConfigurer.setSqlSessionFactoryBeanName("sqlSession");
		return mapperConfigurer;
	}
	
}
