package jdbc;
import java.sql.*;

public class DbQuery2 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/dbtest?characterEncoding=gbk","root", "admin");
			String strsql = "select id,name,age from person";
			pstmt = conn.prepareStatement(strsql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt(1);
				String name = rs.getString(2);
				int age=rs.getInt(3);
				System.out.println("±‡∫≈£∫"+id+"–’√˚: " +name+" ƒÍ¡‰£∫"+age);
			}
			rs.close();
			pstmt.close();
			conn.close();
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