package Tampilan_Admin;

import Config.Config;
import Tampilan_Awal.Absen;
import Tampilan_Awal.Login;
import Tampilan_Kasir.Menu_Transaks_Kasir;
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

// Mengatur tanggal dan waktu saat ini
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

    // Jadwalkan tugas untuk memperbarui tanggal dan waktu saat ini setiap detik
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(() -> {
        setTanggalDanWaktuSekarang();
    }, 0, 1, TimeUnit.SECONDS);

    // Set tanggal dan waktu saat ini
    setTanggalDanWaktuSekarang();

    // Mengisi tabel barang dan menginisialisasi formulir barang baru
    tabel_akun();
    txt_idakun.setText(getNextIdAkun());
    kosong1();
}

// Dapatkan ID berikutnya untuk akun baru
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

// Mengosongkan input untuk membuat akun baru
private void kosong1() {
    txt_username.setText(null);
    txt_password.setText(null);
    cmb_role.setSelectedItem(null);
    txt_gmail.setText(null);
    txt_telepon.setText(null);
    txt_alamat.setText(null);
}

// Mengisi tabel akun dengan data dari database
private void tabel_akun() {
    model = new DefaultTableModel();
    model.addColumn("Id Akun");
    model.addColumn("Username");
    model.addColumn("Password");
    model.addColumn("Role");
    model.addColumn("Email");
    model.addColumn("Telepon");
    model.addColumn("Alamat");

    try {
        int no = 1;
        String sql = "SELECT akun.id_akun, akun.username, akun.password, akun.role, akun.email, akun.telepon, akun.alamat FROM akun";
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id_akun"),
                res.getString("username"),
                res.getString("password"),
                res.getString("role"),
                res.getString("email"),
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
        btn_logout = new javax.swing.JButton();
        txt_username = new javax.swing.JFormattedTextField();
        lbl_gmail = new javax.swing.JLabel();
        lbl_telepon = new javax.swing.JLabel();
        lbl_alamat = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        txt_password = new javax.swing.JFormattedTextField();
        txt_alamat = new javax.swing.JFormattedTextField();
        txt_gmail = new javax.swing.JFormattedTextField();
        txt_telepon = new javax.swing.JFormattedTextField();
        lbl_username = new javax.swing.JLabel();
        cmb_role = new javax.swing.JComboBox<>();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_akun = new javax.swing.JTable();
        lbl_role = new javax.swing.JLabel();
        btn_dashboard = new javax.swing.JButton();
        btn_datamaster = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_opname = new javax.swing.JButton();
        btn_oprasional = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        txt_idakun = new javax.swing.JFormattedTextField();
        txt_tanggalmasuk = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setText("Hai Admin, Selamat Datang Di Data Akun");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 1120, 50));

        btn_logout.setBackground(new java.awt.Color(255, 255, 255));
        btn_logout.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_logout.setText("Log Out");
        btn_logout.setContentAreaFilled(false);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 200, -1));

        txt_username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 160, -1));

        lbl_gmail.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_gmail.setText("Gmail");
        getContentPane().add(lbl_gmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, -1, -1));

        lbl_telepon.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_telepon.setText("Telepon");
        getContentPane().add(lbl_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 100, -1, -1));

        lbl_alamat.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_alamat.setText("Alamat");
        getContentPane().add(lbl_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        lbl_password.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_password.setText("Password");
        getContentPane().add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        txt_password.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 160, -1));

        txt_alamat.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        getContentPane().add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 310, -1));

        txt_gmail.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_gmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_gmailActionPerformed(evt);
            }
        });
        getContentPane().add(txt_gmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 310, -1));

        txt_telepon.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_telepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teleponActionPerformed(evt);
            }
        });
        getContentPane().add(txt_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 120, 140, -1));

        lbl_username.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_username.setText("Username");
        getContentPane().add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        cmb_role.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmb_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Kasir" }));
        getContentPane().add(cmb_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(1221, 120, 100, 30));

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

        tabel_akun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Akun", "Username", "Password", "Role", "Gmail", "Telepon", "Alamat", "Tanggal_dibuat", "Terakhir_login"
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
        getContentPane().add(lbl_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 100, -1, -1));

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
        getContentPane().add(btn_opname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 200, -1));

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
        getContentPane().add(btn_oprasional, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 200, -1));

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
        getContentPane().add(btn_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 200, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_idakun.setText("jFormattedTextField1");
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, 30));

        txt_tanggalmasuk.setText("jFormattedTextField1");
        getContentPane().add(txt_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin logout?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void txt_teleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teleponActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_gmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_gmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_gmailActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        try {
    // Mendapatkan nilai dari inputan form
    int idakun = Integer.parseInt(txt_idakun.getText());
    String username = txt_username.getText();
    String password = txt_password.getText();
    String role = cmb_role.getSelectedItem().toString();
    String gmail = txt_gmail.getText();
    String alamat = txt_alamat.getText();
    String telepon = txt_telepon.getText();

    // Membuat koneksi ke database
    Connection conn = Config.configDB();

    // Mengecek apakah username, password, gmail, telepon, dan alamat sudah diisi
    if (username.isEmpty() || password.isEmpty() || gmail.isEmpty() || telepon.isEmpty() || alamat.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
        return;
    }

    // Mengecek panjang username, password, gmail, alamat, dan telepon
    if (username.length() < 5 || username.length() > 15) {
        JOptionPane.showMessageDialog(null, "Panjang username harus antara 5 hingga 15 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (password.length() < 5 || password.length() > 15) {
        JOptionPane.showMessageDialog(null, "Panjang password harus antara 5 hingga 15 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (gmail.length() < 1 || gmail.length() > 30) {
        JOptionPane.showMessageDialog(null, "Panjang gmail harus antara 5 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (alamat.length() < 1 || alamat.length() > 30) {
        JOptionPane.showMessageDialog(null, "Panjang alamat harus antara 5 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (telepon.length() < 1 || telepon.length() > 13) {
        JOptionPane.showMessageDialog(null, "Panjang nomor telepon harus antara 1 hingga 13 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Mengecek apakah username, password, gmail, dan telepon sudah ada dalam database
    String checkSql = "SELECT COUNT(*) FROM akun WHERE username = ? OR password = ?";
    PreparedStatement checkPst = conn.prepareStatement(checkSql);
    checkPst.setString(1, username);
    checkPst.setString(2, password);
    ResultSet checkRs = checkPst.executeQuery();
    if (checkRs.next()) {
        int count = checkRs.getInt(1);
        if (count > 0) {
            JOptionPane.showMessageDialog(null, "Data sudah ada dalam database");
            return;
        }
    }

    // Mengecek jumlah akun dengan role Admin dan Kasir
    if (role.equals("Admin")) {
        String checkAdminSql = "SELECT COUNT(*) FROM akun WHERE role = 'Admin'";
        PreparedStatement checkAdminPst = conn.prepareStatement(checkAdminSql);
        ResultSet checkAdminRs = checkAdminPst.executeQuery();
        if (checkAdminRs.next() && checkAdminRs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(null, "Hanya Bisa Ada Satu Admin");
            return;
        }
        if (checkAdminRs.next() && checkAdminRs.getInt(1) >= 4) {
            JOptionPane.showMessageDialog(null, "Hanya Bisa Ada 4 Akun Kasir");
            return;
        }
        if (checkAdminRs.next() && checkAdminRs.getInt(1) >= 4) {
            JOptionPane.showMessageDialog(null, "Hanya Bisa Ada 4 Akun Karyawan");
            return;
        }
    }

    // Tampilkan dialog konfirmasi untuk menyimpan data
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        // Simpan data ke database
        String insertSql = "INSERT INTO akun (id_akun, username, password, role, email, telepon, alamat) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement insertPst = conn.prepareStatement(insertSql);
        insertPst.setInt(1, idakun);
        insertPst.setString(2, username);
        insertPst.setString(3, password);
        insertPst.setString(4, role);
        insertPst.setString(5, gmail);
        insertPst.setString(6, telepon);
        insertPst.setString(7, alamat);
        insertPst.execute();

        // Tampilkan notifikasi sukses
        JOptionPane.showMessageDialog(null, "Data berhasil ditambah", "Sukses", JOptionPane.INFORMATION_MESSAGE);

        // Refresh tabel akun
        tabel_akun();
        txt_idakun.setText(getNextIdAkun()); // Update ID akun berikutnya setelah penyimpanan berhasil
        // Kosongkan input
        kosong1();
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
       try {
    // Tampilkan dialog konfirmasi untuk mengedit data
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengedit data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String username = txt_username.getText();
        String password = txt_password.getText();
        String gmail = txt_gmail.getText();
        String telepon = txt_telepon.getText();
        String alamat = txt_alamat.getText();
        String idakun = txt_idakun.getText();

        Connection conn = Config.configDB();

        // Mengecek apakah username, password, gmail, telepon, dan alamat sudah diisi
        if (username.isEmpty() || password.isEmpty() || gmail.isEmpty() || telepon.isEmpty() || alamat.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
            return;
        }

        // Mengecek panjang username, password, gmail, alamat, dan telepon
        if (username.length() < 5 || username.length() > 15) {
            JOptionPane.showMessageDialog(null, "Panjang username harus antara 5 hingga 15 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (password.length() < 5 || password.length() > 15) {
            JOptionPane.showMessageDialog(null, "Panjang password harus antara 5 hingga 15 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (gmail.length() < 1 || gmail.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang gmail harus antara 5 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (alamat.length() < 1 || alamat.length() > 30) {
            JOptionPane.showMessageDialog(null, "Panjang alamat harus antara 5 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (telepon.length() < 1 || telepon.length() > 13) {
            JOptionPane.showMessageDialog(null, "Panjang nomor telepon harus antara 1 hingga 13 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tampilkan dialog konfirmasi untuk menyimpan data
        int confirmSave = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan perubahan ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirmSave == JOptionPane.YES_OPTION) {
            // Update data akun dengan informasi yang diedit
            String sql = "UPDATE akun SET username=?, password=?, email=?, telepon=?, alamat=? WHERE Id_akun=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, gmail);
            pst.setString(4, telepon);
            pst.setString(5, alamat);
            pst.setString(6, idakun);
            pst.execute();

            // Tampilkan notifikasi sukses
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Sukses", JOptionPane.INFORMATION_MESSAGE);

            // Perbarui tabel akun, ID akun, dan kosongkan input
            tabel_akun();
            txt_idakun.setText(getNextIdAkun());
            kosong1();
        }
    }
} catch (Exception e) {
    // Tampilkan notifikasi jika terjadi kesalahan saat mengubah data
    JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
    // Tampilkan dialog konfirmasi penghapusan data
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        // Hapus data akun berdasarkan ID
        String sqlbarang = "DELETE FROM akun WHERE id_akun=?";
        java.sql.Connection conn = Config.configDB();
        java.sql.PreparedStatement pstbarang = conn.prepareStatement(sqlbarang);
        pstbarang.setString(1, txt_idakun.getText());
        pstbarang.executeUpdate();

        // Tampilkan notifikasi sukses
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);

        // Generate ID baru untuk akun selanjutnya
        txt_idakun.setText(getNextIdAkun());
    }
} catch (Exception e) {
    // Tampilkan notifikasi gagal
    JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}

// Perbarui tabel akun
tabel_akun();

// Kosongkan input
kosong1();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void tabel_akunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_akunMouseClicked
        int baris = tabel_akun.rowAtPoint(evt.getPoint());

// Ambil nilai ID akun dari baris yang dipilih
String id_akun = tabel_akun.getValueAt(baris, 0).toString();
txt_idakun.setText(id_akun);
System.out.println(id_akun);
txt_idakun.setEnabled(false);

// Set nilai username
txt_username.setText(tabel_akun.getValueAt(baris, 1) == null ? "" : tabel_akun.getValueAt(baris, 1).toString());

// Set nilai password
txt_password.setText(tabel_akun.getValueAt(baris, 2) == null ? "" : tabel_akun.getValueAt(baris, 2).toString());

// Set nilai role
cmb_role.setSelectedItem(tabel_akun.getValueAt(baris, 3) == null ? "" : tabel_akun.getValueAt(baris, 3).toString());

// Set nilai gmail
txt_gmail.setText(tabel_akun.getValueAt(baris, 4) == null ? "" : tabel_akun.getValueAt(baris, 4).toString());

// Set nilai telepon
txt_telepon.setText(tabel_akun.getValueAt(baris, 5) == null ? "" : tabel_akun.getValueAt(baris, 5).toString());

// Set nilai alamat
txt_alamat.setText(tabel_akun.getValueAt(baris, 6) == null ? "" : tabel_akun.getValueAt(baris, 6).toString());

    }//GEN-LAST:event_tabel_akunMouseClicked

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

    private void btn_opnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opnameActionPerformed
        this.setVisible(false);
        new Opname().setVisible(true);
    }//GEN-LAST:event_btn_opnameActionPerformed

    private void btn_oprasionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_oprasionalActionPerformed
        this.setVisible(false);
        new Oprasional().setVisible(true);
    }//GEN-LAST:event_btn_oprasionalActionPerformed

    private void btn_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanActionPerformed
        this.setVisible(false);
        new Menu_Laporan().setVisible(true);
    }//GEN-LAST:event_btn_laporanActionPerformed

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
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_datamaster;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_opname;
    private javax.swing.JButton btn_oprasional;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JComboBox<String> cmb_role;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_gmail;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_role;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_telepon;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JTable tabel_akun;
    private javax.swing.JFormattedTextField txt_alamat;
    private javax.swing.JFormattedTextField txt_gmail;
    private javax.swing.JFormattedTextField txt_idakun;
    private javax.swing.JFormattedTextField txt_password;
    private javax.swing.JFormattedTextField txt_tanggalmasuk;
    private javax.swing.JFormattedTextField txt_telepon;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
