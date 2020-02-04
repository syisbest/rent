package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.Lodge;

import java.awt.Component;
import java.awt.Window.Type;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LodgeselfGUI1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lodge lodge = new Lodge();
					LodgeselfGUI1 frame = new LodgeselfGUI1(lodge);
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
	public LodgeselfGUI1(Lodge lodge) {
		setFont(null);
		setTitle("\u4E2A\u4EBA\u4E2D\u5FC3");
		setBounds(100, 100, 460, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);

		
		String s=lodge.getLname(); 
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel(s+"\u7684\u4E2A\u4EBA\u4FE1\u606F");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setToolTipText("");
		lblNewLabel.setBounds(0, 16, 442, 42);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 25));
		label.setBounds(50, 100, 97, 35);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u6027\u522B\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 25));
		label_1.setBounds(50, 150, 97, 35);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5E74\u9F84\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 25));
		label_2.setBounds(50, 200, 97, 35);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 25));
		label_3.setBounds(50, 250, 125, 35);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_4.setFont(new Font("宋体", Font.PLAIN, 25));
		label_4.setBounds(50, 300, 125, 35);
		contentPane.add(label_4);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(50, 350, 97, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(50, 400, 97, 35);
		contentPane.add(lblNewLabel_2);
		//
		JLabel lblNewLabel_4 = new JLabel(lodge.getLname());
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(174, 100, 250, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(lodge.getLsex());
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(174, 150, 250, 35);
		contentPane.add(lblNewLabel_5);
		
		String ss=String.valueOf(lodge.getLage());
		JLabel lblNewLabel_6 = new JLabel(ss);
		lblNewLabel_6.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(174, 200, 250, 35);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_3 = new JLabel(lodge.getLtel());
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(174, 250, 250, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel(lodge.getLidno());
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(174, 300, 250, 35);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(lodge.getLid());
		lblNewLabel_8.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(174, 350, 250, 35);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(lodge.getLpassword());
		lblNewLabel_9.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_9.setBounds(174, 400, 250, 35);
		contentPane.add(lblNewLabel_9);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LodgeselfGUI11 lodgeSelf = new LodgeselfGUI11(lodge);
				lodgeSelf.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(150, 470, 139, 40);
		contentPane.add(btnNewButton_1);
		
		
	}
}
