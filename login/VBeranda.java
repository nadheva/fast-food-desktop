package id.ac.uns.vokasi.d3ti.login;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import id.ac.uns.vokasi.d3ti.gui.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VBeranda extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VBeranda frame = new VBeranda();
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
	public VBeranda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 272, 2, 2);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_3 = new JLabel("Belum punya akun?");
		lblNewLabel_3.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(50, 272, 107, 23);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Lanjut");
		btnNewButton_1.setBounds(165, 97, 130, 71);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TampilanDatabaseUAS ce=new TampilanDatabaseUAS();
				ce.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Beranda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(165, 97, 130, 71);
		contentPane.add(lblNewLabel);
	}

}
