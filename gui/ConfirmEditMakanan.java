package id.ac.uns.vokasi.d3ti.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import id.ac.uns.vokasi.d3ti.jdbc.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfirmEditMakanan extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmEditMakanan frame = new ConfirmEditMakanan();
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
	public ConfirmEditMakanan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID Makanan");
		lblNewLabel.setBounds(55, 104, 301, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(176, 101, 141, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Confirm Edit");
		lblNewLabel_1.setBounds(176, 11, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID=textField.getText();
				MakananData md=new MakananData();
				String id=md.getRowIDData(ID).get(0).getID();
				String jm=md.getRowIDData(ID).get(0).getJenis_menu();
				String jema=md.getRowIDData(ID).get(0).getJenis_makanan();
				String jeneng=md.getRowIDData(ID).get(0).getNama();
				String rego=md.getRowIDData(ID).get(0).getHarga();
				String ket=md.getRowIDData(ID).get(0).getKeterangan();
				//System.out.println(id);
				editMkn edit=new editMkn();
				edit.getTextID().setText(id);
				edit.getTextJenis_menu().setText(jm);
				edit.getTextNama().setText(jeneng);
				edit.getTextJenis_makanan().setText(jema);
				edit.getTextHarga().setText(rego);
				edit.getTextKet().setText(ket);
				edit.setVisible(true);
				contentPane.setVisible(false);
			}
		});
		btnNewButton.setBounds(176, 210, 89, 23);
		contentPane.add(btnNewButton);
	}

}
