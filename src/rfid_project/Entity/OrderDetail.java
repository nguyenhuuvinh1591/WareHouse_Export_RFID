/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rfid_project.Entity;

/**
 *
 * @author LENOVO
 */
public class OrderDetail {
	private String orderID;
	private String productID;
    private int quantity;
    private int price;
    private int totalItem;
    private Product product;
    private Order order;

    public OrderDetail() {
    }

    public OrderDetail(String orderID, String productID, int quantity, int price, int totalItem, Product product, Order order) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.totalItem = totalItem;
        this.product = product;
        this.order = order;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
}
