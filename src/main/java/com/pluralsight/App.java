package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.println("Enter the name of the file you want to read: ");
        String fileName = scanner.nextLine().trim().toLowerCase();

        System.out.println("Enter the name of the payroll file to create: ");
        String payrollFileName = scanner.nextLine();

        try {
            FileWriter fileWriter = new FileWriter(payrollFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("ID | Name | Gross Pay\n");
            bufferedWriter.write("111 | Cameron Tay | 3277.65\n");
            bufferedWriter.write("222 | James Tee | 2150.00\n");

            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Unable to create another file.");
        }

        try {
            FileReader fileReader = new FileReader(fileName);
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
