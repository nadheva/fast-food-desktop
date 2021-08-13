package id.ac.uns.vokasi.d3ti.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import id.ac.uns.vokasi.d3ti.jdbc.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TampilanDatabaseUAS extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private MakananData makananData;
	private JButton btnNewButton;
	private JButton btnNewButton1;
	private JButton btnNewButton2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TampilanDatabaseUAS frame = new TampilanDatabaseUAS();
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
	public TampilanDatabaseUAS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 787, 375);
		contentPane.add(scrollPane);
		String[] columnName= {"ID","Jenis Menu","Nama","Jenis Makanan","Harga", "Keterangan"};
		DefaultTableModel dtm=new DefaultTableModel();
		dtm.setColumnIdentifiers(columnName);
		
		
		makananData=new MakananData();
		ArrayList<MakananModel> dataMakanan=new ArrayList<>();
		dataMakanan=makananData.getData();
		for(int i=0;i<dataMakanan.size();i++) {
			ArrayList<Object> tempMkn=new ArrayList<>();
			tempMkn.add(dataMakanan.get(i).getID());
			tempMkn.add(dataMakanan.get(i).getJenis_menu());
			tempMkn.add(dataMakanan.get(i).getNama());
			tempMkn.add(dataMakanan.get(i).getJenis_makanan());
			tempMkn.add(dataMakanan.get(i).getHarga());
			tempMkn.add(dataMakanan.get(i).getKeterangan());
			dtm.addRow(tempMkn.toArray());
		}
		
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		btnNewButton2 = new JButton("Input Data");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inputMkn ce=new inputMkn();
				ce.setVisible(true);
			}
		});
		btnNewButton = new JButton("Edit Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfirmEditMakanan ce=new ConfirmEditMakanan();
				ce.setVisible(true);
			}
		});
		
		btnNewButton1 = new JButton("Hapus Data");
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConfirmHapusMakanan ce=new ConfirmHapusMakanan();
				ce.setVisible(true);
			}
		});
		btnNewButton2.setBounds(200, 495, 96, 23);
		contentPane.add(btnNewButton2);
		btnNewButton.setBounds(358, 495, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton1.setBounds(500, 495, 150, 23);
		contentPane.add(btnNewButton1);
		
		
	}
}
