import java.sql.*;
public class display_data
{
    public static void main(String[] args)throws Exception {
        String URL="jdbc:mysql://localhost:3306/TFLMentoringDB";
        String USERNAME="root";
        String PASSWORD="password";
        Connection connection=null;

        connection=DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connection established successfully");
      

        System.out.println();
        System.out.println();
        System.out.println();
        Statement smt=connection.createStatement();
        ResultSet rs=smt.executeQuery("select * from topics");

        ResultSetMetaData rmd=rs.getMetaData();
        int columncount=rmd.getColumnCount();
        System.out.println("Data of a github content ");
        
        for( int i=1;i<=columncount;i++)
        {
            
            System.out.println(rmd.getColumnName(i)+"\t");
        }
        System.out.println("\n*****************************");
        while(rs.next())
        {
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+rs.getInt(4)+"\t");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Record Display Successfully");
        connection.close();
    }
}