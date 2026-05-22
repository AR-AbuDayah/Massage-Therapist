package com.mycompany.massage_thirapist;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
    static Scanner input = new Scanner(System.in);
    
    private ArrayList<Employee> employees = new ArrayList<>();
     
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    
    public void addEmployee() {
        System.out.println("Enter Employee ID: ");
        int id = input.nextInt();   
        System.out.println("Enter Employee Name: ");
        String name = input.next();
        System.out.println("Enter Employee Gender: ");
        char gender = input.next().charAt(0);
        System.out.println("Enter Employee Age: ");
        int age = input.nextInt();
        System.out.println("Enter Employee Phone: ");
        String phone = input.next();
        System.out.println("Enter Employee Month: ");
        int month = input.nextInt();
        System.out.println("Enter Employee Year: ");
        int year = input.nextInt();
        System.out.println("Enter Employee salary: ");
        float salary = input.nextFloat();
        employees.add(new Employee(id, name, gender, age, phone, month, year, salary));
    }
    
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }
    
    public void addEmployee(int id, String name, char gender, int age, String phone, BirthDate bDate, float salary) {
        employees.add(new Employee(id, name, gender, age, phone, bDate, salary));
    }
    
    public void addEmployee(int id, String name, char gender, int age, String phone, int month, int year, float salary) {
        employees.add(new Employee(id, name, gender, age, phone, new BirthDate(month,year), salary));
    }
    
    
    //----------------
    
    private Employee findEmployee(String idOrName) {
      for (Employee emp : employees) {
            if (String.valueOf(emp.getId()).equals(idOrName) || emp.getName().equalsIgnoreCase(idOrName)) {
                return emp;
            }
        }
        return null;
    }

    
    private Employee findEmployee(int id, String name) {
        for (Employee emp : employees) {
           if (emp.getId() == id || emp.getName().equalsIgnoreCase(name)) {
              return emp;
           }
      }
      return null;
    }
    
    private void printSearchResult(Employee emp) {
        if(emp != null)
            System.out.println("Founded");
        else
            System.out.println("Not Founded");
    }
    
    private void printRemoveResult(Employee emp) {
        if (emp != null) 
            System.out.println("Client deleted");
        else 
            System.out.println("Client not Found");
    }

    //----------------------
    
    public Employee searchEmployee() {
        System.out.print("Enter Client By (ID / Name): ");
        System.out.println("");
        
        String index = input.next();
        Employee emp = findEmployee(index);
        printSearchResult(emp);
        return emp;
    }
    
    public Employee searchEmployee(int id, String name) {
        System.out.print("Enter Client By (ID / Name): ");
        System.out.println("");
        
        Employee emp = findEmployee(id, name);
        
        printSearchResult(emp);
        return emp;
    }
    
    
    
    public void removeEmployee() {
        System.out.print("Enter Client (ID / Name): ");
        System.out.println("");
        
        String index = input.next();
        Employee emp = findEmployee(index);
        
        if (emp != null) 
            employees.remove(emp);
        printRemoveResult(emp);
        
    }
    
    public void removeEmployee(int id, String name) {
        System.out.print("Enter Client (ID / Name): ");
        System.out.println("");
        
        Employee emp = findEmployee(id, name);
        
        if (emp != null)
            employees.remove(emp);
        printRemoveResult(emp);
    }
    
    public void updateEmployee() {
        
        System.out.println("Enter Client (ID / Name) to Update: ");
        String index = input.next();
        
        Employee emp = findEmployee(index);
        
        if(emp != null){
            System.out.println("Client Found: " + emp.getName());
            System.out.println("Choice Number of Field to Update:");
            System.out.println("1. Update ID");
            System.out.println("2. Update Name");
            System.out.println("3. Update Gender (M / F)");
            System.out.println("4. Update Age");
            System.out.println("5. Update Phone");
            System.out.println("6. Update BirthDate");
            System.out.println("7. Update Salary");
            int choice = input.nextInt();
            
            switch(choice){
                case 1:
                    System.out.println("Enter New ID: ");
                    emp.setId(input.nextInt());
                    break;
                
                case 2:
                    System.out.println("Enter New Name: ");
                    emp.setName(input.next());
                    break;
                
                case 3:
                    System.out.println("Enter New Gender: ");
                    emp.setGender(input.next().charAt(0));
                    break;
                
                case 4:
                    System.out.println("Enter New Age: ");
                    emp.setAge(input.nextInt());
                    break;
                
                case 5:
                    System.out.println("Enter New Phone: ");
                    emp.setPhone(input.next());
                    break;
                
                case 6:
                    System.out.println("Enter New Month: ");
                    int month = input.nextInt();
                    System.out.println("Enter New Year: ");
                    int year = input.nextInt();
                    emp.setbDate(new BirthDate(month, year));
                    break;
                    
                case 7:
                    System.out.println("Enter New Salary: ");
                    emp.setSalary(input.nextFloat());
                    break;
                
                default:
                    System.out.println("Invalid Choice!!!!");
                    break;
            }    
        }
        else
            System.out.println("Employee Not Found");
        
    }
    
    private void drowLine() {
        for(int i=0; i<73; i++)
            System.out.print("-");
        System.out.println("");
    }
    
    public void printAllInfo() {
        drowLine();
        Employee.printEmployeeHeader();
        drowLine();
        for(Employee emp : employees){
            emp.printEmployeeRow();
        }
        drowLine();
    }

    
    
    
    
     
    
    
}
