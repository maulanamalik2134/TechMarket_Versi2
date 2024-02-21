package Tampilan_Admin;

import Config.Config;
import Tampilan_Awal.Absen;
import Tampilan_Awal.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Absen_Admin extends javax.swing.JFrame {
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

public Absen_Admin() {
    initComponents();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");

    // Jadwalkan tugas untuk memperbarui tanggal dan waktu saat ini setiap detik
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            setTanggalDanWaktuSekarang();
            
    setTanggalDanWaktu();
        }
    }, 0, 1, TimeUnit.SECONDS);

    // Set tanggal dan waktu saat ini
    setTanggalDanWaktuSekarang();
    setTanggalDanWaktu();
    
    // Mengisi tabel barang dan menginisialisasi formulir barang baru
    tabel_Absen();
    txt_idabsen.setText(getNextIdAbsen());
    kosong1();
}

// Dapatkan ID berikutnya untuk barang baru
private String getNextIdAbsen() {
    try {
        String sql = "SELECT MAX(Id_absen) AS max_id FROM absen";
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
    cmb_keterangan.setSelectedItem(null);
    txt_username.setText(null);
}

// Mengisi tabel barang
private void tabel_Absen() {
    model = new DefaultTableModel();
    model.addColumn("Id Absen");
    model.addColumn("keterangan");
    model.addColumn("Tanggal");
    model.addColumn("Id Akun");
    model.addColumn("Username");

    try {
        String sql = "SELECT absen.id_absen, absen.katerangan, absen.tanggal, absen.id_akun, absen.username FROM absen";
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id_absen"),
                res.getString("katerangan"),
                res.getString("tanggal"),
                res.getString("id_akun"),
                res.getString("Username"),
            });
        }
        txt_absen.setModel(model);
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
        txt_username = new javax.swing.JFormattedTextField();
        lbl_hargabeli = new javax.swing.JLabel();
        cmb_keterangan = new javax.swing.JComboBox<>();
        lbl_namabarang = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_absen = new javax.swing.JTable();
        btn_edit = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        txt_idabsen = new javax.swing.JFormattedTextField();
        txt_idakun = new javax.swing.JFormattedTextField();
        txt_tanggalmasuk = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setText("Hai Admin, Selamat Datang Di Menu Absen");
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
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 160, -1));

        lbl_hargabeli.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargabeli.setText("Username");
        getContentPane().add(lbl_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, -1, -1));

        cmb_keterangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hadir", "Sakit", "Ijin", "Alpa" }));
        getContentPane().add(cmb_keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 160, 30));

        lbl_namabarang.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namabarang.setText("Keterangan");
        getContentPane().add(lbl_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        txt_absen.setModel(new javax.swing.table.DefaultTableModel(
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
        txt_absen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_absenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(txt_absen);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 210, 1070, 450));

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

        txt_idabsen.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_idabsen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idabsenActionPerformed(evt);
            }
        });
        txt_idabsen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idabsenKeyReleased(evt);
            }
        });
        getContentPane().add(txt_idabsen, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 160, -1));

        txt_idakun.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_idakun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idakunActionPerformed(evt);
            }
        });
        txt_idakun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idakunKeyReleased(evt);
            }
        });
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 160, -1));

        txt_tanggalmasuk.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_tanggalmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tanggalmasukActionPerformed(evt);
            }
        });
        txt_tanggalmasuk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tanggalmasukKeyReleased(evt);
            }
        });
        getContentPane().add(txt_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 160, -1));

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

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

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

    private void txt_tanggalmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tanggalmasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tanggalmasukActionPerformed

    private void txt_tanggalmasukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tanggalmasukKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tanggalmasukKeyReleased

    private void txt_idakunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idakunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idakunActionPerformed

    private void txt_idakunKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idakunKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idakunKeyReleased

    private void txt_idabsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idabsenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idabsenActionPerformed

    private void txt_idabsenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idabsenKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idabsenKeyReleased

    private void txt_absenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_absenMouseClicked
        int baris = txt_absen.rowAtPoint(evt.getPoint());

        // Ambil nilai ID akun dari baris yang dipilih
        String idabsen = txt_absen.getValueAt(baris, 0).toString();
        txt_idabsen.setText(idabsen);
        System.out.println(idabsen);
        txt_idabsen.setEnabled(false);

        // Set nilai telepon
        cmb_keterangan.setSelectedItem(txt_absen.getValueAt(baris, 1) == null ? "" : txt_absen.getValueAt(baris, 1).toString());

        // Set nilai username
        txt_tanggalmasuk.setText(txt_absen.getValueAt(baris, 2) == null ? "" : txt_absen.getValueAt(baris, 2).toString());

        // Set nilai telepon
        txt_idakun.setText(txt_absen.getValueAt(baris, 3) == null ? "" : txt_absen.getValueAt(baris, 3).toString());

        // Set nilai alamat
        txt_username.setText(txt_absen.getValueAt(baris, 4) == null ? "" : txt_absen.getValueAt(baris, 4).toString());
    }//GEN-LAST:event_txt_absenMouseClicked

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
            // Tampilkan dialog konfirmasi untuk mengedit data
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengedit data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String username = txt_username.getText();
                String keterangan = (String) cmb_keterangan.getSelectedItem();
                String tanggal = txt_tanggalmasuk.getText();
                String idakun = txt_idakun.getText();
                String idabsen = txt_idabsen.getText();

                Connection conn = Config.configDB();

                // Mengecek apakah username, total, dan keterangan sudah diisi
                if (username.isEmpty() || keterangan.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
                    return;
                }

                // Mengecek panjang username, total, dan keterangan
                if (username.length() < 5 || username.length() > 15) {
                    JOptionPane.showMessageDialog(null, "Panjang nama username harus antara 5 hingga 15 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
                    return;
                } 

                // Update data oprasional dengan informasi yang diedit
                String sql = "UPDATE absen SET katerangan=?,tanggal=?, id_akun=?, username=? WHERE Id_absen=?";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, keterangan);
                pst.setString(2, tanggal);
                pst.setString(3, idakun);
                pst.setString(4, username);
                pst.setString(5, idabsen);
                pst.executeUpdate();

                // Tampilkan notifikasi sukses dengan username, total, dan keterangan
                String successMessage = "Data berhasil diubah!\nUsername: " + username +"\nKeterangan: " + keterangan +"\ntanggal: " + tanggal;
                JOptionPane.showMessageDialog(null, successMessage, "Berhasil", JOptionPane.INFORMATION_MESSAGE);

                // Perbarui tabel oprasional, ID oprasional, dan kosongkan input
                tabel_Absen();
                txt_idabsen.setText(getNextIdAbsen());
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
    int idabsen = Integer.parseInt(txt_idabsen.getText());
    String username = txt_username.getText();
    String keterangan = (String) cmb_keterangan.getSelectedItem();
    String tanggal = txt_tanggalmasuk.getText();
    String idakun = txt_idakun.getText();

    // Membuat koneksi ke database
    Connection conn = Config.configDB();

    // Mengecek apakah username, keterangan sudah diisi
    if (username.isEmpty() || keterangan.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semua kolom harus diisi");
        return;
    }

    // Mengecek panjang username
    if (username.length() < 5 || username.length() > 30) {
        JOptionPane.showMessageDialog(null, "Panjang nama username harus antara 5 hingga 30 karakter.", "Inputan tidak valid", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Mendapatkan tanggal saat ini
    LocalDate currentDate = LocalDate.now(); // Mendapatkan tanggal saat ini

    // Mendapatkan waktu saat ini
    LocalTime currentTime = LocalTime.now(); // Mendapatkan waktu saat ini

    // Cek jika username salah
    boolean isUsernameCorrect = false;
    String checkUsernameSql = "SELECT * FROM akun WHERE username = ?";
    java.sql.PreparedStatement checkUsernamePst = conn.prepareStatement(checkUsernameSql);
    checkUsernamePst.setString(1, username);
    java.sql.ResultSet checkUsernameRs = checkUsernamePst.executeQuery();
    if (checkUsernameRs.next()) {
        isUsernameCorrect = true;
    }

    // Tampilkan pesan notifikasi sesuai dengan kesalahan yang terjadi
    if (!isUsernameCorrect) {
        JOptionPane.showMessageDialog(null, "Username Tidak Ditemukan", "Peringatan", JOptionPane.WARNING_MESSAGE);
    } else {
        // Cek apakah sudah melewati waktu absen
        LocalTime startTime = LocalTime.parse("07:00"); // Waktu mulai absen
        LocalTime endTime = LocalTime.parse("18:00"); // Waktu akhir absen

        if (currentTime.isBefore(startTime) || currentTime.isAfter(endTime)) { // Jika waktu saat ini sebelum waktu mulai absen atau setelah waktu akhir absen
            JOptionPane.showMessageDialog(null, "Waktu absen telah berakhir. Silakan absen antara jam 07:00 - 18:00."); // Tampilkan pesan bahwa waktu absen telah berakhir
        } else {
            // Cek apakah ID akun sudah melakukan absen sebelumnya pada hari ini
            String checkSql = "SELECT COUNT(*) FROM absen WHERE Id_akun=? AND Tanggal >= ? AND Tanggal < ?"; // Query untuk menghitung jumlah absen
            java.sql.PreparedStatement checkPst = conn.prepareStatement(checkSql); // Membuat objek PreparedStatement untuk menjalankan query
            checkPst.setString(1, idakun); // Mengatur parameter ID akun
            checkPst.setString(2, currentDate + " 00:00:00"); // Mengatur parameter tanggal awal
            checkPst.setString(3, currentDate + " 23:59:59"); // Mengatur parameter tanggal akhir
            java.sql.ResultSet checkResult = checkPst.executeQuery(); // Menjalankan query dan mendapatkan hasil
            checkResult.next(); // Memindahkan kursor ke baris pertama hasil
            int absenCount = checkResult.getInt(1); // Mendapatkan jumlah absen

            if (absenCount > 0) { // Jika sudah ada absen sebelumnya pada hari ini
                JOptionPane.showMessageDialog(null, "Anda sudah melakukan absen hari ini. Silakan coba lagi besok."); // Tampilkan pesan bahwa sudah melakukan absen hari ini
            } else {
                // Menyimpan data absen ke dalam database
                String sql = "INSERT INTO absen (Id_absen, Id_akun, Keterangan, Tanggal) VALUES (?, ?, ?, ?)"; // Query untuk menyimpan data absen
                java.sql.PreparedStatement pst = conn.prepareStatement(sql); // Membuat objek PreparedStatement untuk menjalankan query
                pst.setInt(1, idabsen); // Mengatur parameter ID absen
                pst.setString(2, idakun); // Mengatur parameter ID akun
                pst.setString(3, keterangan); // Mengatur parameter keterangan absen
                pst.setString(4, currentDate + " " + currentTime); // Mengatur parameter tanggal absen
                pst.executeUpdate(); // Menjalankan query untuk menyimpan data absen

                JOptionPane.showMessageDialog(null, "Data absen berhasil disimpan!\nUsername: " + username + "\nWaktu Absen: " + currentDate + " " + currentTime); // Tampilkan pesan bahwa data absen berhasil disimpan

                // Refresh tabel absen
                tabel_Absen();
                txt_idabsen.setText(getNextIdAbsen()); // Update ID absen berikutnya setelah penyimpanan berhasil
                // Kosongkan input
                kosong1();
            }
        }
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
                String sqlbarang = "DELETE FROM absen WHERE id_absen=?";
                Connection conn = Config.configDB();
                PreparedStatement pstbarang = conn.prepareStatement(sqlbarang);
                pstbarang.setString(1, txt_idabsen.getText());
                pstbarang.executeUpdate();

                // Tampilkan notifikasi sukses
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);

                // Generate ID baru untuk supplier selanjutnya
                txt_idabsen.setText(getNextIdAbsen());
            }
        } catch (Exception e) {
            // Tampilkan notifikasi gagal
            JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Perbarui tabel supplier
        tabel_Absen();

        // Kosongkan input
        kosong1();
    }//GEN-LAST:event_btn_hapusActionPerformed

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
            java.util.logging.Logger.getLogger(Absen_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Absen_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Absen_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Absen_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Absen_Admin().setVisible(true);
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
    private javax.swing.JComboBox<String> cmb_keterangan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_hargabeli;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_namabarang;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JTable txt_absen;
    private javax.swing.JFormattedTextField txt_idabsen;
    private javax.swing.JFormattedTextField txt_idakun;
    private javax.swing.JFormattedTextField txt_tanggalmasuk;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
