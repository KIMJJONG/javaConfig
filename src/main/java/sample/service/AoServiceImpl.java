package sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.mapper.postgres.AoMapper;
import sample.model.EmployeeInfo;

@Service
public class AoServiceImpl implements AoService {
	
	private static final Logger logger = LoggerFactory.getLogger(AoServiceImpl.class);
	
	@Autowired
	private AoMapper aoMapper;
	
	public AoServiceImpl() {
		logger.debug("AoServiceImpl 생성자");
	}
	
	public void getEmployeeService(String employeeId) {
		logger.debug("getEmployeeService 실행");
		EmployeeInfo info = aoMapper.getEmployeeInfo(employeeId);
		logger.debug("Employee 이름: {}", info.getEmployeeName());
	}
	
}
