package Transaksi;

import Data_master.Akun;
import Data_master.Barang;
import Laporan.Laporan_Transaksi_Penjualan;
import Config.Config;
import Dashboard.Dashboard;
import Opname.Opname;
import Tampilan_Awal.Login;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperViewer;
import net.sf.jasperreports.view.JasperViewer;

public class Transaksi_Pembelian extends javax.swing.JFrame {
    String Tanggal;
    private DefaultTableModel model;
    private NumberFormat numberFormat;

    public Transaksi_Pembelian() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Aplikasi Kasir - Toko Imanuel Jember");
        model = new DefaultTableModel();
        tabel.setModel(model);
        model.addColumn("Id_transaksi");
        model.addColumn("Id Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Harga");
        model.addColumn("Satuan");
        model.addColumn("Jumlah");
        model.addColumn("SubTotal");
        numberFormat = NumberFormat.getNumberInstance(Locale.US);
        numberFormat.setMinimumFractionDigits(0);
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            Date date = new Date();
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            txt_tanggal.setText(s.format(date));
            setTanggalDanWaktu();
        }, 0, 1, TimeUnit.SECONDS);
        try {
            String sql = "SELECT * FROM transaksi_pembelian order by id_transaksi desc limit 1";
            System.out.println(sql);
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                String noBaru = "" + (res.getInt("id_transaksi") + 1);
                txt_idtransaksi.setText(noBaru);
            } else {
                txt_idtransaksi.setText("1");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        // ... (same as before)
    }

    // ... (other methods remain the same)

    private void setTanggalDanWaktu() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
        String formattedDateTime = dateTime.format(formatter);
        lbl_tanggal.setText(formattedDateTime);
    }

    private void txt_namabarangKeyReleased(java.awt.event.KeyEvent evt) {
        String Nama = txt_namabarang.getText();
        try {
            String sql = "SELECT * FROM barang WHERE barang LIKE ?";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + Nama + "%");
            java.sql.ResultSet res = stm.executeQuery();
            if (res.next()) {
                txt_namabarang.setText(res.getString("barang"));
                txt_idbarang.setText(res.getString("Id_barang"));
                txt_hargajual.setText(String.valueOf(res.getDouble("harga")));
                cmb_satuan.setSelectedItem(res.getString("satuan"));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Barang tidak ditemukan.");
                clear2();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {
        int harga = Integer.parseInt(txt_hargajual.getText());
        int jumlah = Integer.parseInt(txt_jumlah.getText());
        double subtotal = harga * jumlah;
        txt_
