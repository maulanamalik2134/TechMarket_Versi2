package Tampilan_Kasir;

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

public class Menu_Transaks_Kasir extends javax.swing.JFrame {
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

public Menu_Transaks_Kasir() {
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
        btn_menutransaksi = new javax.swing.JButton();
        lbl_tanggal = new javax.swing.JLabel();
        lbl_transaksipenjualam = new javax.swing.JLabel();
        lbl_transaksipembelian = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subbab.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        subbab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subbab.setText("Mau Melakukan Transaksi Apa Kasir?");
        getContentPane().add(subbab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 1060, 100));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setText("Hai Kasir, Selamat Di Menu Transaksi ");
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

        btn_menutransaksi.setBackground(new java.awt.Color(255, 255, 255));
        btn_menutransaksi.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_menutransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btn_menutransaksi.setText("Transaksi");
        btn_menutransaksi.setContentAreaFilled(false);
        getContentPane().add(btn_menutransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, -1));

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        lbl_transaksipenjualam.setBackground(new java.awt.Color(255, 255, 255));
        lbl_transaksipenjualam.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        lbl_transaksipenjualam.setForeground(new java.awt.Color(255, 255, 255));
        lbl_transaksipenjualam.setText("Transaksi Penjualan");
        getContentPane().add(lbl_transaksipenjualam, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, -1, -1));

        lbl_transaksipembelian.setBackground(new java.awt.Color(255, 255, 255));
        lbl_transaksipembelian.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 36)); // NOI18N
        lbl_transaksipembelian.setForeground(new java.awt.Color(255, 255, 255));
        lbl_transaksipembelian.setText("Transaksi Pembelian");
        getContentPane().add(lbl_transaksipembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 410, -1, -1));

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
        new Transaks_Penjualan_Kasir().setVisible(true);
    }
    }//GEN-LAST:event_btn_transaksipenjualanActionPerformed

    private void btn_transaksipembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksipembelianActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Anda akan memulai transaksi pembelian. Lanjutkan?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
    if (result == JOptionPane.YES_OPTION) {
        this.setVisible(false);
        new Transaks_Pembelian_Kasir().setVisible(true);
    }
    }//GEN-LAST:event_btn_transaksipembelianActionPerformed

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
            java.util.logging.Logger.getLogger(Menu_Transaks_Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Transaks_Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Transaks_Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Transaks_Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Transaks_Kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_menutransaksi;
    private javax.swing.JButton btn_transaksipembelian;
    private javax.swing.JButton btn_transaksipenjualan;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_transaksipembelian;
    private javax.swing.JLabel lbl_transaksipenjualam;
    private javax.swing.JLabel subbab;
    // End of variables declaration//GEN-END:variables
}
