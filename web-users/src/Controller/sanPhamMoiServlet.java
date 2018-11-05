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


@WebServlet("/sanPhamMoiServlet")
public class sanPhamMoiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public sanPhamMoiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<sanPham> dssp_new = sanPhamBL.SanPhamMoi(4);
		List<sanPham> dssp_bottom = sanPhamBL.SanPhamBottom(4);
		List<sanPham> dssp_giaRe = sanPhamBL.timTheoGiaDuoi1TrieuMain();
		List<sanPham> dssp_giaRe1TrieuDen3Trieu = sanPhamBL.timTheoGia1TrieuDen3TrieuMain();
		response.setContentType("image/jpg");
		request.setAttribute("dssp",dssp_new);
		request.setAttribute("dssp_bottom", dssp_bottom);
		request.setAttribute("dssp_Re",dssp_giaRe);
		request.setAttribute("dssp_ReTren1Trieu", dssp_giaRe1TrieuDen3Trieu);
		request.getRequestDispatcher("Views/san-pham-main.jsp").include(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
