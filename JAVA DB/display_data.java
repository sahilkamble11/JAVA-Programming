import java.sql.*;


public class display_data {

    public static void main(String[] args)throws Exception
     {
        String URL="jdbc:mysql://localhost:3306/TFLMentoringDB";
        String USERNAME="root";
        String PASSWORD="password";
        Connection conn=null;

        conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connection Established Sucessfully...!!");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        Statement smt=conn.createStatement();
        ResultSet rs= smt.executeQuery("select * from topics");

        ResultSetMetaData rmd=rs.getMetaData();
        int colmncount=rmd.getColumnCount();
        System.out.println("Topics Information");

        for(int i=1;i<=colmncount;i++)
        {
            System.out.println(rmd.getColumnName(i)+"\t");
        }
        System.out.println("\n----------------------------------------------------------------");
        while (rs.next()) {
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("record display sucessfully...!!!");
        conn.close();
    }
}