package controller;

import database.Dbconnection;
import model.Product_model;
import view.Admin.Product_Inventory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product_controller {
    PreparedStatement ps;
    Dbconnection db = new Dbconnection();

    public int adding_food(Product_model pm){
        String query;
        try {
            query = "insert into product (product_name,product_code,product_available,product_price)" +
                    "values (?,?,?,?)";
            ps = db.connection.prepareStatement(query);

            ps.setString(1, pm.getProduct_name());
            ps.setString(2, pm.getProduct_code());
            ps.setString(3, pm.getProduct_available());
            ps.setString(4, pm.getProduct_price());


        }catch (SQLException e){
            e.printStackTrace();
        }
        return db.manipulate(ps);


    }

    public Product_model fetchProductdata(){

        Product_model product_model = null;
        try{
            String query;
            query = "select * from product";
            ps = db.connection.prepareStatement(query);
            ResultSet resultSet = db.retrieve(ps);
            while(resultSet.next()){
                product_model = new Product_model();
                product_model.setProduct_id(resultSet.getInt("product_id"));
                product_model.setProduct_name(resultSet.getString("product_name"));
                product_model.setProduct_code(resultSet.getString("product_code"));
                product_model.setProduct_available(resultSet.getString("product_available"));
                product_model.setProduct_price(resultSet.getString("product_price"));
            }
        }catch(SQLException e){
            e.printStackTrace();

        }
        return product_model;

    }


    public int deleteCustomer(int id) {
        try {
            String query = "delete from product where product_id=?";
            ps = db.connection.prepareStatement(query);
            ps.setInt(1, id);
            return db.manipulate(ps);
        }
        catch(Exception e) {
            System.out.println("Error " + e);
            return 0;
        }
    }

    public Product_model fetchIndividualProduct(){
        Product_model product_model = null;
        try{
            String query;
            query = "select * from product ";
            assert false;
            ps = db.connection.prepareStatement(query);
            ResultSet resultSet = db.retrieve(ps);
            while(resultSet.next()){
                product_model = new Product_model();
                product_model.setProduct_id(resultSet.getInt("product_id"));
                product_model.setProduct_name(resultSet.getString("product_name"));
                product_model.setProduct_code(resultSet.getString("product_code"));
                product_model.setProduct_available(resultSet.getString("product_available"));
                product_model.setProduct_price(resultSet.getString("product_price"));
            }
        }catch(SQLException e){
            e.printStackTrace();

        }
        return product_model;

    }

    public ResultSet extractProduct() {
        ResultSet rs = null;
        try {
            String query = "select * from product";
            PreparedStatement ps = db.connection.prepareStatement(query);
            rs = db.retrieve(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
