/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rfid_project.Entity;

/**
 *
 * @author LENOVO
 */
public class History {
    public int id;
    public String orderid;
    public int status;
    public String detail;
    public String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public History() {
    }

    public History(int id, String orderid, int status, String detail,String date) {
        this.id = id;
        this.orderid = orderid;
        this.status = status;
        this.detail = detail;
        this.date = date;
    }
    
}
