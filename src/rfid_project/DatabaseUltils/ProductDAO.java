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

/**
 *
 * @author LENOVO
 */
public class ProductDAO {
    private database db;
    public ProductDAO(){
        db = new database();
    }
    public int addProduct(Product pro){
        String query="insert into product values (?,?,?,?,?)";
        int k =0;
       db.getConnect();
               try {
                   PreparedStatement stmt = db.getCon().prepareStatement(query);
                   stmt.setString(1, pro.getPid());
                   stmt.setString(2,pro.getDetail());
                   stmt.setString(3, pro.getName());
                   stmt.setInt(4, pro.getQuantity());
                   stmt.setInt(5, pro.getPrice());
                   k = stmt.executeUpdate();
               } catch (Exception e) {
                   e.printStackTrace();
               }
               db.disconnect();  
               return k;
   }
    public Product getProductById(String id){
        String query="SELECT pid,detail,product_name,quantity,price FROM product WHERE pid = ?";
        Product p = new Product();
        db.getConnect();
                try {
                    PreparedStatement stmt = db.getCon().prepareStatement(query);
                    stmt.setString(1, id);
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                         p.setPid(rs.getString(1));
                         p.setDetail(rs.getString(2));
                         p.setName(rs.getString(3));
                         p.setQuantity(rs.getInt(4));
                         p.setPrice(rs.getInt(5));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                db.disconnect();  
                return p;
    }
    public List<Product> getProduct(){
        String query="SELECT pid,detail,product_name,quantity,price FROM product";
        List<Product> products = new ArrayList<>();
        db.getConnect();
                try {
                    PreparedStatement stmt = db.getCon().prepareStatement(query);
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        Product p = new Product();
                         p.setPid(rs.getString(1));
                         p.setDetail(rs.getString(2));
                         p.setName(rs.getString(3));
                         p.setQuantity(rs.getInt(4));
                         p.setPrice(rs.getInt(5));
                         products.add(p);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                db.disconnect();  
                return products;
    }
    public int updateProduct(List<Product> prods){
         String query="update product set "
                 + "quantity=? "
                 + "WHERE pid=?";
        db.getConnect();
                try {
                    PreparedStatement stmt = db.getCon().prepareStatement(query);
                    for(Product p:prods){
                        stmt.setInt(1,p.getQuantity());
                        stmt.setString(2,p.getPid());
                        stmt.addBatch();
                    }
                    stmt.executeBatch();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                db.disconnect();  
                return 0;
    }
    public int updateProductList(List<Product> prods){
        String query="update product set "
                + "quantity=?, "
                + "product_name=?,price=? "
                + "WHERE pid=?";
       db.getConnect();
               try {
                   PreparedStatement stmt = db.getCon().prepareStatement(query);
                   for(Product p:prods){
                       stmt.setInt(1,p.getQuantity());
                       stmt.setString(2,p.getName());
                       stmt.setInt(3,p.getPrice());
                       stmt.setString(4,p.getPid());
                       stmt.addBatch();
                   }
                   stmt.executeBatch();
               } catch (Exception e) {
                   e.printStackTrace();
               }
               db.disconnect();  
               return 0;
   }

}
