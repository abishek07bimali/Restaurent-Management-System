package testing;

import controller.AdminController;
import controller.Product_controller;
import model.AdminModel;
import model.Employee_model;
import model.Product_model;
import org.junit.Test;
import view.Admin.AdminRegistration;

import static org.junit.Assert.assertEquals;

public class AdminTesting {

    @Test
    public void registerTest(){
        AdminController adminController = new AdminController();
        AdminModel adminModel = new AdminModel("Fullname","Gender","Email","Username","Password");
        int actual = adminController.adminRegistration(adminModel);
        int expected =1;
        assertEquals(expected,actual);

    }

    @Test
    public void loginPreparedTest(){
        AdminController adminController = new AdminController();
        AdminModel adminModel = new AdminModel();
        Object actual = adminController.loginAdminPreparedStatement("rak","123456");
        assertEquals(adminModel.getClass(),actual.getClass());
    }

    @Test
    public void fetchLoginAdminTest(){
        AdminController adminController = new AdminController();
        AdminModel adminModel = new AdminModel();
        Object actual = adminController.fetchLoggedInAdmin();
        assertEquals(adminModel.getClass(),actual.getClass());
    }

    @Test
    public void updateAdminProfileTest(){
        AdminController adminController = new AdminController();
        AdminModel adminModel = new AdminModel(2,"");
        int expected =1;
        int actual = adminController.updateAdminProfile(adminModel);
        assertEquals(expected,actual);
    }

    @Test
    public void adminPictureTest(){
        AdminController adminController = new AdminController();
        AdminModel adminModel = new AdminModel(2,null);
        int actual = adminController.Picture(adminModel);
        int expected =1;
        assertEquals(expected,actual);
    }

    @Test
    public void delAdminTest(){
        AdminController adminController = new AdminController();
        AdminModel adminModel = new AdminModel();
        Object actual = adminController.deleteAdmin(3);
        int expected =1;
        assertEquals(expected,actual);
    }

    @Test
    public void forgotPassAdminTest(){
        AdminController adminController = new AdminController();
        AdminModel adminModel = new AdminModel();
        Object actual = adminController.Forgetpssword("rak@gmail.com","rak");
        assertEquals(adminModel.getClass(),actual.getClass());
    }

    @Test
    public void updatePassAdminTest(){
        AdminController adminController = new AdminController();
        AdminModel adminModel = new AdminModel(5,"asdfgh1","abishek");
        int actual = adminController.updateAdminPassword(adminModel);
        int expected =1;
        assertEquals(expected,actual);
    }

    @Test
    public void updateEmpAdminTest(){
        AdminController adminController = new AdminController();
        Employee_model employee_model = new Employee_model("1", "1", "2", "3",
                "abi@gmail.com","980980980", "4", "as","","6","Not married");
        int actual = adminController.updateEmployeeAdmin(employee_model);
        int expected =1;
        assertEquals(expected,actual);
    }

    @Test
    public void updateProductTest(){
        AdminController adminController = new AdminController();
        Product_model product_model = new Product_model(85,
                "pizza",
                "21",
                "available",
                "300");
        int expected =1;
        int actual = adminController.updateProduct(product_model);
        assertEquals(expected,actual);
    }

}
