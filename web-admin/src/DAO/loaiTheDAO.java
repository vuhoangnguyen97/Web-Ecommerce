package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DTO.loaiThe;
import Database.Database;

public class loaiTheDAO {

	public static List<loaiThe> DocTatCa(){
		List<loaiThe> dsLoaiThe = null;
		
		
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			
			ResultSet rs= stm.executeQuery("SELECT * FROM loai_the");
			dsLoaiThe = new ArrayList<>();
			
			while (rs.next()) {
				loaiThe lt = new loaiThe();
				lt.setId_loai_the(rs.getInt("id_loai_the"));
				lt.setLoai_the(rs.getString("loai_the"));
				
				dsLoaiThe.add(lt);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsLoaiThe;
	}
	
	public static int ThemLoaiTheMoi(loaiThe lt) {
		int them = 0;		
		try {
			Connection db = Database.connect();
			String sql = "INSERT INTO loai_the (`id_loai_the`, `loai_the`) VALUES (?, ?)";
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			
			pst.setInt(1, lt.getId_loai_the());
			pst.setString(2, lt.getLoai_the());
			
			them =  pst.executeUpdate();
			db.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return them;
	}
	
	public static loaiThe readLoaiThe(int maLoaiThe) {
		loaiThe lt = null;		
		try {
			Connection db = Database.connect();
			String sql = "SELECT * FROM loai_the where id_loai_the = ?;";
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			pst.setInt(1, maLoaiThe);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				lt = new loaiThe();
				lt.setId_loai_the(rs.getInt("id_loai_the"));
				lt.setLoai_the(rs.getString("loai_the"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
}
