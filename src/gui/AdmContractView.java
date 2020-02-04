package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bo.ContractBoImpl;
import model.Contract;
import util.Check;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextPane;

public class AdmContractView extends JFrame {

	private JPanel contentPane;
	private JTable contractTable;
	
	private ArrayList<Contract> cs = new ArrayList<Contract>();
	private ContractBoImpl cont = new ContractBoImpl();
	private JTextField Cno;
	private JTextField Lid;
	private JTextField LLid;
	private JTextField Date;
	private JTextField Rent;
	private JTextField Time;
	private JTextField Hid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					AdmContractView frame = new AdmContractView();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdmContractView() {
		setTitle("\u5408\u540C\u67E5\u8BE2\uFF08\u7BA1\u7406\u5458\u754C\u9762\uFF09");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 667, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 631, 196);
		contentPane.add(scrollPane);
		
		contractTable = new JTable();
		contractTable.setForeground(Color.BLACK);
//		读取数据
		cont.findAllCon(cs);
//		初始化表格
		Object[][] dt = dataInput(cs);
		String[] title = {
				"\u5408\u540C\u7F16\u53F7", "\u79DF\u5BA2\u8D26\u53F7", "\u623F\u5C4B\u7F16\u53F7", "\u6210\u4EA4\u6708\u79DF", "\u6210\u4EA4\u65E5\u671F", "\u79DF\u8D41\u65F6\u957F", "\u5408\u540C\u72B6\u6001", "\u9009\u62E9"
				};
		contractTable.setModel(new DefaultTableModel(dt,title) {
			Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		scrollPane.setViewportView(contractTable);
		
		JCheckBox allButton = new JCheckBox("\u5168\u9009");
		allButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				事件触发在点击结束之后，此时allButton.isSelected是点击后的状态
				Object[][] dt = dataInput(cs);
				if(allButton.isSelected()) {
					for(int i = 0; i<cs.size(); i++)
						dt[i][7] = true;
				}
				else {
					for(int i = 0; i<cs.size(); i++)
						dt[i][7] = false;
				}
//				刷新
				contractTable.setModel(new DefaultTableModel(dt,title) {
					Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
			}
		});
		allButton.setEnabled(true);
		allButton.setBounds(569, 212, 72, 23);
		contentPane.add(allButton);
		
		Cno = new JTextField();
		Cno.setBounds(90, 229, 137, 21);
		contentPane.add(Cno);
		Cno.setColumns(10);
		
		JComboBox choose = new JComboBox();
		choose.setModel(new DefaultComboBoxModel(new String[] {"", "\u540C\u610F", "\u672A\u5904\u7406", "\u4E0D\u540C\u610F", "\u5230\u671F"}));
		choose.setBounds(298, 303, 137, 23);
		contentPane.add(choose);
		
		JButton find = new JButton("\u67E5\u8BE2");
		find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				ArrayList<String> s1 = new ArrayList<String>();
				ArrayList<String> s2 = new ArrayList<String>();
				ArrayList<String> s3 = new ArrayList<String>();
				if(!Cno.getText().equals("")) {
					s1.add("Cno");
					s1.add(Cno.getText());
				}
				if(!Hid.getText().equals("")) {
					s1.add("Hid");
					s1.add(Hid.getText());
				}
				if(!Date.getText().equals("")) {
					s1.add("Date");
					s1.add(Date.getText());
				}
				if(!Lid.getText().equals("")) {
					s1.add("Lid");
					s1.add(Lid.getText());
				}
				if(!choose.getSelectedItem().toString().equalsIgnoreCase("")) {
					s1.add("Status");
					if(choose.getSelectedItem().toString().equalsIgnoreCase("未处理"))
						s1.add("0");
					else if(choose.getSelectedItem().toString().equalsIgnoreCase("同意"))
						s1.add("1");
					else if(choose.getSelectedItem().toString().equalsIgnoreCase("不同意"))
						s1.add("-1");
					else if(choose.getSelectedItem().toString().equalsIgnoreCase("到期"))
						s1.add("-2");
				}
				if(!Rent.getText().equals("")) {
					s2.add("Rent");
					s2.add(Rent.getText());
				}
				if(!Time.getText().equals("")) {
					s2.add("Time");
					s2.add(Time.getText());
				}
				if(!LLid.getText().equals("")) {
					s3.add(LLid.getText());
				}
				cont.combinedQuery(cs, s1, s2, s3);
				
//					设置长度及初始化数据
					Object[][] dt = dataInput(cs);
					contractTable.setModel(new DefaultTableModel(dt,title) {
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				allButton.setSelected(false);
			}
		});
		find.setBounds(445, 303, 93, 23);
		contentPane.add(find);
		
