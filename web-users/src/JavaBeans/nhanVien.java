package JavaBeans;

import java.io.Serializable;

public class nhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String ho_nhan_vien;
	private String ten_nhan_vien;
	private String email;
	private int sdt;
	
	public nhanVien() {
		super();
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHo_nhan_vien() {
		return ho_nhan_vien;
	}

	public void setHo_nhan_vien(String ho_nhan_vien) {
		this.ho_nhan_vien = ho_nhan_vien;
	}

	public String getTen_nhan_vien() {
		return ten_nhan_vien;
	}

	public void setTen_nhan_vien(String ten_nhan_vien) {
		this.ten_nhan_vien = ten_nhan_vien;
	}

	public int getSdt() {
		return sdt;
	}

	public void setSdt(int sdt) {
		this.sdt = sdt;
	}
	
}
