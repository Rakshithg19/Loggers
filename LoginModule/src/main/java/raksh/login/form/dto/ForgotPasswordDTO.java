package raksh.login.form.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import lombok.Data;
import raksh.login.form.controller.ForgotController;
@Component
@Data
public class ForgotPasswordDTO implements Serializable {
	private static Logger  logger = Logger.getLogger(ForgotPasswordDTO.class);
	private String email;
	private String password;
	private String confirmPassword;
	public ForgotPasswordDTO() {
		logger.info("Created \t"+this.getClass().getSimpleName());
	}
}