
	package gui;

	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

	import model.Landlord;

	import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
	import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

	public class LandlordGUI1 extends JFrame {

		private JPanel contentPane;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
//						LandlordGUI1 frame = new LandlordGUI1(landlord);
//						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public LandlordGUI1(Landlord landlord) {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(300, 300, 518, 535);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			setLocationRelativeTo(null);
			setResizable(false);
			
			
			JLabel label = new JLabel("\u623F\u4E3B\u4FE1\u606F");
			label.setBounds(186, 13, 139, 18);
			contentPane.add(label);
			
			JLabel lblId_1 = new JLabel("\u8D26\u53F7\uFF1A");
			lblId_1.setBounds(0, 50, 72, 18);
			contentPane.add(lblId_1);
			
			JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
			lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
			lblNewLabel.setBounds(0, 100, 72, 18);
			contentPane.add(lblNewLabel);
			
			JLabel label_2 = new JLabel("\u6027\u522B\uFF1A");
			label_2.setBounds(0, 150, 72, 18);
			contentPane.add(label_2);
			
			JLabel label_3 = new JLabel("\u5E74\u9F84\uFF1A");
			label_3.setBounds(0, 200, 72, 18);
			contentPane.add(label_3);
			
			JLabel lblId = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
			lblId.setBounds(0, 250, 91, 18);
			contentPane.add(lblId);
			
			JLabel label_4 = new JLabel("\u5BC6\u7801\uFF1A");
			label_4.setBounds(0, 300, 72, 18);
			contentPane.add(label_4);
			
			JLabel label_1 = new JLabel("\u624B\u673A\u53F7\uFF1A");
			label_1.setBounds(0, 350, 72, 18);
			contentPane.add(label_1);
			
			JLabel lblNewLabel_1 = new JLabel(landlord.getLLid());
			lblNewLabel_1.setBounds(105, 50, 115, 18);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel(landlord.getLLname());
			lblNewLabel_2.setBounds(105, 100, 115, 18);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel(landlord.getLLsex());
			lblNewLabel_3.setBounds(105, 150, 115, 18);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel(((Integer)landlord.getLLage()).toString());
			lblNewLabel_4.setBounds(105, 200, 115, 18);
			contentPane.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel(landlord.getLLidno());
			lblNewLabel_5.setBounds(105, 250, 242, 18);
			contentPane.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel(landlord.getPassword());
			lblNewLabel_6.setBounds(105, 300, 115, 18);
			contentPane.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel(landlord.getLLtel());
			lblNewLabel_7.setBounds(105, 350, 115, 18);
			contentPane.add(lblNewLabel_7);
			
			JButton button = new JButton("\u4FEE\u6539");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LandlordGUI3 ll=new LandlordGUI3(landlord);
					ll.setVisible(true);
					dispose();
				}
			});
			button.setBounds(186, 405, 113, 27);
			contentPane.add(button);
			
			
			
			
			
			
		}
	}


