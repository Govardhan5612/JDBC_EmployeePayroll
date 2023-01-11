package org.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Govardhan reddy
 */
public class Employee {
    /**
     * create a connection between SQL to java server
     */
    static String jdbc = "jdbc:mysql://localhost:3306/payroll_service";
    static String userName = "root";
    static String password = "Muni@5612";
    static Connection connection;

    public static void main(String[] args) {
        /**
         * if path address is correct try block is work
         * else catch block is work
         */
        try {
            connection = DriverManager.getConnection(jdbc, userName, password);
            System.out.println("JDBC is successful");
        } catch (Exception exception) {
            exception.printStackTrace();
            System.out.println("JDBC is not successful");

        }
    }
}
