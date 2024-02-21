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

public Barang() {
    initComponents();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");

    // Jadwalkan tugas untuk memperbarui tanggal dan waktu saat ini setiap detik
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            setTanggalDanWaktuSekarang();
        }
    }, 0, 1, TimeUnit.SECONDS);

    // Set tanggal dan waktu saat ini
    setTanggalDanWaktuSekarang();
    setTanggalDanWaktu();
    
    // Mengisi tabel barang dan menginisialisasi formulir barang baru
    tabel_Barang();
    txt_idbarang.setText(getNextIdBarang());
    kosong1();
}

// Dapatkan ID berikutnya untuk barang baru
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

// Mengosongkan input untuk membuat barang baru
private void kosong1() {
    txt_namabarang.setText(null);
    txt_hargajual.setText(null);
    txt_hargabeli.setText(null);
    txt_namasupplier.setText(null);
    txt_stok.setText(null);
    cmb_kategori.setSelectedItem(null);
}

// Mengisi tabel barang
private void tabel_Barang() {
    model = new DefaultTableModel();
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Harga Jual");
    model.addColumn("Harga Beli");
    model.addColumn("Kategori");
    model.addColumn("Stok");
    model.addColumn("Tanggal");
    model.addColumn("Nama Supplier");

    try {
        String sql = "SELECT barang.id_barang, barang.nama_barang, barang.harga_jual, barang.harga_beli, barang.kategori, barang.stok, barang.tanggal, barang.nama_supplier FROM barang";
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id_barang"),
                res.getString("nama_barang"),
                res.getString("harga_jual"),
                res.getString("harga_beli"),
                res.getString("kategori"),
                res.getString("stok"),
                res.getString("tanggal"),
                res.getString("nama_supplier"),
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
        lbl_namasupplier = new javax.swing.JLabel();
        txt_namasupplier = new javax.swing.JFormattedTextField();
        lbl_hargajual = new javax.swing.JLabel();
        txt_hargabeli = new javax.swing.JFormattedTextField();
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
        cmb_kategori = new javax.swing.JComboBox<>();
        lbl_namabarang = new javax.swing.JLabel();
        txt_namabarang = new javax.swing.JFormattedTextField();
        lbl_image = new javax.swing.JLabel();
        txt_idsupplier = new javax.swing.JFormattedTextField();
        txt_tanggalmasuk = new javax.swing.JFormattedTextField();
        txt_idbarang = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setText("Hai Admin, Selamat Di Barang");
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

        lbl_namasupplier.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namasupplier.setText("Nama Supplier");
        getContentPane().add(lbl_namasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

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
        lbl_hargajual.setText("Harga Jual");
        getContentPane().add(lbl_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        txt_hargabeli.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_hargabeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargabeliActionPerformed(evt);
            }
        });
        getContentPane().add(txt_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 140, -1));

        lbl_stok.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok.setText("Stok");
        getContentPane().add(lbl_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, -1, -1));

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
        ));
        tabel_barang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_barangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_barang);

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

        txt_stok.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stokActionPerformed(evt);
            }
        });
        getContentPane().add(txt_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, 140, -1));

        txt_hargajual.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_hargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargajualActionPerformed(evt);
            }
        });
        getContentPane().add(txt_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 140, -1));

        lbl_kategori.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_kategori.setText("Kategori");
        getContentPane().add(lbl_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 100, -1, -1));

        lbl_hargabeli.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargabeli.setText("Harga Beli");
        getContentPane().add(lbl_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        cmb_kategori.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        cmb_kategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elektronik" }));
        getContentPane().add(cmb_kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 120, 140, 30));

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

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_idsupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idsupplierKeyReleased(evt);
            }
        });
        getContentPane().add(txt_idsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 140, -1));

        txt_tanggalmasuk.setText("jFormattedTextField1");
        getContentPane().add(txt_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 240, -1));

        txt_idbarang.setText("jFormattedTextField1");
        getContentPane().add(txt_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, 30));

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

    }//GEN-LAST:event_btn_barangActionPerformed

    private void btn_opnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opnameActionPerformed
        this.setVisible(false);
            new Opname().setVisible(true);
    }//GEN-LAST:event_btn_opnameActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        this.setVisible(false);
            new Return().setVisible(true);
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

    private void txt_namasupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namasupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namasupplierActionPerformed

    private void txt_hargabeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargabeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargabeliActionPerformed

    private void tabel_barangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_barangMouseClicked
        try{                                          
            int baris = tabel_barang.rowAtPoint(evt.getPoint());
            Connection conn = Config.configDB();
            Statement stm = conn.createStatement();
            
            
            // Ambil nilai ID akun dari baris yang dipilih
            String id_barang = tabel_barang.getValueAt(baris, 0).toString();
            txt_idbarang.setText(id_barang);
            System.out.println(id_barang);
            txt_idbarang.setEnabled(false);
            
            // Set nilai username
            txt_namabarang.setText(tabel_barang.getValueAt(baris, 1) == null ? "" : tabel_barang.getValueAt(baris, 1).toString());
            
            // Set nilai username
            txt_hargajual.setText(tabel_barang.getValueAt(baris, 2) == null ? "" : tabel_barang.getValueAt(baris, 2).toString());
            
            // Set nilai telepon
            txt_hargabeli.setText(tabel_barang.getValueAt(baris, 3) == null ? "" : tabel_barang.getValueAt(baris, 3).toString(
            ));
            
            // Set nilai username
            cmb_kategori.setSelectedItem(tabel_barang.getValueAt(baris, 4) == null ? "" : tabel_barang.getValueAt(baris, 4).toString());
            // Set nilai username
            
            txt_stok.setText(tabel_barang.getValueAt(baris, 5) == null ? "" : tabel_barang.getValueAt(baris, 5).toString());
            
            // Set nilai username
            txt_tanggalmasuk.setText(tabel_barang.getValueAt(baris, 6) == null ? "" : tabel_barang.getValueAt(baris, 6).toString());
            
            // set nilai namabarang
            txt_namasupplier.setText(tabel_barang.getValueAt(baris,7) == null ? "" : tabel_barang.getValueAt(baris, 7).toString());
          
        }
        catch(SQLException ex){
            Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabel_barangMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
    // Tampilkan dialog konfirmasi untuk mengedit data
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengedit data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        // Mendapatkan nilai dari inputan
        String namabarang = txt_namabarang.getText(); // Nama barang
        String hargajual = txt_hargajual.getText(); // Harga jual
        String hargabeli = txt_hargabeli.getText(); // Harga beli
        String kategori = (String) cmb_kategori.getSelectedItem(); // Kategori
        String stok = txt_stok.getText(); // Stok
        String tanggal = txt_tanggalmasuk.getText(); // Tanggal masuk
        String namasupplier = txt_namasupplier.getText(); // Nama supplier
        String idsupplier = txt_idsupplier.getText(); // ID supplier
        String idbarang = txt_idbarang.getText(); // ID barang

        Connection conn = Config.configDB();
        
        // Mengecek apakah semua kolom sudah diisi
    if (namabarang.isEmpty() || hargajual.isEmpty() || hargabeli.isEmpty() || kategori.isEmpty() || stok.isEmpty() || tanggal.isEmpty() || namasupplier.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
        return;
    }
    
    // Mengecek panjang inputan
        if (namabarang.length() < 5 || namabarang.length() > 40) {
            JOptionPane.showMessageDialog(null, "Panjang nama barang harus antara 5 hingga 40 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hargajual.length() < 4 || hargajual.length() > 8) {
            JOptionPane.showMessageDialog(null, "Panjang harga jual harus antara 4 hingga 8 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hargabeli.length() < 4 || hargabeli.length() > 8) {
            JOptionPane.showMessageDialog(null, "Panjang harga beli harus antara 4 hingga 8 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (stok.length() < 0 || stok.length() > 4) {
            JOptionPane.showMessageDialog(null, "Panjang stok harus antara 0 hingga 4 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (namasupplier.length() < 5 || namasupplier.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang nama supplier harus antara 5 hingga 30 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        // Update data barang dengan informasi yang diedit
        String sql = "UPDATE barang SET nama_barang=?, harga_jual=?, harga_beli=?, kategori=?, stok=?, tanggal=?, nama_supplier=? WHERE id_barang=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, namabarang);
        pst.setString(2, hargajual);
        pst.setString(3, hargabeli);
        pst.setString(4, kategori);
        pst.setString(5, stok);
        pst.setString(6, tanggal);
        pst.setString(7, namasupplier);
        pst.setString(8, idbarang);
        pst.executeUpdate();

        // Menampilkan pesan sukses
        String successMessage = "Data Barang Berhasil Ditambahkan!\nNama Barang: " + namabarang + "\nHarga Jual: " + hargajual + "\nHarga Beli: " + hargabeli + "\nKategori: " + kategori + "\nStok: " + stok + "\nTanggal Masuk: " + tanggal + "\nNama Supplier: " + namasupplier;
        JOptionPane.showMessageDialog(null, successMessage);

        // Perbarui tabel barang dan kosongkan input
        tabel_Barang();
        kosong1();
        txt_idbarang.setText(getNextIdBarang()); // Update ID barang berikutnya setelah penyimpanan berhasil
    }
} catch (Exception e) {
    // Tampilkan notifikasi jika terjadi kesalahan saat mengubah data
    JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menambahkan barang?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
if (konfirmasi == JOptionPane.YES_OPTION) {
    try {
        // Mendapatkan nilai dari inputan form
        String idbarang = txt_idbarang.getText(); // ID barang
        String namabarang = txt_namabarang.getText(); // Nama barang
        String hargajual = txt_hargajual.getText(); // Harga jual
        String hargabeli = txt_hargabeli.getText(); // Harga beli
        String kategori = (String) cmb_kategori.getSelectedItem(); // Kategori
        String stok = txt_stok.getText(); // Stok
        String tanggal = txt_tanggalmasuk.getText(); // Tanggal masuk
        String namasupplier = txt_namasupplier.getText(); // Nama supplier

        // Membuat koneksi ke database
        Connection conn = Config.configDB();

        // Mengecek apakah semua kolom sudah diisi
        if (namabarang.isEmpty() || hargajual.isEmpty() || hargabeli.isEmpty() || kategori.isEmpty() || stok.isEmpty() || tanggal.isEmpty() || namasupplier.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
            return;
        }

        // Mengecek panjang inputan
        if (namabarang.length() < 5 || namabarang.length() > 40) {
            JOptionPane.showMessageDialog(null, "Panjang nama barang harus antara 5 hingga 40 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hargajual.length() < 4 || hargajual.length() > 8) {
            JOptionPane.showMessageDialog(null, "Panjang harga jual harus antara 4 hingga 8 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (hargabeli.length() < 4 || hargabeli.length() > 8) {
            JOptionPane.showMessageDialog(null, "Panjang harga beli harus antara 4 hingga 8 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (stok.length() < 0 || stok.length() > 4) {
            JOptionPane.showMessageDialog(null, "Panjang stok harus antara 0 hingga 4 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (namasupplier.length() < 5 || namasupplier.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang nama supplier harus antara 5 hingga 30 karakter", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simpan data ke database
        String insertSql = "INSERT INTO barang (id_barang, nama_barang, harga_jual, harga_beli, kategori, stok, tanggal, nama_supplier) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertPst = conn.prepareStatement(insertSql);
        insertPst.setString(1, idbarang);
        insertPst.setString(2, namabarang);
        insertPst.setString(3, hargajual);
        insertPst.setString(4, hargabeli);
        insertPst.setString(5, kategori);
        insertPst.setString(6, stok);
        insertPst.setString(7, tanggal);
        insertPst.setString(8, namasupplier);
        insertPst.execute();

        // Menampilkan pesan sukses
        String successMessage = "Data Barang Berhasil Ditambahkan!\nNama Barang: " + namabarang + "\nHarga Jual: " + hargajual + "\nHarga Beli: " + hargabeli + "\nKategori: " + kategori + "\nStok: " + stok + "\nTanggal Masuk: " + tanggal + "\nNama Supplier: " + namasupplier;
        JOptionPane.showMessageDialog(null, successMessage);

        // Refresh tabel barang
        tabel_Barang();
        txt_idbarang.setText(getNextIdBarang()); // Update ID barang berikutnya setelah penyimpanan berhasil

        // Kosongkan input
        kosong1();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Perbarui tabel barang
    tabel_Barang();

    // Kosongkan input
    kosong1();
} else {
    JOptionPane.showMessageDialog(null, "Penambahan barang dibatalkan");
}
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
            // Tampilkan dialog konfirmasi penghapusan data
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Hapus data supplier berdasarkan ID
                String sqlbarang = "DELETE FROM barang WHERE id_barang=?";
                Connection conn = Config.configDB();
                PreparedStatement pstbarang = conn.prepareStatement(sqlbarang);
                pstbarang.setString(1, txt_idbarang.getText());
                pstbarang.executeUpdate();

                // Tampilkan notifikasi sukses
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                // Generate ID baru untuk supplier selanjutnya
                txt_idbarang.setText(getNextIdBarang());
            }
        } catch (Exception e) {
            // Tampilkan notifikasi gagal
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Perbarui tabel supplier
        tabel_Barang();

        // Kosongkan input
        kosong1();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txt_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stokActionPerformed

    private void txt_hargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargajualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargajualActionPerformed

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed

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

    private void txt_idsupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idsupplierKeyReleased

    }//GEN-LAST:event_txt_idsupplierKeyReleased

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
    private javax.swing.JComboBox<String> cmb_kategori;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_hargabeli;
    private javax.swing.JLabel lbl_hargajual;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_kategori;
    private javax.swing.JLabel lbl_namabarang;
    private javax.swing.JLabel lbl_namasupplier;
    private javax.swing.JLabel lbl_stok;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JFormattedTextField txt_hargabeli;
    private javax.swing.JFormattedTextField txt_hargajual;
    private javax.swing.JFormattedTextField txt_idbarang;
    private javax.swing.JFormattedTextField txt_idsupplier;
    private javax.swing.JFormattedTextField txt_namabarang;
    private javax.swing.JFormattedTextField txt_namasupplier;
    private javax.swing.JFormattedTextField txt_stok;
    private javax.swing.JFormattedTextField txt_tanggalmasuk;
    // End of variables declaration//GEN-END:variables
}
