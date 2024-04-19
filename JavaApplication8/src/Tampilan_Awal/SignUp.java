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

    private DefaultTableModel model;
    private Config config;
    private Connection connection;
    private String checkSql;
    private String checkAdminSql;
    private String checkKasirSql;
    private String sql;
    private PreparedStatement pst;
    private String successMessage;
    private String roleLimitExceededMessage;
    private int countAdmin;
    private int countKasir;

    public SignUp(Config config) {
        this.config = config;
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                setTanggalDanWaktuSekarang();
                setTanggalDanWaktu();
            }
        }, 0, 1, TimeUnit.SECONDS);

        try {
            connection = config.configDB();
            loadRoles();
            loadIdAkun();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadRoles() throws SQLException {
        String sql = "SELECT * FROM role";
        java.sql.Statement stm = connection.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);

        cmb_role.removeAllItems();
        while (res.next()) {
            cmb_role.addItem(res.getString("role"));
        }
    }

    private void loadIdAkun() throws SQLException {
        String sql = "SELECT MAX(Id_akun) FROM akun";
        java.sql.Statement stm = connection.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);

        if (res.next()) {
            String idakun = "" + (res.getInt("MAX(Id_akun)") + 1);
            txt_idakun.setText(idakun);
        } else {
            txt_idakun.setText("1");
        }
    }

    public void setTanggalDanWaktuSekarang() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
        String formattedDateTime = dateTime.format(formatter);
        lbl_tanggal.setText(formattedDateTime);
        String lokasiToko = "Jl. Raya Situbondo, Blk. Gardu, Cindogo, Tapen, Kabupaten Bondowoso, Jawa Timur 68282"; 
        lbl_
