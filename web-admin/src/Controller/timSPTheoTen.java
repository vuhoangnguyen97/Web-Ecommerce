package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDAO;
import DTO.SanPham;

/**
 * Servlet implementation class timSPTheoTen
 */
@WebServlet("/timSPTheoTen")
public class timSPTheoTen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timSPTheoTen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ten_input = request.getParameter("txtTen");
		List<SanPham> dssp_theoTen = SanPhamDAO.timTheoTen(ten_input);	
		if(dssp_theoTen != null) {
			
			System.out.println(dssp_theoTen.size());
			response.setContentType("image/jpg");
			request.setAttribute("dssp_ten", dssp_theoTen);
			int size = dssp_theoTen.size();
			request.setAttribute("size", size);
			request.getRequestDispatcher("san-pham-tim-kiem.jsp").forward(request, response);
		}
		else {
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
