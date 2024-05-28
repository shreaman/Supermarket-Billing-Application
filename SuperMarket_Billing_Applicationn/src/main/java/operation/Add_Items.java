package operation;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Add_Items
 */
public class Add_Items extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Extract table data from request parameters
		String menuf_name = request.getParameter("menuf_name");
	    String product_name = request.getParameter("product_name");
	    int quantity = Integer.parseInt(request.getParameter("quantity"));
	    

        
        try(Connection conn = DataBaseConnection.get_conn()){
    		String query = "SELECT Product_price, Tax, Discount FROM product WHERE Brand_name = ? AND Product_name = ?";
    		try(PreparedStatement statement = conn.prepareStatement(query)){
    			statement.setString(1, menuf_name);
    			statement.setString(2, product_name);
    			try(ResultSet resultSet = statement.executeQuery()){
    				 if (resultSet.next()) {
    					 double price = resultSet.getDouble("Product_price");
                         double tax = resultSet.getDouble("Tax");
                         double discount = resultSet.getDouble("Discount");
                         
                         // Calculate total price
                         double totalPrice = price * (1 + tax/100) * (1 - discount / 100) * quantity;
                         
                         totalPrice = Math.round(totalPrice * 100.0) / 100.0;
                         
                         // Send the totalPrice as response
                         response.setContentType("text/plain");
                         response.setCharacterEncoding("UTF-8");
                         response.getWriter().write(String.valueOf(totalPrice));
                     } else {
                         response.getWriter().write("Not Available");
                     }
    			}
    		}
    				        	
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
     	}

}
