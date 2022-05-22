package com.vivek.config;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("SpellCheckingInspection")

public class InsertConfigData {

    //inserting hostel data
    @Contract(pure = true)
    public static @NotNull String iquery1(int hostelId, String hostelName, double hostelFee) {
        return "insert into hostel values (" + hostelId + ",'" + hostelName + "'," + hostelFee + ")";
    }

    //inserting department data
    @Contract(pure = true)
    public static @NotNull String iquery2(int deptId, String deptDesc) {
        return "insert into department values (" + deptId + ",'" + deptDesc + "')";
    }

    //inserting roomNo data
    //roomNo status 0 << empty 1 << one bed occupied  2 << 2 person occupied 3 << room is having maintainance issue
    @Contract(pure = true)
    public static @NotNull String iquery3(int hostelId, int roomNo) {
        return "insert into roomno values (" + hostelId + "," + roomNo + "," + 0 + ")";
    }
}
