package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DTO.ThanhVien;
import Database.Database;
import Encryption.encrypt;

public class ThanhVienDAO {
	
	/*public static List<ThanhVien> DocTatCa(){
		List<ThanhVien> dsThanhVien = null;
		
		
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT * FROM user");
			dsThanhVien = new ArrayList<>();
			while(rs.next())
			{
				ThanhVien tv = new ThanhVien();
				tv.setIduser(rs.getInt("iduser"));
				tv.setUsername(rs.getString("username"));
				tv.setPassword(rs.getString("password"));
				tv.setHo_user(rs.getString("ho_user"));
				tv.setTen_user(rs.getString("ten_user"));
				tv.setSdt(rs.getInt("sdt"));
				tv.setEmail(rs.getString("email"));
				tv.setDia_chi(rs.getString("dia_chi"));
				tv.setQuan(rs.getString("quan"));
				tv.setPhuong(rs.getString("phuong"));
				tv.setThanh_pho(rs.getString("thanh_pho"));
				tv.setNuoc(rs.getString("nuoc"));
				tv.setZip_code(rs.getString("zip_code"));
				
				
				dsThanhVien.add(tv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return dsThanhVien;
	}*/
	
	
	//Ä�á»�c Táº¥t Cáº£ ThÃ nh ViÃªn Má»›i
	public static List<ThanhVien> DocTatCa(){
		List<ThanhVien> dsThanhVien = null;
		
		
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT iduser, username, password, ho_user, ten_user, sdt, email, dia_chi, quan, phuong, thanh_pho,\r\n" + 
					"nuoc, zip_code, diem_tich_luy, loai_the\r\n" + 
					"FROM user INNER JOIN the_tich_diem ON the_tich_diem.id_the_tich_diem = user.id_the_tich_diem\r\n" + 
					"INNER JOIN loai_the ON loai_the.id_loai_the = the_tich_diem.id_loai_the");
			dsThanhVien = new ArrayList<>();
			String key = "Bar12345Bar12345"; // 128 bit key
	        String initVector = "RandomInitVector"; // 16 bytes IV
			
			while(rs.next())
			{
				ThanhVien tv = new ThanhVien();
				tv.setIduser(rs.getInt("iduser"));
				tv.setUsername(rs.getString("username"));
				tv.setPassword(rs.getString("password"));
				tv.setHo_user(rs.getString("ho_user"));
				tv.setTen_user(rs.getString("ten_user"));
				tv.setSdt(rs.getInt("sdt"));
				tv.setEmail(rs.getString("email"));
				tv.setDia_chi(rs.getString("dia_chi"));
				tv.setQuan(rs.getString("quan"));
				tv.setPhuong(rs.getString("phuong"));
				tv.setThanh_pho(rs.getString("thanh_pho"));
				tv.setNuoc(rs.getString("nuoc"));
				tv.setZip_code(rs.getString("zip_code"));
				tv.setDiem(rs.getInt("diem_tich_luy"));
				tv.setLoai_the(rs.getString("loai_the"));
				
				dsThanhVien.add(tv);
			}
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return dsThanhVien;
	}
	
	
	//Chi tiáº¿t ThÃ nh ViÃªn
	/*public static ThanhVien docTheoID(int id) {
		ThanhVien tv = null;
		Connection db = Database.connect();
		String sql = "SELECT * FROM user WHERE iduser =" + id;
		Statement stm;
		
		try {
			stm = db.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				tv = new ThanhVien();
				tv.setIduser(rs.getInt("iduser"));
				tv.setHo_user(rs.getString("ho_user"));
				tv.setTen_user(rs.getString("ten_user"));
				tv.setSdt(rs.getInt("sdt"));
				tv.setEmail(rs.getString("email"));
				tv.setDia_chi(rs.getString("dia_chi"));
				tv.setPhuong(rs.getString("phuong"));
				tv.setQuan(rs.getString("quan"));
				tv.setThanh_pho(rs.getString("thanh_pho"));
				tv.setNuoc(rs.getString("nuoc"));
				tv.setZip_code(rs.getString("zip_code"));
				tv.setUsername(rs.getString("username"));
				tv.setPassword(rs.getString("password"));	
			}db.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tv;
	}*/
	
	
	
	//Chi tiáº¿t thÃ nh viÃªn má»›i
	public static ThanhVien docTheoID(int id) {
		ThanhVien tv = null;
		Connection db = Database.connect();
		String sql = "SELECT iduser, username, password, ho_user, ten_user, sdt, email, dia_chi, quan, phuong, thanh_pho,\r\n" + 
				"nuoc, zip_code, diem_tich_luy, loai_the\r\n" + 
				"FROM user INNER JOIN the_tich_diem ON the_tich_diem.id_the_tich_diem = user.id_the_tich_diem\r\n" + 
				"INNER JOIN loai_the ON loai_the.id_loai_the = the_tich_diem.id_loai_the WHERE iduser =" + id;
		Statement stm;
		
		try {
			stm = db.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				tv = new ThanhVien();
				tv.setIduser(rs.getInt("iduser"));
				tv.setHo_user(rs.getString("ho_user"));
				tv.setTen_user(rs.getString("ten_user"));
				tv.setSdt(rs.getInt("sdt"));
				tv.setEmail(rs.getString("email"));
				tv.setDia_chi(rs.getString("dia_chi"));
				tv.setPhuong(rs.getString("phuong"));
				tv.setQuan(rs.getString("quan"));
				tv.setThanh_pho(rs.getString("thanh_pho"));
				tv.setNuoc(rs.getString("nuoc"));
				tv.setZip_code(rs.getString("zip_code"));
				tv.setUsername(rs.getString("username"));
				tv.setPassword(rs.getString("password"));	
				tv.setDiem(rs.getInt("diem_tich_luy"));
				tv.setLoai_the(rs.getString("loai_the"));
			}db.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tv;
	}
	
	
	
	
	
	//XÃ³a ThÃ nh ViÃªn
	public static int XoaThanhVien(int iduser) {
		int xoa=0;
		try {
			Connection db = Database.connect();
			String sql = "DELETE FROM user where `iduser`=?";
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			pst.setInt(1, iduser);
			xoa = pst.executeUpdate();
		
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return xoa;
	}
	
	

}
