package Controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BusinessLogics.resetPasswordDAO;
import BusinessLogics.userBL;
import Encrypt.encrypt;
import JavaBeans.generateTokenKey;
import JavaBeans.user;
import sun.rmi.runtime.Log;

@WebServlet("/quenMatKhauServlet")
public class quenMatKhauServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public quenMatKhauServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       	request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String username = encrypt.hashWith256(request.getParameter("txtUsername"));
		String email = request.getParameter("txtEmail");
		
		user thanhVienQuenMatKhau = userBL.ResetPassword(username, email);
		int insert = 0;
		if(thanhVienQuenMatKhau != null) {
			// tÃ¬m tháº¥y tÃªn vÃ  email thÃ nh viÃªn nÃ y trong csdl
			final String admin = "chamsockhachhangdtonline@gmail.com";
			final String password_admin = "Tuminhhau";

			
			
			try {
				int iduser = thanhVienQuenMatKhau.getIduser();
				String tokenKey = generateTokenKey.generateToken(thanhVienQuenMatKhau.getUsername());
				
				insert = resetPasswordDAO.themToken(iduser, tokenKey);
				System.out.println("insert: " + insert);			
				
				if(insert!=0) {
					final String adminEmail = "chamsockhachhangdtonline@gmail.com";
					final String password = "Tuminhhau";
					
                    Properties props = new Properties();
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");

                    Session sessions = Session.getInstance(props,
                            new javax.mail.Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(adminEmail, password);
                                }
                            });
					// success , còn 10p, 
                    Message message = new MimeMessage(sessions);


                    message.setFrom(new InternetAddress("testmailbaitap@gmail.com"));
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(thanhVienQuenMatKhau.getEmail()));
                    message.setHeader("Content-Type", "text/plain; charset=UTF-8");
                    message.setSubject("Khôi phục mật khẩu");
                    String noiDung = "Chào bạn, " + thanhVienQuenMatKhau.getTen_user()
                            + "<br/>Mã xác nhận của bạn là: " + tokenKey
                            + "<br/> Truy cập đường dẫn sau để thực hiện thay đổi mật khẩu: <a href='http://localhost:8161/web-mobile/xac-nhan-ma.jsp'>CLICK HERE</a>" 
                            + "<br/> <br/> Ban Quản Lý, Mobile Shop OU!";
                    //message.setText(noiDung);
                    message.setContent(noiDung, "text/html; charset=utf-8");
                    Transport.send(message);
					System.out.println("Done");
					
					request.getRequestDispatcher("Views/Success.jsp").forward(request, response);
				}
				else {
					// mã đã có rồi
					int delete = resetPasswordDAO.deleteToken(iduser);
					String tokenKeyNew = generateTokenKey.generateToken(thanhVienQuenMatKhau.getUsername());
					
					insert = resetPasswordDAO.themToken(iduser, tokenKeyNew);
					if(insert!=0) {
						final String adminEmail = "chamsockhachhangdtonline@gmail.com";
						final String password = "Tuminhhau";
						
	                    Properties props = new Properties();
	                    props.put("mail.smtp.auth", "true");
	                    props.put("mail.smtp.starttls.enable", "true");
	                    props.put("mail.smtp.host", "smtp.gmail.com");
	                    props.put("mail.smtp.port", "587");

	                    Session sessions = Session.getInstance(props,
	                            new javax.mail.Authenticator() {
	                                protected PasswordAuthentication getPasswordAuthentication() {
	                                    return new PasswordAuthentication(adminEmail, password);
	                                }
	                            });
						// success , còn 10p, 
	                    Message message = new MimeMessage(sessions);


	                    message.setFrom(new InternetAddress("testmailbaitap@gmail.com"));
	                    message.setRecipients(Message.RecipientType.TO,
	                            InternetAddress.parse(thanhVienQuenMatKhau.getEmail()));
	                    message.setHeader("Content-Type", "text/plain; charset=UTF-8");
	                    message.setSubject("Thông tin đơn hàng");
	                    String noiDung = "Chào bạn, " + thanhVienQuenMatKhau.getTen_user()
                        + "<br/>Mã xác nhận của bạn là: " + tokenKeyNew
                        + "<br/> Truy cập đường dẫn sau để thực hiện thay đổi mật khẩu: <a href='http://localhost:8161/web-mobile/xac-nhan-ma.jsp'>CLICK HERE</a>" 
                        + "<br/> <br/> Ban Quản Lý, Mobile Shop OU!";
	                    //message.setText(noiDung);
	                    message.setContent(noiDung, "text/html; charset=utf-8");
	                    Transport.send(message);
						System.out.println("Done");
						
						request.getRequestDispatcher("Views/Success.jsp").forward(request, response);
					}
					
				}
				
				
			} catch (MessagingException e) {
				request.getRequestDispatcher("Views/loi-reset.jsp").forward(request, response);

				throw new RuntimeException(e);
			}

		
		}
		else{
			response.sendRedirect("loi-reset.jsp");
		}
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	 	
}
