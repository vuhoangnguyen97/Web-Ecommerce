package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.quanLyGioHang;
import JavaBeans.hoaDon;

@WebServlet("/danhSachDonHang")
public class danhSachDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public danhSachDonHang() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<hoaDon> dshd = quanLyGioHang.xemTatCa();
		request.setAttribute("dshd", dshd);
		request.getRequestDispatcher("staff-main/danh-sach-don-hang.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
