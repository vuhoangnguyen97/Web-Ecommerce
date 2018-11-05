package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.rpc.processor.generator.InterfaceSerializerGenerator;

import DAO.SanPhamDAO;
import DAO.ThanhVienDAO;
import DTO.SanPham;
import DTO.ThanhVien;

/**
 * Servlet implementation class DocCTSanPham
 */
@WebServlet("/DocCTSanPham")
public class DocCTSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocCTSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		SanPham ChiTietSanPham = SanPhamDAO.docTheoID(id);
		if(ChiTietSanPham != null) {
			response.setContentType("image/jpg");
			System.out.println("gia: " + ChiTietSanPham.getGiaSanPham());
			System.out.println("path: " + ChiTietSanPham.getHinh_anh());
			request.setAttribute("chitiet", ChiTietSanPham);
			request.getRequestDispatcher("Views/staff/chi-tiet-san-pham-nv.jsp").forward(request, response);
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
