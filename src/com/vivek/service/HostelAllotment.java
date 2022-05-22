package com.vivek.service;

import com.vivek.dao.CreateDdConnection;

import java.sql.Date;

@SuppressWarnings("SpellCheckingInspection")
public class HostelAllotment {

//    private int rollNo;
//    private int hostelId;
//    private int roomNo;
//    private double actualHostelFee;
//    private double feePaid;
//    private double feeDue;
//    private Date admissionDate;
//    private Date vacantDate;
//    private int status;
// status 0 << allotted 1 << vacated


    public static void allotHostel(int rollNo, int hostelId, double feePaid) {

        if (!ifRoomAlreadyAllotted(rollNo)) {
            int roomno = getRoomNoWhichIsEmpty(hostelId);
            if (roomno != 0) {
                double fee = getHostelFee(hostelId);
                double feedue = fee - feePaid;
                long millis = System.currentTimeMillis();
                Date date = new Date(millis);
                String query = "insert into hostelallotement (rollno,hostel_id,roomno,admissiondate,feepaid,feedue,sta) values (" + rollNo + "," + hostelId + "," + roomno + ",'" + date + "'," + feePaid + "," + feedue + "," + 0 + ")";
                CreateDdConnection.insertQuery(query);
                if (roomnostatus(hostelId, roomno) == 0) {
                    RoomNo roomNo = new RoomNo();
                    roomNo.changeRoomNoStatus(hostelId, roomno, 1);
                } else {
                    RoomNo roomNo = new RoomNo();
                    roomNo.changeRoomNoStatus(hostelId, roomno, 2);
                }
                System.out.println("Hostel allotted room no : " + roomno + " fee paid : " + feePaid + " fee due : " + feedue);
            } else {
                System.out.println("Room not available in hostel or hostel id not valid");
            }
        } else {
            System.out.println("Student already have hostel allotted to him. Please check previous allotement ");
        }

    }

    public static void getallotementdetailhavingrollno(int rollNo) {
        String query = "select * from hostelAllotement where rollno=" + rollNo;
        CreateDdConnection.selectQuery(query);
    }


    public static void payDueFee(int rollNo, double feePaid) {
        if (ifRoomAlreadyAllotted(rollNo)) {
            double feeDue = getfeedue(rollNo);
            if (feeDue == 0) {
                System.out.println("Fee already paid, no balance");
            } else if (feePaid > feeDue) {
                System.out.println("Fee paid amount is greater than or fee due");
            } else {
                double feepaid1 = getfeepaid(rollNo);
                double currentdue = feeDue - feePaid;
                double totalfeepaid = feePaid + feepaid1;
                String query2 = "update hostelAllotement set feepaid=" + totalfeepaid + " ,feedue=" + currentdue + " where rollno=" + rollNo + " and sta=" + 0;
                CreateDdConnection.update(query2);
                System.out.println("Fee paid..");
            }
        } else {
            System.out.println("data not found...");
        }
    }

    public static void vacateRoom(int rollNo) {
        double feedue;
        if (ifRoomAlreadyAllotted(rollNo)) {
            feedue = getfeedue(rollNo);
            if (feedue == 0) {
                int roomno = getRoomNo(rollNo);
                int hostelId = getHostelId(rollNo);
                String query = "update roomno set roomnostatus=roomnostatus-1 where hostel_id=" + hostelId + " and roomno=" + roomno;
                CreateDdConnection.update(query);
                long millis = System.currentTimeMillis();
                Date date = new Date(millis);
                String query1 = "update hostelAllotement set sta=" + 1 + " , vacantdate='" + date + "' where rollno=" + rollNo + " and sta=" + 0;
                CreateDdConnection.update(query1);
                System.out.println("Hostel vacated..");
            } else {
                System.out.println("Please clear your fee due before vacating");
            }
        } else {
            System.out.println("No room alloted to rollno : " + rollNo);
        }
    }

    private static boolean ifRoomAlreadyAllotted(int rollNo) {
        String query = "select * from hostelAllotement where rollNo=" + rollNo + " and sta=" + 0;
        return CreateDdConnection.selectQueryBol(query);
    }

    private static int getRoomNoWhichIsEmpty(int hostelId) {
        String query = "select roomNo from roomno where hostel_Id=" + hostelId + " and roomnostatus in (0,1) limit 1";
        return CreateDdConnection.selectQueryRSOI(query);

    }

    private static double getHostelFee(int hostelId) {
        String query = "select hostelfee from hostel where hostel_id=" + hostelId;
        return CreateDdConnection.selectQueryRSOD(query);
    }

    private static int roomnostatus(int hostelid, int roomno) {
        String query = "select roomnostatus from roomno where hostel_id=" + hostelid + " and roomNo=" + roomno;
        return CreateDdConnection.selectQueryRSOI(query);
    }

    private static double getfeedue(int rollno) {
        String query1 = "select feedue from hostelAllotement where rollno=" + rollno + " and sta=" + 0;
        return CreateDdConnection.selectQueryRSOD(query1);

    }

    private static double getfeepaid(int rollno) {
        String query1 = "select feepaid from hostelAllotement where rollno=" + rollno + " and sta=" + 0;
        return CreateDdConnection.selectQueryRSOD(query1);

    }

    private static int getRoomNo(int rollno) {
        String query = "select roomno from hostelAllotement where rollno=" + rollno + " and sta=" + 0;
        return CreateDdConnection.selectQueryRSOI(query);
    }

    private static int getHostelId(int rollno) {
        String query = "select hostel_id from hostelAllotement where rollno=" + rollno + " and sta=" + 0;
        return CreateDdConnection.selectQueryRSOI(query);
    }


}
