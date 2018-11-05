package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.userBL;
import Encrypt.encrypt;
import JavaBeans.user;

@WebServlet("/dangKyServlet")
public class dangKyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public dangKyServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String username = request.getParameter("txtUsername");
		String password = request.getParameter("txtPassword");
		String ho_user = request.getParameter("txtHo");
		String ten_user = request.getParameter("txtTen");
		int sdt = Integer.parseInt(request.getParameter("txtSDT"));
		String email = request.getParameter("txtEmail");
		String dia_chi = request.getParameter("txtDiaChi");
		String quan = request.getParameter("txtQuan");
		String phuong = request.getParameter("txtPhuong");
		String thanh_pho = request.getParameter("txtThanhPho");
		String nuoc = request.getParameter("txtQuocGia");
		String zip_code = request.getParameter("txtZipCode");
		
		user thanhVien = new user();
		
		thanhVien.setUsername(username);
		thanhVien.setEmail(email);
		
		thanhVien = userBL.kiemTraUser(username, email);
		if(thanhVien == null) {
			thanhVien = new user();
			String usernameEncrypt = encrypt.hashWith256(username);
			String passwordEncrypt = encrypt.hashWith256(password);
			thanhVien.setUsername(usernameEncrypt);
			thanhVien.setPassword(passwordEncrypt);
			thanhVien.setHo_user(ho_user);
			thanhVien.setTen_user(ten_user);
			thanhVien.setSdt(sdt);
			thanhVien.setEmail(email);
			thanhVien.setDia_chi(dia_chi);
			thanhVien.setQuan(quan);
			thanhVien.setPhuong(phuong);
			thanhVien.setThanh_pho(thanh_pho);
			thanhVien.setNuoc(nuoc);
			thanhVien.setZip_code(zip_code);
			int dangKyThanhVien = userBL.dangKy(thanhVien);
			if(dangKyThanhVien != 0) {
				request.getRequestDispatcher("dang-ky-thanh-cong.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("dang-ky-loi.jsp");
			}
		}
		else {
			response.sendRedirect("loi-dang-ky.jsp");
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
