import java.sql.*;
import java.util.Scanner;

public class Ex04GetAllUsers {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/shop_db?user=postgres&password=postgres";
        Connection conn = DriverManager.getConnection(url);
        String sqlQuery = "SELECT * FROM shop_user;";
        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
        ResultSet rs = pstmt.executeQuery();

        while(rs.next()) {
            System.out.println(rs.getString("username"));
        }
    }
}
