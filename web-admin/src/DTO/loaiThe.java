package DTO;

import java.io.Serializable;

public class loaiThe implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id_loai_the;
	private String loai_the;
	public loaiThe() {
		super();
		// TODO Auto-generated constructor stub
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
	
	
}
