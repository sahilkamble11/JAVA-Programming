import java.sql.*;
 public class EcomConn{
    public static void main(String[] args) {
        String URL="jdbc:mysql://localhost:3306/TFLEcommerce";
        String USERNAME="root";
        String PASSWORD="password";
        Connection conn=null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loded sucessfully..!!");

            conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection established sucessfully...!!");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
 }