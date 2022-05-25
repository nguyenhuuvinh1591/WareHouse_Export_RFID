/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rfid_project.Entity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class Tag2 {
	private String tagid;
        private String productid;
	private String tag_gate_in;
	private String tag_gate_out;
	private String tag_date_in;
	private String tag_date_out;
        public Product product;

    public Tag2() {
    }
public Tag2(String tagid) {
    this.tagid = tagid;
    }
    public Tag2(String tagid, String productid, String tag_gate_in, String tag_gate_out, String tag_date_in, String tag_date_out, Product product) {
        this.tagid = tagid;
        this.productid = productid;
        this.tag_gate_in = tag_gate_in;
        this.tag_gate_out = tag_gate_out;
        this.tag_date_in = tag_date_in;
        this.tag_date_out = tag_date_out;
        this.product = product;
    }

    public String getTagid() {
        return tagid;
    }

    public void setTagid(String tagid) {
        this.tagid = tagid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getTag_gate_in() {
        return tag_gate_in;
    }

    public void setTag_gate_in(String tag_gate_in) {
        this.tag_gate_in = tag_gate_in;
    }

    public String getTag_gate_out() {
        return tag_gate_out;
    }

    public void setTag_gate_out(String tag_gate_out) {
        this.tag_gate_out = tag_gate_out;
    }

    public String getTag_date_in() {
        return tag_date_in;
    }

    public void setTag_date_in(String tag_date_in) {
        this.tag_date_in = tag_date_in;
    }

    public String getTag_date_out() {
        return tag_date_out;
    }

    public void setTag_date_out(String tag_date_out) {
        this.tag_date_out = tag_date_out;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
        
}
