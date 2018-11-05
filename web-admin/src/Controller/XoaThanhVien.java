package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ThanhVienDAO;

/**
 * Servlet implementation class XoaThanhVien
 */
@WebServlet("/XoaThanhVien")
public class XoaThanhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaThanhVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iduser = Integer.parseInt(request.getParameter("id"));
		int xoaTV = 0;
		xoaTV = ThanhVienDAO.XoaThanhVien(iduser);
		if(xoaTV != 0) {
			request.getRequestDispatcher("quan-ly-thanh-vien.jsp").forward(request, response);
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
