package Tampilan_Awal;

import Config.Config;
import java.sql.Connection;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Absen extends javax.swing.JFrame {
    String Tanggal; 
private DefaultTableModel model; 

public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
    String formattedDate = dateTime.format(formatter);
    
    String lokasiToko = "Jl. Raya Situbondo, Blk. Gardu, Cindogo, Tapen, Kabupaten Bondowoso, Jawa Timur 68282";

    lbl_tanggal.setText(formattedDate); 
    lbl_lokasi.setText(lokasiToko); 
}

public Absen() {
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
    
    try {
    String sql = "SELECT * FROM absen ORDER BY Id_absen DESC LIMIT 1";
    java.sql.Connection conn = (Connection) Config.configDB();
    java.sql.Statement stm = conn.createStatement();
    java.sql.ResultSet res = stm.executeQuery(sql);
    if (res.next()) {
        String idabsen = "" + (res.getInt("Id_absen") + 1);
        txt_idabsen.setText(idabsen);
    } else {
        txt_idabsen.setText("1");
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
        Lbl_absen = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        btn_absen = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        cmb_absen = new javax.swing.JComboBox<>();
        lbl_image = new javax.swing.JLabel();
        txt_idakun = new javax.swing.JLabel();
        txt_idabsen = new javax.swing.JLabel();
        txt_tanggal1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_lokasi.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_lokasi.setForeground(new java.awt.Color(255, 255, 255));
        lbl_lokasi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        getContentPane().add(lbl_lokasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 860, 50));

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        Lbl_absen.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 36)); // NOI18N
        Lbl_absen.setForeground(new java.awt.Color(255, 255, 255));
        Lbl_absen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_absen.setText("ABSEN");
        getContentPane().add(Lbl_absen, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 130, 400, -1));

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
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usernameKeyReleased(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 300, 40));

        btn_absen.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_absen.setText("ABSEN");
        btn_absen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_absen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_absenActionPerformed(evt);
            }
        });
        getContentPane().add(btn_absen, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, 300, 40));

        btn_cancel.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_cancel.setText("CANCEL");
        btn_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 400, 300, 40));

        cmb_absen.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        cmb_absen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hadir", "Ijin", "sakit", "Alpa" }));
        getContentPane().add(cmb_absen, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 280, 300, 40));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Fornend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        txt_idakun.setText("11");
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 280, -1, -1));

        txt_idabsen.setText("jLabel1");
        getContentPane().add(txt_idabsen, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 264, 220, 60));

        txt_tanggal1.setText("jLabel2");
        getContentPane().add(txt_tanggal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 400, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed

    }//GEN-LAST:event_txt_usernameActionPerformed

    private void btn_absenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_absenActionPerformed
        try {
    int id_absen = Integer.parseInt(txt_idabsen.getText());
    int id_user = Integer.parseInt(txt_idakun.getText());
    String keterangan = (String) cmb_absen.getSelectedItem();
    String username = txt_username.getText();
    
    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();
    
    java.sql.Connection conn = (Connection) Config.configDB();
    
    boolean isUsernameCorrect = false;
    String checkUsernameSql = "SELECT * FROM akun WHERE username = ?";
    java.sql.PreparedStatement checkUsernamePst = conn.prepareStatement(checkUsernameSql);
    checkUsernamePst.setString(1, username);
    java.sql.ResultSet checkUsernameRs = checkUsernamePst.executeQuery();
    if (checkUsernameRs.next()) {
        isUsernameCorrect = true;
    }
    
    if (!isUsernameCorrect) {
        JOptionPane.showMessageDialog(null, "Username Tidak Di Temukan", "Peringatan", JOptionPane.WARNING_MESSAGE);
    } else {
        LocalTime startTime = LocalTime.parse("07:00");
        LocalTime endTime = LocalTime.parse("09:00");
        
        if (currentTime.isBefore(startTime) || currentTime.isAfter(endTime)) {
            JOptionPane.showMessageDialog(null, "Waktu absen telah berakhir. Silakan absen antara jam 07:00 - 09:00.");
            new Login().setVisible(true);
            dispose();
        } else {
            String checkSql = "SELECT COUNT(*) FROM absen WHERE Id_akun=? AND waktu_absen >= ? AND waktu_absen < ?";
            java.sql.PreparedStatement checkPst = conn.prepareStatement(checkSql);
            checkPst.setInt(1, id_user);
            checkPst.setString(2, currentDate + " 00:00:00");
            checkPst.setString(3, currentDate + " 23:59:59");
            java.sql.ResultSet checkResult = checkPst.executeQuery();
            checkResult.next();
            int absenCount = checkResult.getInt(1);
            
            if (absenCount > 0) {
                JOptionPane.showMessageDialog(null, "Anda sudah melakukan absen hari ini. Silakan coba lagi besok.");
                new Login().setVisible(true);
                dispose();
            } else {
                String sql = "INSERT INTO absen (Id_absen, Id_akun, username, Keterangan, waktu_absen) VALUES (?, ?, ?, ?, ?)";
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.setInt(1, id_absen);
                pst.setInt(2, id_user);
                pst.setString(3, username);
                pst.setString(4, keterangan);
                pst.setString(5, currentDate + " " + currentTime);
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Data absen berhasil disimpan!\nUsername: " + username + "\nWaktu Absen: " + currentDate + " " + currentTime);
                
                new Login().setVisible(true);
                dispose();
            }
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data absen. Silakan coba lagi nanti.");
    System.out.println("Simpan Absen Error 2: " + e);
    new Login().setVisible(true);
    dispose();
}
    }//GEN-LAST:event_btn_absenActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.setVisible(false);
        new Login().setVisible(true);
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void txt_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyReleased
        String Nama = txt_username.getText();
        try {
            String sql = "SELECT * FROM akun WHERE  Username = '" + Nama + "';";
            System.out.println(sql);
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                txt_idakun.setText(res.getString("Id_akun"));
            }
        } catch (Exception e) {
            System.out.println("");
        }
    }//GEN-LAST:event_txt_usernameKeyReleased

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
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Absen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_absen;
    private javax.swing.JButton btn_absen;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JComboBox<String> cmb_absen;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_lokasi;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JLabel txt_idabsen;
    private javax.swing.JLabel txt_idakun;
    private javax.swing.JLabel txt_tanggal1;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
