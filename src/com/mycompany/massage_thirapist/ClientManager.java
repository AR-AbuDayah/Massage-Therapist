package com.mycompany.massage_thirapist;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientManager {
    static Scanner input = new Scanner(System.in);
    
    private ArrayList<Client> clients = new ArrayList<>();
    
    public ArrayList<Client> getClients() {
        return clients;
    }
    
    public void addClient() {
        System.out.println("Enter Client ID: ");
        int id = input.nextInt();   
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
        clients.add(new Client(id, name, gender, age, phone, month, year));
    }
    
    public void addClient(Client c) {
        clients.add(c);
    }
    
    public void addClient(int id, String name, char gender, int age, String phone, BirthDate bDate) {
        clients.add(new Client(id, name, gender, age, phone, bDate));
    }
    
    public void addClient(int id, String name, char gender, int age, String phone, int month, int year) {
        clients.add(new Client(id, name, gender, age, phone, new BirthDate(month,year)));
    }
    
    
    //----------------
    
    private Client findClient(String idOrName) {
      for (Client c : clients) {
            if (String.valueOf(c.getId()).equals(idOrName) || c.getName().equalsIgnoreCase(idOrName)) {
                return c;
            }
        }
        return null;
    }

    
    private Client findClient(int id, String name) {
        for (Client c : clients) {
           if (c.getId() == id || c.getName().equalsIgnoreCase(name)) {
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
    
    public Client searchClient(int id, String name) {
        System.out.print("Enter Client By (ID / Name): ");
        System.out.println("");
        
        Client c = findClient(id, name);
        
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
    
    public void removeClient(int id, String name) {
        System.out.print("Enter Client (ID / Name): ");
        System.out.println("");
        
        Client c = findClient(id, name);
        
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
                    c.setId(input.nextInt());
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
