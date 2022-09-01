package controller;

import database.Dbconnection;
import model.Attendance_model;
import model.Employee_model;
import view.Employee.EmployeeForgetPassword;
import view.Employee.Employeelogin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeController {
    PreparedStatement ps;
    Dbconnection db = new Dbconnection();

    public int employeeRegistration(Employee_model ar) {
        String query;
        try {
            query = "insert into employee (name,citizen_no,gender,address,phone,mail,username,password,position,salary,married)" +
                    "values (?,?,?,?,?,?,?,?,?,?,?)";
            ps = db.connection.prepareStatement(query);

            ps.setString(1, ar.getName());
            ps.setString(2, ar.getCitizen_no());
            ps.setString(3, ar.getGender());
            ps.setString(4, ar.getAddress());
            ps.setString(5, ar.getPhone());
            ps.setString(6, ar.getMail());
            ps.setString(7, ar.getUsername());
            ps.setString(8, ar.getPassword());
            ps.setString(9, ar.getPosition());
            ps.setString(10, ar.getSalary());
            ps.setString(11, ar.getMarried());


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return db.manipulate(ps);
    }


    public Employee_model loginAdminPreparedStatement(String username, String password) {
        Employee_model employee_Model = null;
        try {
            String query;
            query = "select id from employee where username = ? and password=?";
            ps = db.connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = db.retrieve(ps);
            while (rs.next()) {
                employee_Model = new Employee_model();
                employee_Model.setId(rs.getInt("id"));
                Employeelogin.Cust_ID = rs.getInt("id");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee_Model;
    }


    public Employee_model fetchLoggedInEmployee() {
        Employee_model employee_model = null;
        try {
            String query;
            query = "select * from employee where id = ?";
            ps = db.connection.prepareStatement(query);
            ps.setInt(1, Employeelogin.Cust_ID);
            ResultSet resultSet = db.retrieve(ps);
            while (resultSet.next()) {
                employee_model = new Employee_model();
                employee_model.setId(resultSet.getInt("id"));
                employee_model.setName(resultSet.getString("name"));
                employee_model.setCitizen_no(resultSet.getString("citizen_no"));
                employee_model.setGender(resultSet.getString("gender"));
                employee_model.setAddress(resultSet.getString("address"));
                employee_model.setPhone(resultSet.getString("phone"));
                employee_model.setMail(resultSet.getString("mail"));
                employee_model.setUsername(resultSet.getString("username"));
                employee_model.setPassword(resultSet.getString("password"));
                employee_model.setPosition(resultSet.getString("position"));
                employee_model.setSalary(resultSet.getString("salary"));
                employee_model.setMarried(resultSet.getString("married"));
                employee_model.setPicture(resultSet.getString("picture"));
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
        return employee_model;
    }

    public Employee_model fetchRegisteredEmployee() {
        Employee_model employee_model = null;
        try {
            String query;
            query = "select * from employee";
            ps = db.connection.prepareStatement(query);
//            ps.setInt(1,Employeelogin.Cust_ID);
            ResultSet resultSet = db.retrieve(ps);
            while (resultSet.next()) {
                employee_model = new Employee_model();
                employee_model.setId(resultSet.getInt("id"));
                employee_model.setName(resultSet.getString("name"));
                employee_model.setCitizen_no(resultSet.getString("citizen_no"));
                employee_model.setGender(resultSet.getString("gender"));
                employee_model.setAddress(resultSet.getString("address"));
                employee_model.setPhone(resultSet.getString("phone"));
                employee_model.setMail(resultSet.getString("mail"));
                employee_model.setUsername(resultSet.getString("username"));
                employee_model.setPassword(resultSet.getString("password"));
                employee_model.setPosition(resultSet.getString("position"));
                employee_model.setSalary(resultSet.getString("salary"));
                employee_model.setMarried(resultSet.getString("married"));
            }
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
        return employee_model;
    }

    public int updateEmployee(Employee_model employee_model) {
        try {
            String query;
            query = "Update employee Set name =?,citizen_no=?,address=?,mail=?,phone=?,username=?,password=? where id = ?";
            ps = db.connection.prepareStatement(query);
            ps.setString(1, employee_model.getName());
            ps.setString(2, employee_model.getCitizen_no());
            ps.setString(3, employee_model.getAddress());
            ps.setString(4, employee_model.getMail());
            ps.setString(5, employee_model.getPhone());
            ps.setString(6, employee_model.getUsername());
            ps.setString(7, employee_model.getPassword());
            ps.setInt(8, employee_model.getId());
            return db.manipulate(ps);

        } catch (SQLException e) {
            System.out.println("Error " + e);
            return 0;
        }
    }

    public int updateEmployeeAdmin(int ids) {
        try {
            Employee_model employee_model = new Employee_model();
            String query;
            query = "Update employee Set name =?,citizen_no=?,phone=?,mail=?,position =? where id = ?";
            ps = db.connection.prepareStatement(query);
            ps.setString(1, employee_model.getName());
            ps.setString(2, employee_model.getCitizen_no());
            ps.setString(3, employee_model.getPhone());
            ps.setString(4, employee_model.getMail());
            ps.setString(5, employee_model.getPosition());
            ps.setInt(6, ids);
            return db.manipulate(ps);
        } catch (SQLException e) {
            System.out.println("Error " + e);
            return 0;
        }
    }

    public int Picture(Employee_model er) {
        String query;
        try {
            query = "Update employee Set picture =? where id=?";
            ps = db.connection.prepareStatement(query);

            ps.setString(1, er.getPicture());
            ps.setInt(2, er.getId());

            return db.manipulate(ps);

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;

        }
    }

    public int deleteEmployee(int id) {
        try {
            String query = "delete from employee where id =?";
            ps = db.connection.prepareStatement(query);
            ps.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return db.manipulate(ps);
    }


    public int attendance(Attendance_model at){
        String query;
        try {
            query = "insert into attendance (name,date)" +
                    "values (?,?)";
            ps = db.connection.prepareStatement(query);

            ps.setString(1, at.getEmpName());
            ps.setString(2, at.getAttendanceDate());

        }catch (SQLException e){
            System.out.println(e);
        }
        return db.manipulate(ps);
    }


//    ======== forget password====

    public Employee_model Forgetpssword(String phone, String Username) {
        Employee_model employee_model= null;
        try{
            String query;
            query = "select id from employee where phone = ? and username=?";
            PreparedStatement pt = db.connection.prepareStatement(query);
            pt.setString(1,phone);
            pt.setString(2,Username);
            ResultSet rs = db.retrieve(pt);
            while(rs.next()){
                employee_model = new Employee_model();
                employee_model.setId(rs.getInt("id"));
                EmployeeForgetPassword.Cust_ID = rs.getInt("id");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee_model;
    }


    public int updateEmployeePassword(Employee_model employee_model) {
        try {
            String query;
            query = "Update employee Set password=? where id = ?";
            ps = db.connection.prepareStatement(query);

            ps.setString(1, employee_model.getPassword());
            ps.setInt(2,employee_model.getId());
            return db.manipulate(ps);

        } catch (SQLException e) {
            System.out.println("Error " + e);
            return 0;
        }
    }

    public ResultSet extractintoTableAttandance() {
        ResultSet rs = null;
        try {
            String query = "select * from attendance";
            PreparedStatement ps = db.connection.prepareStatement(query);
            rs = db.retrieve(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

}
