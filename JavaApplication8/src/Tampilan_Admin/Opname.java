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
import javax.swing.JOptionPane;

public class Opname extends javax.swing.JFrame {
String Tanggal;
private DefaultTableModel model;

public void loaddata() {
    model = (DefaultTableModel) tabel.getModel();
    model.addRow(new Object[]{
        txt_idopname.getText(),
        txt_idbarang.getText(),
        txt_namabarang.getText(),
        txt_stoksistem.getText(),
        txt_stokfisik.getText(),
        txt_keterangan.getText()});
}

private void tabel_Barang() {
    model = new DefaultTableModel();
    model.addColumn("Nama Barang");

    try {
        String sql = "SELECT barang.nama_barang FROM barang";
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("nama_barang"),
            });
        }
        tabel_barang.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal mengisi tabel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void kosong() {
    model = (DefaultTableModel) tabel.getModel();
    while (model.getRowCount() > 0) {
        model.removeRow(0);
    }
}

public void utama() {
    txt_idbarang.setText("");
    txt_namabarang.setText("");
    txt_stoksistem.setText("");
    txt_stokfisik.setText("");
    txt_keterangan.setText("");
    txt_idopname.setText("");
}

public void clear1() {
    txt_idopname.setText("");
    txt_idakun.setText("");
    txt_username.setText("");
    txt_idbarang.setText("");
    txt_keterangan.setText("");
    txt_tanggal.setText("");
    txt_namabarang.setText("");
    txt_stokfisik.setText("");
    txt_stoksistem.setText("");
    txt_keterangan.setText("");
}

public void clear2() {
    txt_idbarang.setText("");
    txt_namabarang.setText("");
    txt_stoksistem.setText("");
    txt_keterangan.setText("");
    txt_stokfisik.setText("");
}

public void tambahtransaksi() {
    loaddata();
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

public Opname() {
    initComponents();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setTitle("Aplikasi Kasir - Toko Imanuel Jember");
    model = new DefaultTableModel();
    tabel.setModel(model);
    model.addColumn("Id Opname");
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Stok Sistem");
    model.addColumn("Stok Fisik");
    model.addColumn("Keterangan");
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(() -> {
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        txt_tanggal.setText(s.format(date));
        setTanggalDanWaktu();
        tabel_Barang();
    }, 0, 1, TimeUnit.SECONDS);
    try {
        String sql = "SELECT * FROM opname ORDER BY id_opname DESC LIMIT 1";
        System.out.println(sql);
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            String noBaru = "" + (res.getInt("id_opname") + 1);
            txt_idopname.setText(noBaru);
        } else {
            txt_idopname.setText("1");
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
        txt_stoksistem = new javax.swing.JFormattedTextField();
        lbl_hargabeli = new javax.swing.JLabel();
        txt_stokfisik = new javax.swing.JFormattedTextField();
        lbl_namabarang2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        txt_keterangan = new javax.swing.JFormattedTextField();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_simpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        lbl_stok5 = new javax.swing.JLabel();
        btn_cari = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        btn_laporan = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
        gambar = new javax.swing.JLabel();
        btn_dashboard = new javax.swing.JButton();
        btn_datamaster = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_opname = new javax.swing.JButton();
        btn_logout1 = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        txt_idbarang = new javax.swing.JFormattedTextField();
        txt_idopname = new javax.swing.JFormattedTextField();
        txt_tanggal = new javax.swing.JFormattedTextField();
        txt_idakun = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setForeground(new java.awt.Color(255, 255, 255));
        bab.setText("Hai Admin, Selamat Datang Di Opname");
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
        lbl_hargajual.setText("Stok Sistem");
        getContentPane().add(lbl_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        txt_stoksistem.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_stoksistem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stoksistemActionPerformed(evt);
            }
        });
        getContentPane().add(txt_stoksistem, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 140, -1));

        lbl_hargabeli.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargabeli.setText("Stok Fistem");
        getContentPane().add(lbl_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        txt_stokfisik.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_stokfisik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stokfisikActionPerformed(evt);
            }
        });
        txt_stokfisik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_stokfisikKeyReleased(evt);
            }
        });
        getContentPane().add(txt_stokfisik, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 140, -1));

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

        txt_keterangan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_keterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_keteranganActionPerformed(evt);
            }
        });
        txt_keterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_keteranganKeyReleased(evt);
            }
        });
        getContentPane().add(txt_keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, 330, -1));

        btn_tambah.setBackground(new java.awt.Color(255, 255, 255));
        btn_tambah.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Plus Math (1).png"))); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 220, 130, -1));

        btn_hapus.setBackground(new java.awt.Color(255, 255, 255));
        btn_hapus.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Delete (1).png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 220, 130, -1));

        btn_simpan.setBackground(new java.awt.Color(255, 255, 255));
        btn_simpan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Cash.png"))); // NOI18N
        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 130, -1));

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

        lbl_stok5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok5.setText("Keterangan");
        getContentPane().add(lbl_stok5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, -1, -1));

        btn_cari.setBackground(new java.awt.Color(255, 255, 255));
        btn_cari.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Search.png"))); // NOI18N
        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 130, 30));
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, -1, -1));

        btn_laporan.setBackground(new java.awt.Color(255, 255, 255));
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

        btn_logout.setBackground(new java.awt.Color(255, 255, 255));
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

        gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Administrator Male (1).png"))); // NOI18N
        getContentPane().add(gambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 50, 190, 120));

        btn_dashboard.setBackground(new java.awt.Color(255, 255, 255));
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

        btn_datamaster.setBackground(new java.awt.Color(255, 255, 255));
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

        btn_transaksi.setBackground(new java.awt.Color(255, 255, 255));
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

        btn_return.setBackground(new java.awt.Color(255, 255, 255));
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

        btn_opname.setBackground(new java.awt.Color(255, 255, 255));
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

        btn_logout1.setBackground(new java.awt.Color(255, 255, 255));
        btn_logout1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_logout1.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logout (1).png"))); // NOI18N
        btn_logout1.setText("Log Out");
        btn_logout1.setContentAreaFilled(false);
        btn_logout1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 200, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_idbarang.setText("jFormattedTextField2");
        getContentPane().add(txt_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 180, -1, -1));

        txt_idopname.setText("jFormattedTextField1");
        getContentPane().add(txt_idopname, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, -1, -1));

        txt_tanggal.setText("jFormattedTextField4");
        getContentPane().add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 170, -1, -1));

        txt_idakun.setText("jFormattedTextField3");
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

