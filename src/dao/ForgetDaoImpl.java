package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Landlord;
import model.Lodge;
import util.ConnectMySQL;

public class ForgetDaoImpl {
	private Connection con;
	private Statement sql;
	private String password = null;
	private ResultSet rs;
	public ForgetDaoImpl() {
		con = ConnectMySQL.connectMySQL();
	}
	
	public String getPsd(Lodge lodge) throws SQLException{
		String sqlStr = "select Lpassword from lodge where Lid = '"+lodge.getLid()+"' and Ltel='"+lodge.getLtel()+"'";
		sql = con.createStatement();
		rs = sql.executeQuery(sqlStr);
		while(rs.next()) {
			password = rs.getString("Lpassword");
		}
		return password;
		
	}
	public String getPsd(Landlord landlord) throws SQLException {
		String sqlStr = "select LLpassword from landlord where LLid = '"+landlord.getLLid()+"' and LLtel='"+landlord.getLLtel()+"'";
		sql = con.createStatement();
		rs = sql.executeQuery(sqlStr);
		while(rs.next()) {
			password = rs.getString("LLpassword");
		}
		return password;
		
	}
}
