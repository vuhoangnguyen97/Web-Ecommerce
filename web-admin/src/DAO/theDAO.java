package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import DTO.the;
import Database.Database;

public class theDAO {
	public static List<the> DocTatCa(){
		List<the> dsThe = null;
		
		try {
			Connection db = Database.connect();
			Statement stm = db.createStatement();
			
			ResultSet rs = stm.executeQuery("SELECT the_tich_diem.id_the_tich_diem,diem_tich_luy ,the_tich_diem.id_loai_the,loai_the.loai_the, count(*) as `so_luong_the`\r\n" + 
					"FROM the_tich_diem\r\n" + 
					"JOIN loai_the ON loai_the.id_loai_the = the_tich_diem.id_loai_the\r\n" + 
					"GROUP BY id_loai_the\r\n");
			dsThe = new ArrayList<>();
			
			while(rs.next()){
				the the = new the();
				the.setId_the_tich_diem(rs.getInt("id_the_tich_diem"));				
				the.setDiem(rs.getInt("diem_tich_luy"));
				the.setLoai_the(rs.getString("loai_the"));
				the.setSo_luong(rs.getInt("so_luong_the"));				
				dsThe.add(the);		
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsThe;
	}
	
	
}
