package shop;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class addCustomer extends JFrame {

	JFrame addCustomer;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	Connection con=null;
	PreparedStatement ps=null;
	private static final String SET_CUSTOMER_DETAILS="insert into customer_info values(?,?,?,?)";
	/**
	 * Launch the application.
	 */
	public  static void main(String []args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addCustomer window = new addCustomer();
					window.addCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addCustomer = new JFrame();
		addCustomer.setBounds(0,0, 1560, 840);
		addCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addCustomer.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Customer");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Vineta BT", Font.BOLD | Font.ITALIC, 52));
		lblNewLabel.setBounds(305, 108, 597, 72);
		addCustomer.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(218, 296, 101, 29);
		addCustomer.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Customer Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(218, 358, 116, 29);
		addCustomer.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mobile");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(218, 423, 101, 29);
		addCustomer.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Customer Address");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(218, 487, 130, 29);
		addCustomer.getContentPane().add(lblNewLabel_1_3);
		
		textField = new JTextField();
		textField.setBounds(359, 294, 361, 37);
		addCustomer.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(359, 356, 361, 37);
		addCustomer.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(359, 421, 361, 37);
		addCustomer.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(358, 485, 361, 37);
		addCustomer.getContentPane().add(textField_3);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setIcon(new ImageIcon(addCustomer.class.getResource("/img/save.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int  flag=0;
			
				try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##pratik","system");
			ps=con.prepareStatement(SET_CUSTOMER_DETAILS);
			ps.setString(1, textField.getText());
			ps.setString(2,textField_1.getText());
			ps.setString(3,textField_2.getText());
			ps.setString(4,textField_3.getText());
			 flag=ps.executeUpdate();
				}catch(SQLException se) {
					se.printStackTrace();
				}
				if(flag!=0) {
					JOptionPane.showMessageDialog(btnNewButton, "Rrecord is save.");
			}else {JOptionPane.showMessageDialog(btnNewButton, "Fill the textboxes.");
				}}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(236, 588, 140, 57);
		addCustomer.getContentPane().add(btnNewButton);
		
		JButton btnRresate = new JButton("Rresate");
		btnRresate.setIcon(new ImageIcon(addCustomer.class.getResource("/img/resate.png")));
		btnRresate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnRresate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRresate.setBounds(406, 588, 148, 57);
		addCustomer.getContentPane().add(btnRresate);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.setIcon(new ImageIcon(addCustomer.class.getResource("/img/cancel (1).png")));
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomer.dispose();
				new Home().Home.setVisible(true);
			}
		});
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancle.setBounds(582, 588, 140, 57);
		addCustomer.getContentPane().add(btnCancle);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(addCustomer.class.getResource("/img/customer.png")));
		lblNewLabel_2.setBounds(155, 67, 140, 151);
		addCustomer.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(addCustomer.class.getResource("/img/line.png")));
		lblNewLabel_3.setBounds(-59, 228, 1599, 13);
		addCustomer.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(addCustomer.class.getResource("/img/backgrund.png")));
		lblNewLabel_4.setBounds(-82, -36, 2171, 927);
		addCustomer.getContentPane().add(lblNewLabel_4);
	}
}
