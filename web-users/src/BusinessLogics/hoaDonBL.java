package BusinessLogics;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import JavaBeans.hoaDon;
import JavaBeans.themSanPhamMua;

public class hoaDonBL {
	public static int themHoaDon(hoaDon hd) {
		int status =0;
		String sql = "insert into gio_hang(iduser, email, ho_user, ten_user, sdt, diaChi, quan, phuong, chi_tiet, hinh_thuc_thanh_toan) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection db = Database.connect();
			PreparedStatement pst = db.prepareStatement(sql);
			pst.setInt(1, hd.getId_user());
			pst.setString(2, hd.getEmail());
			pst.setString(3, hd.getHo_user());
			pst.setString(4, hd.getTen_user());
			pst.setInt(5, hd.getSdt());
			pst.setString(6, hd.getDiaChi());;
			pst.setString(7, hd.getQuan());
			pst.setString(8, hd.getPhuong());
			pst.setString(9, hd.getChiTiet());
			pst.setString(10, hd.getHinhThucThanhToan());
			status = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int themSPMua(themSanPhamMua spm) {
		int status =0;
		String sql = "insert into giohang_sanpham(idgio_hang,ma_san_pham) values(?,?)";
		try {
			Connection db = Database.connect();
			PreparedStatement pst = db.prepareStatement(sql);
			pst.setInt(1, spm.getIdgio_hang());
			pst.setInt(2, spm.getMa_san_pham());
			
			status = pst.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}
