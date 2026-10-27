package com.pluralsight;

public class Employee {
    int employeeId;
    String name;
    double hoursWorked;
    double payRate;

    public Employee(int employeeId, String name, double hoursWokred, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWokred;
        this.payRate = payRate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getGrossPay() {
        double grossPay = payRate * hoursWorked;
        return grossPay;
    }

    @Override
    public String toString() {
        return String.format(
                "╔══════════════════════════════╗%n" +
                        "║ Employee                     ║%n" +
                        "╠══════════════════════════════╣%n" +
                        "║ %-13s%-15d ║%n" +
                        "║ %-13s%-15s ║%n" +
                        "║ %-13s%-15.2f ║%n" +
                        "║ %-13s%-15.2f ║%n" +
                        "╚══════════════════════════════╝",
                "ID:", employeeId,
                "Name:", name,
                "Hours:", hoursWorked,
                "Pay rate:", payRate);
    }

    public String toCSV() {
        return employeeId + "|" + name + "|" + hoursWorked + "|" + payRate;
    }

    public String toRow() {
        return String.format("%-5d | %-20s | %-12.1f | %-8.2f",
                employeeId, name, hoursWorked, payRate);
    }

    public String toCard() {
        return String.format(
                "┌────────────────────────────────┐\n" +
                        "│ ID:       %-20d │\n" +
                        "│ Name:     %-20s │\n" +
                        "│ Hours:    %-20.1f │\n" +
                        "│ Pay Rate: $%-19.2f │\n" +
                        "└────────────────────────────────┘",
                employeeId, name, hoursWorked, payRate
        );
    }
}
