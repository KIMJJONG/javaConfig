package sample.controller2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sample.model.SoliderInfo;
import sample.service.CoService;

@Controller
public class CoController {
	
	private static final Logger logger = LoggerFactory.getLogger(CoController.class);
	
	@Autowired
	private CoService coService;
	
	public CoController() {
		logger.debug("CoController 생성자");
	}
	
	@RequestMapping("/getSolider.co")
	public ModelAndView getSolider(@ModelAttribute SoliderInfo soliderInfo) {
		logger.debug("getSolider.co 호출");
		logger.debug(soliderInfo.getSoliderId());
		coService.getSoliderService(soliderInfo.getSoliderId());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:index.jsp");
		return mav;
	}
}
