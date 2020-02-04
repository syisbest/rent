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

public class LandlordGUI2 extends JFrame {

	private JPanel contentPane;
	private JTextField houseID;
	private JTextField address;
	private JTextField size;
	private JTextField type;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Landlord ll = new Landlord();
					ll.setLLid("12");
					LandlordGUI2 frame = new LandlordGUI2(ll);
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
	public LandlordGUI2(Landlord landlord) {
		setTitle("\u623F\u5C4B\u4FE1\u606F\u53D1\u5E03");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JLabel label = new JLabel("\u623F\u5C4B\u7F16\u53F7");
		label.setBounds(33, 72, 72, 18);
		contentPane.add(label);
		
		houseID = new JTextField();
		houseID.setBounds(119, 69, 86, 24);
		contentPane.add(houseID);
		houseID.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5730\u5740");
		lblNewLabel.setBounds(33, 136, 72, 18);
		contentPane.add(lblNewLabel);
		
		address = new JTextField();
		address.setBounds(119, 133, 86, 24);
		contentPane.add(address);
		address.setColumns(10);
		
		JLabel label_2 = new JLabel("\u623F\u5C4B\u5927\u5C0F");
		label_2.setBounds(33, 190, 72, 18);
		contentPane.add(label_2);
		
		size = new JTextField();
		size.setBounds(119, 187, 86, 24);
		contentPane.add(size);
		size.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6237\u578B");
		label_3.setBounds(33, 242, 72, 18);
		contentPane.add(label_3);
		
		type = new JTextField();
		type.setBounds(119, 239, 86, 24);
		contentPane.add(type);
		type.setColumns(10);
		
		JButton button = new JButton("\u53D1\u5E03");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HouseDaoImple hd = new HouseDaoImple();
				House h = new House();
				h.setHid(hd.getMaxHid());
				h.setLLid(landlord);
				h.setAddress(address.getText());
				h.setSize(Integer.parseInt(size.getText()));
				h.setType(type.getText());
				hd.add(h);	
				JOptionPane.showMessageDialog(null, "发布成功");
				dispose();
				}
		});
		button.setBounds(273, 132, 113, 27);
		contentPane.add(button);
	}
}
