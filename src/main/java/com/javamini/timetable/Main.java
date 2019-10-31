/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javamini.timetable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 *
 * @author prabodhmayekar
 */
public class Main {
    public static void main(String[] args) {
        AssignTeacher id = new AssignTeacher();
        id.takeinput();
        AssignTeacher.hoursperday = 7;
        AssignTeacher.daysperweek = 5;
        TimeTableGenerator.cli = true;
        //Utility.printInputData();
        new SlotGenerator();
       // TimeTableGenerator.printSlots();
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
        TimeTableGenerator.generateTimeTable(5,day,hour);
//        SplashScreen splash = new SplashScreen();
//        MainMenu mainMenu = new MainMenu();
//        mainMenu.man_group.setOpaque(true);
//        mainMenu.man_sub.setOpaque(true);
//        mainMenu.man_teacher.setOpaque(true);
//        mainMenu.man_tt.setOpaque(true);
//        splash.setVisible(true);
//        try {
//            
//            for (int i = 0; i < 100; i++) {
//                Thread.sleep(100);
//                splash.progressBar.setValue(i);
//                
//            }
//            splash.setVisible(false);
//            mainMenu.setVisible(true);
//            
//        } catch (Exception e) {
//        }
//        
//        mainMenu.man_group.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//        });
//                  
//        
    }
}
