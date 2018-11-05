package DAO.DuPhong;

import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DTO.SanPham;
import Database.Database;

public class ThemSPDAO {
	public static int Them(SanPham sp) {
		int status = 0;
		Connection db = Database.connect();
		try {
			String sql = "INSERT INTO san_pham (`ma_san_pham`,`ten_san_pham`, `hang_san_xuat`, `gia_san_pham`, `tinh_trang`, `hinh_anh_mo_phong`, `camera_truoc`, `camera_sau`, `dung_luong_pin`, `tinh_nang`, `bao_mat`, `mau_sac`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			
			pst.setInt(1, sp.getMa_san_pham());
			pst.setString(2, sp.getTenSanPham());
			pst.setString(3, sp.getHangSanXuat());
			pst.setInt(4, sp.getGiaSanPham());
			pst.setString(5, sp.getTinhTrang());
			pst.setBlob(6, sp.getHinh_dai_dien());
			pst.setString(7, sp.getCamera_truoc());
			pst.setString(8, sp.getCamera_sau());
			pst.setString(9, sp.getDung_luong_pin());
			pst.setString(10, sp.getTinh_nang());
			pst.setString(11, sp.getBao_mat());
			pst.setString(12, sp.getMau_sac());
			
			status = pst.executeUpdate();
			db.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}
}
