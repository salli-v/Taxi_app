package core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public static final String URL =
            "jdbc:mysql://localhost:3306/driver_db?useUnicode=true" + "&serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "1488";
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    static {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't find SQL Driver", e);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        Properties dbProperties = new Properties();
        dbProperties.setProperty("user", USERNAME);
        dbProperties.setProperty("password", PASSWORD);
        return DriverManager.getConnection(URL, dbProperties);
    }
}
