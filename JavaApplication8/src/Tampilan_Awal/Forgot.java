package Tampilan_Awal;

import Config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Forgot extends javax.swing.JFrame {

    String Tanggal; // Variabel untuk menyimpan tanggal
private DefaultTableModel model; // Model tabel default

/**
 * Mengatur tanggal dan waktu saat ini.
 */
public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
    String formattedDate = dateTime.format(formatter);

    String lokasiToko = "Jl. Raya Situbondo, Blk. Gardu, Cindogo, Tapen, Kabupaten Bondowoso, Jawa Timur 68282"; // Lokasi toko

    lbl_tanggal.setText(formattedDate); // Mengatur label tanggal dengan tanggal yang diformat
    lbl_lokasi.setText(lokasiToko); // Mengatur label lokasi dengan lokasi toko
}

public Forgot() {
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

        lbl_lokasi = new javax.swing.JLabel();
        lbl_tanggal = new javax.swing.JLabel();
        Lbl_forgot = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JFormattedTextField();
        txt_konfirmasipassword = new javax.swing.JPasswordField();
        chk_showpassword = new javax.swing.JCheckBox();
        lbl_password = new javax.swing.JLabel();
        lbl_konfirmasipassword = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        btn_cancel = new javax.swing.JButton();
        btn_forgot = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_lokasi.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_lokasi.setForeground(new java.awt.Color(255, 255, 255));
        lbl_lokasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(lbl_lokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 860, 50));

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 490, 50));

        Lbl_forgot.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36)); // NOI18N
        Lbl_forgot.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_forgot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_forgot.setText("FORGOT");
        getContentPane().add(Lbl_forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 130, 400, -1));

        lbl_email.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_email.setText("Email");
        getContentPane().add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 200, -1, -1));

        txt_email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 300, 40));

        txt_konfirmasipassword.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(txt_konfirmasipassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 380, 300, 40));

        chk_showpassword.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        chk_showpassword.setForeground(new java.awt.Color(255, 255, 255));
        chk_showpassword.setText("Show Password");
        chk_showpassword.setContentAreaFilled(false);
        chk_showpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_showpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(chk_showpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 430, -1, -1));

        lbl_password.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_password.setText("Password");
        getContentPane().add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 280, -1, -1));

        lbl_konfirmasipassword.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_konfirmasipassword.setForeground(new java.awt.Color(255, 255, 255));
        lbl_konfirmasipassword.setText("Konfirmasi Password");
        getContentPane().add(lbl_konfirmasipassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 360, -1, -1));

        txt_password.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 300, 300, 40));

        btn_cancel.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_cancel.setText("CANCEL");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 520, 300, 40));

        btn_forgot.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_forgot.setText("FORGOT");
        btn_forgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_forgotActionPerformed(evt);
            }
        });
        getContentPane().add(btn_forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 460, 300, 40));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Fornend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void chk_showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_showpasswordActionPerformed
        /// Mengatur karakter echo pada field password
if (chk_showpassword.isSelected()) {
    txt_password.setEchoChar((char)0); // Menghilangkan karakter echo
} else {
    txt_password.setEchoChar('*'); // Mengganti karakter echo dengan tanda bintang
}

