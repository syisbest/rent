package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Contract;
import model.Lodge;
import model.House;
import util.ConnectMySQL;

public class Lodgedao {

	private Connection con = ConnectMySQL.connectMySQL();
	private PreparedStatement sql;
	private Statement smt=null;
	
	public int add(Lodge lodge){
		int ok = 0;
		String sqlStr = "insert into Lodge values(?,?,?,?,?,?,?)";
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,lodge.getLid());
	        sql.setString(2,lodge.getLname());
	        sql.setString(3,lodge.getLsex());
	        sql.setInt(4,lodge.getLage());
	        sql.setString(5,lodge.getLtel());
	        sql.setString(6,lodge.getLpassword());
	        sql.setString(7,lodge.getLidno());
	        ok = sql.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "该账户已存在");
			return 0;
		}
		if(ok==0) {return 0;}
		else {return 1;}
	}
	
	public int delete(Lodge lodge) {
		int ok = 0;
		String sqlStr = "delete from Lodge where Lid=?";
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,lodge.getLid());
			ok = sql.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		if(ok==0) {return 0;}
		else {return 1;}
	}
	

	public int updateall(Lodge lodges,String Lname, String Lsex,int Lage,String Ltel,String Lpassword,String Lidno) {
		int ok = 0;
		String sqlStr = "update Lodge set Lname=? , Lsex=? , Lage=? , Ltel=? , Lpassword=? , Lidno=? where Lid=?";
			try {
				sql = con.prepareStatement(sqlStr);
				sql.setString(1,Lname);
		        sql.setString(2,Lsex);
		        sql.setInt(3,Lage);
		        sql.setString(4,Ltel);
		        sql.setString(5,Lpassword);
		        sql.setString(6,Lidno);
				sql.setString(7,lodges.getLid());
				
				ok = sql.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			lodges.setLname(Lname);
			lodges.setLsex(Lsex);
			lodges.setLage(Lage);
			lodges.setLtel(Ltel);
			lodges.setLpassword(Lpassword);
			lodges.setLidno(Lidno);
			if(ok==0) {return 0;}
		return 1;	
	}
	public int updateLname(Lodge lodges,String Lname) {
		int ok = 0;
		String sqlStr = "update Lodge set Lname=? where Lid=?";
			try {
				sql = con.prepareStatement(sqlStr);
				sql.setString(1,Lname);
				sql.setString(2,lodges.getLid());
				ok = sql.executeUpdate();
			} catch (SQLException e) {
				return 0;
			}lodges.setLname(Lname);
			if(ok==0) {return 0;}
		return 1;	
	}
	public int updateLsex(Lodge lodges,String Lsex) {
		int ok = 0;
		String sqlStr = "update Lodge set Lsex=? where Lid=?";
			try {
				sql = con.prepareStatement(sqlStr);	
		        sql.setString(1,Lsex);
				sql.setString(2,lodges.getLid());
				ok = sql.executeUpdate();
			} catch (SQLException e) {
				return 0;
			}lodges.setLsex(Lsex);
			if(ok==0) {return 0;}
		return 1;	
	}
	public int updateLage(Lodge lodges,int Lage) {
		int ok = 0;
		String sqlStr = "update Lodge set Lage=? where Lid=?";
			try {
				sql = con.prepareStatement(sqlStr);
		        sql.setInt(1,Lage);
		        sql.setString(2,lodges.getLid());
				ok = sql.executeUpdate();
			} catch (SQLException e) {
				return 0;
			}			lodges.setLage(Lage);
			if(ok==0) {return 0;}
		return 1;	
	}
	public int updateLtel(Lodge lodges,String Ltel) {
		int ok = 0;
		String sqlStr = "update Lodge set Ltel=?  where Lid=?";
			try {
				sql = con.prepareStatement(sqlStr);				
		        sql.setString(1,Ltel);		        
				sql.setString(2,lodges.getLid());
				ok = sql.executeUpdate();
			} catch (SQLException e) {
				return 0;
			}lodges.setLtel(Ltel);
			if(ok==0) {return 0;}
		return 1;	
	}
	public int updateLpassword(Lodge lodges,String Lpassword) {
		int ok = 0;
		String sqlStr = "update Lodge set Lpassword=? where Lid=?";
			try {
				sql = con.prepareStatement(sqlStr);
		        sql.setString(1,Lpassword);
				sql.setString(2,lodges.getLid());
				ok = sql.executeUpdate();
			} catch (SQLException e) {
				return 0;
			}lodges.setLpassword(Lpassword);
			if(ok==0) {return 0;}
		return 1;	
	}
	public int updateLidno(Lodge lodges,String Lidno) {
		int ok = 0;
		String sqlStr = "update Lodge set Lidno=? where Lid=?";
			try {
				sql = con.prepareStatement(sqlStr);
		        sql.setString(1,Lidno);
				sql.setString(2,lodges.getLid());
				ok = sql.executeUpdate();
			} catch (SQLException e) {
				return 0;
			}lodges.setLidno(Lidno);
			if(ok==0) {return 0;}
		return 1;	
	}
	
	public int findall(ArrayList<Lodge> lodges) {
		int i = 0;
		String sqlStr = null;
		ResultSet rs = null;
		lodges.clear();
		sqlStr = "select * from Lodge";
		try {
			sql = con.prepareStatement(sqlStr);
			rs = sql.executeQuery();
			while(rs.next()){
				lodges.add(new Lodge());
				lodges.get(i).setLid(rs.getString(1));
				lodges.get(i).setLname(rs.getString(2));
				lodges.get(i).setLsex(rs.getString(3));
				lodges.get(i).setLage(rs.getInt(4));
				lodges.get(i).setLtel(rs.getString(5));
				lodges.get(i).setLpassword(rs.getString(6));
				lodges.get(i).setLidno(rs.getString(7));
				i++;
			}
		} catch (SQLException e) {
			return 0;
		}
		return 1;
	}
	
	public int findself(Lodge lodges,String Lid) {
		String sqlStr = null;
		ResultSet rs = null;
		sqlStr = "select * from Lodge where Lid=?";
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,Lid);
			rs = sql.executeQuery();
			rs.next();
			lodges.setLid(rs.getString(1));
			lodges.setLname(rs.getString(2));
			lodges.setLsex(rs.getString(3));
			lodges.setLage(rs.getInt(4));
			lodges.setLtel(rs.getString(5));
			lodges.setLpassword(rs.getString(6));
			lodges.setLidno(rs.getString(7));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	public ArrayList<Lodge> findBySQL(String sql){
		if (smt == null)
			try {
				smt = con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		ArrayList<Lodge> lodges = new ArrayList<Lodge>();
		System.out.println(sql);
		ResultSet rs;
		try {
			rs = smt.executeQuery(sql);
			while(rs.next()){
			Lodge lodge = new Lodge(); 
			lodge.setLid(rs.getString("Lid"));
			lodge.setLname(rs.getString("Lname"));
			lodge.setLsex(rs.getString("Lsex"));
			lodge.setLage(rs.getInt("Lage"));
			lodge.setLtel(rs.getString("Ltel"));
			lodge.setLpassword(rs.getString("Lpassword"));
			lodge.setLidno(rs.getString("Lidno"));
			lodges.add(lodge);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lodges;		
	}

}

