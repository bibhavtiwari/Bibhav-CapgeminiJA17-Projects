package com.capgemini.jdbcexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			//register the driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","221829208");
			//create the statement
			Statement stmt=con.createStatement();
			//execute the sql statement
			ResultSet rs=stmt.executeQuery("select * from department");
			while(rs.next()){
				System.out.println("DID: " + rs.getInt(1) + "\nDNAME: " + rs.getString(2));
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println();
			//close the connection
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}