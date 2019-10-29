/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javamini.timetable;

import java.util.*;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author prabodhmayekar
 */


public class Utility {
    
    static DatabaseConnection db = new DatabaseConnection();
    static boolean cli = false;
    
    public static void printInputData(){
        
        System.out.println("Nostgrp="+inputdata.nostudentgroup+" Noteachers="+inputdata.noteacher+" daysperweek="+inputdata.daysperweek+" hoursperday="+inputdata.hoursperday);
        for(int i=0;i<inputdata.nostudentgroup;i++){

            System.out.println(inputdata.studentgroup[i].id+" "+inputdata.studentgroup[i].name);
            for(int j=0;j<inputdata.studentgroup[i].nosubject;j++){
                System.out.println(inputdata.studentgroup[i].subjectid[j]+" "+inputdata.studentgroup[i].hours[j]+" hrs "+new Teacher().getTeacherName(inputdata.studentgroup[i].teacherid[j]) +" "+inputdata.studentgroup[i].teacherid[j]); 
                    
            }
            System.out.println("");
        }

        for(int i=0;i<inputdata.noteacher;i++){			
            System.out.println(inputdata.teacher[i].id+" "+inputdata.teacher[i].name+" "+inputdata.teacher[i].subject+" "+inputdata.teacher[i].assigned);
        }
    }
	
	
    public static void printSlots(){
        int days=inputdata.daysperweek;
        int hours=inputdata.hoursperday;
        int nostgrp=inputdata.nostudentgroup;
        System.out.println("----Slots----");
        for(int i=0;i<days*hours*nostgrp;i++){
            System.out.println(i+"- "+TimeTable.slot[i].studentgroup.id+" "+TimeTable.slot[i].subject+" "+new Teacher().getTeacherName(TimeTable.slot[i].teacherid));

            if((i+1)%(hours*days)==0) System.out.println("******************************");
        }
    }
    
    
    public static void generateTimeTable(int GrpId, ArrayList<String> day, ArrayList<String> hour){
         int days=inputdata.daysperweek;
        int hours=inputdata.hoursperday;
        int nostgrp=inputdata.nostudentgroup;
        int arr2[][] = new int[days][hours];
        
        db.executeUpdate("DELETE FROM TimeTable WHERE GrpId = " + GrpId);
        
        
        System.out.println("----Slots----");
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<days*hours*nostgrp;i++){
            if(TimeTable.slot[i].studentgroup.id == GrpId){
                arr.add(i);
                System.out.println(TimeTable.slot[i].subject + " : " + i);
            }
                
        }
        
        //System.out.println(arr);
        if(cli == true){
            cliMode(arr, arr2, day, hour);
        }
        else{
            guiMode(arr, arr2, day, hour);
        }
        
        
        
        
        
    }
    
    
    public static void cliMode(ArrayList<Integer> arr,int arr2[][], ArrayList<String> day, ArrayList<String> hour){
        String b;
        Scanner s = new Scanner(System.in);
        System.out.println("Do you want to Insert Manually: y || n ");
        b = s.nextLine();
        while(!b.equalsIgnoreCase("n")){
            System.out.println("Manually Insert Timetable");
            Scanner scan = new Scanner(System.in);
            
            System.out.println("Day: ");
            String sDay = s.nextLine();
            System.out.println("Hour: ");
            String sHour = s.nextLine();
            System.out.println("Lecture: ");
            int sLecture = scan.nextInt();
            ResultSet rs=db.executeQuery("SELECT TeacherId FROM TimeTable WHERE Day = '"+sDay+"' AND Hour = '"+sHour+"' AND TeacherId = "+TimeTable.slot[sLecture].teacherid);
             try {
                 if(!rs.next()){
                     arr2[day.indexOf(sDay)][hour.indexOf(sHour)] = sLecture;
                     arr.remove(arr.indexOf(arr2[day.indexOf(sDay)][hour.indexOf(sHour)]));
                 }else{
                     System.out.println("Sorry the teacher is busy");
                 }
             } catch (SQLException ex) {
                 System.out.println(ex.getMessage());
             }
                
            System.out.println("Countinue: y || n ");
            b = s.nextLine();
        }
        autoGenerator(arr,arr2,day,hour);
    }
     
    
    public static void autoGenerator(ArrayList<Integer> arr,int arr2[][], ArrayList<String> day, ArrayList<String> hour){
        int days=inputdata.daysperweek;
        int hours=inputdata.hoursperday;
        
        Random r = new Random();
        System.out.println(arr);
        int k = 0;
        
        while(!arr.isEmpty()){
            int d = r.nextInt(days);
            int h = r.nextInt(hours);
            if(arr2[d][h] == 0){
                if(h == hours/2 && "FR-0000".equals(TimeTable.slot[arr.get(k)].subject) ){
                    arr2[d][h] = arr.get(k);
                    arr.remove(k);
                }
                else if( h!=hours/2 ){
                    ResultSet rs=db.executeQuery("SELECT TeacherId FROM TimeTable WHERE Day = '"+d+"' AND Hour = '"+h+"' AND TeacherId = "+TimeTable.slot[k].teacherid);
                    try {
                        if(!rs.next()){
                            arr2[d][h] = arr.get(k);
                            arr.remove(k);
                        }else{
                            
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                
            }
            
        }
     
        for(int i = 0 ; i < arr2.length ; i++){     
            for(int j = 0 ; j < arr2[i].length; j++){
                db.executeUpdate("INSERT INTO TimeTable(Day,Hour,SubId,GrpId,TeacherId) VALUES('"+day.get(i)+"','"+hour.get(j)+"','"+TimeTable.slot[arr2[i][j]].subject+"',"+TimeTable.slot[arr2[i][j]].studentgroup.id+","+TimeTable.slot[arr2[i][j]].teacherid+")");
                System.out.println(day.get(i)+" : " + hour.get(j)+ " - " + TimeTable.slot[arr2[i][j]].subject+ " ");
            }   
        }
    }

    private static void guiMode(ArrayList<Integer> arr, int[][] arr2, ArrayList<String> day, ArrayList<String> hour) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
