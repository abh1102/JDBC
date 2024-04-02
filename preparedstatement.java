import java.sql.*;
import java.util.*;

public class preparedstatement {
    public static void main(String[] args) throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "Abhi@1234";
        // String query = "SELECT * from employees where name=? AND job_title=?";
        String query = "INSERT INTO employees(id,name,job_title,salary) VALUES(?,?,?,?)";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver loaded succesfully");

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("connection established");
            // Statement stmt = conn.createStatement();
            // USING PREPARED STATEMENT
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            String name = sc.nextLine();
            String job_title = sc.nextLine();
            Double salary = sc.nextDouble();

            PreparedStatement prep = conn.prepareStatement(query);
            prep.setInt(1, id);
            prep.setString(2, name);
            prep.setString(3, job_title);

            prep.setDouble(4, salary);

            // prep.setString(1, "Abhishek Jha");
            // prep.setString(2, "full stack developer");
            // //Result set is only used when we want to retrieve data
            // ResultSet res = prep.executeQuery();
            // while (res.next()) {
            // int id = res.getInt("id");
            // String name = res.getString("name");
            // String job_title = res.getString("job_title");
            // double salary = res.getDouble("salary");
            // System.out.println(id);
            // System.out.println(name);
            // System.out.println(job_title);
            // System.out.println(salary);
            // }
            int rowsaffected = prep.executeUpdate();
            if (rowsaffected > 0) {
                System.out.println("updated Succesfully" + rowsaffected + "rows");

            } else {
                System.out.println("Some problem occured");

            }

            prep.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }

}
