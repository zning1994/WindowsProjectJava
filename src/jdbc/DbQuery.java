package jdbc;
import java.sql.*;

public class DbQuery {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:MySQL://localhost:3306/dbtest?characterEncoding=gbk","root", "admin");
			String strsql = "select * from person where id=? ";
			PreparedStatement pstmt = conn.prepareStatement(strsql);
			pstmt.setInt(1, 100);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("id");
				String name = rs.getString("name");
				int age=rs.getInt("age");
				System.out.println("±‡∫≈£∫"+id+"–’√˚: " +name+" ƒÍ¡‰£∫"+age);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}