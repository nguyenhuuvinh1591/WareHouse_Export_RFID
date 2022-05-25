/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rfid_project.DatabaseUltils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import rfid_project.Entity.Product;
import rfid_project.Entity.Tag2;

/**
 *
 * @author LENOVO
 */
public class TagDAO {
    private database db;
    public TagDAO(){
        db = new database();
    }
    public List<Tag2> getTagById(String tagID){
        List<Tag2> danhsach= new ArrayList();
        String query = "SELECT * from tag tg join product p on tg.product_id = p.pid WHERE tg.tagid= ?";
        db.getConnect();
                try {
                    PreparedStatement stmt = db.getCon().prepareStatement(query);
                    stmt.setString(1, tagID);
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        
                        Tag2 tag = new Tag2();
                        Product product = new Product();
                        tag.setTagid(rs.getString(1));
                        tag.setTag_date_in(rs.getString(2));
                        tag.setTag_date_out(rs.getString(3));
                        tag.setTag_gate_in(rs.getString(4));
                         tag.setTag_gate_out(rs.getString(5));
                         tag.setProductid(rs.getString(6));
                         product.setPid(rs.getString(7));
                         product.setDetail(rs.getString(8));
                         product.setName(rs.getString(9));
                         product.setQuantity(rs.getInt(10));
                         product.setPrice(rs.getInt(11));
                         tag.setProduct(product);
                        danhsach.add(tag);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                db.disconnect();   
                return danhsach;
    }
    public int updateTag2(List<Tag2> tags){
        String query = "UPDATE tag SET "
                + "tag_date_out = ? ,"
                + " tag_gate_out=? "
                + "WHERE tagid=?";
        db.getConnect();
		try {
		PreparedStatement stmt = db.getCon().prepareStatement(query);
                for(Tag2 tag:tags){
                    stmt.setString(1, tag.getTag_date_out());
                    stmt.setString(2, tag.getTag_gate_out());
                    stmt.setString(3, tag.getTagid());
                    stmt.addBatch();
                }
                int[] s = stmt.executeBatch();
		return s[0];
        } catch (Exception e) {
            e.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error");
        }
        db.disconnect();
        return 0;
    }
    public int addTag(List<Tag2> tags){
        String query = "insert into tag values (?,?,?,?,?,?)";
        db.getConnect();
		try {
		PreparedStatement stmt = db.getCon().prepareStatement(query);
                for(Tag2 tag:tags){
                    stmt.setString(1, tag.getTagid());
                    stmt.setString(2, tag.getTag_date_in());
                    stmt.setString(3, tag.getTag_date_out());
                    stmt.setString(4, tag.getTag_gate_in());
                    stmt.setString(5, tag.getTag_gate_out());
                    stmt.setString(6, tag.getProductid());
                    stmt.addBatch();
                }
                int[] s = stmt.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error");
        }
        db.disconnect();
        return 0;
    }
    public List<Tag2> getTagByDateTime(String date){
        List<Tag2> danhsach= new ArrayList();
        String query = "SELECT * from tag tg join product p on tg.product_id = p.pid WHERE tg.tag_date_out= ?";
        db.getConnect();
                try {
                    PreparedStatement stmt = db.getCon().prepareStatement(query);
                    stmt.setString(1, date);
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        
                        Tag2 tag = new Tag2();
                        Product product = new Product();
                        tag.setTagid(rs.getString(1));
                        tag.setTag_date_in(rs.getString(2));
                        tag.setTag_date_out(rs.getString(3));
                        tag.setTag_gate_in(rs.getString(4));
                         tag.setTag_gate_out(rs.getString(5));
                         tag.setProductid(rs.getString(6));
                         product.setPid(rs.getString(7));
                         product.setDetail(rs.getString(8));
                         product.setName(rs.getString(9));
                         product.setQuantity(rs.getInt(10));
                         product.setPrice(rs.getInt(11));
                         tag.setProduct(product);
                        danhsach.add(tag);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                db.disconnect();   
                return danhsach;
    }
}
