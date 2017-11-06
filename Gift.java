/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melvin.thetaubatepregnant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class Gift{
    //private final StringProperty donor = new SimpleStringProperty(this, "studentName");
    private StringProperty donor;
    private StringProperty desc;
    private StringProperty date;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public Gift(String donor, String desc, Date date) {
        this.donor =  new SimpleStringProperty(donor);
        this.desc = new SimpleStringProperty(desc);
        this.date = new SimpleStringProperty(sdf.format(date));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.donor);
        hash = 23 * hash + Objects.hashCode(this.desc);
        hash = 23 * hash + Objects.hashCode(this.date);
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
        final Gift other = (Gift) obj;
        if (!Objects.equals(this.donor, other.donor)) {
            return false;
        }
        if (!Objects.equals(this.desc, other.desc)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gift{" + "giver=" + donor + ", desc=" + desc + ", date=" + date + '}';
    }

    public String getDonor() {
        return donor.get();
    }

    public void setDonor(String giver) {
        this.donor = new SimpleStringProperty(giver);
    }

    public String getDesc() {
        return desc.get();
    }

    public void setDesc(String desc) {
        this.desc = new SimpleStringProperty(desc);
    }

    public String getDate() {
        return this.date.get();
        
    }

    public void setDate(Date date) {
        this.date = new SimpleStringProperty(sdf.format(date));
    }
}
