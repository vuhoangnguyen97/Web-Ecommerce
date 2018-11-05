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

@WebServlet("/GopYServlet")
public class GopYServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GopYServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String comment = request.getParameter("message");
		
		if(email != null) {
			final String username = "testmailbaitap@gmail.com";
			final String password = "Vuhoangnguyen";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			
			Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
			});
			
			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(email));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("testmailbaitap@gmail.com"));
				message.setSubject("Góp ý");
				message.setText("Chào admin,"
					+ "\n\n Tôi tên là: " + name
					+ "\n\n Email: " + email
					+ "\n\n Góp ý của tôi: " + comment
					+ "\n\n Mong admin kiểm tra góp ý của tôi"
					+ "\n\n Thân! "
					+ "\n\n" + name);

				Transport.send(message);

				System.out.println("Done");
				request.getRequestDispatcher("Views/Success.jsp").forward(request, response);
			} catch (MessagingException e) {
				request.getRequestDispatcher("Views/loi.jsp").forward(request, response);

				throw new RuntimeException(e);
			}
		}
		else {
			request.getRequestDispatcher("Views/loi.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
