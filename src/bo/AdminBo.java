package bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Landlord;
import model.Lodge;

interface AdminBo {
	int addLodge(Lodge lodge);
	int addLandlord(Landlord landlord);
	int delLodge(Lodge lodge);
	int delLandlord(Landlord landlord);
	int updateLandlord(Landlord landlord);
	ArrayList<Lodge> findLodge() throws SQLException;
	ArrayList<Landlord> findLandlord() throws SQLException;
	int updateLodge(Lodge lodge, String Lname, String Lsex, int Lage, String Ltel, String Lpassword, String Lidno);
	ArrayList<Lodge> findlodge(ArrayList<String> s1);
	public ArrayList<Landlord> findlandlord(ArrayList<String> s1) throws SQLException;
}
