package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Contract;
import model.Lodge;
import util.ConnectMySQL;

public class ContractDaoImpl {
	private Connection con = ConnectMySQL.connectMySQL();
	private PreparedStatement sql;
	
	public int add(Contract c){
		int ok = 0;
		String sqlStr = "insert into contract values(?,?,?,?,?,?,?)";
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,c.getCno());
	        sql.setString(2,c.getLodge().getLid());
	        sql.setString(3,c.getHouse().getHid());
	        sql.setInt(4,c.getRent());
	        sql.setString(5,c.getDate());
	        sql.setInt(6,c.getTime());
	        sql.setString(7,"0");
	        ok = sql.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		if(ok==0) {return 0;}
		else {return 1;}
	}
	
	public int delete(Lodge l) {
		int ok = 0;
		String sqlStr = "delete from contract where Lid=? and Status=?";
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,l.getLid());
			sql.setString(2,"-1");
			ok = sql.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		if(ok==0) {return 0;}
		else {return 1;}
	}
	
	public int change(ArrayList<Contract> c,String s) {
		int ok = 0, i = 0;
		String sqlStr = "update contract set Status=? where Cno=?";
		for(i = 0; i<c.size(); i++) {
			try {
				sql = con.prepareStatement(sqlStr);
				sql.setString(1,s);
				sql.setString(2,c.get(i).getCno());
				c.get(i).setStatus(s);
				ok = sql.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
			if(ok==0) {return 0;}
		}
		return 1;
	}
	
	public int setDate(ArrayList<Contract> c,String s){
		int ok = 0, i = 0;
		String sqlStr = "update contract set Date=? where Cno=?";
		for(i = 0; i<c.size(); i++) {
			try {
				sql = con.prepareStatement(sqlStr);
				sql.setString(1,s);
				sql.setString(2,c.get(i).getCno());
				c.get(i).setStatus(s);
				ok = sql.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
			if(ok==0) {return 0;}
		}
		return 1;
	}
	
	public int  findAllCon(ArrayList<Contract> c) {
		int i = 0;
		String sqlStr = null;
		ResultSet rs = null;
		c.clear();
		sqlStr = "select * from contract";
		try {
			sql = con.prepareStatement(sqlStr);
			rs = sql.executeQuery();
			while(rs.next()){
				c.add(new Contract());
				c.get(i).setCno(rs.getString(1));
				c.get(i).setLodge(rs.getString(2));
				c.get(i).setHouse(rs.getString(3));
				c.get(i).setRent(rs.getInt(4));
				c.get(i).setDate(rs.getString(5));
				c.get(i).setTime(rs.getInt(6));
				c.get(i).setStatus(rs.getString(7));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	public String getMaxCno() {
		String sqlStr = null;
		ResultSet rs = null;
		int ok = 0, i = 0, max = 0;
		sqlStr = "select Cno from contract";
		try {
			sql = con.prepareStatement(sqlStr);
			rs = sql.executeQuery();
			rs.last();
			if(rs.getRow()==0)
				return "1";
			String[] r = new String[rs.getRow()];
			rs.beforeFirst();
			while(rs.next()){
				r[i] = rs.getString(1);
				if(Integer.parseInt(r[i]) > max)
					max = Integer.parseInt(r[i]);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return ((Integer)(max+1)).toString();
	}
	
	//1为房东查询，2为租客查询
	public int  find(String s,String status,ArrayList<Contract> c,int j) {
		int i = 0;
		String sqlStr = null;
		ResultSet rs = null;
		c.clear();
		switch(j) {
		case 1:
			sqlStr = "select * from contract where Status=? and Hid in "
					+ "(select Hid from house where LLid=?)";
			break;
		case 2:
			sqlStr = "select * from contract where Status=? and Lid=?";
			break;
		}
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,status);
			sql.setString(2,s);
			rs = sql.executeQuery();
			while(rs.next()){
				c.add(new Contract());
				c.get(i).setCno(rs.getString(1));
				c.get(i).setLodge(rs.getString(2));
				c.get(i).setHouse(rs.getString(3));
				c.get(i).setRent(rs.getInt(4));
				c.get(i).setDate(rs.getString(5));
				c.get(i).setTime(rs.getInt(6));
				c.get(i).setStatus(rs.getString(7));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	//1为按日期查询，2为按编号查询,3为按房屋查询，4为按租客查询，5为按房东查询
	public int  find(String s,ArrayList<Contract> c,int j) {
		int i = 0;
		ResultSet rs = null;
		String sqlStr = null;
		c.clear();
		switch(j) {
		case 1:
			sqlStr = "select * from contract where Date=?";
			break;
		case 2:
			sqlStr = "select * from contract where Cno=?";
			break;
		case 3:
			sqlStr = "select * from contract where Hid=?";
			break;
		case 4:
			sqlStr = "select * from contract where Lid=?";
			break;
		case 5:
			sqlStr = "select * from contract where Hid in "
					+ "(select Hid from house where LLid=?)";
			break;
		}
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,s);
			rs = sql.executeQuery();
			while(rs.next()){
				c.add(new Contract());
				c.get(i).setCno(rs.getString(1));
				c.get(i).setLodge(rs.getString(2));
				c.get(i).setHouse(rs.getString(3));
				c.get(i).setRent(rs.getInt(4));
				c.get(i).setDate(rs.getString(5));
				c.get(i).setTime(rs.getInt(6));
				c.get(i).setStatus(rs.getString(7));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	public int  find(String sqlString,ArrayList<Contract> c) {
		int i = 0;
		ResultSet rs = null;
		String sqlStr = sqlString;
		c.clear();
		try {
			sql = con.prepareStatement(sqlStr);
			rs = sql.executeQuery();
			while(rs.next()){
				c.add(new Contract());
				c.get(i).setCno(rs.getString(1));
				c.get(i).setLodge(rs.getString(2));
				c.get(i).setHouse(rs.getString(3));
				c.get(i).setRent(rs.getInt(4));
				c.get(i).setDate(rs.getString(5));
				c.get(i).setTime(rs.getInt(6));
				c.get(i).setStatus(rs.getString(7));
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	public int delete0(Lodge l,String Cno) {
		int ok = 0;
		String sqlStr = "delete from contract where Lid=? and Cno=? and Status=?";
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,l.getLid());
			sql.setString(2,Cno);
			sql.setString(3,"0");
			ok = sql.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(ok==0) {return 0;}
		else {return 1;}
	}

}
