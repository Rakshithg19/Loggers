package raksh.login.form.service;

import raksh.login.form.dto.SignInDTO;

public interface SignInService {
	public boolean validateAndSave(SignInDTO signInDTO);
}		
