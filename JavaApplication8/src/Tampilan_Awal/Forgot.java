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
private DefaultTableModel model;

public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
    String formattedDateTime = dateTime.format(formatter);
    lbl_tanggal.setText(formattedDateTime);
    String lokasiToko = "Jl. Raya Situbondo, Blk. Gardu, Cindogo, Tapen, Kabupaten Bondowoso, Jawa Timur 68282";
    lbl_lokasi.setText(lokasiToko);
}

public void setTanggalDanWaktu() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", new Locale("id", "ID"));
    String formattedDate = dateTime.format(formatter);
    txt_tanggalmasuk.setText(formattedDate);
}

public Forgot() {
    initComponents();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            setTanggalDanWaktuSekarang();
        }
    }, 0, 1, TimeUnit.SECONDS);

    setTanggalDanWaktuSekarang();
    setTanggalDanWaktu();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_lokasi = new javax.swing.JLabel();
        lbl_tanggal = new javax.swing.JLabel();
        Lbl_forgot = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        txt_konfirmasipassword = new javax.swing.JPasswordField();
        chk_showpassword = new javax.swing.JCheckBox();
        lbl_password = new javax.swing.JLabel();
        lbl_konfirmasipassword = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        btn_cancel = new javax.swing.JButton();
        btn_forgot = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        txt_tanggalmasuk = new javax.swing.JFormattedTextField();

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

        Username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        Username.setForeground(new java.awt.Color(255, 255, 255));
        Username.setText("Username");
        getContentPane().add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 200, -1, -1));

        txt_username.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 300, 40));

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
        btn_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 520, 300, 40));

        btn_forgot.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_forgot.setText("FORGOT");
        btn_forgot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_forgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_forgotActionPerformed(evt);
            }
        });
        getContentPane().add(btn_forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 460, 300, 40));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Fornend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        txt_tanggalmasuk.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_tanggalmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tanggalmasukActionPerformed(evt);
            }
        });
        getContentPane().add(txt_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 300, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void chk_showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_showpasswordActionPerformed
if (chk_showpassword.isSelected()) {
    txt_password.setEchoChar((char)0);
} else {
    txt_password.setEchoChar('*');
}

if (chk_showpassword.isSelected()) {
    txt_konfirmasipassword.setEchoChar((char)0);
} else {
    txt_konfirmasipassword.setEchoChar('*');
}
    }//GEN-LAST:event_chk_showpasswordActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.setVisible(false);
        new Login().setVisible(true);            
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_forgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_forgotActionPerformed
        try {
    String newpassword = new String(txt_password.getPassword());
    String username = new String(txt_username.getText());
    String confirmpassword = new String(txt_konfirmasipassword.getPassword());

    if (username.isEmpty() && newpassword.isEmpty() && confirmpassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username, Password, dan Konfirmasi Password harus diisi");
        return;
    } else if (username.isEmpty() && newpassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username dan Password harus diisi");
        return;
    } else if (username.isEmpty() && confirmpassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username dan Konfirmasi Password harus diisi");
        return;
    } else if (newpassword.isEmpty() && confirmpassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Password dan Konfirmasi Password harus diisi");
        return;
    } else if (username.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    } else if (newpassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Password harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    } else if (confirmpassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Konfirmasi harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (newpassword.length() < 5 || newpassword.length() > 15 || newpassword.contains(" ") || !newpassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$")) {
        JOptionPane.showMessageDialog(null, "Password harus diisi dengan panjang minimal 5 karakter dan maksimal 15 karakter, serta harus mengandung huruf besar, huruf kecil, angka, dan simbol");
        return;
    } else if (!newpassword.equals(confirmpassword)) {
        JOptionPane.showMessageDialog(null, "Konfirmasi Password Tidak Sesuai");
        return;
    } 

    Connection conn = null;
    try {
        conn = Config.configDB();
    } catch (SQLException ex) {
        Logger.getLogger(Forgot.class.getName()).log(Level.SEVERE, null, ex);
    }

    String checkUserSql = "SELECT COUNT(*) FROM akun WHERE username = ?";
    PreparedStatement checkUserPst = conn.prepareStatement(checkUserSql);
    checkUserPst.setString(1, username);
    ResultSet checkUserRs = checkUserPst.executeQuery();
    if (!checkUserRs.next() || checkUserRs.getInt(1) == 0) {
        JOptionPane.showMessageDialog(null, "Username Tidak Ditemukan. Silakan Cek Kembali Username Anda.");
        return;
    }

    String checkPassSql = "SELECT COUNT(*) FROM akun WHERE password = ?";
    PreparedStatement checkPassPst = conn.prepareStatement(checkPassSql);
    checkPassPst.setString(1, newpassword);
    ResultSet checkPassRs = checkPassPst.executeQuery();
    if (checkPassRs.next() && checkPassRs.getInt(1) > 0) {
        JOptionPane.showMessageDialog(null, "Password Sudah Digunakan");
        return;
    }

    String updateSql = "UPDATE akun SET password = ? WHERE username = ?";
    PreparedStatement updatePst = conn.prepareStatement(updateSql);
    updatePst.setString(1, newpassword);
    updatePst.setString(2, username);
    updatePst.executeUpdate();

    JOptionPane.showMessageDialog(null, "Password Berhasil Direset. Silakan Login Dengan Password Baru Anda.\nPassword Baru: " + newpassword);

    this.setVisible(false);
    new Login().setVisible(true);
} catch (SQLException ex) {
    Logger.getLogger(Forgot.class.getName()).log(Level.SEVERE, null, ex);
}
    }//GEN-LAST:event_btn_forgotActionPerformed

    private void txt_tanggalmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tanggalmasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tanggalmasukActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forgot().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_forgot;
    private javax.swing.JLabel Username;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_forgot;
    private javax.swing.JCheckBox chk_showpassword;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_konfirmasipassword;
    private javax.swing.JLabel lbl_lokasi;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JPasswordField txt_konfirmasipassword;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JFormattedTextField txt_tanggalmasuk;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
