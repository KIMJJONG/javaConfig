package sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.mapper.maria.DoMapper;
import sample.model.StudentInfo;

@Service("doService")
public class DoServiceImpl implements DoService {
	
	private static final Logger logger = LoggerFactory.getLogger(DoServiceImpl.class);
	
	@Autowired
	private DoMapper doMapper;
	
	public DoServiceImpl() {
		logger.debug("BoServiceImpl 생성자");
	}
	
	public void getStudentService(String studentId) {
		logger.debug("getStudentService 실행");
		StudentInfo info = doMapper.getStudentInfo(studentId);
		logger.debug("Student 이름: {}", info.getStudentName());
	}
	
}
