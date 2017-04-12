package bl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by root on 4/12/17.
 * Need for create Hibernate session, and close it
 */
public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.out.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * Need for close Hibernate session
	 */
	public static void shutdown() {
		getSessionFactory().close();
	}
}
