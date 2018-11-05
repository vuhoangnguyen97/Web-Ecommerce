package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.nhanVienDAO;

/**
 * Servlet implementation class suaNhanVienController
 */
@WebServlet("/suaNhanVienController")
public class suaNhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public suaNhanVienController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		System.out.println("value: " + request.getParameter("txtIDNhanVien"));
		/* BÓ TAY, ĂN CƠM CÁI, TÍNH TIẾP
		int idnhan_vien = Integer.parseInt(request.getParameter("txtIDNhanVien"));
		System.out.println("Ma nhan vien: "+  idnhan_vien);
		String username = request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		String ho_nhan_vien = request.getParameter("txtHo");
		String ten_nhan_vien = request.getParameter("txtTen");
		String email = request.getParameter("txtEmail");
		int sdt = Integer.parseInt(request.getParameter("txtSdt"));
		int ma_chuc_vu = Integer.parseInt(request.getParameter("txtMaChucVu"));
		
		int update = nhanVienDAO.SuaNhanVien(idnhan_vien, username, password, ho_nhan_vien, ten_nhan_vien, email, sdt, ma_chuc_vu);
		if(update != 0) {
			request.getRequestDispatcher("quan-ly-nhan-vien.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("loi.jsp");
		}
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
