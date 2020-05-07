package proje;

import java.sql.*;

public class KullaniciRepositoryPostgreSQL implements IKullaniciRepository {
    private static KullaniciRepositoryPostgreSQL nesne;


    private KullaniciRepositoryPostgreSQL()
    {
    }

    public static synchronized KullaniciRepositoryPostgreSQL getInstance(){
        if(nesne==null)
            nesne=new KullaniciRepositoryPostgreSQL();
        return nesne;
    }

    private Connection baglan(){

        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/AkilliCihaz",
                    "postgres", "261216");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    @Override
    public boolean kullaniciDogrula(String kullaniciAdi, String sifre)
    {
        String sql= "SELECT * FROM \"public\".\"Kullanici\" WHERE \"kullaniciAdi\"='"+kullaniciAdi+"'AND \"sifre\"='"+sifre+"'";
       try {
           Connection conn=this.baglan();
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(sql);
           if(rs.next()){
               return true;
           }
       }
       catch (Exception e){
           e.printStackTrace();
       }
        return false;
    }
}
