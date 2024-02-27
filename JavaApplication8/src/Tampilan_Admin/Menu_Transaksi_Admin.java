package Tampilan_Admin;

import Tampilan_Kasir.*;
import Config.Config;
import Tampilan_Awal.Login;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Menu_Transaksi_Admin extends javax.swing.JFrame {
String Tanggal; // Variabel untuk menyimpan tanggal
private DefaultTableModel model; // Model tabel default

/**
 * Mengatur tanggal dan waktu saat ini.
 */
public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
    String formattedDate = dateTime.format(formatter);
    lbl_tanggal.setText(formattedDate); // Mengatur label tanggal dengan tanggal yang diformat
}

public Menu_Transaksi_Admin() {
    initComponents();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");
    
    // Mengatur penjadwalan untuk memperbarui tanggal dan waktu secara periodik
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            setTanggalDanWaktuSekarang();
        }
    }, 0, 1, TimeUnit.SECONDS);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bab = new javax.swing.JLabel();
        btn_transaksipenjualan = new javax.swing.JButton();
        btn_transaksipembelian = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        lbl_tanggal = new javax.swing.JLabel();
        lbl_transaksipenjualam = new javax.swing.JLabel();
        lbl_transaksipembelian = new javax.swing.JLabel();
        btn_dashboard = new javax.swing.JButton();
        btn_datamaster = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_opname1 = new javax.swing.JButton();
        btn_oprasional = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setText("Hai Admin, Selamat Datang Di Menu Transaksi ");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 1120, 50));

        btn_transaksipenjualan.setContentAreaFilled(false);
        btn_transaksipenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksipenjualanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_transaksipenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 470, 200));

        btn_transaksipembelian.setContentAreaFilled(false);
        btn_transaksipembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksipembelianActionPerformed(evt);
            }
        });
        getContentPane().add(btn_transaksipembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 300, 460, 200));

        btn_logout.setBackground(new java.awt.Color(255, 255, 255));
        btn_logout.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setText("Log Out");
        btn_logout.setContentAreaFilled(false);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 200, -1));

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        lbl_transaksipenjualam.setBackground(new java.awt.Color(255, 255, 255));
        lbl_transaksipenjualam.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        lbl_transaksipenjualam.setForeground(new java.awt.Color(255, 255, 255));
        lbl_transaksipenjualam.setText("Transaksi Penjualan");
        getContentPane().add(lbl_transaksipenjualam, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, -1, -1));

        lbl_transaksipembelian.setBackground(new java.awt.Color(255, 255, 255));
        lbl_transaksipembelian.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        lbl_transaksipembelian.setForeground(new java.awt.Color(255, 255, 255));
        lbl_transaksipembelian.setText("Transaksi Pembelian");
        getContentPane().add(lbl_transaksipembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 370, -1, -1));

        btn_dashboard.setBackground(new java.awt.Color(255, 255, 255));
        btn_dashboard.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        btn_dashboard.setText("Dashboard");
        btn_dashboard.setContentAreaFilled(false);
        btn_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btn_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, -1));

        btn_datamaster.setBackground(new java.awt.Color(255, 255, 255));
        btn_datamaster.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_datamaster.setForeground(new java.awt.Color(255, 255, 255));
        btn_datamaster.setText("Data Master");
        btn_datamaster.setContentAreaFilled(false);
        btn_datamaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_datamasterActionPerformed(evt);
            }
        });
        getContentPane().add(btn_datamaster, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, -1));

        btn_transaksi.setBackground(new java.awt.Color(255, 255, 255));
        btn_transaksi.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        btn_transaksi.setText("Transaksi");
        btn_transaksi.setContentAreaFilled(false);
        btn_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 200, -1));

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
        btn_return.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_return.setForeground(new java.awt.Color(255, 255, 255));
        btn_return.setText("Return");
        btn_return.setContentAreaFilled(false);
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        getContentPane().add(btn_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 200, -1));

        btn_opname1.setBackground(new java.awt.Color(255, 255, 255));
        btn_opname1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_opname1.setForeground(new java.awt.Color(255, 255, 255));
        btn_opname1.setText("Opname");
        btn_opname1.setContentAreaFilled(false);
        btn_opname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_opname1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_opname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 200, -1));

        btn_oprasional.setBackground(new java.awt.Color(255, 255, 255));
        btn_oprasional.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_oprasional.setForeground(new java.awt.Color(255, 255, 255));
        btn_oprasional.setText("Oprasional");
        btn_oprasional.setContentAreaFilled(false);
        btn_oprasional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_oprasionalActionPerformed(evt);
            }
        });
        getContentPane().add(btn_oprasional, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 200, -1));

        btn_laporan.setBackground(new java.awt.Color(255, 255, 255));
        btn_laporan.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_laporan.setForeground(new java.awt.Color(255, 255, 255));
        btn_laporan.setText("Laporan");
        btn_laporan.setContentAreaFilled(false);
        btn_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 200, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Dashboard (9).png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
    this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_transaksipenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksipenjualanActionPerformed
    this.setVisible(false);
        new Transaksi_Penjualan_Admin().setVisible(true);
    }//GEN-LAST:event_btn_transaksipenjualanActionPerformed

    private void btn_transaksipembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksipembelianActionPerformed
    this.setVisible(false);
        new Transaksi_Pembelian_Admin().setVisible(true);
    }//GEN-LAST:event_btn_transaksipembelianActionPerformed

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_datamasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datamasterActionPerformed
        this.setVisible(false);
        new Menu_master().setVisible(true);
    }//GEN-LAST:event_btn_datamasterActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed

    }//GEN-LAST:event_btn_transaksiActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        this.setVisible(false);
        new Return().setVisible(true);
    }//GEN-LAST:event_btn_returnActionPerformed

    private void btn_opname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opname1ActionPerformed
        this.setVisible(false);
        new Opname().setVisible(true);
    }//GEN-LAST:event_btn_opname1ActionPerformed

    private void btn_oprasionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_oprasionalActionPerformed
        this.setVisible(false);
        new Oprasional().setVisible(true);
    }//GEN-LAST:event_btn_oprasionalActionPerformed

    private void btn_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanActionPerformed
        this.setVisible(false);
        new Menu_Laporan().setVisible(true);
    }//GEN-LAST:event_btn_laporanActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Transaksi_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Transaksi_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Transaksi_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Transaksi_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Transaksi_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_datamaster;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_opname1;
    private javax.swing.JButton btn_oprasional;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JButton btn_transaksipembelian;
    private javax.swing.JButton btn_transaksipenjualan;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_transaksipembelian;
    private javax.swing.JLabel lbl_transaksipenjualam;
    // End of variables declaration//GEN-END:variables
}
