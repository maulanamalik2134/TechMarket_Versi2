package Aplikasi;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Register extends javax.swing.JFrame {
    int failedAttempts = 0;
    boolean isBlocked = false;

    public Register() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");
        try {
    String sql = "SELECT * FROM akun ORDER BY Id_akun DESC LIMIT 1";
    java.sql.Connection conn = (Connection) Aplikasi.Config.configDB();
    java.sql.Statement stm = conn.createStatement();
    java.sql.ResultSet res = stm.executeQuery(sql);
    if (res.next()) {
        String idakun = "" + (res.getInt("Id_akun") + 1);
        txt_idakun.setText(idakun);
    } else {
        txt_idakun.setText("1");
    }
} catch (Exception e) {
    e.printStackTrace();
}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_username = new javax.swing.JLabel();
        lbl_register = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        txt_password = new javax.swing.JPasswordField();
        chk_showpassword = new javax.swing.JCheckBox();
        btn_kembali = new javax.swing.JButton();
        lbl_konfirmasipassword = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        lbl_idakun = new javax.swing.JLabel();
        txt_idakun = new javax.swing.JFormattedTextField();
        btn_register = new javax.swing.JButton();
        txt_konfirmasipassword = new javax.swing.JPasswordField();
        cmb_role = new javax.swing.JComboBox<>();
        lbl_body = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_username.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_username.setText("Username");
        getContentPane().add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 290, -1, -1));

        lbl_register.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_register.setForeground(new java.awt.Color(255, 255, 255));
        lbl_register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_register.setText("REGISTER");
        getContentPane().add(lbl_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 150, 410, -1));

        txt_username.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 310, 240, -1));

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
        lbl_idakun.setText("Id Akun");
        getContentPane().add(lbl_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, -1, -1));

        txt_idakun.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 240, 240, -1));

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
    int id_akun = Integer.parseInt(txt_idakun.getText());
    String username = txt_username.getText();
    String password = new String(txt_password.getPassword());
    String konfirmasi = new String(txt_password.getPassword());
    String role = cmb_role.getSelectedItem().toString();
    Connection conn = Config.configDB();

    // Cek apakah username sudah ada di database
    if (username.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username Harus Diisi");
        return;
    }
    
    String checkUserSql = "SELECT COUNT(*) FROM akun WHERE username = ?";
    PreparedStatement checkUserPst = conn.prepareStatement(checkUserSql);
    checkUserPst.setString(1, username);
    ResultSet checkUserRs = checkUserPst.executeQuery();
    if (checkUserRs.next() && checkUserRs.getInt(1) > 0) {
        JOptionPane.showMessageDialog(null, "Username Sudah Ada");
        return;
    }

    // Cek apakah password sudah digunakan
    if (password.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Password Harus Diisi");
        return;
    }
    
    String checkPassSql = "SELECT COUNT(*) FROM akun WHERE password = ?";
    PreparedStatement checkPassPst = conn.prepareStatement(checkPassSql);
    checkPassPst.setString(1, password);
    ResultSet checkPassRs = checkPassPst.executeQuery();
    if (checkPassRs.next() && checkPassRs.getInt(1) > 0) {
        JOptionPane.showMessageDialog(null, "Password Sudah Digunakan");
        return;
    }

    // Validasi panjang dan karakter username
    if (username.length() < 5 || username.length() > 15) {
        JOptionPane.showMessageDialog(null, "Username Harus Diisi Dengan Panjang Minimal 5 Karakter Dan Maksimal 15 Karakter");
        return;
    }
    
    if (username.contains(" ")) {
        JOptionPane.showMessageDialog(null, "Username Tidak Boleh Mengandung Spasi");
        return;
    }
    
    // Validasi karakter username
    if (!username.matches("^[a-zA-Z0-9_-]+$")) {
        JOptionPane.showMessageDialog(null, "Username Hanya Boleh Mengandung Huruf, Angka, Garis Bawah (_), Dan Tanda Hubung (-)");
        return;
    }
    
    // Validasi awalan karakter username
    if (!username.matches("^[a-zA-Z].*[^_-]$")) {
        JOptionPane.showMessageDialog(null, "Username Harus Dimulai Dengan Huruf Dan Tidak Boleh Diakhiri Dengan Garis Bawah (_) Atau Tanda Hubung (-)");
        return;
    }
    
    // Validasi panjang dan karakter password
    if (password.length() < 5 || password.length() > 15) {
        JOptionPane.showMessageDialog(null, "Password Harus Diisi Dengan Panjang Minimal 5 karakter Dan Maksimal 15 Karakter");
        return;
    }
    
    // Validasi tidak ada spasi dalam password
    if (password.contains(" ")) {
        JOptionPane.showMessageDialog(null, "Password Tidak Boleh Mengandung Spasi");
        return;
    }
    
    // Validasi kekuatan password
    if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$")) {
        JOptionPane.showMessageDialog(null, "Password Harus sulit Ditebak. Gunakan Kombinasi Huruf Besar, Huruf Kecil, Angka, Dan Simbol");
        return;
    }
    
    // Cek kesesuaian password dengan konfirmasi password
    if (!password.equals(konfirmasi)) {
        JOptionPane.showMessageDialog(null, "Konfirmasi Password Tidak Sesuai");
        return;
    }

    // Validasi jumlah akun admin
    if (role.equals("Admin")) {
        String checkSql = "SELECT COUNT(*) FROM akun WHERE role = 'Admin'";
        PreparedStatement checkPst = conn.prepareStatement(checkSql);
        ResultSet checkRs = checkPst.executeQuery();
        if (checkRs.next() && checkRs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(null, "Hanya Bisa Ada Satu Admin");
            return;
        }
    }

    String sql = "INSERT INTO akun (id_akun, username, password, role) VALUES (?, ?, ?, ?)";
    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setInt(1, id_akun);
    pst.setString(2, username);
    pst.setString(3, password);
    pst.setString(4, role);
    pst.executeUpdate();

    // Tampilkan pesan sukses dengan username
    String successMessage;
    if (role.equals("Admin")) {
        successMessage = "Akun Berhasil Dibuat, Kamu Sekarang Adalah Admin!";
    } else if (role.equals("Kasir")) {
        successMessage = "Akun Berhasil Dibuat, Kamu Sekarang Adalah Kasir!";
    } else {
        successMessage = "Akun Berhasil Dibuat, Kamu Sekarang Adalah Karyawan!";
    }
    successMessage += "\nUsername: " + username;
    JOptionPane.showMessageDialog(null, successMessage);

    // Tutup form saat akun berhasil dibuat
    // Ganti "this" dengan objek form yang sesuai
    this.dispose();
    new Login().setVisible(true);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan SQL: " + e.getMessage());
} catch (HeadlessException | NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
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
    private javax.swing.JFormattedTextField txt_idakun;
    private javax.swing.JPasswordField txt_konfirmasipassword;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