@SuppressWarnings("empty-statement")
    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed

    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_stoksistemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stoksistemActionPerformed
 
    }//GEN-LAST:event_txt_stoksistemActionPerformed

    private void txt_stokfisikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokfisikActionPerformed

    }//GEN-LAST:event_txt_stokfisikActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
   
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_keteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_keteranganActionPerformed
  
    }//GEN-LAST:event_txt_keteranganActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
String namaBarang = txt_namabarang.getText();
String stokFisik = txt_stokfisik.getText();
String stokSistem = txt_stoksistem.getText();
String keterangan = txt_keterangan.getText();
String username = txt_username.getText();

if (namaBarang.isEmpty() || stokSistem.isEmpty() || stokFisik.isEmpty() || keterangan.isEmpty() || username.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Semua kolom harus diisi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (namaBarang.length() < 5 || namaBarang.length() > 50) {
    JOptionPane.showMessageDialog(null, "Panjang nama barang harus antara 5 hingga 50 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!namaBarang.matches("[a-zA-Z0-9\"\\s.,]+")) {
    JOptionPane.showMessageDialog(null, "Nama barang hanya boleh terdiri dari huruf, angka, spasi, tanda petik (\") , titik (.) dan koma (,)", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!stokSistem.matches("[0-9]+")) {
    JOptionPane.showMessageDialog(null, "Stok sistem hanya boleh terdiri dari angka", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (stokFisik.length() < 1 || stokFisik.length() > 3 || !stokFisik.matches("[0-9]+")) {
    JOptionPane.showMessageDialog(null, "Stok fisik harus berupa angka dengan panjang antara 1 hingga 3 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!keterangan.matches("[a-zA-Z\\s]+")) {
    JOptionPane.showMessageDialog(null, "Keterangan hanya boleh terdiri dari huruf dan spasi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!username.matches("[a-zA-Z]+")) {
    JOptionPane.showMessageDialog(null, "Username hanya boleh terdiri dari huruf", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
}
tambahtransaksi();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int row = tabel.getSelectedRow();
        model.removeRow(row);
        clear2();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        try {
            String username = txt_username.getText(); 
    if (username.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username dan supplier harus diisi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (username.length() < 5 || username.length() > 15) {
        JOptionPane.showMessageDialog(null, "Panjang username harus antara 5 hingga 15 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!username.matches("^[a-zA-Z]+$")) {
        JOptionPane.showMessageDialog(null, "Username hanya boleh terdiri dari huruf", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    }
    int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin melakukan opname?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (dialogResult == JOptionPane.YES_OPTION) {
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        String Id_opname = txt_idopname.getText();
        String Id_akun = txt_idakun.getText();
        String Username = txt_username.getText();
        String Tanggal = txt_tanggal.getText();
        System.out.println(Id_opname + " " + Id_akun + " " + Username + " " + Tanggal);
        try {
            Connection c = Config.configDB();
            String sql = "INSERT INTO opname VALUES (?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, Integer.parseInt(Id_opname));
            p.setInt(2, Integer.parseInt(Id_akun));
            p.setString(3, Username);
            p.setString(4, Tanggal);
            p.executeUpdate();
            p.close();
        } catch (Exception e) {
            System.out.println("Simpan opname Error 1: " + e);
        }
        try {
            Connection c = Config.configDB();
            int baris = tabel.getRowCount();
            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO detail_opname (id_opname, id_barang, nama_barang, jumlah_sistem, jumlah_fisik, keterangan) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, tabel.getValueAt(i, 0).toString());
                p.setString(2, tabel.getValueAt(i, 1).toString());
                p.setString(3, tabel.getValueAt(i, 2).toString());
                p.setString(4, tabel.getValueAt(i, 3).toString());
                p.setString(5, tabel.getValueAt(i, 4).toString());
                p.setString(6, tabel.getValueAt(i, 5).toString());
                p.executeUpdate();
                p.close();
            }
        } catch (Exception e) {
            System.out.println("Simpan opname Error 2: " + e);
        }
        clear1();
        utama();
        kosong();
        try {
            Connection c = Config.configDB();
            String sql = "SELECT * FROM opname ORDER BY id_opname DESC LIMIT 1";
            System.out.println(sql);
            java.sql.Statement stm = c.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                String noBaru = String.valueOf(res.getInt("id_opname") + 1);
                txt_idopname.setText(noBaru);
            } else {
                txt_idopname.setText("1");
            }
            res.close();
            stm.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Masukkan Angka Yang Valid");
}
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        try {
    int baris = tabel.rowAtPoint(evt.getPoint());
    Connection conn = Config.configDB();
    Statement stm = conn.createStatement();
    String id_opname = tabel.getValueAt(baris, 0).toString();
    txt_idopname.setText(id_opname);
    System.out.println(id_opname);
    txt_idopname.setEnabled(false);
    txt_idbarang.setText(tabel.getValueAt(baris, 1) == null ? "" : tabel.getValueAt(baris, 1).toString());
    txt_namabarang.setText(tabel.getValueAt(baris, 2) == null ? "" : tabel.getValueAt(baris, 2).toString());
    txt_stoksistem.setText(tabel.getValueAt(baris, 3) == null ? "" : tabel.getValueAt(baris, 3).toString());
    txt_stokfisik.setText(tabel.getValueAt(baris, 4) == null ? "" : tabel.getValueAt(baris, 4).toString());
    txt_keterangan.setText(tabel.getValueAt(baris, 5) == null ? "" : tabel.getValueAt(baris, 5).toString());
} catch(SQLException ex) {
    Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
}
    }//GEN-LAST:event_tabelMouseClicked

    private void txt_namabarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namabarangKeyReleased
        String Nama = txt_namabarang.getText();
    try {
        String sql = "SELECT * FROM barang WHERE Nama_barang = ?";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, Nama);
        java.sql.ResultSet res = stm.executeQuery();
        if (res.next()) {
            txt_namabarang.setText(res.getString("Nama_barang"));
            txt_idbarang.setText(res.getString("id_barang"));
            txt_stoksistem.setText(res.getString("stok"));
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

    private void txt_keteranganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_keteranganKeyReleased
  
    }//GEN-LAST:event_txt_keteranganKeyReleased

    private void txt_stokfisikKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_stokfisikKeyReleased

    }//GEN-LAST:event_txt_stokfisikKeyReleased

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        try {
            Connection conn = Config.configDB();
            Statement statement = conn.createStatement();
            String searchKeyword = txt_namabarang.getText();
            ResultSet res = statement.executeQuery("SELECT * FROM barang WHERE nama_barang LIKE '%" + searchKeyword 
                    + "%'");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Nama Barang");
            tabel_barang.setModel(model);
            int no = 1;
            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString("Nama_Barang"),  
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

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_datamasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datamasterActionPerformed
        this.setVisible(false);
        new Akun().setVisible(true);
    }//GEN-LAST:event_btn_datamasterActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
        this.setVisible(false);
        new Transaksi_Penjualan().setVisible(true);
    }//GEN-LAST:event_btn_transaksiActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        this.setVisible(false);
        new Return_Pelanggan().setVisible(true);
    }//GEN-LAST:event_btn_returnActionPerformed

    private void btn_opnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opnameActionPerformed

    }//GEN-LAST:event_btn_opnameActionPerformed

    private void btn_logout1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout1ActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btn_logout1ActionPerformed

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
            java.util.logging.Logger.getLogger(Opname.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Opname.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Opname.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opname.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Opname().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_datamaster;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_logout1;
    private javax.swing.JButton btn_opname;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JLabel gambar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_hargabeli;
    private javax.swing.JLabel lbl_hargajual;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_namabarang;
    private javax.swing.JLabel lbl_namabarang2;
    private javax.swing.JLabel lbl_stok5;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JTable tabel;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JFormattedTextField txt_idakun;
    private javax.swing.JFormattedTextField txt_idbarang;
    private javax.swing.JFormattedTextField txt_idopname;
    private javax.swing.JFormattedTextField txt_keterangan;
    private javax.swing.JFormattedTextField txt_namabarang;
    private javax.swing.JFormattedTextField txt_stokfisik;
    private javax.swing.JFormattedTextField txt_stoksistem;
    private javax.swing.JFormattedTextField txt_tanggal;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}