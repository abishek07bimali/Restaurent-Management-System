package model;

import javax.swing.*;

public class Employee_model {

    int id;
    String name;
    String citizen_no;
    String gender;
    String address;
    String phone;
    String mail;
    String username;
    String password;
    String position;
    String salary;
    String married;
    String picture;

    public  Employee_model(){

    }
    public Employee_model(String name, String citizen_no, String gender, String address, String eMail,
                          String phone, String username, String password, String position,String salary,
                          String married)
    {
        this.name = name;
        this.citizen_no = citizen_no;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.mail = eMail;
        this.username = username;
        this.password = password;
        this.position=position;
        this.salary = salary;
        this.married = married;
            }
    public Employee_model( int Id,String name, String citizen_no,String address, String eMail,
                           String phone, String username, String password) {
        this.id=Id;
        this.name = name;
        this.citizen_no = citizen_no;
        this.address = address;
        this.phone = phone;
        this.mail = eMail;
        this.username = username;
        this.password=password;

    }
    public Employee_model(int id,String picaddress){
        this.id=id;
        this.picture=picaddress;
    }

    public Employee_model(int id,String password,String username){
        this.id=id;
        this.password=password;
    }

    public Employee_model(int id, String name, String citizen_no, String phone, String mail, String position, String salary) {
        this.id=id;
        this.name = name;
        this.citizen_no = citizen_no;
        this.phone = phone;
        this.mail = mail;
        this.position = position;
        this.salary = salary;
    }

    public Employee_model(int i) {
        this.id=i;
    }

    public Employee_model(String empName, String empcitizen, String empmail, String empphone, String empposition, String empsalary) {
        this.name = empName;
        this.citizen_no = empcitizen;
        this.mail = empmail;
        this.phone = empphone;
        this.position = empposition;
        this.salary = empsalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCitizen_no() {
        return citizen_no;
    }

    public void setCitizen_no(String citizen_no) {
        this.citizen_no = citizen_no;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {return password;}

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
