package raksh.login.form.service;

import raksh.login.form.dto.ForgotPasswordDTO;

public interface ForgotService {

	public boolean validateForgotPassword(ForgotPasswordDTO dto);
	public String validateForgot(ForgotPasswordDTO dto);

}
