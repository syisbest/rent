package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Landlorddao;
import model.Landlord;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LandlordGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
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
	public LandlordGUI(Landlord landlord) {
		Landlorddao lld = new Landlorddao();
		lld.find(landlord, landlord.getLLid());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u83DC\u5355");
		mnNewMenu.setForeground(Color.RED);
		menuBar.add(mnNewMenu);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem = new JRadioButtonMenuItem("\u4E2A\u4EBA\u4FE1\u606F");
		rdbtnmntmNewRadioItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LandlordGUI1 landlordgui1 = new LandlordGUI1(landlord);
				landlordgui1.setVisible(true);
			}
		});
		rdbtnmntmNewRadioItem.setForeground(Color.GREEN);
		mnNewMenu.add(rdbtnmntmNewRadioItem);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_1 = new JRadioButtonMenuItem("\u623F\u5C4B\u4FE1\u606F\u53D1\u5E03");
		rdbtnmntmNewRadioItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandlordGUI2 lgui2 = new LandlordGUI2(landlord);
				lgui2.setVisible(true);
			}
		});
		mnNewMenu.add(rdbtnmntmNewRadioItem_1);
		
		JRadioButtonMenuItem rdbtnmntmNewRadioItem_2 = new JRadioButtonMenuItem("\u67E5\u8BE2\u5220\u9664");
		rdbtnmntmNewRadioItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandlordGUI4 pp=new LandlordGUI4();
				pp.setVisible(true);
			}
		});
		mnNewMenu.add(rdbtnmntmNewRadioItem_2);
		
		JRadioButtonMenuItem radioButtonMenuItem = new JRadioButtonMenuItem("\u5904\u7406\u5F85\u5904\u7406\u5408\u540C");
		radioButtonMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LandlordContractView landlordContractView = new LandlordContractView(landlord);
				landlordContractView.setVisible(true);
			}
		});
		mnNewMenu.add(radioButtonMenuItem);
		
		JRadioButtonMenuItem radioButtonMenuItem_1 = new JRadioButtonMenuItem("\u67E5\u770B\u5408\u540C");
		radioButtonMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LandlordConViewOnly landlordConViewOnly = new LandlordConViewOnly(landlord);
				landlordConViewOnly.setVisible(true);
			}
		});
		mnNewMenu.add(radioButtonMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
