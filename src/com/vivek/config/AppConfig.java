package com.vivek.config;

import com.vivek.exception.FailedInInitializing;

import static com.vivek.dao.CreateDdConnection.insertQueryConfig;

public class AppConfig {

    public static void config() throws FailedInInitializing {
        try {


            //creating table
            insertQueryConfig(TableCreationQuery.cquery1);
            insertQueryConfig(TableCreationQuery.cquery2);
            insertQueryConfig(TableCreationQuery.cquery3);
            insertQueryConfig(TableCreationQuery.cquery4);
            insertQueryConfig(TableCreationQuery.cquery5);


            //inserting predefined data in table

            //for hostel
            insertQueryConfig(InsertConfigData.iquery1(1, "vishwakarma", 3000.00));
            insertQueryConfig(InsertConfigData.iquery1(2, "charak", 3000.00));
            insertQueryConfig(InsertConfigData.iquery1(3, "c v raman", 3000.00));

            // for department
            insertQueryConfig(InsertConfigData.iquery2(101, "electrical engineering"));
            insertQueryConfig(InsertConfigData.iquery2(102, "information technology"));
            insertQueryConfig(InsertConfigData.iquery2(103, "electronics department"));


            // for roomNo
            insertQueryConfig(InsertConfigData.iquery3(1, 1));
            insertQueryConfig(InsertConfigData.iquery3(1, 2));
            insertQueryConfig(InsertConfigData.iquery3(1, 3));
            insertQueryConfig(InsertConfigData.iquery3(1, 4));
            insertQueryConfig(InsertConfigData.iquery3(2, 1));
            insertQueryConfig(InsertConfigData.iquery3(2, 2));
            insertQueryConfig(InsertConfigData.iquery3(2, 3));
            insertQueryConfig(InsertConfigData.iquery3(2, 4));
            insertQueryConfig(InsertConfigData.iquery3(3, 1));
            insertQueryConfig(InsertConfigData.iquery3(3, 2));



        } catch (FailedInInitializing e) {
            throw new FailedInInitializing();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

