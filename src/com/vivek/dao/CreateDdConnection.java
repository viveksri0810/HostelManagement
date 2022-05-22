package com.vivek.dao;

import com.vivek.exception.FailedInInitializing;

import java.sql.*;

public class CreateDdConnection {

    private static Connection con = null;
    private static Statement stmt = null;

    private static void createConnection() {
        try {
            //   con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hostelmanagement","root","root");
            //test
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test2", "root", "root");

            stmt = con.createStatement();
            con.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertQueryConfig(String query) throws FailedInInitializing {
        createConnection();
        try {
            stmt.execute(query);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new FailedInInitializing();
        }
        commit();
        closeConnection();
    }

    public static void insertQuery(String query) {
        createConnection();
        try {
            stmt.execute(query);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(e.getMessage());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        commit();
        closeConnection();
    }


    public static void insertStudentQuery(String query) {
        createConnection();
        try {
            stmt.execute(query);
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Student already present");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        commit();
        closeConnection();
    }


    public static void selectQuery(String query) {
        createConnection();
        try {
            ResultSet resultSet = stmt.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{\n");
            while (resultSet.next()) {
                stringBuilder.append("\t{\n");
                int temp = 1;
                while (temp <= columnCount) {
                    stringBuilder.append("\t\t\"").append(rsmd.getColumnName(temp)).append("\" : \"").append(resultSet.getString(temp)).append("\",\n");
                    temp++;
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 2);
                stringBuilder.append("\t}\n");
            }
            stringBuilder.append("}");


            if (stringBuilder.length() > 3) {
                System.out.println(stringBuilder);
            } else {
                System.out.println("Data Not Found...");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
    }


    public static boolean selectQueryBol(String query) {
        createConnection();
        int size = 0;
        try {
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                size++;
            }
//            System.out.println(size);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return size > 0;

    }

    //Result Set Output Int
    public static int selectQueryRSOI(String query) {
        int num = 0;
        try {
            createConnection();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                num = rs.getInt(1);
            }
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public static double selectQueryRSOD(String query) {
        double num = 0;
        try {
            createConnection();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                num = rs.getDouble(1);
            }
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }


    public static void update(String query) {
        createConnection();
        try {
            stmt.executeUpdate(query);
//            System.out.println("no of rows updated : " + stmt.getUpdateCount());
            commit();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Duplicate entry ...");
        } catch (SQLException e) {
            System.out.println("Update failed ...");
            e.printStackTrace();
        }
        closeConnection();
    }


    private static void commit() {
        if (stmt != null & con != null) {
            try {
                con.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static void closeConnection() {

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
