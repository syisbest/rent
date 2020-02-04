package bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import dao.ContractDaoImpl;
import model.Contract;
import model.House;
import model.Landlord;
import model.Lodge;

public class ContractBoImpl {
	
	//查找生效的合同（房东）
//	public int findConInForce(ArrayList<Contract> c,Landlord ll){
//		ContractDaoImpl con = new ContractDaoImpl();
//		if(con.find(ll.getLLid(), "1", c, 1)==1)
//			return 1;
//		else
//			return 0;
//	}
	
	//查找生效的合同（租客）
//	public int findConInForce(ArrayList<Contract> c,Lodge l){
//		ContractDaoImpl con = new ContractDaoImpl();
//		if(con.find(l.getLid(), "1", c, 2)==1)
//			return 1;
//		else
//			return 0;
//	}
	
	//查找到期的合同（房东）
//	public int findExpiringCon(ArrayList<Contract> c,Landlord ll){
//		ContractDaoImpl con = new ContractDaoImpl();
//		if(con.find(ll.getLLid(), "-2", c, 1)==1)
//			return 1;
//		else
//			return 0;
//	}
	
	//查找到期的合同（租客）
//	public int findExpiringCon(ArrayList<Contract> c,Lodge l){
//		ContractDaoImpl con = new ContractDaoImpl();
//		if(con.find(l.getLid(), "-2", c, 2)==1)
//			return 1;
//		else
//			return 0;
//	}
	
	//查找待处理的合同（房东）
	public int findPendingCon(ArrayList<Contract> c,Landlord ll){
		ContractDaoImpl con = new ContractDaoImpl();
		if(con.find(ll.getLLid(), "0", c, 1)==1)
			return 1;
		else
			return 0;
	}
	
	//查找待处理的合同（租客）
//	public int findPendingCon(ArrayList<Contract> c,Lodge l){
//		ContractDaoImpl con = new ContractDaoImpl();
//		if(con.find(l.getLid(), "0", c, 2)==1)
//			return 1;
//		else
//			return 0;
//	}
	
	//处理合同(改变状态)
	public int handleCon(ArrayList<Contract> c,String status){
		ContractDaoImpl con = new ContractDaoImpl();
		if(con.change(c, status)==1)
			return 1;
		else
			return 0;
	}

	//按日期查找合同
//	public int findDateCon(ArrayList<Contract> c,String date){
//		ContractDaoImpl con = new ContractDaoImpl();
//		if(con.find(date, c, 1)==1)
//			return 1;
//		else
//			return 0;
//	}
//	
	//按编号查找合同
//	public int findCon(ArrayList<Contract> c,String cno){
//		ContractDaoImpl con = new ContractDaoImpl();
//		if(con.find(cno, c, 2)==1)
//			return 1;
//		else
//			return 0;
//	}
	
	//按房东查找合同
	public int findLandlordCon(ArrayList<Contract> c,Landlord ll){
		ContractDaoImpl con = new ContractDaoImpl();
		if(con.find(ll.getLLid(), c, 5)==1)
			return 1;
		else
			return 0;
	}
	public int findLandlordCon(ArrayList<Contract> c,String llid){
		ContractDaoImpl con = new ContractDaoImpl();
		if(con.find(llid, c, 5)==1)
			return 1;
		else
			return 0;
	}
	
	//按租客查找合同
	public int findLodgeCon(ArrayList<Contract> c,Lodge l){
		ContractDaoImpl con = new ContractDaoImpl();
		if(con.find(l.getLid(), c, 4)==1)
			return 1;
		else
			return 0;
	}
	public int findLodgeCon(ArrayList<Contract> c,String lid){
		ContractDaoImpl con = new ContractDaoImpl();
		if(con.find(lid, c, 4)==1)
			return 1;
		else
			return 0;
	}
	
	//按照房屋查找合同
//	public int findHouseCon(ArrayList<Contract> c,House h){
//		ContractDaoImpl con = new ContractDaoImpl();
//		if(con.find(h.getHid(), c, 3)==1)
//			return 1;
//		else
//			return 0;
//	}
//	public int findHouseCon(ArrayList<Contract> c,String hid){
//		ContractDaoImpl con = new ContractDaoImpl();
//		if(con.find(hid, c, 3)==1)
//			return 1;
//		else
//			return 0;
//	}
	
	//删除不同意合同
	public int deleteCon(Lodge l){
		ContractDaoImpl con = new ContractDaoImpl();
		if(con.delete(l)==1)
			return 1;
		else
			return 0;
	}
	
	
	//添加合同
	public int addCon(Lodge lodge,House house,int rent,int time) {
		ContractDaoImpl con = new ContractDaoImpl();
		String cno = con.getMaxCno();
		String date = null;
		//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		// new Date()为获取当前系统时间
		date = df.format(new Date());
		Contract contract = new Contract(cno,lodge,house,date,rent,time);
		if(con.add(contract)==1)
			return 1;
		else
			return 0;
	}
	public int addCon(Contract contract) {
		ContractDaoImpl con = new ContractDaoImpl();
		if(con.add(contract)==1)
			return 1;
		else
			return 0;
	}
	
//	全部查询
	public int findAllCon(ArrayList<Contract> c) {
		ContractDaoImpl con = new ContractDaoImpl();
		if(con.findAllCon(c)==1)
			return 1;
		else
			return 0;
	}
	
//	设置时间
	public String setDate(ArrayList<Contract> c) {
		ContractDaoImpl con = new ContractDaoImpl();
		String time = null;
		//设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		// new Date()为获取当前系统时间
		time = df.format(new Date());
		if(con.setDate(c,time)==1)
			return time;
		else
			return null;
	}
	public int setDate(ArrayList<Contract> c,String time) {
		ContractDaoImpl con = new ContractDaoImpl();
		if(con.setDate(c,time)==1)
			return 1;
		else
			return 0;
	}
	
//	组合查询
	public int combinedQuery(ArrayList<Contract> c, ArrayList<String> s1, ArrayList<String> s2, ArrayList<String> s3) {
		String sql = "select * from contract ";
		if(!(s1.size()==0 && s2.size()==0 && s3.size()==0))
			sql = sql + "where ";
		for(int i = 0; i<s1.size(); i++) {
			if(!s1.get(i).equals("Date")) {
				sql = sql + s1.get(i) + " ='" + s1.get(i+1) +"'" ;
				i++;
			}else {
				sql = sql + s1.get(i) + " like '" + s1.get(i+1) +"%'" ;
				i++;
			}
			if(i<s1.size()-1 || (s2.size()>0||s3.size()>0))
				sql = sql + " and ";
		}
		for(int i = 0; i<s2.size(); i++) {
			sql = sql + s2.get(i) + " = " + s2.get(i+1) +"" ;
			i++;
			if(i<s2.size()-1 || s3.size()>0)
				sql = sql + " and ";
		}
		if(s3.size()>0) {
			sql = sql + "Hid in (select Hid from house where LLid='" + s3.get(0) +"')";
		}
		System.out.println(sql);
		ContractDaoImpl con = new ContractDaoImpl();
		if(con.find(sql, c)==1)
			return 1;
		else
			return 0;
	}

}
