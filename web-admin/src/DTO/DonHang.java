package DTO;

import java.io.Serializable;

public class DonHang implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int ma_don_hang;
	private int ma_khach_hang;
	private String email;
	private String ho_user;
	private String ten_user;
	private int sdt;
	private String diaChi;
	private String phuong;
	private String quan;
	private String chi_tiet;
	private int diem;
	
	
	public DonHang() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getMa_don_hang() {
		return ma_don_hang;
	}


	public void setMa_don_hang(int ma_don_hang) {
		this.ma_don_hang = ma_don_hang;
	}


	public int getMa_khach_hang() {
		return ma_khach_hang;
	}


	public void setMa_khach_hang(int ma_khach_hang) {
		this.ma_khach_hang = ma_khach_hang;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getHo_user() {
		return ho_user;
	}


	public void setHo_user(String ho_user) {
		this.ho_user = ho_user;
	}


	public String getTen_user() {
		return ten_user;
	}


	public void setTen_user(String ten_user) {
		this.ten_user = ten_user;
	}


	public int getSdt() {
		return sdt;
	}


	public void setSdt(int sdt) {
		this.sdt = sdt;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getPhuong() {
		return phuong;
	}


	public void setPhuong(String phuong) {
		this.phuong = phuong;
	}


	public String getQuan() {
		return quan;
	}


	public void setQuan(String quan) {
		this.quan = quan;
	}


	public String getChi_tiet() {
		return chi_tiet;
	}


	public void setChi_tiet(String chi_tiet) {
		this.chi_tiet = chi_tiet;
	}


	public int getDiem() {
		return diem;
	}


	public void setDiem(int diem) {
		this.diem = diem;
	}
	
	
	
	
	
}
