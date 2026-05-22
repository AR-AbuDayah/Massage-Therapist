package com.mycompany.massage_thirapist;

import com.mycompany.massage_thirapist.Client;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    Scanner input = new Scanner(System.in);
    
    
    private int employee_id;
    private String name;
    private char gender;
    private int age;
    private String phone;
    private BirthDate bDate;
    private ArrayList<Client> clients = new ArrayList<>();

    public Employee() {
        this.employee_id = -1;
        this.name = "Unknow";
        this.gender = 'M';
        this.age = 18;
        this.phone = "00 0000 0000";
        this.bDate = new BirthDate();
        this.clients = new ArrayList<>();
    }

    public Employee(int Employee_id, String name, char gender, int age, String phone, BirthDate bDate) {
        this.employee_id = Employee_id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.bDate = bDate;
        this.clients = new ArrayList<>();
    }
    
    public Employee(int Employee_id, String name, char gender, int age, String phone, int month, int year) {
        this.employee_id = Employee_id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.bDate = new BirthDate(month, year);
        this.clients = new ArrayList<>();
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int Employee_id) {
        this.employee_id = Employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BirthDate getbDate() {
        return bDate;
    }
    public void setbDate(BirthDate bDate) {
        this.bDate = bDate;
    }
    //------------------------------------------------------------
    public void addClient() {
        System.out.println("Enter Client ID: ");
        int Client_id = input.nextInt();   
        System.out.println("Enter Client Name: ");
        String name = input.next();
        System.out.println("Enter Client Gender: ");
        char gender = input.next().charAt(0);
        System.out.println("Enter Client Age: ");
        int age = input.nextInt();
        System.out.println("Enter Client Phone: ");
        String phone = input.next();
        System.out.println("Enter Client Month: ");
        int month = input.nextInt();
        System.out.println("Enter Client Year: ");
        int year = input.nextInt();
        clients.add(new Client(Client_id, name, gender, age, phone, month, year));
    }
    
    public void addClient(Client cltr) {
        clients.add(cltr);
    }
    
    public void addClient(int client_id, String name, char gender, int age, String phone, BirthDate bDate) {
        clients.add(new Client(client_id, name, gender, age, phone, bDate));
    }
    
    public void addClient(int client_id, String name, char gender, int age, String phone, int month, int year) {
        clients.add(new Client(client_id, name, gender, age, phone, new BirthDate(month,year)));
    }
    
    
    //----------------
    
    private Client findClient(String idOrName) {
      for (Client c : clients) {
            if (String.valueOf(c.getClient_id()).equals(idOrName) || c.getName().equalsIgnoreCase(idOrName)) {
                return c;
            }
        }
        return null;
    }

    
    private Client findClient(int client_id, String name) {
        for (Client c : clients) {
           if (c.getClient_id() == client_id || c.getName().equalsIgnoreCase(name)) {
              return c;
           }
      }
      return null;
    }
    
    private void printSearchResult(Client c) {
        if(c != null)
            System.out.println("Founded");
        else
            System.out.println("Not Founded");
    }
    
    private void printRemoveResult(Client c) {
        if (c != null) 
            System.out.println("Client deleted");
        else 
            System.out.println("Client not Found");
    }

    //----------------------
    
    public Client searchClient() {
        System.out.print("Enter Client By (ID / Name): ");
        System.out.println("");
        
        String index = input.next();
        Client c = findClient(index);
        printSearchResult(c);
        return c;
    }
    
    public Client searchClient(int client_id, String name) {
        System.out.print("Enter Client By (ID / Name): ");
        System.out.println("");
        
        Client c = findClient(client_id, name);
        
        printSearchResult(c);
        return c;
    }
    
    
    
    public void removeClient() {
        System.out.print("Enter Client (ID / Name): ");
        System.out.println("");
        
        String index = input.next();
        Client c = findClient(index);
        if (c != null) 
            clients.remove(c);
        printRemoveResult(c);
        
    }
    
    public void removeClient(int client_id, String name) {
        System.out.print("Enter Client (ID / Name): ");
        System.out.println("");
        
        Client c = findClient(client_id, name);
        
        if (c != null)
            clients.remove(c);
        printRemoveResult(c);
    }
    
    public void updateClient() {
        
        System.out.println("Enter Client (ID / Name) to Update: ");
        String index = input.next();
        
        Client c = findClient(index);
        
        if(c != null){
            System.out.println("Client Found: " + c.getName());
            System.out.println("Choice Number of Field to Update:");
            System.out.println("1. Update ID");
            System.out.println("2. Update Name");
            System.out.println("3. Update Gender (M / F)");
            System.out.println("4. Update Age");
            System.out.println("5. Update Phone");
            System.out.println("6. Update BirthDate");
            int choice = input.nextInt();
            
            switch(choice){
                case 1:
                    System.out.println("Enter New ID: ");
                    c.setClient_id(input.nextInt());
                    break;
                
                case 2:
                    System.out.println("Enter New Name: ");
                    c.setName(input.next());
                    break;
                
                case 3:
                    System.out.println("Enter New Gender: ");
                    c.setGender(input.next().charAt(0));
                    break;
                
                case 4:
                    System.out.println("Enter New Age: ");
                    c.setAge(input.nextInt());
                    break;
                
                case 5:
                    System.out.println("Enter New Phone: ");
                    c.setPhone(input.next());
                    break;
                
                case 6:
                    System.out.println("Enter New Month: ");
                    int month = input.nextInt();
                    System.out.println("Enter New Year: ");
                    int year = input.nextInt();
                    c.setbDate(new BirthDate(month, year));
                    break;
                
                default:
                    System.out.println("Invalid Choice!!!!");
                    break;
            }    
        }
        else
            System.out.println("client Not Found");
        
    }
    
    private void drowLine() {
        for(int i=0; i<73; i++)
            System.out.print("-");
        System.out.println("");
    }
    
    public void printAllInfo() {
        drowLine();
        Client.printClientHeader();
        drowLine();
        for(Client c : clients){
            c.printClientRow();
        }
        drowLine();
    }
    
    
    
    
}
