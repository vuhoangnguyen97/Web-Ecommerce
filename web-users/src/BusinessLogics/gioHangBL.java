package BusinessLogics;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.Blob;

import JavaBeans.sanPham;
import JavaBeans.sanPhamMua;

public class gioHangBL {
	Map<Integer, Integer> danhSachHang;
	
	public gioHangBL() {
		danhSachHang = new Hashtable<Integer, Integer>();
	}
	
	public void them(int id, int soLuongMua) {
		if(danhSachHang.containsKey(id)) {
			danhSachHang.replace(id, danhSachHang.get(id)+soLuongMua);
		}
		else {
			danhSachHang.put(id, soLuongMua);
		}
	}
	
	public List<sanPhamMua> danhSachSanPhamMua(){
		List<sanPhamMua> dsspm = new ArrayList<sanPhamMua>();
		
		for(Integer id:danhSachHang.keySet()) {
			sanPham sp = sanPhamBL.docTheoID(id);
			sanPhamMua spm = new sanPhamMua();
			spm.setMa_san_pham(id);
			spm.setTenSanPham(sp.getTenSanPham());
			spm.setHangSanXuat(sp.getHangSanXuat());
			spm.setGiaSanPham(sp.getGiaSanPham());
			spm.setTinh_nang(sp.getTinhTrang());
			spm.setHinh_dai_dien(sp.getHinh_dai_dien());
			
			Blob b = (Blob) sp.getHinh_dai_dien();
			
			// Tách biến blob, ra thành kiểu nhị phân ( InputStream)
			InputStream inputStream;
			try {
				inputStream = (InputStream) b.getBinaryStream();
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
				spm.setHinh_anh(base64Image);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			spm.setCamera_truoc(sp.getCamera_truoc());
			spm.setCamera_sau(sp.getCamera_sau());
			spm.setDung_luong_pin(sp.getDung_luong_pin());
			spm.setTinh_nang(sp.getTinh_nang());
			spm.setBao_mat(sp.getBao_mat());
			spm.setMau_sac(sp.getMau_sac());
			spm.setSoLuongMua(danhSachHang.get(id));
			dsspm.add(spm);
		}
		
		return dsspm;
	}
	
	public double tongTien() {
		double tt = 0;
		List<sanPhamMua> dshm = danhSachSanPhamMua();
		
		for(sanPhamMua spm: dshm)
			tt += spm.getThanhTien();
		return tt;
	}
	
	public int countSoLuongMua() {
		return danhSachHang.size();
	}
	
	public void xoa(int id) {
		danhSachHang.remove(id);
	}
	
	public void reset() {
		danhSachHang.clear();
	}
}
