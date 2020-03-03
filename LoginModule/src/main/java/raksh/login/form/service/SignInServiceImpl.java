package raksh.login.form.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raksh.login.form.dao.SignInDAO;
import raksh.login.form.dto.SignInDTO;
import raksh.login.form.entity.LoginEntity;

@Service
public class SignInServiceImpl implements SignInService {
	private static Logger  logger = Logger.getLogger(SignInServiceImpl.class);
	@Autowired
	private SignInDAO signInDAO;
public SignInServiceImpl() {
	logger.info("invoked"+this.getClass().getSimpleName());
}
	public boolean validateAndSave(SignInDTO signInDTO) {
boolean valid = false;
		
		try {
			logger.info("invoked validateAndSave");
			if (Objects.nonNull(signInDTO)) { 
				logger.info("starting validation for " + signInDTO);
			   String email = signInDTO.getEmail(); 
			   if (email != null && !email.isEmpty() && email.length() >= 10) { 
				   logger.info("email is valid"); 
				   valid = true; 
				   } else
			   
			  { 
					   logger.info("email is invalid"); 
				  valid = false;
				} 
			  }
			
			  String password = signInDTO.getPassword();
			  if (valid && password != null &&  !password.isEmpty() && password.length() >= 6) { 
				  logger.info("password is valid"); 
			  valid = true; 
			  } else {
				  logger.info("password is invalid"); 
			  valid = false; 
			  }  
			  //if (valid)
			  
			  logger.info("Data is valid ,will convert  to entity");

			LoginEntity signupEntity = new LoginEntity();
			BeanUtils.copyProperties(signInDTO, signupEntity);


			LoginEntity signupEntity1 = signInDAO.fetchByEmailAndPassword(signInDTO.getEmail(), signInDTO.getPassword());

			if (signupEntity1 != null) {
				logger.info("Entity is ready \t" + signupEntity1);
				// dao.save(regEntity);
				// System.out.println("Entity is saved");
				signInDAO.fetchByEmailAndPassword(signInDTO.getEmail(), signInDTO.getPassword());
				logger.info("login details exist");
				return true;
			} else {
				logger.info("login details does not exist");
				return false;
			}
			
		} catch(Exception e) {
			logger.error("--Exception occured--");
		}
		
		return true;
	}
	
}