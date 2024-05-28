package operation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.mail.Authenticator;
import javax.activation.DataSource;
import operation.EmailSend;


import operation.DataBaseConnection;



public class register_new extends HttpServlet {
	public static boolean varifyPass(String pass, String re_pass) {
		if(!pass.equals(re_pass)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String emailRegister = request.getParameter("email");
		String email = (String) session.getAttribute("email");
        String role = request.getParameter("role");
        String u_name = request.getParameter("username");
        String password = request.getParameter("pass");
        String re_password = request.getParameter("re_enter");
        
        
    
        // Perform basic validation
        if (u_name == null || email == null || password == null || u_name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "All fields are required");
            return;
        }
        
        //checking for verified email
        if(!emailRegister.equals(email)) {
        	response.sendRedirect("Register_New.jsp?error_email=Alert : Wrong email");
        	return;
        }
        
        //password verification
        boolean varify = varifyPass(password,re_password);
        System.out.println(varify);
        if(varify) {
        	response.sendRedirect("Register_New.jsp?passError=Alert : Password mismatch");
        	return;
        }   
        		
        try (Connection conn = DataBaseConnection.get_conn()){
        	String query = "SELECT * FROM user WHERE Email_ID=?";
            try (PreparedStatement statement = conn.prepareStatement(query)){
                statement.setString(1, email);
                try (ResultSet resultset = statement.executeQuery()){
                    if (resultset.next()) {
                        response.sendRedirect("Register_New.jsp?error_email=Alert : Email Already Exist");
                        return; // Stop further execution
                    }
                }
            }
            
            String insertQuery = "INSERT INTO user (User_ID, Email_ID, User_name, User_pass, Role) VALUES (?,?,?,?,?)";
            try (PreparedStatement insertStatement = conn.prepareStatement(insertQuery)){
            	String getIdQuery = "SELECT User_ID FROM user ORDER BY User_ID DESC LIMIT 1";
            	try(PreparedStatement getStatement = conn.prepareStatement(getIdQuery)){
            		try(ResultSet resultset = getStatement.executeQuery()){
            			int id =0;
            			if(resultset.next()) {
            				id = resultset.getInt("User_ID");
            			}
            			int newId = id+1;
            			insertStatement.setInt(1, newId);
            		}
            	}
                insertStatement.setString(2, email);
                insertStatement.setString(3, u_name);
                insertStatement.setString(4, password);
                insertStatement.setString(5, role);
                insertStatement.executeUpdate(); 
            }
            response.sendRedirect("Register_New.jsp?message=Registration successful");
            
        } catch (SQLException e) {
        	e.printStackTrace();
            response.sendRedirect("Register_New.jsp");
            }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
