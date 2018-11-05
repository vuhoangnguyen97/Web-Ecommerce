package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.ws.runtime.dev.Session;

import DAO.SanPhamDAO;
import DTO.SanPham;

/**
 * Servlet implementation class DocSanPham
 */
@WebServlet("/DocSanPham")
public class DocSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SanPham> dsSanPham = SanPhamDAO.DocTatCa();
		int size = dsSanPham.size(); // rs.Last();
		request.setAttribute("dssp", dsSanPham); //set là trả dữ liệu về cho USERS
		
		HttpSession session = request.getSession();  // sessions + cookies. 
		session.setAttribute("size", size);
		
		System.out.println(size + "");
		
		request.getRequestDispatcher("Views/danh-sach-san-pham.jsp").include(request, response);
		//Lệnh trên sau khi trả KQ cho USERS thì nó sẽ trả lại trang danh-sach-san-pham.jsp để in ra KQ. CÒn include(request, response) bắt buộc có.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
