package Laporan;

import Config.Config;
import Tampilan_Awal.Login;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Laporan_Transaksi_Pembelian extends javax.swing.JFrame {
    private DefaultTableModel model;

    public void setTanggalDanWaktuSekarang() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
        String formattedDateTime = dateTime.format(formatter);
        lbl_tanggal.setText(formattedDateTime);
    }

    public Laporan_Transaksi_Pembelian() {
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
        setTanggalDanWaktuSekarang();
        tabel_laporanpembelian();
    }

    private void tabel_laporanpembelian() {
        model = new DefaultTableModel();
        model.addColumn("Id Transaksi");
        model.addColumn("Username");
        model.addColumn("Nama Supplier");
        model.addColumn("Total");
        model.addColumn("Bayar");
        model.addColumn("Kembalian");
        model.addColumn("Metode Pembayaran");
        model.addColumn("Tanggal Transaksi");

        try (Connection conn = Config.configDB()) {
            String sql = "SELECT transaksi_pembelian.id_transaksi, transaksi_pembelian.username, transaksi_pembelian.nama_supplier, transaksi_pembelian.total,"
                    + "transaksi_pembelian.bayar, transaksi_pembelian.kembalian, transaksi_pembelian.metode_pembayaran, transaksi_pembelian.tanggal_transaksi FROM transaksi_pembelian";
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{
                        res.getString("id_transaksi"),
                        res.getString("username"),
                        res.getString("nama_supplier"),
                        res.getString("total"),
                        res.getString("bayar"),
                        res.getString("kembalian"),
                        res.getString("metode_pembayaran"),
                        res.getString("tanggal_transaksi"),
                });
            }

            tabel_supplier.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mengisi tabel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // ... (same as the original code)
    }

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("./print/Laporan_Pembelian.jasper"), null, Config.configDB());
            JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }

    public static void main(String args[]) {
        // ... (same as the original code)
    }
}
