package sample.controller;

import java.security.NoSuchAlgorithmException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.zaxxer.hikari.HikariPoolMXBean;

import sample.model.StudentInfo;
import sample.service.DoService;

@Controller
public class DoController {
	
	private static final Logger logger = LoggerFactory.getLogger(DoController.class);
	
	@Lazy
	@Autowired
	private DoService doService;
	
	@Autowired
	private HikariPoolMXBean poolMXBean;
	
	public DoController() {
		logger.debug("DoController 생성자");
	}
	
	@PostConstruct
	public void init() {
		logger.debug("빈 초기화");
	}
	
	@PreDestroy
	public void close() {
		logger.debug("빈 소멸전");
	}
	
	@RequestMapping("/getStudent.do")
	public ModelAndView getStudent(@ModelAttribute StudentInfo studentInfo) {
		logger.debug("getStudent.do 호출");
		logger.debug("활성 커넥션(Controller): {}", poolMXBean.getActiveConnections());
		logger.debug("유휴 커넥션(Controller): {}", poolMXBean.getIdleConnections());
		logger.debug(studentInfo.getStudentId());
		doService.getStudentService(studentInfo.getStudentId());
		logger.debug("활성 커넥션(Controller): {}", poolMXBean.getActiveConnections());
		logger.debug("유휴 커넥션(Controller): {}", poolMXBean.getIdleConnections());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:index.jsp");
		return mav;
	}

}
