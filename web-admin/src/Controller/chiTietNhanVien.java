package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.nhanVienDAO;
import DTO.nhanVien;

/**
 * Servlet implementation class chiTietNhanVien
 */
@WebServlet("/chiTietNhanVien")
public class chiTietNhanVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public chiTietNhanVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/** mo roi ma`
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		nhanVien ChiTietNhanVien = nhanVienDAO.docTheoID(id);		
		if(ChiTietNhanVien != null) {
			System.out.println("Chuc vu "+ ChiTietNhanVien.getChuc_vu()); 
			response.setContentType("image/jpg");
			request.setAttribute("chitiet", ChiTietNhanVien);
			request.getRequestDispatcher("Views/chi-tiet-nhan-vien.jsp").forward(request, response);
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
