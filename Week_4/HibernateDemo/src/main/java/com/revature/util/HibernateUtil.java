package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

		private static Session ses;
		
		
		//SessionFactory is created by providing a configuration object
		private static SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//this method obtains a JDBC connection which we can use to perform a transaction against the DB
		public static Session getSession() {
			if (ses == null) {
				ses =sf.openSession();
			}
			
			return ses; // We will use the Session object in our DAO layer to perform CRUD methods against the DB
		}
		
		public static void CloseSes() {
			ses.close();
			sf.close();
		}
}
