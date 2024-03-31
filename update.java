
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

class updatedata {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Abhi@1234";
        String query = "UPDATE  employees\n" +
                " set job_title='full stack developer',salary=70000.0\n" +
                "where id=2;";
        try {
            // loading the driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded succesfully");
        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }
        try {
            // establishing the connectio
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("connection established succesfully");
            Statement stmt = conn.createStatement();
            int rowsaffected = stmt.executeUpdate(query);
            if (rowsaffected > 0) {
                System.out.println("updated Succesfull" + rowsaffected + "rows");
            } else {
                System.out.println("data not updatedd");
            }
            stmt.close();
            conn.close();
            System.out.println("*****************");
            System.out.println("connections closed susscessfully");
        } catch (

        SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
