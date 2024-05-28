package operation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Servlet implementation class Pay_Bill
 */
public class Pay_Bill extends HttpServlet {
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    System.out.println("doPost method is executed");
	    
	    String query = request.getParameter("query");
	    String type = request.getParameter("type");
	    String brand = request.getParameter("brand");
	    System.out.println("\n"+brand);
	    
	    try(Connection conn = DataBaseConnection.get_conn()){
	    	String sqlQuery;
	    	if("manufacturer".equals(type)) {
	    		sqlQuery = "SELECT DISTINCT Brand_name FROM product WHERE Brand_name LIKE ?";	    		
	    	}
	    	else if("product".equals(type)) {
	    		sqlQuery = "SELECT DISTINCT Product_name FROM product WHERE Product_name LIKE ? AND Brand_name = ?";
	    	}
	    	else {
	    		return;
	    	}
	    	try(PreparedStatement statement = conn.prepareStatement(sqlQuery)){
	    		statement.setString(1, query+"%");
	    		System.out.println("entering to if statement");
	            if("product".equals(type)) {
	            	System.out.println("inside the if statement");
	                statement.setString(2, brand);
	            }
	            System.out.println("out of if statement");
	    		try(ResultSet resultSet = statement.executeQuery()){
	    			out.println("<ul>");
	    			while(resultSet.next()) {
	    				String suggestion;
	    				if("manufacturer".equals(type)){
	    					suggestion = resultSet.getString("Brand_name");
	    				}
	    				else {
	    					suggestion = resultSet.getString("Product_name");
	    					System.out.println("Suggestion is "+suggestion);
	    				}
	    				out.println("<li style>"+suggestion+"</li>");
	    			}
	    			out.println("</ul>");
	    		}
	    		
	    	}
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
}
