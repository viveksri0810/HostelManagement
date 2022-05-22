package com.vivek.service;

import com.vivek.dao.CreateDdConnection;

public class Department {

//    private int deptId;
//    private String deptDesc;

    public void addDept(int deptId, String deptDesc) {

        String query = "insert into department values (" + deptId + ",'" + deptDesc + "')";
        CreateDdConnection.insertQuery(query);


    }


    public void setDeptDescHavingDeptId(String newDeptDesc, int deptId) {

        String query = "update department set deptDesc='" + newDeptDesc + "' where dept_id=" + deptId;
        CreateDdConnection.update(query);


    }

    public void setDeptDescHavingDeptDesc(String newDeptDesc, String deptDesc) {

        String query = "update department set deptDesc='" + newDeptDesc + "' where deptDesc like '%" + deptDesc + "%'";
        CreateDdConnection.update(query);


    }

    public void getDeptList() {

        String query = "select * from department";
        CreateDdConnection.selectQuery(query);


    }
}
