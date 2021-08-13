package id.ac.uns.vokasi.d3ti.gui;

import java.awt.BorderLayout;
import id.ac.uns.vokasi.d3ti.jdbc.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class inputMkn  extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ButtonGroup bp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inputMkn  frame = new inputMkn ();
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
	public inputMkn () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(48, 82, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Jenis Menu");
		lblNewLabel_1.setBounds(48, 122, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nama");
		lblNewLabel_2.setBounds(48, 162, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Harga");
		lblNewLabel_3.setBounds(48, 201, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Jenis Makanan");
		lblNewLabel_4.setBounds(48, 242, 96, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Keterangan");
		lblNewLabel_5.setBounds(48, 292, 76, 14);
		contentPane.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(152, 79, 501, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 119, 501, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(152, 159, 501, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(152, 198, 501, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(152, 292, 501, 60);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Ringan");
		rdbtnNewRadioButton.setBounds(152, 238, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Berat");
		rdbtnNewRadioButton_1.setBounds(152, 264, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		
		bp=new ButtonGroup();
		bp.add(rdbtnNewRadioButton);
		bp.add(rdbtnNewRadioButton_1);
		
		
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ID=textField.getText();
				String jenis_menu=textField_1.getText();
				String nama=textField_2.getText();
				String harga=textField_3.getText();
				String jenis_makanan="";
				if(rdbtnNewRadioButton.isSelected()) {
					jenis_makanan="Ringan";
				}else if(rdbtnNewRadioButton_1.isSelected()) {
					jenis_makanan="Berat";
				}
				String keterangan=textField_4.getText();
				MakananData makananData=new MakananData();
				makananData.insertMakanan(ID, jenis_menu, nama, harga, jenis_makanan, keterangan);
				System.out.println("Input Data Berhasil");
				TampilanDatabaseUAS ce=new TampilanDatabaseUAS();
				ce.setVisible(true);
			}
		});
		btnNewButton.setBounds(564, 427, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("Tambah Daftar Menu");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(177, 31, 364, 14);
		contentPane.add(lblNewLabel_6);
	}
}
