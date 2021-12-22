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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class updateProduct {

	JFrame updateProduct;
	private JTextField textField,textField_1,textField_2,textField_3,textField_4;
	private JComboBox comboBox;
	private Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	private JTextField textField_5;
	private String ppname;
	private String type;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateProduct window = new updateProduct();
					window.updateProduct.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updateProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		updateProduct = new JFrame();
		updateProduct.setBounds(0,0, 1560, 840);
		updateProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		updateProduct.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update product ");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Vineta BT", Font.BOLD | Font.ITALIC, 52));
		lblNewLabel.setBounds(332, 39, 701, 99);
		updateProduct.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(303, 266, 102, 24);
		updateProduct.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prize");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(303, 309, 71, 24);
		updateProduct.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Company");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(303, 362, 90, 24);
		updateProduct.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Code");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(303, 408, 49, 24);
		updateProduct.getContentPane().add(lblNewLabel_1_3);
		
	
		
		JLabel lblNewLabel_1_4 = new JLabel("Type");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(303, 458, 63, 24);
		updateProduct.getContentPane().add(lblNewLabel_1_4);
		
		textField = new JTextField();
		textField.setBounds(412, 266, 226, 24);
		updateProduct.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(412, 312, 226, 24);
		updateProduct.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(412, 365, 226, 24);
		updateProduct.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(412, 411, 226, 24);
		updateProduct.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(412, 193, 226, 25);
		updateProduct.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("Product name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(281, 194, 102, 19);
		updateProduct.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setIcon(new ImageIcon(updateProduct.class.getResource("/img/search.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##pratik","system");
					st=con.createStatement();
					ppname=textField_4.getText();
				rs=	st.executeQuery("select * from product_info where pname='"+textField_4 .getText()+"'");
				rs.next();
				textField.setText(rs.getString(1));
				textField_1.setText(rs.getString(2));
				textField_2.setText(rs.getString(3));
				textField_3.setText(rs.getString(4));
				textField_5.setText(rs.getString(5));
				textField_4.setEditable(false);
				
				}catch(SQLException se) {
					se.printStackTrace();
				}
			}
		});
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Fertilizer", "Insecticide", "Seed", "Herbicide", "Pesticides", "Fungicide"}));
		comboBox.addItem(type);
		comboBox.setBounds(647, 461, 113, 23);
		updateProduct.getContentPane().add(comboBox);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(648, 191, 112, 31);
		updateProduct.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setIcon(new ImageIcon(updateProduct.class.getResource("/img/checked.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pname=textField.getText();
				String prize=textField_1.getText();
				String company=textField_2.getText();
				String  code=textField_3.getText();
				String type=(String)comboBox.getSelectedItem();
				int flag=0;
			try {st.executeQuery("update product_info set pname='"+pname+"', prize="+prize+",company='"+company+"', code='"+code+"', type='"+type+"'where pname='"+ppname+"'" );
				flag =1;
			}catch(SQLException se) {
				se.printStackTrace();
			}
			if (flag!=0) {
				JOptionPane.showMessageDialog(btnNewButton_1, "Record in updated.");
			}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(332, 557, 113, 31);
		updateProduct.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Cancel");
		btnNewButton_1_1.setIcon(new ImageIcon(updateProduct.class.getResource("/img/x-button.png")));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateProduct.dispose();
			new Home().Home.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(558, 557, 113, 31);
		updateProduct.getContentPane().add(btnNewButton_1_1);
		
		textField_5 = new JTextField();
		textField_5.setBackground(Color.WHITE);
		textField_5.setColumns(10);
		textField_5.setBounds(412, 460, 226, 24);
		updateProduct.getContentPane().add(textField_5);
		textField_5.setEditable(false);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(updateProduct.class.getResource("/img/line.png")));
		lblNewLabel_4.setBounds(-563, 239, 2143, 13);
		updateProduct.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon(updateProduct.class.getResource("/img/line.png")));
		lblNewLabel_4_1.setBounds(-518, 148, 2143, 13);
		updateProduct.getContentPane().add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setForeground(new Color(139, 69, 19));
		lblNewLabel_3.setIcon(new ImageIcon(updateProduct.class.getResource("/img/captcha.png")));
		lblNewLabel_3.setBounds(182, 21, 128, 128);
		updateProduct.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(updateProduct.class.getResource("/img/backgrund.png")));
		lblNewLabel_5.setBounds(0, 0, 2127, 926);
		updateProduct.getContentPane().add(lblNewLabel_5);
	}
}
