package Handler;
import java.sql.*;
import java.util.concurrent.TimeUnit;
public class loader 
{
    protected Connection con;
    public boolean Connect(String password) // Connects To mySQL Database 
    {
        System.out.print("Connection Status >>>>> ");
        try{
            //Class.forName("com.mysql.jdbc.Driver"); // Loading The Driver 
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root",password); // Connecting The Driver
            System.out.println(" MySQL Database Connected !!!");
            //con.close();
            return true;
        }
        catch(Exception e)
        {
            System.out.println("Oops Incorrect Password !!! Try Again !! ");
            try
            {
                     TimeUnit.SECONDS.sleep(1);
            }
            catch(Exception e2)
            {
                System.out.println("Oops !!! Something Went Wrong ! ");
                System.out.println("Stack Trace : "+e.getStackTrace());
                System.out.println("Exception occured >> "+e.getMessage()+e2);
            }
            return false;
        }
    }
}
