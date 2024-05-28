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
import java.util.Random;

/**
 * Servlet implementation class AddItemToInventory
 */
public class AddItemToInventory extends HttpServlet {
	private String getId() {
        // Generate a 6-digit OTP
        Random random = new Random();
        int id = 1000 + random.nextInt(9000);
        return String.valueOf(id);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(getId());
		String brandName = request.getParameter("brand");
		String product = request.getParameter("product");
		String quantity = request.getParameter("quantity");
		String price = request.getParameter("price");
		String tax = request.getParameter("tax");
		String discount = request.getParameter("discount");
		
		//Checking for empty 
		if (brandName == null || product == null || quantity == null || price.isEmpty() || tax.isEmpty() || tax.isEmpty() || discount.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "All fields are required");
            return;
        }
		
		
		try(Connection conn = DataBaseConnection.get_conn()){
			String query = "INSERT INTO product (Product_ID, Brand_name , Product_name, Product_quantity, Product_price, Tax, Discount) VALUES (?,?,?,?,?,?,?)";
			try(PreparedStatement statement = conn.prepareStatement(query)){
					statement.setInt(1, id);
					statement.setString(2, brandName);
					statement.setString(3, product);
					statement.setString(4, quantity);
					statement.setString(5, price);
					statement.setString(6, tax);
					statement.setString(7, discount);
					statement.executeUpdate();
					DataBaseConnection.close_connection(conn);
			}
			response.sendRedirect("AddInventory.jsp?message=Item Inserted successfully Id of the product is : "+id);
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
