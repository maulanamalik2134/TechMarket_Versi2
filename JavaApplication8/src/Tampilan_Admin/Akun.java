package Tampilan_Admin;

import Config.Config;
import Tampilan_Awal.Login;
import java.awt.HeadlessException;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Akun extends javax.swing.JFrame {
private DefaultTableModel model;

public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
    String formattedDateTime = dateTime.format(formatter);
    lbl_tanggal.setText(formattedDateTime);
}

public Akun() {
    initComponents();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(() -> {
        setTanggalDanWaktuSekarang();
    }, 0, 1, TimeUnit.SECONDS);
    setTanggalDanWaktuSekarang();
    tabel_akun();
    txt_idakun.setText(getNextIdAkun());
    kosong1();
}

private String getNextIdAkun() {
    try {
        String sql = "SELECT MAX(Id_akun) AS max_id FROM akun";
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
    txt_password.setText(null);
    cmb_role.setSelectedItem(null);
    txt_telepon.setText(null);
    txt_alamat.setText(null);
}

private void tabel_akun() {
    model = new DefaultTableModel();
    model.addColumn("Id Akun");
    model.addColumn("Username");
    model.addColumn("Password");
    model.addColumn("Role");
    model.addColumn("Telepon");
    model.addColumn("Alamat");
    try {
        int no = 1;
        String sql = "SELECT akun.id_akun, akun.username, akun.password, akun.role, akun.telepon, akun.alamat FROM akun";
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id_akun"),
                res.getString("username"),
                res.getString("password"),
                res.getString("role"),
                res.getString("telepon"),
                res.getString("alamat"),
            });
        }
        tabel_akun.setModel(model);
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
        txt_username = new javax.swing.JFormattedTextField();
        lbl_telepon = new javax.swing.JLabel();
        lbl_alamat = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        txt_password = new javax.swing.JFormattedTextField();
        txt_alamat = new javax.swing.JFormattedTextField();
        txt_telepon = new javax.swing.JFormattedTextField();
        lbl_username = new javax.swing.JLabel();
        cmb_role = new javax.swing.JComboBox<>();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_akun = new javax.swing.JTable();
        lbl_role = new javax.swing.JLabel();
        btn_supplier = new javax.swing.JButton();
        btn_pelanggan = new javax.swing.JButton();
        btn_barang = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        btn_dashboard = new javax.swing.JButton();
        btn_datamaster = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_opname = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        txt_idakun = new javax.swing.JFormattedTextField();
        lbl_username1 = new javax.swing.JLabel();
        lbl_image = new javax.swing.JLabel();
        txt_tanggalmasuk = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setForeground(new java.awt.Color(255, 255, 255));
        bab.setText("Hai Admin, Selamat Datang Di Data Akun");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1120, 50));

        txt_username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 160, -1));

        lbl_telepon.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_telepon.setText("Telepon");
        getContentPane().add(lbl_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, -1, -1));

        lbl_alamat.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_alamat.setText("Alamat");
        getContentPane().add(lbl_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 100, -1, -1));

        lbl_password.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_password.setText("Password");
        getContentPane().add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, -1, -1));

        txt_password.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 160, -1));

        txt_alamat.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 120, 250, -1));

        txt_telepon.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_telepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teleponActionPerformed(evt);
            }
        });
        getContentPane().add(txt_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 140, -1));

        lbl_username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_username.setText("Id Akun");
        getContentPane().add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        cmb_role.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmb_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Kasir" }));
        getContentPane().add(cmb_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 160, 30));

        btn_tambah.setBackground(new java.awt.Color(255, 255, 255));
        btn_tambah.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(51, 51, 51));
        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Plus Math (1).png"))); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        getContentPane().add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 220, 130, 30));

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
        getContentPane().add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 220, 130, 30));

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
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 220, 130, 30));

        tabel_akun.setModel(new javax.swing.table.DefaultTableModel(
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
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_akun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_akunMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_akun);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 260, 1070, 400));

        lbl_role.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_role.setText("Role");
        getContentPane().add(lbl_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        btn_supplier.setBackground(new java.awt.Color(255, 255, 255));
        btn_supplier.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_supplier.setText("Data Supplier");
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 180, 30));

        btn_pelanggan.setBackground(new java.awt.Color(255, 255, 255));
        btn_pelanggan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_pelanggan.setText("Data Pelanggan");
        btn_pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pelangganActionPerformed(evt);
            }
        });
        getContentPane().add(btn_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 180, 30));

        btn_barang.setBackground(new java.awt.Color(255, 255, 255));
        btn_barang.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_barang.setText("Data Barang");
        btn_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barangActionPerformed(evt);
            }
        });
        getContentPane().add(btn_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 60, 180, -1));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Administrator Male (1).png"))); // NOI18N
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 50, 190, 80));

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

        txt_idakun.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_idakun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idakunActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 160, -1));

        lbl_username1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_username1.setText("Username");
        getContentPane().add(lbl_username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_tanggalmasuk.setText("jFormattedTextField1");
        getContentPane().add(txt_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_teleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teleponActionPerformed

    }//GEN-LAST:event_txt_teleponActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed

    }//GEN-LAST:event_txt_usernameActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        try {
    int idakun = Integer.parseInt(txt_idakun.getText());
    String username = txt_username.getText();
    String password = txt_password.getText();
    String role = cmb_role.getSelectedItem().toString();
    String alamat = txt_alamat.getText();
    String telepon = txt_telepon.getText();
    Connection conn = Config.configDB();

    String checkSql = "SELECT COUNT(*) FROM akun WHERE username = ? OR password = ?";
    PreparedStatement checkPst = conn.prepareStatement(checkSql);
    checkPst.setString(1, username);
    checkPst.setString(2, password);
    ResultSet checkRs = checkPst.executeQuery();
    if (checkRs.next()) {
        int count = checkRs.getInt(1);
        if (count > 0) {
            JOptionPane.showMessageDialog(null, "Username atau Password Sudah Digunakan");
            return;
        }
    }

    if (username.isEmpty() && password.isEmpty() && telepon.isEmpty() && alamat.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username, Password, dan Konfirmasi Password harus diisi");
        return;
    } else if (username.length() < 5 || username.length() > 15 || username.contains(" ")) {
        JOptionPane.showMessageDialog(null, "Username Harus Diisi Dengan Panjang Minimal 5 karakter Dan Maksimal 15 Karakter, dan Tidak Boleh Mengandung Spasi");
        return;
    } else {
        Pattern usernamePattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher usernameMatcher = usernamePattern.matcher(username);
    if (!usernameMatcher.matches()) {
        JOptionPane.showMessageDialog(null, "Username hanya boleh menggunakan huruf (A-Z) atau (a-z)");
        return;
    }
}

    if (password.length() < 5 || password.length() > 15 || password.contains(" ") || !password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).+$") || password.contains("username") || password.contains("Telepon")) {
        JOptionPane.showMessageDialog(null, "Password Harus Diisi Dengan Panjang Minimal 5 karakter Dan Maksimal 15 Karakter, dan Harus Mengandung huruf besar, huruf kecil, angka, dan simbol");
        return;
    } 

    if (role.equals("Admin")) {
    String checkAdminSql = "SELECT COUNT(*) FROM akun WHERE role = 'Admin'";
    PreparedStatement checkAdminPst = conn.prepareStatement(checkAdminSql);
    ResultSet checkAdminRs = checkAdminPst.executeQuery();
    if (checkAdminRs.next() && checkAdminRs.getInt(1) > 0) {
        JOptionPane.showMessageDialog(null, "Hanya Bisa Ada Satu Admin");
        return;
    }
} else if (role.equals("Kasir")) {
    String checkKasirSql = "SELECT COUNT(*) FROM akun WHERE role = 'Kasir'";
    PreparedStatement checkKasirPst = conn.prepareStatement(checkKasirSql);
    ResultSet checkKasirRs = checkKasirPst.executeQuery();
    if (checkKasirRs.next() && checkKasirRs.getInt(1) >= 4) {
        JOptionPane.showMessageDialog(null, "Hanya Bisa Membuat Maksimal 4 Akun Kasir");
        return;
    }
} 

    if (telepon.length() < 1 || telepon.length() > 13 || !telepon.matches("[0-9-]+")) {
    JOptionPane.showMessageDialog(null, "Nomor telepon harus terdiri dari 1 hingga 13 karakter dan hanya mengandung angka atau tanda '-'", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
} else if(alamat.length() < 5 || alamat.length() > 30 || !alamat.matches("[a-zA-Z\\s]+")) {
    JOptionPane.showMessageDialog(null, "Alamat harus terdiri dari 5 hingga 30 karakter dan hanya mengandung huruf dan spasi", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
    return;
}

    String insertSql = "INSERT INTO akun (id_akun, username, password, role, telepon, alamat) VALUES (?, ?, ?, ?, ?, ?)";
    PreparedStatement insertPst = conn.prepareStatement(insertSql);
    insertPst.setInt(1, idakun);
    insertPst.setString(2, username);
    insertPst.setString(3, password);
    insertPst.setString(4, role);
    insertPst.setString(5, telepon);
    insertPst.setString(6, alamat);
    insertPst.execute();

    JOptionPane.showMessageDialog(null, "Data berhasil ditambah", "Sukses", JOptionPane.INFORMATION_MESSAGE);

    tabel_akun();
    txt_idakun.setText(getNextIdAkun());
    kosong1();

} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
       try {
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengedit data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String username = txt_username.getText();
        String password = txt_password.getText();
        String telepon = txt_telepon.getText();
        String alamat = txt_alamat.getText();
        String idakun = txt_idakun.getText();
        String role = (String) cmb_role.getSelectedItem();
        Connection conn = Config.configDB();

        if (role.equals("Admin")) {
            String checkAdminSql = "SELECT COUNT(*) FROM akun WHERE role = 'Admin'";
            PreparedStatement checkAdminPst = conn.prepareStatement(checkAdminSql);
            ResultSet checkAdminRs = checkAdminPst.executeQuery();
            if (checkAdminRs.next() && checkAdminRs.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "Hanya Bisa Ada Satu Admin");
                return;
            }
        } else if (role.equals("Kasir")) {
            String checkKasirSql = "SELECT COUNT(*) FROM akun WHERE role = 'Kasir'";
            PreparedStatement checkKasirPst = conn.prepareStatement(checkKasirSql);
            ResultSet checkKasirRs = checkKasirPst.executeQuery();
            if (checkKasirRs.next() && checkKasirRs.getInt(1) >= 4) {
                JOptionPane.showMessageDialog(null, "Hanya Bisa Membuat Maksimal 4 Akun Kasir");
                return;
            }
        }

        if (idakun.length() < 1 || idakun.length() > 10 || !idakun.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "ID Akun harus terdiri dari 1 hingga 10 angka.");
            return;
        }

        if (username.length() < 5 || username.length() > 15 || !username.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Username harus terdiri dari 5 hingga 15 huruf.");
            return;
        }

        if (password.length() < 5 || password.length() > 15 || !password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).*$")) {
            JOptionPane.showMessageDialog(null, "Password harus terdiri dari 5 hingga 15 karakter dan mengandung setidaknya satu huruf, satu angka, dan satu simbol.");
            return;
        }

        if (telepon.length() < 1 || telepon.length() > 13 || !telepon.matches("[0-9-]+")) {
            JOptionPane.showMessageDialog(null, "Nomor telepon harus terdiri dari 1 hingga 13 karakter dan hanya mengandung angka atau simbol '-'.");
            return;
        }

        if (alamat.length() < 5 || alamat.length() > 30 || !alamat.matches("[a-zA-Z\\s]+")) {
            JOptionPane.showMessageDialog(null, "Alamat harus terdiri dari 5 hingga 30 karakter dan hanya mengandung huruf dan spasi.");
            return;
        }

        String updateSql = "UPDATE akun SET username = ?, password = ?, role =?, telepon = ?, alamat = ? WHERE id_akun = ?";
        PreparedStatement updatePst = conn.prepareStatement(updateSql);
        updatePst.setString(1, username);
        updatePst.setString(2, password);
        updatePst.setString(3, role);
        updatePst.setString(4, telepon);
        updatePst.setString(5, alamat);
        updatePst.setString(6, idakun);
        updatePst.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data berhasil diupdate", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        tabel_akun();
        kosong1();
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal mengupdate data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
        String idakun = txt_idakun.getText();
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String sqlbarang = "DELETE FROM akun WHERE id_akun=?";
        java.sql.Connection conn = Config.configDB();
        java.sql.PreparedStatement pstbarang = conn.prepareStatement(sqlbarang);
        pstbarang.setString(1, txt_idakun.getText());
        pstbarang.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        txt_idakun.setText(getNextIdAkun());
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
tabel_akun();
kosong1();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tabel_akunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_akunMouseClicked
        int baris = tabel_akun.rowAtPoint(evt.getPoint());
        String id_akun = tabel_akun.getValueAt(baris, 0).toString();
        txt_idakun.setText(id_akun);
        System.out.println(id_akun);
        txt_username.setText(tabel_akun.getValueAt(baris, 1) == null ? "" : tabel_akun.getValueAt(baris, 1).toString());
        txt_password.setText(tabel_akun.getValueAt(baris, 2) == null ? "" : tabel_akun.getValueAt(baris, 2).toString());
        cmb_role.setSelectedItem(tabel_akun.getValueAt(baris, 3) == null ? "" : tabel_akun.getValueAt(baris, 3).toString());
        txt_telepon.setText(tabel_akun.getValueAt(baris, 4) == null ? "" : tabel_akun.getValueAt(baris, 4).toString());
        txt_alamat.setText(tabel_akun.getValueAt(baris, 5) == null ? "" : tabel_akun.getValueAt(baris, 5).toString());
    }//GEN-LAST:event_tabel_akunMouseClicked

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        this.setVisible(false);
        new Supplier().setVisible(true);
    }//GEN-LAST:event_btn_supplierActionPerformed

    private void btn_pelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pelangganActionPerformed
        this.setVisible(false);
        new Pelanggan().setVisible(true);
    }//GEN-LAST:event_btn_pelangganActionPerformed

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

    private void txt_idakunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idakunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idakunActionPerformed

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
            java.util.logging.Logger.getLogger(Akun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Akun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Akun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Akun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Akun().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_datamaster;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_opname;
    private javax.swing.JButton btn_pelanggan;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JComboBox<String> cmb_role;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_role;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_telepon;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JLabel lbl_username1;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tabel_akun;
    private javax.swing.JFormattedTextField txt_alamat;
    private javax.swing.JFormattedTextField txt_idakun;
    private javax.swing.JFormattedTextField txt_password;
    private javax.swing.JFormattedTextField txt_tanggalmasuk;
    private javax.swing.JFormattedTextField txt_telepon;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}