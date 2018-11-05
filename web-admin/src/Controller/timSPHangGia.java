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
 * Servlet implementation class timSPHangGia
 */
@WebServlet("/timSPHangGia")
public class timSPHangGia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timSPHangGia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String brand = request.getParameter("brand");
		int option = Integer.parseInt(request.getParameter("opt"));	
		List<SanPham> dsKetQua;
		switch(option){ 
			case 1: 
				dsKetQua = SanPhamDAO.timTheoHangGiaDuoi1Trieu(brand);
				response.setContentType("image/jpg");
				request.setAttribute("dsKetQua", dsKetQua);
				request.setAttribute("brandCurrent", brand);
				request.getRequestDispatcher("san-pham-hang-gia.jsp").forward(request, response);
				break;
			case 2: 
				dsKetQua = SanPhamDAO.timTheoHangGia1Den3Trieu(brand);
				response.setContentType("image/jpg");
				request.setAttribute("dsKetQua", dsKetQua);
				request.setAttribute("brandCurrent", brand);
				request.getRequestDispatcher("san-pham-hang-gia.jsp").forward(request, response);
				break;
				
			case 3: 
				dsKetQua = SanPhamDAO.timTheoHangGia3Den7rieu(brand);
				response.setContentType("image/jpg");
				request.setAttribute("dsKetQua", dsKetQua);
				request.setAttribute("brandCurrent", brand);
				request.getRequestDispatcher("san-pham-hang-gia.jsp").forward(request, response);
				break;
				
			case 4: 
				dsKetQua = SanPhamDAO.timTheoHangGia7Den10rieu(brand);
				response.setContentType("image/jpg");
				request.setAttribute("dsKetQua", dsKetQua);
				request.setAttribute("brandCurrent", brand);
				request.getRequestDispatcher("san-pham-hang-gia.jsp").forward(request, response);
				break;
			
			case 5: 
				dsKetQua = SanPhamDAO.timTheoHangGiaTren10Trieu(brand);
				response.setContentType("image/jpg");
				request.setAttribute("dsKetQua", dsKetQua);
				request.setAttribute("brandCurrent", brand);
				request.getRequestDispatcher("san-pham-hang-gia.jsp").forward(request, response);
				break;
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
