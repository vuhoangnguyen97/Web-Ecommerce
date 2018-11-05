package DAO.DuPhong;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

import DTO.ThanhVien;
import Database.Database;

public class CTThanhVienDAO {
	public static ThanhVien docTheoID(int id) {
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
	}
}
