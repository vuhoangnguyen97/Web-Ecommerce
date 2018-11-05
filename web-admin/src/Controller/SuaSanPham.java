package Controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDAO;

/**
 * Servlet implementation class SuaSanPham
 */
@WebServlet("/SuaSanPham")
public class SuaSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int ma_san_pham = Integer.parseInt(request.getParameter("txtMaSanPham"));
		System.out.println("Ma SP : " + ma_san_pham);
		String ten_san_pham = request.getParameter("txtTenSanPham");
		int gia_san_pham = Integer.parseInt(request.getParameter("txtGiaSanPham"));
		String tinh_trang = request.getParameter("txtTinhTrang");
		String camera_truoc = request.getParameter("txtCameraTruoc");
		String camera_sau = request.getParameter("txtCameraSau");
		String dung_luong_pin = request.getParameter("txtDungLuongPin");
		String tinh_nang = request.getParameter("txtTinhNang");
		String bao_mat = request.getParameter("txtBaoMat");
		String mau_sac = request.getParameter("txtMauSac");
		
		int update = SanPhamDAO.SuaSanPham(ma_san_pham, ten_san_pham, gia_san_pham, tinh_trang, camera_truoc, camera_sau, dung_luong_pin, tinh_nang, bao_mat, mau_sac);
		if(update !=0) {
			request.getRequestDispatcher("success.jsp").forward(request, response);
			
		}
		else {
			response.sendRedirect("loi.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
