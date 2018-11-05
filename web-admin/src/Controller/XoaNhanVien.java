package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.nhanVienDAO;

/**
 * Servlet implementation class XoaNhanVien
 */
@WebServlet("/XoaNhanVien")
public class XoaNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idnhan_vien = Integer.parseInt(request.getParameter("id"));
		int xoaNV = 0;
		xoaNV = nhanVienDAO.XoaNhanVien(idnhan_vien);
		if(xoaNV != 0) {
			// xoa thanh cong - them code hien thi hinh` di
			request.getRequestDispatcher("quan-ly-nhan-vien.jsp").forward(request, response);
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
