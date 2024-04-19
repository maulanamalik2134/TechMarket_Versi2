package Tampilan_Awal;

import Config.Config;
import Dashboard.Dashboard;
import Transaksi.Transaksi_Penjualan_Kasir;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class Login extends JFrame {
    private static final long serialVersionUID = 1L;
    private DefaultTableModel model;
    private int failedAttempts = 0;
    private boolean isBlocked = false;
    private JPasswordField txt_password;
    private JFormattedTextField txt_username;

    public Login() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTanggalDanWaktuSekarang();
                setTanggalDanWaktu();
            }
        });
        timer.start();
    }

    private void initComponents() {
        // Initialize components here
    }

    private void setTanggalDanWaktuSekarang() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
        String formattedDate = dateTime.format(formatter);
        String lokasiToko = "Jl. Raya Situbondo, Blk. Gardu, Cindogo, Tapen, Kabupaten Bondowoso, Jawa Timur 68282";
        lbl_tanggal.setText(formattedDate);
        lbl_lokasi.setText(lokasiToko);
    }

    private void setTanggalDanWaktu() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", new Locale("id", "ID"));
        String formattedDate = dateTime.format(formatter);
        lbl_tanggalmasuk.setText(formattedDate);
    }

    private void login() {
        if (isBlocked) {
            JOptionPane.showMessageDialog(null, "Anda Sedang Diblokir. Silakan Tunggu Sebentar Sebelum Mencoba Lagi.");
            return;
        }

        String username = txt_username.getText();
        String password = new String(txt_password.getPassword());

        if (username.isEmpty() && password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username dan Password harus diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (Connection conn = Config.configDB()) {
            String checkUserPassSql = "SELECT * FROM akun WHERE username = ? AND password = ?";
            try (java.sql.PreparedStatement checkUserPassPst = conn.prepareStatement(checkUserPassSql)) {
                checkUserPassPst.setString(1, username);
                checkUserPassPst.setString(2, password);
                try (java.sql.ResultSet checkUserPassRs = checkUserPassPst.executeQuery()) {
                    if (!checkUserPassRs.next()) {
                        boolean isUsernameCorrect = false;
                        boolean isPasswordCorrect = false;

                        String checkUsernameSql = "SELECT * FROM akun WHERE username = ?";
                        try (java.sql.PreparedStatement checkUsernamePst = conn.prepareStatement(checkUsernameSql)) {
                            checkUsernamePst.setString(1, username);
                            try (java.sql.ResultSet checkUsernameRs = checkUsernamePst.executeQuery()) {
                                if (checkUsernameRs.next()) {
                                    isUsernameCorrect = true;
                                }
                            }
                        }

                        String checkPasswordSql = "SELECT * FROM akun WHERE password = ?";
                        try (java.sql.PreparedStatement checkPasswordPst = conn.prepareStatement(checkPasswordSql)) {
                            checkPasswordPst.setString(1, password);
                            try (java.sql.ResultSet checkPasswordRs = checkPasswordPst.executeQuery()) {
                                if (checkPasswordRs.next()) {
                                    isPasswordCorrect = true;
                                }
                            }
                        }

                        if (!isUsernameCorrect && !isPasswordCorrect) {
                            JOptionPane.showMessageDialog(null, "Username dan Password Salah", "Peringatan", JOptionPane.WARNING_MESSAGE);
                        } else if (!isUsernameCorrect) {
                            JOptionPane.showMessageDialog(null, "Username Salah", "Peringatan", JOptionPane.WARNING_MESSAGE);
                        } else if (!isPasswordCorrect) {
                            JOptionPane.showMessageDialog(null, "Password Salah", "Peringatan", JOptionPane.WARNING_MESSAGE);
                        }

                        failedAttempts++;
                        if (failedAttempts >= 3) {
                            isBlocked = true;
                            JOptionPane.showMessageDialog(null, "Akun Anda Telah Diblokir Selama 1 Menit. Silakan Coba Lagi Nanti.", "Peringatan", JOptionPane.WARNING_MESSAGE);
                            return;
                        }
                    } else {
                        failedAttempts = 0;
                        isBlocked
