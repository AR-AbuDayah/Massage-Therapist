package com.mycompany.massage_thirapist;

import static com.mycompany.massage_thirapist.ClientManager.input;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Person{
    private ClientManager clientManager = new ClientManager();
    private float salary;
    
    public ArrayList<Client> getClients() {
        return clientManager.getClients();
    }
    
    public Employee() {
        super();
        this.salary = 290;
    }

    public Employee(int id, String name, char gender, int age, String phone, BirthDate bDate, float salary) {
        super(id, name, gender, age, phone, bDate);
        setSalary(salary);
        
    }

    public Employee(int id, String name, char gender, int age, String phone, int month, int year, float salary) {
        super(id, name, gender, age, phone, month, year);
        setSalary(salary);
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        if(salary >= 290)
            this.salary = salary;
        else
            this.salary = 290;
    }
    
    
    
    //--------------------------------------------------------
    
    public void addClient() {
        clientManager.addClient();
    }
    
    public void addClient(Client c) {
        clientManager.addClient(c);
    }
    
    public void addClient(int id, String name, char gender, int age, String phone, BirthDate bDate) {
        clientManager.addClient(id, name, gender, age, phone, bDate);
    }
    
    public void addClient(int id, String name, char gender, int age, String phone, int month, int year) {
        clientManager.addClient(id, name, gender, age, phone, month, year);
    }
    
    public void searchClient() {
        clientManager.searchClient();
    }
    
    public void searchClient(int id, String name) {
        clientManager.searchClient(id, name);
    }
    
    public void removeClient() {
        clientManager.removeClient();
    }
    
    public void removeClient(int id, String name) {
        clientManager.removeClient(id, name);
    }
    
    public void updateClient() {
        clientManager.updateClient();
    }
    
    public static void printEmployeeHeader() {
        System.out.printf("%-10s %-20s %-5s %-8s %-16s %-14s %n",
                          "ID",
                          "Name",
                          "Gender",
                          "Age",
                          "Phone",
                          "BirthDate"
    );
    
    }
    
    public void printEmployeeRow() {
        System.out.printf("%-10d %-20s %-5c %-8d %-16s %-14s %n",
                          getId(),
                          getName(),
                          getGender(),
                          getAge(),
                          getPhone(),
                          getbDate()
        );
    }
    
    
}
