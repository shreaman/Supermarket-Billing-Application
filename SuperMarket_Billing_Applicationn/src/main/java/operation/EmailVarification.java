package operation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

/**
 * Servlet implementation class EmailVarification
 */
public class EmailVarification extends HttpServlet {
	
	//generate otp method it will generate a 6 digit otp
		private String generateOTP() {
	        // Generate a 6-digit OTP
	        Random random = new Random();
	        int otp = 100000 + random.nextInt(900000);
	        return String.valueOf(otp);
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("getEmail");
		System.out.println(email);
		
//      Varifying the email
      String otp = generateOTP();
      boolean emailsender = EmailSend.sendOTP(email, otp);

      
      //creating a session to for otp varification
      request.getSession().setAttribute("OTP", otp);
      request.getSession().setAttribute("email", email);
      request.getSession().setMaxInactiveInterval(5*60);

      
      //sending the otp for varification to the otp varification servlet 
      	request.getRequestDispatcher("VarifyOtp.jsp?message=Otp is sent").forward(request, response);	
	}
}
