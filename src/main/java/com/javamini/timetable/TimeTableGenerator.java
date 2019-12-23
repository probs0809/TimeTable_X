/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javamini.timetable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prabodhmayekar
 */

public class TimeTableGenerator {
    static SplashScreen ss = new SplashScreen();
    static DatabaseConnection db = new DatabaseConnection();
    static boolean cli = false;

    // debugging purpose only
    public static void printInputData() {

        System.out.println("Nostgrp=" + AssignTeacher.nostudentgroup + " Noteachers=" + AssignTeacher.noteacher
                + " daysperweek=" + AssignTeacher.daysperweek + " hoursperday=" + AssignTeacher.hoursperday);
        for (int i = 0; i < AssignTeacher.nostudentgroup; i++) {

            System.out.println(AssignTeacher.studentgroup[i].id + " " + AssignTeacher.studentgroup[i].name);
            for (int j = 0; j < AssignTeacher.studentgroup[i].nosubject; j++) {
                System.out.println(
                        AssignTeacher.studentgroup[i].subjectid[j] + " " + AssignTeacher.studentgroup[i].hours[j]
                                + " hrs " + new Teacher().getTeacherName(AssignTeacher.studentgroup[i].teacherid[j])
                                + " " + AssignTeacher.studentgroup[i].teacherid[j]);

            }
            System.out.println("");
        }

        for (int i = 0; i < AssignTeacher.noteacher; i++) {
            System.out.println(AssignTeacher.teacher[i].id + " " + AssignTeacher.teacher[i].name + " "
                    + AssignTeacher.teacher[i].subject + " " + AssignTeacher.teacher[i].assigned);
        }
    }

    public static void printSlots() {
        int days = AssignTeacher.daysperweek;
        int hours = AssignTeacher.hoursperday;
        int nostgrp = AssignTeacher.nostudentgroup;
        System.out.println("----Slots----");
        for (int i = 0; i < days * hours; i++) {
            System.out.println(i + "- " + SlotGenerator.slot[i].studentgroup.id + " " + SlotGenerator.slot[i].subject
                    + " " + new Teacher().getTeacherName(SlotGenerator.slot[i].teacherid));

            if ((i + 1) % (hours * days) == 0)
                System.out.println("******************************");
        }
    }

    public static void generateTimeTable(int GrpId, ArrayList<String> day, ArrayList<String> hour,GenerateTimeTable genTimeTable, ViewTimeTable v) {
        int days = AssignTeacher.daysperweek;
        int hours = AssignTeacher.hoursperday;
        int nostgrp = AssignTeacher.nostudentgroup;
        v.GrpId = GrpId;
        int arr2[][] = new int[days][hours];

        db.executeUpdate("DELETE FROM TimeTable WHERE GrpId = " + GrpId);

        System.out.println("----Slots----");
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < days * hours; i++) {
            if (SlotGenerator.slot[i].studentgroup.id == GrpId) {
                arr.add(i);
                System.out.println(SlotGenerator.slot[i].subject + " : " + i);
            }

        }

