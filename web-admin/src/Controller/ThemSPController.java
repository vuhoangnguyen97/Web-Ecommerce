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

import Database.Database;

/**
 * Servlet implementation class ThemSPController
 */
@WebServlet("/ThemSPController")
@MultipartConfig(location = "D:\\Android\\HinhDB\\SP"
, fileSizeThreshold = 1024 * 1024
, maxFileSize = 1024 * 1024 * 5
, maxRequestSize = 1024 * 1024 * 5 * 5)

public class ThemSPController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemSPController() {
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
		
		int maSanPham = Integer.parseInt(request.getParameter("txtMaSanPham"));
		String tenSanPham = request.getParameter("txtTenSanPham");
		String hangSanXuat = request.getParameter("txtHangSanXuat");
		int giaSanPham = 1;
		
		InputStream inputStream = null;
		
		Part hinhDaiDien = request.getPart("txtHinhSanPham");
		
		System.out.println(hinhDaiDien.getName());
		System.out.println(hinhDaiDien.getSize());
		System.out.println(hinhDaiDien.getContentType());
		// obtains input stream of the upload file
        inputStream = hinhDaiDien.getInputStream();
        
        
        String tinhTrang = request.getParameter("txtTinhTrang");
        String tinhNang = request.getParameter("txtTinhNang");
        String cameraSau = request.getParameter("txtCameraSau");
        String cameraTruoc = request.getParameter("txtCameraTruoc");
        String dungLuongPin = request.getParameter("txtDungLuongPin");
        String baoMat = request.getParameter("txtBaoMat");
        String mauSac = request.getParameter("txtMauSac");
        
        int upload=0;
        Connection db = Database.connect();
		try {
			String sql = "INSERT INTO san_pham (`ma_san_pham`,`ten_san_pham`, `hang_san_xuat`, `gia_san_pham`, `tinh_trang`, `hinh_anh_mo_phong`, `camera_truoc`, `camera_sau`, `dung_luong_pin`, `tinh_nang`, `bao_mat`, `mau_sac`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement pst = (PreparedStatement) db.prepareStatement(sql);
			
			pst.setInt(1, maSanPham);
			pst.setString(2, tenSanPham);
			pst.setString(3, hangSanXuat);
			pst.setInt(4, giaSanPham);
			pst.setString(5, tinhTrang);
			pst.setBlob(6, inputStream);
			pst.setString(7, cameraTruoc);
			pst.setString(8, cameraSau);
			pst.setString(9, dungLuongPin);
			pst.setString(10, tinhNang);
			pst.setString(11, baoMat);
			pst.setString(12, mauSac);
			
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
