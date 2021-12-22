package shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;

public class Home {

	 JFrame Home;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.Home.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Home() {
		initialize();
	}

	private void initialize() {
		Home = new JFrame();
		Home.setBounds(0,0, 1560, 840);
		Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Home.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add customer");
		btnNewButton.setBackground(new Color(240, 255, 255));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setIcon(new ImageIcon(Home.class.getResource("/img/add (1).png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addCustomer().addCustomer.setVisible(true);
				Home.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(47, 51, 193, 65);
		Home.getContentPane().add(btnNewButton);
		
		JButton btnAddProduct = new JButton("Add product");
		btnAddProduct.setBackground(new Color(240, 255, 255));
		btnAddProduct.setForeground(new Color(178, 34, 34));
		btnAddProduct.setIcon(new ImageIcon(Home.class.getResource("/img/add-to-cart.png")));
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new addProduct().addProduct.setVisible(true);
			Home.dispose();
			}
		});
		btnAddProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddProduct.setBounds(47, 159, 193, 65);
		Home.getContentPane().add(btnAddProduct);
		
		JButton btnEditCustomer = new JButton("Update Customer");
		btnEditCustomer.setBackground(new Color(240, 255, 255));
		btnEditCustomer.setForeground(new Color(178, 34, 34));
		btnEditCustomer.setIcon(new ImageIcon(Home.class.getResource("/img/add (1).png")));
		btnEditCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new  EditCustomer().EditCustomer.setVisible(true);
			Home.dispose();
			}
		});
		btnEditCustomer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnEditCustomer.setBounds(51, 265, 189, 65);
		Home.getContentPane().add(btnEditCustomer);
		
		JButton btnUpdateProduct = new JButton("Update Product");
		btnUpdateProduct.setBackground(new Color(240, 255, 255));
		btnUpdateProduct.setForeground(new Color(178, 34, 34));
		btnUpdateProduct.setIcon(new ImageIcon(Home.class.getResource("/img/captcha (1).png")));
		btnUpdateProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new updateProduct().updateProduct.setVisible(true);
			Home.dispose();
			}
		});
		btnUpdateProduct.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdateProduct.setBounds(51, 366, 189, 65);
		Home.getContentPane().add(btnUpdateProduct);
		
		JButton btnBilling = new JButton("Billing");
		btnBilling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Billling().Billing.setVisible(true);
			Home.dispose();
			}
		});
		btnBilling.setBackground(new Color(240, 255, 255));
		btnBilling.setIcon(new ImageIcon(Home.class.getResource("/img/payment (1).png")));
		btnBilling.setForeground(new Color(178, 34, 34));
		btnBilling.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBilling.setBounds(51, 469, 189, 65);
		Home.getContentPane().add(btnBilling);
		
		JLabel lblNewLabel = new JLabel("Smart Agri");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(135, 206, 235));
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setFont(new Font("Bernard MT Condensed", Font.BOLD, 99));
		lblNewLabel.setIcon(null);
		lblNewLabel.setBounds(617, 62, 450, 136);
		Home.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBackground(new Color(0, 0, 255));
		lblNewLabel_4.setIcon(new ImageIcon(Home.class.getResource("/img/max-O_TVsaeZNlE-unsplash.jpg")));
		lblNewLabel_4.setBounds(0, 0, 2171, 927);
		Home.getContentPane().add(lblNewLabel_4);
	}
}
