/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rfid_project.DatabaseUltils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import rfid_project.Entity.OrderDetail;
import rfid_project.Entity.Product;
import rfid_project.Entity.Tag2;

/**
 *
 * @author LENOVO
 */
public class OrderDetailDAO {
    private database db;
    public OrderDetailDAO(){
        db = new database();
    }
    public List<OrderDetail> getOrderDetail(String pid){
        String query = "SELECT dt.order_id,dt.product_id FROM order_detail dt join product p on dt.product_id=p.pid join orders orr on orr.orderid = dt.order_id WHERE p.pid = ? AND orr.status=2";
        List<OrderDetail> lis = new ArrayList<>();
        db.getConnect();
                try {
                    PreparedStatement stmt = db.getCon().prepareStatement(query);
                    stmt.setString(1, pid);
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                      OrderDetail or = new OrderDetail();  
                      or.setOrderID(rs.getString(1));
                      or.setProductID(rs.getString(2));
                        lis.add(or);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                db.disconnect();   
                return lis;
    }
    public List<OrderDetail> getOrderDetail2(String orderid){
        String query = "SELECT dt.order_id,dt.product_id,dt.price,dt.quantity,dt.total FROM order_detail dt join orders ors on dt.order_id=ors.orderid WHERE ors.orderid = ?";
        List<OrderDetail> lis = new ArrayList<>();
        db.getConnect();
                try {
                    PreparedStatement stmt = db.getCon().prepareStatement(query);
                    stmt.setString(1, orderid);
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                      OrderDetail or = new OrderDetail();  
                      or.setOrderID(rs.getString(1));
                      or.setProductID(rs.getString(2));
                      or.setPrice(rs.getInt(3));
                      or.setQuantity(rs.getInt(4));
                      or.setTotalItem(rs.getInt(5));
                      lis.add(or);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                db.disconnect();   
                return lis;
    }
     public int addDetail(List<OrderDetail> orderdetails){
        String query = "insert into order_detail values (?,?,?,?,?)";
        db.getConnect();
                try {
                    PreparedStatement stmt = db.getCon().prepareStatement(query);
                    for(OrderDetail or:orderdetails) {
                    	stmt.setString(1,or.getOrderID());
                        stmt.setString(2,or.getProductID());
                        stmt.setInt(3,or.getPrice());
                        stmt.setInt(4,or.getQuantity());
                        stmt.setInt(5,or.getTotalItem());
                        stmt.addBatch();
                    }
                    //stmt.setString(1, orderid);
                   stmt.executeBatch();
                   
                } catch (Exception e) {
                    e.printStackTrace();
                }
                db.disconnect();   
                return 0;
    }
}
