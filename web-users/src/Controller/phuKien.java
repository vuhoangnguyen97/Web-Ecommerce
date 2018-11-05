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

@WebServlet("/phuKien")
public class phuKien extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public phuKien() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int options = Integer.parseInt(request.getParameter("loaiPK"));
		
		switch(options) {
			case 1:
				List<sanPham> ds_oplung = sanPhamBL.phuKien("Ốp lưng");
				request.setAttribute("dspk", ds_oplung);
				request.getRequestDispatcher("phu-kien.jsp").forward(request, response);
				break;
			case 2:
				List<sanPham> ds_sacduphong = sanPhamBL.phuKien("Sạc dự phòng");
				request.setAttribute("dspk", ds_sacduphong);
				request.getRequestDispatcher("phu-kien.jsp").forward(request, response);
				break;
			case 3:
				List<sanPham> ds_tainghe = sanPhamBL.phuKien("Tai nghe");
				request.setAttribute("dspk", ds_tainghe);
				request.getRequestDispatcher("phu-kien.jsp").forward(request, response);
				break;
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
