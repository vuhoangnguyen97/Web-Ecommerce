package DTO;

import java.io.Serializable;

public class the implements Serializable {
	private static final long serialVersionUID =1L;
	private int id_the_tich_diem;
	private int diem;
	private int id_loai_the;
	private String loai_the;
	private int so_luong;
	
	public the() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId_the_tich_diem() {
		return id_the_tich_diem;
	}
	public void setId_the_tich_diem(int id_the_tich_diem) {
		this.id_the_tich_diem = id_the_tich_diem;
	}
	public int getDiem() {
		return diem;
	}
	public void setDiem(int diem) {
		this.diem = diem;
	}
	public int getId_loai_the() {
		return id_loai_the;
	}
	public void setId_loai_the(int id_loai_the) {
		this.id_loai_the = id_loai_the;
	}

	public String getLoai_the() {
		return loai_the;
	}

	public void setLoai_the(String loai_the) {
		this.loai_the = loai_the;
	}

	public int getSo_luong() {
		return so_luong;
	}

	public void setSo_luong(int so_luong) {
		this.so_luong = so_luong;
	}
	
	
	
}
