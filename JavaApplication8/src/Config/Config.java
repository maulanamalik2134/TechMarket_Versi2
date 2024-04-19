package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/techmarket";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection mysqlConfig;

    public static Connection getConnection() throws SQLException {
        if (mysqlConfig == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                mysqlConfig = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (Exception e) {
                throw new SQLException("Error connecting to the database", e);
            }
        }
        return mysqlConfig;
    }
}
