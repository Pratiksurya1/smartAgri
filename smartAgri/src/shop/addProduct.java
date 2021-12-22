package shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class addProduct {

	JFrame addProduct;
	private JTextField pname;
	private JTextField cumpany;
	private JTextField code;
	private JTextField prize;
	JComboBox type_1=null;
	Connection con=null;
	PreparedStatement ps=null;
	private static final String SET_PRODUCT_DETAILS="INSERT INTO PRODUCT_INFO VALUES (?,?,?,?,?)";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addProduct window = new addProduct();
					window.addProduct.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addProduct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		addProduct = new JFrame();
		addProduct.setBounds(0,0, 1560, 840);
		addProduct.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addProduct.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add product");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Vineta BT", Font.ITALIC, 52));
		lblNewLabel.setBounds(339, 65, 518, 116);
		addProduct.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(207, 301, 102, 32);
		addProduct.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Cumpany");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(207, 363, 81, 32);
		addProduct.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Code");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(219, 425, 69, 32);
		addProduct.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Prize");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(219, 483, 69, 32);
		addProduct.getContentPane().add(lblNewLabel_1_3);
		
		pname = new JTextField();
		pname.setBounds(329, 300, 363, 33);
		addProduct.getContentPane().add(pname);
		pname.setColumns(10);
		
		cumpany = new JTextField();
		cumpany.setColumns(10);
		cumpany.setBounds(329, 362, 363, 33);
		addProduct.getContentPane().add(cumpany);
		
		code = new JTextField();
		code.setColumns(10);
		code.setBounds(329, 424, 363, 33);
		addProduct.getContentPane().add(code);
		
		prize = new JTextField();
		prize.setColumns(10);
		prize.setBounds(329, 485, 363, 33);
		addProduct.getContentPane().add(prize);
		
		type_1 = new JComboBox();
		type_1.setBackground(Color.WHITE);
		type_1.setModel(new DefaultComboBoxModel(new String[] {"", "Fertilizer", "Insecticide", "Seed", "Herbicide", "Pesticides", "Fungicide"}));
		type_1.setBounds(735, 306, 179, 27);
		
		addProduct.getContentPane().add(type_1);
		
		JButton btnNewButton = new JButton("Save\r\n");
		btnNewButton.setIcon(new ImageIcon(addProduct.class.getResource("/img/save.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##pratik","system");
				ps=con.prepareStatement(SET_PRODUCT_DETAILS);
				ps.setString(1,pname.getText());
				ps.setString(2,prize.getText());
				ps.setString(3,cumpany.getText());
				ps.setString(4,code.getText());
				String type=(String)type_1.getSelectedItem();
				if(type.equals("...")) {System.out.println("not enter");
				ps.setString(5, "");
				}
				else{ps.setString(5, type);}
		
				ps.executeQuery();
				pname.setText("");
				prize.setText("");
				cumpany.setText("");
				code.setText("");
				
			}catch(SQLException se) {
				se.printStackTrace();
			}catch(Exception se) {
				se.printStackTrace();
			}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(231, 579, 144, 53);
		addProduct.getContentPane().add(btnNewButton);
		
		JButton btnResate = new JButton("Resate");
		btnResate.setIcon(new ImageIcon(addProduct.class.getResource("/img/resate.png")));
		btnResate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			pname.setText("");
			prize.setText("");
			cumpany.setText("");
			code.setText("");
			
			}
		});
		btnResate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnResate.setBounds(402, 579, 144, 53);
		addProduct.getContentPane().add(btnResate);
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.setIcon(new ImageIcon(addProduct.class.getResource("/img/cancel (1).png")));
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addProduct.dispose();
			new Home().Home.setVisible(true);
			}
		});
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancle.setBounds(578, 579, 144, 53);
		addProduct.getContentPane().add(btnCancle);
		
		JLabel lblNewLabel_1_4 = new JLabel("Type");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(695, 301, 40, 32);
		addProduct.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(addProduct.class.getResource("/img/product.png")));
		lblNewLabel_3.setBounds(172, 51, 157, 141);
		addProduct.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(addProduct.class.getResource("/img/line.png")));
		lblNewLabel_4.setBounds(-489, 218, 2226, 13);
		addProduct.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(addProduct.class.getResource("/img/backgrund.png")));
		lblNewLabel_2.setBounds(0, -14, 2132, 845);
		addProduct.getContentPane().add(lblNewLabel_2);
		
		
	}
}
