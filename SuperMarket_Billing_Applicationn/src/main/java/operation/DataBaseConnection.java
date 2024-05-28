package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseConnection {
	private static final String url = "jdbc:mysql://localhost:3306/supermarketdata";
    private static final String name = "root";
    private static final String hostname = "localhost";
    private static final String password = "";

    static {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection get_conn() throws SQLException {
        return DriverManager.getConnection(url, name, password);
    }

    public static void close_connection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
