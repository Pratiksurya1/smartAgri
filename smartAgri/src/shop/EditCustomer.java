package shop;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class EditCustomer {

	JFrame EditCustomer;
	private JTextField textField;
	
	JLabel lblMobaile=null;
	JButton btnNewButton=null;
	
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	private JLabel lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4;
	private JTextField textField_1, textField_2, textField_3, textField_4;
	private JButton btnNewButton_1,btnNewButton_1_1;
	private String No;
	private String name;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;

	public static void main (String []arg) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCustomer window = new EditCustomer();
					window.EditCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditCustomer() {
		initialize();
	}

	private void initialize() {
		EditCustomer = new JFrame();
		EditCustomer.setBounds(0,0, 1560, 840);
		EditCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		EditCustomer.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search customer using");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(268, 267, 166, 27);
		EditCustomer.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(comboBox.getSelectedItem().equals("mobaile number")) {
				lblMobaile.setVisible(true);
				textField.setVisible(true);
				 btnNewButton.setVisible(true);
			}
			else if(comboBox.getSelectedItem().equals("customer name")) {
				lblMobaile = new JLabel("Name");
				lblMobaile.setFont(new Font("Tahoma", Font.BOLD, 14));
				lblMobaile.setBounds(511, 118, 85, 27);
				EditCustomer.getContentPane().add(lblMobaile);
				lblMobaile.setVisible(true);
				textField.setVisible(true);
				 btnNewButton.setVisible(true);		
			}			
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "mobaile number", "customer name"}));
		comboBox.setBounds(444, 269, 176, 27);
		EditCustomer.getContentPane().add(comboBox);
		
		 lblMobaile = new JLabel("Mobaile No.");
		lblMobaile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobaile.setBounds(642, 267, 90, 27);
		EditCustomer.getContentPane().add(lblMobaile);
		lblMobaile.setVisible(false);
				
		textField = new JTextField();
		textField.setBounds(742, 269, 183, 27);
		EditCustomer.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Search\r\n");
		btnNewButton.setIcon(new ImageIcon(EditCustomer.class.getResource("/img/search.png")));
		btnNewButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				try {
					
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##pratik","system");
					st=con.createStatement();
					if(comboBox.getSelectedItem().equals("mobaile number")) {
						 No=textField.getText();
					rs=st.executeQuery("SELECT CID,CNAME,MOBILENO,CADD FROM CUSTOMER_INFO where mobileno ="+No);
					rs.next();				
					textField_1.setText(rs.getString(1));
					textField_2.setText(rs.getString(2));
					textField_3.setText(rs.getString(3));
					textField_4.setText(rs.getString(4));
					}else if(comboBox.getSelectedItem().equals("customer name")) {
						name="'"+textField.getText()+"'";
						rs=st.executeQuery("SELECT CID,CNAME,MOBILENO,CADD FROM CUSTOMER_INFO where cname ="+name);
						rs.next();				
						textField_1.setText(rs.getString(1));
						textField_2.setText(rs.getString(2));
						textField_3.setText(rs.getString(3));
						textField_4.setText(rs.getString(4));
						}
					}catch(SQLException se) {
				se.printStackTrace();		}
			}
		}	);
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(949, 267, 114, 29);
		btnNewButton.setVisible(false);
		EditCustomer.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("Customer ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(297, 362, 96, 27);
		EditCustomer.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Customer name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(297, 420, 114, 27);
		EditCustomer.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Mobile No");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(297, 483, 96, 27);
		EditCustomer.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel(" Address");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(297, 538, 96, 27);
		EditCustomer.getContentPane().add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setEditable(false);
		textField_1.setBounds(435, 364, 282, 27);
		EditCustomer.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(435, 422, 282, 27);
		EditCustomer.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(435, 485, 282, 27);
		EditCustomer.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(435, 540, 282, 27);
		EditCustomer.getContentPane().add(textField_4);
		
		btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setIcon(new ImageIcon(EditCustomer.class.getResource("/img/checked.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String name=	textField_2.getText();
			String add=textField_4.getText();
			String mobile=textField_3.getText();
			
			try { st.executeUpdate("update customer_info set cname='"+name+"',cadd='"+add+"',mobileno='"+mobile+"' where mobileno="+No);
			}catch(SQLException se) {
				se.printStackTrace();
			}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(343, 643, 114, 35);
		EditCustomer.getContentPane().add(btnNewButton_1);	
		//btnNewButton_1.setVisible(false);
		
		btnNewButton_1_1 = new JButton("Cancle");
		btnNewButton_1_1.setIcon(new ImageIcon(EditCustomer.class.getResource("/img/x-button.png")));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCustomer.dispose();
		new Home().Home.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(602, 643, 115, 35);
		EditCustomer.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("Update Customer");
		lblNewLabel_5.setForeground(new Color(178, 34, 34));
		lblNewLabel_5.setFont(new Font("Vineta BT", Font.BOLD | Font.ITALIC, 52));
		lblNewLabel_5.setBounds(270, 89, 767, 77);
		EditCustomer.getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(EditCustomer.class.getResource("/img/line.png")));
		lblNewLabel_6.setBounds(-187, 324, 1817, 3);
		EditCustomer.getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(EditCustomer.class.getResource("/img/line.png")));
		lblNewLabel_7.setBounds(-283, 225, 2093, 13);
		EditCustomer.getContentPane().add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(EditCustomer.class.getResource("/img/update customer.png")));
		lblNewLabel_8.setBounds(113, 45, 147, 153);
		EditCustomer.getContentPane().add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(EditCustomer.class.getResource("/img/backgrund.png")));
		lblNewLabel_9.setBounds(0, 0, 2154, 865);
		EditCustomer.getContentPane().add(lblNewLabel_9);
		textField.setVisible(false);
	}
}
