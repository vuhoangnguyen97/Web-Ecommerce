package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.loaiTheDAO;
import DTO.loaiThe;

/**
 * Servlet implementation class themLoaiThe
 */
@WebServlet("/themLoaiThe")
public class themLoaiThe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public themLoaiThe() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int id_loai_the = Integer.parseInt(request.getParameter("txtMaLoaiThe"));
		String loai_the = request.getParameter("txtLoaiThe");
		loaiThe checkLoaiThe = null;
		checkLoaiThe = loaiTheDAO.readLoaiThe(id_loai_the);
		if(checkLoaiThe!=null) {
			int loi = 1;
			request.setAttribute("id_loi", loi);
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		else {
			int themLoaiThe = 0;
			loaiThe lt = new loaiThe();
			lt.setId_loai_the(id_loai_the);
			lt.setLoai_the(loai_the);
			themLoaiThe = loaiTheDAO.ThemLoaiTheMoi(lt);
			if(themLoaiThe>0) {
				// success
				request.getRequestDispatcher("thongKeThe").forward(request, response);
			}
			else {
				try {
					throw new SQLException("ERROR MESSAGE");
				} catch (SQLException e) {
					// lỗi không kết nối dc server csdl
					int loi = 2;
					request.setAttribute("id_loi", loi);
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				catch(NullPointerException e) {
					// lỗi không kết nối dc server csdl hoặc server web sập
					int loi = 3;
					request.setAttribute("id_loi", loi);
					request.getRequestDispatcher("error.jsp").forward(request, response);
				}
				
			}
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
