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
public class Slot {
    public StudentGroup studentgroup;
    public int teacherid;
    public String subject;

    Slot() {
    };

    Slot(StudentGroup studentgroup, int teacherid, String subject) {

        this.studentgroup = studentgroup;
        this.subject = subject;
        this.teacherid = teacherid;

    }
}
