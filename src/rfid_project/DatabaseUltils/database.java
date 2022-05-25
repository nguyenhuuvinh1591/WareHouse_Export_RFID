/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rfid_project.DatabaseUltils;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author LENOVO
 */
public class database {
    private  static Connection con;
    private static PreparedStatement stmt;
    private static ResultSet rs;
    public void getConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rfid_db?useSSL=false","root","");
        } catch (Exception e) {
        	e.printStackTrace();
            System.out.println("Kết nối không thành công");
        }
    }
    public Connection getCon() {
        return con;
    }
    
    public static PreparedStatement getStmt() {
		return stmt;
	}
	public static void setStmt(PreparedStatement stmt) {
		database.stmt = stmt;
	}
	public ResultSet execution(String sql) {
        try{
            rs=stmt.executeQuery(sql);
        }
        catch( SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e);
        }
        return rs;
    }

   
    

    public void disconnect(){
        try{
            if(rs !=null){
                rs.close();
                stmt.close();
                con.close();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
