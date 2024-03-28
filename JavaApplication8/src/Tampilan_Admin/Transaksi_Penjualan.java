package Tampilan_Admin;

import Config.Config;
import Tampilan_Awal.Login;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Transaksi_Penjualan extends javax.swing.JFrame {
String Tanggal;
private DefaultTableModel model;

public void total() {
    int Jumlahbaris = tabel.getRowCount();
    int Subtotal = 0;
    int Total = 0;
    int Jumlah, Harga;
    for (int i = 0; i < Jumlahbaris; i++) {
        Total += Integer.parseInt(tabel.getValueAt(i, 6).toString());
    }
    txt_subtotal.setText(String.valueOf(Subtotal));
    txt_total.setText(String.valueOf(Total));
}

public void loaddata() {
    DefaultTableModel model = (DefaultTableModel) tabel.getModel();
     int Jumlahbaris = tabel.getRowCount();
    for (int i = 0; i < Jumlahbaris; i++) {
        int idBarangTable = Integer.parseInt(tabel.getValueAt(i, 1).toString());
        int idBarang = Integer.parseInt(txt_idbarang.getText());
        if (idBarang == idBarangTable) { 
            int jumlahTable  = Integer.parseInt(model.getValueAt(i,5).toString());
            int subTotalTable  =Integer.parseInt( model.getValueAt(i,6).toString());
            int jumlah  = Integer.parseInt(txt_jumlah.getText());
            int subTotal  =Integer.parseInt(  txt_subtotal.getText());
            model.setValueAt(jumlahTable+jumlah, i, 5);
            model.setValueAt(subTotal+subTotalTable, i, 6);
            return;
        }
    }
    model.addRow(new Object[]{
        txt_idtransaksi.getText(),
        txt_idbarang.getText(),
        txt_namabarang.getText(),
        txt_hargajual.getText(),
        cmb_satuan.getSelectedItem(),
        txt_jumlah.getText(),
        txt_subtotal.getText()});
}

public void kosong() {
    DefaultTableModel model = (DefaultTableModel) tabel.getModel();
    while (model.getRowCount() > 0) {
        model.removeRow(0);
    }
}

public void utama() {
    txt_idbarang.setText("");
    txt_namabarang.setText("");
    txt_hargajual.setText("");
    cmb_satuan.setSelectedItem("");
    txt_jumlah.setText("");
    txt_subtotal.setText("");
    txt_idtransaksi.setText("");
}

public void clear1() {
    txt_idtransaksi.setText("");
    txt_idakun.setText("");
    txt_username.setText("");
    txt_idpelanggan.setText("");
    txt_namapelanggan.setText("");
    txt_tanggal.setText("");
    cmb_metode.setSelectedItem("");
    txt_total.setText("");
    txt_bayar.setText("");
    txt_kembalian.setText("");
}

public void clear2() {
    txt_idbarang.setText("");
    txt_namabarang.setText("");
    txt_hargajual.setText("");
    cmb_satuan.setSelectedItem("");
    txt_subtotal.setText("");
    txt_jumlah.setText("");
}

public int getStok() {
    int stok = 0;
    try {
        Connection conn = Config.configDB();
        Statement statement = conn.createStatement();
        String idBarang = txt_idbarang.getText();
        ResultSet res = statement.executeQuery("SELECT stok FROM barang WHERE Id_barang = '" + idBarang + "'");

        if (res.next()) {
            stok = res.getInt("stok");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal Mengambil Data: " + e.getMessage());
    }
    return stok;
}

public void tambahtransaksi() {
    int jumlah, harga, total;
    jumlah = Integer.valueOf(txt_jumlah.getText());
    harga = Integer.valueOf(txt_hargajual.getText());

    int stok = getStok(); 
    if (stok == 0) {
        JOptionPane.showMessageDialog(null, "Stok habis untuk transaksi ini");
        return;
    } else if (stok < jumlah) {
        JOptionPane.showMessageDialog(null, "Stok tidak cukup untuk transaksi ini");
        return;
    } else if (stok <= 5) {
        JOptionPane.showMessageDialog(null, "Stok menipis");
    }

    total = jumlah * harga;
    loaddata();
    total();
    clear2();
    txt_idbarang.requestFocus();
}

public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd-MM-yyyy HH:mm:ss");
    String formattedDateTime = dateTime.format(formatter);
    txt_tanggal.setText(formattedDateTime);
}

public void setTanggalDanWaktu() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
    String formattedDateTime = dateTime.format(formatter);
    lbl_tanggal.setText(formattedDateTime);
}

