package sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import sample.model.EmployeeInfo;
import sample.service.AoService;

@Controller
public class AoController {
	
	private static final Logger logger = LoggerFactory.getLogger(AoController.class);
	
	@Autowired
	private AoService aoService;
	
	public AoController() {
		logger.debug("aoController 생성자");
	}
	
	@RequestMapping("/getEmployee.ao")
	public ModelAndView getEmployee(@ModelAttribute EmployeeInfo employeeInfo) {
		logger.debug("getEmployee.ao 호출");
		logger.debug(employeeInfo.getEmployeeId());
		aoService.getEmployeeService(employeeInfo.getEmployeeId());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:index.jsp");
		return mav;
	}
	
}
