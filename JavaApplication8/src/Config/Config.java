package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    private static Connection mysqlConfig;

/**
 * Mengatur konfigurasi database MySQL.
 * 
 * @return Koneksi database MySQL yang telah dikonfigurasi.
 * @throws SQLException Jika terjadi kesalahan saat menghubungkan ke database.
 */
    
public static Connection configDB() throws SQLException {
    try {
        String url = "jdbc:mysql://localhost:3306/tech_market";
        String user = "root";
        String pass = "";
        
        // Mendaftarkan driver JDBC MySQL
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        
        // Membuat koneksi ke database dengan menggunakan URL, username, dan password
        mysqlConfig = DriverManager.getConnection(url, user, pass);
    } catch (Exception e) {
        System.err.println("Koneksi Gagal " + e.getMessage());
    }
    
    return mysqlConfig;
}
}