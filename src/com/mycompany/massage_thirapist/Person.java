package com.mycompany.massage_thirapist;
import java.util.ArrayList; 

public abstract class Person {
    
    private int id;
    private String name;
    private char gender;
    private int age;
    private String phone;
    private BirthDate bDate;

    protected Person() {
        this.id = -1;
        this.name = "Unknown";
        this.gender = 'M';
        this.age = 18;
        this.phone = "00 0000 0000";
        this.bDate = new BirthDate();
    }

    protected Person(int id, String name, char gender,int age, String phone, BirthDate bDate) {
        setId(id);
        setName(name);
        setGender(gender);
        setAge(age);
        setPhone(phone);
        setbDate(bDate);
    }
    
    protected Person(int id, String name, char gender, int age, String phone, int month, int year) {
        setId(id);
        setName(name);
        setGender(gender);
        setAge(age);
        setPhone(phone);
        this.bDate = new BirthDate(month, year);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 0)
            this.id = id;
        else {
            System.out.println("The ID must be greater than zero!");
            this.id = -1;
        }
}

    public void setId(int id, ArrayList<Client> myClients) {
        if(id > 0){
            boolean exists = false;
            for(Client c : myClients){
                if(c.getId() == id){
                    exists = true;
                    break;
                }
            }
            if(!exists) 
                this.id = id;
            else
                System.out.println("This ID is already in use");
        }
        else{
            System.out.println("The ID must be greater than zero!");
            this.id = -1;
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
    
    
    
   
    
    
    
    public String toString() {
        return (
                "id: " + id 
               +"\nName: " + name
               +"\nGender: " + gender
               +"\nAge: " + age
               +"\nPhone: " + phone
               +"\nBirth Date: " + bDate.getFullDate()
               );
    }
    
    
    
    
    
}
