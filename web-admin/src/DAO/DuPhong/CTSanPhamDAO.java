package DAO.DuPhong;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import java.io.InputStream;


import java.sql.*;
import com.mysql.jdbc.Connection;

import DTO.SanPham;
import Database.Database;

public class CTSanPhamDAO {
	public static SanPham docTheoID(int id) {
		SanPham sp = null;
		Connection db = Database.connect();
		String sql = "SELECT * FROM san_pham WHERE ma_san_pham =" + id;
		Statement stm;
		
		try {
			stm = db.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				// táº¡o 1 biáº¿n kiá»ƒu Blob, nháº­n giÃ¡ trá»‹ tá»« CSDL vá»� dáº¡ng BLob
				Blob b = rs.getBlob("hinh_anh_mo_phong");
				// TÃ¡ch biáº¿n blob, ra thÃ nh kiá»ƒu nhá»‹ phÃ¢n ( InputStream)
				InputStream inputStream = (InputStream) b.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				 
				// duyá»‡t qua máº£ng kiá»ƒu byte sau khi lÆ°u á»Ÿ nhá»‹ phÃ¢n, 
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					// má»—i láº§n duyá»‡t lÃ  lÆ°u vÃ o outStream Ä‘á»ƒ lÃ¡t in ra hÃ¬nh áº£nh
				    outputStream.write(buffer, 0, bytesRead);
				}
				 
				// táº¡o máº£ng bytes sau khi duyá»‡t vÃ  lÆ°u trong outputstream
				byte[] imageBytes = outputStream.toByteArray();
				 
				// Ã©p kiá»ƒu tá»« byte vá»� láº¡i String, do lÃ  dáº¡ng base64, 
				// nÃªn á»Ÿ tháº» img, pháº£i khai bÃ¡o data cÃ³ kiá»ƒu lÃ  base64
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				 
				inputStream.close();
				outputStream.close();
				sp.setHinh_anh(base64Image);
				
				sp.setCamera_truoc(rs.getString("camera_truoc"));
				sp.setCamera_sau(rs.getString("camera_sau"));
				sp.setDung_luong_pin(rs.getString("dung_luong_pin"));
				sp.setTinh_nang(rs.getString("tinh_nang"));
				sp.setBao_mat(rs.getString("bao_mat"));
				sp.setMau_sac(rs.getString("mau_sac")); 
			}
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sp;
	}
}
