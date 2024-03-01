package Tampilan_Karyawan;

import Tampilan_Admin.*;
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

public class Opname_Karyawan extends javax.swing.JFrame {
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

public Opname_Karyawan() {
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
        btn_logout2 = new javax.swing.JButton();
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
        btn_bayar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btn_opname = new javax.swing.JButton();
        lbl_stok5 = new javax.swing.JLabel();
        btn_cari = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
        btn_masterdata = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        txt_idbarang = new javax.swing.JFormattedTextField();
        txt_tanggal = new javax.swing.JFormattedTextField();
        txt_idopname = new javax.swing.JFormattedTextField();
        txt_idakun = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setForeground(new java.awt.Color(255, 255, 255));
        bab.setText("Hai Karyawan, Selamat Datang Di Opname");
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

        btn_bayar.setBackground(new java.awt.Color(255, 255, 255));
        btn_bayar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_bayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Cash.png"))); // NOI18N
        btn_bayar.setText("Bayar");
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 130, -1));

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
        getContentPane().add(btn_opname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 200, -1));

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

        btn_masterdata.setBackground(new java.awt.Color(255, 255, 255));
        btn_masterdata.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_masterdata.setForeground(new java.awt.Color(255, 255, 255));
        btn_masterdata.setText("Data Master");
        btn_masterdata.setContentAreaFilled(false);
        btn_masterdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_masterdataActionPerformed(evt);
            }
        });
        getContentPane().add(btn_masterdata, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_idbarang.setText("jFormattedTextField2");
        getContentPane().add(txt_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 180, -1, -1));

        txt_tanggal.setText("jFormattedTextField4");
        getContentPane().add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 170, -1, -1));

        txt_idopname.setText("jFormattedTextField1");
        getContentPane().add(txt_idopname, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, -1, -1));

        txt_idakun.setText("jFormattedTextField3");
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 200, -1, -1));
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout2ActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin logout?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btn_logout2ActionPerformed

@SuppressWarnings("empty-statement")
    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
String namaBarang = txt_namabarang.getText();

Connection conn = null;
try {
    conn = Config.configDB();
} catch (SQLException ex) {
    Logger.getLogger(Opname_Karyawan.class.getName()).log(Level.SEVERE, null, ex);
}
try {
    Statement stmt = conn.createStatement();
    
    String query = "SELECT * FROM barang WHERE nama_barang = '" + namaBarang + "'";
    ResultSet rs = stmt.executeQuery(query);
    
    if (rs.next()) {
        System.out.println("Barang yang ditemukan:");
        do {
            String nama = rs.getString("nama");
            System.out.println("Nama: " + nama);
        } while (rs.next());
    } else {
        System.out.println("Barang tidak ditemukan");
    }
    
    rs.close();
    stmt.close();
    conn.close();
} catch (SQLException e) {
    e.printStackTrace();
}
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_stoksistemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stoksistemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stoksistemActionPerformed

    private void txt_stokfisikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokfisikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stokfisikActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_keteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_keteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_keteranganActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        tambahtransaksi();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int row = tabel.getSelectedRow();
        model.removeRow(row);
        clear2();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        try {
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
    }//GEN-LAST:event_btn_bayarActionPerformed

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

    private void btn_opnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opnameActionPerformed
        
    }//GEN-LAST:event_btn_opnameActionPerformed

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
    ResultSet res = statement.executeQuery("SELECT * FROM barang WHERE nama_barang LIKE '%" + searchKeyword + "%'");

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Nama Barang");
    tabel_barang.setModel(model);

    int no = 1;
    while (res.next()) {
        model.addRow(new Object[]{
            res.getString("Nama_Barang")
        });
        no++;
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(rootPane, "Gagal Mengambil Data: " + e.getMessage());
}
    }//GEN-LAST:event_btn_cariActionPerformed

    private void tabel_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barangMouseClicked
        try {
    int baris = tabel_barang.rowAtPoint(evt.getPoint());
    Connection conn = Config.configDB();
    Statement stm = conn.createStatement();
            
    String nama_barang = tabel_barang.getValueAt(baris, 0).toString();
    txt_namabarang.setText(nama_barang);
} catch(SQLException ex) {
    Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
}
    }//GEN-LAST:event_tabel_barangMouseClicked

    private void btn_masterdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_masterdataActionPerformed
        this.setVisible(false);
        new Barang_Karyawan().setVisible(true);
    }//GEN-LAST:event_btn_masterdataActionPerformed

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
            java.util.logging.Logger.getLogger(Opname_Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Opname_Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Opname_Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opname_Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Opname_Karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_logout2;
    private javax.swing.JButton btn_masterdata;
    private javax.swing.JButton btn_opname;
    private javax.swing.JButton btn_tambah;
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
