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

@WebServlet("/timTheoHangSanPham")
public class timTheoHangSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public timTheoHangSanPham() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brand = request.getParameter("hang");
		List<sanPham> timKiemTheoHang = sanPhamBL.timKiemTheoHang(brand);
		if(timKiemTheoHang != null) {
			System.out.println(timKiemTheoHang.size());
			request.setAttribute("dsach_theohang", timKiemTheoHang);
			request.getRequestDispatcher("san-pham-theo-hang.jsp").forward(request, response);
			
		}
		else{
			request.getRequestDispatcher("loi.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
