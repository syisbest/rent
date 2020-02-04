package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Landlord;
import model.Lodge;
import util.ConnectMySQL;

public class Landlorddao{
	private Connection con = ConnectMySQL.connectMySQL();
	private PreparedStatement sql;
	public int find(Landlord landlord,String llid) {
		String sqlStr = null;
		ResultSet rs = null;
		String id = landlord.getLLid();
		sqlStr="select * from landlord where LLid=? ";

		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,id);
			rs=sql.executeQuery();
			while(rs.next()) {
			    landlord.setLLid(rs.getString(1));
			    landlord.setLLname(rs.getString(2));
			    landlord.setLLsex(rs.getString(3));
			    landlord.setPassword(rs.getString(4));
			     landlord.setLLage(rs.getInt(5));
			     landlord.setLLtel(rs.getString(6));
			    landlord.setLLidno(rs.getString(7));
		}
	   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("1");
		}
		
	   
		return 1;
		
	}
	public int update(Landlord landlord,String LLidno, String LLname,String LLsex,String Password,int LLage,String LLtel) {
		int ok = 0;
		String sqlStr = "update landlord set LLidno=? , LLname=? , LLsex=? , LLpassword=? , LLage=? , LLtel=? where LLid=?";
			try {
				sql = con.prepareStatement(sqlStr);
				sql.setString(1,LLidno);
		        sql.setString(2,LLname);
		        sql.setString(3,LLsex);
		        sql.setString(4,Password);
		        sql.setInt(5,LLage);
		        sql.setString(6,LLtel);
				sql.setString(7,landlord.getLLid());
				
				ok = sql.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			landlord.setLLidno(LLidno);
			landlord.setLLname(LLname);
			landlord.setLLsex(LLsex);
			landlord.setPassword(Password);
			landlord.setLLage(LLage);
			landlord.setLLtel(LLtel);
			if(ok==0) {return 0;}
		return 1;	}
	public int update(String LLid,String tel,Landlord landlord) {
		String sqlStr = null;
		ResultSet rs = null;
		sqlStr="update landlord set tel=? where LLid=?";
		try {
			sql=con.prepareStatement(sqlStr);
			sql.setString(1,tel);
			sql.setString(2,LLid);
			rs=sql.executeQuery();
		}catch(SQLException e) {return 0;}
	return 1;
		
		
	}
	public int update1(String LLid,String LLidno ) {
		String sqlStr = null;
		ResultSet rs = null;
		sqlStr="update landlord set LLidno=? where LLid=?";
		try {
			sql=con.prepareStatement(sqlStr);
			sql.setString(1,LLidno);
			sql.setString(2,LLid);
			rs=sql.executeQuery();
		}catch(SQLException e) {return 0;}
	return 1;
		
	}
	public ArrayList<Landlord> findBySQL(String sql) throws SQLException {
		Statement smt = con.createStatement();
		ArrayList<Landlord> landlords = new ArrayList<Landlord>();
		System.out.println(sql);
		ResultSet rs = smt.executeQuery(sql);
		while(rs.next()){
			Landlord landlord = new Landlord(); 
			landlord.setLLid(rs.getString("LLid"));
			landlord.setLLname(rs.getString("LLname"));
			landlord.setLLsex(rs.getString("LLsex"));
			landlord.setLLage(rs.getInt("LLage"));
			landlord.setLLtel(rs.getString("LLtel"));
			landlord.setPassword(rs.getString("LLpassword"));
			landlord.setLLidno(rs.getString("LLidno"));
			landlords.add(landlord);
		}
		return landlords;		
	}
	
		
	}
	    
	
