package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;



import DAO.SanPhamDAO;
import DTO.SanPham;

/**
 * Servlet implementation class timSPTheoHang
 */
@WebServlet("/timSPTheoHang")
public class timSPTheoHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timSPTheoHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brand = request.getParameter("brand");
		List<SanPham> timKiemTheoHang = SanPhamDAO.timKiemTheoHang(brand);
		if(timKiemTheoHang != null) {
			
			System.out.println(timKiemTheoHang.size());
			response.setContentType("image/jpg");
			request.setAttribute("dsach_theohang", timKiemTheoHang);
			request.setAttribute("brand", brand);
			
			request.getRequestDispatcher("san-pham-tim-theo-hang.jsp").forward(request, response);
			
		}
		else{
			request.getRequestDispatcher("Views/loi.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
