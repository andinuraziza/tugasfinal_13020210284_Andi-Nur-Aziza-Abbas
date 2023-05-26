package Login;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Barang extends javax.swing.JFrame {
    private DefaultTableModel model;
    
void dataBarang(){
    model.addColumn("Kode Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Harga");
    model.addColumn("Stok");
    txTable.setModel(model);
    try{    
        String sql = "SELECT * FROM barang";
        Connection c =(Connection)Koneksi.DBConnection();
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(sql);
        
        
        while (r.next()){
            Object[] obj = new Object[4];
            obj [0] = r.getString("kode");
            obj [1] = r.getString("nama");
            obj [2] = r.getString("harga");
            obj [3] = r.getString("stok");
            
            model.addRow(obj);
        }
        r.close();
        s.close();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}

void idBarang(){
     try{
            String sql = "SELECT * FROM barang ORDER BY kode DESC";
            Connection c =(Connection)Koneksi.DBConnection();
            Statement s = c.createStatement();
            ResultSet r = s.executeQuery(sql);
            
            if (r.next()){
                String id = r.getString("kode").substring(1);
                String a = "" + (Integer.parseInt(id) + 1);
                String n = "";
                
                if (a.length() == 1){
                    n = "01";
                }
                else if(a.length() == 2){
                    n = "0";
                }
                txKode.setText("A" + n + a);
            }
            else {
                txKode.setText("A011");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}


void clear(){
        txBarang.setText("");
        txHarga.setText("");
        txStok.setText("");
    }

void refresh(){
    model = new DefaultTableModel();
    model.addColumn("Kode Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Harga");
    model.addColumn("Stok");
    txTable.setModel(model);
    
    try{
        String sql = "SELECT * FROM barang";
        Connection c =(Connection)Koneksi.DBConnection();
        Statement s = c.createStatement();
        ResultSet r = s.executeQuery(sql);
        
        while(r.next()){
            Object[] obj = new Object[4];
            obj [0] = r.getString("kode");
            obj [1] = r.getString("nama");
            obj [2] = r.getString("harga");
            obj [3] = r.getString("stok");
            
            model.addRow(obj);
        }
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
    public Barang() {
        initComponents();
        
        model = new DefaultTableModel();
        idBarang();
        dataBarang();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txBarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txKode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txStok = new javax.swing.JTextField();
        txSimpan = new javax.swing.JButton();
        txHapus = new javax.swing.JButton();
        txEdit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txTable = new javax.swing.JTable();
        txKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DAFTAR MOTOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nama Motor");

        txBarang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Kode Barang");

        txKode.setBackground(new java.awt.Color(204, 204, 204));
        txKode.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));
        txKode.setEnabled(false);
        txKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txKodeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Harga");

        txHarga.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Stok");

        txStok.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 2, true));

        txSimpan.setBackground(new java.awt.Color(153, 255, 153));
        txSimpan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txSimpan.setForeground(new java.awt.Color(255, 255, 255));
        txSimpan.setText("Simpan");
        txSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txSimpanActionPerformed(evt);
            }
        });

        txHapus.setBackground(new java.awt.Color(255, 102, 102));
        txHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txHapus.setForeground(new java.awt.Color(255, 255, 255));
        txHapus.setText("Hapus");
        txHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txHapusActionPerformed(evt);
            }
        });

        txEdit.setBackground(new java.awt.Color(204, 204, 204));
        txEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txEdit.setText("Edit");
        txEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEditActionPerformed(evt);
            }
        });

        txTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        txTable.setRowHeight(30);
        txTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(txTable);

        txKembali.setBackground(new java.awt.Color(204, 204, 204));
        txKembali.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txKembali.setText("Kembali");
        txKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txKode, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txStok, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txKode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txStok, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txSimpanActionPerformed
        try{
            String kode = txKode.getText();
            String nama = txBarang.getText();
            String harga = txHarga.getText();
            String stok = txStok.getText();
            
            String sql = "INSERT INTO barang VALUES (? , ? , ? , ?)";
            Connection c =(Connection)Koneksi.DBConnection();
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, kode);
            p.setString(2, nama);
            p.setString(3, harga);
            p.setString(4, stok);
            p.execute();
            this.setVisible(false);
            new Barang().setVisible(true);
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txSimpanActionPerformed

    private void txKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txKodeActionPerformed
      
    }//GEN-LAST:event_txKodeActionPerformed

    private void txEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEditActionPerformed
        try{
            String kode = txKode.getText();
            String nama = txBarang.getText();
            String harga = txHarga.getText();
            String stok = txStok.getText();
            
            String sql = "UPDATE barang SET nama = ?, harga = ?, stok = ? where kode = ? ";
            Connection c =(Connection)Koneksi.DBConnection();
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, nama);
            p.setString(2, harga);
            p.setString(3, stok);
            p.setString(4, txKode.getText());
            
            p.execute();
            refresh();
            clear();
            
            txSimpan.setEnabled(true);
            txEdit.setEnabled(false);
            txHapus.setEnabled(false);
            
            this.setVisible(false);
            new Barang().setVisible(true);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_txEditActionPerformed

    private void txTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txTableMouseClicked
        txKode.setText(model.getValueAt(txTable.getSelectedRow(), 0).toString());
        txBarang.setText(model.getValueAt(txTable.getSelectedRow(), 1).toString());
        txHarga.setText(model.getValueAt(txTable.getSelectedRow(), 2).toString());
        txStok.setText(model.getValueAt(txTable.getSelectedRow(), 3).toString());
        
        txSimpan.setEnabled(false);
        txHapus.setEnabled(true);
        txEdit.setEnabled(true);
    }//GEN-LAST:event_txTableMouseClicked

    private void txHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txHapusActionPerformed
        try{
            String kode = txKode.getText();
            
            String sql = "DELETE from barang where kode = ?";
            Connection c =(Connection)Koneksi.DBConnection();
            PreparedStatement p = c.prepareStatement(sql);
            
            p.setString(1, kode);
            p.execute();
            refresh();
            clear();
           
            txSimpan.setEnabled(true);
            txEdit.setEnabled(false);
            txHapus.setEnabled(false);
            
            this.setVisible(false);
            new Barang().setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_txHapusActionPerformed

    private void txKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txKembaliActionPerformed
        this.setVisible(false);
        new Main().setVisible(true);
    }//GEN-LAST:event_txKembaliActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txBarang;
    private javax.swing.JButton txEdit;
    private javax.swing.JButton txHapus;
    private javax.swing.JTextField txHarga;
    private javax.swing.JButton txKembali;
    private javax.swing.JTextField txKode;
    private javax.swing.JButton txSimpan;
    private static javax.swing.JTextField txStok;
    private javax.swing.JTable txTable;
    // End of variables declaration//GEN-END:variables
}
