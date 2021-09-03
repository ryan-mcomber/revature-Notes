package com.revature.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

// think abou this as our ConnectionUtil.java... but on steroids....
// we need to use a special library that gives the ability to create a POOl of connections, so we can
// perform multiple operations on the db at once
public class ConnectionPool {

	/**
	 * We will use this class to supply general database credentials and attain an object called GenericObjectPool
	 * 
	 * gPool is a special object that holds all the connection to our DB at once
	 * 
	 * HAving a connection pool drastically increases performance whenever we perform a CRUD operation on the DB
	 */
	
	//if you were doing this in your own project, or in a REAL application, use the application.properties file
	// and the Properties object in Java which you use to READ from that file and supply the credentials
	static final String JDBC_DRIVER = "org.postgresql.Driver";
	static final String JDBC_DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	static final String JDBC_USER = "postgres";
	static final String JDBC_PASS = "password";
	
	
	private static GenericObjectPool gPool = null;
	
	//Apache commons dbcp gives us the functionality to create a connection pool. But we have to do so
	// by using its specific class and functionality called GenericObjectPool.
	
	public DataSource setUpPool () throws Exception {
		
		Class.forName(JDBC_DRIVER);
		
		// create an instance of the Generic Object Pool that holds our pool of connection objects
		gPool = new GenericObjectPool();
		gPool.setMaxActive(5);
		
		// Create a connectionFactory object which will be used by the pool object to reate the connections (which are all objects)
		ConnectionFactory cf = new DriverManagerConnectionFactory(JDBC_DB_URL,JDBC_USER,JDBC_PASS);
		
		PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf,gPool, null, null, false, true);
		
		return new PoolingDataSource(gPool);
		
	}
	
	public GenericObjectPool getConnectionPool() {
		return gPool;
	}
	
	//for our own benefit let's create a method to print the connection pool status
	public void printDbStatus() {
		
		System.out.println("Max: " + getConnectionPool().getMaxActive()+"; Active: "+getConnectionPool().getNumActive() + 
				"; Idle: "+getConnectionPool().getNumIdle());
	}
	
}
