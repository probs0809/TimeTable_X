/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javamini.timetable;


import java.sql.*;
/**
 *
 * @author prabodhmayekar
 */
public class StudentGroup {
    public int id;
    public String name;
    public String[] subjectid;
    public int nosubject;
    public int teacherid[];
    public int[] hours;
    DatabaseConnection db = new DatabaseConnection();

    public StudentGroup() {
        subjectid = new String[10];
        hours = new int[10];
        teacherid = new int[10];
    }

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
    public String[] getSubjectid() {
        return subjectid;
    }
    public void setSubjectid(String[] subjectid) {
        this.subjectid = subjectid;
    }
    public int getNosubject() {
        return nosubject;
    }
    public void setNosubject(String snosubject) {
        int nosubject=Integer.parseInt(snosubject);
        this.nosubject = nosubject;
    }
    public int[] getTeacherid() {
        return teacherid;
    }
    public void setTeacherid(int[] teacherid) {
        this.teacherid = teacherid;
    }
    public int[] getHours() {
        return hours;
    }
    public void setHours(int[] hours) {
        this.hours = hours;
    }
    
    //database handler
    
    public void addToRecord(String GrpName, int noOfSub){
        db.executeUpdate("INSERT INTO StudentGroup(GrpName,NoOfSub) VALUES('"+GrpName+"',"+noOfSub+")");
    }
    
    public void updateNoOfSubject(int id, int noOfSub){
        db.executeUpdate("UPDATE StudentGroup SET NoOfSub = "+noOfSub+" WHERE GrpId = "+id);
    }
    
    public void deleteRecord(int id){
        db.executeUpdate("DELETE FROM StudentGroup WHERE GrpId = "+id);
    }
    
    
}
