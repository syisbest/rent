package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Landlord;
import model.Lodge;
import util.ConnectMySQL;
import util.SqlSelect;

public class AdminDaoImpl implements AdminDao{
	Connection con;
	Statement sql;
	private PreparedStatement psql;
	Lodgedao lodgedao = new Lodgedao();
	Landlorddao landlorddao = new Landlorddao();
	SqlSelect sqlSelect = new SqlSelect();
	
	
	public AdminDaoImpl() {
		con = ConnectMySQL.connectMySQL();
	}

	@Override
	public int addLodge(Lodge lodge){
		// TODO Auto-generated method stub
		return lodgedao.add(lodge);
	}

	@Override
	public int addLandlord(Landlord landlord){
		// TODO Auto-generated method stub
		int ok = 0;
		String sqlStr = "insert into landlord values(?,?,?,?,?,?,?)";
		try {
			psql = con.prepareStatement(sqlStr);
			psql.setString(1,landlord.getLLid());
	        psql.setString(2,landlord.getLLname());
	        psql.setString(3,landlord.getLLsex());
	        psql.setString(4,landlord.getPassword());
	        psql.setInt(5,landlord.getLLage());
	        psql.setString(6,landlord.getLLtel());
	        psql.setString(7,landlord.getLLidno());
	        ok = psql.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "该用户已存在");
			return 0;
		}
		if(ok==0) {return 0;}
		else {return 1;}
	}

	@Override
	public int delLodge(Lodge lodge){
		// TODO Auto-generated method stub
		
		return lodgedao.delete(lodge);
	}

	@Override
	public int delLandlord(Landlord landlord) {
		// TODO Auto-generated method stub
		int ok = 0;
		String sqlStr = "delete from Landlord where LLid=?";
		try {
			psql = con.prepareStatement(sqlStr);
			psql.setString(1,landlord.getLLid());
			ok = psql.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		if(ok==0) {return 0;}
		else {return 1;}
	}

	@Override
	public int updateLodge(Lodge lodge,String Lname, String Lsex,int Lage,String Ltel,String Lpassword,String Lidno){

		// TODO Auto-generated method stub
		
		return lodgedao.updateall(lodge,Lname, Lsex,Lage,Ltel,Lpassword,Lidno);
	}
	public int updateLandlord(Landlord landlord,String LLname, String LLsex,int LLage,String LLtel,String LLpassword,String LLidno) {
		int ok = 0;
		String sqlStr = "update Landlord set LLname=? , LLsex=? , LLage=? , LLtel=? , LLpassword=? , LLidno=? where LLid=?";
			try {
				psql = con.prepareStatement(sqlStr);
				psql.setString(1,LLname);
		        psql.setString(2,LLsex);
		        psql.setInt(3,LLage);
		        psql.setString(4,LLtel);
		        psql.setString(5,LLpassword);
		        psql.setString(6,LLidno);
				psql.setString(7,landlord.getLLid());
				
				ok = psql.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			landlord.setLLname(LLname);
			landlord.setLLsex(LLsex);
			landlord.setLLage(LLage);
			landlord.setLLtel(LLtel);
			landlord.setPassword(LLpassword);
			landlord.setLLidno(LLidno);
			if(ok==0) {return 0;}
		return 1;	
	}

	@Override
	public int updateLandlord(Landlord landlord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Lodge> findLodge(){
		// TODO Auto-generated method stub
		String sql;
		sql = "select Lid,Lname,Lsex,Lage,Ltel,Lpassword,Lidno from Lodge";
		return lodgedao.findBySQL(sql);
	}

	@Override
	public ArrayList<Landlord> findLandlord() throws SQLException {
		// TODO Auto-generated method stub
		String sql;
		sql = "select LLid,LLname,LLsex,LLage,LLtel,LLpassword,LLidno from Landlord";
		return landlorddao.findBySQL(sql);
	}

	@Override

	
	public ArrayList<Lodge> findlodge(ArrayList<String> s1){
		String sql;
		sql = sqlSelect.lodgeSelect(s1);
		return lodgedao.findBySQL(sql);
		
	}
	public ArrayList<Landlord> findlandlord(ArrayList<String> s1) throws SQLException{
		String sql;
		sql = sqlSelect.landlordSelect(s1);
		return landlorddao.findBySQL(sql);		
	}

		

}
