package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.revature.util.ConnectionPool;

public class Driver {

	public static void main(String[] args) throws SQLException {
		
		ResultSet rs = null;
		Connection connObj = null;
		PreparedStatement pstmtObj = null;
		ConnectionPool jdbcObj = new ConnectionPool();
		
		// surround everything in a try/catch
		try {
			DataSource dataSource = jdbcObj.setUpPool();
			jdbcObj.printDbStatus();
			//get the connection (from the pool)
			System.out.println("===============Making a new connection Object for a DB operation!===================");
			connObj = dataSource.getConnection();
			
			//print the dbStatus()
			jdbcObj.printDbStatus();
			// use the fetch connection to execute a query from heroes dB
			pstmtObj = connObj.prepareStatement("SELECT * FROM heroes");
			
			rs = pstmtObj.executeQuery();
			// iterate over the result set returned
			while(rs.next()) {
				System.out.println("Hero name is "+rs.getString("hero_name"));
			}
			
			//release db connection obj back to the pool
			System.out.println("\n==================Realeasing the db connection object back to the pool.==============================");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
//			if( rs != null) {
//				rs.close();
//			}
//			
//			if(pstmtObj != null) {
//				pstmtObj.close();
//			}
			
			connObj.close(); //close the specific connection so it can be sent back to the pool
			// this sends the connection to an IDLE state .... it can be used again
		}
	
		jdbcObj.printDbStatus();
		
		
	}

}
