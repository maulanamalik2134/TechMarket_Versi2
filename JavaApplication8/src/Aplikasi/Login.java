package Aplikasi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Login extends javax.swing.JFrame {
    int failedAttempts = 0;
    boolean isBlocked = false;

    public Login() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");
    }
    
    public void login() {
    System.out.println("Metode login dipanggil");
    
    if (isBlocked) {
        JOptionPane.showMessageDialog(null, "Anda Sedang Diblokir. Silakan Tunggu Sebentar Sebelum Mencoba Lagi.");
        return;
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_username = new javax.swing.JLabel();
        lbl_apakahsudahpunyaakun = new javax.swing.JLabel();
        lbl_login = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        txt_password = new javax.swing.JPasswordField();
        chk_showpassword = new javax.swing.JCheckBox();
        btn_register = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        btn_forgotpassword = new javax.swing.JButton();
        lbl_password = new javax.swing.JLabel();
        lbl_body = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_username.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_username.setText("Username");
        getContentPane().add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, -1, -1));

        lbl_apakahsudahpunyaakun.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_apakahsudahpunyaakun.setForeground(new java.awt.Color(255, 255, 255));
        lbl_apakahsudahpunyaakun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_apakahsudahpunyaakun.setText("Apakah Sudah Punya Akun?");
        getContentPane().add(lbl_apakahsudahpunyaakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 450, 160, -1));

        lbl_login.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_login.setForeground(new java.awt.Color(255, 255, 255));
        lbl_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_login.setText("LOGIN");
        getContentPane().add(lbl_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 150, 400, -1));

        txt_username.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 240, 240, -1));

        txt_password.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 310, 240, -1));

        chk_showpassword.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        chk_showpassword.setForeground(new java.awt.Color(255, 255, 255));
        chk_showpassword.setText("Show Password");
        chk_showpassword.setContentAreaFilled(false);
        chk_showpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_showpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(chk_showpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 350, -1, -1));

        btn_register.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btn_register.setForeground(new java.awt.Color(255, 255, 255));
        btn_register.setText("Register");
        btn_register.setBorderPainted(false);
        btn_register.setContentAreaFilled(false);
        btn_register.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 440, 220, 40));

        btn_login.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_login.setText("LOGIN");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 390, 240, -1));

        btn_forgotpassword.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btn_forgotpassword.setForeground(new java.awt.Color(255, 255, 255));
        btn_forgotpassword.setText("Forgot Password?");
        btn_forgotpassword.setBorderPainted(false);
        btn_forgotpassword.setContentAreaFilled(false);
        getContentPane().add(btn_forgotpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 350, -1, -1));

        lbl_password.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_password.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_password.setText("Password");
        getContentPane().add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 290, 60, -1));

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
    }//GEN-LAST:event_chk_showpasswordActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
    try {
    // Ambil input username dan password dari pengguna
    String username = txt_username.getText();
    String password = new String(txt_password.getPassword());

    // Lakukan validasi input
    if (username.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username Harus Diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    if (password.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Password Harus Diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Lakukan koneksi ke database
    java.sql.Connection conn = (Connection) Config.configDB();

    // Buat query untuk memeriksa username dan password yang cocok
    String checkUserPassSql = "SELECT * FROM akun WHERE username = ? AND password = ?";
    java.sql.PreparedStatement checkUserPassPst = conn.prepareStatement(checkUserPassSql);
    checkUserPassPst.setString(1, username);
    checkUserPassPst.setString(2, password);
    java.sql.ResultSet checkUserPassRs = checkUserPassPst.executeQuery();

    int maxAttempts = 15; // Jumlah maksimum percobaan
    int delayMinutes = 0; // Waktu penundaan awal (menit)
    int delaySeconds = 0; // Waktu penundaan awal (detik)
    int currentAttempt = 0; // Jumlah percobaan saat ini

    if (!checkUserPassRs.next()) {
        // Username atau password tidak cocok, tampilkan pesan error
        failedAttempts++;
        currentAttempt = failedAttempts;
        if (currentAttempt == 3) {
            delaySeconds = 30; // Blokir selama 30 detik setelah 3 percobaan gagal
        } else if (currentAttempt == 5) {
            delayMinutes = 1; // Blokir selama 1 menit setelah 5 percobaan gagal
        } else if (currentAttempt == 10) {
            delayMinutes = 2; // Blokir selama 2 menit setelah 10 percobaan gagal
        } else if (currentAttempt == 15) {
            delayMinutes = 60; // Blokir selama 60 menit (1 jam) setelah 15 percobaan gagal
        }

        if (currentAttempt >= maxAttempts) {
            JOptionPane.showMessageDialog(null, "Akun Anda Telah Diblokir Selama 1 Jam. Silakan Coba Lagi Nanti.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (delayMinutes > 0 || delaySeconds > 0) {
            int totalDelayInSeconds = delayMinutes * 60 + delaySeconds;
            JOptionPane.showMessageDialog(null, "Anda Telah Gagal Login Sebanyak " + currentAttempt + " Kali. Akun Anda Akan Diblokir Selama " + delayMinutes + " Menit " + delaySeconds + " Detik.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            // Blokir akun selama waktu yang ditentukan
            isBlocked = true;

            // Membuat timer yang akan memperbarui peringatan setiap detik
            Timer timer = new Timer(1000, new ActionListener() {
                int remainingSeconds = totalDelayInSeconds;

                public void actionPerformed(ActionEvent e) {
                    if (remainingSeconds > 0) {
                        int minutes = remainingSeconds / 60;
                        int seconds = remainingSeconds % 60;
                        JOptionPane.showMessageDialog(null, "Akun Anda Masih Diblokir Selama " + minutes + " Menit " + seconds + " Detik.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                        remainingSeconds--;
                    } else {
                        // Setelah waktu penundaan berakhir, izinkan pengguna mencoba login lagi
                        isBlocked = false;
                        failedAttempts = 0;
                        JOptionPane.showMessageDialog(null, "Blokir Akun Telah Berakhir. Anda Bisa Mencoba Login Lagi.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                        // Aktifkan tombol setelah timer berakhir
                        btn_login.setEnabled(true);
                        ((Timer) e.getSource()).stop();
                    }
                }
            });
            timer.setInitialDelay(0); // Memulai timer segera setelah dimulai
            timer.start();
            // Nonaktifkan tombol saat timer dimulai
            btn_login.setEnabled(false);
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Username, Password ", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        // Jika login berhasil, reset jumlah percobaan dan aktifkan tombol
        failedAttempts = 0;
        currentAttempt = 0;
        btn_login.setEnabled(true);

        // Periksa peran pengguna berdasarkan username
        String role = checkUserPassRs.getString("role");
        if (role.equals("Admin")) {
            JOptionPane.showMessageDialog(null, "Username " + username + " Berhasil Login Sebagai Admin", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            // Buka halaman dashboard admin
            new Dashboard().setVisible(true);
        } else if (role.equals("Kasir")) {
            JOptionPane.showMessageDialog(null, "Username " + username + " Berhasil Login Sebagai Kasir", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            // Buka halaman transaksi penjualan
            new Transaksi_penjualan().setVisible(true);
        } else if (role.equals("Karyawan")) {
            JOptionPane.showMessageDialog(null, "Username " + username + " Berhasil Login Sebagai Karyawan", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            // Buka halaman opname
            new Opname().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Role Tidak Valid", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Tutup halaman login
        this.dispose();
    }
} catch (SQLException e) {
    // Tangani kesalahan koneksi atau eksekusi SQL
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Terjadi Kesalahan: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        this.dispose();
        new Register().setVisible(true);
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_forgotpassword;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JCheckBox chk_showpassword;
    private javax.swing.JLabel lbl_apakahsudahpunyaakun;
    private javax.swing.JLabel lbl_body;
    private javax.swing.JLabel lbl_login;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
