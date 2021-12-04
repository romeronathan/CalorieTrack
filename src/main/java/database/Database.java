package database;


import java.sql.*;

import static panes.accountSettingsPane.readSettings;

/**
 * @author Nathan Romero
 * @version 1.0
 * @date 12/4/2021
 * @description
 */

public class Database {

    private static Database instance;
    private Connection connection = null;
    private Database() {
        if(connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                readSettings();
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DBConst.DB_NAME + "?useSSL=false",
                        DBConst.DB_USER, DBConst.DB_PASS);
                System.out.println("Database successfully created!");

                createTable(DBTableValues.TABLE_DAY, DBTableValues.CREATE_TABLE_DAY, connection);
                createTable(DBTableValues.TABLE_MEAL, DBTableValues.CREATE_TABLE_MEAL, connection);
                createTable(DBTableValues.TABLE_DRINK, DBTableValues.CREATE_TABLE_DRINK, connection);
                createTable(DBTableValues.TABLE_SNACK, DBTableValues.CREATE_TABLE_SNACK, connection);
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
    private void createTable(String tableName, String tableQuery,
                             Connection connection) throws SQLException {
        Statement createTable;
        //Get database information
        DatabaseMetaData md = connection.getMetaData();
        //Looking for the table with tableName
        ResultSet resultSet = md.getTables("nromerojava",
                null, tableName, null);
        //If the table is present
        if(resultSet.next()){
            System.out.println(tableName + " table already exists!");
        }
        else{
            createTable = connection.createStatement();
            createTable.execute(tableQuery);
            System.out.println("The " + tableName + " table has been inserted");
        }
    }
}
