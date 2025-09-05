import java.sql.*;

public class jdbcConnection
{
    public static void main(String[] args) {
        String URL="jdbc:mysql://192.168.1.45:3306/TFLMentoringDB";
        String USERNAME="root";
        String PASSWORD="password";
        Connection connection=null;
        try
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
           System.out.println("Driver loaded successfully");
            connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection established successfully");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}