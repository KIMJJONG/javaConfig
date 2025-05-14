package sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zaxxer.hikari.HikariPoolMXBean;

import sample.mapper.maria.DoMapper;
import sample.model.StudentInfo;

@Service
@Transactional("mariaTransactionManager")
@Lazy
public class DoServiceImpl implements DoService {
	
	private static final Logger logger = LoggerFactory.getLogger(DoServiceImpl.class);
	
	@Autowired
	private DoMapper doMapper;
	
	@Autowired
	private HikariPoolMXBean poolMXBean;
	
	public DoServiceImpl() {
		logger.debug("BoServiceImpl 생성자");
	}
	
	public void getStudentService(String studentId) {
		logger.debug("getStudentService 실행");
		logger.debug("활성 커넥션(Service): {}", poolMXBean.getActiveConnections());
		logger.debug("유휴 커넥션(Service): {}", poolMXBean.getIdleConnections());
		StudentInfo info = doMapper.getStudentInfo(studentId);
		logger.debug("활성 커넥션(Service): {}", poolMXBean.getActiveConnections());
		logger.debug("유휴 커넥션(Service): {}", poolMXBean.getIdleConnections());
		logger.debug("Student 이름: {}", info.getStudentName());
	}
	
}
