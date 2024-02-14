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

public class Barang extends javax.swing.JFrame {
    String Tanggal;
    private DefaultTableModel model;
     
    public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss");
    String formattedDateTime = dateTime.format(formatter);
    txt_tanggal.setText(formattedDateTime);
}
    public Barang() {
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
          tabel_barang();
          txt_idbarang.setText(getNextIdBarang());
          kosong();
          Date date = new Date();
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd ");
                txt_tanggalmasuk.setText(s.format(date));
    }
    
     private String getNextIdBarang() {
    try {
        String sql = "SELECT MAX(Id_barang) AS max_id FROM barang";
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
        JOptionPane.showMessageDialog(null, "Gagal Mengambil Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        return "";
    }
}
     
     private void kosong(){
        txt_idsupplier.setText(null);
        txt_namabarang.setText(null);
        txt_kategori.setText(null);
        txt_stok.setText(null);
        txt_hargajual.setText(null);
        txt_hargabeli.setText(null);
    }

    private void tabel_barang() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Kategori");
    model.addColumn("Harga");
    model.addColumn("Stok");
    model.addColumn("Harga Jual");
    model.addColumn("Harga Beli");
    model.addColumn("Id Supplier");

    try {
        int no = 1;
        String sql = "SELECT barang.id_barang, barang.nama_barang, barang.kategori, barang.harga_jual, barang.harga_beli, barang.stok, barang.tanggal, barang.id_supplier FROM barang";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("kategori"),
                    res.getString("harga_jual"),
                    res.getString("harga_beli"),
                    res.getString("stok"),
                    res.getString("tanggal"),
                    res.getString("id_supplier")
            });
        }
        tabel_barang.setModel(model);
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
        lbl_idbarang = new javax.swing.JLabel();
        txt_idbarang = new javax.swing.JFormattedTextField();
        lbl_idsupplier = new javax.swing.JLabel();
        txt_idsupplier = new javax.swing.JFormattedTextField();
        lbl_tanggalmasuk = new javax.swing.JLabel();
        txt_tanggalmasuk = new javax.swing.JFormattedTextField();
        lbl_stok = new javax.swing.JLabel();
        txt_kategori = new javax.swing.JFormattedTextField();
        lbl_namabarang = new javax.swing.JLabel();
        txt_namabarang = new javax.swing.JFormattedTextField();
        lbl_kategori = new javax.swing.JLabel();
        txt_stok = new javax.swing.JFormattedTextField();
        lbl_hargabeli = new javax.swing.JLabel();
        txt_hargabeli = new javax.swing.JFormattedTextField();
        lbl_hargajual = new javax.swing.JLabel();
        txt_hargajual = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
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

        lbl_idbarang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_idbarang.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idbarang.setText("Id Barang");
        getContentPane().add(lbl_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        txt_idbarang.setEnabled(false);
        txt_idbarang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_idbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idbarangActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, 30));

        lbl_idsupplier.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_idsupplier.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idsupplier.setText("Id Supplier");
        getContentPane().add(lbl_idsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        txt_idsupplier.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_idsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idsupplierActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 100, 30));

        lbl_tanggalmasuk.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_tanggalmasuk.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggalmasuk.setText("Tanggal");
        getContentPane().add(lbl_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, -1, -1));

        txt_tanggalmasuk.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_tanggalmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tanggalmasukActionPerformed(evt);
            }
        });
        getContentPane().add(txt_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 130, 140, 30));

        lbl_stok.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_stok.setForeground(new java.awt.Color(255, 255, 255));
        lbl_stok.setText("Stok");
        getContentPane().add(lbl_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 170, -1, -1));

        txt_kategori.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kategoriActionPerformed(evt);
            }
        });
        getContentPane().add(txt_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 390, 30));

        lbl_namabarang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_namabarang.setForeground(new java.awt.Color(255, 255, 255));
        lbl_namabarang.setText("Nama Barang");
        getContentPane().add(lbl_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

        txt_namabarang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarangActionPerformed(evt);
            }
        });
        getContentPane().add(txt_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 390, 30));

        lbl_kategori.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_kategori.setForeground(new java.awt.Color(255, 255, 255));
        lbl_kategori.setText("Kategori");
        getContentPane().add(lbl_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        txt_stok.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stokActionPerformed(evt);
            }
        });
        getContentPane().add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 190, 140, 30));

        lbl_hargabeli.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_hargabeli.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hargabeli.setText("Harga Beli");
        getContentPane().add(lbl_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 110, -1, -1));

        txt_hargabeli.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_hargabeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargabeliActionPerformed(evt);
            }
        });
        getContentPane().add(txt_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 130, 130, 30));

        lbl_hargajual.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_hargajual.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hargajual.setText("Harga Jual");
        getContentPane().add(lbl_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 170, -1, -1));

        txt_hargajual.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_hargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargajualActionPerformed(evt);
            }
        });
        getContentPane().add(txt_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 190, 130, 30));

        tabel_barang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Barang", "Id Supplier", "Nama Barang", "Harga", "Stok", "Diskon", "Garansi", "Kategori"
            }
        ));
        tabel_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_barang);

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

        body.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Small.png"))); // NOI18N
        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idbarangActionPerformed

    private void txt_idsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idsupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idsupplierActionPerformed

    private void txt_tanggalmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tanggalmasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tanggalmasukActionPerformed

    private void txt_kategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kategoriActionPerformed

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stokActionPerformed

    private void txt_hargabeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargabeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargabeliActionPerformed

    private void txt_hargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargajualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargajualActionPerformed

    private void tabel_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barangMouseClicked
        int baris = tabel_barang.rowAtPoint(evt.getPoint());
