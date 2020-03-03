package raksh.login.form.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



import raksh.login.form.dto.SignInDTO;
import raksh.login.form.service.SignInService;

@Controller
@RequestMapping("/")
public class SignInController {
	
private static Logger  logger = Logger.getLogger(SignInController.class);	
	@Autowired
	private SignInService loginService;
	
	public SignInController() {
		logger.info(this.getClass().getSimpleName()+ " object created");
	}
	@RequestMapping("SignIn.do")
	public String onLogin(SignInDTO signInDTO,ModelMap map) {
		/*logger.trace("trace message --> inside getMessage()...");
		logger.debug("debug message --> inside getMessage()...");
		logger.warn("warn message --> inside getMessage()...");
		logger.fatal("fatal message --> inside getMessage()..."); */
		
		logger.warn("warn message --> inside getMessage()...");
		logger.error("error message --> inside getMessage()..");
		
	try {
		logger.info("info message --> inside getMessage()...");
		
		logger.info(signInDTO);
		
		boolean check = this.loginService.validateAndSave(signInDTO);
				
		if (check) {
			
			ModelMap Success = map.addAttribute("Success", "Login Successfull");
			
			return "Success";
			
		}else {
			
			ModelMap failure = map.addAttribute("Login", "Login Unsuccessfull");
			
			}
			
		} catch (Exception e) {
			logger.error("--Exception occured--");
		}
		return "SignIn";
	}
}

