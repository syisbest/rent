package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import dao.AdminDaoImpl;
import model.Landlord;
import model.Lodge;
import util.MyDocument;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminUser extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idtxt;
	private JTextField nametxt;
	private JTextField teltxt;
	private JTextField idnotxt;
	private JTextField psdtxt;
	private JTextField agetxt;
	private JComboBox userbox;
	private JComboBox sexbox;
	
	private ArrayList<Lodge> lodgelist = new ArrayList<Lodge>();
	private ArrayList<Landlord> landlordlist = new ArrayList<Landlord>();
	private AdminDaoImpl admin = new AdminDaoImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					AdminUser frame = new AdminUser();
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
	public AdminUser(){
		setTitle("\u7528\u6237\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 821, 627);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 96, 789, 441);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		setLodgeTableAll();
		table.setRowHeight(25);
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("\u8D26\u53F7\uFF1A");
		label.setBounds(14, 13, 45, 18);
		contentPane.add(label);
		
		idtxt = new JTextField();
		idtxt.setBounds(63, 10, 86, 24);
		contentPane.add(idtxt);
		idtxt.setColumns(10);
		idtxt.setDocument(new MyDocument(10));
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		label_1.setBounds(163, 13, 45, 18);
		contentPane.add(label_1);
		
		nametxt = new JTextField();
		nametxt.setBounds(211, 10, 55, 24);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		nametxt.setDocument(new MyDocument(10));
		
		JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
		label_2.setBounds(273, 13, 45, 18);
		contentPane.add(label_2);
		
		sexbox = new JComboBox();
		sexbox.setModel(new DefaultComboBoxModel(new String[] {"null", "\u7537", "\u5973"}));
		sexbox.setBounds(318, 10, 45, 24);
		contentPane.add(sexbox);
		
		JLabel label_3 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\uFF1A");
		label_3.setBounds(377, 13, 80, 18);
		contentPane.add(label_3);
		
		teltxt = new JTextField();
		teltxt.setBounds(457, 10, 86, 24);
		contentPane.add(teltxt);
		teltxt.setColumns(10);
		teltxt.setDocument(new MyDocument(11));
		
		JLabel label_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_4.setBounds(557, 13, 80, 18);
		contentPane.add(label_4);
		
		idnotxt = new JTextField();
		idnotxt.setBounds(636, 10, 167, 24);
		contentPane.add(idnotxt);
		idnotxt.setColumns(10);
		idnotxt.setDocument(new MyDocument(18));
		
		
		JLabel label_5 = new JLabel("\u5BC6\u7801\uFF1A");
		label_5.setBounds(14, 51, 45, 18);
		contentPane.add(label_5);
		
		psdtxt = new JTextField();
		psdtxt.setBounds(63, 47, 113, 24);
		contentPane.add(psdtxt);
		psdtxt.setColumns(10);
		psdtxt.setDocument(new MyDocument(10));
		
		JLabel label_6 = new JLabel("\u5E74\u9F84\uFF1A");
		label_6.setBounds(180, 51, 45, 18);
		contentPane.add(label_6);
		
		agetxt = new JTextField();
		agetxt.setBounds(225, 48, 33, 24);
		contentPane.add(agetxt);
		agetxt.setColumns(10);
		agetxt.setDocument(new MyDocument(2));
		
		JLabel label_7 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		label_7.setBounds(283, 51, 80, 18);
		contentPane.add(label_7);
		
		userbox = new JComboBox();
		userbox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userbox.getSelectedItem().toString().equals("租客")) {
					setLodgeTableAll();				
				}
				
				if(userbox.getSelectedItem().toString().equals("房东")) {
					setLandlordTableALL();
				}
			}
		});
		userbox.setModel(new DefaultComboBoxModel(new String[] {"\u79DF\u5BA2", "\u623F\u4E1C"}));
		userbox.setBounds(365, 48, 55, 24);
		contentPane.add(userbox);
		
		JButton inquire = new JButton("\u67E5\u8BE2");
		inquire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(userbox.getSelectedItem().toString().equals("租客")) {
					ArrayList<String> s1 = new ArrayList<String>();
					if(!idtxt.getText().equals("")) {
						s1.add("Lid");
						s1.add(idtxt.getText());
					}
					if(!idnotxt.getText().equals("")) {
						s1.add("Lidno");
						s1.add(idnotxt.getText());
					}
					if(!nametxt.getText().equals("")) {
						s1.add("Lname");
						s1.add(nametxt.getText());
					}
					if(!agetxt.getText().equals("")) {
						s1.add("Lage");
						s1.add(agetxt.getText());
					}
					if(!teltxt.getText().equals("")) {
						s1.add("Ltel");
						s1.add(teltxt.getText());
					}
					if(!sexbox.getSelectedItem().toString().equals("null")) {
						s1.add("Lsex");
						s1.add(sexbox.getSelectedItem().toString());
					}
					setLodgeTableA(s1);
					
				}
				if(userbox.getSelectedItem().toString().equals("房东")) {
					ArrayList<String> s1 = new ArrayList<String>();
					if(!idtxt.getText().equals("")) {
						s1.add("LLid");
						s1.add(idtxt.getText());
					}
					if(!idnotxt.getText().equals("")) {
						s1.add("LLidno");
						s1.add(idnotxt.getText());
					}
					if(!nametxt.getText().equals("")) {
						s1.add("LLname");
						s1.add(nametxt.getText());
					}
					if(!agetxt.getText().equals("")) {
						s1.add("LLage");
						s1.add(agetxt.getText());
					}
					if(!teltxt.getText().equals("")) {
						s1.add("LLtel");
						s1.add(teltxt.getText());
					}
					if(!sexbox.getSelectedItem().toString().equals("null")) {
						s1.add("LLsex");
						s1.add(sexbox.getSelectedItem().toString());
					}
					try {
						setLandlordTableA(s1);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		inquire.setBounds(690, 47, 113, 27);
		contentPane.add(inquire);
		
		JButton add = new JButton("\u6DFB\u52A0");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(userbox.getSelectedItem().toString().equals("租客")) {
					Lodge lodge = new Lodge(idtxt.getText(),nametxt.getText(),
							sexbox.getSelectedItem().toString(),Integer.parseInt(agetxt.getText()),
							teltxt.getText(),psdtxt.getText(),idnotxt.getText());			
					
					admin.addLodge(lodge);
					setLodgeTableAll();
				}
				if(userbox.getSelectedItem().toString().equals("房东")) {
					Landlord landlord = new Landlord(idtxt.getText(),nametxt.getText(),
							sexbox.getSelectedItem().toString(),Integer.parseInt(agetxt.getText()),
							teltxt.getText(),psdtxt.getText(),idnotxt.getText());
					System.out.print("1"+agetxt.getText());
					admin.addLandlord(landlord);
					setLandlordTableALL();
				}
			}
		});
		add.setBounds(456, 47, 113, 27);
		contentPane.add(add);
		
		JButton delete = new JButton("\u5220\u9664");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userbox.getSelectedItem().toString().equals("租客")) {
					Lodge lodge = new Lodge();
					lodge.setLid(idtxt.getText());
					
					admin.delLodge(lodge);
					
					setLodgeTableAll();
				}
				if(userbox.getSelectedItem().toString().equals("房东")) {
					Landlord landlord = new Landlord();
					landlord.setLLid(idtxt.getText());
					admin.delLandlord(landlord);
					
					setLandlordTableALL();
				}
				
			}
		});
		delete.setBounds(690, 550, 113, 27);
		contentPane.add(delete);
		
		JButton update = new JButton("\u4FEE\u6539");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userbox.getSelectedItem().toString().equals("租客")) {
					Lodge lodge = new Lodge();
					lodge.setLid(idtxt.getText());
					
					
					admin.updateLodge(lodge, nametxt.getText(), sexbox.getSelectedItem().toString(),
							Integer.parseInt(agetxt.getText()), teltxt.getText(), psdtxt.getText(), idnotxt.getText());
					
					
					setLodgeTableAll();
				}
				if(userbox.getSelectedItem().toString().equals("房东")) {
					Landlord landlord = new Landlord();
					landlord.setLLid(idtxt.getText());
					
					admin.updateLandlord(landlord ,nametxt.getText(), sexbox.getSelectedItem().toString(),
							Integer.parseInt(agetxt.getText()), teltxt.getText(), psdtxt.getText(), idnotxt.getText());
					
					setLandlordTableALL();
				}
			}
		});
		update.setBounds(456, 550, 113, 27);
		contentPane.add(update);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	public void setLodgeTable(ArrayList<Lodge> lodgelist) {
		Object[][] dt = new Object[lodgelist.size()][7];
		for(int i = 0; i<lodgelist.size(); i++) {
			dt[i][0] = lodgelist.get(i).getLid();
			dt[i][1] = lodgelist.get(i).getLpassword();
			dt[i][2] = lodgelist.get(i).getLname();
			dt[i][3] = lodgelist.get(i).getLsex();
			dt[i][4] = lodgelist.get(i).getLage();
			dt[i][5] = lodgelist.get(i).getLtel();
			dt[i][6] = lodgelist.get(i).getLidno();
		}
		String[] title={
				"\u8D26\u53F7", "\u5BC6\u7801", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u8054\u7CFB\u65B9\u5F0F", "\u8EAB\u4EFD\u8BC1\u53F7"
				};
		table.setModel(new DefaultTableModel(dt,title) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
	}
	public void setLandlordTable(ArrayList<Landlord> landlordlist) {
		Object[][] dt2 = new Object[landlordlist.size()][7];
		for(int i = 0; i<landlordlist.size(); i++) {
			dt2[i][0] = landlordlist.get(i).getLLid();
			dt2[i][1] = landlordlist.get(i).getPassword();
			dt2[i][2] = landlordlist.get(i).getLLname();
			dt2[i][3] = landlordlist.get(i).getLLsex();
			dt2[i][4] = landlordlist.get(i).getLLage();
			dt2[i][5] = landlordlist.get(i).getLLtel();
			dt2[i][6] = landlordlist.get(i).getLLidno();
		}
	
		String[] title={
			"\u8D26\u53F7", "\u5BC6\u7801", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u8054\u7CFB\u65B9\u5F0F", "\u8EAB\u4EFD\u8BC1\u53F7"
			};
		table.setModel(new DefaultTableModel(dt2,title) {
			Class[] columnTypes = new Class[] {
					Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
		});
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
	}
	public void setLodgeTableAll() {
		lodgelist=admin.findLodge();
		setLodgeTable(lodgelist);
	}
	public void setLandlordTableALL() {
		try {
			landlordlist = admin.findLandlord();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLandlordTable(landlordlist);
	}
	public void setLodgeTableA(ArrayList<String> s1 ) {
		lodgelist = admin.findlodge(s1);
		setLodgeTable(lodgelist);
	}
	public void setLandlordTableA(ArrayList<String> s1 ) throws SQLException {
		landlordlist = admin.findlandlord(s1);
		setLandlordTable(landlordlist);
	}
}
