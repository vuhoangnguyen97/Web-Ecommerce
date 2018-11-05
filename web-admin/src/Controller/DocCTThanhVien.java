package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.SanPhamDAO;
import DAO.ThanhVienDAO;
import DTO.SanPham;
import DTO.ThanhVien;

/**
 * Servlet implementation class DocCTThanhVien
 */
@WebServlet("/DocCTThanhVien")
public class DocCTThanhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocCTThanhVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ThanhVien ChiTietThanhVien = ThanhVienDAO.docTheoID(id);
		if(ChiTietThanhVien != null) {
			System.out.println("iduser: " + ChiTietThanhVien.getIduser());
			request.setAttribute("chitiet", ChiTietThanhVien);
			request.getRequestDispatcher("Views/staff/chi-tiet-thanh-vien.jsp").forward(request, response);
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
