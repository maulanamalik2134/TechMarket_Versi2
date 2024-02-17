package Tampilan_Awal;

import Config.Config;
import java.awt.HeadlessException;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SignUp extends javax.swing.JFrame {
    
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

public SignUp() {
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

    try {
        // Mengambil data akun terakhir dari database
        String sql = "SELECT * FROM akun ORDER BY Id_akun DESC LIMIT 1";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);

        // Mengatur nilai id akun pada field inputan
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

        lbl_lokasi = new javax.swing.JLabel();
        lbl_tanggal = new javax.swing.JLabel();
        Lbl_register = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        lbl_konfirmasipassword = new javax.swing.JLabel();
        txt_konfirmasipassword = new javax.swing.JPasswordField();
        chk_showpassword = new javax.swing.JCheckBox();
        btn_register = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        lbl_username = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        cmb_role = new javax.swing.JComboBox<>();
        lbl_image = new javax.swing.JLabel();
        txt_idakun = new javax.swing.JFormattedTextField();

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

        Lbl_register.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36)); // NOI18N
        Lbl_register.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_register.setText("REGISTER");
        getContentPane().add(Lbl_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 130, 400, -1));

        lbl_email.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_email.setText("Email");
        getContentPane().add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, -1));

        lbl_password.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_password.setText("Password");
        getContentPane().add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 280, -1, -1));

        txt_password.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 300, 300, 40));

        lbl_konfirmasipassword.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_konfirmasipassword.setForeground(new java.awt.Color(255, 255, 255));
        lbl_konfirmasipassword.setText("Konfirmasi Password");
        getContentPane().add(lbl_konfirmasipassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 360, -1, -1));

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
        getContentPane().add(chk_showpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 430, -1, -1));

        btn_register.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_register.setText("REGISTER");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 520, 300, 40));

        btn_cancel.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_cancel.setText("CANCEL");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 580, 300, 40));

        lbl_username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setText("Username");
        getContentPane().add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 200, -1, -1));

        txt_username.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 300, 40));

        cmb_role.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        cmb_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Kasir" }));
        getContentPane().add(cmb_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 460, 300, 40));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Fornend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        txt_idakun.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_idakun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idakunActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 300, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idakunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idakunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idakunActionPerformed

    private void chk_showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_showpasswordActionPerformed
        // Mengatur karakter echo pada field password
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

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        try {
    // Mendapatkan nilai dari inputan form
    int id_akun = Integer.parseInt(txt_idakun.getText());
    String username = txt_username.getText();
    String password = new String(txt_password.getPassword());
    String konfirmasi = new String(txt_konfirmasipassword.getPassword());
    String role = cmb_role.getSelectedItem().toString();

    // Membuat koneksi ke database
    Connection conn = Config.configDB();

    // Mengecek apakah username sudah ada
    String checkUserSql = "SELECT COUNT(*) FROM akun WHERE username = ?";
    PreparedStatement checkUserPst = conn.prepareStatement(checkUserSql);
    checkUserPst.setString(1, username);
    ResultSet checkUserRs = checkUserPst.executeQuery();
    if (checkUserRs.next() && checkUserRs.getInt(1) > 0) {
        JOptionPane.showMessageDialog(null, "Username Sudah Ada");
        return;
    }

    // Mengecek apakah password sudah digunakan sebelumnya
    String checkPassSql = "SELECT COUNT(*) FROM akun WHERE password = ?";
    PreparedStatement checkPassPst = conn.prepareStatement(checkPassSql);
    checkPassPst.setString(1, password);
    ResultSet checkPassRs = checkPassPst.executeQuery();
    if (checkPassRs.next() && checkPassRs.getInt(1) > 0) {
        JOptionPane.showMessageDialog(null, "Password Sudah Digunakan");
        return;
    }

    // Validasi inputan form
    if (username.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username harus diisi");
        return;
    }

    if (password.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Password harus diisi");
        return;
    }

    if (konfirmasi.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Konfirmasi Password harus diisi");
        return;
    }

    if (username.length() < 5 || username.length() > 15) {
        JOptionPane.showMessageDialog(null, "Username Harus Diisi Dengan Panjang Minimal 5 karakter Dan Maksimal 15 Karakter");
        return;
    }

    if (username.contains(" ")) {
        JOptionPane.showMessageDialog(null, "Username Tidak boleh Mengandung Spasi");
        return;
    }

    Pattern usernamePattern = Pattern.compile("^[a-zA-Z0-9_-]+$");
    Matcher usernameMatcher = usernamePattern.matcher(username);
    if (!usernameMatcher.matches()) {
        JOptionPane.showMessageDialog(null, "Username hanya boleh menggunakan huruf (A-Z), angka (0-9), tanda hubung (-), atau garis bawah (_)");
        return;
    }

    if (password.length() < 5 || password.length() > 15) {
        JOptionPane.showMessageDialog(null, "Password Harus Diisi Dengan Panjang Minimal 5 karakter Dan Maksimal 15 Karakter");
        return;
    }

    if (password.contains(" ")) {
        JOptionPane.showMessageDialog(null, "Password Tidak boleh Mengandung Spasi");
        return;
    }

    Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$");
    Matcher passwordMatcher = passwordPattern.matcher(password);
    if (!passwordMatcher.matches()) {
        JOptionPane.showMessageDialog(null, "Password harus mengandung huruf besar, huruf kecil, angka, dan simbol");
        return;
    }

    if (password.contains("username") || password.contains("Telepon")) {
        JOptionPane.showMessageDialog(null, "Password tidak boleh mengandung informasi pribadi");
        return;
    }

    String[] commonPasswords = {"password", "123456", "qwerty", "abc123"};
    for (String commonPassword : commonPasswords) {
        if (password.equalsIgnoreCase(commonPassword)) {
            JOptionPane.showMessageDialog(null, "Password tidak boleh menggunakan kata-kata umum");
            return;
        }
    }

    if (!password.equals(konfirmasi)) {
        JOptionPane.showMessageDialog(null, "Konfirmasi Password Tidak Sesuai");
        return;
    }

    if (role.equals("Admin")) {
        String checkSql = "SELECT COUNT(*) FROM akun WHERE role = 'Admin'";
        PreparedStatement checkPst = conn.prepareStatement(checkSql);
        ResultSet checkRs = checkPst.executeQuery();
        if (checkRs.next() && checkRs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(null, "Hanya Bisa Ada Satu Admin");
            return;
        }
        if (checkRs.next() && checkRs.getInt(1) >= 8) {
            JOptionPane.showMessageDialog(null, "Hanya Bisa Ada Delapan Akun Kasir");
            return;
        }
    }

    // Menyimpan akun baru ke database
    String sql = "INSERT INTO akun (id_akun, username, password, role) VALUES (?, ?, ?, ?)";
    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setInt(1, id_akun);
    pst.setString(2, username);
    pst.setString(3, password);
    pst.setString(4, role);
    pst.executeUpdate();

    // Menampilkan pesan sukses dengan username
    String successMessage = "Akun Berhasil Dibuat!\nUsername: " + username;
    JOptionPane.showMessageDialog(null, successMessage);

    // Menutup form saat akun berhasil dibuat
    // Ganti "this" dengan objek form yang sesuai
    this.dispose();
    new Login().setVisible(true);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan SQL: " + e.getMessage());
} catch (HeadlessException | NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
}
    }//GEN-LAST:event_btn_registerActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

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
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_register;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_register;
    private javax.swing.JCheckBox chk_showpassword;
    private javax.swing.JComboBox<String> cmb_role;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_konfirmasipassword;
    private javax.swing.JLabel lbl_lokasi;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JFormattedTextField txt_idakun;
    private javax.swing.JPasswordField txt_konfirmasipassword;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}