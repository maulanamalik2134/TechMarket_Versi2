package Tampilan_Awal;

import Config.Config;
import Tampilan_Admin.Dashboard;
import Tampilan_Kasir.Menu_Transaks_Kasir;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Login extends javax.swing.JFrame {
    
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

int failedAttempts = 0; // Jumlah percobaan login yang gagal
boolean isBlocked = false; // Status blokir akun

public Login() {
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

/**
 * Metode untuk melakukan proses login.
 */
public void login() {
    System.out.println("Metode login dipanggil");
    
    // Memeriksa apakah akun sedang dalam status diblokir
    if (isBlocked) {
        JOptionPane.showMessageDialog(null, "Anda Sedang Diblokir. Silakan Tunggu Sebentar Sebelum Mencoba Lagi.");
        return;
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lbl_login = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        txt_password = new javax.swing.JPasswordField();
        lbl_password = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        chk_showpassword = new javax.swing.JCheckBox();
        Btn_absen = new javax.swing.JButton();
        btn_forgot = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        btn_register = new javax.swing.JButton();
        lbl_tanggal = new javax.swing.JLabel();
        lbl_lokasi = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Lbl_login.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36)); // NOI18N
        Lbl_login.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_login.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_login.setText("LOGIN ");
        getContentPane().add(Lbl_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 130, 400, -1));

        txt_username.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 300, 40));

        txt_password.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 300, 300, 40));

        lbl_password.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_password.setText("Password");
        getContentPane().add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 280, -1, -1));

        lbl_username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setText("Username");
        getContentPane().add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 200, -1, -1));

        chk_showpassword.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        chk_showpassword.setForeground(new java.awt.Color(255, 255, 255));
        chk_showpassword.setText("Show Password");
        chk_showpassword.setContentAreaFilled(false);
        chk_showpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_showpasswordActionPerformed(evt);
            }
        });
        getContentPane().add(chk_showpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 350, -1, -1));

        Btn_absen.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        Btn_absen.setText("ABSEN");
        Btn_absen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_absenActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_absen, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 500, 300, 40));

        btn_forgot.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_forgot.setForeground(new java.awt.Color(255, 255, 255));
        btn_forgot.setText("Forgot Password?");
        btn_forgot.setContentAreaFilled(false);
        getContentPane().add(btn_forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 350, -1, -1));

        btn_login.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_login.setText("LOGIN");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 380, 300, 40));

        btn_register.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_register.setText("REGISTER");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 440, 300, 40));

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 490, 50));

        lbl_lokasi.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_lokasi.setForeground(new java.awt.Color(255, 255, 255));
        lbl_lokasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(lbl_lokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 860, 50));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Fornend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void chk_showpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_showpasswordActionPerformed
        if (chk_showpassword.isSelected()) {
    // Jika checkbox "chk_showpassword" terpilih, maka...
    // Mengatur karakter echo pada teks password menjadi 0 (tidak terlihat)
    txt_password.setEchoChar((char) 0);
} else {
    // Jika checkbox "chk_showpassword" tidak terpilih, maka...
    // Mengatur karakter echo pada teks password menjadi '*' (terlihat sebagai bintang)
    txt_password.setEchoChar('*');
}
    }//GEN-LAST:event_chk_showpasswordActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        try {
    // Ambil input username dan password dari pengguna
    String username = txt_username.getText();
    String password = new String(txt_password.getPassword());

    // Lakukan koneksi ke database
    java.sql.Connection conn = (Connection)Config.configDB();

    // Buat query untuk memeriksa username dan password yang cocok
    String checkUserPassSql = "SELECT * FROM akun WHERE username = ? AND password = ?";
    java.sql.PreparedStatement checkUserPassPst = conn.prepareStatement(checkUserPassSql);
    checkUserPassPst.setString(1, username);
    checkUserPassPst.setString(2, password);
    java.sql.ResultSet checkUserPassRs = checkUserPassPst.executeQuery();

    int maxAttempts = 15; // Jumlah maksimum penundaan
    int delayMinutes = 0; // Waktu penundaan awal (menit)
    int delaySeconds = 0; // Waktu penundaan awal (detik)
    int currentAttempt = 0; // Jumlah penundaan saat ini

    if (!checkUserPassRs.next()) {
        // Cek jika username dan password salah
        boolean isUsernameCorrect = false;
        boolean isPasswordCorrect = false;

        // Cek jika username salah
        String checkUsernameSql = "SELECT * FROM akun WHERE username = ?";
        java.sql.PreparedStatement checkUsernamePst = conn.prepareStatement(checkUsernameSql);
        checkUsernamePst.setString(1, username);
        java.sql.ResultSet checkUsernameRs = checkUsernamePst.executeQuery();
        if (checkUsernameRs.next()) {
            isUsernameCorrect = true;
        }

        // Cek jika password salah
        String checkPasswordSql = "SELECT * FROM akun WHERE password = ?";
        java.sql.PreparedStatement checkPasswordPst = conn.prepareStatement(checkPasswordSql);
        checkPasswordPst.setString(1, password);
        java.sql.ResultSet checkPasswordRs = checkPasswordPst.executeQuery();
        if (checkPasswordRs.next()) {
            isPasswordCorrect = true;
        }

        // Tampilkan pesan notifikasi sesuai dengan kesalahan yang terjadi
        if (!isUsernameCorrect && !isPasswordCorrect) {
            JOptionPane.showMessageDialog(null, "Username dan Password Salah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else if (!isUsernameCorrect) {
            JOptionPane.showMessageDialog(null, "Username Salah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else if (!isPasswordCorrect) {
            JOptionPane.showMessageDialog(null, "Password Salah", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }

        // Tambahkan jumlah percobaan gagal
        failedAttempts++;
        currentAttempt = failedAttempts;

        // Set waktu penundaan berdasarkan jumlah percobaan gagal
        if (currentAttempt == 3) {
            delaySeconds = 5; // Blokir selama 5 detik setelah 3 percobaan gagal
        } else if (currentAttempt == 5) {
            delayMinutes = 1; // Blokir selama 1 menit setelah 5 percobaan gagal
        } else if (currentAttempt == 10) {
            delayMinutes = 2; // Blokir selama 2 menit setelah 10 percobaan gagal
        } else if (currentAttempt == 15) {
            delayMinutes = 60; // Blokir selama 1 jam setelah 15 percobaan gagal
        }

        // Cek jika jumlah percobaan gagal melebihi batas maksimum
        if (currentAttempt >= maxAttempts) {
            JOptionPane.showMessageDialog(null, "Akun Anda Telah Diblokir Selama 1 Jam. Silakan Coba Lagi Nanti.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Tampilkan pesan notifikasi berdasarkan waktu penundaan yang ditentukan
        if (delayMinutes > 0 || delaySeconds > 0) {
            int totalDelayInSeconds = delayMinutes * 60 + delaySeconds;
            JOptionPane.showMessageDialog(null, "Anda Telah Gagal Login Sebanyak " + currentAttempt + " Kali. Akun Anda Akan Di Blokir Selama " + delayMinutes + " Menit " + delaySeconds + " Detik.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            // Blokir akun selama waktu yang ditentukan
            isBlocked = true;

            // Membuat timer yang akan memperbarui peringatan setiap detik
            Timer timer = new Timer(1000, new ActionListener() {
                int remainingSeconds = totalDelayInSeconds;

                public void actionPerformed(ActionEvent e) {
                    if (remainingSeconds > 0) {
                        int minutes = remainingSeconds / 60;
                        int seconds = remainingSeconds % 60;
                        JOptionPane.showMessageDialog(null, "Akun Anda Masih diblokir Selama " + minutes + " Menit " + seconds + " Detik.", "Peringatan", JOptionPane.WARNING_MESSAGE);
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
        }
    } else {
        // Jika login berhasil, reset jumlah penundaan dan aktifkan tombol
        failedAttempts = 0;
        currentAttempt = 0;
        btn_login.setEnabled(true);

        // Username dan password cocok, pengguna berhasil login
        String role = checkUserPassRs.getString("role");
        if (role.equals("Admin")) {
            JOptionPane.showMessageDialog(null, "Selamat datang, " + username + "! Anda berhasil login sebagai Admin.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            // Buka halaman dashboard
            new Dashboard().setVisible(true);
        } else if (role.equals("Kasir")) {
            JOptionPane.showMessageDialog(null, "Selamat datang, " + username + "! Anda berhasil login sebagai Kasir.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            // Buka halaman menu transaksi kasir
            new Menu_Transaks_Kasir().setVisible(true);
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
        this.setVisible(false);
        new SignUp().setVisible(true);
    }//GEN-LAST:event_btn_registerActionPerformed

    private void Btn_absenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_absenActionPerformed
        this.setVisible(false);
        new Absen().setVisible(true);
    }//GEN-LAST:event_Btn_absenActionPerformed

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
    private javax.swing.JButton Btn_absen;
    private javax.swing.JLabel Lbl_login;
    private javax.swing.JButton btn_forgot;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_register;
    private javax.swing.JCheckBox chk_showpassword;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_lokasi;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
