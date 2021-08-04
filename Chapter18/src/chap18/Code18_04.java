package chap18;

import java.sql.*;

public class Code18_04 {
	public static void main(String[] args) throws Exception {
		Clas.forName("org.h2.Driver");
		String dburl = "jdbc:h2:~/test";
		String sql = "INSERT INTO EMPLOYEES(name) VALUES('aoki')";
		Connection conn = DriverManager.getConnection(dburl);
		conn.createStatement().executeUpdate(sql);
		conn.close();
	}
}
