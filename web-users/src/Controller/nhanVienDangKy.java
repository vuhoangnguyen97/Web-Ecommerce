package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.nhanVienBL;
import JavaBeans.nhanVien;

@WebServlet("/nhanVienDangKy")
public class nhanVienDangKy extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public nhanVienDangKy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		String ho_nhan_vien = request.getParameter("hoNhanVien");
		String ten_nhan_vien = request.getParameter("nameNhanVien");
		String email = request.getParameter("emailNhanVien");
		int sdt = Integer.parseInt(request.getParameter("sdtNhanVien"));
		
		nhanVien nv_dangky = new nhanVien();
		nv_dangky.setUsername(username);
		nv_dangky.setPassword(password);
		nv_dangky.setHo_nhan_vien(ho_nhan_vien);
		nv_dangky.setTen_nhan_vien(ten_nhan_vien);
		nv_dangky.setEmail(email);
		nv_dangky.setSdt(sdt);
		
		int dki_nhanvien = nhanVienBL.dangKyNhanVien(nv_dangky);
		if(dki_nhanvien != 0) {
			request.getRequestDispatcher("Views/dang-ky-thanh-cong.jsp").forward(request, response);

		}
		else {
			request.getRequestDispatcher("Views/dang-ky-loi.jsp").forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
