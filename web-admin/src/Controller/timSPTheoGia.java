package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import DAO.SanPhamDAO;
import DTO.SanPham;

/**
 * Servlet implementation class timSPDuoi1Trieu
 */
@WebServlet("/timSPTheoGia")
public class timSPTheoGia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timSPTheoGia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		/* chú thích:
		 * 1: giá dưới 1 triệu
		 * 2: giá từ 1-3 triệu
		 * 3: giá từ 3-7 triệu
		 * 4: giá từ 7-10 triệu
		 */
		
		int options = Integer.parseInt(request.getParameter("options"));
		
		switch(options) {
			// giá dưới 1 triệu
			case 1:
				List<SanPham> dssp_giaDuoi1Trieu = SanPhamDAO.timTheoGiaDuoi1Trieu();				
				int size = dssp_giaDuoi1Trieu.size();
				request.setAttribute("size", size);
				if(dssp_giaDuoi1Trieu.isEmpty() == true) {
					System.out.println("Empty");
				}
				else {
					System.out.println(dssp_giaDuoi1Trieu.size());
					request.setAttribute("dssp_duoi1Trieu", dssp_giaDuoi1Trieu);
					request.getRequestDispatcher("san-pham-duoi-1-trieu.jsp").forward(request, response);
				}
				break;
				
			// giá từ 1-3 triệu
			case 2:
				List<SanPham> dssp_giaTu1Den3Trieu = SanPhamDAO.timTheoGia1TrieuDen3Trieu();				
				if(dssp_giaTu1Den3Trieu.isEmpty() == true) {
					System.out.println("Empty");
				}
				else {
					System.out.println(dssp_giaTu1Den3Trieu.size());
					request.setAttribute("dssp_1Den3Trieu", dssp_giaTu1Den3Trieu);
					request.getRequestDispatcher("san-pham-1-den-3-trieu.jsp").forward(request, response);
				}				
				break;
				
			//  giá từ 3-7 triệu
			case 3:
				List<SanPham> dssp_giaTu3Den7Trieu = SanPhamDAO.timTheoGia3TrieuDen7Trieu();
				if(dssp_giaTu3Den7Trieu.isEmpty() == true) {
					System.out.println("Empty");
				}
				else {
					request.setAttribute("dssp_3Den7Trieu", dssp_giaTu3Den7Trieu);
					request.getRequestDispatcher("san-pham-3-den-7-trieu.jsp").forward(request, response);
					System.out.println(dssp_giaTu3Den7Trieu.size());
				}				
				break;
								
			//  giá từ 7-10 triệu
			case 4:
				List<SanPham> dssp_giaTu7Den10Trieu = SanPhamDAO.timTheoGia7TrieuDen10Trieu();
				if(dssp_giaTu7Den10Trieu.isEmpty() == true) {
					System.out.println("Empty");
				}
				else {
					request.setAttribute("dssp_7Den10Trieu", dssp_giaTu7Den10Trieu);
					request.getRequestDispatcher("san-pham-7-den-10-trieu.jsp").forward(request, response);
					System.out.println(dssp_giaTu7Den10Trieu.size());
				}	
				
				break;
			
				//Trên 10 triệu
			case 5:
				List<SanPham> dssp_tren10Trieu = SanPhamDAO.timTheoGiaTren10Trieu();
				if(dssp_tren10Trieu.isEmpty() == true) {
					System.out.println("Empty");
				}
				else {
					request.setAttribute("dssp_tren10Trieu", dssp_tren10Trieu);
					request.getRequestDispatcher("san-pham-tren-10-trieu.jsp").forward(request, response);
					System.out.println(dssp_tren10Trieu.size());
				}	
				
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
