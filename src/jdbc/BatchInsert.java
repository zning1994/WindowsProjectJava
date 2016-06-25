package jdbc;

import java.sql.*;

public class BatchInsert {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/dbtest?characterEncoding=gbk","root", "admin");
			String strsql = "insert into person(name,age) values(?,?)";

			pstmt = conn.prepareStatement(strsql);
			pstmt2 = conn.prepareStatement(strsql);
			
			long s1 = System.currentTimeMillis(); 
			for (int i=0;i<10000;i++) {
				pstmt.setString(1, "李晓华");
				pstmt.setInt(2, 22);
				pstmt.executeUpdate();
			}
			
			long s2 = System.currentTimeMillis();
			for (int i=0;i<10000;i++) {
				pstmt2.setString(1, "李晓华");
				pstmt2.setInt(2, 22);
				pstmt2.addBatch();
			}			
			pstmt.executeBatch();
			
			long s3 = System.currentTimeMillis();
			
			System.out.println("execution time for per item updating : " + (s2-s1) + "  milliseconds");
			System.out.println("execution time for batch updating: " + (s3-s2) + "  milliseconds");
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null)
					rs.close();
				if (pstmt!=null)
					pstmt.close();
				if (conn!=null)
					conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