        // System.out.println(arr);
        if (cli == true) {
            cliMode(arr, arr2, day, hour);
        } else {
            guiMode(arr, arr2, day, hour, genTimeTable, v);
        }

    }

    public static void cliMode(ArrayList<Integer> arr, int arr2[][], ArrayList<String> day, ArrayList<String> hour) {
        String b;
        Scanner s = new Scanner(System.in);
        System.out.println("Do you want to Insert Manually: y || n ");
        b = s.nextLine();
        while (!b.equalsIgnoreCase("n")) {
            System.out.println("Manually Insert Timetable");
            Scanner scan = new Scanner(System.in);

            System.out.println("Day: ");
            String sDay = s.nextLine();
            System.out.println("Hour: ");
            String sHour = s.nextLine();
            System.out.println("Lecture: ");
            int sLecture = scan.nextInt();
            ResultSet rs = db.executeQuery("SELECT TeacherId FROM TimeTable WHERE Day = '" + sDay + "' AND Hour = '"
                    + sHour + "' AND TeacherId = " + SlotGenerator.slot[sLecture].teacherid);
            try {
                if (!rs.next()) {
                    arr2[day.indexOf(sDay)][hour.indexOf(sHour)] = sLecture;
                    arr.remove(arr.indexOf(arr2[day.indexOf(sDay)][hour.indexOf(sHour)]));
                } else {
                    System.out.println("Sorry the teacher is busy");
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.println("Countinue: y || n ");
            b = s.nextLine();
        }
        autoGenerator(arr, arr2, day, hour);
    }

    public static void autoGenerator(ArrayList<Integer> arr, int arr2[][], ArrayList<String> day, ArrayList<String> hour) {
        int days = AssignTeacher.daysperweek;
        int hours = AssignTeacher.hoursperday;
        Random r = new Random();
        System.out.println(arr);
        int k = 0;

        while (!arr.isEmpty()) {
            int d = r.nextInt(days);
            int h = r.nextInt(hours);
            if (arr2[d][h] == 0) {
                if (h == hours / 2 && "FR-0000".equals(SlotGenerator.slot[arr.get(k)].subject)) {
                    arr2[d][h] = arr.get(k);
                    arr.remove(k);
                } else if (h != hours / 2) {
                    ResultSet rs = db.executeQuery("SELECT TeacherId FROM TimeTable WHERE Day = '" + d + "' AND Hour = '" + h + "' AND TeacherId = " + SlotGenerator.slot[k].teacherid);
                    try {
                        if (!rs.next()) {
                            arr2[d][h] = arr.get(k);
                            arr.remove(k);
                        } else {

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TimeTableGenerator.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }

        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                db.executeUpdate("INSERT INTO TimeTable(Day,Hour,SubId,GrpId,TeacherId) VALUES('" + day.get(i) + "','"
                        + hour.get(j) + "','" + SlotGenerator.slot[arr2[i][j]].subject + "',"
                        + SlotGenerator.slot[arr2[i][j]].studentgroup.id + ","
                        + SlotGenerator.slot[arr2[i][j]].teacherid + ")");
                System.out.println(
                        day.get(i) + " : " + hour.get(j) + " - " + SlotGenerator.slot[arr2[i][j]].subject + " ");
            }
        }
    }

    private static void guiMode(ArrayList<Integer> arr, int[][] arr2, ArrayList<String> day, ArrayList<String> hour,
            GenerateTimeTable generateTimeTable, ViewTimeTable v) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.

        initInput(arr, day, hour, generateTimeTable);

        generateTimeTable.addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change
                // body of generated methods, choose Tools | Templates.
                String sDay = generateTimeTable.day.getItemAt(generateTimeTable.day.getSelectedIndex());
                String sHour = generateTimeTable.hour.getItemAt(generateTimeTable.hour.getSelectedIndex());
                int subIndex = generateTimeTable.sub.getSelectedIndex();
                ss.progressBar.setValue(50);

                if (sDay.equals("Select Day") || sHour.equals("Select Hour") || subIndex == 0) {

                } else {
                    int sLecture = arr.get(subIndex - 1);
                    ResultSet rs = db.executeQuery("SELECT TeacherId FROM TimeTable WHERE Day = '" + sDay
                            + "' AND Hour = '" + sHour + "' AND TeacherId = " + SlotGenerator.slot[sLecture].teacherid);
                    try {
                        if (!rs.next()) {
                            arr2[day.indexOf(sDay)][hour.indexOf(sHour)] = sLecture;
                            arr.remove(arr.indexOf(arr2[day.indexOf(sDay)][hour.indexOf(sHour)]));
                            initInput(arr, day, hour, generateTimeTable);
                        } else {
                            System.out.println("Sorry the teacher is busy");
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                ss.progressBar.setValue(80);
                ss.dispose();
            }
        });

        generateTimeTable.auto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change
                // body of generated methods, choose Tools | Templates.

                autoGenerator(arr, arr2, day, hour);
                generateTimeTable.dispose();
                v.initInput();
                v.setVisible(true);
            }
        });
        System.out.println("Sucessfuly reached in gui");
    }

    private static void initInput(ArrayList<Integer> arr, ArrayList<String> day, ArrayList<String> hour,
            GenerateTimeTable generateTimeTable) {

        generateTimeTable.day.removeAllItems();
        generateTimeTable.day.addItem("Select Day");
        day.forEach((day1) -> {
            generateTimeTable.day.addItem(day1);
        });
        generateTimeTable.day.setSelectedIndex(0);
        generateTimeTable.hour.removeAllItems();
        generateTimeTable.hour.addItem("Select Hour");
        hour.forEach((hr) -> {
            generateTimeTable.hour.addItem(hr);
        });
        generateTimeTable.hour.setSelectedIndex(0);

        generateTimeTable.sub.removeAllItems();
        generateTimeTable.sub.addItem("Select Subject");
        arr.forEach((ar) -> {
            generateTimeTable.sub.addItem(Subject.getSubjectName(SlotGenerator.slot[ar].subject));
        });
        generateTimeTable.sub.setSelectedIndex(0);
    }
}