package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Lodge;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import dao.ContractDaoImpl;
import dao.Lodgedao;
import bo.Lodgebo;

import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



@SuppressWarnings("unused")
public class LodgeselfGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lodge lodge = new Lodge();
					LodgeselfGUI frame = new LodgeselfGUI(lodge);
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
	public LodgeselfGUI(Lodge lodge) {
		setBackground(new Color(240, 240, 240));
		setTitle("\u79DF\u5BA2\u7BA1\u7406\u4E2D\u5FC3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u83DC\u5355");
		mnNewMenu.setFont(new Font("ËÎÌו", Font.PLAIN, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4E2A\u4EBA\u4E2D\u5FC3");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LodgeselfGUI1 lodgeSelf = new LodgeselfGUI1(lodge);
				lodgeSelf.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u79DF\u623F\u4E2D\u5FC3");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u79DF\u623F\u67E5\u8BE2");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LodgeContractView1 frame = new LodgeContractView1(lodge);
				frame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u79DF\u623F\u7BA1\u7406");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LodgeContractView2 frame = new LodgeContractView2(lodge);
				frame.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Lodgedao cont = new Lodgedao();
		cont.findself(lodge,lodge.getLid());
		String s=lodge.getLname(); 
		JLabel label = new JLabel("\u6B22\u8FCE\u5149\u4E34,"+s+"!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setToolTipText("");
		label.setLabelFor(this);
		label.setFont(new Font("ËÎÌו", Font.PLAIN, 40));
		contentPane.add(label, BorderLayout.CENTER);
		
	}


}
