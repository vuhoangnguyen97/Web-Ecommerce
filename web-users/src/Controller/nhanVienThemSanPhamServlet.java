package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JavaBeans.sanPham;

@WebServlet("/nhanVienThemSanPhamServlet")
public class nhanVienThemSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public nhanVienThemSanPhamServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ten_san_pham = request.getParameter("txtTenSanPham");
		String hang_san_xuat = request.getParameter("txtHang");
		int gia_san_pham = Integer.parseInt(request.getParameter("txtGiaSanPham"));
		String tinh_trang = request.getParameter("txtTinhTrang");
		String hinh_anh = request.getParameter("txtHinh");
		String camera_truoc = request.getParameter("txtCameraTruoc");
		String camera_sau = request.getParameter("txtCameraSau");
		String dung_luong_pin = request.getParameter("txtDungLuongPin");
		String tinh_nang = request.getParameter("txtTinhNang");
		String bao_mat = request.getParameter("txtBaoMat");
		String mau_sac = request.getParameter("txtMauSac");
		
		sanPham sanPhamMoi = new sanPham();
		sanPhamMoi.setTenSanPham(ten_san_pham);
		sanPhamMoi.setHangSanXuat(hang_san_xuat);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
