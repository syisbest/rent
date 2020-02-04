package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Landlord;
import model.Lodge;
import util.ConnectMySQL;

public class RegisterDaoImpl {
	private Connection con;

	private ResultSet rs;
	private PreparedStatement preSql;
	private String id;
	private String password;
	
	public RegisterDaoImpl() {
		con=ConnectMySQL.connectMySQL();
		
	}
	
	public void register(Lodge lodge) throws SQLException {
		String sql = "insert into lodge values(?,?,?,?,?,?,?)";

		preSql = con.prepareStatement(sql);
		preSql.setString(1, lodge.getLid());
		preSql.setString(2, lodge.getLname());
		preSql.setString(3, lodge.getLsex());
		preSql.setInt(4, lodge.getLage());
		preSql.setString(5, lodge.getLtel());
		preSql.setString(6, lodge.getLpassword());
		preSql.setString(7, lodge.getLidno());
		preSql.executeUpdate();
		
	}
	public void register(Landlord landlord) throws SQLException {
		String sql = "insert into landlord values(?,?,?,?,?,?,?)";
		
		preSql = con.prepareStatement(sql);
		preSql.setString(1, landlord.getLLid());
		preSql.setString(2, landlord.getLLname());
		preSql.setString(3, landlord.getLLsex());
		preSql.setString(4, landlord.getPassword());
		preSql.setInt(5, landlord.getLLage());
		preSql.setString(6, landlord.getLLtel());
		preSql.setString(7, landlord.getLLidno());
		preSql.executeUpdate();
		
	}

}
