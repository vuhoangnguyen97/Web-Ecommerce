package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessLogics.resetPasswordDAO;
import JavaBeans.resetPass;

/**
 * Servlet implementation class xacNhanToken
 */
@WebServlet("/xacNhanToken")
public class xacNhanToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xacNhanToken() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maToken = request.getParameter("txtMaXacNhan");
		// Kiem tra co trong csdl ? 
		resetPass resetPass = resetPasswordDAO.readTokenKey(maToken);
		if(resetPass!=null) {
			// kiem tra thoi gian hieu luc
			long expire = resetPasswordDAO.checkToken(maToken);
			if(expire>0) {
				// còn hieu luc
				int iduser = resetPass.getIduser();
				HttpSession session = request.getSession();
				session.setAttribute("iduser", iduser);
				request.getRequestDispatcher("reset-password.jsp").forward(request, response);
			}
			else {
				// het hieu luc
				response.sendRedirect("het-han.jsp");
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
