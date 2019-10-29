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
public class DatabaseConnection {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/TimeTable";
    static final String USER = "root";
    static final String PASS = "rootroot";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    DatabaseConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            
        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public Connection conn(){
        return this.conn;
    }
    
    public void close(){
        try{
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ResultSet executeQuery(String sql){
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return rs;
    }
    
    public void executeUpdate(String sql){
        try{
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
  
