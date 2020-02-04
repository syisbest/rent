package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.ForgetDaoImpl;
import model.Landlord;
import model.Lodge;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Forget extends JFrame {

	private JPanel contentPane;
	private JTextField idtxt;
	private JButton inquire;
	private JButton exit;
	private JLabel tel;
	private JTextField teltxt;
	private JRadioButton landlordbtn;
	private JRadioButton lodgebtn;
	private String choose=null;
	private ForgetDaoImpl forgetDao;
	private Lodge lodge;
	private Landlord landlord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Forget frame = new Forget();
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
	public Forget() {
		setTitle("\u5FD8\u8BB0\u5BC6\u7801");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		setResizable(false);
		setBg();
		
		JLabel id = new JLabel("\u8D26\u53F7\uFF1A");
		id.setBounds(73, 65, 72, 18);
		contentPane.add(id);
		
		idtxt = new JTextField();
		idtxt.setBounds(150, 62, 182, 24);
		contentPane.add(idtxt);
		idtxt.setColumns(10);
		
		inquire = new JButton("\u67E5\u8BE2");
		inquire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choose=="lodge") {
					forgetDao = new ForgetDaoImpl();
					lodge = new Lodge();
					lodge.setLid(idtxt.getText());
					lodge.setLtel(teltxt.getText());
					try {
						if(forgetDao.getPsd(lodge)!=null) {
							JOptionPane.showMessageDialog(null, "您的密码是："+forgetDao.getPsd(lodge));
						}else
							JOptionPane.showMessageDialog(null, "用户名或联系电话错误");
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				if(choose=="landlord") {
					forgetDao = new ForgetDaoImpl();
					landlord = new Landlord();
					landlord.setLLid(idtxt.getText());
					landlord.setLLtel(teltxt.getText());
					try {
						if(forgetDao.getPsd(landlord)!=null) {
							JOptionPane.showMessageDialog(null, "您的密码是："+forgetDao.getPsd(landlord));
						}else
							JOptionPane.showMessageDialog(null, "用户名或联系电话错误");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(choose==null) {
					JOptionPane.showMessageDialog(null, "请选择用户类型");
				}
			}
		});
		inquire.setBounds(73, 176, 113, 27);
		contentPane.add(inquire);
		
		exit = new JButton("\u53D6\u6D88");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exit.setBounds(219, 176, 113, 27);
		contentPane.add(exit);
		
		tel = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		tel.setBounds(73, 125, 84, 18);
		contentPane.add(tel);
		
		teltxt = new JTextField();
		teltxt.setColumns(10);
		teltxt.setBounds(150, 122, 182, 24);
		contentPane.add(teltxt);
		
		landlordbtn = new JRadioButton("\u623F\u4E1C");
		landlordbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose = "landlord";
			}
		});
		landlordbtn.setBounds(114, 9, 72, 27);
		contentPane.add(landlordbtn);
		
		lodgebtn = new JRadioButton("\u79DF\u5BA2");
		lodgebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choose = "lodge";
			}
		});
		lodgebtn.setBounds(219, 9, 72, 27);
		contentPane.add(lodgebtn);
		
		ButtonGroup group=new ButtonGroup();
		group.add(lodgebtn);
		group.add(landlordbtn);
	}
	public void setBg(){ 
		((JPanel)this.getContentPane()).setOpaque(false);     
		ImageIcon img = new ImageIcon("pic/foget.jpg");     
		JLabel background = new JLabel(img);    
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());   
	}

}
