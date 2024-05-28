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
 * Servlet implementation class removeItem
 */
public class removeItem extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getting values form the form
		String brandName = request.getParameter("brand");	
		System.out.println(brandName);
		String productName = request.getParameter("product");
		System.out.println(productName);
		
		// creating the database connection
		try (Connection conn = DataBaseConnection.get_conn();){
			String query = "DELETE FROM product where Brand_name = ? and Product_name = ?";
			try(PreparedStatement statement = conn.prepareStatement(query)) {
				statement.setString(1, brandName);
				statement.setString(2, productName);
				int result = statement.executeUpdate();
				System.out.println(result);
				if (result > 0) {
				    response.sendRedirect("deleteProduct.jsp?message=Item deleted successfully");
				} else {
				    response.sendRedirect("deleteProduct.jsp?message=Item did not found");
				}

				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}

}
