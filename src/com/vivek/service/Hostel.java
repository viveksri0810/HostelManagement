package com.vivek.service;

import com.vivek.dao.CreateDdConnection;

public class Hostel {

//    private int hostelId;
//    private String hostelName;
//    private double hostelFee;


    //add hostel
    public void addHostel(int hostelId, String hostelName, double hostelFee) {

        String query = "insert into hostel values (" + hostelId + ",'" + hostelName + "'," + hostelFee + ")";
        CreateDdConnection.insertQuery(query);


    }

    //change hostel name
    public void changeHostelName(int hostelId, String hostelName) {
        String query = "update hostel set hostelName='" + hostelName + "' where hostel_Id=" + hostelId;
        CreateDdConnection.update(query);


    }

    //change hostel fee
    public void changeHostelFees(int hostelId, double hostelFee) {
        String query = "update hostel set hostelFee='" + hostelFee + "' where hostel_Id=" + hostelId;
        CreateDdConnection.update(query);
    }

    //print hostel list

    public void getHostelList() {
        String query = "select * from hostel";
        CreateDdConnection.selectQuery(query);
    }

}