		JButton change = new JButton("\u5408\u540C\u5230\u671F");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Contract> c = new ArrayList<Contract>();
				Object[][] dt = dataInput(cs);
//				修改
				int m = 0;
				for(int i = 0; i<cs.size(); i++) {
					if((boolean) contractTable.getValueAt(i, 7) 
							&& contractTable.getValueAt(i, 6).toString().equals("同意") 
							&& Check.check(contractTable.getValueAt(i, 4).toString(),contractTable.getValueAt(i, 5).toString())) {
						c.add(cs.get(i));
						cont.handleCon(c, "-2");
						dt[i][6] = "到期";
					}
					else if(!(contractTable.getValueAt(i, 6).toString().equals("同意")) && m==0 && (boolean) contractTable.getValueAt(i, 7)) {
						JOptionPane.showMessageDialog(null,"只能更改生效（同意）的合同");
						m++;
					}
				}
//				刷新
				contractTable.setModel(new DefaultTableModel(dt,title) {
					Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				allButton.setSelected(false);
			}
		});
		change.setBounds(548, 303, 93, 23);
		contentPane.add(change);
		
		JLabel label = new JLabel("\u5408\u540C\u7F16\u53F7");
		label.setBounds(10, 232, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u79DF\u5BA2");
		label_1.setBounds(10, 257, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u623F\u4E1C");
		label_2.setBounds(10, 282, 54, 15);
		contentPane.add(label_2);
		
		JLabel lblNewLabel = new JLabel("\u65E5\u671F");
		lblNewLabel.setBounds(10, 307, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label_3 = new JLabel("\u6708\u79DF");
		label_3.setBounds(237, 232, 54, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u79DF\u8D41\u65F6\u957F");
		label_4.setBounds(237, 257, 54, 15);
		contentPane.add(label_4);
		
		Lid = new JTextField();
		Lid.setBounds(90, 254, 137, 21);
		contentPane.add(Lid);
		Lid.setColumns(10);
		
		LLid = new JTextField();
		LLid.setBounds(90, 279, 137, 21);
		contentPane.add(LLid);
		LLid.setColumns(10);
		
		Date = new JTextField();
		Date.setBounds(90, 304, 137, 21);
		contentPane.add(Date);
		Date.setColumns(10);
		
		Rent = new JTextField();
		Rent.setBounds(298, 229, 137, 21);
		contentPane.add(Rent);
		Rent.setColumns(10);
		
		Time = new JTextField();
		Time.setBounds(298, 254, 137, 21);
		contentPane.add(Time);
		Time.setColumns(10);
		
		Hid = new JTextField();
		Hid.setBounds(298, 279, 137, 21);
		contentPane.add(Hid);
		Hid.setColumns(10);
		
		JLabel label_5 = new JLabel("\u623F\u5C4B");
		label_5.setBounds(237, 282, 54, 15);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u5408\u540C\u72B6\u6001");
		label_6.setBounds(237, 307, 54, 15);
		contentPane.add(label_6);
		
		

	}
	
	private static Object[][] dataInput(ArrayList<Contract> cs){
//		设置长度及初始化数据
		Object[][] dt = new Object[cs.size()][8];
		for(int i = 0; i<cs.size(); i++) {
			dt[i][0] = cs.get(i).getCno();
			dt[i][1] = cs.get(i).getLodge().getLid();
			dt[i][2] = cs.get(i).getHouse().getHid();
			dt[i][3] = cs.get(i).getRent();
			dt[i][4] = cs.get(i).getDate();
			dt[i][5] = cs.get(i).getTime();
			if(cs.get(i).getStatus().equalsIgnoreCase("0"))
				dt[i][6] = "未处理";
			else if(cs.get(i).getStatus().equalsIgnoreCase("1"))
				dt[i][6] = "同意";
			else if(cs.get(i).getStatus().equalsIgnoreCase("-1"))
				dt[i][6] = "不同意";
			else if(cs.get(i).getStatus().equalsIgnoreCase("-2"))
				dt[i][6] = "到期";
			dt[i][7] = false;
		}
		return dt;
	}
}
