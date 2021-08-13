package id.ac.uns.vokasi.d3ti.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class MakananData {
	Connection con;
	Statement st;
	ResultSet rs;
	ArrayList <MakananModel> dataMakanan;
	
	public MakananData() {
		dataMakanan=new ArrayList<MakananModel>();
		try {
			String server="jdbc:mysql://127.0.0.1/makanan_pbo?user=root&password=";
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection(server);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<MakananModel> getData(){
		try {
			st=(Statement) con.createStatement();
			String query="SELECT * FROM daftar_menu";
			rs=(ResultSet) st.executeQuery(query);
			while(rs.next()) {
				MakananModel mm=new MakananModel();
				mm.setID(rs.getString(1));
				mm.setJenis_menu(rs.getString(2));
				mm.setNama(rs.getString(3));
				mm.setJenis_makanan(rs.getString(4));
				mm.setHarga(rs.getString(5));
				mm.setKeterangan(rs.getString(5));
				dataMakanan.add(mm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataMakanan;
	}
	
	public ArrayList<MakananModel> getRowIDData(String ID){
		try {
			st=(Statement) con.createStatement();
			String query="SELECT * FROM daftar_menu WHERE ID='"+ID+"'";
			rs=(ResultSet) st.executeQuery(query);
			while(rs.next()) {
				MakananModel mm=new MakananModel();
				mm.setID(rs.getString(1));
				mm.setJenis_menu(rs.getString(2));
				mm.setNama(rs.getString(3));
				mm.setJenis_makanan(rs.getString(4));
				mm.setHarga(rs.getString(5));
				mm.setKeterangan(rs.getString(5));
				dataMakanan.add(mm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataMakanan;
	}
	
	public void insertMakanan(String ID, String jenis_menu, String nama, String jenis_makanan, String harga, String keterangan) {
		try {
			st=(Statement) con.createStatement();
			String query="INSERT INTO daftar_menu(ID, jenis_menu, nama, jenis_makanan, harga, keterangan)VALUES('"+ID+"','"+jenis_menu+"','"+nama+"','"+jenis_makanan+"','"+harga+"','"+keterangan+"')";
			st.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateMakanan(String ID, String jenis_menu, String nama, String jenis_makanan, String harga, String keterangan) {
		try {
			st=(Statement) con.createStatement();
			String query="UPDATE daftar_menu SET ID='"+ID+"', jenis_menu='"+jenis_menu+"', nama='"+nama+"', jenis_makanan='"+jenis_makanan+"', harga='"+harga+"', keterangan='"+keterangan+"' WHERE ID='"+ID+"'";
			st.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteMakanan(String ID) {
		try {
			st=(Statement) ((java.sql.Connection) con).createStatement();
			String query="DELETE FROM daftar_menu WHERE ID='"+ID+"'";
			st.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}//end of class
