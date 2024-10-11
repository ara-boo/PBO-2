
package app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaManager {
    Connection coon = null;
    Statement stm = null;
    String driver = "com.mysql.jdbc.Drver";
    String url = "dbc:mysql://localhost:3306/db_SI_15";

    public MahasiswaManager(){
        try {
            Class.forName(driver);
            coon = DriverManager.getConnection(url, "root","");
            stm = coon.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List getMahasiswa () {
        ResultSet rs = null;
        List Mahasiswa = new ArrayList();

        try {
            rs = stm.executeQuery("select * from tbl_mahasiswa");
            while (rs.next()) {
                Mahasiswa m = new Mahasiswa();
                m.setnobp(rs.getString("No_BP"));
                m.setnama(rs.getString("Nama"));
                m.settmplahir(rs.getString("Tempat_lahir"));
                m.settgllahir(rs.getString("Tanggal_ahir"));
                m.setalamat(rs.getString("Alamat"));
                m.setphone(rs.getString("Telp"));
                m.setasalsekolah(rs.getString("Asal_Sekolah"));
                Mahasiswa.add(m);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Mahasiswa;
    }

    public int Insert(Mahasiswa m) {
        int result = 0;
        try {
            result = stm.executeUpdate("insert into tbl_mahasiswa value (' " + m.getnobp() + "', '"
                    + m.getnama() + "', '" + m.gettmplahir() + "', '" + m.gettgllahir() + "', '"
                    + m.getalamat() + "', '" + m.getphone() + "','" + m.getasalsekolah() + "')");
        }
        catch (Exception e){
            e.printStackTrace();

        }
        return result;
    }
    public int Delete (Mahasiswa m) {
        int result = 0;
        try {
            result = stm.executeUpdate("delete fromtbl_mahasiswa where N0_BP = '"+ m.getnobp() +"'");

        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return  result;
    }

    public int update (Mahasiswa m) {
        int result = 0;
        try {
            result = stm.executeUpdate("update tbl_mahasiswa set No_BP= '"+ m.getnobp()
                    +"', nama = '"+ m.getnama() +"', tempat_lahir = '"+m.gettmplahir()
                    +"', Tanggal_lahir = '"+ m.gettgllahir() +"', Alamat = '"+m.getalamat()+"', Telp ='"+m.getphone()
                    +"', Asal_Sekolah = '"+m.getasalsekolah()+ "' where No_BP= '"+m.getnobp()+"'" );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  result;
    }
    public void closeConnection() {
        try {
            coon.close();
            stm.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
