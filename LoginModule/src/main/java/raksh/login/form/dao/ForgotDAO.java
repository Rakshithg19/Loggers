package raksh.login.form.dao;

import raksh.login.form.entity.LoginEntity;

public interface ForgotDAO {
	
	public LoginEntity fetchByEmail(String email,String pwd);
	//public RegisterEntity updatePasswordByEmail(String pwd, String mail);
}
