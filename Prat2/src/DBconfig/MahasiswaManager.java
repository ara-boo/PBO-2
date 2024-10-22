
package DBconfig;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

/**
 *
 * @author ASUS
 */
public class MahasiswaManager {
    private static Connection coon;
    public static Connection getConnection(){
        if (coon == null){
            try {
                String url = "jdbc:mysql://localhost:3306/db_si_15";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                coon  = DriverManager.getConnection(url,user,pass);
            } catch (Exception e) {
                Logger.getLogger(MahasiswaManager.class.getName()).log(Level.SEVERE,null,e);
                
            }
            
        }
       return coon;
    }
        
    
}
