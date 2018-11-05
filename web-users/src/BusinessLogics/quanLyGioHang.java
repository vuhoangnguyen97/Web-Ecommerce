package BusinessLogics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import JavaBeans.hoaDon;

public class quanLyGioHang {
	public static List<hoaDon> xemTatCa(){
		List<hoaDon> dshd = new ArrayList<hoaDon>();
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery("select*from gio_hang");
			
			while(rs.next()) {
				hoaDon hd = new hoaDon();
				hd.setId_giohang(rs.getInt("idgio_hang"));
				hd.setId_user(rs.getInt("iduser"));
				hd.setEmail(rs.getString("email"));
				hd.setHo_user(rs.getString("ho_user"));
				hd.setTen_user(rs.getString("ten_user"));
				hd.setSdt(rs.getInt("sdt"));
				hd.setDiaChi(rs.getString("diaChi"));
				hd.setQuan(rs.getString("quan"));
				hd.setPhuong(rs.getString("phuong"));
				hd.setChiTiet(rs.getString("chi_tiet"));
				dshd.add(hd);
			}
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dshd;
	}
}
