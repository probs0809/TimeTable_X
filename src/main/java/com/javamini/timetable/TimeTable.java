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
//through this class slots are generated to match minimum hours criteria for each subjectid
//also this class holds slots in order
public class TimeTable {

	public static Slot[] slot;

    TimeTable() {

        DatabaseConnection db = new DatabaseConnection();
        db.executeUpdate("DELETE FROM Slots");

        int k = 0;
        int subjectno = 0;
        int hourcount = 1;
        int days = inputdata.daysperweek;
        int hours = inputdata.hoursperday;
        int nostgrp = inputdata.nostudentgroup;

        // creating as many slots as the no of blocks in overall timetable
        slot = new Slot[hours * days * nostgrp];

        // looping for every student group
        for (int i = 0; i < nostgrp; i++) {

            subjectno = 0;
            // for every slot in a week for a student group
                int hr = 0;
            for (int j = 0; j < hours * days; j++) {

                StudentGroup sg = inputdata.studentgroup[i];

                // if all subjects have been assigned required hours we give
                // free periods

                if (subjectno >= sg.nosubject) {
                    hr++;
                    slot[k++] = new Slot(sg, -1, "FR-0000");
                    db.executeUpdate("INSERT INTO Slots(SlotId, GrpId, SubId, TeacherId) VALUES("+(k-1)+","+sg.id+",'FR-0000',-1)");

                    //slot[k++] = new Slot(sg, sg.teacherid[subjectno], sg.subjectid[subjectno]);
                }

                // if not we create new slots
                else {

                    slot[k++] = new Slot(sg, sg.teacherid[subjectno], sg.subjectid[subjectno]);
                        db.executeUpdate("INSERT INTO Slots(SlotId, GrpId, SubId, TeacherId) VALUES("+(k-1)+","+sg.id+",'"+sg.subjectid[subjectno]+"',"+sg.teacherid[subjectno]+")");

                    // suppose java has to be taught for 5 hours then we make 5
                    // slots for java, we keep track through hourcount
                    if (hourcount < sg.hours[subjectno]) {
                        hourcount++;
                    } else {
                        hourcount = 1;
                        subjectno++;
                    }

                }

            }

        }

    }

    public static Slot[] returnSlots() {
            return slot;
    }
}