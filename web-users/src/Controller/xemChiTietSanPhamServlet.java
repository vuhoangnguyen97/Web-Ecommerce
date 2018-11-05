package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.sanPhamBL;
import JavaBeans.sanPham;

@WebServlet("/xemChiTietSanPhamServlet")

public class xemChiTietSanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public xemChiTietSanPhamServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		sanPham chiTietSanPham = sanPhamBL.docTheoID(id);
		if(chiTietSanPham != null) {
			response.setContentType("image/jpg");
			System.out.println("gia: " + chiTietSanPham.getGiaSanPham());
			System.out.println("path: " + chiTietSanPham.getHinh_anh());
			request.setAttribute("chitiet", chiTietSanPham);
			request.getRequestDispatcher("chi-tiet-san-pham.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
