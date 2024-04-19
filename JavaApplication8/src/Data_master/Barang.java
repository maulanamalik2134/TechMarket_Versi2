package Data_master;

import Laporan.Laporan_Transaksi_Penjualan;
import Config.Config;
import Dashboard.Dashboard;
import Opname.Opname;
import Transaksi.Transaksi_Penjualan;
import Tampilan_Awal.Login;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Barang extends javax.swing.JFrame {

    private DefaultTableModel model;

    public void setTanggalDanWaktuSekarang() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
        String formattedDateTime = dateTime.format(formatter);
        lbl_tanggal.setText(formattedDateTime);
    }

    public void setTanggalDanWaktu() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", new Locale("id", "ID"));
        String formattedDate = dateTime.format(formatter);
        txt_tanggalmasuk.setText(formattedDate);
    }

    public Barang() {
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
        setTanggalDanWaktu();
        tabel_Barang();
        txt_idbarang.setText(getNextIdBarang());
        kosong1();
    }

    private String getNextIdBarang() {
        try {
            String sql = "SELECT MAX(Id_barang) AS max_id FROM barang";
            System.out.println(sql);
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
        txt_namabarang.setText(null);
        txt_hargajual.setText(null);
        txt_stok.setText(null);
        txt_diskon.setText(null);
    }

    private void tabel_Barang() {
        model = new DefaultTableModel();
        model.addColumn("Id Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Ketegori");
        model.addColumn("Merek");
        model.addColumn("Satuan");
        model.addColumn("Harga");
        model.addColumn("Diskon");
        model.addColumn("Stok");
        model.addColumn("Tanggal Masuk");

        try {
            String sql = "SELECT barang.id_barang, barang.barang, barang.kategori, barang.merek, barang.satuan, barang.harga, barang.diskon, barang.stok, barang.tanggal FROM barang";
            Connection conn = Config.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                String idBarang = res.getString("id_barang");
                String namaBarang = res.getString("barang");
                String kategori = res.getString("kategori");
                String merek = res.getString("merek");
                String satuan = res.getString("satuan");
                String harga = res.getString("harga");
                String diskon = res.getString("diskon");
                String stok = res.getString("stok");
                String tanggal = res.getString("tanggal");

                model.addRow(new Object[]{
                    idBarang,
                    namaBarang,
                    kategori,
                    merek,
                    satuan,
                    harga,
                    diskon,
                    stok,
                    tanggal
                });
            }

            tabel_barang.setModel(model);

            // Set the column widths
            TableColumnModel columnModel = tabel_barang.getColumnModel();
            columnModel.getColumn(
