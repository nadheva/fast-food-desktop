package id.ac.uns.vokasi.d3ti.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LoginData {
	Connection con;
	ResultSet rs;
	Statement st;
	
	ArrayList<LoginModel> LoginData;
	
	//Konstruktor
	public LoginData() {
		LoginData = new ArrayList<LoginModel>();
		
		try {
			String server="jdbc:mysql://127.0.0.1/makanan_pbo?user=root&password="; //Koneksi
			Class.forName("com.mysql.jdbc.Driver");
			con=(Connection) DriverManager.getConnection(server);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertData(String id_user, String nama, String email,  String password, String username) {
		try {
			st = (Statement) con.createStatement();
			
			String query = "INSERT INTO users (id_user, nama, email, password, username) VALUES('"+id_user+"','"+nama+"','"+nama+"','"+email+"','"+password+"','"+username+"')";
			st.execute(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<LoginModel> getRowData(String username){
		try {
			st=(Statement) con.createStatement();
			String query="SELECT * FROM users WHERE username='"+username+"'";
			rs=(ResultSet) st.executeQuery(query);
			
			while(rs.next()) {
				LoginModel mm=new LoginModel();
				mm.setUsername(rs.getString(2));
				mm.setPassword(rs.getString(3));
				mm.setNama(rs.getString(4));
				LoginData.add(mm);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return LoginData;
	}
}