// Mengatur karakter echo pada field konfirmasi password
if (chk_showpassword.isSelected()) {
    txt_konfirmasipassword.setEchoChar((char)0); // Menghilangkan karakter echo
} else {
    txt_konfirmasipassword.setEchoChar('*'); // Mengganti karakter echo dengan tanda bintang
}
    }//GEN-LAST:event_chk_showpasswordActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.setVisible(false);
        new Login().setVisible(true);            
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_forgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_forgotActionPerformed
        try {
    String email = txt_email.getText();
    String newPassword = new String(txt_password.getPassword());
    String confirmPassword = new String(txt_konfirmasipassword.getPassword());

    // Cek apakah email sudah diisi
    if (email.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Email Harus Diisi");
        return;
    }
    
    // Cek apakah password sudah diisi
    if (newPassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Password harus diisi");
        return;
    }
    
    // Cek apakah konfirmasi password sudah diisi
    if (confirmPassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Konfirmasi Password harus diisi");
        return;
    }
    
    // Validasi panjang dan karakter password
    if (newPassword.length() < 5 || newPassword.length() > 15) {
        JOptionPane.showMessageDialog(null, "Password Harus Diisi Dengan Panjang Minimal 5 karakter Dan Maksimal 15 Karakter");
        return;
    }
    
    // Mengandung huruf besar, huruf kecil, angka, dan simbol
    Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$");
    Matcher matcher = pattern.matcher(newPassword);
    if (!matcher.matches()) {
        JOptionPane.showMessageDialog(null, "Password harus mengandung huruf besar, huruf kecil, angka, dan simbol");
        return;
    }
    
    // Tidak mengandung informasi pribadi
    if (newPassword.contains("username") || newPassword.contains("Telepon")) {
        JOptionPane.showMessageDialog(null, "Password tidak boleh mengandung informasi pribadi");
        return;
    }
    
    // Tidak menggunakan kata-kata umum
    String[] commonPasswords = {"password", "123456", "qwerty", "abc123"};
    for (String commonPassword : commonPasswords) {
        if (newPassword.equalsIgnoreCase(commonPassword)) {
            JOptionPane.showMessageDialog(null, "Password tidak boleh menggunakan kata-kata umum");
            return;
        }
    }
    
    // Cek kesesuaian password dengan konfirmasi password
    if (!confirmPassword.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(null, "Konfirmasi Password Tidak Sesuai");
        return;
    }
    
    // Validasi tidak ada spasi dalam password
    if (newPassword.contains(" ")) {
        JOptionPane.showMessageDialog(null, "Password Tidak boleh Mengandung Spasi");
        return;
    }

    Connection conn = null;
    try {
        conn = (Connection)Config.configDB();
    } catch (SQLException ex) {
        Logger.getLogger(Forgot.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    // Cek apakah password sudah digunakan
    String checkPassSql = "SELECT COUNT(*) FROM akun WHERE password = ?";
    PreparedStatement checkPassPst = conn.prepareStatement(checkPassSql);
    checkPassPst.setString(1, newPassword);
    ResultSet checkPassRs = checkPassPst.executeQuery();
    if (checkPassRs.next() && checkPassRs.getInt(1) > 0) {
        JOptionPane.showMessageDialog(null, "Password Sudah Digunakan");
        return;
    }
    
    // Cek apakah username dan email ada di database
    String checkUserEmailSql = "SELECT COUNT(*) FROM akun WHERE gmail = ?";
    PreparedStatement checkUserEmailPst = conn.prepareStatement(checkUserEmailSql);
    checkUserEmailPst.setString(1, email);
    ResultSet checkUserEmailRs = checkUserEmailPst.executeQuery();
    if (checkUserEmailRs.next() && checkUserEmailRs.getInt(1) > 0) {
        // jika ya, update password di database
        String updateSql = "UPDATE akun SET password = ? , gmail = ?";
        PreparedStatement updatePst = conn.prepareStatement(updateSql);
        updatePst.setString(1, newPassword);
        updatePst.setString(2, email);
        updatePst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Password Berhasil Direset. Silakan Login Dengan Password Baru Anda.");
        
        // tutup form reset password dan buka form login
        this.setVisible(false);
        new Login().setVisible(true);
    } else {
        // jika tidak, tampilkan pesan error
        JOptionPane.showMessageDialog(null, "Email Tidak Ditemukan. Silakan Cek Kembali Dan Email Yang Benar.");
    }
} catch (SQLException ex) {
    Logger.getLogger(Forgot.class.getName()).log(Level.SEVERE, null, ex);
}
    }//GEN-LAST:event_btn_forgotActionPerformed

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
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forgot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forgot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_forgot;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_forgot;
    private javax.swing.JCheckBox chk_showpassword;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_konfirmasipassword;
    private javax.swing.JLabel lbl_lokasi;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JFormattedTextField txt_email;
    private javax.swing.JPasswordField txt_konfirmasipassword;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
