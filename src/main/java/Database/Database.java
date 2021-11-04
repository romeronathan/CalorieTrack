package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database instance;
    private Connection connection = null;
    private Database() {
        if(connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://php.scweb.ca/" + DBConst.DB_NAME + "?userSSL=false",
                        DBConst.DB_USER, DBConst.DB_PASS);
                System.out.println("Database successfully created!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static Database getInstance() {
        if(instance == null) {
            instance = new Database();
        }
        return instance;
    }
    public Connection getConnection() {
        return connection;
    }
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            connection = null;
            e.printStackTrace();
        }
    }
}
