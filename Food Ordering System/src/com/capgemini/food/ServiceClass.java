package com.capgemini.food;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ServiceClass {
	static Connection con = null;
	static Statement stmt = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;
	static Scanner sc = new Scanner(System.in);

public Connection dbConnection() {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","221829208");
		}catch(Exception e) {
		e.printStackTrace();
	}
	
	return con;
}//close of dbconnection
int id;
String Name ;
String Address ;
String Password;
int Wallet;
public void readDetails() {
	System.out.println("Enter the  Details");
	System.out.println("Enter the id");
	id = sc.nextInt();
	System.out.println("Enter name");
	Name = sc.next();
	System.out.println("Enter Address");
	Address = sc.next();
	System.out.println("Enter Password");
	Password = sc.next();
	System.out.println("Enter the amount in Wallet");
	Wallet = sc.nextInt();
}
public void createCustomer() {
	try {
	stmt = con.createStatement();
	int i = stmt.executeUpdate("Create table bcustomer(custid number primary key,custname varchar2(20),custadd varchar2(50),custpswd varchar2(10),custwallet number(10))");
	if(i==0) {
		System.out.println("Table Created");
	}else {
		System.out.println("Table Not Created");
	}
	
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
public void insertIntoCustomer() {
	try {
		stmt = con.createStatement();
		String insertData = "insert into bcustomer values(?,?,?,?,?)";
		pstmt = con.prepareStatement(insertData);
		readDetails();
		pstmt.setInt(1, id);
		pstmt.setString(2, Name);
		pstmt.setString(3, Address);
		pstmt.setString(4, Password);
		pstmt.setInt(5, Wallet);
		
		int i = pstmt.executeUpdate();
		if(i!=0) {
			System.out.println("Inserted");
		}else {
			System.out.println("Not Inserted");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
		pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}
	
	
}
public void loginCustomer(int cid,String pass) {
	int temp = 0;
	boolean flag=false;
	try {
		stmt=con.createStatement();
		rs=stmt.executeQuery("select * from bcustomer");
		while(rs.next()) {
			if(rs.getString(1).equals(cid)&&rs.getString(4).equals(pass)) {
				System.out.println("Customer exists!");
				temp=rs.getInt(1);
				flag=true;
				break;
			}

		}
		
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			if(stmt==null) {
				throw new Exception();
			}
			stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public void displayCustomerbyID(int custid) {
	try {
		String getProduct = "select * from products where custid = ?";
		pstmt = con.prepareStatement(getProduct);
		pstmt.setInt(1, custid);
		rs = pstmt.executeQuery();
		System.out.println("=====================");
		System.out.println("CustID"+"\t\t\t"+"CustNAME"+"\t\t\t"+"CustAdd"+"\t\t\t"+"CustWallet");
		System.out.println("=========================================");
			while(rs.next()){
				System.out.println(rs.getInt(1) + "\t\t\t" + rs.getString(2)+"\t\t\t"+ rs.getString(3)+"\t\t\t"+rs.getInt(5));
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println();
			//close the connection
			try {
				rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
			
}
public void createVendor() {
	try {
	stmt = con.createStatement();
	int i = stmt.executeUpdate("Create table bvendor(venid number primary key,venname varchar2(20),venadd varchar2(50),venpswd varchar2(10),venwallet number(10))");
	if(i==0) {
		System.out.println("Table Created");
	}else {
		System.out.println("Table Not Created");
	}
	
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
public void insertIntoVendor() {
	try {
		stmt = con.createStatement();
		String insertData = "insert into bvendor values(?,?,?,?,?)";
		pstmt = con.prepareStatement(insertData);
		readDetails();
		pstmt.setInt(1, id);
		pstmt.setString(2, Name);
		pstmt.setString(3, Address);
		pstmt.setString(4, Password);
		pstmt.setInt(5, Wallet);
		
		int i = pstmt.executeUpdate();
		if(i!=0) {
			System.out.println("Inserted");
		}else {
			System.out.println("Not Inserted");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
		pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}
	
	
}
public boolean loginVendor(int vid,String pass) {
	boolean flag = false;
	try {
		stmt = con.createStatement();
		rs = stmt.executeQuery("select * from bvendor");
		
		while(rs.next()) {
			if(String.valueOf(rs.getInt(1)).equals(vid) && String.valueOf(rs.getString(4)).equals(pass)) {
				flag = true;
				break;
			}else {
				flag = false;
			}
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		
	}
	if(flag == true)
		return flag;
	else 
		return flag;
}//ending loginCustomer
public void createMenu() {
	try {
	stmt = con.createStatement();
	int i = stmt.executeUpdate("Create table bmenu(itemid number primary key,itemname varchar2(20),venid number, FOREIGN KEY(venid) REFERENCES bvendor(venid))");
	if(i==0) {
		System.out.println("Table Created");
	}else {
		System.out.println("Table Not Created");
	}
	
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
public void insertIntoMenu() {
	try {
		stmt = con.createStatement();
		String insertData = "insert into bmenu values(?,?,?)";
		pstmt = con.prepareStatement(insertData);
		System.out.println("Enter Item details");
		System.out.println("Enter Item id");
		int id = sc.nextInt();
		System.out.println("Enter item name");
		String item = sc.next();
		System.out.println("Enter vendor id");
		int vid = sc.nextInt();
		pstmt.setInt(1, id);
		pstmt.setString(2, item);
		pstmt.setInt(3, vid);
		
		int i = pstmt.executeUpdate();
		if(i!=0) {
			System.out.println("Inserted");
		}else {
			System.out.println("Not Inserted");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
		pstmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}
	
	
}

public void displayVendorbyID(int venid) {
	try {
		String getProduct = "select * from products where venid = ?";
		pstmt = con.prepareStatement(getProduct);
		pstmt.setInt(1, venid);
		rs = pstmt.executeQuery();
		System.out.println("=====================");
		System.out.println("VenID"+"\t\t\t"+"VenNAME"+"\t\t\t"+"VenAdd"+"\t\t\t"+"VenWallet");
		System.out.println("=========================================");
			while(rs.next()){
				System.out.println(rs.getInt(1) + "\t\t\t" + rs.getString(2)+"\t\t\t"+ rs.getString(3)+"\t\t\t"+rs.getInt(5));
			}
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println();
			//close the connection
			try {
				rs.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
			
}
public void createOrder() {
	try {
	stmt = con.createStatement();
	int i = stmt.executeUpdate("Create table orderb(orderid number primary key,custid number ,venid number, FOREIGN KEY(custid) REFERENCES bcustomer(custid), FOREIGN KEY(venid) REFERENCES bvendor(venid))");
	if(i==0) {
		System.out.println("Table Created");
	}else {
		System.out.println("Table Not Created");
	}
	
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			stmt.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
}
