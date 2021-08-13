package id.ac.uns.vokasi.d3ti.jdbc;

public class MakananModel {
	String ID, jenis_menu, nama, jenis_makanan, harga, keterangan;
	
	public void setID(String ID) {
		this.ID=ID;
	}
	public void setJenis_menu(String jenis_menu) {
		this.jenis_menu=jenis_menu;
	}
	public void setNama(String nama) {
		this.nama=nama;
	}
	public void setJenis_makanan(String jenis_makanan) {
		this.jenis_makanan=jenis_makanan;
	}
	public void setHarga(String harga) {
		this.harga=harga;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan=keterangan;
	}
	
	public String getID() {
		return ID;
	}
	public String getJenis_menu() {
		return jenis_menu;
	}
	public String getNama() {
		return nama;
	}
	public String getJenis_makanan() {
		return jenis_makanan;
	}
	public String getHarga() {
		return harga;
	}
	public String getKeterangan() {
		return keterangan;
	}
}//end of class