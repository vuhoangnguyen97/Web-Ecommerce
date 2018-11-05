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

@WebServlet("/timTheoMauSac")
public class timTheoMauSac extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public timTheoMauSac() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int opt = Integer.parseInt(request.getParameter("mauSac"));
		String mauSac = null;
		List<sanPham> timTheoMauSac = null;
		switch(opt) {
			case 1:
				mauSac = "đỏ";
				timTheoMauSac = sanPhamBL.timTheoMauSac(mauSac);
				break;
			case 2:
				mauSac = "vàng";
				timTheoMauSac = sanPhamBL.timTheoMauSac(mauSac);
				break;
			case 3:
				mauSac = "đen";
				timTheoMauSac = sanPhamBL.timTheoMauSac(mauSac);
				break;
			case 4:
				mauSac = "hồng";
				timTheoMauSac = sanPhamBL.timTheoMauSac(mauSac);
				break;
		}
		
		if(timTheoMauSac != null) {
			System.out.println(timTheoMauSac.size());
			request.setAttribute("timTheoMauSac", timTheoMauSac);
			request.getRequestDispatcher("san-pham-mau.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
