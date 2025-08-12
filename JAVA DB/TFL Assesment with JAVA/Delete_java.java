
import java.sql.*;
import java.util.Scanner;

public class Delete_java {
    public static void main(String[] args) {
        //Create conn to db
        String URL="jdbc:mysql://localhost:3306/TFLMentoringDB";
        String USERNAME="root";
        String PASSWORD="password";
        String query="delete from topics where id=?";
        try{
            Connection conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection Established Sucessfully......");

            Scanner sc=new Scanner(System.in);
            System.out.print("Enter Topic id to delete:");
            int id=sc.nextInt();
            PreparedStatement pstmt=conn.prepareStatement(query);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            System.out.println("Data deleted sucessfully.....");
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
