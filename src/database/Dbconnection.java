package database;

import javax.swing.*;
import java.sql.*;

public class Dbconnection {
//    Objects Of variables of class related to database


    //    connection helps to establish the connection with database
    public Connection connection;

    //    executes a static SQL statement
    Statement statement;

    // store the data
    ResultSet resultSet;

    int val;

    //  constructor
    public Dbconnection() {

//        Exception handling in java
        try {

//              assigning username and password
            String username = "root";
            String password = null;
            Class.forName("com.mysql.cj.jdbc.Driver");

//            establishment of connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rms",
                    username, password);

            if (connection != null) {

            } else {
                JOptionPane.showMessageDialog(null, "Error in Connection!!!");

            }

            statement = connection.createStatement();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //    Function to Manipulate the Data
    public int manipulate(String query) {
        try {
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return val;
    }

    //    function to manipulate data using prepared Statement
    public int manipulate(PreparedStatement preparedStatement){
        try{
            val=preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return val;
    }




    //    Function to Retrieve The Data
    public ResultSet retrieve(String query) {

        try {
            resultSet = statement.executeQuery(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }


    //    function to retrieve data using prepared Statement
    public ResultSet retrieve (PreparedStatement preparedStatement){
        try{
            resultSet=preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return resultSet;
    }



    public static void main(String[] args) {
        new Dbconnection();
    }

}

