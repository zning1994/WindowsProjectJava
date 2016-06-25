package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Transaction {
	
	 public static void main(String [] args) {
		  Connection conn = null;
		  Statement stmt = null;
		  
		  try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/dbtest?characterEncoding=gbk","root", "admin");
		   
//			  conn.setAutoCommit(false);

			  stmt = conn.createStatement();
			  stmt.execute("insert into person values (98,'Õı¥Ô',11)");
			  stmt.execute("insert into person values (99,'’‘À®',15)");
			  stmt.execute("insert into person values (100,'’‘ﬁ±',23)");
			   
//			  conn.commit();
//			  conn.setAutoCommit(true);
			  
		  } catch (ClassNotFoundException e) {
			  e.printStackTrace();
		  } catch (SQLException e) {
			  if(conn!=null) {
				  try {
					  conn.rollback();
					  conn.setAutoCommit(true);
				  } catch (SQLException e1) {
					  e1.printStackTrace();
				  }
			  }
			  e.printStackTrace();
		  } finally {
			  if(stmt!=null) {
				  try {
					  stmt.close();
				  } catch (SQLException e) {
					  e.printStackTrace();
				  }
			  }
			  if(conn!=null) {
				  try {
					  conn.close();
				  } catch (SQLException e) {
					  e.printStackTrace();
				  }
			  }
		  }
	 }
}
