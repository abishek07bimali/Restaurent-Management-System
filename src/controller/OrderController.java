package controller;

import database.Dbconnection;
import model.OrderFood;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderController {
    Dbconnection db = new Dbconnection();
    PreparedStatement ps;


    public int orderFood(OrderFood orderFood){
        String query;
        try {
            query = "insert into orderTable (TabelID,Name,Quantity,Total)" +
                    "values (?,?,?,?)";
            ps = db.connection.prepareStatement(query);
            ps.setString(1, orderFood.getTableId());
            ps.setString(2, orderFood.getName());
            ps.setString(3, orderFood.getQuantity());
            ps.setString(4, orderFood.getTotal());

        }catch (SQLException e){
            e.printStackTrace();

        }
        return db.manipulate(ps);
    }

    public int totalSAles(OrderFood orderFood){
        String query;
        try {
            query = "insert into totalsales (date,totalsales)" +
                    "values (?,?)";
            ps = db.connection.prepareStatement(query);
            ps.setString(1, orderFood.getDate());
            ps.setString(2, (orderFood.getTotalsales()));


        }catch (SQLException e){
            e.printStackTrace();

        }
        return db.manipulate(ps);
    }

    public int deleteProduct(int id) {
        try {
            String query = "delete from ordertable where OrderId=?";
            ps = db.connection.prepareStatement(query);
            ps.setInt(1, id);
            return db.manipulate(ps);
        }
        catch(Exception e) {
            System.out.println("Error " + e);
            return 0;
        }
    }

    public int extractTable() {
        try {
            String query = "select * from ordertable";
            PreparedStatement ps = db.connection.prepareStatement(query);
            ResultSet rs = db.retrieve(ps);
            int count=0;
            while (rs.next()){
                count++;
            }
            return  count;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public ResultSet extractintoTable() {
        ResultSet rs = null;
        try {
            String query = "select * from ordertable";
            PreparedStatement ps = db.connection.prepareStatement(query);
            rs = db.retrieve(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }



    public OrderFood fetchTotalsalesweekly() {
        OrderFood orderFood = new OrderFood();
        try {
            String query;
            query = "select sum(totalsales) from totalsales  where date >  DATE_SUB(NOW(), INTERVAL 1 WEEK)";
            ps = db.connection.prepareStatement(query);
            ResultSet rs = db.retrieve(ps);
            while (rs.next()) {
                orderFood = new OrderFood();
                orderFood.setTotalsales(String.valueOf((rs.getInt("sum(totalsales)"))));
            }} catch(Exception ex){
            System.out.println();
        }
        return orderFood;
    }

    public ResultSet daily_total(String date){
        ResultSet rs = null;
        try{
            String query = "select * from totalsales where date = ?";
            PreparedStatement ps = db.connection.prepareStatement(query);
            ps.setString(1,date);
            rs = db.retrieve(ps);

        }catch (SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
}


