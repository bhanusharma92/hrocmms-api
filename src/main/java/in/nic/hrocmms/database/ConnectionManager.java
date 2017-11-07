package in.nic.hrocmms.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static String driverName = "org.postgresql.Driver";
    private static Connection con;

    // root url are used in hrocmmsResource class to call our hrocmms application actions
    // public static final String rootUrl = "http://localhost:8080/HSPCB/";
     public static final String rootUrl = "http://hrocmms.nic.in/OCMMS/";
    // public static final String rootUrl = "http://164.100.163.19/HSPCB/";

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            try {
                // local db
                /*con = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/haryana_db",
                        "postgres","1234");*/
                // live db
                con = DriverManager.getConnection("jdbc:postgresql://10.248.110.101:5432/OCMMS-HAR",
                        "postgres","nic");
                // test db
                /*con = DriverManager.getConnection("jdbc:postgresql://10.25.121.245/OCMMS-TEST-HAR1",
                        "postgres","postgres");*/
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
