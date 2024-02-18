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

public class Menu_Laporan extends javax.swing.JFrame {
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

public Menu_Laporan() {
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

        subbab = new javax.swing.JLabel();
        bab = new javax.swing.JLabel();
        btn_transaksipenjualan = new javax.swing.JButton();
        btn_transaksipembelian = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        lbl_tanggal = new javax.swing.JLabel();
        lbl_transaksipenjualam = new javax.swing.JLabel();
        lbl_transaksipembelian = new javax.swing.JLabel();
        btn_dashboard = new javax.swing.JButton();
        btn_akun = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btn_barang = new javax.swing.JButton();
        btn_opname = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_absen = new javax.swing.JButton();
        btn_oprasional = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        btn_logout1 = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subbab.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        subbab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subbab.setText("Mau Melihat Laporan Apa Admin?");
        getContentPane().add(subbab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 1060, 100));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setText("Hai Admin, Selamat Di Menu Laporan");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 1120, 50));

        btn_transaksipenjualan.setContentAreaFilled(false);
        btn_transaksipenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksipenjualanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_transaksipenjualan, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 350, 390, 200));

        btn_transaksipembelian.setContentAreaFilled(false);
        btn_transaksipembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksipembelianActionPerformed(evt);
            }
        });
        getContentPane().add(btn_transaksipembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 350, 390, 200));

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
        lbl_transaksipenjualam.setText("Laporan Penjualan");
        getContentPane().add(lbl_transaksipenjualam, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, -1, -1));

        lbl_transaksipembelian.setBackground(new java.awt.Color(255, 255, 255));
        lbl_transaksipembelian.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        lbl_transaksipembelian.setForeground(new java.awt.Color(255, 255, 255));
        lbl_transaksipembelian.setText("Laporan Pembelian");
        getContentPane().add(lbl_transaksipembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 410, -1, -1));

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
        getContentPane().add(btn_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, -1));

        btn_akun.setBackground(new java.awt.Color(255, 255, 255));
        btn_akun.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_akun.setForeground(new java.awt.Color(255, 255, 255));
        btn_akun.setText("Akun");
        btn_akun.setContentAreaFilled(false);
        btn_akun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_akunActionPerformed(evt);
            }
        });
        getContentPane().add(btn_akun, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, -1));

        btn_supplier.setBackground(new java.awt.Color(255, 255, 255));
        btn_supplier.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_supplier.setForeground(new java.awt.Color(255, 255, 255));
        btn_supplier.setText("supplier");
        btn_supplier.setContentAreaFilled(false);
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, -1));

        btn_barang.setBackground(new java.awt.Color(255, 255, 255));
        btn_barang.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_barang.setForeground(new java.awt.Color(255, 255, 255));
        btn_barang.setText("Barang");
        btn_barang.setContentAreaFilled(false);
        btn_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barangActionPerformed(evt);
            }
        });
        getContentPane().add(btn_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 200, -1));

        btn_opname.setBackground(new java.awt.Color(255, 255, 255));
        btn_opname.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_opname.setForeground(new java.awt.Color(255, 255, 255));
        btn_opname.setText("Opname");
        btn_opname.setContentAreaFilled(false);
        btn_opname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_opnameActionPerformed(evt);
            }
        });
        getContentPane().add(btn_opname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 200, -1));

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
        getContentPane().add(btn_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 200, -1));

        btn_absen.setBackground(new java.awt.Color(255, 255, 255));
        btn_absen.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_absen.setForeground(new java.awt.Color(255, 255, 255));
        btn_absen.setText("Absen");
        btn_absen.setContentAreaFilled(false);
        btn_absen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_absenActionPerformed(evt);
            }
        });
        getContentPane().add(btn_absen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 200, -1));

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
        getContentPane().add(btn_oprasional, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 200, -1));

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
        getContentPane().add(btn_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 200, -1));

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
        getContentPane().add(btn_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 200, -1));

        btn_logout1.setBackground(new java.awt.Color(255, 255, 255));
        btn_logout1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_logout1.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout1.setText("Log Out");
        btn_logout1.setContentAreaFilled(false);
        btn_logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 200, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend_1.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin logout?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
        this.setVisible(false);
        new Login().setVisible(true);
    }
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_transaksipenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksipenjualanActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda akan memulai transaksi penjualan. Lanjutkan?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
        this.setVisible(false);
        new Laporan_Pembelian().setVisible(true);
    }
    }//GEN-LAST:event_btn_transaksipenjualanActionPerformed

    private void btn_transaksipembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksipembelianActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda akan memulai transaksi pembelian. Lanjutkan?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
        this.setVisible(false);
        new Laporan_Penjualan().setVisible(true);
    }
    }//GEN-LAST:event_btn_transaksipembelianActionPerformed

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda akan memulai menu dashboard?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Dashboard().setVisible(true);
        }
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_akunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_akunActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda akan memulai menu akun?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Akun().setVisible(true);
        }
    }//GEN-LAST:event_btn_akunActionPerformed

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda akan memulai menu supplier?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Supplier().setVisible(true);
        }
    }//GEN-LAST:event_btn_supplierActionPerformed

    private void btn_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barangActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda akan memulai menu barang?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Barang().setVisible(true);
        }
    }//GEN-LAST:event_btn_barangActionPerformed

    private void btn_opnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opnameActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda akan memulai menu opname?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Opname().setVisible(true);
        }
    }//GEN-LAST:event_btn_opnameActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda akan memulai menu return?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Return().setVisible(true);
        }
    }//GEN-LAST:event_btn_returnActionPerformed

    private void btn_absenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_absenActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda akan memulai menu absen?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Absen_Admin().setVisible(true);
        }
    }//GEN-LAST:event_btn_absenActionPerformed

    private void btn_oprasionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_oprasionalActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda akan memulai menu oprasional?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Oprasional().setVisible(true);
        }
    }//GEN-LAST:event_btn_oprasionalActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
               int result = JOptionPane.showConfirmDialog(null, "Anda akan memulai menu transaksi?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Menu_Transaksi_Admin().setVisible(true);
        }
    }//GEN-LAST:event_btn_transaksiActionPerformed

    private void btn_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanActionPerformed

    }//GEN-LAST:event_btn_laporanActionPerformed

    private void btn_logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout1ActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin logout?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btn_logout1ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Laporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Laporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_absen;
    private javax.swing.JButton btn_akun;
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_logout1;
    private javax.swing.JButton btn_opname;
    private javax.swing.JButton btn_oprasional;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JButton btn_transaksipembelian;
    private javax.swing.JButton btn_transaksipenjualan;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_transaksipembelian;
    private javax.swing.JLabel lbl_transaksipenjualam;
    private javax.swing.JLabel subbab;
    // End of variables declaration//GEN-END:variables
}
