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
import dao.ContractDaoImpl;
import model.Contract;
import model.Landlord;
import model.Lodge;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class LodgeContractView2 extends JFrame {

	private JPanel contentPane;
	private JTable contractTable;
	
	private ArrayList<Contract> cs = new ArrayList<Contract>();
	private ContractBoImpl cont = new ContractBoImpl();
	private ContractDaoImpl contt = new ContractDaoImpl();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lodge lodge = new Lodge();
					//l.setLid("1");
					LodgeContractView2 frame = new LodgeContractView2(lodge);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LodgeContractView2(Lodge lodge) {
		setTitle("\u5408\u540C\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
//		读取数据
		cont.findLodgeCon(cs, lodge);
//		设置长度及初始化数据
		Object[][] dt = dataInput(cs);
		String[] title = {
				"\u5408\u540C\u7F16\u53F7", "\u79DF\u5BA2\u8D26\u53F7", "\u623F\u5C4B\u7F16\u53F7", "\u6210\u4EA4\u6708\u79DF", "\u6210\u4EA4\u65E5\u671F", "\u79DF\u8D41\u65F6\u957F", "\u5408\u540C\u72B6\u6001"
				};
		contractTable.setModel(new DefaultTableModel(dt,title) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(contractTable);
		
		JButton button = new JButton("\u6E05\u9664\u4E0D\u540C\u610F\u5408\u540C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int m = 0, size = cs.size();
//				修改
				for(int i = 0; i<size; i++) {
					if(contractTable.getValueAt(i, 6).toString().equals("不同意")) {
						cs.remove(i-m);
						m++;
					}	
				}
				cont.deleteCon(lodge);
				Object[][] dt = dataInput(cs);
//				刷新
				contractTable.setModel(new DefaultTableModel(dt,title) {
					Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				if(size==cs.size())
					JOptionPane.showMessageDialog(null,"无可清理合同");
			}
		});
		button.setBounds(20, 229, 135, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u64A4\u56DE\u7533\u8BF7");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(contt.delete0(lodge,textField.getText())==0) {
					JOptionPane.showMessageDialog(null, "撤回失败");
				}else {
					cont.findLodgeCon(cs, lodge);
					Object[][] dt = dataInput(cs);
//					刷新
					contractTable.setModel(new DefaultTableModel(dt,title) {
						Class[] columnTypes = new Class[] {
								Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
							};
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
					JOptionPane.showMessageDialog(null, "撤回成功");
				}
			}
		});
		button_1.setBounds(528, 227, 113, 27);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setBounds(439, 228, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u53EF\u64A4\u56DE\u672A\u5904\u7406\u5408\u540C\uFF0C\u7F16\u53F7\uFF1A");
		label.setBounds(257, 231, 181, 18);
		contentPane.add(label);
		
	}
	
	private static Object[][] dataInput(ArrayList<Contract> cs){
//		设置长度及初始化数据
		Object[][] dt = new Object[cs.size()][7];
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
		}
		return dt;
	}
}
