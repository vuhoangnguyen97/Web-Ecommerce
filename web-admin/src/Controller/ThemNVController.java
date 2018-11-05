package Controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import Database.*;
import Encryption.encrypt;

/**
 * Servlet implementation class ThemNVController
 */
@WebServlet("/ThemNVController")
@MultipartConfig(location = "D:\\Android\\HinhDB\\NV"
, fileSizeThreshold = 1024 * 1024
, maxFileSize = 1024 * 1024 * 5
, maxRequestSize = 1024 * 1024 * 5 * 5)

public class ThemNVController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemNVController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("txtMaNhanVien"));
		System.out.println("id: " + id);
		String username = request.getParameter("txtusername");
		String password = request.getParameter("txtpassword");
		//password = encrypt.hashWith256(password); // ma hoa password
		String ho_nhan_vien = request.getParameter("txtHoNhanVien");
		String ten_nhan_vien = request.getParameter("txtTenNhanVien");
		String email = request.getParameter("txtEmail");
		int sdt = Integer.parseInt(request.getParameter("txtsdt"));
		int ma_chuc_vu = Integer.parseInt(request.getParameter("txtMaChucVu"));
		System.out.println("Ma chuc vu: " +  ma_chuc_vu); 
		InputStream inputStream = null;
		
		Part hinhNhanVien = request.getPart("txtHinhNhanVien");
		
		System.out.println(hinhNhanVien.getName());
		System.out.println(hinhNhanVien.getSize());
		System.out.println(hinhNhanVien.getContentType());
		// obtains input stream of the upload file
        inputStream = hinhNhanVien.getInputStream();
        
        int upload = 0;
        Connection db = Database.connect();
        
        try {
        	String sql = "INSERT INTO nhan_vien (`idnhan_vien`, `username`, `password`, `ho_nhan_vien`, `ten_nhan_vien`, `email`, `sdt`,`hinh_nhan_vien`,`ma_chuc_vu`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			
			pst.setInt(1, id);
			pst.setString(2, username);
			pst.setString(3, password);
			pst.setString(4, ho_nhan_vien);
			pst.setString(5, ten_nhan_vien);
			pst.setString(6, email);
			pst.setInt(7, sdt);
			pst.setBlob(8, inputStream);
			pst.setInt(9, ma_chuc_vu);
			
			
			upload = pst.executeUpdate();
			
			db.close();
			
			if(upload !=0) {
				request.getRequestDispatcher("success.jsp").forward(request, response);
	
			}
			else {
				response.sendRedirect("dang-ky-loi.jsp");
			}
			
			
        
        
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(upload != 0) {
        	request.getRequestDispatcher("dang-ky-thanh-cong.jsp").forward(request, response);
        }
        else {
        	response.sendRedirect("dang-ky-loi.jsp");
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
