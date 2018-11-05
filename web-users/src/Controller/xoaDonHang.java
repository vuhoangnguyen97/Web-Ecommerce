package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessLogics.gioHangBL;

@WebServlet("/xoaDonHang")
public class xoaDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public xoaDonHang() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		gioHangBL gioHang = (gioHangBL) session.getAttribute("gioHang");
		
		gioHang.xoa(id);
		response.sendRedirect("trang-chu.jsp");
		
		System.out.println(gioHang.countSoLuongMua());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
