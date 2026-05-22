package com.mycompany.massage_thirapist;

import java.util.Calendar;

public class BirthDate {
    
    private int month;
    private int year;

    public BirthDate() {
        this.month = 1;
        this.year = 2007;
    }

    public BirthDate(int month, int year) {
//        this.month = month;
//        this.year = year;
          setMonth(month);
          setYear(year);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(month >= 1 && month <= 12)
            this.month = month;
        else
            this.month = 1;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        int y = Calendar.getInstance().get(Calendar.YEAR);
        if(year <= y-18)
            this.year = year;
        else
            this.year = 2007;
    }
    
    public String getFullDate() {
        return  (month + " - " + year);
    }
    
    public String toString() {
        return (
                "Month: " + month
               +"\nYear: " + year
               +"\nFull date: " + getFullDate()
                );
    }
    
    
}
    