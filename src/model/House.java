package model;

public class House {
	private Landlord  LLid;
	   private String  Hid;
	   private String Address;
	   private int Size;
	   private String Type;
	public House() {
		
		Hid="";
		Address="";
		Size=0;
		Type="";
	}

	public Landlord getLLid() {
		return LLid;
	}

	public void setLLid(Landlord lLid) {
		LLid = lLid;
	}

	public String getHid() {
		return Hid;
	}
	public void setHid(String hid) {
		Hid = hid;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getSize() {
		return Size;
	}
	public void setSize(int size) {
		Size = size;
	}
	public void setType(String Type) {
		this.Type=Type;
	}
	public String getType() {
		return Type;
	}
	
}
