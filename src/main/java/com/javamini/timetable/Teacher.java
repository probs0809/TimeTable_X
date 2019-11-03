/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javamini.timetable;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author prabodhmayekar
 */
public class Teacher {
    int id;
    String name;
//    String subject[];
    ArrayList<String> subject;
    int assigned;
    
    static DatabaseConnection db = new DatabaseConnection();
    
    public int getId() {
            return id;
    }
    public void setId(int id) {
            this.id = id;
    }
    public String getName() {
            return name;
    }
    public void setName(String name) {
            this.name = name;
    }

    public int getAssigned(int id){
        int ass = 0;
        ResultSet rs = db.executeQuery("SELECT assign FROM Teacher WHERE TeacherId = "+id);
        try{
            rs.next();
            ass = rs.getInt("assign");
        }catch(Exception e){
            e.printStackTrace();
        }
        return ass;
    }
    
    public void setAssigned(){
        db.executeUpdate("UPDATE Teacher SET assign = "+this.assigned+" WHERE TeacherId = "+this.id);
    }
    
    public static void addToRecored(String name){
        db.executeUpdate("INSERT INTO Teacher(TeacherName, assign) VALUES('"+name+"',0)");
    }
    
    public String getTeacherName(int id){
        String name = "";
        ResultSet rs = db.executeQuery("SELECT TeacherName FROM Teacher WHERE TeacherId = "+id);
        try{
            rs.next();
            name = rs.getString("TeacherName");
        }catch(Exception e){
            e.printStackTrace();
        }
        return name;
    }
    
    public void deleteRecord(int id){
        db.executeUpdate("DELETE FROM Teacher WHERE TeacherId = "+id);
    }
}
