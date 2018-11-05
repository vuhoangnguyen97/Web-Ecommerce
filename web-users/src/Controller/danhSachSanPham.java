package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.sanPhamBL;
import BusinessLogics.userBL;
import JavaBeans.sanPham;
import JavaBeans.user;

@WebServlet("/danhSachSanPham")
public class danhSachSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public danhSachSanPham() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<sanPham> dssp = sanPhamBL.DocTatCa();
		request.setAttribute("danhSachSanPham", dssp);
		request.getRequestDispatcher("/staff-main/danh-sach-san-pham.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
