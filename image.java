import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class image {
    public static void main(String[] args) throws ClassNotFoundException {
       String url="jdbc:mysql://localhost:3306/mydatabase";
       String username="root";
       String password="Abhi@1234";
      // String query="insert into image_table(image_data)values(?)";
       //String image_path="C:\\Users\\abhis\\OneDrive\\Desktop\\SQL\\profile.jpg";
       String folder="C:\\Users\\abhis\\OneDrive\\Desktop\\SQL\\";
       String query="SELECT image_data from image_table where image_id=(?)";
       try{
            Class.forName("com.mysql.jdbc.driver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());;

        }
        try{

            Connection conn=DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setInt(1, 1);
            ResultSet res=pstmt.executeQuery();
            if(res.next()){
                byte[] image_data=res.getBytes("image_data");
                String image_path=folder+"image.jpg";
                OutputStream obj=new FileOutputStream(image_path);
                obj.write(image_data);

                
            }else{
                System.out.println("image not found");
            }
       
            //     System.out.println("Connection established succesfully");
        //     try{
        //       PreparedStatement pstmt = conn.prepareStatement(query) ;

        //     //fileinputstream is used to convert image into binary format in java;
        //     FileInputStream obj=new FileInputStream(image_path);
        //    // byte[] image=new byte[ FileInputStream.available()];
        //    // FileInputStream.read(image);
        //    pstmt.setBinaryStream(1, obj);
        //   int affectedRows=pstmt.executeUpdate();
        //   if(affectedRows>0){
        //     System.out.println("Image inserted successfully");

        //   }
        //   else{
        //     System.out.println("Image not inserted");
        //   }
         

          
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
     catch(Exception e){
            System.out.println(e.getMessage());

        }
        }
    }


