package sample.controller2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class BoController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoController.class);
	
	public BoController() {
		logger.debug("BoController 생성자");
	}
	
}
