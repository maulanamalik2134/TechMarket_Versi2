package Tampilan_Kasir;

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

public class Return_Supplier_Kasir extends javax.swing.JFrame {
String Tanggal;
private DefaultTableModel model;


public void loaddata() {
    DefaultTableModel model = (DefaultTableModel) tabel.getModel();
    model.addRow(new Object[]{
        txt_idreturn.getText(),
        txt_idbarang.getText(),
        txt_namabarang.getText(),
        txt_keterangan.getText(),
        txt_jumlah.getText()
    });
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
    txt_keterangan.setText("");
    txt_jumlah.setText("");
    txt_idreturn.setText("");
}

public void clear1() {
    txt_idreturn.setText("");
    txt_idakun.setText("");
    txt_username.setText("");
    txt_idsupplier.setText("");
    txt_namasupplier.setText("");
    txt_tanggal.setText("");
}

public void clear2() {
    txt_idbarang.setText("");
    txt_namabarang.setText("");
    txt_keterangan.setText("");
    txt_jumlah.setText("");
}

public void tambahtransaksi() {
    int jumlah;
    jumlah = Integer.valueOf(txt_jumlah.getText());
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

public Return_Supplier_Kasir() {
    initComponents();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setTitle("Aplikasi Kasir - Toko Imanuel Jember");
    model = new DefaultTableModel();
    tabel.setModel(model);
    model.addColumn("Id Return");
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Keterangan");
    model.addColumn("Jumlah");
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(() -> {
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        txt_tanggal.setText(s.format(date));
        setTanggalDanWaktu();
    }, 0, 1, TimeUnit.SECONDS);
    try {
        String sql = "SELECT * FROM return_supplier order by id_return desc limit 1";
        System.out.println(sql);
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            String noBaru = "" + (res.getInt("id_return") + 1);
            txt_idreturn.setText(noBaru);
        } else {
            txt_idreturn.setText("1");
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
        txt_jumlah = new javax.swing.JFormattedTextField();
        lbl_namabarang1 = new javax.swing.JLabel();
        lbl_namabarang2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        txt_namasupplier = new javax.swing.JFormattedTextField();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_bayar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        lbl_stok5 = new javax.swing.JLabel();
        btn_returnpelanggan = new javax.swing.JButton();
        btn_cari = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
        txt_keterangan = new javax.swing.JFormattedTextField();
        lbl_namabarang3 = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        btn_return1 = new javax.swing.JButton();
        transaksi = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        txt_idbarang = new javax.swing.JFormattedTextField();
        txt_idakun = new javax.swing.JFormattedTextField();
        txt_idsupplier = new javax.swing.JFormattedTextField();
        txt_idreturn = new javax.swing.JFormattedTextField();
        txt_tanggal = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setForeground(new java.awt.Color(255, 255, 255));
        bab.setText("Hai Kasir, Selamat Datang Di Return Supplier");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1120, 50));

        btn_logout2.setBackground(new java.awt.Color(255, 255, 255));
        btn_logout2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_logout2.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logout (1).png"))); // NOI18N
        btn_logout2.setText("Log Out");
        btn_logout2.setContentAreaFilled(false);
        btn_logout2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 200, -1));

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
        getContentPane().add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 120, 140, -1));

        lbl_namabarang1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namabarang1.setText("Nama Supplier");
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
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 130, -1));

        btn_bayar.setBackground(new java.awt.Color(255, 255, 255));
        btn_bayar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_bayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Cash.png"))); // NOI18N
        btn_bayar.setText("Simpan");
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 130, -1));

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
        lbl_stok5.setText("Jumlah");
        getContentPane().add(lbl_stok5, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 100, -1, -1));

        btn_returnpelanggan.setBackground(new java.awt.Color(255, 255, 255));
        btn_returnpelanggan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_returnpelanggan.setText("Return Pelanggan");
        btn_returnpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnpelangganActionPerformed(evt);
            }
        });
        getContentPane().add(btn_returnpelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, 30));

        btn_cari.setBackground(new java.awt.Color(255, 255, 255));
        btn_cari.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Search.png"))); // NOI18N
        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 220, 130, 30));

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

        lbl_namabarang3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namabarang3.setText("Keterangan");
        getContentPane().add(lbl_namabarang3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Collaborator Male.png"))); // NOI18N
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 50, 190, 80));

        btn_return1.setBackground(new java.awt.Color(255, 255, 255));
        btn_return1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_return1.setForeground(new java.awt.Color(255, 255, 255));
        btn_return1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Return (1).png"))); // NOI18N
        btn_return1.setText("Return");
        btn_return1.setContentAreaFilled(false);
        btn_return1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_return1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_return1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_return1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 210, -1));

        transaksi.setBackground(new java.awt.Color(255, 255, 255));
        transaksi.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        transaksi.setForeground(new java.awt.Color(255, 255, 255));
        transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Transaction (1).png"))); // NOI18N
        transaksi.setText("Transaksi");
        transaksi.setContentAreaFilled(false);
        transaksi.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        transaksi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiActionPerformed(evt);
            }
        });
        getContentPane().add(transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 200, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(txt_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 180, -1, -1));
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 150, -1, -1));

        txt_idsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idsupplierActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 200, -1, -1));
        getContentPane().add(txt_idreturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        txt_tanggal.setText("jFormattedTextField4");
        getContentPane().add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 170, -1, -1));
        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout2ActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btn_logout2ActionPerformed

