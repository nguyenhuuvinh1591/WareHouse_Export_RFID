/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rfid_project.Entity;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Order {
    private String orderID;
    private String orderdate;
    private int status;
    private double total;
    private String last_modified;
        public String getLast_modified() {
		return last_modified;
	}

	public void setLast_modified(String last_modified) {
		this.last_modified = last_modified;
	}

		public List<OrderDetail> orderdetails;

    public List<OrderDetail> getOrderdetails() {
        return orderdetails;
    }

	public void setOrderdetails(List<OrderDetail> orderdetails) {
        this.orderdetails = orderdetails;
    }

    public Order(String orderID, String orderdate, int status, double total,String last_modified) {
        this.orderID = orderID;
        this.orderdate = orderdate;
        this.status = status;
        this.total = total;
        this.last_modified = last_modified;
    }

    public Order() {
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
        
}
