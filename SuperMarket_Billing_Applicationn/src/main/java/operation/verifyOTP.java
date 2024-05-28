package operation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Random;

/**
 * Servlet implementation class verifyOTP
 */
public class verifyOTP extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String email = request.getParameter("getEmail");
		System.out.println(email);
		String userOtp = request.getParameter("otp");
		System.out.println(userOtp);
		
		HttpSession session = request.getSession();
		String otp = (String)session.getAttribute("OTP");

		
		if(otp != null && userOtp.equals(otp)) {
//			boolean varified = true;
//			request.setAttribute("otpVerified", varified);
			session.removeAttribute("otp");
			request.getRequestDispatcher("Register_New.jsp").forward(request, response);
			return;
		}
		else if(otp != null && !userOtp.equals(otp)) {
			response.sendRedirect("getEmail.jsp");
		}
		else {
			response.sendRedirect("getEmail.jsp?error=Invalid OTP");
			return;
		}
	}

}