@SuppressWarnings("empty-statement")
    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed

    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
  
    }//GEN-LAST:event_txt_jumlahActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
   
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_namasupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namasupplierActionPerformed
      
    }//GEN-LAST:event_txt_namasupplierActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
String jumlah = txt_jumlah.getText(); 
String namabarang = txt_namabarang.getText();
String keterangan = txt_keterangan.getText();  
if (namabarang.isEmpty() || jumlah.isEmpty() || keterangan.isEmpty()) {
    JOptionPane.showMessageDialog(null, "Nama barang, harga barang, keterangan diisi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (namabarang.length() < 5 || namabarang.length() > 50) {
    JOptionPane.showMessageDialog(null, "Panjang nama barang harus antara 5 hingga 50 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!namabarang.matches("[a-zA-Z0-9\"\\s.]+")) {
    JOptionPane.showMessageDialog(null, "Nama barang hanya boleh terdiri dari huruf, angka, spasi, tanda petik (\") dan titik (.)", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (jumlah.length() < 1 || jumlah.length() > 2) {
    JOptionPane.showMessageDialog(null, "Panjang jumlah harus antara 1 hingga 2 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!jumlah.matches("[0-9]+")) {
    JOptionPane.showMessageDialog(null, "Harga jumlah hanya boleh terdiri dari angka", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
}  else if (!jumlah.matches("[0-9]+")) {
    JOptionPane.showMessageDialog(null, "Jumlah hanya boleh terdiri dari angka", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
}  else if (keterangan.length() < 5 || namabarang.length() > 30) {
    JOptionPane.showMessageDialog(null, "Panjang nama barang harus antara 5 hingga 50 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if (!keterangan.matches("[a-zA-Z0-9\"\\s.]+")) {
    JOptionPane.showMessageDialog(null, "Nama barang hanya boleh terdiri dari huruf, angka, spasi, tanda petik (\") dan titik (.)", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
}
        tambahtransaksi();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int row = tabel.getSelectedRow();
        clear2();
        model.removeRow(row);
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
       try {
    String username = txt_username.getText(); 
    String supplier = txt_namasupplier.getText();
    if (username.isEmpty() || supplier.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username dan supplier harus diisi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (username.length() < 5 || username.length() > 15) {
        JOptionPane.showMessageDialog(null, "Panjang username harus antara 5 hingga 15 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!username.matches("^[a-zA-Z]+$")) {
        JOptionPane.showMessageDialog(null, "Username hanya boleh terdiri dari huruf", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (supplier.length() < 5 || supplier.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang nama supplier harus antara 5 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!supplier.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "Nama pelanggan harus terdiri dari huruf dan spasi saja.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        }
    int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan return supplier?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (dialogResult == JOptionPane.YES_OPTION) {
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        String Id_return = txt_idreturn.getText();
        String Id_akun = txt_idakun.getText();
        String Username = txt_username.getText();
        String Id_pelanggan = txt_idsupplier.getText();
        String Nama_pelanggan = txt_namasupplier.getText();
        String Tanggal = txt_tanggal.getText();
        System.out.println(Id_return + " " + Id_akun + " " + Username + " " + Id_pelanggan + " " + Nama_pelanggan + " " + Tanggal);
        try {
            Connection c = Config.configDB();
            String sql = "INSERT INTO return_supplier (Id_return, Id_akun, Username, Id_supplier, Nama_supplier, Tanggal_return) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setInt(1, Integer.parseInt(Id_return));
            p.setInt(2, Integer.parseInt(Id_akun));
            p.setString(3, Username);
            p.setInt(4, Integer.parseInt(Id_pelanggan));
            p.setString(5, Nama_pelanggan);
            p.setString(6, Tanggal);
            p.executeUpdate();
            p.close();
        } catch (Exception e) {
            System.out.println("Simpan return supplier Error 1: " + e);
        }

        try {
            Connection c = Config.configDB();
            int baris = tabel.getRowCount();
            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO detail_return_supplier (Id_return, Id_barang, Nama_barang, Keterangan, Jumlah) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, Integer.parseInt(tabel.getValueAt(i, 0).toString()));
                p.setString(2, tabel.getValueAt(i, 1).toString());
                p.setString(3, tabel.getValueAt(i, 2).toString());
                p.setString(4, tabel.getValueAt(i, 3).toString());
                p.setInt(5, Integer.parseInt(tabel.getValueAt(i, 4).toString()));
                p.executeUpdate();
                p.close();
            }
        } catch (Exception e) {
            System.out.println("Simpan return supplier Error 2: " + e);
        }
        clear1();
        utama();
        kosong();
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Masukkan Angka Yang Valid");
}
    }//GEN-LAST:event_btn_bayarActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        try{
            int baris = tabel.rowAtPoint(evt.getPoint());
            Connection conn = Config.configDB();
            Statement stm = conn.createStatement();
            String id_return = tabel.getValueAt(baris, 0).toString();
            txt_idreturn.setText(id_return);
            System.out.println(id_return);
            txt_idreturn.setEnabled(false);
            txt_idbarang.setText(tabel.getValueAt(baris, 1) == null ? "" : tabel.getValueAt(baris, 1).toString());
            txt_namabarang.setText(tabel.getValueAt(baris, 2) == null ? "" : tabel.getValueAt(baris, 2).toString());
            txt_keterangan.setText(tabel.getValueAt(baris, 3) == null ? "" : tabel.getValueAt(baris, 3).toString());
            txt_jumlah.setText(tabel.getValueAt(baris, 4) == null ? "" : tabel.getValueAt(baris, 4).toString());
        }
        catch(SQLException ex){
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
            txt_idbarang.setText(res.getString("Id_barang"));
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

    private void txt_namasupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namasupplierKeyReleased
        String Nama = txt_namasupplier.getText();
    try {
        String sql = "SELECT * FROM supplier WHERE nama_supplier = ?";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, Nama);
        java.sql.ResultSet res = stm.executeQuery();
        if (res.next()) {
            txt_namasupplier.setText(res.getString("nama_supplier"));
            txt_idsupplier.setText(res.getString("Id_supplier"));
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    }//GEN-LAST:event_txt_namasupplierKeyReleased

    private void txt_idsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idsupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idsupplierActionPerformed

    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyReleased

    }//GEN-LAST:event_txt_jumlahKeyReleased

    private void btn_returnpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnpelangganActionPerformed
        this.setVisible(false);
        new Return_Pelanggan_Kasir().setVisible(true);
    }//GEN-LAST:event_btn_returnpelangganActionPerformed

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

    private void txt_keteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_keteranganActionPerformed

    }//GEN-LAST:event_txt_keteranganActionPerformed

    private void txt_keteranganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_keteranganKeyReleased

    }//GEN-LAST:event_txt_keteranganKeyReleased

    private void transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiActionPerformed
        this.setVisible(false);
        new Transaksi_Penjualan_Kasir().setVisible(true);
    }//GEN-LAST:event_transaksiActionPerformed

    private void btn_return1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_return1ActionPerformed

    }//GEN-LAST:event_btn_return1ActionPerformed

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
            java.util.logging.Logger.getLogger(Return_Supplier_Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Return_Supplier_Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Return_Supplier_Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Return_Supplier_Kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Return_Supplier_Kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_logout2;
    private javax.swing.JButton btn_return1;
    private javax.swing.JButton btn_returnpelanggan;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_namabarang;
    private javax.swing.JLabel lbl_namabarang1;
    private javax.swing.JLabel lbl_namabarang2;
    private javax.swing.JLabel lbl_namabarang3;
    private javax.swing.JLabel lbl_stok5;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tabel;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JButton transaksi;
    private javax.swing.JFormattedTextField txt_idakun;
    private javax.swing.JFormattedTextField txt_idbarang;
    private javax.swing.JFormattedTextField txt_idreturn;
    private javax.swing.JFormattedTextField txt_idsupplier;
    private javax.swing.JFormattedTextField txt_jumlah;
    private javax.swing.JFormattedTextField txt_keterangan;
    private javax.swing.JFormattedTextField txt_namabarang;
    private javax.swing.JFormattedTextField txt_namasupplier;
    private javax.swing.JFormattedTextField txt_tanggal;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}