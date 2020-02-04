package util;

import java.util.ArrayList;

import model.Lodge;

public class SqlSelect {
	public String lodgeSelect(ArrayList<String> s1) {
	String sql = "select * from Lodge ";
	if(!(s1.size()==0))
		sql = sql + "where ";
	for(int i = 0; i<s1.size(); i++) {
		sql = sql + s1.get(i) + " ='" + s1.get(i+1) +"'" ;
		i++;
		if(i<s1.size()-1)
			sql = sql + " and ";
		}
	
	return sql;
	}
	public String landlordSelect(ArrayList<String> s1) {
		String sql = "select * from Landlord ";
		if(!(s1.size()==0))
			sql = sql + "where ";
		for(int i = 0; i<s1.size(); i++) {
			sql = sql + s1.get(i) + " ='" + s1.get(i+1) +"'" ;
			i++;
			if(i<s1.size()-1)
				sql = sql + " and ";
			}
		
		return sql;
		}
}
