package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("employees.csv");
            BufferedReader bufferedReader= new BufferedReader(fileReader);

            String line;
            String headerLine = bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {
                String[] fields = line.split(Pattern.quote("|"));

                int employeeId = Integer.parseInt(fields[0]);
                String name = fields[1];
                Double hoursWorked = Double.parseDouble(fields[2]);
                Double payRate = Double.parseDouble(fields[3]);
                Employee employee = new Employee(employeeId, name, hoursWorked, payRate);
                employees.add(employee);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("There was an error reading the transactions file. Check the location of the file.");
        }

        printEmployeeSquare(employees);
//        printEmployeeCards(employees);
//        printEmployeeTable(employees);
    }

    private static void printEmployeeCards(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toRow());
        }
    }

    private static void printEmployeeTable(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toCard());
        }
    }

    private static void printEmployeeSquare(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }


}
