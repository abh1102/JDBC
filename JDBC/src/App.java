// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;
// import java.sql.Statement;

// public class App {
//     static final String DB_URL = "jdbc:Mysql://localhost:3306/abhi";
//     static final String USER = "root";
//     static final String pass = "Abhi@1234";

//     public static void main(String[] args) {
//         try (Connection conn = DriverManager.getConnection(DB_URL, USER, pass)) {
//             // String sql = "create database aj1";
//             // stmt.executeUpdate(sql);
//             System.out.println("connected to the database");
//             System.out.println(conn);
//         } catch (SQLException e) {
//             System.err.println("connection failed " + e.getMessage());
//         }

//     }
// }
import java.sql.*;

public class App {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.driver");
            System.out.println("driver loaded succesfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        }
    }

}
