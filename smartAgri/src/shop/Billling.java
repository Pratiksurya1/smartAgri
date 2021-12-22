package shop;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Window.Type;

public class Billling {

	 JFrame Billing;
	private JTextField textField;
	private JTextField textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_8,textField_9;
	private JTable table1;
	JLabel lblNewLabel_5_2;
	JLabel lblNewLabel_5;
	
	
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	String time1,date1;
	private JTextField textField_10;
	private static int finalTotal=0;
	private JTextField textField_11;
	private JTextField textField_12;
	int Q;
	int P;
	int total;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Billling window = new Billling();
					window.Billing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Billling() {
		initialize();
		clock();
	}

		private void clock() {
			Thread Clock=new Thread() {
				public void run() {
					try {
					while(true) {
						SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
						Date date=new Date();
						 date1=df.format(date);
						 lblNewLabel_5.setText("Date :-"+date1);
						 
						DateTimeFormatter time= DateTimeFormatter.ofPattern("HH:mm:ss");
						LocalDateTime now= LocalDateTime.now();
						 time1=time.format(now);
						 lblNewLabel_5_2.setText("Time :-"+time1);
						 sleep(1000);
					}
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			Clock.start();
		}
	
	 // Initialize the contents of the frame.
	 
	private void initialize() {
		Billing = new JFrame();
		Billing.setBounds(0,0, 1560, 840);
		Billing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Billing.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Billing System");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Vineta BT", Font.BOLD | Font.ITALIC, 52));
		lblNewLabel.setBounds(365, 31, 644, 98);
		Billing.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(168, 256, 45, 21);
		Billing.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String cname=textField.getText();
			try {
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##pratik","system");
				st=con.createStatement();
				rs=st.executeQuery("select cname,mobileno,cadd from customer_info where cname like '"+cname+"%'");
				if(rs.next()) {
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));					
				}else {
					textField.setText("");
					textField_1.setText("");
					textField_2.setText("");	
				}
			}catch(SQLException se) {
				se.printStackTrace();
			}
			}
		});
		textField.setColumns(10);
		textField.setBounds(223, 251, 181, 26);
		Billing.getContentPane().add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mobile No");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(414, 257, 65, 16);
		Billing.getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number=textField_1.getText();
				try {
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##pratik","system");
					st=con.createStatement();
					rs=st.executeQuery("select cname,mobileno,cadd from customer_info where mobileno like '"+number+"%'");
					if(rs.next()) {
						textField.setText(rs.getString(1));
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));					
					}else {
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");	
						JOptionPane.showMessageDialog(textField_1, "This mobile number not available.");
					}
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(481, 251, 181, 26);
		Billing.getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Address");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(672, 257, 65, 16);
		Billing.getContentPane().add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(741, 251, 181, 26);
		Billing.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_2 = new JLabel("Bayer details :-");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(59, 214, 129, 21);
		Billing.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Product details :-");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2_1.setBounds(59, 323, 140, 13);
		Billing.getContentPane().add(lblNewLabel_2_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pname=textField_3.getText();
				try {
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##pratik","system");
					st=con.createStatement();
					rs=st.executeQuery("select * from product_info where pname like '"+pname+"%'");
					if(rs.next()) {
						textField_3.setText(rs.getString(1));
						textField_6.setText(rs.getString(4));
						textField_4.setText(rs.getString(5));	
						textField_10.setText(rs.getString(3));
						textField_5.setText(rs.getString(2));
						textField_9.setText("1");
					}else {
						textField_3.setText("");
						textField_6.setText("");
						textField_4.setText("");
						textField_10.setText("");
						textField_5.setText("");
						textField_9.setText("");
					}
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(220, 346, 181, 26);
		Billing.getContentPane().add(textField_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Product name");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(116, 352, 98, 16);
		Billing.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Type");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3.setBounds(559, 349, 38, 16);
		Billing.getContentPane().add(lblNewLabel_1_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(606, 346, 119, 26);
		Billing.getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Prize");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3_1.setBounds(957, 352, 38, 16);
		Billing.getContentPane().add(lblNewLabel_1_3_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_5.setColumns(10);
		textField_5.setBounds(1002, 346, 85, 26);
		Billing.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_6.setColumns(10);
		textField_6.setBounds(451, 346, 98, 26);
		Billing.getContentPane().add(textField_6);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Code");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(411, 352, 38, 16);
		Billing.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Billling.class.getResource("/img/line.png")));
		lblNewLabel_3.setBounds(-193, 191, 2458, 13);
		Billing.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon(Billling.class.getResource("/img/line.png")));
		lblNewLabel_3_1.setBounds(-565, 298, 2458, 13);
		Billing.getContentPane().add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setIcon(new ImageIcon(Billling.class.getResource("/img/line.png")));
		lblNewLabel_3_1_1.setBounds(-425, 433, 2458, 13);
		Billing.getContentPane().add(lblNewLabel_3_1_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DefaultTableModel dtm=(DefaultTableModel)table1.getModel();
			dtm.addRow(new Object[] {textField_3.getText(),textField_6.getText(),textField_4.getText(),textField_10.getText(),textField_5.getText(),textField_9.getText()	});
			}
		});
		btnNewButton.setIcon(new ImageIcon(Billling.class.getResource("/img/add.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(1139, 392, 85, 30);
		Billing.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1_4 = new JLabel("Total");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_4.setBounds(985, 476, 45, 21);
		Billing.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Paid amount\r\n");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_5.setBounds(989, 529, 85, 21);
		Billing.getContentPane().add(lblNewLabel_1_5);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int paid=Integer.parseInt( textField_8.getText());
			int total=Integer.parseInt(textField_12.getText());
			int remaininglTotal=total-paid;
			String remaining=String.valueOf(remaininglTotal);
			textField_11.setText(remaining);
			}
		});
		textField_8.setColumns(10);
		textField_8.setBounds(1119, 526, 85, 26);
		Billing.getContentPane().add(textField_8);
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.setIcon(new ImageIcon(Billling.class.getResource("/img/printer.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(1082, 650, 111, 47);
		Billing.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Cancel");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Home().Home.setVisible(true);
				Billing.dispose();
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon(Billling.class.getResource("/img/x-button.png")));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_1.setBounds(1351, 650, 106, 47);
		Billing.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(Billling.class.getResource("/img/bill.png")));
		lblNewLabel_4.setBounds(223, 10, 129, 137);
		Billing.getContentPane().add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 456, 833, 290);
		Billing.getContentPane().add(scrollPane);
		
		table1 = new JTable();
		table1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				  "Product", "Code", "Type", "Company", "Prize","Quantitiy"
			}
		));
		scrollPane.setViewportView(table1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Quantity");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3_2.setBounds(1097, 352, 65, 16);
		Billing.getContentPane().add(lblNewLabel_1_3_2);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_9.setColumns(10);
		textField_9.setBounds(1166, 348, 56, 24);
		Billing.getContentPane().add(textField_9);
		
		 lblNewLabel_5 = new JLabel("");
		 lblNewLabel_5.setForeground(new Color(178, 34, 34));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(1168, 167, 162, 13);
		Billing.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_5_2 = new JLabel("");
		lblNewLabel_5_2.setForeground(new Color(178, 34, 34));
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5_2.setBounds(1365, 167, 165, 13);
		Billing.getContentPane().add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Company");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_3_1_1.setBounds(735, 352, 65, 16);
		Billing.getContentPane().add(lblNewLabel_1_3_1_1);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_10.setColumns(10);
		textField_10.setBounds(810, 349, 137, 26);
		Billing.getContentPane().add(textField_10);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Remaining amount");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_5_1.setBounds(985, 578, 129, 21);
		Billing.getContentPane().add(lblNewLabel_1_5_1);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_11.setColumns(10);
		textField_11.setBounds(1119, 575, 85, 26);
		Billing.getContentPane().add(textField_11);
		
		JButton btnNewButton_1_2 = new JButton("Resate");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Billling().Billing.setVisible(true);
			Billing.dispose();
			}
		});
		btnNewButton_1_2.setIcon(new ImageIcon(Billling.class.getResource("/img/reset.png")));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1_2.setBounds(1211, 650, 119, 47);
		Billing.getContentPane().add(btnNewButton_1_2);
		
		textField_12 = new JTextField();
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_12.setColumns(10);
		textField_12.setBounds(1116, 470, 85, 26);
		Billing.getContentPane().add(textField_12);
		
		JButton btnTotal = new JButton("Total");
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<table1.getRowCount(); i++) {
					P=Integer.parseInt(table1.getValueAt(i,4).toString());
					 total=P;
					  finalTotal=finalTotal+total;
				 String finalTotal_1=String.valueOf(finalTotal);
				textField_12.setText(finalTotal_1);
				}
				finalTotal=0;
				total=0;
				}
		});
		btnTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnTotal.setBounds(1218, 471, 85, 26);
		Billing.getContentPane().add(btnTotal);
		
		JButton btnDeleateRow = new JButton("D\r\ne\r\nl\r\ne\r\nt\r\ne \r\nr\r\no\r\nw");
		btnDeleateRow.setIcon(new ImageIcon(Billling.class.getResource("/img/delete.png")));
		btnDeleateRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DefaultTableModel model=(DefaultTableModel)table1.getModel();
			if(table1.getSelectedColumnCount()==1) {
				model.removeRow(table1.getSelectedRow());
			}else {
				JOptionPane.showMessageDialog(btnDeleateRow,"Plese select row.");
			}
			}
		});
		btnDeleateRow.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeleateRow.setBounds(934, 650, 129, 47);
		Billing.getContentPane().add(btnDeleateRow);
		
		JLabel lblNewLabel_5_4 = new JLabel("");
		lblNewLabel_5_4.setIcon(new ImageIcon(Billling.class.getResource("/img/backgrund.png")));
		lblNewLabel_5_4.setBounds(0, 0, 2127, 926);
		Billing.getContentPane().add(lblNewLabel_5_4);
		
	}
}
