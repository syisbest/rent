package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bo.ContractBoImpl;
import model.Contract;
import model.Landlord;

public class LandlordConViewOnly extends JFrame {

	private JPanel contentPane;
	private JTable contractTable;
	
	private ArrayList<Contract> cs = new ArrayList<Contract>();
	private ContractBoImpl cont = new ContractBoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Landlord ll = new Landlord();
//					ll.setLLid("1");
//					LandlordConViewOnly frame = new LandlordConViewOnly(ll);
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
	public LandlordConViewOnly(Landlord ll) {
		setTitle("\u5408\u540C\u67E5\u770B\uFF08\u623F\u4E1C\u754C\u9762\uFF09");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 667, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 631, 241);
		contentPane.add(scrollPane);
		
		contractTable = new JTable();
		contractTable.setForeground(Color.BLACK);
//		读取数据
		cont.findLandlordCon(cs, ll);
//		设置长度及初始化数据
		Object[][] dt = new Object[cs.size()][7];
		for(int i = 0; i<cs.size(); i++) {
			dt[i][0] = cs.get(i).getCno();
			dt[i][1] = cs.get(i).getLodge().getLid();
			dt[i][2] = cs.get(i).getHouse().getHid();
			dt[i][3] = cs.get(i).getRent();
			dt[i][4] = cs.get(i).getDate();
			dt[i][5] = cs.get(i).getTime();
			if(cs.get(i).getStatus().equalsIgnoreCase("0"))
				dt[i][6] = "未处理";
			else if(cs.get(i).getStatus().equalsIgnoreCase("1"))
				dt[i][6] = "同意";
			else if(cs.get(i).getStatus().equalsIgnoreCase("-1"))
				dt[i][6] = "不同意";
			else if(cs.get(i).getStatus().equalsIgnoreCase("-2"))
				dt[i][6] = "到期";
		}
		String[] title = {
				"\u5408\u540C\u7F16\u53F7", "\u79DF\u5BA2\u8D26\u53F7", "\u623F\u5C4B\u7F16\u53F7", "\u6210\u4EA4\u6708\u79DF", "\u6210\u4EA4\u65E5\u671F", "\u79DF\u8D41\u65F6\u957F", "\u5408\u540C\u72B6\u6001"
				};
		contractTable.setModel(new DefaultTableModel(dt,title) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(contractTable);
		
	}

}
