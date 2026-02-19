package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {

    private static final String URL="jdbc:mysql://localhost:3306/OnlineFoodOrderingApp";

    private static final String USER="your_username";//username

    private static final String PASSWORD="your_password";//password



    public static Connection getconnection() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
