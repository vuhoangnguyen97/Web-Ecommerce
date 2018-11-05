package DAO.DuPhong;



import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DTO.nhanVien;
import Database.*;

public class ThemNVDAO {
	public static int Them(nhanVien nv) {
		int status = 0;
		Connection db = Database.connect();
		try {
			String sql = "INSERT INTO nhan_vien (`idnhan_vien`, username, password, `ho_nhan_vien`, `ten_nhan_vien`, email, sdt,`hinh_nhan_vien`, `ma_chuc_vu`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			
			pst.setInt(1, nv.getIdnhan_vien());
			pst.setString(2, nv.getUsername());
			pst.setString(3, nv.getPassword());
			pst.setString(4, nv.getHo_nhan_vien());
			pst.setString(5, nv.getTen_nhan_vien());
			pst.setString(6, nv.getEmail());
			pst.setInt(7, nv.getSdt());
			pst.setBlob(8, nv.getHinh_nhan_vien());
			pst.setInt(9, nv.getMa_chuc_vu());
			
			status = pst.executeUpdate();
			db.close();
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return status;
	}
}
