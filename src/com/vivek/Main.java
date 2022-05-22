package com.vivek;

import com.vivek.config.AppConfig;
import com.vivek.service.*;

import java.sql.Date;
import java.time.Year;

public class Main {

    public static void main(String[] args) {
        // write your code here

        //initializing application
        try {
            AppConfig.config();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(422);
        }

        //Department
        Department department=new Department();
        department.getDeptList();
        department.setDeptDescHavingDeptId("electrical eng",101);
        department.setDeptDescHavingDeptDesc("electrical engineering","electrical eng");
        department.addDept(104,"mechanical engineering");
        department.getDeptList();

        //Hostel
        Hostel hostel=new Hostel();
        hostel.getHostelList();
        hostel.changeHostelName(2,"charak hostel");
        hostel.changeHostelFees(2,40000.00);
        hostel.addHostel(4,"A P J Abdul Kalam",50000);
        hostel.getHostelList();

        //roomno
        RoomNo roomNo=new RoomNo();
        roomNo.getRoomList();
        roomNo.addRoom(2,101);
        roomNo.getRoomNoStatus(1,102);
        roomNo.getRoomListhavinghostelId(2);
        roomNo.getRoomListhavinghostelIdAndStatus(2,0);

        //student
        Student.checkIfStudentAlreadyRegistered(215531);
        Student student0=new Student(215531,"Vivek","GKP, UP",101, Year.of(2015), Date.valueOf("1998-10-08"),"9565649427");
        student0.addStudent();
        Student student1=new Student(215532,"Parmeshwar","VNS, UP",101,Year.of(2015), Date.valueOf("1998-10-08"),"9565649427");
        student1.addStudent();
        Student student2=new Student(215533,"Santosh","JNU, UP",101,Year.of(2015), Date.valueOf("1998-10-08"),"9565649427");
        student2.addStudent();

        Student.getStudentList();
        Student.getStudentListHavingRollNo(215531);
        Student.getStudentListHavingDeptIdAndYear(101,2015);

        HostelAllotment.allotHostel(215531,1,2000);
        HostelAllotment.payDueFee(215531,28000);
        HostelAllotment.payDueFee(215531, 28000);
        HostelAllotment.vacateRoom(215531);
        HostelAllotment.getallotementdetailhavingrollno(215531);
    }
}
