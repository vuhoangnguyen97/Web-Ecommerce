package DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DTO.nhanVien;
import Database.Database;

public class nhanVienDAO {
	public static List<nhanVien> DocTatCa(){
		List<nhanVien> dsNhanVien = null;
		
		
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT * FROM nhan_vien INNER JOIN chuc_vu ON nhan_vien.ma_chuc_vu = chuc_vu.ma_chuc_vu order by idnhan_vien asc");
			dsNhanVien = new ArrayList<>();
			while(rs.next()) {
				
				nhanVien nv = new nhanVien();
				nv.setIdnhan_vien(rs.getInt("idnhan_vien"));
				nv.setUsername(rs.getString("username"));
				nv.setPassword(rs.getString("password"));
				nv.setHo_nhan_vien(rs.getString("ho_nhan_vien"));
				nv.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
				
				nv.setChuc_vu(rs.getString("chuc_vu"));
				nv.setEmail(rs.getString("email"));
				nv.setSdt(rs.getInt("sdt"));
				
				dsNhanVien.add(nv);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		return dsNhanVien;
	}
	
	
	//Xóa Nhân Viên
	public static int XoaNhanVien(int idnhan_vien) {
		int xoa = 0;
		try {
			Connection db = Database.connect();
			String sql = "DELETE FROM nhan_vien WHERE `idnhan_vien`= ?";
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			pst.setInt(1, idnhan_vien);
			xoa = pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return xoa;
	}
	
	
	//Đăng Ký Nhân Viên
	public static int dangKyNhanVien(nhanVien nv) {
		int status =0;
		
		String sql = "INSERT INTO `hthong_muaban`.`nhan_vien` (`username`, `password`, `ho_nhan_vien`, `ten_nhan_vien`,`email` ,`sdt`) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection db = Database.connect();
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			pst.setString(1, nv.getUsername());
			pst.setString(2, nv.getPassword());
			pst.setString(3, nv.getHo_nhan_vien());
			pst.setString(4, nv.getTen_nhan_vien());
			pst.setString(5, nv.getEmail());
			pst.setInt(6, nv.getSdt());
			
			status = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return status;
	}
	
	
	
	//Đăng Nhập
	public static nhanVien docTheoUsernamePassword(String username, String password) {
		nhanVien nv_dangnhap = null;
		
		try {
			String sql = "select*from nhan_vien where username = ? and password = ? ";
			Connection db = Database.connect();
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				nv_dangnhap = new nhanVien();
				nv_dangnhap.setIdnhan_vien(rs.getInt("idnhan_vien"));
				nv_dangnhap.setUsername(rs.getString("username"));
				nv_dangnhap.setPassword(rs.getString("password"));
				nv_dangnhap.setHo_nhan_vien(rs.getString("ho_nhan_vien"));
				nv_dangnhap.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
				nv_dangnhap.setEmail(rs.getString("email"));
				nv_dangnhap.setSdt(rs.getInt("sdt"));
				nv_dangnhap.setMa_chuc_vu(rs.getInt("ma_chuc_vu"));
			}
			/* lỗi SQL Injection cú pháp: ' or '1' = '1'
			 * Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery("select*from nhan_vien where username = '"+username+"' and password = '"+password+"' ");
			 where pass = ' 
			while(rs.next()) {
				nv_dangnhap = new nhanVien();
				nv_dangnhap.setUsername(rs.getString("username"));
				nv_dangnhap.setPassword(rs.getString("password"));
				nv_dangnhap.setHo_nhan_vien(rs.getString("ho_nhan_vien"));
				nv_dangnhap.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
				nv_dangnhap.setEmail(rs.getString("email"));
				nv_dangnhap.setSdt(rs.getInt("sdt"));
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nv_dangnhap;
	}
	
	
	//Reset Password
	public static nhanVien ResetPassword(String username, String email) {
		nhanVien nhanVienQuenMatKhau = null;
		Connection db = Database.connect();
		Statement stm;
		
		try {
			stm = db.createStatement();
			String sql = "SELECT * FROM hthong_muaban.nhan_vien where username = '"+username+"' and email = '"+email+"' ";
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				nhanVienQuenMatKhau = new nhanVien();
				nhanVienQuenMatKhau.setUsername(rs.getString("username"));
				nhanVienQuenMatKhau.setPassword(rs.getString("password"));
				nhanVienQuenMatKhau.setHo_nhan_vien(rs.getString("ho_nhan_vien"));
				nhanVienQuenMatKhau.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
				nhanVienQuenMatKhau.setEmail(rs.getString("email"));
				nhanVienQuenMatKhau.setSdt(rs.getInt("sdt"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return nhanVienQuenMatKhau;		
	}
	
	
	//Thêm Nhân Viên
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
	
	
	//Chi Tiết Nhân Viên
	public static nhanVien docTheoID(int id){
		nhanVien nv = null;
		
		
		try {
			Connection db = Database.connect();
			String sql = "SELECT * FROM nhan_vien INNER JOIN chuc_vu ON nhan_vien.ma_chuc_vu = chuc_vu.ma_chuc_vu where idnhan_vien ="+id;
			Statement stm;
			stm = db.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				nv = new nhanVien();
				nv.setIdnhan_vien(rs.getInt("idnhan_vien"));
				nv.setUsername(rs.getString("username"));
				nv.setPassword(rs.getString("password"));
				nv.setHo_nhan_vien(rs.getString("ho_nhan_vien"));
				nv.setTen_nhan_vien(rs.getString("ten_nhan_vien"));
				nv.setMa_chuc_vu(rs.getInt("ma_chuc_vu"));
				nv.setEmail(rs.getString("email"));
				nv.setSdt(rs.getInt("sdt"));
				nv.setChuc_vu(rs.getString("chuc_vu"));
				
				// tạo 1 biến kiểu Blob, nhận giá trị từ CSDL về dạng BLob
				Blob b = (Blob) rs.getBlob("hinh_nhan_vien");
				// Tách biến blob, ra thành kiểu nhị phân ( InputStream)
				InputStream inputStream = (InputStream) b.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				 
				// duyệt qua mảng kiểu byte sau khi lưu ở nhị phân, 
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					// mỗi lần duyệt là lưu vào outStream để lát in ra hình ảnh
				    outputStream.write(buffer, 0, bytesRead);
				}
				 
				// tạo mảng bytes sau khi duyệt và lưu trong outputstream
				byte[] imageBytes = outputStream.toByteArray();
				 
				// ép kiểu từ byte về lại String, do là dạng base64, 
				// nên ở thẻ img, phải khai báo data có kiểu là base64
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);
				 
				inputStream.close();
				outputStream.close();
				nv.setHinh_anh(base64Image);
	
			}
			db.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return nv;
	}
	
	
	//Sửa Nhân Viên
	public static int SuaNhanVien(int idnhan_vien, String username, String password, String ho_nhan_vien, String ten_nhan_vien, String email, int sdt, int ma_chuc_vu) {
		int sua = 0;
		try {
			Connection db = Database.connect();
			String sql = "UPDATE nhan_vien SET `username`=?, `password`=?,"
					+ "`ho_nhan_vien` = ?,"
					+ " `ten_nhan_vien`=?, `email`=?, `sdt`=?,"
					+ " `ma_chuc_vu`=? WHERE `idnhan_vien`=?";
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			pst.setString(3, ho_nhan_vien);
			pst.setString(4, ten_nhan_vien);
			pst.setString(5, email);
			pst.setInt(6, sdt);
			pst.setInt(7, ma_chuc_vu);
			pst.setInt(8, idnhan_vien);
			
			sua = pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sua;
	}
	
	
	
}
