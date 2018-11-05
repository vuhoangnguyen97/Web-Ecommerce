package Controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BusinessLogics.gioHangBL;
import BusinessLogics.hoaDonBL;
import BusinessLogics.theTichDiemDAO;
import Encrypt.encrypt;
import JavaBeans.hoaDon;
import JavaBeans.sanPhamMua;
import JavaBeans.theKhachHang;
import JavaBeans.user;

@WebServlet("/xacNhanDonHang")
public class xacNhanDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public xacNhanDonHang() {
        super();
    }
    
    // chi co COD thi` gui mail luon
    //1: paypal, ... de switch case:
    
    // con` cac cong thanh toan khác, thì có kiểm tra transaction rồi mới gui mail
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		user thanhVienMuaHang = (user) session.getAttribute("member");
		
		
		gioHangBL gioHang = (gioHangBL) session.getAttribute("gioHang");
		List<sanPhamMua> listOfSp = gioHang.danhSachSanPhamMua();
		
		
		int id = thanhVienMuaHang.getIduser();
		int id_the_tich_diem = thanhVienMuaHang.getId_the_tich_diem();
		
		theKhachHang theKhachHang = theTichDiemDAO.theKhachHang(id_the_tich_diem);
		int diem = theKhachHang.getDiem(); // current point
		
		String email = request.getParameter("txtEmail");
		String ho_user = request.getParameter("txtHo");
		String ten_user = request.getParameter("txtHo");
		int sdt = Integer.parseInt(request.getParameter("txtSDT"));
		String diaChi = request.getParameter("txtDiaChi");
		String quan = request.getParameter("txtQuan");
		String phuong = request.getParameter("txtPhuong");
		
		// Kiá»ƒm thá»­ Session
		System.out.println(thanhVienMuaHang.getIduser());
		String kq = "";
		for(sanPhamMua spm: listOfSp) {
			kq += spm.getTenSanPham() + " - Số lượng mua: " +spm.getSoLuongMua() +" - Thành tiền: " + String.format("%,3d", spm.getThanhTien()) + "<br/>";
			System.out.println(kq);
		}
		String phuongEncrypt, quanEncrypt, diaChiEncrypt, chiTietEncrypt= "";
		try {
			byte[] diaChiMaHoa = encrypt.encrypt(diaChi);
			byte[] phuongMaHoa = encrypt.encrypt(phuong);
	        byte[] quanMaHoa = encrypt.encrypt(quan);
	        byte[] chiTietMaHoa = encrypt.encrypt(kq);
	        
	        diaChiEncrypt = diaChiMaHoa.toString();
	        phuongEncrypt = phuongMaHoa.toString();
	        quanEncrypt = quanMaHoa.toString();
	        chiTietEncrypt = chiTietMaHoa.toString();
	        
			
	        
			hoaDon hd_mua = new hoaDon();
			hd_mua.setId_user(id);
			hd_mua.setEmail(email);
			hd_mua.setHo_user(ho_user);
			hd_mua.setTen_user(ten_user);
			hd_mua.setSdt(sdt);
			hd_mua.setDiaChi(diaChiEncrypt);
			hd_mua.setQuan(quanEncrypt);
			hd_mua.setPhuong(phuongEncrypt);
			hd_mua.setChiTiet(chiTietEncrypt);
			
			int them = hoaDonBL.themHoaDon(hd_mua);
			if(them != 0) {
				diem += gioHang.tongTien()/100000;
				if(diem>=100 && diem <400){
				    // Silver
				    int updateThe = theTichDiemDAO.nangCapThe(id_the_tich_diem, 2);
				}
				else if(diem >=400 && diem<700){
				    // Gold
				    int updateThe = theTichDiemDAO.nangCapThe(id_the_tich_diem, 3);

				}
				else if(diem>=700 && diem <1000){
				    // Plantium
				    int updateThe = theTichDiemDAO.nangCapThe(id_the_tich_diem, 4);

				}else if(diem>=1000){
				    // Diamond
				    int updateThe = theTichDiemDAO.nangCapThe(id_the_tich_diem, 5);

				}
				int tichDiem = theTichDiemDAO.tichDiem(id_the_tich_diem, diem);

				// mail
				if (email != null) {
					
					//final String username = "testmailbaitap@gmail.com";
					//final String password = "Vuhoangnguyen";
					
					final String username = "chamsockhachhangdtonline@gmail.com";
					final String password = "Tuminhhau";

					Properties props = new Properties();
					props.put("mail.smtp.auth", "true");
					props.put("mail.smtp.starttls.enable", "true");
					props.put("mail.smtp.host", "smtp.gmail.com");
					props.put("mail.smtp.port", "587");

					Session sessions = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username, password);
						}
					  });
					
					try {					
						
						Message message = new MimeMessage(sessions);
						
						message.setFrom(new InternetAddress("chamsockhachhangdtonline@gmail.com"));
						message.setRecipients(Message.RecipientType.TO,
							InternetAddress.parse(email));
						message.setHeader("Content-Type", "text/html; charset=UTF-8");
						message.setSubject("Thông tin đơn hàng");
						DecimalFormat df = new DecimalFormat("###,###.##");
						String noiDung = "Chào bạn, " + ho_user
	                    + "<br/> Cảm ơn bạn đã mua hàng của chúng tôi"
	                    + "<br/> Sau đây là chi tiết đơn hàng bạn đã mua: "
	                    + "<br/> <br/>" + " <strong> " + kq + "</strong>"
	                    + "<br/> <br/>" + " <strong> Tổng tiền: " + df.format(gioHang.tongTien()) + " VNĐ</strong>"
	                    + "<br/> Địa chỉ giao hàng: " + diaChi + " Quận: " + quan + " Phường: " + phuong
	                    + "<br/> Số điện thoại liên hệ: " + sdt
	                    + "<br/> <br/> Ban Quản Lý, VHN!";
						//message.setText(noiDung);
						message.setContent(noiDung, "text/html; charset=utf-8");
						Transport.send(message);
						request.getRequestDispatcher("mua-thanh-cong.jsp").forward(request, response);
						// reset giỏ hàng
						gioHang.reset();
					} catch (MessagingException e) {
						request.getRequestDispatcher("Views/loi.jsp").forward(request, response);

						throw new RuntimeException(e);
					}
				}
				
			}
			else {
				request.getRequestDispatcher("mua-bi-loi.jsp").forward(request, response);
			}
	        
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}     

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
