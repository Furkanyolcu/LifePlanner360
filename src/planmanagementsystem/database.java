package planmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;


public class database {
    
    public static Connection connectDB(){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/plan", "root", ""); 
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
    
}
