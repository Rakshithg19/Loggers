package raksh.login.form.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



import raksh.login.form.dto.LoginDTO;
import raksh.login.form.service.LoginServiceDAO;

@Component
@RequestMapping("/")
public class LoginController {
	private static Logger  logger = Logger.getLogger(LoginController.class);	
	
	@Autowired
	private LoginServiceDAO service;
	
	public LoginController() {
		
		logger.info("created"+this.getClass().getSimpleName());
	}
	@RequestMapping("/SignUp.do")
	public String toSave(LoginDTO dto, ModelMap map) {
		logger.warn("warn message --> inside getMessage()...");
		logger.error("error message --> inside getMessage()..");
		try {
			logger.info("invoked onSignup");
		//	logger.error("error message --> inside getMessage()..");
			boolean check = this.service.validateAndSave(dto);
			if (check) {
				map.addAttribute("Signup.jsp", "Data saved");
			} else {
				map.addAttribute("Signup.jsp", "Data not saved");
			}
		
		}
		catch (Exception e) {
			
			logger.error("--Exception occured--");
		}
		return "SignUp";
	}
}
