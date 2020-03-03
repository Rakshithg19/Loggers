package raksh.login.form.dao;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import raksh.login.form.controller.ForgotController;
import raksh.login.form.entity.LoginEntity;

@Component
public class ForgotDAOImpl implements ForgotDAO {
	private static Logger  logger = Logger.getLogger(ForgotDAOImpl.class);
	@Autowired
	private SessionFactory factory;

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public ForgotDAOImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}


	public LoginEntity fetchByEmail(String email, String pwd) {
		logger.info("Invoked fetchByName() ....");
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			// session.getTransaction();
			logger.info("fetching...");
			String hql = "SELECT re from RegisterEntity re where email='" + email + "'";
			logger.info("Email" + hql);
			Query query = session.getNamedQuery("updatePasswordByEmail");

			query.setParameter("password", pwd);
			query.setParameter("email", email);

			Object result = query.executeUpdate();
			tx.commit();
			if (Objects.nonNull(result)) {
				logger.info("Entity found" + result);

			} else {
				logger.info("Entity not found");
			}

		} catch (Exception e) {
			logger.error("--Exception occured--");
			logger.info("INFO:" + e.getMessage());
		} finally {
			session.close();
		}
		return null;
	}
	/* public RegisterEntity updatePasswordByEmail(String pwd, String mail) {
		 * Session session = factory.openSession(); try {
		 * System.out.println("invoke program...");
		 * 
		 * Query query = session.getNamedQuery("updatePasswordByEmail");
		 * 
		 * query.setParameter("password", pwd); query.setParameter("email", mail);
		 * 
		 * Object result = query.executeUpdate(); if (Objects.nonNull(result)) {
		 * System.out.println("Entity found");
		 * 
		 * } else { System.out.println("Entity not found"); }
		 * 
		 * } catch (HibernateException he) { he.printStackTrace(); } finally { if
		 * (Objects.nonNull(session)) session.close(); } return null; } }
		 */
}
