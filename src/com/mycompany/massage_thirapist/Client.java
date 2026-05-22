package com.mycompany.massage_thirapist;
import java.util.ArrayList; 

public class Client extends Person{

    public Client() {
        super();
    }

    public Client(int id, String name, char gender, int age, String phone, BirthDate bDate) {
        super(id, name, gender, age, phone, bDate);
    }

    public Client(int id, String name, char gender, int age, String phone, int month, int year) {
        super(id, name, gender, age, phone, month, year);
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
                          getId(),
                          getName(),
                          getGender(),
                          getAge(),
                          getPhone(),
                          getbDate()
        );
    }
    
    
    
    
}
