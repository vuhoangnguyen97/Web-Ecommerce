package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.sanPhamBL;
import JavaBeans.sanPham;

/**
 * Servlet implementation class compareProduct
 */
@WebServlet("/compareProduct")
public class compareProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public compareProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idSanPham = Integer.parseInt(request.getParameter("cboSanPhamCanSoSanh"));
		int idSanPhamSoSanh = Integer.parseInt(request.getParameter("cboSanPhamSoSanh"));
		
		sanPham sp = sanPhamBL.docTheoID(idSanPham);
		sanPham spSoSanh = sanPhamBL.docTheoID(idSanPhamSoSanh);
		
		request.setAttribute("sp", sp);
		request.setAttribute("spSoSanh", spSoSanh);
		
		request.getRequestDispatcher("ket-qua-so-sanh").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
