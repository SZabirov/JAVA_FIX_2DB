import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex02AddNewUserSqlInjection {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя:");
        String nick = sc.nextLine();
        System.out.println("Введите пароль:");
        String password = sc.nextLine();

        //пример sql-инъекции: вводим данное значение в качестве пароля
        String badPassword = "'); DROP TABLE shop_user; SELECT ('";

        String url = "jdbc:postgresql://localhost:5432/shop_db?user=postgres&password=postgres";
        Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        String sqlQuery = "INSERT INTO shop_user(username, password) " +
                "VALUES ('" + nick + "', '" + badPassword + "');";
        stmt.executeUpdate(sqlQuery);
    }
}
