package com.mycompany.massage_thirapist;

import java.util.ArrayList;
import java.util.Scanner;

public class Massage_Thirapist {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Manager manager = new Manager(1, "Oday", 'M', 50, "0790909090", 5, 1975, 1000);

        Employee emp1 = new Employee(1, "Baraa", 'M', 23, "0770000000", 11, 2002, 290);
        Employee emp2 = new Employee(2, "Sara", 'F', 18, "0780000000", 12, 2006, 300);

        emp1.addClient(101, "Mazen", 'M', 41, "0799999999", 5, 1984);
        emp1.addClient(102, "Ahmad", 'M', 22, "0788888888", 3, 2003);

        emp2.addClient(103, "Sozan", 'F', 45, "0777777777", 8, 1980);
        emp2.addClient(104, "Fatheya", 'F', 60, "0777777777", 1, 1965);

    manager.addEmployee(emp1);
    manager.addEmployee(emp2);

        managerMenu(manager);
    }
    
   

        

    public static void managerMenu(Manager manager) {
        String choice;
        do {
            System.out.println("\n===== Manager Menu =====");
            System.out.println("1 - Print All Employees");
            System.out.println("2 - Print All Clients for All Employees");
            System.out.println("3 - Add Employee");
            System.out.println("4 - Delete Employee");
            System.out.println("5 - Update Employee");
            System.out.println("6 - Search Employee");
            System.out.println("7 - Print All Clients for One Employee");
            System.out.println("8 - Exit");
            System.out.print("Enter your choice: ");
            choice = input.next();

            switch (choice) {
                case "1":
                    manager.printAllEmployees();
                    break;
                case "2":
                    manager.printAllClientsForAllEmployee();
                    break;
                case "3":
                    System.out.println("Enter Employee Data:");
                    System.out.print("ID: ");
                    int id = input.nextInt();
                    System.out.print("Name: ");
                    String name = input.next();
                    System.out.print("Gender (M/F): ");
                    char gender = input.next().charAt(0);
                    System.out.print("Age: ");
                    int age = input.nextInt();
                    System.out.print("Phone: ");
                    String phone = input.next();
                    System.out.print("Birth Month: ");
                    int month = input.nextInt();
                    System.out.print("Birth Year: ");
                    int year = input.nextInt();
                    System.out.print("Salary: ");
                    float salary = input.nextFloat();
                    Employee newEmp = new Employee(id, name, gender, age, phone, month, year, salary);
                    manager.addEmployee(newEmp);
                    System.out.println("Employee Added!");
                    break;
                case "4":
                    System.out.print("Enter Employee ID to delete: ");
                    int removeId = input.nextInt();
                    Employee toRemove = manager.findEmployeeByIdOrName(String.valueOf(removeId));
                    if (toRemove != null) {
                        manager.removeEmployee(removeId, toRemove.getName());
                        System.out.println("Employee deleted!");
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case "5":
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = input.nextInt();
                    Employee toUpdate = manager.findEmployeeByIdOrName(String.valueOf(updateId));
                    if (toUpdate != null) {
                        System.out.println("Update fields:");
                        System.out.println("1 - Name\n2 - Gender\n3 - Age\n4 - Phone\n5 - Birth Month\n6 - Birth Year\n7 - Salary");
                        System.out.print("Enter field number: ");
                        int field = input.nextInt();
                        switch (field) {
                            case 1:
                                System.out.print("New Name: ");
                                toUpdate.setName(input.next());
                                break;
                            case 2:
                                System.out.print("New Gender (M/F): ");
                                toUpdate.setGender(input.next().charAt(0));
                                break;
                            case 3:
                                System.out.print("New Age: ");
                                toUpdate.setAge(input.nextInt());
                                break;
                            case 4:
                                System.out.print("New Phone: ");
                                toUpdate.setPhone(input.next());
                                break;
                            case 5:
                                System.out.print("New Birth Month: ");
                                int newMonth = input.nextInt();
                                toUpdate.getbDate().setMonth(newMonth);
                                break;
                            case 6:
                                System.out.print("New Birth Year: ");
                                int newYear = input.nextInt();
                                toUpdate.getbDate().setYear(newYear);
                                break;
                            case 7:
                                System.out.print("New Salary: ");
                                toUpdate.setSalary(input.nextFloat());
                                break;
                            default:
                                System.out.println("Invalid field!");
                        }
                        System.out.println("Employee updated!");
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case "6":
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = input.nextInt();
                    Employee found = manager.findEmployeeByIdOrName(String.valueOf(searchId));
                    if (found != null) {
                        System.out.println("Employee found:");
                        found.printEmployeeRow();
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case "7":
                    System.out.print("Enter Employee ID to show clients: ");
                    int empId = input.nextInt();
                    Employee emp = manager.findEmployeeByIdOrName(String.valueOf(empId));
                    if (emp != null) {
                        System.out.println("Clients for employee " + emp.getName() + ":");
                        for (Client c : emp.getClients()) {
                            System.out.println(" - " + c.getName());
                        }
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case "8":
                    System.out.println("Exiting Manager Interface.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (!choice.equals("8"));
    }

    public static void employeeMenu(Employee emp) {
        String choice;
        do {
            System.out.println("\n===== Employee Menu =====");
//            System.out.println("1 - Print All Clien");
            System.out.println("2 - add client");
            System.out.println("3 - remove");
            System.out.println("4 - exit");
            System.out.print("enter choice: ");
            choice = input.next();

            switch (choice) {
//                case "1":
//                    emp.printAllClients();
//                    break;
                case "2":
                   emp.addClient();
                    System.out.println("==============================");
                    System.out.println("|        Client Added        |");
                    System.out.println("==============================");
                    break;
                    
                case "3":
                    emp.removeClient();
                System.out.println("==============================");
                System.out.println("|       Client Deleted       |");
                System.out.println("==============================");
                break;
                
                case "4":
                    System.out.println("exit employye menu.");
                    break;
                default:
                    System.out.println("eroor");
            }
        } while (!choice.equals("4"));
    }
}
    
    //-------------------
    
//    public static void drawMenu() {
//        System.out.println("____________________________________");
//        System.out.println("P - Print Clients");
//        System.out.println("A - Add Client");
//        System.out.println("D - delete Client");
//        System.out.println("S - search fo A Client (ID / Name)");
//        System.out.println("U - Update Client Data");
//        System.out.println("E - Exit");
//
//        System.out.print("Enter Your Choice: ");
//    }

//    public static void ControlRun(String Choice) {
//
//        switch (Choice.toUpperCase()) {
//            case "P":
//                emp1.pr();
//                break;
//
//            case "A":
//                e1.addClient();
//                System.out.println("==============================");
//                System.out.println("|        Client Added        |");
//                System.out.println("==============================");
//                break;
//
//            case "D":
//                e1.removeClient();
//                System.out.println("==============================");
//                System.out.println("|       Client Deleted       |");
//                System.out.println("==============================");
//                break;
//
//            case "S":
//                e1.searchClient();
//                break;
//
//            case "U":
//                e1.updateClient();
//                System.out.println("==============================");
//                System.out.println("|       Client Updated       |");
//                System.out.println("==============================");
//                break;
//
//            case "E":
//                System.out.println("==============================");
//                System.out.println("|   You ended the program    |");
//                System.out.println("==============================");
//                break;
//
//            default:
//                System.out.println("==============================");
//                System.out.println("|    Error No such choice!   |");
//                System.out.println("==============================");
//                break;
//        }
//
//    }


