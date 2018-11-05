package Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import BusinessLogics.Database;
import BusinessLogics.gioHangBL;
import BusinessLogics.nhanVienBL;
import BusinessLogics.quanLyGioHang;
import BusinessLogics.sanPhamBL;
import BusinessLogics.userBL;
import JavaBeans.nhanVien;
import JavaBeans.sanPham;
import JavaBeans.user;

public class testCSDL {
	Connection con;
	Statement stm;
	
	@Before
	public void chuanBi() {
		con = Database.connect();
	}
	
	@Test
	public void testConnection() {
		assertNotNull(con);
	}
	
	@Test
	public void findAllUser() {
		// tá»•ng cá»™ng hiá»‡n táº¡i lÃ  2
		assertEquals(2 , userBL.docTatCa().size());
	}
	
	@Test
	public void findAllSanPhamFail() {
		// tá»•ng cá»™ng hiá»‡n táº¡i lÃ  47
		assertEquals(3 , sanPhamBL.DocTatCa().size());
	}
	
	@Test
	public void findAllSanPham() {
		// tá»•ng cá»™ng hiá»‡n táº¡i lÃ  47
		assertTrue(sanPhamBL.DocTatCa().size() == 47 );
	}
	
	@Test
	public void findAllGioHang() {
		assertEquals(4 , quanLyGioHang.xemTatCa().size());
	}
	
	@Test
	public void TimSanPhamID() {
		sanPham test = sanPhamBL.docTheoID(2);
		assertTrue(test.getTenSanPham().equals("iPhone 6"));
	}
	
	@Test
	public void timSanPhamTheoHang() {
		List<sanPham> dssp = sanPhamBL.timKiemTheoHang("Apple");
		assertTrue(dssp.size() == 3);
	}
	
	@Test
	public void timSanPhamTheoTen() {
		List<sanPham> dssp = sanPhamBL.timTheoTen("iphone");
		assertTrue(dssp.size() == 4);
	}
	
	@Test
	public void dangKy() {
		// test náº¿u nháº­p sÃ³t cÃ¡c trÆ°á»�ng dá»¯ liá»‡u khÃ¡c thÃ¬ bÃ¡o lá»—i
		// test case pass náº¿u thÃ´ng bÃ¡o lá»—i
		String username = "abcde";
		String password = "123456";
		user u = new user();
		u.setUsername(username);
		u.setPassword(password);
		
		int them = userBL.dangKy(u);
		assertTrue(them > 0);
	}
	
	@Test
	public void dangNhapUser() {
		// Ä‘Äƒng nháº­p Ä‘Ãºng
		String user = "test";
		String pass = "test";
		
		user u = userBL.DocTheoUsernamePassword(user, pass);
		assertTrue(u != null);
	}
	
	@Test
	public void dangNhapUserSai() {
		// Ä‘Äƒng nháº­p Ä‘Ãºng
		// Test case pass náº¿u thÃ´ng bÃ¡o lá»—i
		String user = "test";
		String pass = "test1";
		
		user u = userBL.DocTheoUsernamePassword(user, pass);
		assertTrue(u != null);
	}
	
	@Test
	public void dangKyNhanVien() {
		String user = "abc";
		String pass = "abc";
		nhanVien nv = new nhanVien();
		nv.setUsername(user);
		nv.setPassword(pass);
		int them = nhanVienBL.dangKyNhanVien(nv);
		
		assertTrue(them > 0); // sáº½ bÃ¡o lá»—i, vÃ¬ thiáº¿u vÃ o dá»¯ liá»‡u --> pass
	}
	
	@Test
	public void dangNhapNhanVien() {
		String user = "admin";
		String pass = "admin";
		nhanVien nv = nhanVienBL.docTheoUsernamePassword(user, pass);
		assertTrue(nv != null);
	}
	
	@Test
	public void userQuenMatKhau() {
		String user = "test1";
		String mail = "darkevil9712@gmail.com";
		
		user u = userBL.ResetPassword(user, mail);
		assertTrue(u != null);
	}
	
	@Test
	public void nvQuenMatKhau() {
		String user = "admin";
		String email = "admin";
		
		nhanVien nv = nhanVienBL.ResetPassword(user, email);
		assertTrue(nv != null);
	}
	
	@Test
	public void testThemGioHang() {
		gioHangBL gh = new gioHangBL();
		gh.them(1, 1);
		gh.them(1, 2);
		assertTrue(gh.countSoLuongMua() == 1);
	}
	
	@Test
	public void testXoaSPham_GioHang() {
		gioHangBL gh = new gioHangBL();
		gh.them(1, 2);
		gh.them(2, 1);
		gh.them(1, 3);
		gh.them(3, 1);
		gh.xoa(1);
		assertTrue(gh.countSoLuongMua()==2);
	}
	
	@Test
	public void testTinhTongTienMua() {
		gioHangBL gh = new gioHangBL();
		gh.them(1, 1);
		gh.them(2, 1);
		assertTrue(gh.tongTien() == 30180000);
	}
	
	@Test
	public void testTinhTongTienKhiXoaBot() {
		gioHangBL gh = new gioHangBL();
		gh.them(1, 1);
		gh.them(2, 1);
		gh.xoa(2);
		assertTrue(gh.tongTien() == 30180000);
	}
	
	@Test
	public void test() {
		
	}
}
