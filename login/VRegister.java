package id.ac.uns.vokasi.d3ti.login;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import id.ac.uns.vokasi.d3ti.login.logindata;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class VRegister extends JFrame {

	private JPanel contentPane;
	private JTextField in_nama;
	private JTextField in_email;
	private JTextField in_ttl;
	private ButtonGroup bp;
	private JPasswordField in_password;
	private JTextField in_nohp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VRegister frame = new VRegister();
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
	public VRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 30));
		lblNewLabel.setBounds(200, 10, 116, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nama");
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_1.setBounds(50, 63, 81, 24);
		contentPane.add(lblNewLabel_1);
		
		in_nama = new JTextField();
		in_nama.setFont(new Font("Tahoma", Font.PLAIN, 15));
		in_nama.setBounds(172, 64, 212, 21);
		contentPane.add(in_nama);
		in_nama.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_2.setBounds(50, 95, 64, 35);
		contentPane.add(lblNewLabel_2);
		
		in_email = new JTextField();
		in_email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		in_email.setBounds(172, 101, 212, 21);
		contentPane.add(in_email);
		in_email.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_3.setBounds(50, 126, 81, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Jenis Kelamin");
		lblNewLabel_4.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_4.setBounds(50, 167, 117, 29);
		contentPane.add(lblNewLabel_4);
		
		in_ttl = new JTextField();
		in_ttl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		in_ttl.setBounds(172, 207, 212, 21);
		contentPane.add(in_ttl);
		in_ttl.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("TTL");
		lblNewLabel_5.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_5.setBounds(50, 206, 81, 24);
		contentPane.add(lblNewLabel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 126, 2, 2);
		contentPane.add(scrollPane);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Laki - Laki");
		rdbtnNewRadioButton.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBounds(172, 170, 99, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Perempuan");
		rdbtnNewRadioButton_1.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(285, 170, 99, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		bp=new ButtonGroup();
		bp.add(rdbtnNewRadioButton);
		bp.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(200, 287, 113, 41);
		contentPane.add(btnNewButton);
		
		in_password = new JPasswordField();
		in_password.setBounds(172, 132, 212, 22);
		contentPane.add(in_password);
		
		JLabel lblNewLabel_6 = new JLabel("No HP");
		lblNewLabel_6.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblNewLabel_6.setBounds(50, 240, 42, 13);
		contentPane.add(lblNewLabel_6);
		
		in_nohp = new JTextField();
		in_nohp.setBounds(172, 238, 212, 19);
		contentPane.add(in_nohp);
		in_nohp.setColumns(10);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nama = in_nama.getText();
				String email = in_email.getText();
				char[] password = in_password.getPassword();
				String pass = new String(password);
				String nohp = in_nohp.getText();
				String ttl = in_ttl.getText();
				String jk="";
				if(rdbtnNewRadioButton.isSelected()) {
					jk="Laki - Laki";
				}else if(rdbtnNewRadioButton_1.isSelected()) {
					jk="Perempuan";
				}
				logindata data = new logindata();
				data.insertData(email, pass, nama, ttl, nohp, jk);
//				System.out.println("Data berhasil diinput");
				new suksesRegister().setVisible(true);
				System.out.println("nama :"+nama);
				System.out.println("email :"+email);
				System.out.println("password :"+pass);
				System.out.println("noHP :"+nohp);
				System.out.println("ttl :"+ttl);
				System.out.println("jk :"+jk);
			}
		});
	}
}
