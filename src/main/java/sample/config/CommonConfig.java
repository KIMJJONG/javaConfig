package sample.config;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(
	basePackages = "sample",
	useDefaultFilters = false,
	includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Service.class, Mapper.class})
)
//@ComponentScan(basePackages = {"sample.service.*"})
//@MapperScan(basePackages = {"sample.mapper.*"})
public class CommonConfig {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonConfig.class);
	
	public CommonConfig() {
		logger.debug("CommonConfig 생성자");
	}
	
}
