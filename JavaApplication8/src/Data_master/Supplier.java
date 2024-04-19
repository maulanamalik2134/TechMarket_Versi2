package Data_master;

import Data_master.Barang;
import Laporan.Laporan_Transaksi_Penjualan;
import Config.Config;
import Dashboard.Dashboard;
import Opname.Opname;
import Transaksi.Transaksi_Penjualan;
import Tampilan_Awal.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Supplier extends javax.swing.JFrame {
    private DefaultTableModel model;

    public Supplier() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> setTanggalDanWaktuSekarang(), 0, 1, TimeUnit.SECONDS);
        setTanggalDanWaktuSekarang();
        tabel_supplier();
        txt_idsupplier.setText(getNextIdSupplier());
        kosong1();
    }

    private void setTanggalDanWaktuSekarang() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
        String formattedDateTime = dateTime.format(formatter);
        lbl_tanggal.setText(formattedDateTime);
    }

    private String getNextIdSupplier() {
        try {
            String sql = "SELECT MAX(Id_supplier) AS max_id FROM supplier";
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
        txt_username.setText(null);
        txt_telepon.setText(null);
        txt_alamat.setText(null);
    }

    private void tabel_supplier() {
        model = new DefaultTableModel();
        model.addColumn("Id Supplier");
        model.addColumn("Supplier");
        model.addColumn("Telepon");
        model.addColumn("Alamat");
        try {
            int no = 1;
            String sql = "SELECT supplier.id_supplier, supplier.supplier, supplier.telepon, supplier.alamat FROM supplier";
            Connection conn = Config.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString("id_supplier"),
                    res.getString("supplier"),
                    res.getString("telepon"),
                    res.getString("alamat"),
                });
            }
            tabel_supplier.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal mengisi tabel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tabel_supplierMouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 1) {
            int row = tabel_supplier.rowAtPoint(evt.getPoint());
            if (row >= 0 && row < tabel_supplier.getRowCount()) {
                String id_supplier = tabel_supplier.getValueAt(row, 0).toString();
                String supplier = tabel_supplier.getValueAt(row, 1).toString();
                String telepon = tabel_supplier.getValueAt(row, 2).toString();
                String alamat = tabel_supplier.getValueAt(row, 3).toString();

                txt_idsupplier.setText(id_supplier);
                txt_username.setText(supplier);
                txt_telepon.setText(telepon);
                txt_alamat.setText(alamat);
            }
        }
    }

    // ... (other methods)
}
