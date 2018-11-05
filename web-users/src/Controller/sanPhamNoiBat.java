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

@WebServlet("/sanPhamNoiBat")
public class sanPhamNoiBat extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public sanPhamNoiBat() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<sanPham> dssp_noibat = sanPhamBL.timTheoGiaDuoi1TrieuMain();
		request.setAttribute("spnoibat", dssp_noibat);
		request.getRequestDispatcher("Views/san-pham-noi-bat.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
