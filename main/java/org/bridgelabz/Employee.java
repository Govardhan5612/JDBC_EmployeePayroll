package org.bridgelabz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            EmployeePayroll employee = new EmployeePayroll();
            Connection connection = DriverManager.getConnection(jdbc, userName, password);
            PreparedStatement prepare = connection.prepareStatement("update employee_payroll set BasicPay = ? where Employee_id = ?;");
            System.out.print("Enter id number : ");
            employee.setEmployee_id(input.nextInt());
            System.out.print("Enter basic pay : ");
            employee.setBasicPay(input.nextInt());
            prepare.setInt(1, employee.getBasicPay());
            prepare.setInt(2, employee.getEmployee_id());
            prepare.executeLargeUpdate();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void read() {
        /**
         * In this method read the payroll service database
         */
        EmployeePayroll employee = new EmployeePayroll();
        System.out.print("Enter name : ");
        employee.setName(input.next());
        try {
            Connection connection = DriverManager.getConnection(jdbc, userName, password);
            String query = "select * from employee_payroll where name=?";
            PreparedStatement prepare = connection.prepareStatement(query);
            prepare.setString(1, employee.getName());
            ResultSet result = prepare.executeQuery();
            while (result.next()) {
                System.out.print("id : ");
                System.out.print(result.getString("employee_id"));
                System.out.print(" , Name : ");
                System.out.print(result.getString("name"));

                System.out.print(" , basic pay : ");
                System.out.print(result.getInt("basicPay"));
                System.out.println();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) {
        read();
    }

}
