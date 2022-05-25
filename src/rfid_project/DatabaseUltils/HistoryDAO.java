/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rfid_project.DatabaseUltils;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import rfid_project.Entity.History;

/**
 *
 * @author LENOVO
 */
public class HistoryDAO {
    private database db;
    public HistoryDAO(){
        db = new database();
    }
    public List<History> getHistoriesBy(String date) {
        List<History> histories = new ArrayList<>();
        try {
            db.getConnect();
            String query = "SELECT h.id,h.orderid,h.status,h.detail,h.date FROM history h join orders on h.orderid = orders.orderid "
                    + "WHERE Date(h.date) = ?";
            PreparedStatement stmt = db.getCon().prepareStatement(query);
            stmt.setString(1, date);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                History hi = new History();
                hi.setId(rs.getInt(1));
                hi.setOrderid(rs.getString(2));
                hi.setStatus(rs.getInt(3));
                hi.setDetail(rs.getString(4));
                hi.setDate(rs.getString(5));
                histories.add(hi);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.disconnect();
        return histories;
    }
    public int addHistory(History his){
        int ii=0; 
    	try {	
            db.getConnect();
            String query = "insert into history(orderid,status,detail,date) values  (?,?,?,?)";
            PreparedStatement stmt = db.getCon().prepareStatement(query);
            stmt.setString(1,his.getOrderid());
            stmt.setInt(2,his.getStatus());
            stmt.setString(3,his.getDetail());
            stmt.setString(4,his.getDate());
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
}
