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

import dao.Lodgedao;
import dao.RegisterDaoImpl;
import model.Lodge;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class LodgeselfGUI11 extends JFrame {

	private JPanel contentPane;
	String choose;
	String sexStr;
	private JTextField psdtxt1;
	private JTextField psdtxt2;
	private JTextField nametxt;
	private JTextField agetxt;
	private JTextField idnotxt;
	private JTextField teltxt;
	/**
	 * @wbp.nonvisual location=-41,74
	 */
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lodge lodge = new Lodge();
					LodgeselfGUI11 frame = new LodgeselfGUI11(lodge);
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
	public LodgeselfGUI11(Lodge lodge) {
		setTitle("\u4FEE\u6539\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 617);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

		
		JLabel id = new JLabel("\u8D26\u53F7\uFF1A");
		id.setBounds(73, 65, 72, 18);
		contentPane.add(id);
		
		JLabel password1 = new JLabel("\u5BC6\u7801\uFF1A");
		password1.setBounds(73, 125, 72, 18);
		contentPane.add(password1);
		
		psdtxt1 = new JTextField(lodge.getLpassword());
		psdtxt1.setBounds(150, 122, 182, 24);
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
		
		psdtxt2 = new JTextField(lodge.getLpassword());
		psdtxt2.setBounds(150, 182, 182, 24);
		contentPane.add(psdtxt2);
		psdtxt2.setColumns(10);
		
		nametxt = new JTextField(lodge.getLname());
		nametxt.setBounds(150, 242, 182, 24);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		String ss=String.valueOf(lodge.getLage());
		agetxt = new JTextField(ss);
		agetxt.setColumns(10);
		agetxt.setBounds(150, 302, 182, 24);
		contentPane.add(agetxt);
		
		JLabel idno = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		idno.setBounds(73, 425, 82, 18);
		contentPane.add(idno);
		
		idnotxt = new JTextField(lodge.getLidno());
		idnotxt.setColumns(10);
		idnotxt.setBounds(150, 422, 182, 24);
		contentPane.add(idnotxt);
		
		JLabel tel = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		tel.setBounds(73, 485, 82, 18);
		contentPane.add(tel);
		
		teltxt = new JTextField(lodge.getLtel());
		teltxt.setBounds(150, 482, 182, 24);
		contentPane.add(teltxt);
		teltxt.setColumns(10);
		
		
		
		JButton exit = new JButton("\u53D6\u6D88");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LodgeselfGUI1 lodgeSelf = new LodgeselfGUI1(lodge);
				lodgeSelf.setVisible(true);
				dispose();
			}
		});
		exit.setBounds(219, 530, 113, 27);
		contentPane.add(exit);
		
		JComboBox sexbox = new JComboBox();
		sexbox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		sexbox.setBounds(150, 362, 182, 24);
		contentPane.add(sexbox);
		
		ButtonGroup group=new ButtonGroup();
		
		JButton confirm = new JButton("\u786E\u5B9A");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Lodgedao cont = new Lodgedao();
				if(psdtxt1.getText().equals(psdtxt2.getText())) {
					if(psdtxt1.getText().length()>=6&&psdtxt1.getText().length()<=10) {
						if(Integer.parseInt(agetxt.getText())<100 && Integer.parseInt(agetxt.getText())>0) {
							if((teltxt.getText().length()==11) && (teltxt.getText().substring(0, 1).equals("1")) &&(zifu(teltxt.getText())==1)) {
								if((idnotxt.getText().length()==18) && (zifu(teltxt.getText())==1)) {
									try{
										cont.updateall(lodge,nametxt.getText(),sexbox.getSelectedItem().toString(),Integer.parseInt(agetxt.getText()),teltxt.getText(),psdtxt1.getText(),idnotxt.getText());
										LodgeselfGUI1 lodgeSelf = new LodgeselfGUI1(lodge);
										lodgeSelf.setVisible(true);
										JOptionPane.showMessageDialog(null, "修改成功");
										dispose();
									}catch(NumberFormatException e1) {
										JOptionPane.showMessageDialog(null, "请按要求填写各项信息");
									}
								}else {
									JOptionPane.showMessageDialog(null, "身份证号码格式错误");
								}
							}else {
								JOptionPane.showMessageDialog(null, "电话号码格式错误");
							}
						} else {
							JOptionPane.showMessageDialog(null, "年龄设置错误");
						}
					}else {
						JOptionPane.showMessageDialog(null, "密码长度错误");
					}	
				}else {
					JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入");
				}
			}
		});
		confirm.setBounds(73, 530, 113, 27);
		contentPane.add(confirm);	
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4FEE\u6539\u4FE1\u606F");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 13, 444, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(lodge.getLid());
		lblNewLabel_1.setBounds(150, 62, 182, 24);
		contentPane.add(lblNewLabel_1);
	}
	public int zifu(String str){
		for (int i = str.length();--i>=0;){
			if (!Character.isDigit(str.charAt(i))){
				return 0;
			}
		}
			return 1;
	}
}
