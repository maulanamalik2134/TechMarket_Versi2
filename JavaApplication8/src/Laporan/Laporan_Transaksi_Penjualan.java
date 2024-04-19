package Laporan;

import Config.Config;
import Dashboard.Dashboard;
import Data_master.Akun;
import Opname.Opname;
import Transaksi.Transaksi_Penjualan;
import Tampilan_Awal.Login;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormat;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.Format;
import javax.swing.text.JFormattedTextField;
import javax.swing.text.PlainDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.TabStop;
import javax.swing.*;
import javax.swing.text.DateFormat;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.Format;
import javax.swing.text.JFormattedTextField;
import javax.swing.text.PlainDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.TabStop;
import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Laporan_Transaksi_Penjualan extends JFrame {
    private DefaultTableModel model;
    private JFormattedTextField lbl_tanggal;

    public Laporan_Transaksi_Penjualan() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SwingUtilities.invokeLater(() -> {
                    LocalDateTime dateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
                    String formattedDateTime = dateTime.format(formatter);
                    lbl_tanggal.setValue(formattedDateTime);
                });
            }
        });
        tabel_laporanpenjualan();
    }

    private void tabel_laporanpenjualan() {
        model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Username");
        model.addColumn("Pelanggan");
        model.addColumn("Nama Barang");
        model.addColumn("Total");
        model.addColumn("Bayar");
        model.addColumn("Kembalian");
        model.addColumn("Metode Pembayaran");
        model.addColumn("Tanggal Transaksi");
        try (Connection conn = Config.configDB();
             PreparedStatement stm = conn.prepareStatement("SELECT laporan_penjualan.id_transaksi, laporan_penjualan.username, laporan_penjualan.nama_pelanggan, laporan_penjualan.nama_barang, laporan_penjualan.total,"
                     + "laporan_penjualan.bayar, laporan_penjualan.kembalian, laporan_penjualan.metode_pembayaran, laporan_penjualan.tanggal_transaksi FROM laporan_penjualan")) {
            ResultSet res = stm.executeQuery();
            while (res.next()) {
                model.addRow(new Object[]{
                        res.getString("id_transaksi"),
                        res.getString("username"),
                        res.getString("nama_pelanggan"),
                        res.getString("nama_barang"),
                        res.getString("total"),
                        res.getString("bayar"),
                        res.getString("kembalian"),
                        res.getString("metode_pembayaran"),
                        res.getString("tanggal_transaksi"),
                });
            }
            tabel_supplier.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mengisi tabel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE
