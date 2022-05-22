package com.vivek.service;

import com.vivek.dao.CreateDdConnection;

@SuppressWarnings("SpellCheckingInspection")


public class RoomNo {

//    private int hostelId;
//    private int roomNo;
//    // roomNoStatus : 0 <-- room is empty 1 <-- one bed occupied 2 <-- both bed occupied 3 <--not good
//    private int roomNoStatus;

    //add hostel
    public void addRoom(int hostelId, int roomNo) {

        String query = "insert into roomno values (" + hostelId + "," + roomNo + "," + 0 + ")";
        CreateDdConnection.insertQuery(query);


    }

    //change roomno status
    public void changeRoomNoStatus(int hostelId, int roomNo, int roomNoStatus) {

        String query = "update roomno set roomnostatus=" + roomNoStatus + " where hostel_id=" + hostelId + " and roomNo=" + roomNo;
        CreateDdConnection.update(query);


    }


    //print hostel list

    public void getRoomList() {

        String query = "select * from roomno";
        CreateDdConnection.selectQuery(query);


    }

    public void getRoomListhavinghostelId(int hostel_id) {

        String query = "select * from roomno where hostel_id=" + hostel_id;
        CreateDdConnection.selectQuery(query);

    }

    public void getRoomListhavinghostelIdAndStatus(int hostel_id, int roomNoStatus) {

        String query = "select * from roomno where hostel_id=" + hostel_id + " and roomnostatus=" + roomNoStatus;
        CreateDdConnection.selectQuery(query);

    }

    public void getRoomNoStatus(int hostel_id, int roomNo) {

        String query = "select * from roomno where hostel_id=" + hostel_id + " and roomNo=" + roomNo;
        CreateDdConnection.selectQuery(query);

    }


}
