package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.HouseDaoImple;
import dao.Landlorddao;
import dao.RegisterDaoImpl;
import model.House;
import model.Landlord;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LandlordGUI3 extends JFrame {

	private JPanel contentPane;
	
	private JTextField llid;
	private JTextField name;
	private JTextField sex;
	private JTextField age;
	private JTextField idno;
	private JTextField pass;
	private JTextField tel;
	private JButton btnNewButton;
	private JButton button;
	private JButton button_1;
	private JButton button_2;

	

	
public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					LandlordGUI frame = new LandlordGUI();
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
	public LandlordGUI3(Landlord landlord) {
		setTitle("\u623F\u5C4B\u4FE1\u606F\u66F4\u6539");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setBounds(0, 0, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setBounds(0, 71, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setBounds(0, 141, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74\u9F84");
		lblNewLabel_3.setBounds(0, 218, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7");
		lblNewLabel_4.setBounds(0, 304, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u5BC6\u7801");
		lblNewLabel_5.setBounds(0, 378, 72, 18);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u624B\u673A\u53F7");
		lblNewLabel_6.setBounds(0, 460, 72, 18);
		contentPane.add(lblNewLabel_6);
		llid = new JTextField();
		llid.setBounds(248, 13, 185, 24);
		contentPane.add(llid);
		llid.setColumns(10);
		
		name = new JTextField();
		name.setBounds(248, 68, 185, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		sex = new JTextField();
		sex.setBounds(248, 138, 185, 24);
		contentPane.add(sex);
		sex.setColumns(10);
		
		age = new JTextField();
		age.setBounds(248, 215, 185, 24);
		contentPane.add(age);
		age.setColumns(10);
		
		idno = new JTextField();
		idno.setBounds(248, 301, 185, 24);
		contentPane.add(idno);
		idno.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(248, 389, 185, 24);
		contentPane.add(pass);
		pass.setColumns(10);
		
		tel = new JTextField();
		tel.setBounds(248, 457, 185, 24);
		contentPane.add(tel);
		tel.setColumns(10);
		tel.setColumns(10);
		
		button_2 = new JButton("\u4FEE\u6539");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(pass.getText().length()>=6) {
						if(tel.getText().length()==11) {
							if(llid.getText().length()==18) {
								try{Landlorddao ll =new Landlorddao();
				ll.update(landlord,idno.getText(),name.getText(),sex.getText(),pass.getText(),Integer.parseInt(age.getText()),tel.getText());
				landlord.setLLidno(idno.getText());
				 landlord.setLLname(name.getText());
				 landlord.setLLsex(sex.getText());
				 landlord.setPassword(pass.getText());
				 landlord.setLLtel(tel.getText());
				 landlord.setLLage(Integer.parseInt(age.getText()));
				  landlord.setLLid(llid.getText());
				  JOptionPane.showMessageDialog(null, "修改失败");
					dispose();
									
								}catch(NumberFormatException e1) {
									JOptionPane.showMessageDialog(null, "请按要求填写各项信息");
								}
							}else {
								JOptionPane.showMessageDialog(null, "身份证号码长度错误");
							}
						}else {
							JOptionPane.showMessageDialog(null, "电话号码长度错误");
						}
					}else {
						JOptionPane.showMessageDialog(null, "密码长度错误");
					}	
				
			}
		});
		button_2.setBounds(93, 172, 113, 27);
		contentPane.add(button_2);
		
		
		
//
}}
