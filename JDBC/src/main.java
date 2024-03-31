import java.sql.*;

public class main {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Abhi@1234";
        String query = "Select * from employees";
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded succesfully");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("connection established succesfully");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                String job_title = res.getString("job_title");
                double salary = res.getDouble("salary");

                System.out.println("*****************");
                System.out.println("ID: " + id);
                System.out.println("name: " + name);
                System.out.println("Job_title: " + job_title);
                System.out.println("Salary: " + salary);
            }
            res.close();
            stmt.close();
            conn.close();
            System.out.println("*****************");
            System.out.println("connections closed susscessfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
