package id.ac.uns.vokasi.d3ti.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import id.ac.uns.vokasi.d3ti.jdbc.MakananData;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editMkn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private ButtonGroup bg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editMkn frame = new editMkn();
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
	public editMkn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(78, 101, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jenis Menu");
		lblNewLabel_1.setBounds(78, 142, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nama");
		lblNewLabel_2.setBounds(78, 182, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Harga");
		lblNewLabel_3.setBounds(78, 224, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Jenis Makanan");
		lblNewLabel_4.setBounds(78, 278, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Keterangan");
		lblNewLabel_5.setBounds(78, 309, 86, 14);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(184, 101, 305, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 139, 305, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(184, 182, 305, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		//textField_3.setBounds(184, 221, 305, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(184, 277, 305, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(184, 307, 305, 60);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Ringan");
		rdbtnNewRadioButton.setBounds(181, 225, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Berat");
		rdbtnNewRadioButton_1.setBounds(181, 251, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		bg=new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID=textField.getText();
				String jenis_menu=textField_1.getText();
				String nama=textField_2.getText();
				String harga=textField_3.getText();
				String keterangan=textField_4.getText();
				String jenis_makanan="";
				if(rdbtnNewRadioButton.isSelected()) {
					jenis_makanan="Ringan";
				}else if(rdbtnNewRadioButton_1.isSelected()) {
					jenis_makanan="Berat";
				}
				MakananData makananData=new MakananData();
				makananData.updateMakanan(ID, jenis_menu, nama, jenis_makanan, harga, keterangan);
				System.out.println("Update Data Berhasil");
				contentPane.setVisible(false);
				TampilanDatabaseUAS ce=new TampilanDatabaseUAS();
				ce.setVisible(true);
			}
		});
		btnNewButton.setBounds(270, 376, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
	public JTextField getTextID() {
		return textField;
	}
	public JTextField getTextJenis_menu() {
		return textField_1;
	}
	public JTextField getTextNama() {
		return textField_2;
	}
	public JTextField getTextJenis_makanan() {
		return textField_3;
	}
	public JTextField getTextHarga() {
		return textField_4;
	}
	public JTextField getTextKet() {
		return textField_5;
	}
}
