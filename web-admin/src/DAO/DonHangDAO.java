package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import DTO.DonHang;
import Database.Database;
import Encryption.encrypt;

public class DonHangDAO {
	public static List<DonHang> DocTatCa(){
		List<DonHang> dsDonHang = null;
		String key = "Bar12345Bar12345"; // 128 bit key
        String initVector = "RandomInitVector"; // 16 bytes IV
		
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT * FROM gio_hang order by idgio_hang desc");
			dsDonHang = new ArrayList<>();
			
			while(rs.next()) 
			{
				DonHang dh = new DonHang();
				dh.setMa_don_hang(rs.getInt("idgio_hang"));
				dh.setMa_khach_hang(rs.getInt("iduser"));
				dh.setEmail(rs.getString("email"));
				dh.setHo_user(rs.getString("ho_user"));
				dh.setTen_user(rs.getString("ten_user"));
				dh.setSdt(rs.getInt("sdt"));
				dh.setDiaChi(encrypt.decryptAES(key, initVector, rs.getString("diaChi")));
				dh.setPhuong(encrypt.decryptAES(key, initVector, rs.getString("phuong")));
				dh.setQuan(encrypt.decryptAES(key, initVector, rs.getString("quan")));
				dh.setChi_tiet(encrypt.decryptAES(key, initVector,rs.getString("chi_tiet")));
				
				dsDonHang.add(dh);
			}
			stm.close();
			rs.close();
			db.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return dsDonHang;
	}
	
	public static List<DonHang> dsTopNguoiDungMuaNhieu(){
		List<DonHang> dsTop = new ArrayList<>();	
		
		try {
			String sql = "SELECT user.iduser, user.ten_user, the_tich_diem.diem_tich_luy, count(*) as soLanMua\r\n" + 
					"					FROM gio_hang\r\n" + 
					"					INNER JOIN user ON gio_hang.iduser = user.iduser\r\n" + 
					"					INNER JOIN the_tich_diem ON the_tich_diem.id_the_tich_diem = user.id_the_tich_diem\r\n" + 
					"					GROUP BY iduser";
			
			String key = "Bar12345Bar12345"; // 128 bit key
	        String initVector = "RandomInitVector"; // 16 bytes IV
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) 
			{
				DonHang dh = new DonHang();				
				dh.setMa_khach_hang(rs.getInt("iduser"));
				dh.setTen_user(rs.getString("ten_user"));
				dh.setDiem(rs.getInt("diem_tich_luy"));
				dsTop.add(dh);
			}
			stm.close();
			rs.close();
			db.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsTop;
	}
	
}
