package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.RegisterDaoImpl;
import model.Admin;
import model.Landlord;
import model.Lodge;
import util.MyDocument;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ItemEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField idtxt;
	String choose;
	String sexStr;
	private JTextField psdtxt1;
	private JTextField psdtxt2;
	private JTextField nametxt;
	private JTextField agetxt;
	private JTextField idnotxt;
	private JTextField teltxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Register frame = new Register();
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
	public Register() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 617);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setBg();
		
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		JLabel id = new JLabel("\u8D26\u53F7\uFF1A");
		id.setBounds(73, 65, 72, 18);
		contentPane.add(id);
		
		JLabel password1 = new JLabel("\u5BC6\u7801\uFF1A");
		password1.setBounds(73, 125, 72, 18);
		contentPane.add(password1);
		
		idtxt = new JTextField();
		idtxt.setBounds(150, 62, 182, 24);
		contentPane.add(idtxt);
		idtxt.setDocument(new MyDocument(10));
		idtxt.setColumns(10);
		
		psdtxt1 = new JTextField();
		psdtxt1.setToolTipText("6-10\u4F4D\u5B57\u7B26");
		psdtxt1.setBounds(150, 122, 182, 24);
		psdtxt1.setDocument(new MyDocument(10));
		contentPane.add(psdtxt1);
		psdtxt1.setColumns(10);
		
		JLabel password2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		password2.setBounds(73, 185, 82, 18);
		contentPane.add(password2);
		
		JLabel name = new JLabel("\u59D3\u540D\uFF1A");
		name.setBounds(73, 245, 72, 18);
		contentPane.add(name);
		
		JLabel age = new JLabel("\u5E74\u9F84\uFF1A");
		age.setBounds(73, 305, 72, 18);
		contentPane.add(age);
		
		JLabel sex = new JLabel("\u6027\u522B\uFF1A");
		sex.setBounds(73, 365, 72, 18);
		contentPane.add(sex);
		
		psdtxt2 = new JTextField();
		psdtxt2.setToolTipText("\u4E24\u6B21\u8F93\u5165\u5BC6\u7801\u9700\u8981\u4E00\u81F4");
		psdtxt2.setBounds(150, 182, 182, 24);
		psdtxt2.setDocument(new MyDocument(10));
		contentPane.add(psdtxt2);
		psdtxt2.setColumns(10);
		
		nametxt = new JTextField();
		nametxt.setToolTipText("\u8BF7\u8F93\u5165\u771F\u5B9E\u59D3\u540D");
		nametxt.setBounds(150, 242, 182, 24);
		nametxt.setDocument(new MyDocument(10));
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		agetxt = new JTextField();
		agetxt.setToolTipText("18\u5C81\u4EE5\u4E0A");
		agetxt.setColumns(10);
		agetxt.setBounds(150, 302, 182, 24);
		agetxt.setDocument(new MyDocument(2));
		contentPane.add(agetxt);
		
		JLabel idno = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		idno.setBounds(73, 425, 82, 18);
		contentPane.add(idno);
		
		idnotxt = new JTextField();
		idnotxt.setToolTipText("\u8BF7\u8F93\u5165\u771F\u5B9E\u8EAB\u4EFD\u8BC1\u53F7");
		idnotxt.setColumns(10);
		idnotxt.setBounds(150, 422, 182, 24);
		idnotxt.setDocument(new MyDocument(18));
		contentPane.add(idnotxt);
		
		JLabel tel = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		tel.setBounds(73, 485, 82, 18);
		contentPane.add(tel);
		
		teltxt = new JTextField();
		teltxt.setToolTipText("\u8F93\u5165\u771F\u5B9E\u8054\u7CFB\u7535\u8BDD\uFF0C\u65B9\u4FBF\u4ED6\u4EBA\u8054\u7CFB\u60A8");
		teltxt.setBounds(150, 482, 182, 24);
		teltxt.setDocument(new MyDocument(11));
		contentPane.add(teltxt);
		teltxt.setColumns(10);
		
		
		
		JButton exit = new JButton("\u53D6\u6D88");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exit.setBounds(219, 530, 113, 27);
		contentPane.add(exit);
		
		JComboBox sexbox = new JComboBox();
		sexbox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		sexbox.setBounds(150, 362, 182, 24);
		contentPane.add(sexbox);
		
		JRadioButton lodge = new JRadioButton("\u79DF\u5BA2");
		lodge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose = "lodge";
			}
		});
		lodge.setBounds(219, 9, 72, 27);
		contentPane.add(lodge);
		
		JRadioButton landlord = new JRadioButton("\u623F\u4E1C");
		landlord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose = "landlord";
			}
		});
		landlord.setBounds(104, 9, 82, 27);
		contentPane.add(landlord);
		
		ButtonGroup group=new ButtonGroup();
		group.add(lodge);
		group.add(landlord);
		
		JButton confirm = new JButton("\u786E\u5B9A");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(choose=="lodge") {
					if(psdtxt1.getText().equals(psdtxt2.getText())) {
						if(psdtxt1.getText().length()>=6) {
							if((teltxt.getText().length()==11) && (teltxt.getText().substring(0, 1).equals("1")) &&(isNumeric(teltxt.getText())) ) {
								if((idnotxt.getText().length()==18) && (isNumeric(idnotxt.getText()))) {
									
									Lodge lodge = new Lodge(idtxt.getText(),nametxt.getText(),
											sexbox.getSelectedItem().toString(),Integer.parseInt(agetxt.getText()),
											teltxt.getText(),psdtxt1.getText(),idnotxt.getText());
									RegisterDaoImpl registerDao = new RegisterDaoImpl();
									try {
										registerDao.register(lodge);
										JOptionPane.showMessageDialog(null, "注册成功");
										dispose();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										JOptionPane.showMessageDialog(null, "用户名已存在或格式错误");
										
									}				
									
								}else {
									JOptionPane.showMessageDialog(null, "身份证号码长度或格式错误");
								}
							}else {
								JOptionPane.showMessageDialog(null, "电话号码长度或格式错误");
							}
						}else {
							JOptionPane.showMessageDialog(null, "密码长度错误");
						}	
					}else {
						JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入");
					}
					
				}
				if(choose=="landlord") {
					if(psdtxt1.getText().equals(psdtxt2.getText())) {
						if(psdtxt1.getText().length()>=6) {
							if((teltxt.getText().length()==11) && (teltxt.getText().substring(0, 1).equals("1")) &&(isNumeric(teltxt.getText())) ) {
								if((idnotxt.getText().length()==18) && (isNumeric(idnotxt.getText()))) {
									
									Landlord landlord = new Landlord(idtxt.getText(),nametxt.getText(),
											sexbox.getSelectedItem().toString(),Integer.parseInt(agetxt.getText()),
											teltxt.getText(),psdtxt1.getText(),idnotxt.getText());
									RegisterDaoImpl registerDao = new RegisterDaoImpl();
									try {
										registerDao.register(landlord);
										JOptionPane.showMessageDialog(null, "注册成功");
										dispose();
									} catch (SQLException e) {
										// TODO Auto-generated catch block
										JOptionPane.showMessageDialog(null, "用户名已存在或格式错误");
									}
										
									
								}else {
									JOptionPane.showMessageDialog(null, "身份证号码长度或格式错误");
								}
							}else {
								JOptionPane.showMessageDialog(null, "电话号码长度或格式错误");
							}
						}else {
							JOptionPane.showMessageDialog(null, "密码长度错误");
						}	
					}else {
						JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入");
					}
				}
				else if(choose==null) {
					JOptionPane.showMessageDialog(null, "选择用户类型");
				}
			}
		});
		confirm.setBounds(73, 530, 113, 27);
		contentPane.add(confirm);	
	}
	public void setBg(){ 
		((JPanel)this.getContentPane()).setOpaque(false);     
		ImageIcon img = new ImageIcon("pic/register.jpg");     
		JLabel background = new JLabel(img);    
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());   
	}
	
	 public boolean isNumeric(String str){
        for(int i = 0; i < str.length(); i++){
        	if (!Character.isDigit(str.charAt(i))){
        		return false;
        		}
        	}
        return true;
        }
}