public Transaksi_Penjualan() {
    initComponents();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setTitle("Aplikasi Kasir - Toko Imanuel Jember");
    model = new DefaultTableModel();
    tabel.setModel(model);
    model.addColumn("Id_transaksi");
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Harga ");
    model.addColumn("Satuan");
    model.addColumn("Jumlah");
    model.addColumn("SubTotal");

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(() -> {
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        txt_tanggal.setText(s.format(date));
        setTanggalDanWaktu();
    }, 0, 1, TimeUnit.SECONDS);

    try {
        String sql = "SELECT * FROM transaksi_penjualan order by id_transaksi desc limit 1";
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_tanggal = new javax.swing.JLabel();
        bab = new javax.swing.JLabel();
        txt_namabarang = new javax.swing.JFormattedTextField();
        lbl_namabarang = new javax.swing.JLabel();
        lbl_hargajual = new javax.swing.JLabel();
        txt_hargajual = new javax.swing.JFormattedTextField();
        cmb_satuan = new javax.swing.JComboBox<>();
        lbl_hargabeli = new javax.swing.JLabel();
        lbl_stok = new javax.swing.JLabel();
        txt_jumlah = new javax.swing.JFormattedTextField();
        txt_subtotal = new javax.swing.JFormattedTextField();
        lbl_namabarang1 = new javax.swing.JLabel();
        lbl_namabarang2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        txt_namapelanggan = new javax.swing.JFormattedTextField();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_bayar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        txt_total = new javax.swing.JFormattedTextField();
        txt_kembalian = new javax.swing.JFormattedTextField();
        txt_bayar = new javax.swing.JFormattedTextField();
        lbl_stok2 = new javax.swing.JLabel();
        lbl_stok3 = new javax.swing.JLabel();
        lbl_stok4 = new javax.swing.JLabel();
        lbl_stok5 = new javax.swing.JLabel();
        btn_transaksipembelian = new javax.swing.JButton();
        btn_cari = new javax.swing.JButton();
        btn_struk = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        gambar = new javax.swing.JLabel();
        btn_dashboard = new javax.swing.JButton();
        btn_datamaster = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_opname = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        txt_idpelanggan = new javax.swing.JFormattedTextField();
        txt_idakun = new javax.swing.JFormattedTextField();
        txt_idbarang = new javax.swing.JFormattedTextField();
        txt_tanggal = new javax.swing.JFormattedTextField();
        txt_idtransaksi = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setForeground(new java.awt.Color(255, 255, 255));
        bab.setText("Hai Admin, Selamat Datang Di Transaksi Penjualan");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1120, 50));

        txt_namabarang.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarangActionPerformed(evt);
            }
        });
        txt_namabarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_namabarangKeyReleased(evt);
            }
        });
        getContentPane().add(txt_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 310, -1));

        lbl_namabarang.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namabarang.setText("Username");
        getContentPane().add(lbl_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        lbl_hargajual.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargajual.setText("Harga Jual");
        getContentPane().add(lbl_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        txt_hargajual.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_hargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargajualActionPerformed(evt);
            }
        });
        getContentPane().add(txt_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 140, -1));

        cmb_satuan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        cmb_satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pcs" }));
        getContentPane().add(cmb_satuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 140, 30));

        lbl_hargabeli.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargabeli.setText("Satuan");
        getContentPane().add(lbl_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        lbl_stok.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok.setText("Subtotal");
        getContentPane().add(lbl_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 570, -1, -1));

        txt_jumlah.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });
        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyReleased(evt);
            }
        });
        getContentPane().add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, 140, -1));

        txt_subtotal.setEnabled(false);
        txt_subtotal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        txt_subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_subtotalActionPerformed(evt);
            }
        });
        getContentPane().add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 590, 260, 30));

        lbl_namabarang1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namabarang1.setText("Pelanggan");
        getContentPane().add(lbl_namabarang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, -1, -1));

        lbl_namabarang2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namabarang2.setText("Nama Barang");
        getContentPane().add(lbl_namabarang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        txt_username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        txt_username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_usernameKeyReleased(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 310, -1));

        txt_namapelanggan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_namapelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namapelangganActionPerformed(evt);
            }
        });
        txt_namapelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_namapelangganKeyReleased(evt);
            }
        });
        getContentPane().add(txt_namapelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 310, -1));

        btn_tambah.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Plus Math (1).png"))); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 220, 130, -1));

        btn_hapus.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Delete (1).png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 130, -1));

        btn_bayar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_bayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Cash.png"))); // NOI18N
        btn_bayar.setText("Bayar");
        btn_bayar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 590, 140, -1));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama Barang", "Harga", "Satuan", "Jumlah", "Subtotal"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 750, 300));

        txt_total.setEnabled(false);
        txt_total.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        getContentPane().add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 650, 260, -1));

        txt_kembalian.setEnabled(false);
        txt_kembalian.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        txt_kembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kembalianActionPerformed(evt);
            }
        });
        getContentPane().add(txt_kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 650, 260, -1));

        txt_bayar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        txt_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bayarActionPerformed(evt);
            }
        });
        txt_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bayarKeyReleased(evt);
            }
        });
        getContentPane().add(txt_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 590, 260, -1));

        lbl_stok2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok2.setText("Bayar");
        getContentPane().add(lbl_stok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 570, -1, -1));

        lbl_stok3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok3.setText("Kembalian");
        getContentPane().add(lbl_stok3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 630, -1, -1));

        lbl_stok4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok4.setText("Total");
        getContentPane().add(lbl_stok4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 630, -1, -1));

        lbl_stok5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok5.setText("Jumlah");
        getContentPane().add(lbl_stok5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, -1, -1));

        btn_transaksipembelian.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_transaksipembelian.setText("Transaksi Pembelian");
        btn_transaksipembelian.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_transaksipembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksipembelianActionPerformed(evt);
            }
        });
        getContentPane().add(btn_transaksipembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, 30));

        btn_cari.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Search.png"))); // NOI18N
        btn_cari.setText("Cari");
        btn_cari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 220, 130, 30));

        btn_struk.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_struk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Print (1).png"))); // NOI18N
        btn_struk.setText("Struk");
        btn_struk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_struk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_strukActionPerformed(evt);
            }
        });
        getContentPane().add(btn_struk, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 590, 130, -1));

        tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabel_barang);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1032, 260, 290, 300));
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, -1, -1));

        gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Administrator Male (1).png"))); // NOI18N
        getContentPane().add(gambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 50, 190, 120));

        btn_dashboard.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        btn_dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Performance Macbook.png"))); // NOI18N
        btn_dashboard.setText("Dashboard");
        btn_dashboard.setContentAreaFilled(false);
        btn_dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_dashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btn_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, -1));

        btn_datamaster.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_datamaster.setForeground(new java.awt.Color(255, 255, 255));
        btn_datamaster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Master.png"))); // NOI18N
        btn_datamaster.setText("Data Master");
        btn_datamaster.setContentAreaFilled(false);
        btn_datamaster.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_datamaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_datamasterActionPerformed(evt);
            }
        });
        getContentPane().add(btn_datamaster, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 210, -1));

        btn_transaksi.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        btn_transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Transaction (1).png"))); // NOI18N
        btn_transaksi.setText("Transaksi");
        btn_transaksi.setContentAreaFilled(false);
        btn_transaksi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 200, -1));

        btn_return.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_return.setForeground(new java.awt.Color(255, 255, 255));
        btn_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Return (1).png"))); // NOI18N
        btn_return.setText("Return");
        btn_return.setContentAreaFilled(false);
        btn_return.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        getContentPane().add(btn_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 200, -1));

        btn_opname.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_opname.setForeground(new java.awt.Color(255, 255, 255));
        btn_opname.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Move Stock.png"))); // NOI18N
        btn_opname.setText("Opname");
        btn_opname.setContentAreaFilled(false);
        btn_opname.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_opname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_opnameActionPerformed(evt);
            }
        });
        getContentPane().add(btn_opname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 200, -1));

        btn_laporan.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_laporan.setForeground(new java.awt.Color(255, 255, 255));
        btn_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Graph Report.png"))); // NOI18N
        btn_laporan.setText("Laporan");
        btn_laporan.setContentAreaFilled(false);
        btn_laporan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 200, -1));

        btn_logout.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logout (1).png"))); // NOI18N
        btn_logout.setText("Log Out");
        btn_logout.setContentAreaFilled(false);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 200, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_idpelanggan.setText("jFormattedTextField3");
        txt_idpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idpelangganActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idpelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 200, -1, -1));

        txt_idakun.setText("jFormattedTextField3");
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 200, -1, -1));

        txt_idbarang.setText("jFormattedTextField2");
        getContentPane().add(txt_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 180, -1, -1));

        txt_tanggal.setText("jFormattedTextField4");
        getContentPane().add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 170, -1, -1));

        txt_idtransaksi.setText("jFormattedTextField1");
        getContentPane().add(txt_idtransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 190, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

@SuppressWarnings("empty-statement")
    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed

    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_hargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargajualActionPerformed

    }//GEN-LAST:event_txt_hargajualActionPerformed

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
      
    }//GEN-LAST:event_txt_jumlahActionPerformed

    private void txt_subtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_subtotalActionPerformed

    }//GEN-LAST:event_txt_subtotalActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_namapelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namapelangganActionPerformed
      
    }//GEN-LAST:event_txt_namapelangganActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
