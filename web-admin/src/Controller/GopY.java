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

/**
 * Servlet implementation class GopY
 */
@WebServlet("/GopY")
public class GopY extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GopY() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		String to = request.getParameter("txtNguoiNhan");
		String from = request.getParameter("txtNguoiGui");
		String pass = request.getParameter("txtPassword");
		String title = request.getParameter("txtTieuDe");
		String context = request.getParameter("txtNoiDung");
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(from, pass);
				}
		});
		
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from)); // người gửi
			message.setRecipients(Message.RecipientType.TO, // người nhận
				InternetAddress.parse(to));
			message.setSubject(title); // 
			message.setText(context);
			message.setContent(context, "text/html; charset=utf-8");
			Transport.send(message);

			System.out.println("Done");
			request.getRequestDispatcher("quan-ly-san-pham.jsp").forward(request, response);
		} catch (MessagingException e) {
			request.getRequestDispatcher("Views/loi.jsp").forward(request, response);

			throw new RuntimeException(e);
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
