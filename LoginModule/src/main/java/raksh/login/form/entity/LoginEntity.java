package raksh.login.form.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import lombok.Data;
import raksh.login.form.controller.ForgotController;
@Component
@Entity
@Table(name = "login_details")
@NamedQueries ({
	@NamedQuery(name = "fetchByEmail", query = "Select le  from LoginEntity le where le.email =:email"),
	@NamedQuery(name ="fetchByEmailAndPassword" , query="select le from LoginEntity le where le.email=:email and le.password=:password"),
@NamedQuery(name = "updatePasswordByEmail", query = "update RegisterEntity re set re.password=:password where re.email=:email")}

)


@Data
	
	public class LoginEntity implements Serializable {
	private static Logger  logger = Logger.getLogger(LoginEntity.class);
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private int id;
	@Column(name = "uname")
		private String uname;
		@Column(name = "email")
		private String email;
		@Column(name = "mobile")
		private String mobile;
		@Column(name = "pswd")
		private String pswd;
		@Column(name = "confirmpswd")
		private String confirmpswd;

	public LoginEntity() {
		logger.info("created"+this.getClass().getName());
	}

	public LoginEntity(int id, String uname, String email, String mobile, String pswd, String confirmpswd) {
		super();
		this.id = id;
		this.uname = uname;
		this.email = email;
		this.mobile = mobile;
		this.pswd = pswd;
		this.confirmpswd = confirmpswd;
	}
}
