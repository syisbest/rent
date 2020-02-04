package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import bo.ContractBoImpl;
import dao.ContractDaoImpl;
import model.Contract;
import model.Landlord;
import model.Lodge;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class LandlordContractView extends JFrame {

	private JPanel contentPane;
	private JTable contractTable;
	
	private ArrayList<Contract> cs = new ArrayList<Contract>();
	private ContractBoImpl cont = new ContractBoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Landlord ll = new Landlord();
//					ll.setLLid("2");
//					LandlordContractView frame = new LandlordContractView(ll);
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
	public LandlordContractView(Landlord ll) {
		setTitle("\u5408\u540C\u67E5\u770B\uFF08\u623F\u4E1C\u754C\u9762\uFF09");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 667, 300);
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
//		数据读取
		cont.findPendingCon(cs, ll);
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
		allButton.setBounds(23, 228, 103, 23);
		contentPane.add(allButton);
		
		JButton agreeButton = new JButton("\u540C\u610F");
		agreeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Contract> c = new ArrayList<Contract>();
				ArrayList<Contract> s = new ArrayList<Contract>();
				int m = 0;
//				修改
				for(int i = 0; i<cs.size(); i++) {
					if((boolean) contractTable.getValueAt(i, 7) && dt[i][6].toString().equals("未处理")) {
						c.add(cs.get(i));
						cont.handleCon(c, "1");
						dt[i][4] = cont.setDate(c);
						for(int k = 0; k<cs.size(); k++) {
							if(dt[i][2].equals(dt[k][2]) && i!=k) {
								s.add(cs.get(k));
								cont.handleCon(s, "-1");
								dt[k][4] = cont.setDate(s);
								dt[k][6] = "不同意";
								contractTable.setValueAt("不同意",k, 6);
								contractTable.setValueAt(false,k, 7);
							}	
						}
							
						dt[i][6] = "同意";
					}	
					else if(!contractTable.getValueAt(i, 6).toString().equals("未处理") && m==0 && (boolean) contractTable.getValueAt(i, 7)) {
						JOptionPane.showMessageDialog(null,"只能更改未处理的合同");
						m++;
					}
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
				allButton.setSelected(false);
			}
		});
		agreeButton.setBounds(171, 228, 93, 23);
		contentPane.add(agreeButton);
		
		JButton disagreeButton = new JButton("\u4E0D\u540C\u610F");
		disagreeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Contract> c = new ArrayList<Contract>();
				int m = 0;
//				修改
				for(int i = 0; i<cs.size(); i++) {
					if((boolean) contractTable.getValueAt(i, 7) && contractTable.getValueAt(i, 6).toString().equals("未处理")) {
						c.add(cs.get(i));
						cont.handleCon(c, "-1");
						dt[i][4] = cont.setDate(c);
						dt[i][6] = "不同意";
						dt[i][7] = false;
					}	
					else if(!contractTable.getValueAt(i, 6).toString().equals("未处理") && m==0 && (boolean) contractTable.getValueAt(i, 7)) {
						JOptionPane.showMessageDialog(null,"只能更改未处理的合同");
						m++;
					}
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
				allButton.setSelected(false);
			}
		});
		disagreeButton.setBounds(295, 228, 93, 23);
		contentPane.add(disagreeButton);
		
	}
}
