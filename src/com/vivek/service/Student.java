package com.vivek.service;

import com.vivek.dao.CreateDdConnection;

import java.sql.Date;
import java.time.Year;

public class Student {

    private final int rollNo;
    private final String name;
    private final String address;
    private final int dept_id;
    private final Year year;
    private final Date dob;
    private final String mobileNo;

    public Student(int rollNo, String name, String address, int dept_id, Year year, Date dob, String mobileNo) {
        this.rollNo = rollNo;
        this.name = name;
        this.dept_id = dept_id;
        this.year = year;
        this.dob = dob;
        this.mobileNo = mobileNo;
        this.address = address;
    }

    public static void getStudentList() {

        String query = "select * from students";
        CreateDdConnection.selectQuery(query);

    }

    public static void getStudentListHavingRollNo(int rollNo) {

        String query = "select * from students where rollNo=" + rollNo;
        CreateDdConnection.selectQuery(query);

    }

    public static void getStudentListHavingDeptIdAndYear(int dept_id, int year) {
        Year year1 = Year.of(year);
        String query = "select * from students where dept_id=" + dept_id + " and year=" + year1;

        CreateDdConnection.selectQuery(query);

    }

    public static boolean checkIfStudentAlreadyRegistered(int rollNo) {

        String query = "select * from students where rollNo=" + rollNo;
        return CreateDdConnection.selectQueryBol(query);
    }

    public void addStudent() {
        if (!checkIfStudentAlreadyRegistered(this.rollNo)) {
            String query = "insert into students values (" + this.rollNo + ",'" + this.name + "'," + this.dept_id + "," + this.year + ",'" + this.dob + "','" + this.mobileNo + "','" + this.address + "')";

            CreateDdConnection.insertStudentQuery(query);


        }
    }
}
