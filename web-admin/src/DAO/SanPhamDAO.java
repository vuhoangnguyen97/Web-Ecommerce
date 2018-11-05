package DAO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;

import DTO.SanPham;
import Database.Database;

public class SanPhamDAO {
	// doc cau lenh SQL: SELECT * FROM san_pham, Ä‘á»�c táº¥t cáº£ sáº£n pháº©m trong báº£ng.
	// luu tat ca ket qua vao` List SanPham.
	public static List<SanPham> DocTatCa(){
		List<SanPham> dsSanPham = null; // ban Ä‘áº§u chÆ°a cÃ³ sáº£n pháº©m, list lÃ  null
		// sau Ä‘Ã³ add káº¿t quáº£ vÃ o list, thÃ´ng qua lá»‡nh dsSanPham.add();
		try {
			Connection db = Database.connect(); // káº¿t ná»‘i vá»›i CSDL thÃ´ng qua lá»›p Database ( khá»Ÿi táº¡o)
			Statement stm = db.createStatement(); // Sau khi káº¿t ná»‘i thÃ nh cÃ´ng, thá»±c thi lá»‡nh SQL ( Statement)
			
			ResultSet rs = stm.executeQuery("SELECT * FROM san_pham"); // ResultSet nháº­n káº¿t quáº£ excute tá»« statement
			dsSanPham = new ArrayList<>(); // new ArrayList cá»§a List Sáº£n pháº©m Ä‘á»ƒ lÆ°u dá»¯ liá»‡u
			
			// nháº­n dá»¯ liá»‡u Ä‘á»�c tá»« Ä‘áº§u Ä‘áº¿n cuá»‘i, thÃ´ng qua lá»‡nh while, rs ( ResultSet).next(), lÃ  Ä‘á»�c láº§n lÆ°á»£t vá»‹ trÃ­ 1 2 3..n) 
			while(rs.next()){				
				SanPham sp = new SanPham(); // khá»Ÿi táº¡o Ä‘á»‘i tÆ°á»£ng SanPham Ä‘á»ƒ lÆ°u tá»« rs 
				sp.setMa_san_pham(rs.getInt("ma_san_pham")); // lÆ°u vÃ o Ä‘á»‘i tÆ°á»£ng sp, á»©ng vá»›i cá»™t trong csdl
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
				String img = new String(b.getBytes(1l, (int) b.length()));
				sp.setHinh_anh(img);
				
				sp.setCamera_truoc(rs.getString("camera_truoc"));
				sp.setCamera_sau(rs.getString("camera_sau"));
				sp.setDung_luong_pin(rs.getString("dung_luong_pin"));
				sp.setTinh_nang(rs.getString("tinh_nang"));
				sp.setBao_mat(rs.getString("bao_mat"));
				sp.setMau_sac(rs.getString("mau_sac"));
				sp.setSoLuotMua(rs.getInt("soLuotMua"));
				dsSanPham.add(sp);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return dsSanPham;
		
	}
	
	public static List<SanPham> dsSanPhamMuaNhieuNhat(){
		List<SanPham> dsSanPhamMuaNhieu = new ArrayList<>();
		try {
			Connection db = Database.connect(); // káº¿t ná»‘i vá»›i CSDL thÃ´ng qua lá»›p Database ( khá»Ÿi táº¡o)
			Statement stm = db.createStatement(); // Sau khi káº¿t ná»‘i thÃ nh cÃ´ng, thá»±c thi lá»‡nh SQL ( Statement)
			
			ResultSet rs = stm.executeQuery("SELECT * FROM san_pham order by soLuotMua desc limit 10"); // ResultSet nháº­n káº¿t quáº£ excute tá»« statement
			
			// nháº­n dá»¯ liá»‡u Ä‘á»�c tá»« Ä‘áº§u Ä‘áº¿n cuá»‘i, thÃ´ng qua lá»‡nh while, rs ( ResultSet).next(), lÃ  Ä‘á»�c láº§n lÆ°á»£t vá»‹ trÃ­ 1 2 3..n) 
			while(rs.next()){				
				SanPham sp = new SanPham(); // khá»Ÿi táº¡o Ä‘á»‘i tÆ°á»£ng SanPham Ä‘á»ƒ lÆ°u tá»« rs 
				sp.setMa_san_pham(rs.getInt("ma_san_pham")); // lÆ°u vÃ o Ä‘á»‘i tÆ°á»£ng sp, á»©ng vá»›i cá»™t trong csdl
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
				String img = new String(b.getBytes(1l, (int) b.length()));
				sp.setHinh_anh(img);
				
				sp.setCamera_truoc(rs.getString("camera_truoc"));
				sp.setCamera_sau(rs.getString("camera_sau"));
				sp.setDung_luong_pin(rs.getString("dung_luong_pin"));
				sp.setTinh_nang(rs.getString("tinh_nang"));
				sp.setBao_mat(rs.getString("bao_mat"));
				sp.setMau_sac(rs.getString("mau_sac"));
				sp.setSoLuotMua(rs.getInt("soLuotMua"));
				dsSanPhamMuaNhieu.add(sp);
				
			}			
			rs.close();
			stm.close();
			db.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return dsSanPhamMuaNhieu;
	}
	
	public static List<SanPham> dsSanPhamMuaItNhat(){
		List<SanPham> dsSanPhamMuaIt = new ArrayList<>();
		try {
			Connection db = Database.connect(); // káº¿t ná»‘i vá»›i CSDL thÃ´ng qua lá»›p Database ( khá»Ÿi táº¡o)
			Statement stm = db.createStatement(); // Sau khi káº¿t ná»‘i thÃ nh cÃ´ng, thá»±c thi lá»‡nh SQL ( Statement)
			
			ResultSet rs = stm.executeQuery("SELECT * FROM san_pham order by soLuotMua asc limit 10"); // ResultSet nháº­n káº¿t quáº£ excute tá»« statement
			
			// nháº­n dá»¯ liá»‡u Ä‘á»�c tá»« Ä‘áº§u Ä‘áº¿n cuá»‘i, thÃ´ng qua lá»‡nh while, rs ( ResultSet).next(), lÃ  Ä‘á»�c láº§n lÆ°á»£t vá»‹ trÃ­ 1 2 3..n) 
			while(rs.next()){				
				SanPham sp = new SanPham(); // khá»Ÿi táº¡o Ä‘á»‘i tÆ°á»£ng SanPham Ä‘á»ƒ lÆ°u tá»« rs 
				sp.setMa_san_pham(rs.getInt("ma_san_pham")); // lÆ°u vÃ o Ä‘á»‘i tÆ°á»£ng sp, á»©ng vá»›i cá»™t trong csdl
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
				String img = new String(b.getBytes(1l, (int) b.length()));
				sp.setHinh_anh(img);
				
				sp.setCamera_truoc(rs.getString("camera_truoc"));
				sp.setCamera_sau(rs.getString("camera_sau"));
				sp.setDung_luong_pin(rs.getString("dung_luong_pin"));
				sp.setTinh_nang(rs.getString("tinh_nang"));
				sp.setBao_mat(rs.getString("bao_mat"));
				sp.setMau_sac(rs.getString("mau_sac"));
				sp.setSoLuotMua(rs.getInt("soLuotMua"));
				dsSanPhamMuaIt.add(sp);
				
			}			
			rs.close();
			stm.close();
			db.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return dsSanPhamMuaIt;
	}
	
	
	//XÃ³a Sáº£n Pháº©m
	public static int XoaSanPham(int ma_san_pham) {
		int xoa = 0;		
		try {
			Connection db = Database.connect();
			String sql = "DELETE FROM san_pham WHERE `ma_san_pham`= ?";
			PreparedStatement pst = db.prepareStatement(sql);
			pst.setInt(1, ma_san_pham);
			xoa = pst.executeUpdate();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return xoa;		
	}
	
	
	//Sá»­a Sáº£n Pháº©m
	public static int SuaSanPham(int ma_san_pham, String ten_san_pham, int gia_san_pham, String tinh_trang, String camera_truoc, String camera_sau, String dung_luong_pin,
			String tinh_nang, String bao_mat, String mau_sac) {
		int sua = 0;
		
		try {
			Connection db = Database.connect();
			String sql = "UPDATE san_pham SET ten_san_pham=?, gia_san_pham=?,"
					+ "tinh_trang = ?,"
					+ " camera_truoc=?, camera_sau=?, dung_luong_pin=?,"
					+ " tinh_nang=?, bao_mat`=?, mau_sac=? WHERE ma_san_pham=?";
			PreparedStatement pst = db.prepareStatement(sql);
			pst.setString(1, ten_san_pham);
			pst.setInt(2, gia_san_pham);
			pst.setString(3, tinh_trang);
			//pst.setBlob(4, hinh_anh_mo_phong);
			pst.setString(4, camera_truoc);
			pst.setString(5, camera_sau);
			pst.setString(6, dung_luong_pin);
			pst.setString(7, tinh_nang);
			pst.setString(8, bao_mat);
			pst.setString(9, mau_sac);
			pst.setInt(10, ma_san_pham);
			
			sua = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return sua;
	}
	
	
	//ThÃªm Sáº£n Pháº©m
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

	
	//Chi Tiáº¿t Sáº£n Pháº©m DAO
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
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
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
	
	
	//TÃ¬m SP theo TÃªn
	public static List<SanPham> timTheoTen(String tenSanPhamCanTim){
		List<SanPham> dsSanPham = null;
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery("select * from  san_pham where ten_san_pham like '%"+tenSanPhamCanTim+"%'");
			dsSanPham = new ArrayList<>();
			while(rs.next()){
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
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
				dsSanPham.add(sp);
			}
			db.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsSanPham;
		
	}
	
	
	//TÃ¬m SP Theo HÃ£ng
	public static List<SanPham> timKiemTheoHang(String hang_sxuat){
		List<SanPham> dsSanPham = null;
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery("select * from san_pham where hang_san_xuat like '%"+hang_sxuat+"%'");
			dsSanPham = new ArrayList<>();
			while(rs.next()){
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
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
				dsSanPham.add(sp);
				
			}
			db.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsSanPham;	
	}
	
	
	//Sáº£n Pháº©m DÆ°á»›i 1 triá»‡u
	public static List<SanPham> timTheoGiaDuoi1Trieu(){
		List<SanPham> dsSanPham = null;
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery("select * from san_pham where gia_san_pham <1000000");
			dsSanPham = new ArrayList<>();
			while(rs.next()){
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
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
				dsSanPham.add(sp);
				
			}
			db.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsSanPham;
	}
	
	
	//Sáº£n pháº©m tá»« 1 Ä‘áº¿n 3 triá»‡u
	public static List<SanPham> timTheoGia1TrieuDen3Trieu(){
		List<SanPham> dsSanPham = null;
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery("select * from san_pham where gia_san_pham >=1000000 and gia_san_pham <3000000 ");
			dsSanPham = new ArrayList<>();
			while(rs.next()){
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
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
				dsSanPham.add(sp);
				
			}
			db.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsSanPham;
	}
	
	
	//Sáº£n pháº©m tá»« 3 Ä‘áº¿n 7 triá»‡u
	public static List<SanPham> timTheoGia3TrieuDen7Trieu(){
		List<SanPham> dsSanPham = null;
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery("select * from san_pham where gia_san_pham >=3000000 and gia_san_pham <7000000 ");
			dsSanPham = new ArrayList<>();
			while(rs.next()){
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
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
				dsSanPham.add(sp);
				
			}
			db.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsSanPham;
		
	}
	
	
	//Sáº£n pháº©m tá»« 7 Ä‘áº¿n 10 triá»‡u
	public static List<SanPham> timTheoGia7TrieuDen10Trieu(){
		List<SanPham> dsSanPham = null;
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery("select * from san_pham where gia_san_pham >=7000000 and gia_san_pham <10000000 ");
			dsSanPham = new ArrayList<>();
			while(rs.next()){
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
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
				dsSanPham.add(sp);
			}
			db.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsSanPham;
		
	}
	
	
	//Sáº£n pháº©m trÃªn 10 triá»‡u
	public static List<SanPham> timTheoGiaTren10Trieu(){
		List<SanPham> dsSanPham = null;
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery("select * from san_pham where gia_san_pham >=10000000");
			dsSanPham = new ArrayList<>();
			while(rs.next()){
				SanPham sp = new SanPham();
				sp.setMa_san_pham(rs.getInt("ma_san_pham"));
				sp.setTenSanPham(rs.getString("ten_san_pham"));
				sp.setHangSanXuat(rs.getString("hang_san_xuat"));
				sp.setGiaSanPham(rs.getInt("gia_san_pham"));
				sp.setTinhTrang(rs.getString("tinh_trang"));
				Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
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
				dsSanPham.add(sp);
				
			}
			db.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsSanPham;
		
	}
	
	
	//TÃ¬m theo hÃ£ng vÃ  dÆ°á»›i 1 triá»‡u
	public static List<SanPham> timTheoHangGiaDuoi1Trieu(String brand){
        List<SanPham> listDuoi1Trieu = new ArrayList<SanPham>();
        try {
            Connection db = Database.connect();
            String sql = "SELECT * FROM san_pham where hang_san_xuat like N'%"+brand+"%' and gia_san_pham <=1000000;";
            Statement stm = db.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa_san_pham(rs.getInt("ma_san_pham"));
                sp.setTenSanPham(rs.getString("ten_san_pham"));
                sp.setHangSanXuat(rs.getString("hang_san_xuat"));
                sp.setGiaSanPham(rs.getInt("gia_san_pham"));
                sp.setTinhTrang(rs.getString("tinh_trang"));
                Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
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
                listDuoi1Trieu.add(sp);

            }
            db.close();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

        return listDuoi1Trieu;
    }
	
	
	//TÃ¬m sáº£n pháº©m hÃ£ng giÃ¡ 1-3 triá»‡u
	public static List<SanPham> timTheoHangGia1Den3Trieu(String brand){
        List<SanPham> list1Den3Trieu = new ArrayList<SanPham>();
        try {
            Connection db = Database.connect();
            String sql = "SELECT * FROM san_pham where hang_san_xuat like N'%"+brand+"%' and gia_san_pham >=1000000 and gia_san_pham <= 3000000;";
            Statement stm = db.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa_san_pham(rs.getInt("ma_san_pham"));
                sp.setTenSanPham(rs.getString("ten_san_pham"));
                sp.setHangSanXuat(rs.getString("hang_san_xuat"));
                sp.setGiaSanPham(rs.getInt("gia_san_pham"));
                sp.setTinhTrang(rs.getString("tinh_trang"));
                Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
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
                list1Den3Trieu.add(sp);

            }
            db.close();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return list1Den3Trieu;
    }
	
	
	//TÃ¬m sp hÃ£ng giÃ¡ 3-7 triá»‡u
	public static List<SanPham> timTheoHangGia3Den7rieu(String brand){
        List<SanPham> list3Den7Trieu = new ArrayList<SanPham>();
        try {
            Connection db = Database.connect();
            String sql = "SELECT * FROM san_pham where hang_san_xuat like N'%"+brand+"%' and gia_san_pham >=3000000 and gia_san_pham <= 7000000;";
            Statement stm = db.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa_san_pham(rs.getInt("ma_san_pham"));
                sp.setTenSanPham(rs.getString("ten_san_pham"));
                sp.setHangSanXuat(rs.getString("hang_san_xuat"));
                sp.setGiaSanPham(rs.getInt("gia_san_pham"));
                sp.setTinhTrang(rs.getString("tinh_trang"));
                Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
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
                list3Den7Trieu.add(sp);

            }
            db.close();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return list3Den7Trieu;
    }
	
	
	//TÃ¬m sp hÃ£ng giÃ¡ 7-10 triá»‡u
	public static List<SanPham> timTheoHangGia7Den10rieu(String brand){
        List<SanPham> list7Den10Trieu = new ArrayList<SanPham>();
        try {
            Connection db = Database.connect();
            String sql = "SELECT * FROM san_pham where hang_san_xuat like N'%"+brand+"%' and gia_san_pham >=7000000 and gia_san_pham <= 10000000;";
            Statement stm = db.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa_san_pham(rs.getInt("ma_san_pham"));
                sp.setTenSanPham(rs.getString("ten_san_pham"));
                sp.setHangSanXuat(rs.getString("hang_san_xuat"));
                sp.setGiaSanPham(rs.getInt("gia_san_pham"));
                sp.setTinhTrang(rs.getString("tinh_trang"));
                Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
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
                list7Den10Trieu.add(sp);

            }
            db.close();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return list7Den10Trieu;
    }
	
	
	
	//TÃ¬m sp hÃ£ng giÃ¡ trÃªn 10 triá»‡u
	public static List<SanPham> timTheoHangGiaTren10Trieu(String brand){
        List<SanPham> listTren10Trieu = new ArrayList<SanPham>();
        try {
            Connection db = Database.connect();
            String sql = "SELECT * FROM san_pham where hang_san_xuat like N'%"+brand+"%' and gia_san_pham >=10000000;";
            Statement stm = db.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                SanPham sp = new SanPham();
                sp.setMa_san_pham(rs.getInt("ma_san_pham"));
                sp.setTenSanPham(rs.getString("ten_san_pham"));
                sp.setHangSanXuat(rs.getString("hang_san_xuat"));
                sp.setGiaSanPham(rs.getInt("gia_san_pham"));
                sp.setTinhTrang(rs.getString("tinh_trang"));
                Blob b = (Blob) rs.getBlob("hinh_anh_mo_phong");
				
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
                listTren10Trieu.add(sp);

            }
            db.close();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return listTren10Trieu;
    }


	

}
