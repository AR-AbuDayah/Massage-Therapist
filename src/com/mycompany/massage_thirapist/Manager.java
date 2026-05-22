package com.mycompany.massage_thirapist;

public class Manager extends Employee {
    // Add employee to EmployeeManager
    public void addEmployee(Employee emp) {
        employeeManager.addEmployee(emp);
    }

    // Print all employees
    public void printAllEmployees() {
        employeeManager.printAllInfo();
    }

    // Find employee by id or name
    public Employee findEmployeeByIdOrName(String idOrName) {
        for (Employee emp : employeeManager.getEmployees()) {
            if (String.valueOf(emp.getId()).equals(idOrName) || emp.getName().equalsIgnoreCase(idOrName)) {
                return emp;
            }
        }
        return null;
    }

    // Remove employee by id and name
    public void removeEmployee(int id, String name) {
        employeeManager.removeEmployee(id, name);
    }
    private EmployeeManager employeeManager = new EmployeeManager();

    public Manager() {
        super();
    }

    public Manager(int id, String name, char gender, int age, String phone, BirthDate bDate, float salary) {
        super(id, name, gender, age, phone, bDate, salary);
    }

    public Manager(int id, String name, char gender, int age, String phone, int month, int year, float salary) {
        super(id, name, gender, age, phone, month, year, salary);
    }

//    public void addEmployee() {
//        employeeManager.addEmployee();
//    }
//
//    // public void addEmployee(Client c) {
//    // clientManager.addClient(c);
//    // }
//    //
//    // public void addClient(int id, String name, char gender, int age, String
//    // phone, BirthDate bDate) {
//    // clientManager.addClient(id, name, gender, age, phone, bDate);
//    // }
//    //
//    // public void addClient(int id, String name, char gender, int age, String
//    // phone, int month, int year) {
//    // clientManager.addClient(id, name, gender, age, phone, month, year);
//    // }
//
//    public void searchClient() {
//        employeeManager.searchEmployee();
//    }
//
//    // public void searchClient(int id, String name) {
//    // clientManager.searchClient(id, name);
//    // }
//
//    public void removeClient() {
//        employeeManager.removeEmployee();
//    }
//
//    // public void removeClient(int id, String name) {
//    // clientManager.removeClient(id, name);
//    // }
//
//    public void updateClient() {
//        employeeManager.updateEmployee();
//    }

    public static void printEmployeeHeader() {
        System.out.printf("%-10s %-20s %-5s %-8s %-16s %-14s %n",
                "ID",
                "Name",
                "Gender",
                "Age",
                "Phone",
                "BirthDate");

    }

    public void printEmployeeRow() {
        System.out.printf("%-10d %-20s %-5c %-8d %-16s %-14s %n",
                getId(),
                getName(),
                getGender(),
                getAge(),
                getPhone(),
                getbDate());
    }

    public void printAllClientsForAllEmployee() {
        for (Employee emp : employeeManager.getEmployees()) {
            System.out.println("Clients for employee " + emp.getName() + ":");
            for (Client c : emp.getClients()) {
                System.out.println(" - " + c.getName());
            }
        }
    }

}
