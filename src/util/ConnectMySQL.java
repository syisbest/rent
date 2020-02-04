package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {
	public static Connection connectMySQL() {
		Connection con = null;
		String uri = "jdbc:mysql://localhost:3306/rent? useSSL=false&characterEncoding=utf-8&serverTimezone=UTC";
		String id = "root";
		String password = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("成功加载");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(uri, id, password);
//			System.out.println("成功连接");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}