package model;

public class Admin {
	private String id;
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
}
