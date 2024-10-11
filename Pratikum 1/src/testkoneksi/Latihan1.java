package testkoneksi;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author PC 2
 */
public class Latihan1 {
    static final String DB_Url = "jdbc:mysql://localhost:3306/db_unidha";
    private static Connection Test_Konek;
    public static Connection DB_Konek()throws SQLException, ClassNotFoundException {
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
            System.out.println("proses Deteksi Driver Berhasil");
            final java.sql.Connection tersambung = DriverManager.getConnection(DB_Url, "root","");
            System.out.println("Koneksi Database Berhasil");
            
        }catch (final SQLException ex) {
            System.out.println("Koneksi Database gagal");
        }
        return Test_Konek;
    }
    public static void main(String[]args) {
    }
}
            
  
