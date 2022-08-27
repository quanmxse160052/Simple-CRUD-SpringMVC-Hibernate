package quanmx.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import quanmx.customer.CustomerDTO;

/**
 *
 * @author Dell
 */
public class HibernateSessionFactory {

    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure("quanmx/hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(CustomerDTO.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
