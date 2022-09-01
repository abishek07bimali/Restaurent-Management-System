package model;

// fro ordering food
public class OrderFood {
    private int orderId;
    private String tableId;
    private String name;
    private String quantity;
    private String total;
    private  String totalsales;
    private  String date;


    public OrderFood(String table,String name,String quantity,String total){
        this.tableId=table;
        this.name=name;
        this.quantity=quantity;
        this.total=total;
    }
    public OrderFood(String date,String totalsales){
        this.date=date;
        this.totalsales=totalsales;
    }
    public OrderFood(){

    }


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalsales() {
        return totalsales;
    }

    public void setTotalsales(String totalsales) {
        this.totalsales = totalsales;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
