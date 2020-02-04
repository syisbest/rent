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
import dao.HouseDaoImple;
import model.Contract;
import model.House;
import model.Landlord;
import model.Lodge;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class LodgeContractView1 extends JFrame {

	private JPanel contentPane;
	private JTable housetable;
	
	private ArrayList<House> house = new ArrayList<House>();
	private HouseDaoImple contt = new HouseDaoImple();
	private ContractBoImpl conn=new ContractBoImpl();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Lodge l = new Lodge();
//					LodgeContractView2 frame = new LodgeContractView2(l);
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
	public LodgeContractView1(Lodge lodge) {
		setTitle("\u79DF\u623F\u67E5\u8BE2");
		setBounds(100, 100, 750, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 73, 722, 331);
		contentPane.add(scrollPane);
		
		housetable = new JTable();
		housetable.setForeground(Color.BLACK);
//		读取数据
//		contt.findhouse(house);
//		设置长度及初始化数据
//
//		Object[][] dt= dataInput(house);
		Object[][] dt = null;
		housetable.setModel(new DefaultTableModel(
			dt
			,
			new String[] {
				"\u623F\u5C4B\u7F16\u53F7", "\u623F\u5C4B\u623F\u4E1C", "\u623F\u5C4B\u5730\u5740", "\u623F\u5C4B\u5927\u5C0F", "\u623F\u5C4B\u6237\u578B", "\u7533\u8BF7\u79DF\u51ED"
			}
		) {
			private static final long serialVersionUID = 2827389194781876220L;
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JButton button = new JButton("\u603B\u4F53\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				读取数据
				contt.findhouse(house);
//				设置长度及初始化数据
				Object[][] dt= dataInput(house);
				housetable.setModel(new DefaultTableModel(
						dt
						,
						new String[] {
							"\u623F\u5C4B\u7F16\u53F7", "\u623F\u5C4B\u623F\u4E1C", "\u623F\u5C4B\u5730\u5740", "\u623F\u5C4B\u5927\u5C0F", "\u623F\u5C4B\u6237\u578B", "\u7533\u8BF7\u79DF\u51ED"
						}
					) {
						private static final long serialVersionUID = 2827389194781876220L;
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				
			}
		});
		button.setBounds(10, 26, 110, 27);
		contentPane.add(button);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setBounds(165, 26, 50, 27);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("\u6309\u623F\u5C4B\u5927\u5C0F\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contt.findhousesize(house,Integer.parseInt(textField_1.getText()));
				Object[][] dt= dataInput(house);
				housetable.setModel(new DefaultTableModel(
						dt
						,
						new String[] {
							"\u623F\u5C4B\u7F16\u53F7", "\u623F\u5C4B\u623F\u4E1C", "\u623F\u5C4B\u5730\u5740", "\u623F\u5C4B\u5927\u5C0F", "\u623F\u5C4B\u6237\u578B", "\u7533\u8BF7\u79DF\u51ED"
						}
					) {
						private static final long serialVersionUID = 2827389194781876220L;
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
			}
		});
		button_1.setBounds(220, 26, 150, 27);
		contentPane.add(button_1);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setBounds(385, 26, 50, 27);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_2 = new JButton("\u6309\u623F\u5C4B\u6237\u578B\u67E5\u8BE2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				contt.findhousetype(house,textField_2.getText());
				Object[][] dt= dataInput(house);
				housetable.setModel(new DefaultTableModel(
						dt
						,
						new String[] {
							"\u623F\u5C4B\u7F16\u53F7", "\u623F\u5C4B\u623F\u4E1C", "\u623F\u5C4B\u5730\u5740", "\u623F\u5C4B\u5927\u5C0F", "\u623F\u5C4B\u6237\u578B", "\u7533\u8BF7\u79DF\u51ED"
						}
					) {
						private static final long serialVersionUID = 2827389194781876220L;
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				
			}
		});
		button_2.setBounds(440, 26, 150, 27);
		contentPane.add(button_2);
		
		scrollPane.setViewportView(housetable);
		
		JLabel lblNewLabel = new JLabel("\u7533\u8BF7\u79DF\u623F\u65F6\u95F4\uFF1A");
		lblNewLabel.setBounds(285, 440, 118, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(402, 437, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E2A\u6708");
		lblNewLabel_1.setBounds(489, 440, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u63D0\u4EA4\u7533\u8BF7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int con=0;
				if(textField.getText().equals("")) {JOptionPane.showMessageDialog(null, "请输入求租时长");}
				else {
				House h = new House();
				for(int i=0;i<house.size();i++) {
					if((boolean)housetable.getValueAt(i, 5)) {
						h.setHid(housetable.getValueAt(i, 0).toString());
						conn.addCon(lodge,h,h.getSize()*20,Integer.parseInt(textField.getText()));
						con++;
					}
				}
				if(con>0){	
					JOptionPane.showMessageDialog(null, "申请已发送，请耐心等待");
				}else {
					JOptionPane.showMessageDialog(null, "申请为空");
				}
			}
			}
		});
		btnNewButton.setBounds(603, 427, 127, 36);
		contentPane.add(btnNewButton);		
		
		JButton btnNewButton_1 = new JButton("\u7EC4\u5408\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contt.findhousesizetype(house,Integer.parseInt(textField_1.getText()),textField_2.getText());
				Object[][] dt= dataInput(house);
				housetable.setModel(new DefaultTableModel(
						dt
						,
						new String[] {
							"\u623F\u5C4B\u7F16\u53F7", "\u623F\u5C4B\u623F\u4E1C", "\u623F\u5C4B\u5730\u5740", "\u623F\u5C4B\u5927\u5C0F", "\u623F\u5C4B\u6237\u578B", "\u7533\u8BF7\u79DF\u51ED"
						}
					) {
						private static final long serialVersionUID = 2827389194781876220L;
						Class[] columnTypes = new Class[] {
							Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
			}
		});
		btnNewButton_1.setBounds(619, 26, 113, 27);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u63D0\u793A\uFF1A\u6708\u79DF\u4E3A\u623F\u5C4B\u9762\u79EF\u768420\u500D");
		lblNewLabel_2.setBounds(12, 440, 250, 18);
		contentPane.add(lblNewLabel_2);
	}
	
	private static Object[][] dataInput(ArrayList<House> cs){
//		设置长度及初始化数据
		Object[][] dt = new Object[cs.size()][6];
		for(int i = 0; i<cs.size(); i++) {
			dt[i][0] = cs.get(i).getHid();
			dt[i][1] = cs.get(i).getLLid().getLLid();
			dt[i][2] = cs.get(i).getAddress();
			dt[i][3] = cs.get(i).getSize();
			dt[i][4] = cs.get(i).getType();

			dt[i][5] = false;
		}
		return dt;
	}
}
