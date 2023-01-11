package org.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * @author Govardhan reddy
 */
public class Employee {
    /**
     * in this class perform CURD operations on payroll service database
     */
    static Scanner input = new Scanner(System.in);
    static String jdbc = "jdbc:mysql://localhost:3306/payroll_service";
    static String userName = "root";
    static String password = "Muni@5612";

    public static void edit() {
        /**
         * In this method edit the terisa basic pay details
         */
        try {
            Connection connection = DriverManager.getConnection(jdbc, userName, password);
            PreparedStatement prepare = connection.prepareStatement("update employee_payroll set BasicPay = ? where Employee_id = ?;");
            System.out.print("Enter id number : ");
            String id = input.next();
            System.out.print("Enter basic pay : ");
            int name = input.nextInt();
            prepare.setInt(1, name);
            prepare.setString(2, id);
            prepare.executeLargeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        edit();
    }

}
