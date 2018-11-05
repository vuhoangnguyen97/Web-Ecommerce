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

@WebServlet("/timTheoNhuCau")
public class timTheoNhuCau extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public timTheoNhuCau() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int options = Integer.parseInt(request.getParameter("opt"));
		String nhucau = null;
		List<sanPham> dssp_nhucau = null;
		switch(options) {
			case 1:
				nhucau = "2 Sim";
				dssp_nhucau = sanPhamBL.dssp_nhucau(nhucau);
				request.setAttribute("dssp_nhucau", dssp_nhucau);
				request.getRequestDispatcher("san-pham-nhu-cau.jsp").forward(request, response);
				break;
			case 2:
				nhucau = "Nghe nhạc";
				dssp_nhucau = sanPhamBL.dssp_nhucau(nhucau);
				request.setAttribute("dssp_nhucau", dssp_nhucau);
				request.getRequestDispatcher("san-pham-nhu-cau.jsp").forward(request, response);				
				break;
			case 3:
				nhucau = "Chụp ảnh";
				dssp_nhucau = sanPhamBL.dssp_nhucau(nhucau);
				request.setAttribute("dssp_nhucau", dssp_nhucau);
				request.getRequestDispatcher("san-pham-nhu-cau.jsp").forward(request, response);
				break;
			case 4:
				nhucau = "Giải trí";
				dssp_nhucau = sanPhamBL.dssp_nhucau(nhucau);
				request.setAttribute("dssp_nhucau", dssp_nhucau);
				request.getRequestDispatcher("san-pham-nhu-cau.jsp").forward(request, response);
				break;
			case 5:
				// Camera > 8MP
				break;
			case 6:
				nhucau = "4G";
				dssp_nhucau = sanPhamBL.dssp_nhucau(nhucau);
				request.setAttribute("dssp_nhucau", dssp_nhucau);
				request.getRequestDispatcher("san-pham-nhu-cau.jsp").forward(request, response);
				break;
			case 7:
				nhucau = "Xem phim";
				dssp_nhucau = sanPhamBL.dssp_nhucau(nhucau);
				request.setAttribute("dssp_nhucau", dssp_nhucau);
				request.getRequestDispatcher("san-pham-nhu-cau.jsp").forward(request, response);
				break;
			case 8:
				nhucau = "Màn hình lớn";
				dssp_nhucau = sanPhamBL.dssp_nhucau(nhucau);
				request.setAttribute("dssp_nhucau", dssp_nhucau);
				request.getRequestDispatcher("san-pham-nhu-cau.jsp").forward(request, response);
				break;
			case 9:
				nhucau = "Sạc pin nhanh";
				dssp_nhucau = sanPhamBL.dssp_nhucau(nhucau);
				request.setAttribute("dssp_nhucau", dssp_nhucau);
				request.getRequestDispatcher("san-pham-nhu-cau.jsp").forward(request, response);
				break;
			case 10:
				nhucau = "Bảo mật vân tay";
				dssp_nhucau = sanPhamBL.dssp_nhucau(nhucau);
				request.setAttribute("dssp_nhucau", dssp_nhucau);
				request.getRequestDispatcher("san-pham-nhu-cau.jsp").forward(request, response);
				break;
			case 11:
				nhucau = "Chống nước, chống bụi";
				dssp_nhucau = sanPhamBL.dssp_nhucau(nhucau);
				request.setAttribute("dssp_nhucau", dssp_nhucau);
				request.getRequestDispatcher("san-pham-nhu-cau.jsp").forward(request, response);
				break;
			case 12:
				// pin > 3000
				break;
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
