package Aplikasi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Supplier extends javax.swing.JFrame {
    String Tanggal;
    private DefaultTableModel model;
     
    public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss");
    String formattedDateTime = dateTime.format(formatter);
    txt_tanggal.setText(formattedDateTime);
}
    public Supplier() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat s = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
                txt_tanggal.setText(s.format(date));
            }
        }, 0, 1, TimeUnit.SECONDS);
          tabel_supplier();
          txt_idsupplier.setText(getNextIdSupplier());
          kosong1();
    }
    
     private String getNextIdSupplier() {
    try {
        String sql = "SELECT MAX(Id_supplier) AS max_id FROM supplier";
        System.out.println(sql);
        java.sql.Connection conn = Aplikasi.Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);
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
     
    private void kosong1(){
        txt_alamat.setText(null);
        txt_telepon.setText(null);
        txt_namasupplier.setText(null);
    }
    
    private void tabel_supplier() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Supplier");
    model.addColumn("Nama Supplier");
    model.addColumn("Telepon");
    model.addColumn("Alamat");

    try {
        int no = 1;
        String sql = "SELECT supplier.id_supplier, supplier.nama_supplier, supplier.telepon, supplier.alamat FROM supplier";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                    res.getString("id_supplier"),
                    res.getString("nama_supplier"),
                    res.getString("telepon"),
                    res.getString("alamat"),
            });
        }
        tabel_supplier.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_akun = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btn_barang = new javax.swing.JButton();
        btn_absen = new javax.swing.JButton();
        btn_dashboard = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        txt_tanggal = new javax.swing.JLabel();
        lbl_idsupplier = new javax.swing.JLabel();
        txt_idsupplier = new javax.swing.JFormattedTextField();
        lbl_alamat = new javax.swing.JLabel();
        lbl_namasupplier = new javax.swing.JLabel();
        txt_namasupplier = new javax.swing.JFormattedTextField();
        txt_alamat = new javax.swing.JFormattedTextField();
        lbl_telepon = new javax.swing.JLabel();
        txt_telepon = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_supplier = new javax.swing.JTable();
        txt_cari = new javax.swing.JFormattedTextField();
        btn_cari = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        body = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_akun.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_akun.setForeground(new java.awt.Color(255, 255, 255));
        btn_akun.setText("Akun");
        btn_akun.setContentAreaFilled(false);
        btn_akun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_akunActionPerformed(evt);
            }
        });
        getContentPane().add(btn_akun, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 250, -1));

        btn_supplier.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_supplier.setForeground(new java.awt.Color(255, 255, 255));
        btn_supplier.setText("Supplier");
        btn_supplier.setContentAreaFilled(false);
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, -1));

        btn_barang.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_barang.setForeground(new java.awt.Color(255, 255, 255));
        btn_barang.setText("Barang");
        btn_barang.setContentAreaFilled(false);
        btn_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barangActionPerformed(evt);
            }
        });
        getContentPane().add(btn_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 250, -1));

        btn_absen.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_absen.setForeground(new java.awt.Color(255, 255, 255));
        btn_absen.setText("Absen");
        btn_absen.setContentAreaFilled(false);
        btn_absen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_absenActionPerformed(evt);
            }
        });
        getContentPane().add(btn_absen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 250, -1));

        btn_dashboard.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        btn_dashboard.setText("Dashboard");
        btn_dashboard.setContentAreaFilled(false);
        btn_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btn_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 250, -1));

        btn_logout.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setText("Log Out");
        btn_logout.setContentAreaFilled(false);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 250, -1));

        btn_laporan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_laporan.setForeground(new java.awt.Color(255, 255, 255));
        btn_laporan.setText("Laporan");
        btn_laporan.setContentAreaFilled(false);
        btn_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 250, -1));

        txt_tanggal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        txt_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 450, 50));

        lbl_idsupplier.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_idsupplier.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idsupplier.setText("Id Supplier");
        getContentPane().add(lbl_idsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        txt_idsupplier.setEnabled(false);
        txt_idsupplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_idsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idsupplierActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, 30));

        lbl_alamat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_alamat.setForeground(new java.awt.Color(255, 255, 255));
        lbl_alamat.setText("Alamat");
        getContentPane().add(lbl_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, -1, -1));

        lbl_namasupplier.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_namasupplier.setForeground(new java.awt.Color(255, 255, 255));
        lbl_namasupplier.setText("Nama Supplier");
        getContentPane().add(lbl_namasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

        txt_namasupplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_namasupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namasupplierActionPerformed(evt);
            }
        });
        getContentPane().add(txt_namasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 240, 30));

        txt_alamat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alamatActionPerformed(evt);
            }
        });
        getContentPane().add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 130, 240, 30));

        lbl_telepon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_telepon.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telepon.setText("Telepon");
        getContentPane().add(lbl_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 110, -1, -1));

        txt_telepon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_telepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teleponActionPerformed(evt);
            }
        });
        getContentPane().add(txt_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 130, 180, 30));

        tabel_supplier.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabel_supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Barang", "Id Supplier", "Nama Barang", "Harga", "Stok", "Diskon", "Garansi"
            }
        ));
        tabel_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_supplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_supplier);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 1000, 290));

        txt_cari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txt_cari.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_cari.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        getContentPane().add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 270, 330, 30));

        btn_cari.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_cari.setText("Cari");
        btn_cari.setContentAreaFilled(false);
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 270, 70, 30));

        btn_edit.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 270, -1, -1));

        btn_tambah.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 270, -1, -1));

        btn_print.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_print.setText("Print");
        getContentPane().add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, -1, -1));

        btn_hapus.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 270, -1, -1));

        body.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Small (2).png"))); // NOI18N
        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idsupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idsupplierActionPerformed

    private void txt_namasupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namasupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namasupplierActionPerformed

    private void txt_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alamatActionPerformed

    private void txt_teleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teleponActionPerformed

    private void tabel_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_supplierMouseClicked
        int baris = tabel_supplier.rowAtPoint(evt.getPoint());
        String id_supplier= tabel_supplier.getValueAt(baris, 0).toString();
        txt_idsupplier.setText(id_supplier);
        System.out.println(id_supplier);
        txt_idsupplier.disable();
        if (tabel_supplier.getValueAt(baris, 1)==null){
            txt_namasupplier.setText("");
        } else {
            txt_namasupplier.setText(tabel_supplier.getValueAt(baris, 1).toString());
        }
        if (tabel_supplier.getValueAt(baris, 3)==null){
            txt_telepon.setText("");
        } else {
            txt_telepon.setText(tabel_supplier.getValueAt(baris, 3).toString());
        }
        if (tabel_supplier.getValueAt(baris, 4)==null){
            txt_alamat.setText("");
        } else {
            txt_alamat.setText(tabel_supplier.getValueAt(baris, 4).toString());
        }
    }//GEN-LAST:event_tabel_supplierMouseClicked

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        try {
    Connection conn = Config.configDB();
    Statement statement = conn.createStatement();
    String searchKeyword = txt_cari.getText();
    String sql = "SELECT * FROM supplier WHERE Nama_supplier LIKE ?";
    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setString(1, "%" + searchKeyword + "%");
    ResultSet res = pst.executeQuery();

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Supplier");
    model.addColumn("Nama Supplier");
    model.addColumn("Email");
    model.addColumn("Telepon");
    model.addColumn("Alamat");
    tabel_supplier.setModel(model);

    int no = 1;
    while (res.next()) {
        model.addRow(new Object[]{
            res.getString("id_supplier"),
                    res.getString("nama_supplier"),
                    res.getString("email"),
                    res.getString("telepon"),
                    res.getString("alamat")
        });
        no++;
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(rootPane, "Gagal Mengambil Data: " + e.getMessage());
}
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        try {
    String idsupplier = txt_idsupplier.getText();
    String namasupplier = txt_namasupplier.getText();
    String telepon = txt_telepon.getText();
    String alamat = txt_alamat.getText();

    // Periksa apakah setiap field telah diisi
    if (idsupplier.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Id Supplier Harus Diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (namasupplier.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nama Supplier Harus Diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (telepon.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Telepon Harus Diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (alamat.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Alamat Harus Diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        String sqlCheck = "SELECT * FROM supplier WHERE Nama_supplier=?";
        java.sql.Connection conn = Aplikasi.Config.configDB();
        java.sql.PreparedStatement pstCheck = conn.prepareStatement(sqlCheck);
        pstCheck.setString(1, namasupplier);
        java.sql.ResultSet rsCheck = pstCheck.executeQuery();

        if (rsCheck.next()) {
            JOptionPane.showMessageDialog(null, "Nama Barang Sudah Ada Dalam Database", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String sql = "INSERT INTO supplier (id_supplier, nama_supplier, telepon, alamat) VALUES (?, ?, ?, ?)";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idsupplier);
            pst.setString(2, namasupplier);
            pst.setString(3, telepon);
            pst.setString(4, alamat);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            tabel_supplier();
            txt_idsupplier.setText(getNextIdSupplier()); // Update ID barang berikutnya setelah penyimpanan berhasil
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
        kosong1();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Mengedit Data Ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String idsupplier = txt_idsupplier.getText();
        String namasupplier = txt_namasupplier.getText();
        String telepon = txt_telepon.getText();
        String alamat = txt_alamat.getText();

        // Periksa apakah nama barang yang diedit sudah ada dalam database
        String sqlCheck = "SELECT * FROM supplier WHERE Nama_supplier=? AND Id_supplier!=?";
        java.sql.Connection conn = Config.configDB();
        java.sql.PreparedStatement pstCheck = conn.prepareStatement(sqlCheck);
        pstCheck.setString(1, namasupplier);
        pstCheck.setString(2, idsupplier);
        java.sql.ResultSet rsCheck = pstCheck.executeQuery();

        if (rsCheck.next()) {
            JOptionPane.showMessageDialog(null, "Nama Supplier Sudah Ada Dalam Database", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String sql = "UPDATE barang SET nama_supplier=?, telepon=?, alamat=? WHERE Id_supplier=?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, namasupplier);
            pst.setString(2, telepon);
            pst.setString(3, alamat);
            pst.setString(4, idsupplier);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            tabel_supplier();
            txt_idsupplier.setText(getNextIdSupplier());
            kosong1();
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal Mengubah Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Menghapus Data Ini?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String sqlbarang = "DELETE FROM supplier WHERE id_supplier=?";
            java.sql.Connection conn = Config.configDB();
            java.sql.PreparedStatement pstbarang = conn.prepareStatement(sqlbarang);
            pstbarang.setString(1, txt_idsupplier.getText());
            pstbarang.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menghapus Data ini", "Success", JOptionPane.INFORMATION_MESSAGE);
            txt_idsupplier.setText(getNextIdSupplier());
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "gagal Menghapus Data Ini: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    tabel_supplier();
    kosong1();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        
    }//GEN-LAST:event_btn_supplierActionPerformed

    private void btn_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barangActionPerformed
        this.dispose();
        new Barang().setVisible(true);
    }//GEN-LAST:event_btn_barangActionPerformed

    private void btn_absenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_absenActionPerformed
        this.dispose();
        new Absen().setVisible(true);
    }//GEN-LAST:event_btn_absenActionPerformed

    private void btn_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanActionPerformed
        this.dispose();
        new Laporan().setVisible(true);
    }//GEN-LAST:event_btn_laporanActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_akunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_akunActionPerformed
        this.dispose();
        new Akun().setVisible(true);
    }//GEN-LAST:event_btn_akunActionPerformed

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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel body;
    private javax.swing.JButton btn_absen;
    private javax.swing.JButton btn_akun;
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_idsupplier;
    private javax.swing.JLabel lbl_namasupplier;
    private javax.swing.JLabel lbl_telepon;
    private javax.swing.JTable tabel_supplier;
    private javax.swing.JFormattedTextField txt_alamat;
    private javax.swing.JFormattedTextField txt_cari;
    private javax.swing.JFormattedTextField txt_idsupplier;
    private javax.swing.JFormattedTextField txt_namasupplier;
    private javax.swing.JLabel txt_tanggal;
    private javax.swing.JFormattedTextField txt_telepon;
    // End of variables declaration//GEN-END:variables
}
