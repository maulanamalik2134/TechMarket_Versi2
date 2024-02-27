package Tampilan_Admin;

import Config.Config;
import Tampilan_Awal.Absen;
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

public class Supplier extends javax.swing.JFrame {
private DefaultTableModel model;

// Mengatur tanggal dan waktu saat ini
public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
    String formattedDateTime = dateTime.format(formatter);
    lbl_tanggal.setText(formattedDateTime);
}

public Supplier() {
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

    // Set tanggal dan waktu saat ini
    setTanggalDanWaktuSekarang();

    // Mengisi tabel akun dan menginisialisasi formulir akun baru
    tabel_supplier();
    txt_idsupplier.setText(getNextIdSupplier());
    kosong1();
}

// Dapatkan ID berikutnya untuk akun baru
private String getNextIdSupplier() {
    try {
        String sql = "SELECT MAX(Id_supplier) AS max_id FROM supplier";
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

// Mengosongkan input untuk membuat akun baru
private void kosong1() {
    txt_username.setText(null);
    txt_telepon.setText(null);
    txt_alamat.setText(null);
}

// Mengisi tabel akun dengan data dari database
private void tabel_supplier() {
    model = new DefaultTableModel();
    model.addColumn("Id Supplier");
    model.addColumn("Nama Supplier");
    model.addColumn("Telepon");
    model.addColumn("Alamat");

    try {
        int no = 1;
        String sql = "SELECT supplier.id_supplier, supplier.nama_supplier, supplier.telepon, supplier.alamat FROM supplier";
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);

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
        JOptionPane.showMessageDialog(null, "Gagal mengisi tabel: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bab = new javax.swing.JLabel();
        lbl_tanggal = new javax.swing.JLabel();
        btn_logout2 = new javax.swing.JButton();
        lbl_telepon = new javax.swing.JLabel();
        lbl_alamat = new javax.swing.JLabel();
        txt_alamat = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_supplier = new javax.swing.JTable();
        btn_edit = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        txt_telepon = new javax.swing.JFormattedTextField();
        btn_dashboard = new javax.swing.JButton();
        btn_datamaster = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        btn_opname1 = new javax.swing.JButton();
        txt_username = new javax.swing.JFormattedTextField();
        lbl_username1 = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();
        lbl_tanggalmasuk = new javax.swing.JLabel();
        txt_idsupplier = new javax.swing.JFormattedTextField();
        txt_idakun1 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setText("Hai Admin, Selamat datang Di Data Supplier");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 1120, 50));

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

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

        lbl_telepon.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_telepon.setText("Telepon");
        getContentPane().add(lbl_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        lbl_alamat.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_alamat.setText("Alamat");
        getContentPane().add(lbl_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        txt_alamat.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 310, -1));

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
                "Id Supplier", "Nama Supplier", "Email", "Telepon", "Alamat"
            }
        ));
        tabel_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_supplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_supplier);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 270, 1070, 390));

        btn_edit.setBackground(new java.awt.Color(153, 153, 0));
        btn_edit.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 180, -1, -1));

        btn_tambah.setBackground(new java.awt.Color(0, 153, 0));
        btn_tambah.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 180, -1, -1));

        btn_hapus.setBackground(new java.awt.Color(153, 0, 0));
        btn_hapus.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 180, -1, -1));

        txt_telepon.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_telepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teleponActionPerformed(evt);
            }
        });
        getContentPane().add(txt_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 140, -1));

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

        btn_opname1.setBackground(new java.awt.Color(255, 255, 255));
        btn_opname1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_opname1.setForeground(new java.awt.Color(255, 255, 255));
        btn_opname1.setText("Opname");
        btn_opname1.setContentAreaFilled(false);
        btn_opname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_opname1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn_opname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 200, -1));

        txt_username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 310, -1));

        lbl_username1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_username1.setText("Username");
        getContentPane().add(lbl_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lbl_tanggalmasuk.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggalmasuk.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggalmasuk.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        txt_idsupplier.setText("jFormattedTextField1");
        getContentPane().add(txt_idsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, 30));

        txt_idakun1.setText("jFormattedTextField1");
        getContentPane().add(txt_idakun1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout2ActionPerformed
        this.setVisible(false);
            new Login().setVisible(true);
    }//GEN-LAST:event_btn_logout2ActionPerformed

    private void tabel_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_supplierMouseClicked
        int baris = tabel_supplier.rowAtPoint(evt.getPoint());

        // Ambil nilai ID akun dari baris yang dipilih
        String id_akun = tabel_supplier.getValueAt(baris, 0).toString();
        txt_idsupplier.setText(id_akun);
        System.out.println(id_akun);
        txt_idsupplier.setEnabled(false);
        
        // Set nilai username
        txt_username.setText(tabel_supplier.getValueAt(baris, 1) == null ? "" : tabel_supplier.getValueAt(baris, 1).toString());

        // Set nilai telepon
        txt_telepon.setText(tabel_supplier.getValueAt(baris, 2) == null ? "" : tabel_supplier.getValueAt(baris, 2).toString());

        // Set nilai alamat
        txt_alamat.setText(tabel_supplier.getValueAt(baris, 3) == null ? "" : tabel_supplier.getValueAt(baris, 3).toString());
    }//GEN-LAST:event_tabel_supplierMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
    // Tampilkan dialog konfirmasi untuk mengedit data
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengedit data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String username = txt_username.getText();
        String telepon = txt_telepon.getText();
        String alamat = txt_alamat.getText();
        String idsupplier = txt_idsupplier.getText();

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

        // Periksa apakah username yang diedit sudah ada dalam database
        String sqlCheck = "SELECT * FROM supplier WHERE nama_supplier=? AND Id_supplier!=?";
        PreparedStatement pstCheck = conn.prepareStatement(sqlCheck);
        pstCheck.setString(1, username);
        pstCheck.setString(2, idsupplier);
        ResultSet rsCheck = pstCheck.executeQuery();

        if (rsCheck.next()) {
            // Tampilkan notifikasi jika username sudah ada dalam database
            JOptionPane.showMessageDialog(null, "Username sudah ada dalam database", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Update data supplier dengan informasi yang diedit
            String sql = "UPDATE supplier SET nama_supplier=?, telepon=?, alamat=? WHERE Id_supplier=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, telepon);
            pst.setString(3, alamat);
            pst.setString(4, idsupplier);
            pst.execute();

            // Tampilkan notifikasi sukses
            JOptionPane.showMessageDialog(null, "Data berhasil diubah:\nUsername: " + username + "\nTelepon: " + telepon + "\nAlamat: " + alamat, "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // Perbarui tabel supplier, ID supplier, dan kosongkan input
            tabel_supplier();
            txt_idsupplier.setText(getNextIdSupplier());
            kosong1();
        }
    }
} catch (Exception e) {
    // Tampilkan notifikasi jika terjadi kesalahan saat mengubah data
    JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        try {
        // Mendapatkan nilai dari inputan form
        int idakun = Integer.parseInt(txt_idsupplier.getText());
        String username = txt_username.getText();
        String alamat = txt_alamat.getText();
        String telepon = txt_telepon.getText();

        // Membuat koneksi ke database
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

        // Rest of the code for inserting the data into the database and displaying notifications

        // Mengecek apakah username dan telepon sudah ada dalam database
        String checkSql = "SELECT COUNT(*) FROM supplier WHERE nama_supplier = ? ";
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

        // Tampilkan dialog konfirmasi untuk menyimpan data
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Simpan data ke database
            String insertSql = "INSERT INTO supplier (id_supplier, nama_supplier, telepon, alamat) VALUES (?, ?, ?, ?)";
            
            PreparedStatement insertPst = conn.prepareStatement(insertSql);
            insertPst.setInt(1, idakun);
            insertPst.setString(2, username);
            insertPst.setString(3, telepon);
            insertPst.setString(4, alamat);
            insertPst.execute();

            // Tampilkan notifikasi sukses
            JOptionPane.showMessageDialog(null, "Data berhasil ditambah:\nUsername: " + username + "\nTelepon: " + telepon + "\nAlamat: " + alamat, "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // Refresh tabel supplier
            tabel_supplier();
            txt_idsupplier.setText(getNextIdSupplier()); // Update ID supplier berikutnya setelah penyimpanan berhasil
            // Kosongkan input
            kosong1();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
        // Tampilkan dialog konfirmasi penghapusan data
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Hapus data supplier berdasarkan ID
            String sqlbarang = "DELETE FROM supplier WHERE id_supplier=?";
            Connection conn = Config.configDB();
            PreparedStatement pstbarang = conn.prepareStatement(sqlbarang);
            pstbarang.setString(1, txt_idsupplier.getText());
            pstbarang.executeUpdate();

            // Tampilkan notifikasi sukses
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus:\nUsername: " + txt_username.getText() + "\nTelepon: " + txt_telepon.getText() + "\nAlamat: " + txt_alamat.getText(), "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // Generate ID baru untuk supplier selanjutnya
            txt_idsupplier.setText(getNextIdSupplier());
        }
    } catch (Exception e) {
        // Tampilkan notifikasi gagal
        JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Perbarui tabel supplier
    tabel_supplier();

    // Kosongkan input
    kosong1();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txt_teleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teleponActionPerformed

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_datamasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datamasterActionPerformed
        this.setVisible(false);
        new Menu_master().setVisible(true);
    }//GEN-LAST:event_btn_datamasterActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
        this.setVisible(false);
        new Menu_Transaksi_Admin().setVisible(true);
    }//GEN-LAST:event_btn_transaksiActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        this.setVisible(false);
        new Return().setVisible(true);
    }//GEN-LAST:event_btn_returnActionPerformed

    private void btn_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanActionPerformed
        this.setVisible(false);
        new Menu_Laporan().setVisible(true);
    }//GEN-LAST:event_btn_laporanActionPerformed

    private void btn_opname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opname1ActionPerformed
        this.setVisible(false);
        new Opname().setVisible(true);
    }//GEN-LAST:event_btn_opname1ActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_datamaster;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout2;
    private javax.swing.JButton btn_opname1;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_tanggalmasuk;
    private javax.swing.JLabel lbl_telepon;
    private javax.swing.JLabel lbl_username1;
    private javax.swing.JTable tabel_supplier;
    private javax.swing.JFormattedTextField txt_alamat;
    private javax.swing.JFormattedTextField txt_idakun1;
    private javax.swing.JFormattedTextField txt_idsupplier;
    private javax.swing.JFormattedTextField txt_telepon;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
