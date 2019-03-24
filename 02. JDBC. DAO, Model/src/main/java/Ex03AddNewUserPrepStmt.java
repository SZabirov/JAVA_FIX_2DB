import java.sql.*;
import java.util.Scanner;

public class Ex03AddNewUserPrepStmt {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя:");
        String nick = sc.nextLine();
        System.out.println("Введите пароль:");
        String password = sc.nextLine();
        String badPassword = "'); DROP TABLE shop_user; SELECT ('";

        String url = "jdbc:postgresql://localhost:5432/shop_db?user=postgres&password=postgres";
        Connection conn = DriverManager.getConnection(url);
        String sqlQuery = "INSERT INTO shop_user(username, password) " +
                "VALUES (?, ?);";
        PreparedStatement pstmt = conn.prepareStatement(sqlQuery);
        pstmt.setString(1, nick);
        pstmt.setString(2, password);
        pstmt.executeUpdate();
    }
}
