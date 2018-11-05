package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessLogics.gioHangBL;

/**
 * Servlet implementation class themGioHang
 */
@WebServlet("/themGioHang")
public class themGioHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themGioHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id, soLuongMua = 1;
		
		id = Integer.parseInt(request.getParameter("id"));
		if(request.getParameter("soLuongMua") != null) {
			soLuongMua = Integer.parseInt(request.getParameter("soLuongMua"));	
		}
		
		HttpSession session = request.getSession();
		gioHangBL gioHang = (gioHangBL) session.getAttribute("gioHang");
		
		if(gioHang == null) {
			gioHang = new gioHangBL();
			session.setAttribute("gioHang", gioHang);
		}
		
		gioHang.them(id, soLuongMua);
		response.sendRedirect("trang-chu.jsp");
		
		System.out.println(gioHang.countSoLuongMua());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
