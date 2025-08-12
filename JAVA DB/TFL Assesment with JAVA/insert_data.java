

import java.sql.*;


public class insert_data {
    public static void main(String[] args) {
             //Create conn to db
        String URL="jdbc:mysql://localhost:3306/TFLMentoringDB";
        String USERNAME="root";
        String PASSWORD="password";
        String query="INSERT INTO topics VALUES (1,'Arrange-Act-Assert (AAA) Testing Pattern','https://github.com/RaviTambade/TFLSoftwareTesting/blob/main/notes/aaapattern.md','1')";
        try{
            Connection conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection Established Sucessfully......");

            Statement smt=conn.createStatement();
            smt.executeUpdate(query);
            System.out.println("Data inserted Sucessfully.....");
            conn.close();
    }
    catch(Exception e)
    { 
        e.printStackTrace();
    }}
    
}
