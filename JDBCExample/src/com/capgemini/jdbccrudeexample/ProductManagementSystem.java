package com.capgemini.jdbccrudeexample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ProductManagementSystem {
	
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
	public void createProduct() {
		try {
		stmt = con.createStatement();
		int i = stmt.executeUpdate("Create table products(pid number primary key,pname varchar2(20),price number(10,2))");
		System.out.println(i);
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
	public void insertIntoProduct() {
		try {
			stmt = con.createStatement();
			String insertData = "insert into products values(123,'Pen',25.45)";
			int i = stmt.executeUpdate(insertData);
			if(i!=0) {
				System.out.println("Inserted");
			}else {
				System.out.println("Not Inserted");
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
	int productid;
	String productName ;
	float productPrice ;
	public void readProductDetails() {
		System.out.println("Enter the product Details");
		System.out.println("Enter Product id");
		productid = sc.nextInt();
		System.out.println("Enter Product name");
		productName = sc.next();
		System.out.println("Enter Product price");
		productPrice = sc.nextFloat();
		
	}
	public void insertIntoProductUsingPS() {
		try {
			stmt = con.createStatement();
			String insertData = "insert into products values(?,?,?)";
			pstmt = con.prepareStatement(insertData);
			readProductDetails();
			pstmt.setInt(1, productid);
			pstmt.setString(2, productName);
			pstmt.setFloat(3, productPrice);
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
	public void getAllProduct() {
		try {
			stmt=con.createStatement();
		    rs=stmt.executeQuery("select * from products");
		    System.out.println("=====================");
			System.out.println("PID"+"\t\t\t"+"PNAME"+"\t\t\t"+"PRICE");
			System.out.println("=========================================");
				
		while(rs.next()){
			System.out.println( rs.getInt(1) + "\t\t\t" + rs.getString(2)+"\t\t\t"+ rs.getFloat(3));
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
	public void getProductbyId() {
		try {
			String getProduct = "select * from products where pid = ?";
			pstmt = con.prepareStatement(getProduct);
			System.out.println("Enter productId");
			int id = sc.nextInt();
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			System.out.println("=====================");
			System.out.println("PID"+"\t\t\t"+"PNAME"+"\t\t\t"+"PRICE");
			System.out.println("=========================================");
				while(rs.next()){
					System.out.println(rs.getInt(1) + "\t\t\t" + rs.getString(2)+"\t\t\t"+ rs.getFloat(3));
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
	public void updateProductUsingId() {
		
		 try {
		        String updateProduct = "update products set price = ?,pname=? where pid = ?";
		        pstmt = con.prepareStatement(updateProduct);
		        System.out.println("Enter the product id");
		        int id = sc.nextInt();
		        System.out.println("Enter the product price");
		        float price = sc.nextFloat();
		        System.out.println("Enter the product name");
		        String name = sc.next();
		        pstmt.setFloat(1, price);
		        pstmt.setString(2, name);
		        pstmt.setInt(3, id);
		        int i = pstmt.executeUpdate();
		        if(i != 0) {
		            System.out.println("data updated successfully");
		        }else {
		            System.out.println("data not updated successfully");
		        }
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }finally {
		            try {
		                pstmt.close();
		                //rs.close();
		            } catch (SQLException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }

		        }
}
	public void deleteProductUsingID() {
		 try {
		        String deleteProduct = "delete from products where pid = ?";
		        pstmt = con.prepareStatement(deleteProduct);
		        System.out.println("Enter the product id");
		        int id = sc.nextInt();
		        pstmt.setInt(1, id);
		        int i = pstmt.executeUpdate();
		        if(i != 0) {
		            System.out.println("product deleted successfully");
		        }else {
		            System.out.println("product not deleted  successfully");
		        }
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }finally {
		            try {
		                pstmt.close();
		                //rs.close();
		            } catch (SQLException e) {
		                // TODO Auto-generated catch block
		                e.printStackTrace();
		            }

		        }
	}
}
