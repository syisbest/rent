package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Admin;
import model.Landlord;
import model.Lodge;
import util.ConnectMySQL;

public class LoginDaoImpl {
	private Connection con;

	private ResultSet rs;
	private PreparedStatement preSql;
	private String id;
	private String password;
	
	public LoginDaoImpl() {
		con=ConnectMySQL.connectMySQL();
		
	}
	
	public Boolean login(Lodge lodge){
		id= lodge.getLid();
		password = lodge.getLpassword();
		String sqlStr = "select Lpassword from lodge where Lid = ? and Lpassword = ?";
		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, id);
			preSql.setString(2, password);
			rs = preSql.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
			
	}
	
	public Boolean login(Landlord landlord){
		id= landlord.getLLid();
		password = landlord.getPassword();
		String sqlStr = "select LLpassword from landlord where LLid = ? and LLpassword = ?";
		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, id);
			preSql.setString(2, password);
			rs = preSql.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
			
	}
	
	public Boolean login(Admin admin) {
		id = admin.getId();
		password = admin.getPassword();
		String sqlStr = "select password from admin where id = ? and password = ?";
		try {
			preSql = con.prepareStatement(sqlStr);
			preSql.setString(1, id);
			preSql.setString(2, password);
			rs = preSql.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
	}
	
}
