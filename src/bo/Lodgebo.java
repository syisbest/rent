package bo;

import java.util.ArrayList;
import dao.Lodgedao;
import model.Lodge;

public class Lodgebo {
	//仅管理员
	public int add1(String Lid, String Lname, String Lsex,int Lage,String Ltel,String Lpassword,String Lidno) {
		Lodge lodge = new Lodge(Lid, Lname,Lsex,Lage,Ltel,Lpassword, Lidno);
		Lodgedao con = new Lodgedao();
		if(con.add(lodge)==1)
			return 1;
		else
			return 0;
	}
	public int delete1(Lodge lodge) {
		Lodgedao con = new Lodgedao();
		if(con.delete(lodge)==1)
			return 1;
		else
			return 0;
	}
	public int findall1(ArrayList<Lodge> lodges) {
		Lodgedao con = new Lodgedao();
		if(con.findall(lodges)==1)
			return 1;
		else
			return 0;
	}
	//用户，管理员
	public int findself1(Lodge lodges,String Lid) {
		Lodgedao con = new Lodgedao();
		if(con.findself(lodges,Lid)==1)
			return 1;
		else
			return 0;	
	}
	public int updateall1(Lodge lodges,String Lname, String Lsex,int Lage,String Ltel,String Lpassword,String Lidno) {
		Lodgedao con = new Lodgedao();
		if(con.updateall(lodges,Lname,  Lsex, Lage, Ltel, Lpassword, Lidno)==1)
			return 1;
		else
			return 0;		
	}
	public int updateLname1(Lodge lodges,String Lname) {
		Lodgedao con = new Lodgedao();
		if(con.updateLname(lodges,Lname)==1)
			return 1;
		else
			return 0;	
	}
	public int updateLsex1(Lodge lodges,String Lsex) {
		Lodgedao con = new Lodgedao();
		if(con.updateLsex(lodges,Lsex)==1)
			return 1;
		else
			return 0;	
	}
	public int updateLage1(Lodge lodges,int Lage) {
		Lodgedao con = new Lodgedao();
		if(con.updateLage(lodges,Lage)==1)
			return 1;
		else
			return 0;		
	}
	public int updateLtel1(Lodge lodges,String Ltel) {
		Lodgedao con = new Lodgedao();
		if(con.updateLtel(lodges,Ltel)==1)
			return 1;
		else
			return 0;	
	}
	public int updateLpassword1(Lodge lodges,String Lpassword) {
		Lodgedao con = new Lodgedao();
		if(con.updateLpassword(lodges,Lpassword)==1)
			return 1;
		else
			return 0;	
	}
	public int updateLidno1(Lodge lodges,String Lidno) {
		Lodgedao con = new Lodgedao();
		if(con.updateLidno(lodges,Lidno)==1)
			return 1;
		else
			return 0;		
	}
	

}
