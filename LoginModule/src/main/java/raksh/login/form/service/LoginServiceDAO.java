package raksh.login.form.service;

import raksh.login.form.dto.LoginDTO;


public interface LoginServiceDAO {
	public boolean validateAndSave(LoginDTO dto);

}
