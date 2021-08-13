package id.ac.uns.vokasi.d3ti.jdbc;

public class LoginModel {
String id_user, nama, email, password, username ;
	
	public void setId_user(String id_user) {
		this.id_user=id_user;
	}
	public void setNama(String nama) {
		this.nama=nama;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	
	public String getId_user() {
		return id_user;
	}
	public String getNama() {
		return nama;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	
}