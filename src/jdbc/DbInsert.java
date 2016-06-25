package jdbc;

import java.sql.*;

public class DbInsert {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement qpstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/dbtest?characterEncoding=gbk","root", "admin");
			String strsql = "insert into person(name,age) values(?,?)";
			pstmt = conn.prepareStatement(strsql);
			pstmt.setString(1, "李晓华");
			pstmt.setInt(2, 22);
			pstmt.executeUpdate();
			
			strsql = "select * from person";
			qpstmt = conn.prepareStatement(strsql);
			rs = qpstmt.executeQuery();			
			while (rs.next()) {
				int id=rs.getInt("id");
				String name = rs.getString("name");
				int age=rs.getInt("age");
				System.out.println("编号："+id+" 姓名: " +name+" 年龄："+age);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null)
					rs.close();
				if (pstmt!=null)
					pstmt.close();
				if (qpstmt!=null)
					qpstmt.close();
				if (conn!=null)
					conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}