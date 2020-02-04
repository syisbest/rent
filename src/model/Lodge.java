package model;

public class Lodge {
	private String Lid;
	private String Lname;
	private String Lsex;
	private int Lage;
	private String Ltel;
	private String Lpassword;
	private String Lidno;
	public Lodge() {
		
	}
	
	public Lodge(String Lid, String Lname, String Lsex,int Lage,String Ltel,String Lpassword,String Lidno) {
		this.Lid = Lid;
		this.Lname = Lname;
		this.Lsex = Lsex;
		this.Lage = Lage;
		this.Ltel = Ltel;
		this.Lpassword = Lpassword;
		this.Lidno = Lidno;
	}
	
	public String getLid() {
		return Lid;
	}
	public void setLid(String lid) {
		this.Lid = lid;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		this.Lname = lname;
	}
	public String getLsex() {
		return Lsex;
	}
	public void setLsex(String lsex) {
		this.Lsex = lsex;
	}
	public int getLage() {
		return Lage;
	}
	public void setLage(int lage) {
		this.Lage = lage;
	}
	public String getLtel() {
		return Ltel;
	}
	public void setLtel(String ltel) {
		this.Ltel = ltel;
	}
	public String getLpassword() {
		return Lpassword;
	}
	public void setLpassword(String lpassword) {
		this.Lpassword = lpassword;
	}
	public String getLidno() {
		return Lidno;
	}
	public void setLidno(String lidno) {
		this.Lidno = lidno;
	}
	
}
