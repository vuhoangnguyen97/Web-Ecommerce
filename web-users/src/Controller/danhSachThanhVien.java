package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.userBL;
import JavaBeans.user;

@WebServlet("/danhSachThanhVien")
public class danhSachThanhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public danhSachThanhVien() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<user> dstv = userBL.docTatCa();
		request.setAttribute("danhSachThanhVien", dstv);
		request.getRequestDispatcher("/staff-main/danh-sach-thanh-vien.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
