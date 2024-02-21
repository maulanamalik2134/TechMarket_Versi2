package Tampilan_Admin;

import Config.Config;
import Tampilan_Awal.Absen;
import Tampilan_Awal.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Oprasional extends javax.swing.JFrame {
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

public Oprasional() {
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
    tabel_Oprasional();
    txt_idoprasional.setText(getNextIdOprasional());
    kosong1();
}

// Dapatkan ID berikutnya untuk barang baru
private String getNextIdOprasional() {
    try {
        String sql = "SELECT MAX(Id_oprasional) AS max_id FROM oprasional";
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
    txt_keterangan.setText(null);
    txt_total.setText(null);
    txt_username.setText(null);
}

// Mengisi tabel barang
private void tabel_Oprasional() {
    model = new DefaultTableModel();
    model.addColumn("Id Oprasional");
    model.addColumn("Katerangan");
    model.addColumn("Total");
    model.addColumn("Tanggal");
    model.addColumn("Id Akun");
    model.addColumn("Username");

    try {
        String sql = "SELECT oprasional.id_oprasional, oprasional.keterangan, oprasional.total, oprasional.tanggal, oprasional.id_akun, oprasional.username FROM oprasional";
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id_oprasional"),
                res.getString("keterangan"),
                res.getString("total"),
                res.getString("tanggal"),
                res.getString("id_akun"),
                res.getString("Username"),
            });
        }
        txt_oprasional.setModel(model);
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
        txt_keterangan = new javax.swing.JFormattedTextField();
        lbl_namabarang = new javax.swing.JLabel();
        lbl_hargajual = new javax.swing.JLabel();
        txt_total = new javax.swing.JFormattedTextField();
        lbl_hargabeli = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        btn_edit = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_oprasional = new javax.swing.JTable();
        btn_hapus = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        txt_tanggalmasuk = new javax.swing.JFormattedTextField();
        txt_idakun = new javax.swing.JFormattedTextField();
        lbl_hargabeli1 = new javax.swing.JLabel();
        txt_idoprasional = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setText("Hai Admin, Selamat Datang Di Oprasional");
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

        txt_keterangan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_keterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_keteranganActionPerformed(evt);
            }
        });
        getContentPane().add(txt_keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 310, -1));

        lbl_namabarang.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namabarang.setText("Keterangan");
        getContentPane().add(lbl_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        lbl_hargajual.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargajual.setText("Total");
        getContentPane().add(lbl_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        txt_total.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        getContentPane().add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 140, -1));

        lbl_hargabeli.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargabeli.setText("Username");
        getContentPane().add(lbl_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

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
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 160, -1));

        btn_edit.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(153, 153, 0));
        btn_edit.setText("Edit");
        btn_edit.setContentAreaFilled(false);
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 170, -1, -1));

        btn_tambah.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(0, 204, 0));
        btn_tambah.setText("Tambah");
        btn_tambah.setContentAreaFilled(false);
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 170, -1, -1));

        txt_oprasional.setModel(new javax.swing.table.DefaultTableModel(
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
        txt_oprasional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_oprasionalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txt_oprasional);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 210, 1070, 450));

        btn_hapus.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(153, 0, 0));
        btn_hapus.setText("Hapus");
        btn_hapus.setContentAreaFilled(false);
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 170, -1, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_tanggalmasuk.setText("jFormattedTextField1");
        getContentPane().add(txt_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 200, 240, -1));

        txt_idakun.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_idakun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idakunActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 160, -1));

        lbl_hargabeli1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargabeli1.setText("Id Akun");
        getContentPane().add(lbl_hargabeli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 100, -1, -1));

        txt_idoprasional.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_idoprasional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idoprasionalActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idoprasional, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 120, 160, -1));

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
        this.setVisible(false);
            new Return().setVisible(true);
    }//GEN-LAST:event_btn_returnActionPerformed

    private void btn_absenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_absenActionPerformed
        this.setVisible(false);
            new Absen_Admin().setVisible(true);
    }//GEN-LAST:event_btn_absenActionPerformed

    private void btn_oprasionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_oprasionalActionPerformed

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

    private void txt_keteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_keteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_keteranganActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_idakunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idakunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idakunActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
    // Tampilkan dialog konfirmasi untuk mengedit data
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengedit data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String username = txt_username.getText();
        String total = txt_total.getText();
        String keterangan = txt_keterangan.getText();
        String tanggal = txt_tanggalmasuk.getText();
        String idakun = txt_idakun.getText();
        String idoprasional = txt_idoprasional.getText();

        Connection conn = Config.configDB();

        // Mengecek apakah username, total, dan keterangan sudah diisi
        if (username.isEmpty() || total.isEmpty() || keterangan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
            return;
        }

        // Mengecek panjang username, total, dan keterangan
        if (username.length() < 5 || username.length() > 15) {
            JOptionPane.showMessageDialog(null, "Panjang nama username harus antara 5 hingga 15 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (total.length() < 4 || total.length() > 8) {
            JOptionPane.showMessageDialog(null, "Panjang total harus antara 4 hingga 8 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (keterangan.length() < 5 || keterangan.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang keterangan harus antara 5 hingga 15 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update data oprasional dengan informasi yang diedit
        String sql = "UPDATE oprasional SET keterangan=?, total=?, tanggal=?, id_akun=?, username=? WHERE Id_oprasional=?";
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, keterangan);
        pst.setString(2, total);
        pst.setString(3, tanggal);
        pst.setString(4, idakun);
        pst.setString(5, username);
        pst.setString(6, idoprasional);
        pst.executeUpdate();

        // Tampilkan notifikasi sukses dengan username, total, dan keterangan
        String successMessage = "Data berhasil diubah!\nUsername: " + username + "\nTotal: " + total + "\nKeterangan: " + keterangan;
        JOptionPane.showMessageDialog(null, successMessage, "Berhasil", JOptionPane.INFORMATION_MESSAGE);

        // Perbarui tabel oprasional, ID oprasional, dan kosongkan input
        tabel_Oprasional();
        txt_idoprasional.setText(getNextIdOprasional());
        kosong1();
    }
} catch (Exception e) {
    // Tampilkan notifikasi jika terjadi kesalahan saat mengubah data
    JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        try {
    // Mendapatkan nilai dari inputan form
    int idoprasional = Integer.parseInt(txt_idoprasional.getText());
    String username = txt_username.getText();
    String total = txt_total.getText();
    String keterangan = txt_keterangan.getText();
    String tanggal = txt_tanggalmasuk.getText();
    String idakun = txt_idakun.getText();

    // Membuat koneksi ke database
    Connection conn = Config.configDB();

    // Mengecek apakah username, total, dan keterangan sudah diisi
    if (username.isEmpty() || total.isEmpty() || keterangan.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
        return;
    }

    // Mengecek panjang username, total, dan keterangan
    if (username.length() < 5 || username.length() > 15) {
        JOptionPane.showMessageDialog(null, "Panjang nama username harus antara 5 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (keterangan.length() < 5 || keterangan.length() > 30) {
        JOptionPane.showMessageDialog(null, "Panjang keterangan harus antara 5 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (total.length() < 4 || total.length() > 8) {
        JOptionPane.showMessageDialog(null, "Panjang total harus antara 4 hingga 8 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Tampilkan dialog konfirmasi untuk menyimpan data
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        // Simpan data ke database
        String insertSql = "INSERT INTO oprasional (Id_oprasional, username, total, keterangan, tanggal, id_akun) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement insertPst = conn.prepareStatement(insertSql);
        insertPst.setInt(1, idoprasional);
        insertPst.setString(2, username);
        insertPst.setString(3, total);
        insertPst.setString(4, keterangan);
        insertPst.setString(5, tanggal);
        insertPst.setString(6, idakun);
        insertPst.execute();

        // Menampilkan pesan sukses dengan username
        String successMessage = "Data berhasil disimpan!\nUsername: " + username + "\nTotal: " + total + "\nKeterangan: " + keterangan;
        JOptionPane.showMessageDialog(null, successMessage);

        // Refresh tabel oprasional
        tabel_Oprasional();
        txt_idoprasional.setText(getNextIdOprasional()); // Update ID oprasional berikutnya setelah penyimpanan berhasil
        // Kosongkan input
        kosong1();
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void txt_oprasionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_oprasionalMouseClicked
        int baris = txt_oprasional.rowAtPoint(evt.getPoint());

        // Ambil nilai ID akun dari baris yang dipilih
        String idoprasional = txt_oprasional.getValueAt(baris, 0).toString();
        txt_idoprasional.setText(idoprasional);
        System.out.println(idoprasional);
        txt_idoprasional.setEnabled(false);

        // Set nilai telepon
        txt_keterangan.setText(txt_oprasional.getValueAt(baris, 1) == null ? "" : txt_oprasional.getValueAt(baris, 1).toString());

        // Set nilai alamat
        txt_total.setText(txt_oprasional.getValueAt(baris, 2) == null ? "" : txt_oprasional.getValueAt(baris, 2).toString());
        
        // Set nilai username
        txt_tanggalmasuk.setText(txt_oprasional.getValueAt(baris, 3) == null ? "" : txt_oprasional.getValueAt(baris, 3).toString());

        // Set nilai telepon
        txt_idakun.setText(txt_oprasional.getValueAt(baris, 4) == null ? "" : txt_oprasional.getValueAt(baris, 4).toString());

        // Set nilai alamat
        txt_username.setText(txt_oprasional.getValueAt(baris, 5) == null ? "" : txt_oprasional.getValueAt(baris, 5).toString());
    }//GEN-LAST:event_txt_oprasionalMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
            // Tampilkan dialog konfirmasi penghapusan data
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Hapus data supplier berdasarkan ID
                String sqlbarang = "DELETE FROM oprasional WHERE id_oprasional=?";
                Connection conn = Config.configDB();
                PreparedStatement pstbarang = conn.prepareStatement(sqlbarang);
                pstbarang.setString(1, txt_idoprasional.getText());
                pstbarang.executeUpdate();

                // Tampilkan notifikasi sukses
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                // Generate ID baru untuk supplier selanjutnya
                txt_idoprasional.setText(getNextIdOprasional());
            }
        } catch (Exception e) {
            // Tampilkan notifikasi gagal
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Perbarui tabel supplier
        tabel_Oprasional();

        // Kosongkan input
        kosong1();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txt_idoprasionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idoprasionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idoprasionalActionPerformed

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
            java.util.logging.Logger.getLogger(Oprasional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Oprasional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Oprasional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Oprasional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Oprasional().setVisible(true);
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
    private javax.swing.JLabel lbl_hargabeli;
    private javax.swing.JLabel lbl_hargabeli1;
    private javax.swing.JLabel lbl_hargajual;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_namabarang;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JFormattedTextField txt_idakun;
    private javax.swing.JFormattedTextField txt_idoprasional;
    private javax.swing.JFormattedTextField txt_keterangan;
    private javax.swing.JTable txt_oprasional;
    private javax.swing.JFormattedTextField txt_tanggalmasuk;
    private javax.swing.JFormattedTextField txt_total;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
