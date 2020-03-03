package raksh.login.form.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raksh.login.form.dao.LoginDAO;
import raksh.login.form.dto.LoginDTO;
import raksh.login.form.entity.LoginEntity;
@Service
public class LoginServiceDAOImpl implements LoginServiceDAO{
	private static Logger  logger = Logger.getLogger(LoginServiceDAOImpl.class);
	@Autowired
	private LoginDAO dao;

	public LoginServiceDAOImpl() {
		logger.info("invoked"+this.getClass().getSimpleName());
	}

	public boolean validateAndSave(LoginDTO dto) {
		boolean valid = false;
		try {
			logger.info("save invoked " +dto);

			if(Objects.nonNull(dto)) {
				logger.info("starting validation for " +dto);
				String Username = dto.getUname();
				if (Username !=null && !Username.isEmpty() && Username.length() >=5) {
					logger.info("Username is valid");
				valid = true;
				} else {
					logger.info("Username is invalid");
					if(Username == null) {
						logger.info("Username is null");
					}
					if(Username !=null && Username.length() <5) {
						logger.info("name length is less than 5");
					}
					valid = false;
				}
		
				String Email = dto.getEmail();
				if (Email !=null && !Email.isEmpty() && Email.length() >=5) {
					logger.info("Email is valid");
					valid = true;	
			} else {
				if(valid) {
					logger.info("Email is invalid");
					valid = false;
					
				}
			}
			
				String Password = dto.getPswd();
				if (Password !=null && !Password.isEmpty() && Password.length() >=5) {
					logger.info("Password is valid");
					valid = true;	
			} else {
				if(valid) {
					logger.info("Password is invalid");
					valid = false;
					
				}
			}
			
				String ConformPassword = dto.getConfirmpswd();
				if (ConformPassword !=null && !ConformPassword.isEmpty() && ConformPassword.length() >=5) {
					logger.info("ConformPassword is valid");
					valid = true;	
			} else {
				if(valid) {
					logger.info("ConformPassword is invalid");
					valid = false;
				}		
		}
			}
			//return valid;
			
			if(valid) {
				System.out.println("Data is valid ,will convert  to entity");
				
				LoginEntity entity = new LoginEntity();
				
				BeanUtils.copyProperties(dto, entity);
				LoginEntity entity1 = dao.fetchByEmail(dto.getEmail());
			
				logger.info("entity is ready \t "+ entity);
				dao.save(entity);
			}
			
		} catch(Exception e) {
			logger.error("--Exception occured--");
		}
		return false;
	}
		
	}