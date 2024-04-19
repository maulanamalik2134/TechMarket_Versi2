package data_master;

import data_master.supplier.SupplierController;
import data_master.supplier.SupplierModel;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PelangganFrame extends JFrame {

    private DefaultTableModel model;

    public PelangganFrame() {
        initComponents();
        setTitle("Aplikasi TechMarket - Data Pelanggan");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        tabelSupplier();
        txtIdpelanggan.setText(getNextIdPelanggan());
        kosong1();
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                setTanggalDanWaktuSekarang();
            }
        }, 0, 1, TimeUnit.SECONDS);
        setTanggalDanWaktuSekarang();
    }

    private void setTanggalDanWaktuSekarang() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
        String formattedDateTime = dateTime.format(formatter);
        lblTanggal.setText(formattedDateTime);
    }

    private void tabelSupplier() {
        model = new DefaultTableModel();
        model.addColumn("Id Pelanggan");
        model.addColumn("Pelanggan");
        model.addColumn("Telepon");
        model.addColumn("Alamat");

        try {
            String sql = "SELECT pelanggan.id_pelanggan, pelanggan.pelanggan, pelanggan.telepon, pelanggan.alamat FROM pelanggan";
            Connection conn = Config.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString("id_pelanggan"),
                    res.getString("pelanggan"),
                    res.getString("telepon"),
                    res.getString("alamat"),
                });
            }
            tabelSupplier.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mengisi tabel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getNextIdPelanggan() {
        try {
            String sql = "SELECT MAX(Id_pelanggan) AS max_id FROM pelanggan";
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
        txtTelepon.setText(null);
        txtAlamat.setText(null);
    }

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String username = txtUsername.getText();
            String alamat = txtAlamat.getText();
            String telepon = txtTelepon.getText();
            int idpelanggan = Integer.parseInt(txtIdpelanggan.getText());

            if (username.isEmpty() || telepon.isEmpty() || alamat.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
                return;
            } else if (username.length() < 5 || username.length() > 30) {
                JOptionPane.showMessageDialog(null, "Panjang nama supplier harus antara 5 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (!username.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(null, "Username harus terdiri dari huruf dan spasi saja.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (alamat.length() < 1 || alamat.length() > 30) {
                JOptionPane.showMessageDialog(null, "Panjang alamat harus antara 1 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (!alamat.matches("[a-zA-Z0-9- ]+")) {
                JOptionPane.showMessageDialog(null, "Alamat hanya boleh terdiri dari huruf, angka, spasi, atau tanda '-'", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (telepon.length