String jumlah = txt_jumlah.getText(); 
String namabarang = txt_namabarang.getText();
String hargajual = txt_hargajual.getText();  
if (namabarang.isEmpty() || jumlah.isEmpty() || hargajual.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Nama barang, harga barang, jumlah harus diisi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (namabarang.length() < 5 || namabarang.length() > 50) {
    JOptionPane.showMessageDialog(null, "Panjang nama barang harus antara 5 hingga 50 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!namabarang.matches("[a-zA-Z0-9\"\\s.]+")) {
    JOptionPane.showMessageDialog(null, "Nama barang hanya boleh terdiri dari huruf, angka, spasi, tanda petik (\") dan titik (.)", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (hargajual.length() < 4 || hargajual.length() > 9) {
    JOptionPane.showMessageDialog(null, "Panjang harga jual harus antara 4 hingga 9 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!hargajual.matches("[0-9]+")) {
    JOptionPane.showMessageDialog(null, "Harga jual hanya boleh terdiri dari angka", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (jumlah.length() < 1 || jumlah.length() > 2) {
    JOptionPane.showMessageDialog(null, "Panjang jumlah harus antara 1 hingga 2 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!jumlah.matches("[0-9]+")) {
    JOptionPane.showMessageDialog(null, "Jumlah hanya boleh terdiri dari angka", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} 
    tambahtransaksi();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int row = tabel.getSelectedRow();
        model.removeRow(row);
        clear2();
        total();
        txt_bayar.setText("0");
        txt_kembalian.setText("0");
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        try {
    String username = txt_username.getText(); 
    String bayar = txt_bayar.getText();
    String pelanggan = txt_namapelanggan.getText();
    if (username.isEmpty() || bayar.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username, nama pelanggan, dan bayar harus diisi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (username.length() < 5 || username.length() > 15) {
        JOptionPane.showMessageDialog(null, "Panjang username harus antara 5 hingga 15 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!username.matches("^[a-zA-Z]+$")) {
        JOptionPane.showMessageDialog(null, "Username hanya boleh terdiri dari huruf", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (bayar.length() < 4 || bayar.length() > 9) {
        JOptionPane.showMessageDialog(null, "Panjang bayar harus antara 4 hingga 9 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!bayar.matches("[0-9]+")) {
        JOptionPane.showMessageDialog(null, "Harga jual hanya boleh terdiri dari angka", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (pelanggan.length() < 5 || pelanggan.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang nama pelanggan harus antara 5 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!pelanggan.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "Nama pelanggan harus terdiri dari huruf dan spasi saja.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        }

    int Total, Bayar, Kembalian;
    Total = Integer.parseInt(txt_total.getText());
    Bayar = Integer.parseInt(txt_bayar.getText());
    System.out.println("Total: " + Total);
    System.out.println("Bayar: " + Bayar);
    if (Total > Bayar) {
        JOptionPane.showMessageDialog(null, "Uang Tidak Cukup Untuk Melakukan Pembayaran");
    } else {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin melakukan pembayaran?", "Konfirmasi", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            Kembalian = Bayar - Total;
            System.out.println("Kembalian: " + Kembalian);
            txt_kembalian.setText(String.valueOf(Kembalian));
            DefaultTableModel model = (DefaultTableModel) tabel.getModel();
            String Id_transaksi = txt_idtransaksi.getText();
            String Id_akun = txt_idakun.getText();
            String Id_pelanggan = txt_idpelanggan.getText();
            String TotalString = txt_total.getText();
            String Tanggal = txt_tanggal.getText();
            System.out.println(Id_transaksi + " " + Id_akun + " " + Id_pelanggan + " " + Total + " " + Tanggal);
            try {
                Connection c = Config.configDB();
                String sql = "INSERT INTO transaksi_penjualan (id_transaksi, id_akun, id_pelanggan, total, tanggal) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, Integer.parseInt(Id_transaksi));
                p.setInt(2, Integer.parseInt(Id_akun));
                p.setInt(3, Integer.parseInt(Id_pelanggan));
                p.setInt(4, Total);
                p.setString(5, Tanggal);
                p.executeUpdate();
                p.close();
            } catch (Exception e) {
                System.out.println("Simpan Pembelian Error 1: " + e);
            }

            try {
                Connection c = Config.configDB();
                int baris = tabel.getRowCount();
                for (int i = 0; i < baris; i++) {
                    String sql = "INSERT INTO detail_transaksi_penjualan (id_transaksi, id_barang, barang, harga, satuan, jumlah, subtotal) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement p = c.prepareStatement(sql);
                    
                    p.setString(1,  tabel.getValueAt(i, 0).toString());
                    p.setString(2,  tabel.getValueAt(i, 1).toString());
                    p.setString(3,  tabel.getValueAt(i, 2).toString());
                    p.setString(4,  tabel.getValueAt(i, 3).toString());
                    p.setString(5,  tabel.getValueAt(i, 4).toString());
                    p.setString(6,  tabel.getValueAt(i, 5).toString());
                    p.setString(7,  tabel.getValueAt(i, 6).toString());
                    p.executeUpdate();
                    p.close();
                }
            } catch (Exception e) {
                System.out.println("Simpan Pembelian Error 2: " + e);
            }
            
            clear1();
            utama();
            kosong();
            
            try {
                Connection c = Config.configDB();
                String sql = "SELECT * FROM transaksi_penjualan ORDER BY id_transaksi DESC LIMIT 1";
                System.out.println(sql);
                java.sql.Statement stm = c.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                if (res.next()) {
                    String noBaru = String.valueOf(res.getInt("id_transaksi") + 1);
                    txt_idtransaksi.setText(noBaru);
                } else {
                    txt_idtransaksi.setText("1");
                }
                res.close();
                stm.close();
                c.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Masukkan Angka Yang Valid");
    txt_bayar.setText("0");
    txt_kembalian.setText("0");
}
        
    }//GEN-LAST:event_btn_bayarActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        try{
            int baris = tabel.rowAtPoint(evt.getPoint());
            Connection conn = Config.configDB();
            Statement stm = conn.createStatement();
            String id_barang = tabel.getValueAt(baris, 0).toString();
            txt_idtransaksi.setText(id_barang);
            System.out.println(id_barang);
            txt_idtransaksi.setEnabled(false);
            txt_idbarang.setText(tabel.getValueAt(baris, 1) == null ? "" : tabel.getValueAt(baris, 1).toString());
            txt_namabarang.setText(tabel.getValueAt(baris, 2) == null ? "" : tabel.getValueAt(baris, 2).toString());
            txt_hargajual.setText(tabel.getValueAt(baris, 3) == null ? "" : tabel.getValueAt(baris, 3).toString());
            cmb_satuan.setSelectedItem(tabel.getValueAt(baris, 4) == null ? "" : tabel.getValueAt(baris, 4).toString());
            txt_jumlah.setText(tabel.getValueAt(baris, 5) == null ? "" : tabel.getValueAt(baris, 5).toString());
            txt_subtotal.setText(tabel.getValueAt(baris,6) == null ? "" : tabel.getValueAt(baris, 6).toString());
        }
        catch(SQLException ex){
            Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
   
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_kembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kembalianActionPerformed

    }//GEN-LAST:event_txt_kembalianActionPerformed

    private void txt_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bayarActionPerformed
   
    }//GEN-LAST:event_txt_bayarActionPerformed

    private void txt_namabarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namabarangKeyReleased
        String Nama = txt_namabarang.getText();
    try {
        String sql = "SELECT * FROM barang WHERE barang = ?";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, Nama);
        java.sql.ResultSet res = stm.executeQuery();
        if (res.next()) {
            txt_namabarang.setText(res.getString("barang"));
            txt_idbarang.setText(res.getString("Id_barang"));
            txt_hargajual.setText(res.getString("harga"));
            cmb_satuan.setSelectedItem(res.getString("satuan"));
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    }//GEN-LAST:event_txt_namabarangKeyReleased

    private void txt_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyReleased
        String Nama = txt_username.getText();
    try {
        String sql = "SELECT * FROM akun WHERE username = ?";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, Nama);
        java.sql.ResultSet res = stm.executeQuery();
        if (res.next()) {
            txt_username.setText(res.getString("username"));
            txt_idakun.setText(res.getString("Id_akun"));
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    }//GEN-LAST:event_txt_usernameKeyReleased

    private void txt_namapelangganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namapelangganKeyReleased
        String Nama = txt_namapelanggan.getText();
    try {
        String sql = "SELECT * FROM pelanggan WHERE pelanggan = ?";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, Nama);
        java.sql.ResultSet res = stm.executeQuery();
        if (res.next()) {
            txt_namapelanggan.setText(res.getString("pelanggan"));
            txt_idpelanggan.setText(res.getString("Id_pelanggan"));
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    }//GEN-LAST:event_txt_namapelangganKeyReleased

    private void txt_idpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idpelangganActionPerformed
       
    }//GEN-LAST:event_txt_idpelangganActionPerformed

    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyReleased
        int Harga = Integer.parseInt(txt_hargajual.getText());
        int Jumlah = Integer.parseInt(txt_jumlah.getText());
        String Hasil = "" + (Harga * Jumlah);
        txt_subtotal.setText(Hasil);
    }//GEN-LAST:event_txt_jumlahKeyReleased

    private void txt_bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bayarKeyReleased
        int Total = Integer.parseInt(txt_total.getText());
        int Bayar = Integer.parseInt(txt_bayar.getText());
        String Hasil = "" + (Bayar - Total);
        txt_kembalian.setText(Hasil);
    }//GEN-LAST:event_txt_bayarKeyReleased

    private void btn_transaksipembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksipembelianActionPerformed
        this.setVisible(false);
        new Transaksi_Pembelian().setVisible(true);
    }//GEN-LAST:event_btn_transaksipembelianActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        try {
            Connection conn = Config.configDB();
            Statement statement = conn.createStatement();
            String searchKeyword = txt_namabarang.getText();
            ResultSet res = statement.executeQuery("SELECT * FROM barang WHERE barang LIKE '%" + searchKeyword 
                    + "%'");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Barang");
            tabel_barang.setModel(model);
            int no = 1;
            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString("Barang"),
                 });
                no++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Gagal Mengambil Data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_cariActionPerformed

    private void tabel_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barangMouseClicked
        try{                                          
            int baris = tabel_barang.rowAtPoint(evt.getPoint());
            Connection conn = Config.configDB();
            Statement stm = conn.createStatement();
            String nama_barang = tabel_barang.getValueAt(baris, 0).toString();
            txt_namabarang.setText(nama_barang);
            System.out.println(nama_barang);
        }
        catch(SQLException ex){
            Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabel_barangMouseClicked

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_datamasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datamasterActionPerformed
        this.setVisible(false);
        new Akun().setVisible(true);
    }//GEN-LAST:event_btn_datamasterActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed

    }//GEN-LAST:event_btn_transaksiActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        this.setVisible(false);
        new Return_Pelanggan().setVisible(true);
    }//GEN-LAST:event_btn_returnActionPerformed

    private void btn_opnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opnameActionPerformed
        this.setVisible(false);
        new Opname().setVisible(true);
    }//GEN-LAST:event_btn_opnameActionPerformed

    private void btn_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanActionPerformed
        this.setVisible(false);
        new Laporan_Transaksi_Penjualan().setVisible(true);
    }//GEN-LAST:event_btn_laporanActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_strukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_strukActionPerformed
// try{
     //       String file = "/struk/struk_1.jasper";
            
      //      Class.forName("com.mysql.jdbc.Driver").newInstance();
      //      HashMap param = new HashMap();
            
     //       param.put("subtotal",txt_subtotal.getText());
     //       param.put("total",txt_total.getText());
     //       param.put("bayar",txt_bayar.getText());
     //       param.put("kembalian",txt_kembalian.getText());
            
    //        JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file),param,Config.configDB());
    //        JasperViewer.viewReport(print, false);
            
   //     }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | JRException e){
   //         System.out.println(e);
            
 //      }        // TODO add your handling code her
    }//GEN-LAST:event_btn_strukActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi_Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_datamaster;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_opname;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_struk;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JButton btn_transaksipembelian;
    private javax.swing.JComboBox<String> cmb_satuan;
    private javax.swing.JLabel gambar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_hargabeli;
    private javax.swing.JLabel lbl_hargajual;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_namabarang;
    private javax.swing.JLabel lbl_namabarang1;
    private javax.swing.JLabel lbl_namabarang2;
    private javax.swing.JLabel lbl_stok;
    private javax.swing.JLabel lbl_stok2;
    private javax.swing.JLabel lbl_stok3;
    private javax.swing.JLabel lbl_stok4;
    private javax.swing.JLabel lbl_stok5;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JTable tabel;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JFormattedTextField txt_bayar;
    private javax.swing.JFormattedTextField txt_hargajual;
    private javax.swing.JFormattedTextField txt_idakun;
    private javax.swing.JFormattedTextField txt_idbarang;
    private javax.swing.JFormattedTextField txt_idpelanggan;
    private javax.swing.JFormattedTextField txt_idtransaksi;
    private javax.swing.JFormattedTextField txt_jumlah;
    private javax.swing.JFormattedTextField txt_kembalian;
    private javax.swing.JFormattedTextField txt_namabarang;
    private javax.swing.JFormattedTextField txt_namapelanggan;
    private javax.swing.JFormattedTextField txt_subtotal;
    private javax.swing.JFormattedTextField txt_tanggal;
    private javax.swing.JFormattedTextField txt_total;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}