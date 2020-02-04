package model;

public class Landlord {
	private String LLid;//’À∫≈
	  private String LLname;
	  private String  LLsex;
	  private String password;//√‹¬Î
	  private String LLtel;
	  private String LLidno;//…Ì∑›÷§∫≈
	  private  int LLage;
	  public  Landlord() {
	
	   }
	  
	   public Landlord(String LLid,String LLname,String LLsex,int age,String LLtel,String password,String LLidno) {
		   this.LLid=LLid;
		   this.LLname=LLname;
		   this.LLsex=LLsex;
		   this.password=password;
		   this.LLtel=LLtel;
		   this.LLidno=LLidno;
		   this.LLage=age;
	   }
	   
	public void setLLid(String lLid) {
		LLid = lLid;
	}
	public String getLLname() {
		return LLname;
	}
	public void setLLname(String lLname) {
		LLname = lLname;
	}
	public String getLLsex() {
		return LLsex;
	}
	public void setLLsex(String lLsex) {
		LLsex = lLsex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLLtel() {
		return LLtel;
	}
	public void setLLtel(String lLtel) {
		this.LLtel = lLtel;
	}
	public String getLLid() {
		return LLid;
	}
	public String getLLidno() {
		return LLidno;
	}
	public void setLLidno(String LLidno) {
		this.LLidno = LLidno;
	}
	public int getLLage() {
		return LLage;
	}
	public void setLLage(int lLage) {
		LLage = lLage;
	}
}
