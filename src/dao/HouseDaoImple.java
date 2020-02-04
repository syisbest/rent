package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Contract;
import model.House;
import model.Landlord;
import model.Lodge;
import util.ConnectMySQL;

public class HouseDaoImple {
	private Connection con = ConnectMySQL.connectMySQL();
	private PreparedStatement sql;//添加房子
	public int add(House house) {
		int ok=0;
		
		String sqlStr = "insert into house values(?,?,?,?,?)";
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,house.getLLid().getLLid());
			sql.setString(2,house.getHid());
	        sql.setString(3,house.getAddress());
	        sql.setInt(4,house.getSize());
	        sql.setString(5,house.getType());
	        ok = sql.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
		if(ok==0) {return 0;}
		else {return 1;}
		
	}//删除编号房子
	public String getMaxHid() {
		String sqlStr = null;
		ResultSet rs = null;
		int ok = 0, i = 0, max = 0;
		sqlStr = "select Hid from house";
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
	
	public int delete(String Hid) {
		int ok = 0;
		String sqlStr = "delete from house where Hid=? ";
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,Hid);
			ok = sql.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		if(ok==0) {return 0;}
		else {return 1;}
	}//主键查找房子
	public int find(House house,String hid) {
		int i=0;
		ResultSet rs = null;
		String sqlStr = null;
		sqlStr="select * from house where Hid=?";
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,hid);
			rs = sql.executeQuery();
			Landlord ll = new Landlord();
			ll.setLLid(rs.getString(1));
			    house.setLLid(ll);
				house.setHid(rs.getString(2));
				house.setAddress(rs.getString(3));
				house.setSize(rs.getInt(4));
				house.setType(rs.getString(5));
				
				
		} catch (SQLException e) {
			return 0;
		}
		return 1;
	}
	//房主查找房子
	public int find2(String llid,ArrayList<House>house) {
		int i=0;
		ResultSet rs = null;
		String sqlStr = null;
		sqlStr="select * from house where LLid=?";
		try {
			
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,llid);
			rs = sql.executeQuery();
			Landlord ll = new Landlord();
			while(rs.next()){
				house.add(new House());
				ll.setLLid(rs.getString(1));
				house.get(i).setLLid(ll);
				house.get(i).setHid(rs.getString(2));
				house.get(i).setAddress(rs.getString(3));
				house.get(i).setSize(rs.getInt(4));
				house.get(i).setType(rs.getString(5));
				i++;}}
		catch(SQLException e) {return 0;}return 1;
		
	}
	public int find3(int Size,ArrayList<House> house) {
		int i=0;
		ResultSet rs = null;
		String sqlStr = null;
		sqlStr="select * from house where Size=? ";
		try {
			
			sql = con.prepareStatement(sqlStr);
			sql.setInt(1,Size);
			rs = sql.executeQuery();
			Landlord ll = new Landlord();
			while(rs.next()){
				house.add(new House());
				ll.setLLid(rs.getString(1));
				house.get(i).setLLid(ll);
				house.get(i).setHid(rs.getString(2));
				house.get(i).setAddress(rs.getString(3));
				house.get(i).setSize(rs.getInt(4));
				house.get(i).setType(rs.getString(5));
				i++;}}
		catch(SQLException e) {return 0;}return 1;
		
	}
	public int find4(ArrayList<House>house,String Type) {
		int i=0;
		ResultSet rs = null;
		String sqlStr = null;
		sqlStr="select * from house where Type=?";
		try {
			
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,Type);
			rs = sql.executeQuery();
			Landlord ll = new Landlord();
			while(rs.next()){
				house.add(new House());

				ll.setLLid(rs.getString(1));
				house.get(i).setHid(rs.getString(2));
				house.get(i).setAddress(rs.getString(3));
				house.get(i).setSize(rs.getInt(4));
				house.get(i).setType(rs.getString(5));
				i++;}}
		catch(SQLException e) {return 0;}return 1;
	}
	
	public int update(House house,String hid,String address ) {
		ResultSet rs=null;
		String sqlStr=null;
		sqlStr="update house set Hid=? where Addrees =? ";
		try {
			sql=con.prepareStatement(sqlStr);
			sql.setString(1,hid);
			sql.setString(2,address);
			rs=sql.executeQuery();
			Landlord ll = new Landlord();
			ll.setLLid(rs.getString(1));
			    house.setLLid(ll);
				house.setHid(rs.getString(2));
				house.setAddress(rs.getString(3));
				house.setSize(rs.getInt(4));
				house.setType(rs.getString(5));
		}catch(SQLException e) {return 0;}
	return 1;
		
	}
	//租客部分
	public int findhouse(ArrayList<House>house) {
		int i=0;
		ResultSet rs = null;
		String sqlStr = null;
		house.clear();
		sqlStr="select * from house where Hid not in(select Hid from contract where Status=?)" ;
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,"1");
			rs = sql.executeQuery();
			Landlord ll = new Landlord();
			while(rs.next()){
				house.add(new House());
				ll.setLLid(rs.getString(1));
				house.get(i).setLLid(ll);
				house.get(i).setHid(rs.getString(2));
				house.get(i).setAddress(rs.getString(3));
				house.get(i).setSize(rs.getInt(4));
				house.get(i).setType(rs.getString(5));
				i++;}}
		catch(SQLException e) {return 0;}return 1;
	}
	
	public int findhousesize(ArrayList<House> house,int Size) {
		int i=0;
		ResultSet rs = null;
		String sqlStr = null;
		house.clear();
		sqlStr="select * from house where Size=? and Hid not in(select Hid from contract where Status=?)";
		try {
			sql = con.prepareStatement(sqlStr);
			sql.setInt(1,Size);
			sql.setString(2,"1");
			rs = sql.executeQuery();
			Landlord ll = new Landlord();
			while(rs.next()){
				house.add(new House());
				ll.setLLid(rs.getString(1));
				house.get(i).setLLid(ll);
				house.get(i).setHid(rs.getString(2));
				house.get(i).setAddress(rs.getString(3));
				house.get(i).setSize(rs.getInt(4));
				house.get(i).setType(rs.getString(5));
				i++;}}
		catch(SQLException e) {return 0;}return 1;
		
	}
	public int findhousetype(ArrayList<House>house,String Type) {
		int i=0;
		ResultSet rs = null;
		String sqlStr = null;
		house.clear();
		sqlStr="select * from house where Type=? and Hid not in(select Hid from contract where Status=?)";
		try {
			
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,Type);
			sql.setString(2,"1");
			rs = sql.executeQuery();
			Landlord ll = new Landlord();
			while(rs.next()){
				house.add(new House());
				ll.setLLid(rs.getString(1));
				house.get(i).setLLid(ll);
				house.get(i).setHid(rs.getString(2));
				house.get(i).setAddress(rs.getString(3));
				house.get(i).setSize(rs.getInt(4));
				house.get(i).setType(rs.getString(5));
				i++;}}
		catch(SQLException e) {return 0;}return 1;
	}
	
	public int findhousesizetype(ArrayList<House>house,int Size,String Type) {
		int i=0;
		ResultSet rs = null;
		String sqlStr = null;
		house.clear();
		sqlStr="select * from house where Type=? and Size=? and Hid not in(select Hid from contract where Status=?)";
		try {
			
			sql = con.prepareStatement(sqlStr);
			sql.setString(1,Type);
			sql.setInt(2,Size);
			sql.setString(3,"1");
			rs = sql.executeQuery();
			Landlord ll = new Landlord();
			while(rs.next()){
				house.add(new House());
				ll.setLLid(rs.getString(1));
				house.get(i).setLLid(ll);
				house.get(i).setHid(rs.getString(2));
				house.get(i).setAddress(rs.getString(3));
				house.get(i).setSize(rs.getInt(4));
				house.get(i).setType(rs.getString(5));
				i++;}}
		catch(SQLException e) {return 0;}return 1;
	}
}
