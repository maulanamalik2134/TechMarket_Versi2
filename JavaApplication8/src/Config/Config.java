package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    private static Connection mysqlConfig;

public static Connection configDB() throws SQLException {
    try {
        String url = "jdbc:mysql://localhost:3306/techmarket";
        String user = "root";
        String pass = "";
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        mysqlConfig = DriverManager.getConnection(url, user, pass);
    } catch (Exception e) {
        System.err.println("Koneksi Gagal " + e.getMessage());
    }
    return mysqlConfig;
}
}