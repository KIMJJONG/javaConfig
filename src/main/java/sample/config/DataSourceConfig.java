package sample.config;

import java.lang.management.ManagementFactory;

import javax.management.JMX;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;

@Configuration
public class DataSourceConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

	public DataSourceConfig() {
		logger.debug("DataSourceConfig 생성자");
	}
	
	@Bean
	@Lazy
    public DataSource mariaDataSource() {
		logger.debug("mariaDataSource 실행");
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
//        dataSource.setUrl("jdbc:mariadb://127.0.0.1:3306/mysql");
//        dataSource.setUsername("root");
//        dataSource.setPassword("test1!@#");
//        return dataSource;
        HikariConfig hikari = new HikariConfig();
        hikari.setDriverClassName("org.mariadb.jdbc.Driver");
        hikari.setJdbcUrl("jdbc:mariadb://127.0.0.1:3306/mysql");
        hikari.setUsername("root");
        hikari.setPassword("test1!@#");
        hikari.setRegisterMbeans(true);
        hikari.setPoolName("hikari");
        HikariDataSource dataSource = new HikariDataSource(hikari);
        return dataSource;
    }
	
	@Bean
	public HikariPoolMXBean poolProxy() throws MalformedObjectNameException {
	    MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
	    ObjectName objectName = new ObjectName("com.zaxxer.hikari:type=Pool (hikari)");
	    return JMX.newMBeanProxy(mBeanServer, objectName, HikariPoolMXBean.class);
	}
	
	@Bean
    public DataSource postgresDataSource() {
		logger.debug("postgresDataSource 실행");
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("test1!@#");
//        return dataSource;
		HikariConfig hikari = new HikariConfig();
		hikari.setDriverClassName("org.postgresql.Driver");
		hikari.setJdbcUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
		hikari.setUsername("postgres");
		hikari.setPassword("test1!@#");
		HikariDataSource dataSource = new HikariDataSource(hikari);
        return dataSource;
    }
	
	@Bean
    public DataSource dataSource() {
		logger.debug("dataSource 실행");
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("org.sqlite.JDBC");
//        dataSource.setUrl("jdbc:sqlite:C:/eGovFrame/workspace/sqlite/solider.db");
//        dataSource.setUsername("admin");
//        dataSource.setPassword("admin");
//        return dataSource;
		HikariConfig hikari = new HikariConfig();
		hikari.setDriverClassName("org.sqlite.JDBC");
		hikari.setJdbcUrl("jdbc:sqlite:C:/eGovFrame/workspace/sqlite/solider.db");
		hikari.setUsername("admin");
		hikari.setPassword("admin");
		HikariDataSource dataSource = new HikariDataSource(hikari);
        return dataSource;
    }

}
