package com.vivek.config;

@SuppressWarnings("SpellCheckingInspection")
public class TableCreationQuery {

    public static final String cquery1 = "create table if not exists department (dept_id int,deptDesc varchar(255),primary key (dept_id))";

    public static final String cquery2 = "create table if not exists students( rollNo int primary key,name varchar(255) not null," +
            "dept_id int not null ,year int not null,dob Date,mobileNo varchar(255)," +
            "address varchar(255), foreign key (dept_id )  references department(dept_id))";

    public static final String cquery3 = "create table if not exists hostel(hostel_id int primary key," +
            "hostelname varchar(255) not null,hostelfee double not null )";

    public static final String cquery4 = "create table if not exists roomno(hostel_id int not null, roomNo int ," +
            "roomnostatus int not null, foreign key (hostel_id) references hostel(hostel_id)," +
            "constraint pk_key primary key (hostel_id,roomNo))";

    public static final String cquery5 = "create table if not exists hostelAllotement (rollNo int, hostel_Id int," +
            "roomNo int, admissionDate Date,  feepaid double, feeDue double,sta int, vacantDate Date,foreign key (rollNo) references students(rollNo)," +
            "foreign key (hostel_Id) references hostel(hostel_id), foreign key(roomNo) references roomno(roomNo))";
}
