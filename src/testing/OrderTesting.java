package testing;

import controller.OrderController;
import model.OrderFood;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderTesting {

    @Test
    public void OrderFoodTest() {
        OrderController orderController = new OrderController();
        OrderFood orderModel = new OrderFood("TabelID", "Name", "Quantity", "Total");
        int actual = orderController.orderFood(orderModel);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void totalSalesTest() {
        OrderController orderController = new OrderController();
        OrderFood orderModel = new OrderFood("2022-06-25","Rs 11.00");
        int expected = 1;
        int actual = orderController.totalSAles(orderModel);
        assertEquals(expected,actual);
    }

    @Test
    public void delProductTest() {
        OrderController orderController = new OrderController();
        OrderFood orderModel = new OrderFood();
        int expected = 1;
        int actual = orderController.deleteProduct(4);
        assertEquals(expected,actual);
    }

    @Test
    public void extractTableTest() {
        OrderController orderController = new OrderController();
        OrderFood orderModel = new OrderFood();
//        int expected =1;
        Object actual = orderController.extractintoTable();
        assertEquals(orderModel.getClass(),actual.getClass());
    }

    @Test
    public void fetchTotalSalesTest() {
        OrderController orderController = new OrderController();
        OrderFood orderModel = new OrderFood();
        Object actual = orderController.fetchTotalsalesweekly();
        assertEquals(orderModel.getClass(),actual.getClass());
    }

//    @Test
//    public void dailyTotalTest() {
//        OrderController orderController = new OrderController();
//        OrderFood orderModel = new OrderFood();
//        int expected = 1;
//        int actual = orderController.daily_total("2022-07-01");
//        assertEquals(expected,actual);
//    }

}
