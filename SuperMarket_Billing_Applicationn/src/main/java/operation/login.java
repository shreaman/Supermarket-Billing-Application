package operation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.relation.Role;

import operation.DataBaseConnection;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
        String password = request.getParameter("pass");
        System.out.println("User Email: " + email);
        System.out.println("User Password: " + password);

        String role = "";
        try (Connection conn = DataBaseConnection.get_conn()) {
        	String query = "SELECT Role FROM user WHERE Email_ID = ?";
        	try(PreparedStatement preparedStatement = conn.prepareStatement(query)){
        		preparedStatement.setString(1, email);
        		try(ResultSet resultSet = preparedStatement.executeQuery()){
        			if(resultSet.next()) {
        				role = resultSet.getString("Role");
        				System.out.println(role);
        			}
        		}
        	}
            String statement = "SELECT * FROM user WHERE Email_ID = ? AND User_pass = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(statement)) {
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String userEmail = resultSet.getString("Email_ID");
                        String userPassword = resultSet.getString("User_pass");
                        System.out.println("User Email form db: " + userEmail);
                        System.out.println("User Password from db: " + userPassword);
                        if(role.equals("Admin")) {
                        	response.sendRedirect("Admin.jsp");
                        }
                        else {
                        	response.sendRedirect("Home.jsp?message = login successful");
                        }
                    } else {
                        response.sendRedirect("Login.jsp?error=login failed Invalid Username or Password");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("Login.jsp?error = failed");
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
