package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessLogics.gioHangBL;
import JavaBeans.sanPhamMua;
import JavaBeans.user;

/**
 * Servlet implementation class xemGioHangServlet
 */
@WebServlet("/xemGioHangServlet")
public class xemGioHangServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xemGioHangServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		gioHangBL gioHang = (gioHangBL) session.getAttribute("gioHang");
		user thanhVienMuaHang = (user) session.getAttribute("member");
		System.out.print("id: " + thanhVienMuaHang.getIduser());
		
		List<sanPhamMua> listOfSp = gioHang.danhSachSanPhamMua();
		
		if(listOfSp != null) {
			request.setAttribute("ds_spm", listOfSp);
			request.getRequestDispatcher("gio-hang.jsp").forward(request, response);
		}
		else if(listOfSp == null) {
			request.getRequestDispatcher("loi-gio-hang.jsp").forward(request, response);
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
