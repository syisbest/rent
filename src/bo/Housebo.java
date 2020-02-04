package bo;

import java.util.ArrayList;

import dao.HouseDaoImple;
import model.House;

public class Housebo {
public int delete1(House house) {
	HouseDaoImple con = new HouseDaoImple();
	if(con.delete(house.getHid())==1)
		return 1;
	else
		return 0;
}
public int find11(House house,String hid) {
	HouseDaoImple con = new HouseDaoImple();
	if(con.find(house,hid)==1)
		return 1;
	else
		return 0;
}
public int fing22(String llid,ArrayList<House>house) {
	HouseDaoImple con = new HouseDaoImple();
	if(con.find2(llid,house)==1)
		return 1;
	else
		return 0;
}
public int find33(int  Size,ArrayList<House> house) {
	HouseDaoImple con = new HouseDaoImple();
	if(con.find3(Size,house)==1)
		return 1;
	else
		return 0;
}
public int find44(ArrayList<House> house,String Type) {
	HouseDaoImple con = new HouseDaoImple();
	if(con.find4(house,Type)==1)
		return 1;
	else
		return 0;
}
public int updatess(House house,String hid,String address) {
	HouseDaoImple con = new HouseDaoImple();
	if(con.update(house, hid, address)==1)
		return 1;
	else
		return 0;
}
}