String id_barang = tabel_barang.getValueAt(baris, 0).toString();
txt_idbarang.setText(id_barang);
System.out.println(id_barang);
txt_idbarang.disable();

if (tabel_barang.getValueAt(baris, 1) == null) {
    txt_namabarang.setText("");
} else {
    txt_namabarang.setText(tabel_barang.getValueAt(baris, 1).toString());
}

if (tabel_barang.getValueAt(baris, 2) == null) {
    txt_kategori.setText("");
} else {
    txt_kategori.setText(tabel_barang.getValueAt(baris, 2).toString());
}

if (tabel_barang.getValueAt(baris, 3) == null) {
    txt_hargajual.setText("");
} else {
    txt_hargajual.setText(tabel_barang.getValueAt(baris, 3).toString());
}

if (tabel_barang.getValueAt(baris, 4) == null) {
    txt_hargabeli.setText("");
} else {
    txt_hargabeli.setText(tabel_barang.getValueAt(baris, 4).toString());
}

if (tabel_barang.getValueAt(baris, 5) == null) {
    txt_stok.setText("");
} else {
    txt_stok.setText(tabel_barang.getValueAt(baris, 5).toString());
}

if (tabel_barang.getValueAt(baris, 6) == null) {
    txt_tanggalmasuk.setText("");
} else {
    txt_tanggalmasuk.setText(tabel_barang.getValueAt(baris, 6).toString());
}

