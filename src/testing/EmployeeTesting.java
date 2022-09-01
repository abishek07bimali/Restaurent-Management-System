package testing;

import controller.AdminController;
import controller.EmployeeController;
import controller.OrderController;
import controller.Product_controller;

import model.Attendance_model;
import model.Employee_model;
import model.OrderFood;
import model.Product_model;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTesting {

    @Test
    public void registerTest(){
        EmployeeController employeeController = new EmployeeController();
        Employee_model employeeModel = new Employee_model("fname","citizen_no","gender","address",
                "Mail","pNo","username","password","position",
                "salary","marriedStatus");
        int actual = employeeController.employeeRegistration(employeeModel);
        int expected =1;
        assertEquals(expected,actual);

    }

    @Test
    public void loginEmpPSTest() {
        EmployeeController employeeController = new EmployeeController();
        Employee_model employee_model = new Employee_model();
        Object actual = employeeController.loginAdminPreparedStatement("qqq","qqq");
        assertEquals(employee_model.getClass(),actual.getClass());
    }

    @Test
    public void fetchLoggedinEmpTest() {
        EmployeeController employeeController = new EmployeeController();
        Employee_model employee_model = new Employee_model();
        Object actual = employeeController.fetchLoggedInEmployee();
        assertEquals(employee_model.getClass(),actual.getClass());
    }

    @Test
    public void fetchRegEmpTest() {
        EmployeeController employeeController = new EmployeeController();
        Employee_model employee_model = new Employee_model();
        Object actual = employeeController.fetchRegisteredEmployee();
        assertEquals(employee_model.getClass(),actual.getClass());
    }

    @Test
    public void updateEmpTest() {
        EmployeeController employeeController = new EmployeeController();
        Employee_model employee_model = new Employee_model(1,"as","aaa");
        int expected =1;
        int actual = employeeController.updateEmployee(employee_model);
        assertEquals(expected,actual);
    }

    @Test
    public void picTest() {
        EmployeeController employeeController = new EmployeeController();
        Employee_model employee_model = new Employee_model(3,null);
        int expected =1;
        int actual = employeeController.Picture(employee_model);
        assertEquals(expected,actual);
    }

    @Test
    public void delEmpTest() {
        EmployeeController employeeController = new EmployeeController();
        Employee_model employee_model = new Employee_model();
        int expected=1;
        int actual = employeeController.deleteEmployee(2);
        assertEquals(expected,actual);
    }

    @Test
    public void attendanceTest() {
        EmployeeController employeeController = new EmployeeController();
//        Attendance_model attendance_model = new Attendance_model();
        int actual = employeeController.attendance(new Attendance_model("Abishek","2022-06-25-18-12-11"));
        assertEquals(1,actual);
    }

    @Test
    public void forgotPassTest() {
        EmployeeController employeeController = new EmployeeController();
        Employee_model employee_model = new Employee_model();
        Object actual = employeeController.Forgetpssword("1234512345","asdf");
        assertEquals(employee_model.getClass(),actual.getClass());
    }

    @Test
    public void updateEmpPasswordtest(){
        EmployeeController employeeController = new EmployeeController();
        Employee_model empModel = new Employee_model(3,"as","aaa");
        int expected =1;
        int actual = employeeController.updateEmployeePassword(empModel);
        assertEquals(expected,actual);
    }
}
