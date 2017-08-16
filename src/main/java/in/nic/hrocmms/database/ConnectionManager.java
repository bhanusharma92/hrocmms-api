package in.nic.hrocmms.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static String driverName = "org.postgresql.Driver";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/haryana_db",
                        "postgres","1234");
                /*con = DriverManager.getConnection("jdbc:postgresql://10.248.110.101:5432/OCMMS-HAR",
                        "postgres","nic");*/
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("ex: " + ex);
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            ex.printStackTrace();
            System.out.println("Driver not found.");
        }
        return con;
    }
}
