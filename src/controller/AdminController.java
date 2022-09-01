package controller;

import database.Dbconnection;
import model.AdminModel;
import model.Employee_model;
import model.Product_model;
import view.Admin.AdminLoginForm;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminController {
    Dbconnection db = new Dbconnection();
    PreparedStatement ps;


    public int adminRegistration(AdminModel ar){
        String query;
        try {
            query = "insert into admin (Fullname,Gender,Email,Username,Password)" +
                    "values (?,?,?,?,?)";
            ps = db.connection.prepareStatement(query);

            ps.setString(1, ar.getFullName());
            ps.setString(2, ar.getGender());
            ps.setString(3, ar.getEmail());
            ps.setString(4, ar.getUsername());
            ps.setString(5, ar.getPassword());

        }catch (SQLException e){
            e.printStackTrace();

        }
        return db.manipulate(ps);
    }


    public AdminModel loginAdminPreparedStatement(String Username, String Password) {
        AdminModel adminModel = null;
        try{
            String query;
            query = "select adminId from admin where Username = ? and Password=?";
            PreparedStatement pt = db.connection.prepareStatement(query);
            pt.setString(1,Username);
            pt.setString(2,Password);
            ResultSet rs = db.retrieve(pt);
            while(rs.next()){
                adminModel = new AdminModel();
                adminModel.setAdminId(rs.getInt("adminId"));
                AdminLoginForm.USER_ID = rs.getInt("adminId");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminModel;
    }


    public AdminModel fetchLoggedInAdmin() {
        AdminModel adminmodel= null;
        try {
            String query;
            query = "select * from admin where adminId =?";
            ps = db.connection.prepareStatement(query);
            ps.setInt(1, AdminLoginForm.USER_ID);
            ResultSet rs = db.retrieve(ps);
            while (rs.next()) {
                adminmodel = new AdminModel();
                adminmodel.setAdminId(rs.getInt("adminId"));
                adminmodel.setFullName(rs.getString("Fullname"));
                adminmodel.setGender(rs.getString("Gender"));
                adminmodel.setEmail(rs.getString("Email"));
                adminmodel.setUsername(rs.getString("Username"));
                adminmodel.setPassword(rs.getString("Password"));
                adminmodel.setPic_address(rs.getString("Picture"));
            }
        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
        return adminmodel;
    }


    public int updateAdminProfile(AdminModel adminModel) {
        try {
            String query;
            query = "Update admin Set Fullname =?,Gender = ?,Email=?,Username=?,Password=? where adminId = ?";
            ps = db.connection.prepareStatement(query);

            ps.setString(1, adminModel.getFullName());
            ps.setString(2, adminModel.getGender());
            ps.setString(3, adminModel.getEmail());
            ps.setString(4, adminModel.getUsername());
            ps.setString(5, adminModel.getPassword());
            ps.setInt(6,adminModel.getAdminId());
            return db.manipulate(ps);

        } catch (SQLException e) {
            System.out.println("Error " + e);
            return 0;
        }
    }

    public int Picture(AdminModel ar){
        String query;
        try {
            query = "Update admin Set Picture =? where adminId=?";
            ps = db.connection.prepareStatement(query);

            ps.setString(1, ar.getPic_address());
            ps.setInt(2,ar.getAdminId());

            return db.manipulate(ps);

        }catch (SQLException e){
            e.printStackTrace();
            return  0;

        }
    }



    public int deleteAdmin(int ID) {
        try {
            String query = "delete from admin where adminId=?";
            ps = db.connection.prepareStatement(query);
            ps.setInt(1, ID);
            return db.manipulate(ps);
        }
        catch(Exception e) {
            System.out.println("Error " + e);
            return 0;
        }
    }




    public AdminModel Forgetpssword(String phone, String Username) {
        AdminModel adminModel = null;
        try{
            String query;
            query = "select adminId from admin where Email = ? and Username=?";
            PreparedStatement pt = db.connection.prepareStatement(query);
            pt.setString(1,phone);
            pt.setString(2,Username);
            ResultSet rs = db.retrieve(pt);
            while(rs.next()){
                adminModel = new AdminModel();
                adminModel.setAdminId(rs.getInt("adminId"));
                AdminLoginForm.USER_ID = rs.getInt("adminId");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminModel;
    }


    public int updateAdminPassword(AdminModel adminModel) {
        try {
            String query;
            query = "Update admin Set Password=? where adminId = ?";
            ps = db.connection.prepareStatement(query);

            ps.setString(1, adminModel.getPassword());
            ps.setInt(2,adminModel.getAdminId());
            return db.manipulate(ps);

        } catch (SQLException e) {
            System.out.println("Error " + e);
            return 0;
        }
    }

    public int updateEmployeeAdmin(Employee_model employee_model){
        try {
            String query;
            query = "Update employee Set name =?,citizen_no=?,phone=?,mail=?,position =? ,salary = ? where id = ?";
            ps = db.connection.prepareStatement(query);
            ps.setString(1, employee_model.getName());
            ps.setString(2, employee_model.getCitizen_no());
            ps.setString(3, employee_model.getPhone());
            ps.setString(4, employee_model.getMail());
            ps.setString(5, employee_model.getPosition());
            ps.setString(6, employee_model.getSalary());
            ps.setInt(7, employee_model.getId());
            return db.manipulate(ps);
        } catch (SQLException e) {
            System.out.println("Error " + e);
            return 0;
        }
    }

    public int updateProduct(Product_model product_model){
        try{
            String query;
            query = "update product set product_name=?,product_code=?,product_available=?,product_price=? where product_id =? ";
            ps=db.connection.prepareStatement(query);
            ps.setString(1,product_model.getProduct_name());
            ps.setString(2,product_model.getProduct_code());
            ps.setString(3,product_model.getProduct_available());
            ps.setString(4,product_model.getProduct_price());
            ps.setInt(5,product_model.getProduct_id());
            return db.manipulate(ps);
        }catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet extractEmployee() {
        ResultSet rs = null;
        try {
            String query = "select * from employee";
            PreparedStatement ps = db.connection.prepareStatement(query);
            rs = db.retrieve(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
