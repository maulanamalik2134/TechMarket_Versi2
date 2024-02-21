/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tampilan_Admin;

import Config.Config;
import Tampilan_Awal.Absen;
import Tampilan_Awal.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Return extends javax.swing.JFrame {
private DefaultTableModel model;

// Mengatur tanggal dan waktu saat ini
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

public Return() {
    initComponents();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");

    // Jadwalkan tugas untuk memperbarui tanggal dan waktu saat ini setiap detik
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(() -> setTanggalDanWaktuSekarang(), 0, 1, TimeUnit.SECONDS);

    // Set tanggal dan waktu saat ini
    setTanggalDanWaktuSekarang();
    setTanggalDanWaktu();
    
    // Mengisi tabel return dan menginisialisasi formulir return baru
    tabel_return();
    txt_idreturn.setText(getNextIdReturn());
    kosong1();
}

// Dapatkan ID berikutnya untuk return baru
private String getNextIdReturn() {
    try {
        String sql = "SELECT MAX(Id_return) AS max_id FROM `return`";
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

// Mengosongkan input untuk membuat return baru
private void kosong1() {
    txt_namabarang.setText(null);
    txt_username.setText(null);
    txt_namasupplier.setText(null);
    txt_total.setText(null);
    txt_jumlah.setText(null);
    txt_keterangan.setText(null);
}

// Mengisi tabel return
private void tabel_return() {
    model = new DefaultTableModel();
    model.addColumn("Id Return");
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Keterangan");
    model.addColumn("Jumlah");
    model.addColumn("Total");
    model.addColumn("Tanggal");
    model.addColumn("Id Akun");
    model.addColumn("Username");
    model.addColumn("Id Supplier");
    model.addColumn("Nama Supplier");

    try {
        String sql = "SELECT `return`.id_return, `return`.id_barang, `return`.nama_barang, `return`.keterangan, `return`.jumlah, `return`.total, `return`.tanggal, `return`.id_akun, `return`.username, `return`.id_supplier, `return`.nama_supplier FROM `return`";
        Connection conn = Config.configDB();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet res = stm.executeQuery();

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id_return"),
                res.getString("id_barang"),
                res.getString("nama_barang"),
                res.getString("keterangan"),
                res.getString("jumlah"),
                res.getString("total"),
                res.getString("tanggal"),
                res.getString("id_akun"),
                res.getString("username"),
                res.getString("id_supplier"),
                res.getString("nama_supplier"),
            });
        }
        tabel_return.setModel(model);
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
        btn_dashboard = new javax.swing.JButton();
        btn_akun = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btn_barang = new javax.swing.JButton();
        btn_opname = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_absen = new javax.swing.JButton();
        btn_oprasional = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        btn_logout2 = new javax.swing.JButton();
        lbl_namabarang = new javax.swing.JLabel();
        txt_namabarang = new javax.swing.JFormattedTextField();
        lbl_namasupplier = new javax.swing.JLabel();
        txt_keterangan = new javax.swing.JFormattedTextField();
        txt_jumlah = new javax.swing.JFormattedTextField();
        txt_total = new javax.swing.JFormattedTextField();
        lbl_namasupplier1 = new javax.swing.JLabel();
        lbl_namasupplier2 = new javax.swing.JLabel();
        txt_namasupplier = new javax.swing.JFormattedTextField();
        lbl_namasupplier3 = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        lbl_namasupplier4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_return = new javax.swing.JTable();
        btn_edit = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        txt_tanggalmasuk = new javax.swing.JFormattedTextField();
        txt_idreturn = new javax.swing.JFormattedTextField();
        txt_idbarang = new javax.swing.JFormattedTextField();
        txt_idakun = new javax.swing.JFormattedTextField();
        txt_idsupplier = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setText("Hai Admin, Selamat Datang Di Return");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 1120, 50));

        btn_dashboard.setBackground(new java.awt.Color(255, 255, 255));
        btn_dashboard.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        btn_dashboard.setText("Dashboard");
        btn_dashboard.setContentAreaFilled(false);
        btn_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btn_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 200, -1));

        btn_akun.setBackground(new java.awt.Color(255, 255, 255));
        btn_akun.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_akun.setForeground(new java.awt.Color(255, 255, 255));
        btn_akun.setText("Akun");
        btn_akun.setContentAreaFilled(false);
        btn_akun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_akunActionPerformed(evt);
            }
        });
        getContentPane().add(btn_akun, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 200, -1));

        btn_supplier.setBackground(new java.awt.Color(255, 255, 255));
        btn_supplier.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_supplier.setForeground(new java.awt.Color(255, 255, 255));
        btn_supplier.setText("supplier");
        btn_supplier.setContentAreaFilled(false);
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, -1));

        btn_barang.setBackground(new java.awt.Color(255, 255, 255));
        btn_barang.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_barang.setForeground(new java.awt.Color(255, 255, 255));
        btn_barang.setText("Barang");
        btn_barang.setContentAreaFilled(false);
        btn_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barangActionPerformed(evt);
            }
        });
        getContentPane().add(btn_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 200, -1));

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
        getContentPane().add(btn_opname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 200, -1));

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
        getContentPane().add(btn_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 200, -1));

        btn_absen.setBackground(new java.awt.Color(255, 255, 255));
        btn_absen.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_absen.setForeground(new java.awt.Color(255, 255, 255));
        btn_absen.setText("Absen");
        btn_absen.setContentAreaFilled(false);
        btn_absen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_absenActionPerformed(evt);
            }
        });
        getContentPane().add(btn_absen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 200, -1));

        btn_oprasional.setBackground(new java.awt.Color(255, 255, 255));
        btn_oprasional.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_oprasional.setForeground(new java.awt.Color(255, 255, 255));
        btn_oprasional.setText("Oprasional");
        btn_oprasional.setContentAreaFilled(false);
        btn_oprasional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_oprasionalActionPerformed(evt);
            }
        });
        getContentPane().add(btn_oprasional, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 200, -1));

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
        getContentPane().add(btn_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 200, -1));

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
        getContentPane().add(btn_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 200, -1));

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

        lbl_namabarang.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namabarang.setText("Nama Barang");
        getContentPane().add(lbl_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

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

        lbl_namasupplier.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namasupplier.setText("Keterangan");
        getContentPane().add(lbl_namasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

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
        getContentPane().add(txt_keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 310, -1));

        txt_jumlah.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });
        getContentPane().add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 120, 140, -1));

        txt_total.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        getContentPane().add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 120, 140, -1));

        lbl_namasupplier1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namasupplier1.setText("Jumlah");
        getContentPane().add(lbl_namasupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 100, -1, -1));

        lbl_namasupplier2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namasupplier2.setText("Total");
        getContentPane().add(lbl_namasupplier2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 100, -1, -1));

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
        getContentPane().add(txt_namasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 180, 310, -1));

        lbl_namasupplier3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namasupplier3.setText("Nama Supplier");
        getContentPane().add(lbl_namasupplier3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, -1, -1));

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

        lbl_namasupplier4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namasupplier4.setText("Username");
        getContentPane().add(lbl_namasupplier4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        tabel_return.setModel(new javax.swing.table.DefaultTableModel(
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
        ));
        tabel_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_returnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_return);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 260, 1070, 400));

        btn_edit.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(153, 153, 0));
        btn_edit.setText("Edit");
        btn_edit.setContentAreaFilled(false);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, -1, -1));

        btn_tambah.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(0, 204, 0));
        btn_tambah.setText("Tambah");
        btn_tambah.setContentAreaFilled(false);
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 220, -1, -1));

        btn_hapus.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(153, 0, 0));
        btn_hapus.setText("Hapus");
        btn_hapus.setContentAreaFilled(false);
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 220, -1, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_tanggalmasuk.setText("jFormattedTextField1");
        getContentPane().add(txt_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 180, 30, 30));

        txt_idreturn.setText("jFormattedTextField1");
        getContentPane().add(txt_idreturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 180, 30, 30));

        txt_idbarang.setText("jFormattedTextField1");
        getContentPane().add(txt_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 180, 30, 30));

        txt_idakun.setText("jFormattedTextField1");
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 180, 30, 30));

        txt_idsupplier.setText("jFormattedTextField1");
        getContentPane().add(txt_idsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 180, 30, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        this.setVisible(false);
            new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_akunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_akunActionPerformed
        this.setVisible(false);
            new Akun().setVisible(true);
    }//GEN-LAST:event_btn_akunActionPerformed

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        this.setVisible(false);
            new Supplier().setVisible(true);
    }//GEN-LAST:event_btn_supplierActionPerformed

    private void btn_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barangActionPerformed
        this.setVisible(false);
            new Barang().setVisible(true);
    }//GEN-LAST:event_btn_barangActionPerformed

    private void btn_opnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opnameActionPerformed
        this.setVisible(false);
            new Opname().setVisible(true);
    }//GEN-LAST:event_btn_opnameActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed

    }//GEN-LAST:event_btn_returnActionPerformed

    private void btn_absenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_absenActionPerformed
        this.setVisible(false);
            new Absen_Admin().setVisible(true);
    }//GEN-LAST:event_btn_absenActionPerformed

    private void btn_oprasionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_oprasionalActionPerformed
        this.setVisible(false);
            new Oprasional().setVisible(true);
    }//GEN-LAST:event_btn_oprasionalActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
        this.setVisible(false);
            new Menu_Transaksi_Admin().setVisible(true);
    }//GEN-LAST:event_btn_transaksiActionPerformed

    private void btn_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanActionPerformed
        this.setVisible(false);
            new Menu_Laporan().setVisible(true);
    }//GEN-LAST:event_btn_laporanActionPerformed

    private void btn_logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout2ActionPerformed
        this.setVisible(false);
            new Login().setVisible(true);
    }//GEN-LAST:event_btn_logout2ActionPerformed

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_keteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_keteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_keteranganActionPerformed

    private void txt_keteranganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_keteranganKeyReleased

    }//GEN-LAST:event_txt_keteranganKeyReleased

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_namasupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namasupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namasupplierActionPerformed

    private void txt_namasupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namasupplierKeyReleased
        String Nama = txt_namasupplier.getText(); // Mendapatkan nilai dari inputan Nama Supplier

        try {
            // Membuat koneksi ke database
            String sql = "SELECT * FROM supplier WHERE Nama_supplier = ?"; // Query SQL untuk mencari supplier berdasarkan Nama_supplier
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Nama); // Mengatur parameter pertama dengan nilai Nama
            java.sql.ResultSet res = stm.executeQuery(); // Eksekusi query dan mendapatkan hasil

            if (res.next()) {
                txt_idsupplier.setText(res.getString("id_Supplier")); // Jika hasil query ada, set nilai txt_idsupplier dengan nilai kolom id_Supplier dari hasil query
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); // Menampilkan pesan error jika terjadi exception saat menjalankan query
        }
    }//GEN-LAST:event_txt_namasupplierKeyReleased

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyReleased
        String Nama = txt_username.getText(); // Mendapatkan nilai dari inputan Nama Supplier

        try {
            // Membuat koneksi ke database
            String sql = "SELECT * FROM akun WHERE username = ?"; // Query SQL untuk mencari supplier berdasarkan Nama_supplier
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Nama); // Mengatur parameter pertama dengan nilai Nama
            java.sql.ResultSet res = stm.executeQuery(); // Eksekusi query dan mendapatkan hasil

            if (res.next()) {
                txt_idakun.setText(res.getString("id_akun")); // Jika hasil query ada, set nilai txt_idsupplier dengan nilai kolom id_Supplier dari hasil query
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); // Menampilkan pesan error jika terjadi exception saat menjalankan query
        }
    }//GEN-LAST:event_txt_usernameKeyReleased

    private void tabel_returnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_returnMouseClicked
        try{
            int baris = tabel_return.rowAtPoint(evt.getPoint());
            Connection conn = Config.configDB();
            Statement stm = conn.createStatement();

            // Ambil nilai ID akun dari baris yang dipilih
            String id_return = tabel_return.getValueAt(baris, 0).toString();
            txt_idreturn.setText(id_return);
            System.out.println(id_return);
            txt_idreturn.setEnabled(false);

            // Set nilai username
            txt_idbarang.setText(tabel_return.getValueAt(baris, 1) == null ? "" : tabel_return.getValueAt(baris, 1).toString());

            // Set nilai username
            txt_namabarang.setText(tabel_return.getValueAt(baris, 2) == null ? "" : tabel_return.getValueAt(baris, 2).toString());

            // Set nilai telepon
            txt_keterangan.setText(tabel_return.getValueAt(baris, 3) == null ? "" : tabel_return.getValueAt(baris, 3).toString(
            ));

            // Set nilai username
            txt_jumlah.setText(tabel_return.getValueAt(baris, 4) == null ? "" : tabel_return.getValueAt(baris, 4).toString());
            // Set nilai username

            txt_total.setText(tabel_return.getValueAt(baris, 5) == null ? "" : tabel_return.getValueAt(baris, 5).toString());

            // Set nilai username
            txt_tanggalmasuk.setText(tabel_return.getValueAt(baris, 6) == null ? "" : tabel_return.getValueAt(baris, 6).toString());

            // set nilai namabarang
            txt_idakun.setText(tabel_return.getValueAt(baris,7) == null ? "" : tabel_return.getValueAt(baris, 7).toString());

            // set nilai namabarang
            txt_username.setText(tabel_return.getValueAt(baris,8) == null ? "" : tabel_return.getValueAt(baris, 8).toString());
 
            // set nilai namabarang
            txt_idsupplier.setText(tabel_return.getValueAt(baris,9) == null ? "" : tabel_return.getValueAt(baris, 9).toString());

            // set nilai namabarang
            txt_namasupplier.setText(tabel_return.getValueAt(baris,10) == null ? "" : tabel_return.getValueAt(baris, 10).toString());

        }
        catch(SQLException ex){
            Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabel_returnMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
 try {
    // Tampilkan dialog konfirmasi untuk mengedit data
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengedit data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        // Mendapatkan nilai dari inputan
        String idbarang = txt_idbarang.getText(); // ID barang
        String namabarang = txt_namabarang.getText(); // Nama barang
        String keterangan = txt_keterangan.getText(); // Keterangan
        String jumlah = txt_jumlah.getText(); // Jumlah
        String total = txt_total.getText(); // Total
        String tanggal = txt_tanggalmasuk.getText(); // Tanggal masuk
        String idakun = txt_idakun.getText(); // ID akun
        String username = txt_username.getText(); // Username
        String idsupplier = txt_idsupplier.getText(); // ID supplier
        String namasupplier = txt_namasupplier.getText(); // Nama supplier
        String idreturn = txt_idreturn.getText(); // ID return

        Connection conn = Config.configDB();

        // Mengecek apakah semua kolom sudah diisi
        if (namabarang.isEmpty() || keterangan.isEmpty() || jumlah.isEmpty() || total.isEmpty() || tanggal.isEmpty() || idakun.isEmpty() || username.isEmpty() || idsupplier.isEmpty() || namasupplier.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
            return;
        }

        // Mengecek panjang inputan
        if (namabarang.length() < 5 || namabarang.length() > 40) {
            JOptionPane.showMessageDialog(null, "Panjang nama barang harus antara 5 hingga 40 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (keterangan.length() < 5 || keterangan.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang keterangan harus antara 5 hingga 30 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (jumlah.length() < 1 || jumlah.length() > 3) {
            JOptionPane.showMessageDialog(null, "Panjang jumlah harus antara 1 hingga 3 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (total.length() < 4 || total.length() > 8) {
            JOptionPane.showMessageDialog(null, "Panjang total harus antara 4 hingga 8 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (namasupplier.length() < 5 || namasupplier.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang nama supplier harus antara 5 hingga 30 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update data return dengan informasi yang diedit
        String sql = "UPDATE `return` SET id_barang=?, nama_barang=?, keterangan=?, jumlah=?, total=?, tanggal=?, id_akun=?, username=?, id_supplier=?, nama_supplier=? WHERE id_return=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, idbarang);
        pst.setString(2, namabarang);
        pst.setString(3, keterangan);
        pst.setString(4, jumlah);
        pst.setString(5, total);
        pst.setString(6, tanggal);
        pst.setString(7, idakun);
        pst.setString(8, username);
        pst.setString(9, idsupplier);
        pst.setString(10, namasupplier);
        pst.setString(11, idreturn);
        pst.executeUpdate();

        // Menampilkan pesan sukses
        String successMessage = "Data Return Berhasil Diubah!\nID Return: " + idreturn + "\nID Barang: " + idbarang + "\nNama Barang: " + namabarang + "\nKeterangan: " + keterangan + "\nJumlah: " + jumlah + "\nTotal: " + total + "\nTanggal Masuk: " + tanggal + "\nID Akun: " + idakun + "\nUsername: " + username + "\nID Supplier: " + idsupplier + "\nNama Supplier: " + namasupplier;
        JOptionPane.showMessageDialog(null, successMessage);

        // Perbarui tabel return dan kosongkan input
        tabel_return();
        kosong1();
        txt_idreturn.setText(getNextIdReturn()); // Update ID return berikutnya setelah penyimpanan berhasil
    }
} catch (Exception e) {
    // Tampilkan notifikasi jika terjadi kesalahan saat mengubah data
    JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menambahkan return?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
if (konfirmasi == JOptionPane.YES_OPTION) {
    try {
        // Mendapatkan nilai dari inputan form
        String idreturn = txt_idreturn.getText();
        String idbarang = txt_idbarang.getText(); // ID barang
        String namabarang = txt_namabarang.getText(); // Nama barang
        String keterangan = txt_keterangan.getText(); // Keterangan
        String jumlah = txt_jumlah.getText(); // Jumlah
        String total = txt_total.getText(); // Total
        String tanggal = txt_tanggalmasuk.getText(); // Tanggal masuk
        String idakun = txt_idakun.getText(); // ID akun
        String username = txt_username.getText(); // Username
        String idsupplier = txt_idsupplier.getText(); // ID supplier
        String namasupplier = txt_namasupplier.getText(); // Nama supplier

        // Membuat koneksi ke database
        Connection conn = Config.configDB();

        // Mengecek apakah semua kolom sudah diisi
        if (namabarang.isEmpty() || keterangan.isEmpty() || jumlah.isEmpty() || total.isEmpty() || tanggal.isEmpty() || idakun.isEmpty() || username.isEmpty() || idsupplier.isEmpty() || namasupplier.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
            return;
        }

        // Mengecek panjang inputan
        if (namabarang.length() < 5 || namabarang.length() > 40) {
            JOptionPane.showMessageDialog(null, "Panjang nama barang harus antara 5 hingga 40 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (keterangan.length() < 5 || keterangan.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang keterangan harus antara 5 hingga 30 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (jumlah.length() < 1 || jumlah.length() > 4) {
            JOptionPane.showMessageDialog(null, "Panjang jumlah harus antara 1 hingga 4 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (total.length() < 4 || total.length() > 8) {
            JOptionPane.showMessageDialog(null, "Panjang total harus antara 4 hingga 8 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (namasupplier.length() < 5 || namasupplier.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang nama supplier harus antara 5 hingga 30 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simpan data ke database
        String insertSql = "INSERT INTO `return` (id_return, id_barang, nama_barang, keterangan, jumlah, total, tanggal, id_akun, username, id_supplier, nama_supplier) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertPst = conn.prepareStatement(insertSql);
        insertPst.setString(1, idreturn);
        insertPst.setString(2, idbarang);
        insertPst.setString(3, namabarang);
        insertPst.setString(4, keterangan);
        insertPst.setString(5, jumlah);
        insertPst.setString(6, total);
        insertPst.setString(7, tanggal);
        insertPst.setString(8, idakun);
        insertPst.setString(9, username);
        insertPst.setString(10, idsupplier);
        insertPst.setString(11, namasupplier);
        insertPst.execute();

        // Menampilkan pesan sukses
        String successMessage = "Data Return Berhasil Ditambahkan!\nID Return: " + idreturn + "\nID Barang: " + idbarang + "\nNama Barang: " + namabarang + "\nKeterangan: " + keterangan + "\nJumlah: " + jumlah + "\nTotal: " + total + "\nTanggal Masuk: " + tanggal + "\nID Akun: " + idakun + "\nUsername: " + username + "\nID Supplier: " + idsupplier + "\nNama Supplier: " + namasupplier;
        JOptionPane.showMessageDialog(null, successMessage);

        // Refresh tabel return
        tabel_return();
        txt_idreturn.setText(getNextIdReturn()); // Update ID return berikutnya setelah penyimpanan berhasil

        // Kosongkan input
        kosong1();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
} else {
    JOptionPane.showMessageDialog(null, "Penambahan return dibatalkan");
}
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
            // Tampilkan dialog konfirmasi penghapusan data
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Hapus data supplier berdasarkan ID
                String sqlbarang = "DELETE FROM return WHERE id_return=?";
                Connection conn = Config.configDB();
                PreparedStatement pstbarang = conn.prepareStatement(sqlbarang);
                pstbarang.setString(1, txt_idbarang.getText());
                pstbarang.executeUpdate();

                // Tampilkan notifikasi sukses
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                // Generate ID baru untuk supplier selanjutnya
                txt_idreturn.setText(getNextIdReturn());
            }
        } catch (Exception e) {
            // Tampilkan notifikasi gagal
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Perbarui tabel supplier
        tabel_return();

        // Kosongkan input
        kosong1();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txt_namabarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namabarangKeyReleased
        String Nama = txt_namabarang.getText(); // Mendapatkan nilai dari inputan Nama Supplier

        try {
            // Membuat koneksi ke database
            String sql = "SELECT * FROM barang WHERE Nama_barang = ?"; // Query SQL untuk mencari supplier berdasarkan Nama_supplier
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Nama); // Mengatur parameter pertama dengan nilai Nama
            java.sql.ResultSet res = stm.executeQuery(); // Eksekusi query dan mendapatkan hasil

            if (res.next()) {
                txt_idbarang.setText(res.getString("id_barang")); // Jika hasil query ada, set nilai txt_idsupplier dengan nilai kolom id_Supplier dari hasil query
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage()); // Menampilkan pesan error jika terjadi exception saat menjalankan query
        }
    }//GEN-LAST:event_txt_namabarangKeyReleased

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
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Return.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Return().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_absen;
    private javax.swing.JButton btn_akun;
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout2;
    private javax.swing.JButton btn_opname;
    private javax.swing.JButton btn_oprasional;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_namabarang;
    private javax.swing.JLabel lbl_namasupplier;
    private javax.swing.JLabel lbl_namasupplier1;
    private javax.swing.JLabel lbl_namasupplier2;
    private javax.swing.JLabel lbl_namasupplier3;
    private javax.swing.JLabel lbl_namasupplier4;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JTable tabel_return;
    private javax.swing.JFormattedTextField txt_idakun;
    private javax.swing.JFormattedTextField txt_idbarang;
    private javax.swing.JFormattedTextField txt_idreturn;
    private javax.swing.JFormattedTextField txt_idsupplier;
    private javax.swing.JFormattedTextField txt_jumlah;
    private javax.swing.JFormattedTextField txt_keterangan;
    private javax.swing.JFormattedTextField txt_namabarang;
    private javax.swing.JFormattedTextField txt_namasupplier;
    private javax.swing.JFormattedTextField txt_tanggalmasuk;
    private javax.swing.JFormattedTextField txt_total;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
