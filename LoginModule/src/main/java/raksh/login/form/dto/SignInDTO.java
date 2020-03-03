package raksh.login.form.dto;

import org.apache.log4j.Logger;

import lombok.Data;


@Data
public class SignInDTO {
	private static Logger  logger = Logger.getLogger(SignInDTO.class);
	private String email;
	private String password;
	
	public SignInDTO() {
		logger.info("invoked"+this.getClass().getSimpleName());
	}
}
