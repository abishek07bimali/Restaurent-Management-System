package model;

import java.sql.Blob;

public class AdminModel {
    //        JLabel name_label,ctz_no_label,address_lbl,gender_lbl,e_mail_lbl,phone_no_lbl,username_lbl,password_lbl;

    private String pic_address;
    private int adminId;
    private String FullName;
    private String Gender;
    private String Email;
    private String Username;
    private String Password;


    public AdminModel(){

    }


    public AdminModel(String fullName, String gender, String email, String username, String password) {

        this.FullName = fullName;
        this.Gender = gender;
        this.Email = email;
        this.Username = username;
        this.Password = password;

    }



    public AdminModel(int adminId, String fullName, String gender,String email, String username, String password) {
        this.adminId=adminId;
        this.FullName = fullName;
        this.Gender = gender;
        this.Email = email;
        this.Username = username;
        this.Password = password;

    }

    public AdminModel(int adminId,String pic){
        this.adminId=adminId;
        this.pic_address =pic;
}



    public AdminModel(int admin, String password,String username) {
        this.adminId=admin;
        this.Password=password;
        this.Username=username;
    }


    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getPic_address() {
        return pic_address;
    }

    public void setPic_address(String pic_address) {
        this.pic_address = pic_address;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}
