package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScrollResultSet {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/dbtest?characterEncoding=gbk","root", "admin");
			String strsql = "select id,name,age from person";
			PreparedStatement pstmt = conn.prepareStatement(strsql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
			rs.absolute(5); //绝对位置
			print(rs);
			rs.previous();
			print(rs);
			
			
			int concurrency =  rs.getConcurrency();
			if (concurrency==ResultSet.CONCUR_UPDATABLE) {
				System.out.println("result updatable!");
				rs.updateInt(3, 60);
				rs.updateRow();
			} else {
				System.out.println("result readonly!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void print(ResultSet rs) throws SQLException{
		int id = rs.getInt("id");
		String name = rs.getString("name");
		int age=rs.getInt("age");
		System.out.println("编号："+id+"姓名: " +name+" 年龄："+age);
	}
}
