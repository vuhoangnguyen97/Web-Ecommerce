package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDAO;

/**
 * Servlet implementation class XoaSanPham
 */
@WebServlet("/XoaSanPham")
public class XoaSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ma_san_pham = Integer.parseInt(request.getParameter("id"));
		int xoaSP =0;
		xoaSP = SanPhamDAO.XoaSanPham(ma_san_pham);
		if(xoaSP != 0 ) {
			request.getRequestDispatcher("quan-ly-san-pham.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("loi.jsp");
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
