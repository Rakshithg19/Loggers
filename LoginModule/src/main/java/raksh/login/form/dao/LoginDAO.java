package raksh.login.form.dao;

import raksh.login.form.entity.LoginEntity;

public interface LoginDAO {
	public void save(LoginEntity entity);
	public LoginEntity fetchByEmail(String email);
}
