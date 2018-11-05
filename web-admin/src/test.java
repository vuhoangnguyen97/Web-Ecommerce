import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import DAO.DonHangDAO;
import DAO.SanPhamDAO;
import DAO.ThanhVienDAO;
import DAO.chucVuDAO;
import DTO.DonHang;
import DTO.SanPham;
import DTO.ThanhVien;
import DTO.chucVu;
import Database.Database;
import Encryption.encrypt;

public class test {

	public static void main(String[] args) {		
		List<ThanhVien> dsThanhVien = ThanhVienDAO.DocTatCa();
		System.out.println(dsThanhVien.size());
	}
}
