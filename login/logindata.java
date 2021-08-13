package id.ac.uns.vokasi.d3ti.login;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class logindata {
	Connection con;
	ResultSet rs;
	Statement st;
	
	ArrayList<loginmodel> logindata;
	
	//Konstruktor
	public logindata() {
		logindata = new ArrayList<loginmodel>();
		
		try {
			String server="jdbc:mysql://127.0.0.1/uaspbolan?user=root&password="; //Koneksi
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection(server);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertData(String email, String password, String nama, String ttl, String nohp, String jk) {
		try {
			st = (Statement) con.createStatement();
			
			String query = "INSERT INTO `login` (`id_siswa`, `email`, `password`, `nama_siswa`, `tanggal_lahir`, `no_hp`, `jk`) VALUES (NULL, '"+email+"', '"+password+"', '"+nama+"', '"+ttl+"', '"+nohp+"', '"+jk+"')";
			st.execute(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<loginmodel> getRowData(String email){
		try {
			st=(Statement) con.createStatement();
			String query="SELECT * FROM login WHERE email='"+email+"'";
			rs=(ResultSet) st.executeQuery(query);
			
			while(rs.next()) {
				loginmodel mm=new loginmodel();
				mm.setEmail(rs.getString(2));
				mm.setPass(rs.getString(3));
				mm.setNama(rs.getString(4));
				mm.setTtl(rs.getString(5));
				mm.setNohp(rs.getString(6));
				mm.setJk(rs.getString(7));
				logindata.add(mm);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return logindata;
	}
}
