/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rfid_project.DatabaseUltils;

import java.util.List;
import rfid_project.Entity.Order;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class OrderDAO {

    private database db;

    public OrderDAO() {
        db = new database();
    }

    public List<Order> getOrderBy(String id) {
        List<Order> orders = new ArrayList<Order>();
        try {
            db.getConnect();
            String query = "SELECT * FROM orders ors WHERE ors.orderid = ? AND status= 2";
            PreparedStatement stmt = db.getCon().prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Order or = new Order();
                or.setOrderID(rs.getString(1));
                or.setOrderdate(rs.getString(2));
                or.setStatus(rs.getInt(3));
                or.setTotal(rs.getInt(4));
                orders.add(or);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return orders;
    }
    public int updateOrder(Order ds) {
		String query = "UPDATE orders"
                        + " SET "
                        + "status=?,"
                        + "total=?,"
                        + "last_modified=? "
				+ " WHERE orderid=?";
		db.getConnect();
		try {
			PreparedStatement stmt = db.getCon().prepareStatement(query);
			stmt.setInt(1, ds.getStatus());
                        stmt.setDouble(2, ds.getTotal());
                        stmt.setString(3,ds.getLast_modified());
                        stmt.setString(4, ds.getOrderID());	              
			return stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error");
        }
        db.disconnect();
	return 0;
    }
    public int addOrder(Order order){
        int ii=0; 
    	try {	
            db.getConnect();
            String query = "insert into orders values (?,?,?,?,?)";
            PreparedStatement stmt = db.getCon().prepareStatement(query);
            stmt.setString(1,order.getOrderID());
            stmt.setString(2,order.getOrderdate());
            stmt.setInt(3,order.getStatus());
            stmt.setDouble(4,order.getTotal());
            stmt.setString(5,order.getLast_modified());
             int iii2=stmt.executeUpdate();
            if(iii2 == 0) {
            	ii=0;
            }else {
            	ii=1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return ii;
    }
    public List<Order> getOrder() {
        List<Order> orders = new ArrayList<Order>();
        try {
            db.getConnect();
            String query = "SELECT * FROM orders ors";
            PreparedStatement stmt = db.getCon().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Order or = new Order();
                or.setOrderID(rs.getString(1));
                or.setOrderdate(rs.getString(2));
                or.setStatus(rs.getInt(3));
                or.setTotal(rs.getInt(4));
                orders.add(or);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return orders;
    }
    public List<Order> getOrderToPull() {
        List<Order> orders = new ArrayList<Order>();
        try {
            db.getConnect();
            String query = "SELECT * FROM orders ors WHERE ors.status !=3";
            PreparedStatement stmt = db.getCon().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Order or = new Order();
                or.setOrderID(rs.getString(1));
                or.setOrderdate(rs.getString(2));
                or.setStatus(rs.getInt(3));
                or.setTotal(rs.getInt(4));
                orders.add(or);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return orders;
    }
    public int getMax() {
        int t = 0;
        try {
            db.getConnect();
            String query = "SELECT orderid FROM orders ors order by orderdate";
            PreparedStatement stmt = db.getCon().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                t=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return t;
    }
    public List<Order> getOrderExport(String id) {
        List<Order> orders = new ArrayList<Order>();
        try {
            db.getConnect();
            String query = "SELECT * FROM orders ors WHERE ors.orderid = ?";
            PreparedStatement stmt = db.getCon().prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Order or = new Order();
                or.setOrderID(rs.getString(1));
                or.setOrderdate(rs.getString(2));
                or.setStatus(rs.getInt(3));
                or.setTotal(rs.getInt(4));
                or.setLast_modified(rs.getString(5));
                orders.add(or);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return orders;
    }
}
