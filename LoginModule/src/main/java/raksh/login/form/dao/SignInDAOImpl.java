package raksh.login.form.dao;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import raksh.login.form.entity.LoginEntity;
@Repository
public class SignInDAOImpl implements SignInDAO {
	private static Logger  logger = Logger.getLogger(SignInDAOImpl.class);
	@Autowired
	private SessionFactory factory;
	
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public SignInDAOImpl() {
		logger.info("invoked"+this.getClass().getSimpleName());
	}
	public LoginEntity fetchByEmailAndPassword(String email, String password) {
Session session=null;
		
		try {
			session=factory.openSession();
			logger.info("invoke program...");
			
			Query  query =session.getNamedQuery("fetchByEmailAndPassword");
			
			query.setParameter("email", email);
			query.setParameter("password", password);
			Object result=query.uniqueResult();
			if(Objects.nonNull(result))
			{
				logger.info("Entity found"+"\t"+email+"\t"+password);
				LoginEntity entity=(LoginEntity) result;
				return entity;
			}
			else
			{
				logger.info("Entity not found");
				return null;
			}
				
			} catch(HibernateException she) {
				logger.error("--Exception occured--");
			} finally {
				if(Objects.nonNull(session));
				System.out.println("close session");
				session.close();
			}

		return null;
	}

}