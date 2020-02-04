package util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Test {
	public static void main(String[] args) throws SQLException {
		Connection con;
		con = ConnectMySQL.connectMySQL();
		String sqlStr = "select * from landlord";
		Statement sql = con.createStatement();
		ResultSet rs = sql.executeQuery(sqlStr);
		while(rs.next()) {
			String id = rs.getString(1);
			System.out.print(id);
		   }
		
	}
}
