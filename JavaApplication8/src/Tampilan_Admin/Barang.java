package Tampilan_Admin;

import Config.Config;
import Tampilan_Awal.Absen;
import Tampilan_Awal.Login;
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
import javax.swing.table.DefaultTableModel;

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
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", new Locale("id", "ID"));
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
//    cmb_satuan.setSelectedItem(null);
//    txt_namasupplier.setText(null);
//    txt_stok.setText(null);
//     txt_merek.setText(null);
//    cmb_kategori.setSelectedItem(null);
}

// Mengisi tabel barang
private void tabel_Barang() {
    model = new DefaultTableModel();
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Kategori");
    model.addColumn("Merek");
    model.addColumn("Satuan");
    model.addColumn("Harga");
    model.addColumn("Stok");
    model.addColumn("Id Supplier");
    model.addColumn("Nama Supplier");
    model.addColumn("Tanggal Masuk");

    try {
        String sql = "SELECT barang.id_barang, barang.nama_barang, barang.kategori, barang.merek, barang.satuan, barang.harga, barang.stok, barang.id_supplier, barang.nama_supplier, barang.tanggal_masuk FROM barang";
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id_barang"),
                res.getString("nama_barang"),
                res.getString("kategori"),
                res.getString("merek"),
                res.getString("satuan"),
                res.getString("harga"),
                res.getString("stok"),
                res.getString("id_supplier"),
                res.getString("nama_supplier"),
                res.getString("tanggal_masuk"),
            });
        }
        tabel_barang.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal mengisi tabel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_tanggal = new javax.swing.JLabel();
        bab = new javax.swing.JLabel();
        btn_logout2 = new javax.swing.JButton();
        lbl_namasupplier = new javax.swing.JLabel();
        txt_namasupplier = new javax.swing.JFormattedTextField();
        lbl_hargajual = new javax.swing.JLabel();
        lbl_stok = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
        btn_edit = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        txt_stok = new javax.swing.JFormattedTextField();
        txt_hargajual = new javax.swing.JFormattedTextField();
        lbl_kategori = new javax.swing.JLabel();
        lbl_hargabeli = new javax.swing.JLabel();
        lbl_namabarang = new javax.swing.JLabel();
        txt_namabarang = new javax.swing.JFormattedTextField();
        cmb_satuan = new javax.swing.JComboBox<>();
        lbl_hargajual1 = new javax.swing.JLabel();
        txt_idsupplier = new javax.swing.JFormattedTextField();
        lbl_hargajual2 = new javax.swing.JLabel();
        txt_merek = new javax.swing.JFormattedTextField();
        btn_dashboard = new javax.swing.JButton();
        btn_datamaster = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_opname = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        btn_akun = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btn_pelanggan = new javax.swing.JButton();
        txt_kategori = new javax.swing.JFormattedTextField();
        lbl_image1 = new javax.swing.JLabel();
        txt_idbarang = new javax.swing.JFormattedTextField();
        txt_tanggalmasuk = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setForeground(new java.awt.Color(255, 255, 255));
        bab.setText("Hai Admin, Selamat Datang Di Data Barang");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1120, 50));

        btn_logout2.setBackground(new java.awt.Color(255, 255, 255));
        btn_logout2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_logout2.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout2.setText("Log Out");
        btn_logout2.setContentAreaFilled(false);
        btn_logout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 200, -1));

        lbl_namasupplier.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namasupplier.setText("Nama Supplier");
        getContentPane().add(lbl_namasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        txt_namasupplier.setText("Pt Elektronik");
        txt_namasupplier.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_namasupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namasupplierActionPerformed(evt);
            }
        });
        txt_namasupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_namasupplierKeyReleased(evt);
            }
        });
        getContentPane().add(txt_namasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 310, -1));

        lbl_hargajual.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargajual.setText("Merek");
        getContentPane().add(lbl_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, -1, -1));

        lbl_stok.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok.setText("Stok");
        getContentPane().add(lbl_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 100, -1, -1));

        tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Supplier", "Nama Supplier", "Telepon", "Alamat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_barang.getTableHeader().setReorderingAllowed(false);
        tabel_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_barang);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 260, 1070, 400));

        btn_edit.setBackground(new java.awt.Color(255, 255, 255));
        btn_edit.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Pencil (1).png"))); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 220, 140, 30));

        btn_tambah.setBackground(new java.awt.Color(255, 255, 255));
        btn_tambah.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Plus Math (1).png"))); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 220, 140, -1));

        btn_hapus.setBackground(new java.awt.Color(255, 255, 255));
        btn_hapus.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Delete (1).png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 220, 140, -1));

        txt_stok.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stokActionPerformed(evt);
            }
        });
        getContentPane().add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 120, 140, -1));

        txt_hargajual.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_hargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargajualActionPerformed(evt);
            }
        });
        getContentPane().add(txt_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 180, 140, -1));

        lbl_kategori.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_kategori.setText("Kategori");
        getContentPane().add(lbl_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        lbl_hargabeli.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargabeli.setText("Satuan");
        getContentPane().add(lbl_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        lbl_namabarang.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namabarang.setText("Nama Barang");
        getContentPane().add(lbl_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        txt_namabarang.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarangActionPerformed(evt);
            }
        });
        getContentPane().add(txt_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 310, -1));

        cmb_satuan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        cmb_satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pcs" }));
        getContentPane().add(cmb_satuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 140, 30));

        lbl_hargajual1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargajual1.setText("Id Supplier");
        getContentPane().add(lbl_hargajual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, -1, -1));

        txt_idsupplier.setText("1");
        txt_idsupplier.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_idsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idsupplierActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 140, -1));

        lbl_hargajual2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargajual2.setText("Harga Jual");
        getContentPane().add(lbl_hargajual2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 160, -1, -1));

        txt_merek.setText("Samsung");
        txt_merek.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_merek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_merekActionPerformed(evt);
            }
        });
        getContentPane().add(txt_merek, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, 140, -1));

        btn_dashboard.setBackground(new java.awt.Color(255, 255, 255));
        btn_dashboard.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        btn_dashboard.setText("Dashboard");
        btn_dashboard.setContentAreaFilled(false);
        btn_dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btn_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, -1));

        btn_datamaster.setBackground(new java.awt.Color(255, 255, 255));
        btn_datamaster.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_datamaster.setForeground(new java.awt.Color(255, 255, 255));
        btn_datamaster.setText("Data Master");
        btn_datamaster.setContentAreaFilled(false);
        btn_datamaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_datamasterActionPerformed(evt);
            }
        });
        getContentPane().add(btn_datamaster, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, -1));

        btn_transaksi.setBackground(new java.awt.Color(255, 255, 255));
        btn_transaksi.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        btn_transaksi.setText("Transaksi");
        btn_transaksi.setContentAreaFilled(false);
        btn_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksiActionPerformed(evt);
            }
        });
        getContentPane().add(btn_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 200, -1));

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
        btn_return.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_return.setForeground(new java.awt.Color(255, 255, 255));
        btn_return.setText("Return");
        btn_return.setContentAreaFilled(false);
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });
        getContentPane().add(btn_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 200, -1));

        btn_opname.setBackground(new java.awt.Color(255, 255, 255));
        btn_opname.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_opname.setForeground(new java.awt.Color(255, 255, 255));
        btn_opname.setText("Opname");
        btn_opname.setContentAreaFilled(false);
        btn_opname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_opnameActionPerformed(evt);
            }
        });
        getContentPane().add(btn_opname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 200, -1));

        btn_laporan.setBackground(new java.awt.Color(255, 255, 255));
        btn_laporan.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_laporan.setForeground(new java.awt.Color(255, 255, 255));
        btn_laporan.setText("Laporan");
        btn_laporan.setContentAreaFilled(false);
        btn_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 200, -1));

        btn_akun.setBackground(new java.awt.Color(255, 255, 255));
        btn_akun.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_akun.setText("Data Akun");
        btn_akun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_akunActionPerformed(evt);
            }
        });
        getContentPane().add(btn_akun, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 180, 30));

        btn_supplier.setBackground(new java.awt.Color(255, 255, 255));
        btn_supplier.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_supplier.setText("Data Supplier");
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 180, 30));

        btn_pelanggan.setBackground(new java.awt.Color(255, 255, 255));
        btn_pelanggan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_pelanggan.setText("Data Pelanggan");
        btn_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pelangganActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 180, 30));

        txt_kategori.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kategoriActionPerformed(evt);
            }
        });
        getContentPane().add(txt_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 140, -1));

        lbl_image1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_idbarang.setText("jFormattedTextField1");
        getContentPane().add(txt_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, -1, 30));

        txt_tanggalmasuk.setText("jFormattedTextField1");
        getContentPane().add(txt_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, 240, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout2ActionPerformed
        this.setVisible(false);
            new Login().setVisible(true);
    }//GEN-LAST:event_btn_logout2ActionPerformed

    private void txt_namasupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namasupplierActionPerformed

    }//GEN-LAST:event_txt_namasupplierActionPerformed

    private void tabel_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barangMouseClicked
        try{
            int baris = tabel_barang.rowAtPoint(evt.getPoint());
            Connection conn = Config.configDB();
            Statement stm = conn.createStatement();
            String id_barang = tabel_barang.getValueAt(baris, 0).toString();
            txt_idbarang.setText(id_barang);
            System.out.println(id_barang);
            txt_idbarang.setEnabled(false);
            txt_namabarang.setText(tabel_barang.getValueAt(baris, 1) == null ? "" : tabel_barang.getValueAt(baris, 1).toString());
            txt_kategori.setText(tabel_barang.getValueAt(baris, 2) == null ? "" : tabel_barang.getValueAt(baris, 2).toString());
            txt_merek.setText(tabel_barang.getValueAt(baris, 3) == null ? "" : tabel_barang.getValueAt(baris, 3).toString());
            cmb_satuan.setSelectedItem(tabel_barang.getValueAt(baris, 4) == null ? "" : tabel_barang.getValueAt(baris, 4).toString());
            txt_hargajual.setText(tabel_barang.getValueAt(baris, 5) == null ? "" : tabel_barang.getValueAt(baris, 5).toString());
            txt_stok.setText(tabel_barang.getValueAt(baris, 6) == null ? "" : tabel_barang.getValueAt(baris, 6).toString());
            txt_idsupplier.setText(tabel_barang.getValueAt(baris, 7) == null ? "" : tabel_barang.getValueAt(baris, 7).toString());
            txt_namasupplier.setText(tabel_barang.getValueAt(baris,8) == null ? "" : tabel_barang.getValueAt(baris, 8).toString());
            txt_tanggalmasuk.setText(tabel_barang.getValueAt(baris,9) == null ? "" : tabel_barang.getValueAt(baris, 9).toString());
        }
        catch(SQLException ex){
            Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabel_barangMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengedit data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String namabarang = txt_namabarang.getText();
        String hargajual = txt_hargajual.getText();
        String satuan = (String) cmb_satuan.getSelectedItem();
        String kategori = txt_kategori.getText();
        String stok = txt_stok.getText();
        String tanggal = txt_tanggalmasuk.getText();
        String namasupplier = txt_namasupplier.getText();
        String idbarang = txt_idbarang.getText();
        String idsupplier = txt_idsupplier.getText();
        String merek = txt_merek.getText();
        Connection conn = Config.configDB();
        if (namabarang.isEmpty() || merek.isEmpty() || hargajual.isEmpty() || stok.isEmpty() || namasupplier.isEmpty() || kategori.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (namabarang.length() < 5 || namabarang.length() > 50) {
            JOptionPane.showMessageDialog(null, "Panjang nama barang harus antara 5 hingga 50 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!namabarang.matches("[a-zA-Z0-9\"\\s.]+")) {
            JOptionPane.showMessageDialog(null, "Nama barang hanya boleh terdiri dari huruf, angka, spasi, tanda petik (\") dan titik (.)", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (merek.length() < 2 || merek.length() > 10) {
            JOptionPane.showMessageDialog(null, "Panjang merek harus antara 2 hingga 10 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!merek.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Merek hanya boleh terdiri dari huruf", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hargajual.length() < 4 || hargajual.length() > 8) {
            JOptionPane.showMessageDialog(null, "Panjang harga jual harus antara 4 hingga 8 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!hargajual.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Harga jual hanya boleh terdiri dari angka", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (stok.length() < 1 || stok.length() > 3) {
            JOptionPane.showMessageDialog(null, "Panjang stok harus antara 1 hingga 3 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!stok.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Stok hanya boleh terdiri dari angka", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (namasupplier.length() < 5 || namasupplier.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang nama supplier harus antara 5 hingga 30 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!namasupplier.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "Nama supplier hanya boleh terdiri dari huruf dan spasi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (kategori.length() < 2 || kategori.length() > 20) {
            JOptionPane.showMessageDialog(null, "Panjang kategori harus antara 2 hingga 20 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!kategori.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "Kategori hanya boleh terdiri dari huruf dan spasi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String checkSql = "SELECT * FROM barang WHERE nama_barang = ? AND kategori = ? AND harga = ? AND merek = ? AND id_barang != ?";
        PreparedStatement checkPst = conn.prepareStatement(checkSql);
        checkPst.setString(1, namabarang);
        checkPst.setString(2, kategori);
        checkPst.setString(3, hargajual);
        checkPst.setString(4, merek);
        checkPst.setString(5, idbarang);
        ResultSet rs = checkPst.executeQuery();
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Barang dengan nama, kategori, harga, dan merek yang sama sudah ada di database", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String sql = "UPDATE barang SET nama_barang=?, kategori=?, merek=?, satuan=?, harga=?, stok=?, id_supplier=?, nama_supplier=?, tanggal_masuk=? WHERE id_barang=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, namabarang);
        pst.setString(2, kategori);
        pst.setString(3, merek);
        pst.setString(4, satuan);
        pst.setString(5, hargajual);
        pst.setString(6, stok);
        pst.setString(7, idsupplier);
        pst.setString(8, namasupplier);
        pst.setString(9, tanggal);
        pst.setString(10, idbarang);
        pst.executeUpdate();
        String notif = "Data berhasil diedit\n\n"
                + "Nama Barang: " + namabarang + "\n"
                + "Harga Jual: " + hargajual + "\n"
                + "Kategori: " + kategori + "\n"
                + "Merek: " + merek + "\n"
                + "Satuan: " + satuan + "\n"
                + "Stok: " + stok + "\n"
                + "Nama Supplier: " + namasupplier;
        JOptionPane.showMessageDialog(null, notif, "Sukses", JOptionPane.INFORMATION_MESSAGE);
        tabel_Barang();
        kosong1();
        txt_idbarang.setText(getNextIdBarang());
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_editActionPerformed
    
    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menambahkan barang?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
if (konfirmasi == JOptionPane.YES_OPTION) {
    try {
        String idbarang = txt_idbarang.getText(); 
        String namabarang = txt_namabarang.getText();
        String hargajual = txt_hargajual.getText(); 
        String satuan = (String) cmb_satuan.getSelectedItem(); 
        String stok = txt_stok.getText(); 
        String kategori = txt_kategori.getText();
        String tanggal = txt_tanggalmasuk.getText(); 
        String idsupplier = txt_idsupplier.getText(); 
        String namasupplier = txt_namasupplier.getText(); 
        String merek = txt_merek.getText();
        if (namabarang.isEmpty() || merek.isEmpty() || hargajual.isEmpty() || stok.isEmpty() || namasupplier.isEmpty() || kategori.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Semua kolom harus diisi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (namabarang.length() < 5 || namabarang.length() > 50) {
    JOptionPane.showMessageDialog(null, "Panjang nama barang harus antara 5 hingga 50 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!namabarang.matches("[a-zA-Z0-9\"\\s.]+")) {
    JOptionPane.showMessageDialog(null, "Nama barang hanya boleh terdiri dari huruf, angka, spasi, tanda petik (\") dan titik (.)", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (merek.length() < 1 || merek.length() > 10) {
    JOptionPane.showMessageDialog(null, "Panjang merek harus antara 1 hingga 10 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!merek.matches("[a-zA-Z]+")) {
    JOptionPane.showMessageDialog(null, "Merek hanya boleh terdiri dari huruf", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (hargajual.length() < 4 || hargajual.length() > 9) {
    JOptionPane.showMessageDialog(null, "Panjang harga jual harus antara 4 hingga 9 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!hargajual.matches("[0-9]+")) {
    JOptionPane.showMessageDialog(null, "Harga jual hanya boleh terdiri dari angka", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (stok.length() < 1 || stok.length() > 3) {
    JOptionPane.showMessageDialog(null, "Panjang stok harus antara 1 hingga 3 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!stok.matches("[0-9]+")) {
    JOptionPane.showMessageDialog(null, "Stok hanya boleh terdiri dari angka", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (namasupplier.length() < 5 || namasupplier.length() > 30) {
    JOptionPane.showMessageDialog(null, "Panjang nama supplier harus antara 5 hingga 30 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!namasupplier.matches("[a-zA-Z ]+")) {
    JOptionPane.showMessageDialog(null, "Nama supplier hanya boleh terdiri dari huruf dan spasi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (kategori.length() < 2 || kategori.length() > 20) {
    JOptionPane.showMessageDialog(null, "Panjang kategori harus antara 2 hingga 20 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!kategori.matches("[a-zA-Z ]+")) {
    JOptionPane.showMessageDialog(null, "Kategori hanya boleh terdiri dari huruf dan spasi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
}
        Connection conn = Config.configDB();
        String checkSql = "SELECT * FROM barang WHERE nama_barang = ? AND kategori = ? AND harga = ? AND merek = ?";
        PreparedStatement checkPst = conn.prepareStatement(checkSql);
        checkPst.setString(1, namabarang);
        checkPst.setString(2, kategori);
        checkPst.setString(3, hargajual);
        checkPst.setString(4, merek);
        ResultSet rs = checkPst.executeQuery();
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "Barang dengan nama, kategori, harga, dan merek yang sama sudah ada di database", "Error", JOptionPane.ERROR_MESSAGE);
            return; // 
        }
        String insertSql = "INSERT INTO barang (id_barang, nama_barang, kategori, merek, satuan, harga, stok, id_supplier, nama_supplier, tanggal_masuk) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertPst = conn.prepareStatement(insertSql);
        insertPst.setString(1, idbarang);
        insertPst.setString(2, namabarang);
        insertPst.setString(3, kategori);
        insertPst.setString(4, merek);
        insertPst.setString(5, satuan);
        insertPst.setString(6, hargajual);
        insertPst.setString(7, stok);
        insertPst.setString(8, idsupplier);
        insertPst.setString(9, namasupplier);
        insertPst.setString(10, tanggal);
        insertPst.execute();
        String notif = "Data berhasil ditambah\n\n"
                + "Nama Barang: " + namabarang + "\n"
                + "Harga Jual: " + hargajual + "\n"
                + "Kategori: " + kategori + "\n"
                + "Merek: " + merek + "\n"
                + "Satuan: " + satuan + "\n"
                + "Stok: " + stok + "\n"
                + "Nama Supplier: " + namasupplier + "\n"
                + "Tanggal Masuk: " + tanggal;
        JOptionPane.showMessageDialog(null, notif, "Sukses", JOptionPane.INFORMATION_MESSAGE);
        tabel_Barang();
        txt_idbarang.setText(getNextIdBarang()); 
        kosong1();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
} else {
    JOptionPane.showMessageDialog(null, "Penambahan barang dibatalkan");
}
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
        String idbarang = txt_idbarang.getText(); 
        String namabarang = txt_namabarang.getText();
        String hargajual = txt_hargajual.getText(); 
        String satuan = (String) cmb_satuan.getSelectedItem(); 
        String stok = txt_stok.getText(); 
        String kategori = txt_kategori.getText();
        String tanggal = txt_tanggalmasuk.getText(); 
        String idsupplier = txt_idsupplier.getText(); 
        String namasupplier = txt_namasupplier.getText(); 
        String merek = txt_merek.getText();
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String sqlbarang = "DELETE FROM barang WHERE id_barang=?";
                Connection conn = Config.configDB();
                PreparedStatement pstbarang = conn.prepareStatement(sqlbarang);
                pstbarang.setString(1, txt_idbarang.getText());
                pstbarang.executeUpdate();
                String notif = "Data berhasil dihapus\n\n"
                + "Nama Barang: " + namabarang + "\n"
                + "Harga Jual: " + hargajual + "\n"
                + "Kategori: " + kategori + "\n"
                + "Merek: " + merek + "\n"
                + "Satuan: " + satuan + "\n"
                + "Stok: " + stok + "\n"
                + "Nama Supplier: " + namasupplier + "\n"
                + "Tanggal Masuk: " + tanggal;
        JOptionPane.showMessageDialog(null, notif, "Sukses", JOptionPane.INFORMATION_MESSAGE);
                txt_idbarang.setText(getNextIdBarang());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        tabel_Barang();
        kosong1();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txt_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokActionPerformed
   
    }//GEN-LAST:event_txt_stokActionPerformed

    private void txt_hargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargajualActionPerformed
  
    }//GEN-LAST:event_txt_hargajualActionPerformed

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
  
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_namasupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namasupplierKeyReleased
        String Nama = txt_namasupplier.getText();
try {
    String sql = "SELECT * FROM supplier WHERE Nama_supplier = ?"; 
    java.sql.Connection conn = (Connection) Config.configDB();
    java.sql.PreparedStatement stm = conn.prepareStatement(sql);
    stm.setString(1, Nama); 
    java.sql.ResultSet res = stm.executeQuery(); 

    if (res.next()) {
        txt_idsupplier.setText(res.getString("id_Supplier")); 
    }
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage()); 
}
    }//GEN-LAST:event_txt_namasupplierKeyReleased

    private void txt_idsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idsupplierActionPerformed
    
    }//GEN-LAST:event_txt_idsupplierActionPerformed

    private void txt_merekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_merekActionPerformed

    }//GEN-LAST:event_txt_merekActionPerformed

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_datamasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datamasterActionPerformed
    
    }//GEN-LAST:event_btn_datamasterActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
        this.setVisible(false);
        new Transaksi_Penjualan_Admin().setVisible(true);
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
        new Laporan_Penjualan().setVisible(true);
    }//GEN-LAST:event_btn_laporanActionPerformed

    private void btn_akunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_akunActionPerformed
        this.setVisible(false);
        new Akun().setVisible(true);
    }//GEN-LAST:event_btn_akunActionPerformed

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        this.setVisible(false);
        new Supplier().setVisible(true);
    }//GEN-LAST:event_btn_supplierActionPerformed

    private void btn_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pelangganActionPerformed
        this.setVisible(false);
        new Pelanggan().setVisible(true);
    }//GEN-LAST:event_btn_pelangganActionPerformed

    private void txt_kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kategoriActionPerformed

    }//GEN-LAST:event_txt_kategoriActionPerformed

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
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_akun;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_datamaster;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout2;
    private javax.swing.JButton btn_opname;
    private javax.swing.JButton btn_pelanggan;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JComboBox<String> cmb_satuan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_hargabeli;
    private javax.swing.JLabel lbl_hargajual;
    private javax.swing.JLabel lbl_hargajual1;
    private javax.swing.JLabel lbl_hargajual2;
    private javax.swing.JLabel lbl_image1;
    private javax.swing.JLabel lbl_kategori;
    private javax.swing.JLabel lbl_namabarang;
    private javax.swing.JLabel lbl_namasupplier;
    private javax.swing.JLabel lbl_stok;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JFormattedTextField txt_hargajual;
    private javax.swing.JFormattedTextField txt_idbarang;
    private javax.swing.JFormattedTextField txt_idsupplier;
    private javax.swing.JFormattedTextField txt_kategori;
    private javax.swing.JFormattedTextField txt_merek;
    private javax.swing.JFormattedTextField txt_namabarang;
    private javax.swing.JFormattedTextField txt_namasupplier;
    private javax.swing.JFormattedTextField txt_stok;
    private javax.swing.JFormattedTextField txt_tanggalmasuk;
    // End of variables declaration//GEN-END:variables
}