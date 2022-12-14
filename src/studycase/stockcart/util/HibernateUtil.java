package studycase.stockcart.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import studycase.stockcart.model.entity.KdvTypeCardModel;
import studycase.stockcart.model.entity.StockCardModel;
import studycase.stockcart.model.entity.StockTypeCardModel;

public class HibernateUtil {
	private static SessionFactory sessionFactory ;
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://127.0.0.1:3306/casestudyhibernate?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root123");
				// settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                          settings.put("Environment.hibernate.listeners.envers.autoRegister", "false");
                         
		settings.put(Environment.HBM2DDL_AUTO, "update");
//				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				configuration.setProperties(settings);

				configuration.addAnnotatedClass(StockTypeCardModel.class);
				configuration.addAnnotatedClass(KdvTypeCardModel.class);
				configuration.addAnnotatedClass(StockCardModel.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;}

}

/*	private static final SessionFactory sessionFactory=buildSessionFactory();
 * private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure()
					.addAnnotatedClass(StockCardModel.class)
					.addAnnotatedClass(KdvTypeCardModel.class)
					.addAnnotatedClass(StockTypeCardModel.class)
					.buildSessionFactory();
		} catch (Throwable ex) {
			
			throw new ExceptionInInitializerError(ex);
		}
	}
 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
 
	public static void shutdown() {
		getSessionFactory().close();
	}*/

/*
 * 	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();

				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://127.0.0.1:3306/casestudyhibernate?useSSL=false");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "root123");
				// settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

				settings.put(Environment.SHOW_SQL, "true");

				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                          settings.put("hibernate.listeners.envers.autoRegister", "false");
                          settings.put("hibernate.listeners.envers.type_resolution_provider", "org.hibernate.envers.event.EnversTypeResolver");
                          settings.put("hibernate.listeners.envers.session_factory_observer", "org.hibernate.envers.event.AuditEventListener");
		settings.put(Environment.HBM2DDL_AUTO, "update");
//				settings.put(Environment.HBM2DDL_AUTO, "create-drop");
				configuration.setProperties(settings);

				configuration.addAnnotatedClass(StockTypeCardModel.class);
				configuration.addAnnotatedClass(KdvTypeCardModel.class);
				configuration.addAnnotatedClass(StockCardModel.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();

				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}*/
