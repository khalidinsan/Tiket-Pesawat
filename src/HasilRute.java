
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Khalid
 */
public class HasilRute extends javax.swing.JFrame {

    /**
     * Creates new form HasilRute
     */
    String idMaskapai = "";
    String Asal = "";
    String Tujuan = "";
    public HasilRute(String id_maskapai, String asal, String tujuan) {
        initComponents();
        this.idMaskapai = id_maskapai;
        this.Asal = asal;
        this.Tujuan = tujuan;
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);
           try {
            //membuat statemen pemanggilan data pada table tblGaji dari database
            Statement stat = (Statement) Koneksi.configDB().createStatement();
            String sql = "SELECT * FROM maskapai WHERE id_maskapai = '"+id_maskapai+"'";
            ResultSet res = stat.executeQuery(sql);

            //penelusuran baris pada tabel tblGaji dari database
            while (res.next()) {
                lblNamaMaskapai.setText(res.getString("nama_maskapai"));
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        lblAsal.setText(asal);
        lblTujuan.setText(tujuan);
        
        
           try {
            //membuat statemen pemanggilan data pada table tblGaji dari database
            Statement stat = (Statement) Koneksi.configDB().createStatement();
            String sql = "SELECT * FROM rute WHERE id_maskapai = '"+id_maskapai+"' AND asal = '"+asal+"' AND tujuan = '"+tujuan+"'";
            ResultSet res = stat.executeQuery(sql);

            //penelusuran baris pada tabel tblGaji dari database
            int pinggir = 20;
            int atas = 260;
            while (res.next()) {
                
                    JPanel panel = new javax.swing.JPanel();
                    panel.setBackground(new java.awt.Color(242, 242, 242));
                    panel.setBorder(new EmptyBorder(18, 18, 18, 18));
                    panel.setPreferredSize(new Dimension(500, 80));
                    panel.setLayout(new AbsoluteLayout());
                    this.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(pinggir, atas, 910, -1));
                    
                    JLabel lKelas = new javax.swing.JLabel();
                    Font fKelas = new Font("Segoe UI Light", Font.PLAIN, 14);
                    lKelas.setFont(fKelas);
                    lKelas.setText("Kelas");
                    
                    JLabel jLabel12 = new javax.swing.JLabel();
                    Font font1 = new Font("Segoe UI Bold", Font.PLAIN, 16);
                    jLabel12.setFont(font1);
                    jLabel12.setText(res.getString("kelas").toUpperCase());
//                    jLabel12.setLocation(pinggir, atas);
//                    jLabel12.setBounds(1,1, 10, 10);
//                    jLabel12.setSize(56,12);
                    lKelas.setHorizontalAlignment(SwingConstants.CENTER);
                    jLabel12.setHorizontalAlignment(SwingConstants.CENTER);
                    panel.add(lKelas,new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 17, 100, -1));
                    panel.add(jLabel12,new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 37, 100, -1));
                    
                    JLabel lHarga = new javax.swing.JLabel();
                    Font fHarga = new Font("Segoe UI Bold", Font.PLAIN, 16);
                    lHarga.setFont(fHarga);
                    int harga = res.getInt("harga");
                    lHarga.setText(Koneksi.Rupiah(harga));
                    
                    lHarga.setHorizontalAlignment(SwingConstants.CENTER);
                    
                    JButton buttonPesan = new javax.swing.JButton();
                    buttonPesan.setText("Pesan");
                    
                    Font fontBtn = new Font("Segoe UI Semibold", Font.PLAIN, 13);
                    buttonPesan.setFont(fontBtn);
                    buttonPesan.setBackground(new java.awt.Color(12, 67, 90));
                    buttonPesan.setForeground(new java.awt.Color(255, 255, 255));
                    buttonPesan.setBorderPainted(false);
                    buttonPesan.setContentAreaFilled(false);
                    buttonPesan.setOpaque(true);
                    buttonPesan.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    
                    String id_rute = res.getString("id_rute");
                    HasilRute as = this;
                    panel.add(lHarga,new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 10, 100, -1));
                    panel.add(buttonPesan,new org.netbeans.lib.awtextra.AbsoluteConstraints(785, 37, 100, -1));
                        buttonPesan.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                System.out.println(id_rute);
                                Pesan a = new Pesan(id_rute);
                                as.dispose();
                                a.setVisible(true);
                                
                        }
                    });
                    atas += 90;
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTujuan = new javax.swing.JLabel();
        lblNamaMaskapai = new javax.swing.JLabel();
        lblAsal = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo-white.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dot2.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/circle2.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -20, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/header2.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 950, 240));

        jPanel2.setBackground(new java.awt.Color(9, 120, 165));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 550, 960, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 1, 18)); // NOI18N
        jLabel5.setText("Hasil Pencarian");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jPanel1.setBackground(new java.awt.Color(12, 67, 90));
        jPanel1.setForeground(new java.awt.Color(12, 67, 90));

        lblTujuan.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblTujuan.setForeground(new java.awt.Color(255, 255, 255));
        lblTujuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_airplane_landing_15px.png"))); // NOI18N
        lblTujuan.setText("jLabel6");

        lblNamaMaskapai.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblNamaMaskapai.setForeground(new java.awt.Color(255, 255, 255));
        lblNamaMaskapai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_airplane_mode_on_15px.png"))); // NOI18N
        lblNamaMaskapai.setText("jLabel6");

        lblAsal.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        lblAsal.setForeground(new java.awt.Color(255, 255, 255));
        lblAsal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_airplane_take_off_15px.png"))); // NOI18N
        lblAsal.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(lblAsal)
                .addGap(78, 78, 78)
                .addComponent(lblTujuan)
                .addContainerGap(533, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(lblNamaMaskapai)
                    .addContainerGap(822, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblTujuan, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addComponent(lblAsal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(lblNamaMaskapai, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 910, 30));

        jButton2.setBackground(new java.awt.Color(9, 120, 165));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_go_back_13px_1.png"))); // NOI18N
        jButton2.setText("Kembali");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setOpaque(true);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, 110, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setBackground(new java.awt.Color(12, 67, 90));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setBackground(new java.awt.Color(9, 120, 165));
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Rute a = new Rute(this.idMaskapai);
        a.cbAsal.setSelectedItem(this.Asal);
        a.cbTujuan.setSelectedItem(this.Tujuan);
        a.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(HasilRute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HasilRute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HasilRute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HasilRute.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HasilRute("","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAsal;
    private javax.swing.JLabel lblNamaMaskapai;
    private javax.swing.JLabel lblTujuan;
    // End of variables declaration//GEN-END:variables
}