if (tabel_barang.getValueAt(baris, 7) == null) {
    txt_idsupplier.setText("");
} else {
    txt_idsupplier.setText(tabel_barang.getValueAt(baris, 7).toString());
}
    }//GEN-LAST:event_tabel_barangMouseClicked

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        try {
    Connection conn = Config.configDB();
    Statement statement = conn.createStatement();
    String searchKeyword = txt_cari.getText();
    String sql = "SELECT * FROM barang WHERE Nama_barang LIKE ?";
    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setString(1, "%" + searchKeyword + "%");
    ResultSet res = pst.executeQuery();

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Barang");
    model.addColumn("Nama Supplier");
    model.addColumn("Kategori");
    model.addColumn("Harga Jual");
    model.addColumn("Stok Beli");
    model.addColumn("Stok");
    model.addColumn("Tanggal");
    model.addColumn("Id Supplier");
    tabel_barang.setModel(model);

    int no = 1;
    while (res.next()) {
        model.addRow(new Object[]{
            res.getString("id_barang"),
            res.getString("nama_barang"),
            res.getString("kategori"),
            res.getString("harga_jual"),
            res.getString("harga_beli"),
            res.getString("stok"),
            res.getString("tanggal"),
            res.getString("id_supplier")
        });
        no++;
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(rootPane, "Gagal Mengambil Data: " + e.getMessage());
}
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        try {
    String idBarang = txt_idbarang.getText();
    String idSupplier = txt_idsupplier.getText();
    String namaBarang = txt_namabarang.getText();
    String hargaJual = txt_hargajual.getText();
    String stok = txt_stok.getText();
    String hargaBeli = txt_hargabeli.getText();
    String tanggalMasuk = txt_tanggalmasuk.getText();
    String kategori = txt_kategori.getText();

    // Validasi panjang dan karakter username
    if (namaBarang.length() < 3 || namaBarang.length() > 50) {
        JOptionPane.showMessageDialog(null, "Nama Barang Harus Diisi Dengan Panjang Minimal 5 Karakter Dan Maksimal 50 Karakter");
        return;
    }
    
    // Validasi panjang dan karakter username
    if (kategori.length() < 5 || kategori.length() > 50) {
        JOptionPane.showMessageDialog(null, "Kategori Harus Diisi Dengan Panjang Minimal 5 Karakter Dan Maksimal 50 Karakter");
        return;
    }
    
    // Validasi panjang dan karakter username
    if (hargaJual.length() < 4 || hargaJual.length() > 8) {
        JOptionPane.showMessageDialog(null, "Harga Jual Harus Diisi Dengan Panjang Minimal 4 Karakter Dan Maksimal 8 Karakter");
        return;
    }
    
    // Validasi panjang dan karakter username
    if (hargaBeli.length() < 4 || hargaBeli.length() > 8) {
        JOptionPane.showMessageDialog(null, "Harga Beli Harus Diisi Dengan Panjang Minimal 4 Karakter Dan Maksimal 8 Karakter");
        return;
    }
    
    // Validasi panjang dan karakter username
    if (stok.length() < 1 || stok.length() > 3) {
        JOptionPane.showMessageDialog(null, "Stok Harus Diisi Dengan Panjang Minimal 1 Karakter Dan Maksimal 3 Karakter");
        return;
    }
    
    // Validasi panjang dan karakter username
    if (idSupplier.length() < 1 || idSupplier.length() > 3) {
        JOptionPane.showMessageDialog(null, "Id Supplier Harus Diisi Dengan Panjang Minimal 1 Karakter Dan Maksimal 3 Karakter");
        return;
    }
    
    // Periksa apakah setiap field telah diisi
    if (idSupplier.isEmpty()) {
        JOptionPane.showMessageDialog(null, "ID Supplier harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (namaBarang.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nama Barang harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (hargaJual.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Harga Jual harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (stok.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Stok harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (hargaBeli.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Harga Beli harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (kategori.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Kategori harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        String sqlCheck = "SELECT * FROM barang WHERE Nama_barang=?";
        java.sql.Connection conn = Aplikasi.Config.configDB();
        java.sql.PreparedStatement pstCheck = conn.prepareStatement(sqlCheck);
        pstCheck.setString(1, namaBarang);
        java.sql.ResultSet rsCheck = pstCheck.executeQuery();

        if (rsCheck.next()) {
            JOptionPane.showMessageDialog(null, "Nama Barang Sudah Ada Dalam Database", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String sql = "INSERT INTO barang (id_barang, nama_barang, kategori, harga_jual, harga_beli, stok, tanggal, id_supplier) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idBarang);
            pst.setString(2, namaBarang);
            pst.setString(3, kategori);
            pst.setString(4, hargaJual);
            pst.setString(5, hargaBeli);
            pst.setString(6, stok);
            pst.setString(7, tanggalMasuk);
            pst.setString(8, idSupplier);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            tabel_barang();
            txt_idbarang.setText(getNextIdBarang()); // Update ID barang berikutnya setelah penyimpanan berhasil
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
kosong();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Mengedit Data Ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String idSupplier = txt_idsupplier.getText();
        String namaBarang = txt_namabarang.getText();
        String hargaJual = txt_hargajual.getText();
        String stok = txt_stok.getText();
        String hargaBeli = txt_hargabeli.getText();
        String tanggal = txt_tanggalmasuk.getText();
        String kategori = txt_kategori.getText();
        String idBarang = txt_idbarang.getText();

        // Periksa apakah nama barang yang diedit sudah ada dalam database
        String sqlCheck = "SELECT * FROM barang WHERE Nama_barang=? AND Id_barang!=?";
        java.sql.Connection conn = Config.configDB();
        java.sql.PreparedStatement pstCheck = conn.prepareStatement(sqlCheck);
        pstCheck.setString(1, namaBarang);
        pstCheck.setString(2, idBarang);
        java.sql.ResultSet rsCheck = pstCheck.executeQuery();

        if (rsCheck.next()) {
            JOptionPane.showMessageDialog(null, "Nama Barang Sudah Ada Dalam Database", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String sql = "UPDATE barang SET nama_barang=?, kategori=?, harga_jual=?, harga_beli=?, stok=?, tangal=?, id_supplier=? WHERE Id_barang=?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, namaBarang);
            pst.setString(2, kategori);
            pst.setString(3, hargaJual);
            pst.setString(4, hargaBeli);
            pst.setString(5, stok);
            pst.setString(6, tanggal);
            pst.setString(7, idSupplier);
            pst.setString(8, idBarang);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            tabel_barang();
            txt_idbarang.setText(getNextIdBarang());
            kosong();
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal Mengubah Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Data Ini??", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String sqlbarang = "DELETE FROM barang WHERE id_barang=?";
        java.sql.Connection conn = Config.configDB();
        java.sql.PreparedStatement pstbarang = conn.prepareStatement(sqlbarang);
        pstbarang.setString(1, txt_idbarang.getText());
        pstbarang.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        txt_idbarang.setText(getNextIdBarang());
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
tabel_barang();
kosong();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_akunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_akunActionPerformed
        this.dispose();
        new Akun().setVisible(true);
    }//GEN-LAST:event_btn_akunActionPerformed

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        this.dispose();
        new Supplier().setVisible(true);
    }//GEN-LAST:event_btn_supplierActionPerformed

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

    private void btn_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_barangActionPerformed

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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barang().setVisible(true);
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
    private javax.swing.JLabel lbl_hargabeli;
    private javax.swing.JLabel lbl_hargajual;
    private javax.swing.JLabel lbl_idbarang;
    private javax.swing.JLabel lbl_idsupplier;
    private javax.swing.JLabel lbl_kategori;
    private javax.swing.JLabel lbl_namabarang;
    private javax.swing.JLabel lbl_stok;
    private javax.swing.JLabel lbl_tanggalmasuk;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JFormattedTextField txt_cari;
    private javax.swing.JFormattedTextField txt_hargabeli;
    private javax.swing.JFormattedTextField txt_hargajual;
    private javax.swing.JFormattedTextField txt_idbarang;
    private javax.swing.JFormattedTextField txt_idsupplier;
    private javax.swing.JFormattedTextField txt_kategori;
    private javax.swing.JFormattedTextField txt_namabarang;
    private javax.swing.JFormattedTextField txt_stok;
    private javax.swing.JLabel txt_tanggal;
    private javax.swing.JFormattedTextField txt_tanggalmasuk;
    // End of variables declaration//GEN-END:variables
}
