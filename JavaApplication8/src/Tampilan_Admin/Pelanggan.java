package Tampilan_Admin;

import Config.Config;
import Tampilan_Awal.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Pelanggan extends javax.swing.JFrame {
private DefaultTableModel model;

public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
    String formattedDateTime = dateTime.format(formatter);
    lbl_tanggal.setText(formattedDateTime);
}

public Pelanggan() {
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
    tabel_supplier();
    txt_idpelanggan.setText(getNextIdPelanggan());
    kosong1();
}

private String getNextIdPelanggan() {
    try {
        String sql = "SELECT MAX(Id_pelanggan) AS max_id FROM pelanggan";
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
    txt_username.setText(null);
    txt_telepon.setText(null);
    txt_alamat.setText(null);
}

private void tabel_supplier() {
    model = new DefaultTableModel();
    model.addColumn("Id Pelanggan");
    model.addColumn("Pelanggan");
    model.addColumn("Telepon");
    model.addColumn("Alamat");

    try {
        int no = 1;
        String sql = "SELECT pelanggan.id_pelanggan, pelanggan.pelanggan, pelanggan.telepon, pelanggan.alamat FROM pelanggan";
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id_pelanggan"),
                res.getString("pelanggan"),
                res.getString("telepon"),
                res.getString("alamat"),
            });
        }
        tabel_supplier.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Gagal mengisi tabel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bab = new javax.swing.JLabel();
        lbl_tanggal = new javax.swing.JLabel();
        lbl_username = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        lbl_telepon = new javax.swing.JLabel();
        lbl_alamat = new javax.swing.JLabel();
        txt_alamat = new javax.swing.JFormattedTextField();
        btn_edit = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        txt_telepon = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_supplier = new javax.swing.JTable();
        btn_akun = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btn_barang = new javax.swing.JButton();
        gambar = new javax.swing.JLabel();
        btn_dashboard = new javax.swing.JButton();
        btn_datamaster = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_opname = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        txt_idpelanggan = new javax.swing.JFormattedTextField();
        lbl_username1 = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setForeground(new java.awt.Color(255, 255, 255));
        bab.setText("Hai Admin, Selamat datang Di Data Pelanggan");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1120, 50));

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        lbl_username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_username.setText("Id Pelanggan");
        getContentPane().add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        txt_username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 310, -1));

        lbl_telepon.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_telepon.setText("Telepon");
        getContentPane().add(lbl_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 100, -1, -1));

        lbl_alamat.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_alamat.setText("Alamat");
        getContentPane().add(lbl_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, -1, -1));

        txt_alamat.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 120, 310, -1));

        btn_edit.setBackground(new java.awt.Color(255, 255, 255));
        btn_edit.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Pencil (1).png"))); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 160, 140, -1));

        btn_tambah.setBackground(new java.awt.Color(255, 255, 255));
        btn_tambah.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Plus Math (1).png"))); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 160, 140, -1));

        btn_hapus.setBackground(new java.awt.Color(255, 255, 255));
        btn_hapus.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Delete (1).png"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 160, 140, -1));

        txt_telepon.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_telepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teleponActionPerformed(evt);
            }
        });
        getContentPane().add(txt_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 140, -1));

        tabel_supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "Id Pelanggan", "Nama Pelanggan", "Email", "Telepon", "Alamat"
            }
        ));
        tabel_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_supplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_supplier);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 200, 1070, 460));

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

        btn_barang.setBackground(new java.awt.Color(255, 255, 255));
        btn_barang.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_barang.setText("Data Barang");
        btn_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barangActionPerformed(evt);
            }
        });
        getContentPane().add(btn_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 180, 30));

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

        txt_idpelanggan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_idpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idpelangganActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idpelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 110, 30));

        lbl_username1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_username1.setText("Pelanggan");
        getContentPane().add(lbl_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, -1, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
     
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengedit data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String username = txt_username.getText();
        String telepon = txt_telepon.getText();
        String alamat = txt_alamat.getText();
        String idsupplier = txt_idpelanggan.getText();
        Connection conn = Config.configDB();

        if (username.isEmpty() || telepon.isEmpty() || alamat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
            return;
        } else if (username.length() < 5 || username.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang nama supplier harus antara 5 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!username.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "Username harus terdiri dari huruf dan spasi saja.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (alamat.length() < 1 || alamat.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang alamat harus antara 1 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!alamat.matches("[a-zA-Z0-9- ]+")) {
            JOptionPane.showMessageDialog(null, "Alamat hanya boleh terdiri dari huruf, angka, spasi, atau tanda '-'", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (telepon.length() < 1 || telepon.length() > 13) {
            JOptionPane.showMessageDialog(null, "Panjang nomor telepon harus antara 1 hingga 13 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!telepon.matches("[0-9-]+")) {
            JOptionPane.showMessageDialog(null, "Nomor telepon hanya boleh terdiri dari angka atau tanda '-'", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sqlCheck = "SELECT * FROM pelanggan WHERE pelanggan=? AND Id_pelanggan!=?";
        PreparedStatement pstCheck = conn.prepareStatement(sqlCheck);
        pstCheck.setString(1, username);
        pstCheck.setString(2, idsupplier);
        ResultSet rsCheck = pstCheck.executeQuery();

        if (rsCheck.next()) {
            JOptionPane.showMessageDialog(null, "Username sudah ada dalam database", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String sql = "UPDATE pelanggan SET pelanggan=?, telepon=?, alamat=? WHERE Id_pelanggan=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, telepon);
            pst.setString(3, alamat);
            pst.setString(4, idsupplier);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil diedit", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            tabel_supplier();
            txt_idpelanggan.setText(getNextIdPelanggan());
            kosong1();
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        try {
    int idakun = Integer.parseInt(txt_idpelanggan.getText());
    String username = txt_username.getText();
    String alamat = txt_alamat.getText();
    String telepon = txt_telepon.getText();
    Connection conn = Config.configDB();

    if (username.isEmpty() || telepon.isEmpty() || alamat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
            return;
        } else if (username.length() < 5 || username.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang nama supplier harus antara 5 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!username.matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "Username harus terdiri dari huruf dan spasi saja.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (alamat.length() < 1 || alamat.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang alamat harus antara 1 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!alamat.matches("[a-zA-Z0-9- ]+")) {
            JOptionPane.showMessageDialog(null, "Alamat hanya boleh terdiri dari huruf, angka, spasi, atau tanda '-'", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (telepon.length() < 1 || telepon.length() > 13) {
            JOptionPane.showMessageDialog(null, "Panjang nomor telepon harus antara 1 hingga 13 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!telepon.matches("[0-9-]+")) {
            JOptionPane.showMessageDialog(null, "Nomor telepon hanya boleh terdiri dari angka atau tanda '-'", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        }

    String checkSql = "SELECT COUNT(*) FROM pelanggan WHERE pelanggan = ?";
    PreparedStatement checkPst = conn.prepareStatement(checkSql);
    checkPst.setString(1, username);
    ResultSet checkRs = checkPst.executeQuery();
    if (checkRs.next()) {
        int count = checkRs.getInt(1);
        if (count > 0) {
            JOptionPane.showMessageDialog(null, "Data sudah ada dalam database");
            return;
        }
    }

    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String insertSql = "INSERT INTO pelanggan (id_pelanggan, pelanggan, telepon, alamat) VALUES (?, ?, ?, ?)";
        PreparedStatement insertPst = conn.prepareStatement(insertSql);
        insertPst.setInt(1, idakun);
        insertPst.setString(2, username);
        insertPst.setString(3, telepon);
        insertPst.setString(4, alamat);
        insertPst.execute();
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        tabel_supplier();
        txt_idpelanggan.setText(getNextIdPelanggan());
        kosong1();
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
        String username = txt_username.getText();
        String alamat = txt_alamat.getText();
        String telepon = txt_telepon.getText();
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String sqlbarang = "DELETE FROM pelanggan WHERE id_pelanggan=?";
        Connection conn = Config.configDB();
        PreparedStatement pstbarang = conn.prepareStatement(sqlbarang);
        pstbarang.setString(1, txt_idpelanggan.getText());
        pstbarang.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        txt_idpelanggan.setText(getNextIdPelanggan());
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
tabel_supplier();
kosong1();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txt_teleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teleponActionPerformed

    }//GEN-LAST:event_txt_teleponActionPerformed

    private void tabel_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_supplierMouseClicked
        int baris = tabel_supplier.rowAtPoint(evt.getPoint());
        String id_akun = tabel_supplier.getValueAt(baris, 0).toString();
        txt_idpelanggan.setText(id_akun);
        txt_username.setText(tabel_supplier.getValueAt(baris, 1) == null ? "" : tabel_supplier.getValueAt(baris, 1).toString());
        txt_telepon.setText(tabel_supplier.getValueAt(baris, 2) == null ? "" : tabel_supplier.getValueAt(baris, 2).toString());
        txt_alamat.setText(tabel_supplier.getValueAt(baris, 3) == null ? "" : tabel_supplier.getValueAt(baris, 3).toString());
    }//GEN-LAST:event_tabel_supplierMouseClicked

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

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_datamasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datamasterActionPerformed

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

    private void txt_idpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idpelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idpelangganActionPerformed

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
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_akun;
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_datamaster;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_opname;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JLabel gambar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_telepon;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JLabel lbl_username1;
    private javax.swing.JTable tabel_supplier;
    private javax.swing.JFormattedTextField txt_alamat;
    private javax.swing.JFormattedTextField txt_idpelanggan;
    private javax.swing.JFormattedTextField txt_telepon;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}