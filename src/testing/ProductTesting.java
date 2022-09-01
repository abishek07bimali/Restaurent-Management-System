package testing;

import controller.AdminController;
import controller.Product_controller;
import model.AdminModel;
import model.Product_model;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductTesting {

    @Test
    public void insert_food_test(){
        Product_controller productController = new Product_controller();
        Product_model productModel = new Product_model("pname","pcode","pavailable","pprice");
        int actual = productController.adding_food(productModel);
        int expected =1;
        assertEquals(expected,actual);

    }

    @Test
    public void fetchProductTest(){
        Product_controller productController = new Product_controller();
        Product_model pModel = new Product_model();
        Object actual = productController.fetchProductdata();
        assertEquals(pModel.getClass(),actual.getClass());
    }

    @Test
    public void delCustTest(){
        Product_controller productController = new Product_controller();
        Product_model pModel = new Product_model();
        int expected =1;
        int actual = productController.deleteCustomer(82);
        assertEquals(expected,actual);
    }

//    @Test
//    public void fetchIndTest(){
//        Product_controller productController = new Product_controller();
//        Product_model pModel = new Product_model();
//        Object actual = productController.fetchIndividualProduct();
//        assertEquals(pModel.getClass(),actual.getClass());
//    }

    @Test
    public void extractProductTest(){
        Product_controller productController = new Product_controller();
        Product_model pModel = new Product_model();
        Object actual = productController.extractProduct();
        assertEquals(pModel.getClass(),actual.getClass());
    }
}
