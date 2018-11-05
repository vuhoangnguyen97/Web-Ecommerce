package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.sanPhamBL;
import JavaBeans.sanPham;

/**
 * Servlet implementation class soSanhServlet
 * 
 */
@WebServlet("/soSanhServlet")
public class soSanhServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public soSanhServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		sanPham sp = sanPhamBL.docTheoID(id);
		String hangSanPham = sp.getHangSanXuat();
		List<sanPham> dsSanPhamTheoHang = sanPhamBL.timKiemTheoHang(hangSanPham);
		String tenSanPhamSoSanh = sp.getTenSanPham();
		request.setAttribute("spCanSoSanh", sp);
		request.setAttribute("dsSanPhamTheoHang", dsSanPhamTheoHang);
		request.getRequestDispatcher("so-sanh").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
