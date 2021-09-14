package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Crime;
import com.revature.util.HibernateUtil;

public class CrimeDao {
	
	public int insert (Crime crime) {
		
		// capture a session
		Session ses = HibernateUtil.getSession();
		
		// import from Hibernate (not JPA)
		Transaction tx = ses.beginTransaction();
		
		int pk = (int) ses.save(crime); // the save() session method performs an insert on the database
		
		tx.commit(); //commit the transaction
		
		return pk; // return the auto-gen primary key
	}

}
