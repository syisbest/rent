package model;

public class Contract {
	private String Cno;
	private Lodge Lodge;
	private House House;
	private String Date;
	private String Status;
	private int Rent;
	private int Time;
	
	public Contract(String cno, Lodge lodge, House house, String date, int rent, int time) {
		Cno = cno;
		Lodge = lodge;
		House = house;
		Date = date;
		Rent = rent;
		Time = time;
		Status = "0";
	}
	public Contract() {
	}
	
	public Lodge getLodge() {
		return Lodge;
	}
	public void setLodge(Lodge lodge) {
		Lodge = lodge;
	}
	public void setLodge(String lid) {
		Lodge l = new Lodge();
		l.setLid(lid);
		Lodge = l;
	}
	public House getHouse() {
		return House;
	}
	public void setHouse(House house) {
		House = house;
	}
	public void setHouse(String hid) {
		House h = new House();
		h.setHid(hid);
		House = h;
	}
	public House setHouse1(String hid) {
		House h = new House();
		h.setHid(hid);
		House = h;
		return House;
	}
	public String getCno() {
		return Cno;
	}
	public void setCno(String cno) {
		Cno = cno;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getRent() {
		return Rent;
	}
	public void setRent(int rent) {
		Rent = rent;
	}
	public int getTime() {
		return Time;
	}
	public void setTime(int time) {
		Time = time;
	}

}
