package Transaksi;

import Data_master.Barang;
import Config.Config;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Transaksi_Penjualan_Kasir extends javax.swing.JFrame {
    String Tanggal;
    private DefaultTableModel model;
    private NumberFormat numberFormat;

    public Transaksi_Penjualan_Kasir() {
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
        numberFormat.setGroupingUsed(false);

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            Date date = new Date();
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            txt_tanggal.setText(s.format(date));
            setTanggalDanWaktu();
        }, 1, 1, TimeUnit.SECONDS);

        try {
            String sql = "SELECT * FROM transaksi_penjualan order by id_transaksi desc limit 1";
            System.out.println(sql);
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                String sql2 = "SELECT * FROM detail_transaksi_penjualan WHERE id_transaksi = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql2);
                pstmt.setInt(1, res.getInt("id_transaksi"));
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    model.addRow(new Object[]{
                        res.getInt("id_transaksi"),
                        rs.getInt("id_barang"),
                        rs.getString("barang"),
                        rs.getInt("harga"),
                        rs.getString("satuan"),
                        rs.getInt("jumlah"),
                        rs.getInt("subtotal")
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComponents() {
        // ... (same as before)
    }

    // ... (same as before, but with some modifications)

    private void tabelMouseClicked(MouseEvent evt) {
        int row = tabel.getSelectedRow();
        if (row >= 0) {
            txt_idtransaksi.setText(tabel.getValueAt(row, 0).toString());
            txt_idbarang.setText(tabel.getValueAt(row, 1).toString());
            txt_namabarang.setText(tabel.getValueAt(row, 2).toString());
            txt_hargajual.setText(tabel.getValueAt(row, 3).toString());
            cmb_satuan.setSelectedItem(tabel.getValueAt(row, 4).toString());
            txt_jumlah.setText(tabel.getValueAt(row, 5).toString());
            txt_subtotal.setText(tabel.getValueAt(row, 6).toString());
        }
    }

    private void txt_namabarangKeyReleased(KeyEvent evt) {
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
                txt_hargajual.setText(res.getString("harga"));
                cmb_satuan.setSelectedItem(res.getString("satuan"));
            } else {
                JOptionPane.showMessageDialog(this, "Barang tidak ditemukan.");
                clear2();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil data: " + e.getMessage());
        }
    }

    private void btn_tambahActionPerformed(ActionEvent evt) {
        String idTransaksi = txt_idtransaksi.getText();
        String idBarang = txt
