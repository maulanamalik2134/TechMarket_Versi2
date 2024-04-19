package Data_master;

import Laporan.Laporan_Transaksi_Penjualan;
import Config.Config;
import Dashboard.Dashboard;
import Opname.Opname;
import Tampilan_Awal.Login;
import Transaksi.Transaksi_Penjualan;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EventObject;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JFormattedTextField;

public class Akun extends JFrame {
    private DefaultTableModel model;
    private JFormattedTextField txtIdAkun;
    private JFormattedTextField txtUsername;
    private JFormattedTextField txtPassword;
    private JFormattedTextField txtTelepon;
    private JFormattedTextField txtAlamat;
    private JComboBox<String> cmbRole;

    public Akun() {
        initComponents();
        setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            setTanggalDanWaktuSekarang();
        }, 0, 1, TimeUnit.SECONDS);
        setTanggalDanWaktuSekarang();
        tabel_akun();
        txtIdAkun.setText(getNextIdAkun());
        kosong1();
    }

    private void initComponents() {
        // Initialize components here
    }

    private void setTanggalDanWaktuSekarang() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
        String formattedDateTime = dateTime.format(formatter);
        lblTanggal.setText(formattedDateTime);
    }

    private void tabel_akun() {
        model = new DefaultTableModel();
        model.addColumn("Id Akun");
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("Role");
        model.addColumn("Telepon");
        model.addColumn("Alamat");

        try {
            String sql = "SELECT akun.id_akun, akun.username, akun.password, akun.role, akun.telepon, akun.alamat FROM akun";
            Connection conn = Config.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString("id_akun"),
                    res.getString("username"),
                    res.getString("password"),
                    res.getString("role"),
                    res.getString("telepon"),
                    res.getString("alamat"),
                });
            }

            tabelAkun.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mengisi tabel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getNextIdAkun() {
        try {
            String sql = "SELECT MAX(Id_akun) AS max_id FROM akun";
            Connection conn = Config.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);

            if (res.next()) {
                int maxId = res.getInt("max_id");
                return String.valueOf(maxId + 1);
            } else {
                return "1";
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mengambil data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return "";
        }
    }

    private void kosong1() {
        txtUsername.setText(null);
        txtPassword.setText(null);
        cmbRole.setSelectedItem(null);
        txtTelepon.setText(null);
        txtAlamat.setText(null);
    }

    private void btnTambahActionPerformed(EventObject evt) {
        // Handle btnTambah click event
    }

    private void btnEditActionPerformed(EventObject evt) {
        // Handle btnEdit click event
    }

    private void btnHapusActionPerformed(EventObject evt) {
        // Handle btnHapus click event
    }

    private void tabelAkunMouseClicked(java.awt.event.MouseEvent evt) {
        int baris = tabelAkun.rowAtPoint(evt.getPoint());
        String id_akun = tabelAkun.getValueAt(baris, 0).toString();
        txtIdAkun.setText(id_akun);
        txtUsername.setText(tabelAkun.getValueAt(baris, 1) == null ? "" : tabelAkun.getValueAt(baris, 1).toString());
        txtPassword.setText(tabelAkun.getValueAt(baris, 2) == null ? "" : tabelAkun.getValueAt(baris, 2).toString());
        cmbRole.setSelectedItem(tabelAkun.getValueAt(baris, 3) == null ? "" : tabelAkun
