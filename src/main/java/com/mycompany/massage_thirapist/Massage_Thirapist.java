package com.mycompany.massage_thirapist;

import java.util.ArrayList;
import java.util.Scanner;

public class Massage_Thirapist {
static Scanner input = new Scanner(System.in);
static Employee e1 = new Employee();

    public static void main(String[] args) {
        ArrayList<Employee> Employees = new ArrayList<>();
        
        e1.addClient(new Client(1, "Ali", 'M', 18, "0779999999", new BirthDate(3, 2000)));
        e1.addClient(new Client(2, "Baraa", 'M', 20, "0789999999", new BirthDate(24, 2022)));
        e1.addClient(new Client(3, "Ali", 'M', 23, "0799999999", new BirthDate(11, 1952)));
        
        
        String choice;
        do{
            drawMenu();
            choice = input.next();
            
            System.out.println("____________________________________");
            ControlRun(choice);
            
        } 
        while(!choice.equalsIgnoreCase("E"));
        
        
        
        
        
    }//-----------------------
    
    public static void drawMenu(){
        System.out.println("____________________________________");
        System.out.println("P - Print Clients");
        System.out.println("A - Add Client");
        System.out.println("D - delete Client");
        System.out.println("S - search fo A Client (ID / Name)");
        System.out.println("U - Update Client Data");
        System.out.println("E - Exit");
        
        System.out.print("Enter Your Choice: ");
    }
    
    public static void ControlRun(String Choice) {
        
        switch(Choice.toUpperCase()){
            case "P":
                e1.printAllInfo();
                break;
                
            case "A":
                e1.addClient();
                System.out.println("==============================");
                System.out.println("|        Client Added        |");
                System.out.println("==============================");
                break;
                
            case "D":
                e1.removeClient();
                System.out.println("==============================");
                System.out.println("|       Client Deleted       |");
                System.out.println("==============================");
                break;
                
            case "S":
                e1.searchClient();
                break;
                
            case "U":
                e1.updateClient();
                System.out.println("==============================");
                System.out.println("|       Client Updated       |");
                System.out.println("==============================");
                break;
                
            case "E":
                System.out.println("==============================");
                System.out.println("|   You ended the program    |");
                System.out.println("==============================");
                break;
                
            default:
                System.out.println("==============================");
                System.out.println("|    Error No such choice!   |");
                System.out.println("==============================");
                break;
        }
        
    }
    
    
}
