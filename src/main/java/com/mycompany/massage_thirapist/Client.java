package com.mycompany.massage_thirapist;
import java.util.ArrayList; 

public class Client {
    
    private int client_id;
    private String name;
    private char gender;
    private int age;
    private String phone;
    private BirthDate bDate;

    public Client() {
        this.client_id = -1;
        this.name = "Unknown";
        this.gender = 'M';
        this.age = 18;
        this.phone = "00 0000 0000";
        this.bDate = new BirthDate();
    }

    public Client(int client_id, String name, char gender, int age, String phone, BirthDate bDate) {
        setClient_id(client_id);
        setName(name);
        setGender(gender);
        setAge(age);
        setPhone(phone);
        setbDate(bDate);
    }
    
    public Client(int client_id, String name, char gender, int age, String phone, int month, int year) {
        setClient_id(client_id);
        setName(name);
        setGender(gender);
        setAge(age);
        setPhone(phone);
        this.bDate = new BirthDate(month, year);
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        if(client_id > 0)
            this.client_id = client_id;
        else {
            System.out.println("The ID must be greater than zero!");
            this.client_id = -1;
        }
}

    public void setClient_id(int client_id, ArrayList<Client> clients) {
        if(client_id > 0){
            boolean exists = false;
            for(Client c : clients){
                if(c.getClient_id() == client_id){
                    exists = true;
                    break;
                }
            }
            if(!exists) 
                this.client_id = client_id;
            else
                System.out.println("This ID is already in use");
        }
        else{
            System.out.println("The ID must be greater than zero!");
            this.client_id = -1;
        }  
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
        switch(gender){
            case 'M': case 'm':
            case 'F': case 'f':
              this.gender = gender;
              break;

            default:
                this.gender = 'M';
        }
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
    
    public void  setbDate(int month, int year) {
        this.bDate = new BirthDate(month, year);
    }
    
    
    
    public static void printClientHeader() {
    System.out.printf("%-10s %-20s %-5s %-8s %-16s %-14s %n",
                     "ID",
                     "Name",
                     "Gender",
                     "Age",
                     "Phone",
                     "BirthDate"
                           
    );
    }
    
    public void printClientRow() {
        System.out.printf("%-10d %-20s %-5c %-8d %-16s %-14s %n",
                          client_id,
                          name,
                          gender,
                          age,
                          phone,
                          bDate.getFullDate()
        );
    }
    
    
    
    public String toString() {
        return (
                "id: " + client_id 
               +"\nName: " + name
               +"\nGender: " + gender
               +"\nAge: " + age
               +"\nPhone: " + phone
               +"\nBirth Date: " + bDate.getFullDate()
               );
    }
    
    
    
    
    
}
