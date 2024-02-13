package Aplikasi;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ForgotPassword extends javax.swing.JFrame {

    public ForgotPassword() {
            initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_username = new javax.swing.JLabel();
        lbl_register = new javax.swing.JLabel();
        txt_gmail = new javax.swing.JFormattedTextField();
        txt_password = new javax.swing.JPasswordField();
        chk_showpassword = new javax.swing.JCheckBox();
        btn_kembali = new javax.swing.JButton();
        lbl_konfirmasipassword = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        lbl_idakun = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        btn_register = new javax.swing.JButton();
        txt_konfirmasipassword = new javax.swing.JPasswordField();
        cmb_role = new javax.swing.JComboBox<>();
        lbl_body = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_username.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_username.setText("Gmail");
        getContentPane().add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 290, -1, -1));

        lbl_register.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_register.setForeground(new java.awt.Color(255, 255, 255));
        lbl_register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_register.setText("FORGOT");
        getContentPane().add(lbl_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 150, 410, -1));

        txt_gmail.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(txt_gmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 310, 240, -1));

        txt_password.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 380, 240, -1));

        chk_showpassword.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        chk_showpassword.setForeground(new java.awt.Color(255, 255, 255));
        chk_showpassword.setText("Show Password");
        chk_showpassword.setContentAreaFilled(false);
        chk_showpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_showpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(chk_showpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 490, -1, -1));

        btn_kembali.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_kembali.setForeground(new java.awt.Color(255, 255, 255));
        btn_kembali.setText("KEMBALI");
        btn_kembali.setContentAreaFilled(false);
        btn_kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btn_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 10, 150, 30));

        lbl_konfirmasipassword.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_konfirmasipassword.setForeground(new java.awt.Color(255, 255, 255));
        lbl_konfirmasipassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_konfirmasipassword.setText("Konfirmasi Password");
        getContentPane().add(lbl_konfirmasipassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 430, -1, -1));

        lbl_password.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_password.setText("Password");
        getContentPane().add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 360, -1, -1));

        lbl_idakun.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_idakun.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idakun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_idakun.setText("Username");
        getContentPane().add(lbl_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, -1, -1));

        txt_username.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 240, 240, -1));

        btn_register.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_register.setText("REGISTER");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 580, 240, -1));

        txt_konfirmasipassword.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(txt_konfirmasipassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 450, 240, -1));

        cmb_role.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmb_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Kasir", "Karyawan" }));
        getContentPane().add(cmb_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 520, 240, 30));

        lbl_body.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Masuk.png"))); // NOI18N
        getContentPane().add(lbl_body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chk_showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_showpasswordActionPerformed
        if (chk_showpassword.isSelected()){
        txt_password.setEchoChar((char)0);
    }
    else {
        txt_password.setEchoChar(('*'));
    }
        if (chk_showpassword.isSelected()){
        txt_konfirmasipassword.setEchoChar((char)0);
    }
    else {
        txt_konfirmasipassword.setEchoChar(('*'));
        }
    }//GEN-LAST:event_chk_showpasswordActionPerformed

    private void btn_kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembaliActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btn_kembaliActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        try {                                           
            String email = txt_gmail.getText();
            String newPassword = new String(txt_password.getPassword());
            String confirmPassword = new String(txt_konfirmasipassword.getPassword());

            // Cek apakah password sudah digunakan
    if (email.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Email Harus Diisi");
        return;
    }
    
    // Cek apakah password sudah digunakan
    if (newPassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Password harus diisi");
        return;
    }
    // Cek apakah password sudah digunakan
    if (confirmPassword.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Konfirmasi Password harus diisi");
        return;
    }
    
        // Validasi panjang dan karakter password
    if (newPassword.length() < 5 || newPassword.length() > 15) {
        JOptionPane.showMessageDialog(null, "Password Harus Diisi Dengan Panjang Minimal 5 Karakter Dan Maksimal 15 Karakter");
        return;
    }
    
    // Validasi tidak ada spasi dalam password
    if (newPassword.contains(" ")) {
        JOptionPane.showMessageDialog(null, "Password Tidak boleh Mengandung Spasi");
        return;
    }
    
    // Validasi kekuatan password
    if (!newPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
        JOptionPane.showMessageDialog(null, "Password Harus Sulit Ditebak. Gunakan Kombinasi Huruf Besar, Huruf Kecil, Angka, Dan Simbol");
        return;
    }
    
    // Cek kesesuaian password dengan konfirmasi password
    if (!confirmPassword.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(null, "Konfirmasi Password Tidak Sesuai");
        return;
    }

        java.sql.Connection conn = null;
            try {
                conn = (Connection)Config.configDB();
            } catch (SQLException ex) {
                Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
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
            // cek apakah username dan email ada di database
    String checkUserEmailSql = "SELECT COUNT(*) FROM akun WHERE email = ?";
    java.sql.PreparedStatement checkUserEmailPst = conn.prepareStatement(checkUserEmailSql);
    checkUserEmailPst.setString(1, email);
    java.sql.ResultSet checkUserEmailRs = checkUserEmailPst.executeQuery();
    if (checkUserEmailRs.next() && checkUserEmailRs.getInt(1) > 0) {
        // jika ya, update password di database
                String updateSql = "UPDATE akun SET password = ? , email = ?";
        java.sql.PreparedStatement updatePst = conn.prepareStatement(updateSql);
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
            Logger.getLogger(ForgotPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_registerActionPerformed

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
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForgotPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForgotPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kembali;
    private javax.swing.JButton btn_register;
    private javax.swing.JCheckBox chk_showpassword;
    private javax.swing.JComboBox<String> cmb_role;
    private javax.swing.JLabel lbl_body;
    private javax.swing.JLabel lbl_idakun;
    private javax.swing.JLabel lbl_konfirmasipassword;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_register;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JFormattedTextField txt_gmail;
    private javax.swing.JPasswordField txt_konfirmasipassword;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
