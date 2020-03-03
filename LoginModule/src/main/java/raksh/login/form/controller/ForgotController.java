package raksh.login.form.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import raksh.login.form.dto.ForgotPasswordDTO;
import raksh.login.form.service.ForgotService;

@Component
@RequestMapping
public class ForgotController {
	private static Logger  logger = Logger.getLogger(ForgotController.class);
	@Autowired
	private ForgotService service;

	public ForgotController() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping("/forgot.do")
	public String onForgot(ForgotPasswordDTO dto, ModelMap map) {
		
		logger.warn("warn message --> inside getMessage()...");
		logger.error("error message --> inside getMessage()..");
		try {

			String C = this.service.validateForgot(dto);
			boolean valid = this.service.validateForgotPassword(dto);
			if (valid) {
				ModelMap success = map.addAttribute("email", dto.getEmail());
				ModelMap success1 = map.addAttribute("password", dto.getPassword());
				ModelMap success2 = map.addAttribute("confirmPassword", dto.getConfirmPassword());
			} else {
				ModelMap failure = map.addAttribute("failureMessage", "forgotPassword unsuccessfull");
			}

			logger.info("Invoked onForgot method");
			logger.info(dto);

		} catch (Exception e) {
			logger.error("--Exception occured--");
		}
		return "Forgot";
	}
}
