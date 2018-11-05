package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import DAO.DonHangDAO;
import DAO.SanPhamDAO;
import DAO.ThanhVienDAO;
import DAO.nhanVienDAO;
import DTO.DonHang;
import DTO.SanPham;
import DTO.ThanhVien;
import DTO.nhanVien;
import serverConnections.serverCount;

@WebServlet("/nhanVienDangNhap")
public class nhanVienDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public nhanVienDangNhap() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username, password;
		username = request.getParameter("user");
		password = request.getParameter("password");
		nhanVien nv_dangnhap = nhanVienDAO.docTheoUsernamePassword(username, password);
		if(nv_dangnhap != null) {
			HttpSession session = request.getSession();
			session.setAttribute("staff", nv_dangnhap);
			List<ThanhVien> dsThanhVien = ThanhVienDAO.DocTatCa();
			List<DonHang> dsDonHang = DonHangDAO.DocTatCa();
			List<SanPham> dsSanPham = SanPhamDAO.DocTatCa();
			int count = serverCount.count();
			request.setAttribute("countUser", dsThanhVien.size());
			request.setAttribute("countDonHang", dsDonHang.size());
			request.setAttribute("countSanPham", dsSanPham.size());
			request.setAttribute("countUserNow", count);
			
			request.getRequestDispatcher("cong-viec").forward(request, response);;
		}
		else {
			response.sendRedirect("log-in-staff");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
