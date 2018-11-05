package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.sanPhamBL;
import JavaBeans.sanPham;

@WebServlet("/timTheoDungLuongPin")
public class timTheoDungLuongPin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public timTheoDungLuongPin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<sanPham> dssp_theoPin = sanPhamBL.timTheoDungLuongPin(3000);
		if(dssp_theoPin != null) {
			request.setAttribute("dspin", dssp_theoPin);
			request.getRequestDispatcher("danh-sach-theo-pin.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
