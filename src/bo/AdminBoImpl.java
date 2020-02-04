package bo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.AdminDaoImpl;
import model.Landlord;
import model.Lodge;
import util.ConnectMySQL;

public class AdminBoImpl implements AdminBo{
	private Connection con;
	private AdminDaoImpl admindaoimpl = new AdminDaoImpl();
	
	public AdminBoImpl() {
		con = ConnectMySQL.connectMySQL();
	}

	@Override
	public int addLodge(Lodge lodge) {
		// TODO Auto-generated method stub
		
		return admindaoimpl.addLodge(lodge);
	}

	@Override
	public int addLandlord(Landlord landlord) {
		// TODO Auto-generated method stub
		return admindaoimpl.addLandlord(landlord);
	}

	@Override
	public int delLodge(Lodge lodge) {
		// TODO Auto-generated method stub
		return admindaoimpl.delLodge(lodge);
	}

	@Override
	public int delLandlord(Landlord landlord) {
		// TODO Auto-generated method stub
		return admindaoimpl.addLandlord(landlord);
	}

	@Override
	public int updateLandlord(Landlord landlord) {
		// TODO Auto-generated method stub
		return admindaoimpl.updateLandlord(landlord);
	}

	@Override
	public ArrayList<Lodge> findLodge() throws SQLException {
		// TODO Auto-generated method stub
		return admindaoimpl.findLodge();
	}

	@Override
	public ArrayList<Landlord> findLandlord() throws SQLException {
		// TODO Auto-generated method stub
		return admindaoimpl.findLandlord();
	}

	@Override
	public int updateLodge(Lodge lodge, String Lname, String Lsex, int Lage, String Ltel, String Lpassword,
			String Lidno) {
		// TODO Auto-generated method stub
		return admindaoimpl.updateLodge(lodge, Lname, Lsex, Lage, Ltel, Lpassword, Lidno);
	}

	@Override
	public ArrayList<Lodge> findlodge(ArrayList<String> s1) {
		// TODO Auto-generated method stub
		return admindaoimpl.findLodge();
	}

	@Override
	public ArrayList<Landlord> findlandlord(ArrayList<String> s1) throws SQLException {
		// TODO Auto-generated method stub
		return admindaoimpl.findLandlord();
	}
	
}
