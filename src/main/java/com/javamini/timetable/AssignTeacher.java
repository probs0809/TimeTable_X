/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javamini.timetable;

/**
 *
 * @author prabodhmayekar
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AssignTeacher {

    public static StudentGroup[] studentgroup;
    public static Teacher[] teacher;
    public static int nostudentgroup, noteacher;
    public static int hoursperday, daysperweek;
    DatabaseConnection db = new DatabaseConnection();

    public AssignTeacher() {
        studentgroup = new StudentGroup[100];
        teacher =   new Teacher[100];
    }

    public void takeinput()
    {
        
            ResultSet rs = db.executeQuery("SELECT * FROM StudentGroup");
            int i = 0, j;
            try {
                while(rs.next()) {
                    studentgroup[i] = new StudentGroup();
                    studentgroup[i].id = rs.getInt("GrpId");
                    studentgroup[i].name = rs.getString("GrpName");
                    studentgroup[i].nosubject = rs.getInt("NoOfSub");

                    ResultSet subHrs = db.executeQuery("SELECT * FROM SubHrs WHERE GrpId = "+studentgroup[i].id);
                    j = 0;
                    while (subHrs.next()) {
                        studentgroup[i].subjectid[j] = subHrs.getString("SubId");
                        studentgroup[i].hours[j++] = subHrs.getInt("Hours");
                    }
                    subHrs.close();
                    i++;
                    nostudentgroup = i;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AssignTeacher.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignTeacher.class.getName()).log(Level.SEVERE, null, ex);
            }

            rs = db.executeQuery("SELECT * FROM Teacher");
            i = 0;
            try {
                while(rs.next()) {
                    teacher[i] = new Teacher();
                    teacher[i].subject = new ArrayList<>();
                    teacher[i].id = rs.getInt("TeacherId");
                    teacher[i].name = rs.getString("TeacherName");
                    ResultSet subHrs = new DatabaseConnection().executeQuery("SELECT * FROM TeacherSubject WHERE TeacherId = "+teacher[i].id);
                    
                    
                    while (subHrs.next()) {
                        try{
                            teacher[i].subject.add(subHrs.getString("SubId"));
                            System.err.println("Error XYZ:"+subHrs.getString("SubId"));
                        }catch(NullPointerException e){
                        }
                        
                    }
                    
                    subHrs.close();
                    i++;
                    noteacher = i;
                }
            } catch (SQLException ex) {
            }
            
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(AssignTeacher.class.getName()).log(Level.SEVERE, null, ex);
            }

        
        assignTeacher();
    }

    // assigning a teacher for each subjectid for every studentgroup
    public void assignTeacher() {
        // looping through every studentgroup
        for (int i = 0; i < nostudentgroup; i++) {
            // looping through every subjectid of a student group
            for (int j = 0; j < studentgroup[i].nosubject; j++) {
                int teacherid;
                int assignedmin = -1;
                String subject = studentgroup[i].subjectid[j];
                // looping through every teacher to find which teacher teaches the current subjectid
                for (int k = 0; k < noteacher; k++) {
                    
                  
                    for(int l = 0 ; l < teacher[k].subject.size();l++ ){
                        // if such teacher found,checking if he should be assigned the subjectid or some other teacher based on prior assignments
                        //System.err.println(teacher[i].subject[l]);

                        if (teacher[k].subject.get(l).equalsIgnoreCase(subject)) {
                            // if first teacher found for this subjectid
                            if (assignedmin == -1) {
                                assignedmin = teacher[k].assigned;
                                teacherid = k;
                                teacher[teacherid].assigned++;
                                studentgroup[i].teacherid[j]= teacher[k].id;
                                db.executeUpdate("UPDATE SubHrs SET TeacherId = '"+teacher[k].id+"' WHERE GrpId = "+studentgroup[i].id+" AND SubId='"+subject+"'");
                                teacher[teacherid].setAssigned();
                            }

                            // if teacher found has less no of pre assignments than the teacher assigned for this subjectid
                            else if (assignedmin > teacher[k].assigned) {
                                assignedmin = teacher[k].assigned;
                                teacherid = k;
                                teacher[teacherid].assigned++;
                                studentgroup[i].teacherid[j]= teacher[k].id;
                                db.executeUpdate("UPDATE SubHrs SET TeacherId = '"+teacher[k].id+"' WHERE GrpId = "+studentgroup[i].id+" AND SubId='"+subject+"'");
                                teacher[teacherid].setAssigned();
                            }
                        }
                    } 
                }
            }
        }
    }
}
