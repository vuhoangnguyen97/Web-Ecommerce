package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessLogics.resetPasswordDAO;
import BusinessLogics.userBL;
import Encrypt.encrypt;

/**
 * Servlet implementation class updatePassword
 */
@WebServlet("/updatePassword")
public class updatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String matkhaumoi = encrypt.hashWith256(request.getParameter("txtMatKhauMoi"));
		HttpSession session = request.getSession();
		int update = 0;
		int iduser = Integer.parseInt(session.getAttribute("iduser").toString());		
		update = userBL.updatePassword(iduser, matkhaumoi);
		if(update!=0) {
			int delete = resetPasswordDAO.deleteToken(iduser);
			request.getRequestDispatcher("dang-nhap").forward(request, response);
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
