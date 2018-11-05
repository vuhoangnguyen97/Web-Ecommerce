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

@WebServlet("/sanPhamHot")
public class sanPhamHot extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public sanPhamHot() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<sanPham> dssp_hot = sanPhamBL.SanPhamMoi(3);
		List<sanPham> dssp_hot2 = sanPhamBL.timTheoGia1TrieuDen3TrieuMain();
		request.setAttribute("dssp_hot", dssp_hot);
		request.setAttribute("dssp_hot2", dssp_hot2);
		request.getRequestDispatcher("Views/san-pham-hot.jsp").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
