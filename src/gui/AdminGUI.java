package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class AdminGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					AdminGUI frame = new AdminGUI();
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
	public AdminGUI() {
		setTitle("\u7BA1\u7406\u5458");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setOpaque(false);
		setBg();
		
		JLabel hello = new JLabel("\u4F60\u597D\uFF01\u7BA1\u7406\u5458");
		hello.setForeground(UIManager.getColor("List.dropLineColor"));
		hello.setFont(new Font("ËÎÌו", Font.PLAIN, 31));
		hello.setBackground(Color.BLUE);
		hello.setBounds(114, 13, 203, 61);
		contentPane.add(hello);
		
		JButton user = new JButton("\u7528\u6237\u7BA1\u7406");
		user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminUser adminUser = new AdminUser();
				adminUser.setVisible(true);
			}
		});
		user.setBounds(152, 87, 113, 27);
		contentPane.add(user);
		
		JButton contract = new JButton("\u5408\u540C\u7BA1\u7406");
		contract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdmContractView adminContract = new AdmContractView();
				adminContract.setVisible(true);
			}
		});
		contract.setBounds(152, 154, 113, 27);
		contentPane.add(contract);
		
	}
	public void setBg(){ 
		((JPanel)this.getContentPane()).setOpaque(false);     
		ImageIcon img = new ImageIcon("pic/admin.jpg");     
		JLabel background = new JLabel(img);    
		this.getLayeredPane().add(background, new Integer(Integer.MIN_VALUE)); 
		background.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());   
	}
}
