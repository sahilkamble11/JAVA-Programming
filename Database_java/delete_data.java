import java.sql.*;
import java.sql.Connection;
import java.util.Scanner;

public class delete_data {
    public static void main(String[] args) {
        String URL="jdbc:mysql://localhost:3306/TFLMentoringDB";
        String USERNAME="root";
        String PASSWORD="password";
        String query="delete from topics where Id=?";

        try{
            Connection conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection established successfully");

            Scanner sc= new Scanner(System.in);
            System.out.println("Enter id that you want to delete");
            int id=sc.nextInt();
            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            System.out.println("Data Deleted Successfully");
            conn.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
