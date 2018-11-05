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

@WebServlet("/timKiemSanPham")
public class timKiemSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public timKiemSanPham() {
        super();
        
    }
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ten_input = request.getParameter("txtTen");
		List<sanPham> dssp_theoTen = sanPhamBL.timTheoTen(ten_input);
		if(dssp_theoTen != null) {
			System.out.println(dssp_theoTen.size());
			request.setAttribute("dssp_ten", dssp_theoTen);
			int size = dssp_theoTen.size();
			request.setAttribute("size", size);
			request.getRequestDispatcher("san-pham-tim-kiem.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("Views/loi.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
