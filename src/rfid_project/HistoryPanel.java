/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package rfid_project;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import rfid_project.DatabaseUltils.HistoryDAO;
import rfid_project.DatabaseUltils.OrderDAO;
import rfid_project.DatabaseUltils.OrderDetailDAO;
import rfid_project.DatabaseUltils.ProductDAO;
import rfid_project.DatabaseUltils.TagDAO;
import rfid_project.Entity.History;
import rfid_project.Entity.Order;
import rfid_project.Entity.OrderDetail;
import rfid_project.Entity.Tag2;
import utility.Constant;
import utility.ExcelUtils;

/**
 *
 * @author LENOVO
 */
public class HistoryPanel extends javax.swing.JPanel {

    /**
     * Creates new form HistoryPanel
     */
    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static final String lower = upper.toLowerCase(Locale.ROOT);
    public static final String digits = "0123456789";

    public static final String alphanum = upper + lower + digits;
    SecureRandom rnd = new SecureRandom();
    List<History> ids = new ArrayList<>();
    List<History> fail = new ArrayList<>();
    HistoryDAO historydao = new HistoryDAO();
    OrderDAO orderdao = new OrderDAO();
    OrderDetailDAO detaildao = new OrderDetailDAO();
    ProductDAO productdao = new ProductDAO();
    TagDAO tagdao = new TagDAO();

    public HistoryPanel() {
        Date d = new Date();
        initComponents();
        jDateChooser1.setDate(d);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(d);
        updateTable(date);

    }

    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(alphanum.charAt(rnd.nextInt(alphanum.length())));
        }
        return sb.toString();
    }

    public void updateTable(String date) {
        ids.clear();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        List<History> histories = historydao.getHistoriesBy(date);
        jTable1.getColumnModel().getColumn(1).setMinWidth(20);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(20);
        jTable1.getColumnModel().getColumn(1).setWidth(20);
        model.setRowCount(0);
        Object[] obj = new Object[5];
        for (History his : histories) {
            if (his.getStatus() == 1) {
                ids.add(his);
            }
            if (his.getStatus() == 0) {
                fail.add(his);
            }
            obj[0] = his.getDate();
            obj[1] = his.getId();
            obj[2] = his.getOrderid();
            if (his.getStatus() == 1) {
                obj[3] = "Success";
            } else {
                if (his.getStatus() == 0) {
                    obj[3] = "Fail";

                }
            }
            obj[4] = his.getDetail();

            model.addRow((obj));
        }
        model.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 255, 255));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Id", "Order", "Status", "Detail"
            }
        ));
        jTable1.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Xu???t File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("L???ch S???");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Ng??y");

        jButton2.setBackground(new java.awt.Color(255, 255, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("L???c");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(177, 177, 177))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Date d = jDateChooser1.getDate();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(d);
        updateTable(date);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Date d = jDateChooser1.getDate();
        int line = 1;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String reportPath = "report_" + formatter.format(d) + ".xlsx";
        System.out.println(reportPath);
        try {
            ExcelUtils.setExcelFile(Constant.Path_save + reportPath, "Sheet1");
            for (History his : ids) {
                int k = line;
                Order or = orderdao.getOrderExport(his.getOrderid()).get(0);
                ExcelUtils.setCellData(Constant.Path_save + reportPath, or.getLast_modified(), line, 0);
                ExcelUtils.setCellData(Constant.Path_save + reportPath, or.getOrderID(), line, 1);
                ExcelUtils.setCellData(Constant.Path_save + reportPath, his.getDetail(), line, 7);
                or.setOrderdetails(detaildao.getOrderDetail2(his.getOrderid()));

                List<Tag2> tags = tagdao.getTagByDateTime(or.getLast_modified());
                System.out.println("size : " + tags.size());
                line++;
                int quan = 0;
                if (his.getStatus() == 1) {
                    for (int i = 0; i < tags.size(); i++) {
                        String pid = tags.get(i).getProductid();
                        OrderDetail det = or.getOrderdetails().stream()
                                .filter(a -> Objects.equals(a.getProductID(), pid))
                                .collect(Collectors.toList()).get(0);
                        quan++;
                        ExcelUtils.setCellData(Constant.Path_save + reportPath, det.getPrice() + "", line, 5);
                        ExcelUtils.setCellData(Constant.Path_save + reportPath, tags.get(i).getTagid(), line, 2);
                        ExcelUtils.setCellData(Constant.Path_save + reportPath, tags.get(i).getTag_gate_out(), line, 6);
                        ExcelUtils.setCellData(Constant.Path_save + reportPath, tags.get(i).product.getName(), line, 3);
                        line++;
                    }
                    ExcelUtils.setCellData(Constant.Path_save + reportPath, quan + "", k, 4);
                }
                

            }
            for(History his: fail) {
            	Order or = orderdao.getOrderExport(his.getOrderid()).get(0);
                ExcelUtils.setCellData(Constant.Path_save + reportPath, his.getDate(), line, 0);
                ExcelUtils.setCellData(Constant.Path_save + reportPath, or.getOrderID(), line, 1);
                ExcelUtils.setCellData(Constant.Path_save + reportPath, his.getDetail(), line, 7);
                line++;
            }
            

        } catch (Exception ex) {
            Logger.getLogger(HistoryPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
