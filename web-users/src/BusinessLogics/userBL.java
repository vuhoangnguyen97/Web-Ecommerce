package BusinessLogics;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Encrypt.encrypt;
import JavaBeans.user;

public class userBL {
	// insert new member
	public static int dangKy(user thanhVien) {
		int status=0;
		int the_tich_diem = 0;
		Connection db = Database.connect();
		try {
			Statement stm = db.createStatement();
	        ResultSet rs = stm.executeQuery("SELECT id_the_tich_diem FROM user order by iduser desc Limit 1;");
	        while (rs.next()){
	            the_tich_diem = rs.getInt("id_the_tich_diem");

	        }
	        the_tich_diem+=1;
	        PreparedStatement pst2 = db.prepareStatement("INSERT INTO the_tich_diem(id_the_tich_diem) VALUES(?)");
	        //PreparedStatement pst = db.prepareStatement("INSERT INTO user(username, password, ho_user, ten_user, email, id_the_tich_diem) VALUES(?,?,?,?,?,?)");

			
			PreparedStatement pst = db.prepareStatement("INSERT INTO user(username, password, ho_user, ten_user, sdt, email, dia_chi, quan, phuong, thanh_pho, nuoc, zip_code, id_the_tich_diem) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pst.setString(1, encrypt.hashWithMD5(thanhVien.getUsername()));
			pst.setString(2, encrypt.hashWithMD5(thanhVien.getPassword()));
			pst.setString(3, thanhVien.getHo_user());
			pst.setString(4, thanhVien.getTen_user());
			pst.setInt(5, thanhVien.getSdt());
			pst.setString(6, thanhVien.getEmail());
			pst.setString(7, thanhVien.getDia_chi());
			pst.setString(8,thanhVien.getQuan());
			pst.setString(9, thanhVien.getPhuong());
			pst.setString(10, thanhVien.getThanh_pho());
			pst.setString(11, thanhVien.getNuoc());
			pst.setString(12, thanhVien.getZip_code());
			pst.setInt(13, the_tich_diem);
			
			pst2.setInt(1, the_tich_diem);
			int stt_the_tich_diem = pst2.executeUpdate();

			
			status = pst.executeUpdate();
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	// login
	public static user DocTheoUsernamePassword(String username, String password) {
		user thanhVienDangNhap = null;
		Connection db = Database.connect();
		Statement stm;
		String key = "Bar12345Bar12345"; // 128 bit key
        String initVector = "RandomInitVector"; // 16 bytes IV
		
		try {
			stm = db.createStatement();
			String sql = "SELECT * FROM user where username = ?  and password = ? ;";
			PreparedStatement pst = db.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				thanhVienDangNhap = new user();
				thanhVienDangNhap.setIduser(rs.getInt("iduser"));
				thanhVienDangNhap.setPassword(rs.getString("password"));
				thanhVienDangNhap.setHo_user(rs.getString("ho_user"));
				thanhVienDangNhap.setTen_user(rs.getString("ten_user"));
				thanhVienDangNhap.setSdt(rs.getInt("sdt"));
				thanhVienDangNhap.setEmail(rs.getString("email"));
				thanhVienDangNhap.setDia_chi(encrypt.decryptAES(key, initVector, rs.getString("dia_chi")));
				thanhVienDangNhap.setQuan(encrypt.decryptAES(key, initVector, rs.getString("quan")));
				thanhVienDangNhap.setPhuong(encrypt.decryptAES(key, initVector, rs.getString("phuong")));
				thanhVienDangNhap.setThanh_pho(encrypt.decryptAES(key, initVector, rs.getString("thanh_pho")));
				thanhVienDangNhap.setNuoc(rs.getString("nuoc"));
				thanhVienDangNhap.setZip_code(rs.getString("zip_code"));
				thanhVienDangNhap.setId_the_tich_diem(rs.getInt("id_the_tich_diem"));
			}
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return thanhVienDangNhap;
	}
	
	// đọc info, để discount khi thanh toán
	public static user readUser(int iduser) {
		user u = null;		
		try {
			Connection db = Database.connect();
			String sql = "SELECT user.ten_user, loai_the.loai_the, the_tich_diem.diem" +
                    "FROM hthong_muaban.user " +
                    "inner join the_tich_diem on the_tich_diem.id_the_tich_diem = user.id_the_tich_diem" +
                    "inner join loai_the on loai_the.id_loai_the = the_tich_diem.id_loai_the" +
                    "where user.iduser = ?";
			PreparedStatement pst = db.prepareStatement(sql);
			pst.setInt(1, iduser);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				u = new user();
                u.setTen_user(rs.getString("ten_user"));
                u.setLoai_the(rs.getString("loai_the"));
                u.setDiem(rs.getInt("diem"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	// reset password
	public static user ResetPassword(String username, String email) {
		user thanhVienQuenMatKhau = null;
		Connection db = Database.connect();
		//Statement stm;
		
		try {
			//stm = db.createStatement();
			String sql = "select*from user where username = ? and email = ?";
			PreparedStatement pst = db.prepareStatement(sql);
			pst.setString(1, encrypt.hashWithMD5(username));
			pst.setString(2, email);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				thanhVienQuenMatKhau = new user();
				thanhVienQuenMatKhau.setIduser(rs.getInt("iduser"));
				thanhVienQuenMatKhau.setUsername(rs.getString("username"));
				thanhVienQuenMatKhau.setPassword(rs.getString("password"));
				thanhVienQuenMatKhau.setHo_user(rs.getString("ho_user"));
				thanhVienQuenMatKhau.setTen_user(rs.getString("ten_user"));
				thanhVienQuenMatKhau.setSdt(rs.getInt("sdt"));
				thanhVienQuenMatKhau.setEmail(rs.getString("email"));
				thanhVienQuenMatKhau.setDia_chi(rs.getString("dia_chi"));
				thanhVienQuenMatKhau.setThanh_pho(rs.getString("thanh_pho"));
				thanhVienQuenMatKhau.setNuoc(rs.getString("nuoc"));
				thanhVienQuenMatKhau.setZip_code(rs.getString("zip_code"));
			}
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return thanhVienQuenMatKhau;		
	}
	
	//read all
	public static List<user> docTatCa(){
		List<user> dstv = new ArrayList<user>();
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			ResultSet rs = stm.executeQuery("select*from user");
			
			while(rs.next()) {
				user thanhVien = new user();
				thanhVien.setIduser(rs.getInt("iduser"));
				thanhVien.setUsername(rs.getString("username"));
				thanhVien.setPassword(rs.getString("password"));
				thanhVien.setHo_user(rs.getString("ho_user"));
				thanhVien.setTen_user(rs.getString("ten_user"));
				thanhVien.setSdt(rs.getInt("sdt"));
				thanhVien.setEmail(rs.getString("email"));
				thanhVien.setDia_chi(rs.getString("dia_chi"));
				thanhVien.setQuan(rs.getString("quan"));
				thanhVien.setPhuong(rs.getString("phuong"));
				thanhVien.setThanh_pho(rs.getString("thanh_pho"));
				thanhVien.setNuoc(rs.getString("nuoc"));
				thanhVien.setZip_code(rs.getString("zip_code"));
				dstv.add(thanhVien);
			}
			db.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dstv;
	}
	
	
	public static user kiemTraUser(String username, String email) {
		user nd = null;
		Connection db = Database.connect();
		try {
			//Statement stm = db.createStatement();
			String sql = "select*from user u where u.username = ? and u.email = ?";			
			PreparedStatement pst = db.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, email);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				nd = new user();
				nd.setIduser(rs.getInt("iduser"));
				nd.setUsername(rs.getString("username"));
				nd.setPassword(rs.getString("password"));
				nd.setHo_user(rs.getString("ho_user"));
				nd.setTen_user(rs.getString("ten_user"));
				nd.setSdt(rs.getInt("sdt"));
				nd.setEmail(rs.getString("email"));
				nd.setDia_chi(rs.getString("dia_chi"));
				nd.setQuan(rs.getString("quan"));
				nd.setPhuong(rs.getString("phuong"));
				nd.setThanh_pho(rs.getString("thanh_pho"));
				nd.setNuoc(rs.getString("nuoc"));
				nd.setZip_code(rs.getString("zip_code"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nd;
	}
	
	//Update Password
	public static int updatePassword(int iduser, String newPassword){
        int update = 0;
        try {
            Connection db = Database.connect();
            String sql = "UPDATE `user` SET `password`=?  WHERE `iduser`= ?;";
            PreparedStatement pst = db.prepareStatement(sql);
            pst.setString(1, encrypt.hashWithMD5(newPassword));
            pst.setInt(2, iduser);

            update = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return update;
    }
}
