package model;

public class Product_model {


    int product_id;
    String product_name;
    String product_price;
    String product_available;
    String product_code;

    public Product_model(){

    }

    public Product_model( String product_name, String product_code, String product_available,String product_price){
        this.product_name = product_name;
        this.product_code=product_code;
        this.product_available = product_available;
        this.product_price = product_price;


    }
    public Product_model( int product_id,String product_name, String product_code, String product_available,String product_price){
        this.product_id= product_id;
        this.product_name = product_name;
        this.product_code=product_code;
        this.product_available = product_available;
        this.product_price = product_price;
    }

    public Product_model(String proName, String proCode, String proPrice) {
        this.product_name=proName;
        this.product_code=proCode;
        this.product_price=proPrice;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }


    public String getProduct_available() {
        return product_available;
    }

    public void setProduct_available(String product_available) {
        this.product_available = product_available;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }



    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }
}
