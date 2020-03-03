package raksh.login.form.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

import lombok.Data;
import raksh.login.form.controller.ForgotController;

@Data
public class LoginDTO implements Serializable {
	private static Logger  logger = Logger.getLogger(LoginDTO.class);
	private String uname;
	private String email;
	private String mobile;
	private String pswd;
	private String confirmpswd;

	LoginDTO() {
		logger.info("invoked");
	}
}

