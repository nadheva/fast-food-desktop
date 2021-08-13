package id.ac.uns.vokasi.d3ti.login;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import id.ac.uns.vokasi.d3ti.login.logindata;
import id.ac.uns.vokasi.d3ti.login.loginmodel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class VLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static boolean tombol = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VLogin frame = new VLogin();
					
					if(tombol == true) {
						new VBeranda().setVisible(true);
						frame.setVisible(false);
					}else{
						frame.setVisible(true);
					};
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			JLabel lblNewLabel = new JLabel("Login");
			//lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
			lblNewLabel.setBounds(216, 10, 92, 60);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Email");
			//lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 20));
			lblNewLabel_1.setBounds(50, 100, 83, 40);
			contentPane.add(lblNewLabel_1);
			
			textField = new JTextField();
			//textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
			textField.setBounds(216, 107, 200, 30);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Password");
			//lblNewLabel_2.setFont(new Font("Arial Narrow", Font.BOLD, 20));
			lblNewLabel_2.setBounds(50, 160, 83, 29);
			contentPane.add(lblNewLabel_2);
			
			textField_1 = new JTextField();
			textField_1.setBounds(216, 163, 200, 30);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			JButton btnNewButton = new JButton("Login");
			//btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String email = textField.getText();
					String password = textField_1.getText();
					
					logindata data = new logindata();
//					data.getRowData(username);
//					System.out.println(username);
//					System.out.println(password);
					
					ArrayList<loginmodel> datauser=new ArrayList<>();
					datauser=data.getRowData(email);
//					System.out.println(datauser);
//					System.out.println(datauser.size());
					
					if(datauser.size()==0) {
						System.out.println("Akun tidak ada");
					}
					else {
						for(int i=0;i<datauser.size();i++) {
							ArrayList<Object> tempMhs=new ArrayList<>();
							tempMhs.add(datauser.get(i).getEmail());
							tempMhs.add(datauser.get(i).getPass());
							
							System.out.println(datauser.get(i).getEmail());
							System.out.println(datauser.get(i).getPass());
						}
						
						new VBeranda().setVisible(true);
						
						tombol = true ;
						System.out.println(tombol);
						
					}
				}
			});
			btnNewButton.setBounds(216, 222, 107, 33);
			contentPane.add(btnNewButton);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(91, 272, 2, 2);
			contentPane.add(scrollPane);
			
			JLabel lblNewLabel_3 = new JLabel("Belum punya akun?");
			lblNewLabel_3.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
			lblNewLabel_3.setBounds(50, 272, 107, 23);
			contentPane.add(lblNewLabel_3);
			
			JButton btnNewButton_1 = new JButton("Register");
			btnNewButton_1.setBounds(165, 274, 83, 21);
			contentPane.add(btnNewButton_1);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new VRegister().setVisible(true);
				}
			});
				
		
	}
}
