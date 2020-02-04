package gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.LoginDaoImpl;
import model.Admin;
import model.Landlord;
import model.Lodge;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Container;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField idtxt;
	private JPasswordField psdtxt;
	private Admin administrator = new Admin();
	LoginDaoImpl loginDao;
	String choose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setForeground(Color.BLUE);
		setTitle("\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setResizable(false);
		contentPane.setOpaque(false);
		setBg();
		
		JLabel id = new JLabel("\u8D26\u53F7\uFF1A");
		id.setBounds(73, 65, 72, 18);
		contentPane.add(id);
		
		JLabel password = new JLabel("\u5BC6\u7801\uFF1A");
		password.setBounds(73, 125, 72, 18);
		contentPane.add(password);
		
		idtxt = new JTextField();
		idtxt.setBounds(150, 62, 182, 24);
		contentPane.add(idtxt);
		idtxt.setColumns(10);
		
		psdtxt = new JPasswordField();
		psdtxt.setBounds(150, 122, 182, 24);
		contentPane.add(psdtxt);
		
		JRadioButton admin = new JRadioButton("\u7BA1\u7406\u5458");
		admin.setSelected(true);
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose = "admin";
			}
		});
		admin.setBounds(73, 163, 87, 27);
		contentPane.add(admin);
		
		JRadioButton lodge = new JRadioButton("\u79DF\u5BA2");
		lodge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose="lodge";
			}
		});
		lodge.setBounds(160, 163, 86, 27);
		contentPane.add(lodge);
		
		JRadioButton landlord = new JRadioButton("\u623F\u4E1C");
		landlord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose="landlord";
			}
		});
		landlord.setBounds(245, 163, 87, 27);
		contentPane.add(landlord);
		
		ButtonGroup group=new ButtonGroup();
		group.add(admin);
		group.add(lodge);
		group.add(landlord);
		
		JButton login = new JButton("\u767B\u5F55");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choose=="admin") {
					String id = idtxt.getText();
					String password = psdtxt.getText();
					Admin admin = new Admin();
					admin.setId(id);
					admin.setPassword(password);
					loginDao = new LoginDaoImpl();
					if(loginDao.login(admin)) {
						JOptionPane.showMessageDialog(null, "µ«¬º≥…π¶");
						AdminGUI admingui = new AdminGUI();
						admingui.setVisible(true);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				}
				if(choose=="lodge") {
					String id = idtxt.getText();
					String password = psdtxt.getText();
					Lodge lodge = new Lodge();
					lodge.setLid(id);
					lodge.setLpassword(password);
					loginDao = new LoginDaoImpl();
					
					if(loginDao.login(lodge)) {
						JOptionPane.showMessageDialog(null, "µ«¬º≥…π¶");
						LodgeselfGUI lodgeSelf = new LodgeselfGUI(lodge);
						lodgeSelf.setVisible(true);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				}
				if(choose=="landlord") {
					String id = idtxt.getText();
					String password = psdtxt.getText();
					Landlord landlord = new Landlord();
					landlord.setLLid(id);
					landlord.setPassword(password);
					loginDao = new LoginDaoImpl();
					
					if(loginDao.login(landlord)) {
						JOptionPane.showMessageDialog(null, "µ«¬Ω≥…π¶");
						LandlordGUI landlordgui = new LandlordGUI(landlord);
						landlordgui.setVisible(true);
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "’À∫≈ªÚ√‹¬Î¥ÌŒÛ");
				}
			}
		});
		login.setBounds(73, 213, 113, 27);
		contentPane.add(login);
		
		JButton exit = new JButton("\u53D6\u6D88");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		exit.setBounds(219, 213, 113, 27);
		contentPane.add(exit);
		
		JButton register = new JButton("\u6CE8\u518C");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Register register = new Register();
				register.setVisible(true);
			}
		});
		register.setBounds(73, 251, 113, 27);
		contentPane.add(register);
		
		JButton forget = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		forget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Forget forget = new Forget();
				forget.setVisible(true);
			}
		});
		forget.setBounds(219, 251, 113, 27);
		contentPane.add(forget);
		
		
		
		
	}
	public void setBg(){ 
		((JPanel)this.getContentPane()).setOpaque(false);     
		ImageIcon img = new ImageIcon("pic/login.jpg");     
		JLabel background = new JLabel(img);    
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());   
	}
}
