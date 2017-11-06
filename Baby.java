/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melvin.thetaubatepregnant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AccessTech
 */
public class Baby{
    private StringProperty birthday;
    private StringProperty name;
    private StringProperty gender;
    private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
    public Baby(){
    }
    
    public Baby(String birthday, String name, char gender){
            this.birthday = new SimpleStringProperty(birthday);
            this.name = new SimpleStringProperty(name);
            this.gender = new SimpleStringProperty(String.valueOf(gender));
    }
    
    public Baby(Date birthday, String name, char gender){
        this.birthday = new SimpleStringProperty(sdf.format(birthday));
            this.name = new SimpleStringProperty(name);
            this.gender = new SimpleStringProperty(String.valueOf(gender));
    }

    public String getBirthday() {
        return this.birthday.get();
    }
    
    public String getBirthdays() {
        return sdf.format(this.birthday.get());
    }

    public void setBirthday(Date birthday) {
        this.birthday = new SimpleStringProperty(sdf.format(birthday));
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.birthday);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.gender);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Baby other = (Baby) obj;
        if (this.gender != other.gender) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Baby{" + "birthday=" + birthday + ", name=" + name + ", gender=" + gender + '}';
    }
    
    // If a given kid is older than the current one
    public boolean isOlder(Baby baby){
        try {
            return sdf.parse(baby.getBirthday()).after(sdf.parse(this.getBirthday()));
        } catch (ParseException ex) {
            Logger.getLogger(Baby.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    // The actual age of the kid in days
    public long howOld() throws ParseException{
        Calendar cal = Calendar.getInstance();
        Date today = cal.getTime();
        
        long dateSubtract = sdf.parse(this.getBirthday()).getTime() - today.getTime();
        long time = 1000 * 60 * 60 * 24;
        return dateSubtract / time;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public char getGender() {
        return gender.get().charAt(0);
    }

    public void setGender(char gender) {
        this.gender = new SimpleStringProperty(String.valueOf(gender));
    }
    
    
    public static Comparator<Baby> NameComparator
                          = new Comparator<Baby>() {

        public int compare(Baby baby1, Baby baby2) {

          String name1 = baby1.getName().toUpperCase();
          String name2 = baby2.getName().toUpperCase();

          //ascending order
          return name1.compareTo(name2);
        }

    };
    
    public static Comparator<Baby> DOBComparator
                          = new Comparator<Baby>() {

        public int compare(Baby baby1, Baby baby2) {
            try {
                Date dob1 = sdf.parse(baby1.getBirthday());
                Date dob2 = sdf.parse(baby2.getBirthday());
                //ascending order
                return dob2.compareTo(dob1);
            } catch (ParseException ex) {
                Logger.getLogger(Baby.class.getName()).log(Level.SEVERE, null, ex);
            }
            return -1;
        }
    };
    
}
