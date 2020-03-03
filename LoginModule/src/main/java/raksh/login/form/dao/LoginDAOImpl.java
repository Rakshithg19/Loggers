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
public class LoginDAOImpl implements LoginDAO {
	private static Logger  logger = Logger.getLogger(LoginDAOImpl.class);
	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	
	public LoginDAOImpl() {
		logger.info("invoked"+this.getClass().getSimpleName());
	}

	public void save(LoginEntity entity) {
		logger.info("Invoking save method");
		Session session = null;
		try {

			logger.info("session created");
			session = factory.openSession();
			logger.info("Transaction begun");
			session.beginTransaction();
			logger.info("Entity saving...");
			session.save(entity);
			logger.info("Commiting....");
			session.getTransaction().commit();
			logger.info("Data saved");
		
		} catch (Exception e) {
			logger.error("--Exception occured--");
			logger.info("INFO:" + e.getMessage());
		} finally {
			
			session.close();
		}

	
	}


	public LoginEntity fetchByEmail(String email) {
		Session session = factory.openSession();
		try {
			String syntax = "Select le  from LoginEntity le where le.email =:email";
			Query<?> query = session.createQuery(syntax);
			Object result = query.uniqueResult();
			if(Objects.nonNull(result)) {
				
				System.out.println("status found"+email);
						
			}
			else {
				System.out.println("status not found "+email);
			
			}
			LoginEntity entity =(LoginEntity) result;
			return entity;
		}
		catch(HibernateException he) {
			logger.error("--Exception occured--");
		}
		
		finally {
			if(Objects.nonNull(session))
			logger.info("closing connection");
			session.close();
		}
		
	
		return null;
	}

}

	
