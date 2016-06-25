package jdbc;
import java.sql.*;

public class QueryStatement {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/dbtest?characterEncoding=gbk","root", "admin");
			
			String strsql1 = "select * from person where name = '";
			stmt = conn.createStatement();
			stmt.executeQuery(strsql1 + "王达" + "\'");
			
			String strsql2 = "select * from person where name=? ";
			pstmt = conn.prepareStatement(strsql2);
			pstmt.setString(1, "王达");
			pstmt.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt!=null)
					stmt.close();
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