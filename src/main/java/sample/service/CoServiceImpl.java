package sample.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.mapper.sqlite.CoMapper;
import sample.model.SoliderInfo;

@Service
public class CoServiceImpl implements CoService {
	
	private static final Logger logger = LoggerFactory.getLogger(CoServiceImpl.class);
	
	@Autowired
	private CoMapper coMapper;
	
	public CoServiceImpl() {
		logger.debug("CoServiceImpl 생성자");
	}
	
	public void getSoliderService(String soliderId) {
		logger.debug("getSoliderService 실행");
		SoliderInfo info = coMapper.getSoliderInfo(soliderId);
		logger.debug("Solider 이름: {}", info.getSoliderName());
	}
	
}
