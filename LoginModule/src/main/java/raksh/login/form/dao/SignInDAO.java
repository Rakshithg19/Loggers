package raksh.login.form.dao;

import raksh.login.form.entity.LoginEntity;

public interface SignInDAO {
	public LoginEntity fetchByEmailAndPassword(String email,String password);
}
