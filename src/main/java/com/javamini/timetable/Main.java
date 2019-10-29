/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javamini.timetable;

import java.util.*;

/**
 *
 * @author prabodhmayekar
 */
public class Main {
    public static void main(String[] args) {
        inputdata id = new inputdata();
        id.takeinput();
        inputdata.hoursperday = 7;
        inputdata.daysperweek = 5;
        Utility.cli = true;
        //Utility.printInputData();
        new TimeTable();
       //s Utility.printSlots();
        ArrayList<String> day = new ArrayList<>();
        day.add("Monday");
        day.add("Tuesday");
        day.add("Wenesday");
        day.add("Thusday");
        day.add("Friday");
        day.add("Saturday");
        day.add("Sunday");

        ArrayList<String> hour = new ArrayList<>();
        hour.add("08:00 PM");
        hour.add("09:00 AM");
        hour.add("10:00 AM");
        hour.add("11:00 AM");
        hour.add("12:00 PM");
        hour.add("01:00 PM");
        hour.add("02:00 PM");
        hour.add("03:00 PM");
        hour.add("04:00 PM");
        hour.add("05:00 PM");
        Utility.generateTimeTable(5,day,hour);
        
    }
}
