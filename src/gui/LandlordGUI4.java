package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.HouseDaoImple;
import model.House;
import model.Landlord;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LandlordGUI4 extends JFrame {

	private JPanel contentPane;
	private JTextField delete11;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LandlordGUI4 frame = new LandlordGUI4();
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
	public LandlordGUI4() {
		setTitle("\u5220\u9664\u623F\u5C4B");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel lblNewLabel = new JLabel("\u623F\u5C4B\u7F16\u53F7");
		lblNewLabel.setBounds(14, 13, 72, 18);
		contentPane.add(lblNewLabel);
		
		delete11 = new JTextField();
		delete11.setBounds(149, 10, 86, 24);
		contentPane.add(delete11);
		delete11.setColumns(10);
		
		btnNewButton = new JButton("\u786E\u5B9A\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HouseDaoImple ss=new HouseDaoImple();
				ss.delete(delete11.getText());
				 JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦");
					dispose();
			}
		});
		btnNewButton.setBounds(117, 118, 113, 27);
		contentPane.add(btnNewButton);
		//Landlord ll=new Landlord();
		
		//ss.find(hs,delete.getText());
		
	}
}
