package Role_Karyawan;

import Role_Karyawan.*;
import Aplikasi.*;
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

public class Opname extends javax.swing.JFrame {
    String Tanggal;
    private DefaultTableModel model;
     
    public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now(); // Mendapatkan tanggal dan waktu sekarang
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss"); // Menentukan format tanggal dan waktu yang diinginkan
    String formattedDateTime = dateTime.format(formatter); // Mengubah tanggal dan waktu menjadi string dengan format yang ditentukan
    txt_tanggal.setText(formattedDateTime); // Mengatur nilai pada text field txt_tanggal dengan tanggal dan waktu yang sudah diformat
}
    public Opname() {
    initComponents(); // Menginisialisasi komponen GUI
    setExtendedState(JFrame.MAXIMIZED_BOTH); // Mengatur ukuran jendela aplikasi menjadi maksimal
    this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik"); // Mengatur judul jendela aplikasi

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(); // Membuat executor untuk menjalankan tugas terjadwal
    executor.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            Date date = new Date();
            SimpleDateFormat s = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
            txt_tanggal.setText(s.format(date)); // Mengatur nilai pada text field txt_tanggal dengan format tanggal yang ditentukan
        }
    }, 0, 1, TimeUnit.SECONDS); // Menjadwalkan tugas untuk dijalankan setiap detik

    tabel_supplier(); // Memperbarui tabel_supplier
    txt_idopname.setText(getNextIdOpname()); // Mengatur nilai pada text field txt_idopname dengan nilai yang didapatkan dari metode getNextIdOpname
    kosong(); // Mengosongkan input field

    Date date = new Date();
    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-yy");
    txt_tanggalmasuk.setText(s.format(date)); // Mengatur nilai pada text field txt_tanggalmasuk dengan format tanggal yang ditentukan
}
    
    private String getNextIdOpname() {
    try {
        String sql = "SELECT MAX(Id_opname) AS max_id FROM opname"; // Query SQL untuk mendapatkan nilai maksimum dari kolom Id_opname dalam tabel opname
        System.out.println(sql); // Menampilkan query SQL pada console
        java.sql.Connection conn = Aplikasi.Config.configDB(); // Membuat koneksi ke database
        java.sql.Statement stm = conn.createStatement(); // Membuat statement SQL
        java.sql.ResultSet res = stm.executeQuery(sql); // Menjalankan perintah SQL untuk mendapatkan hasil query
        if (res.next()) {
            int maxId = res.getInt("max_id"); // Mendapatkan nilai maksimum dari kolom max_id
            return String.valueOf(maxId + 1); // Mengembalikan nilai maxId + 1 sebagai string
        } else {
            return "1"; // Jika tidak ada hasil query, mengembalikan string "1"
        }
    } catch (Exception e) {
        e.printStackTrace(); // Menampilkan trace error jika terjadi exception
        JOptionPane.showMessageDialog(null, "Gagal Mengambil Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // Menampilkan pesan error jika terjadi exception
        return ""; // Mengembalikan string kosong
    }
}
     
    private void kosong(){
    txt_idbarang.setText(null); // Mengosongkan text field txt_idbarang
    txt_namabarang.setText(null); // Mengosongkan text field txt_namabarang
    txt_keterangan.setText(null); // Mengosongkan text field txt_keterangan
    txt_tanggalmasuk.setText(null); // Mengosongkan text field txt_tanggalmasuk
    txt_jumlahsistem.setText(null); // Mengosongkan text field txt_jumlahsistem
    txt_jumlahfisik.setText(null); // Mengosongkan text field txt_jumlahfisik
}

    private void tabel_supplier() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Opname");
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Jumlah Fisik");
    model.addColumn("Jumlah Sistem");
    model.addColumn("Selisih");
    model.addColumn("Keterangan");
    model.addColumn("Tanggal");

    try {
        int no = 1;
        String sql = "SELECT opname.id_opname, opname.id_barang, opname.nama_barang, opname.jumlah_fisik, opname.jumlah_sistem, opname.selisih, opname.keterangan, opname.tanggal FROM opname"; // Query SQL untuk mendapatkan data opname
        java.sql.Connection conn = (Connection) Config.configDB(); // Membuat koneksi ke database
        java.sql.Statement stm = conn.createStatement(); // Membuat statement SQL
        java.sql.ResultSet res = stm.executeQuery(sql); // Menjalankan perintah SQL untuk mendapatkan hasil query

        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id_opname"),
                res.getString("id_barang"),
                res.getString("nama_barang"),
                res.getString("jumlah_fisik"),
                res.getString("jumlah_sistem"),
                res.getString("selisih"),
                res.getString("keterangan"),
                res.getString("tanggal")
            });
        }
        tabel_opname.setModel(model); // Mengatur model tabel pada tabel_opname
    } catch (Exception e) {
        e.printStackTrace(); // Menampilkan trace error jika terjadi exception
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_opname = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        txt_tanggal = new javax.swing.JLabel();
        lbl_idopname = new javax.swing.JLabel();
        txt_idopname = new javax.swing.JFormattedTextField();
        lbl_idbarang = new javax.swing.JLabel();
        txt_idbarang = new javax.swing.JFormattedTextField();
        lbl_jumlahfisik = new javax.swing.JLabel();
        txt_selisih = new javax.swing.JFormattedTextField();
        lbl_jumlahsistem = new javax.swing.JLabel();
        txt_keterangan = new javax.swing.JFormattedTextField();
        lbl_namabarang = new javax.swing.JLabel();
        txt_namabarang = new javax.swing.JFormattedTextField();
        lbl_katerangan = new javax.swing.JLabel();
        txt_tanggalmasuk = new javax.swing.JFormattedTextField();
        lbl_selisih = new javax.swing.JLabel();
        txt_jumlahfisik = new javax.swing.JFormattedTextField();
        lbl_tanggal = new javax.swing.JLabel();
        txt_jumlahsistem = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_opname = new javax.swing.JTable();
        txt_cari = new javax.swing.JFormattedTextField();
        btn_cari = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        body = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_opname.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_opname.setForeground(new java.awt.Color(255, 255, 255));
        btn_opname.setText("Opname");
        btn_opname.setContentAreaFilled(false);
        btn_opname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_opnameActionPerformed(evt);
            }
        });
        getContentPane().add(btn_opname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 250, -1));

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

        txt_tanggal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        txt_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 450, 50));

        lbl_idopname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_idopname.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idopname.setText("Id Opname");
        getContentPane().add(lbl_idopname, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        txt_idopname.setEnabled(false);
        txt_idopname.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_idopname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idopnameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idopname, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, 30));

        lbl_idbarang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_idbarang.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idbarang.setText("Id Barang");
        getContentPane().add(lbl_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, -1, -1));

        txt_idbarang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_idbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idbarangActionPerformed(evt);
            }
        });
        txt_idbarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_idbarangKeyReleased(evt);
            }
        });
        getContentPane().add(txt_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 100, 30));

        lbl_jumlahfisik.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_jumlahfisik.setForeground(new java.awt.Color(255, 255, 255));
        lbl_jumlahfisik.setText("Jumlah Fisik");
        getContentPane().add(lbl_jumlahfisik, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 110, -1, -1));

        txt_selisih.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_selisih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_selisihActionPerformed(evt);
            }
        });
        getContentPane().add(txt_selisih, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 130, 140, 30));

        lbl_jumlahsistem.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_jumlahsistem.setForeground(new java.awt.Color(255, 255, 255));
        lbl_jumlahsistem.setText("Jumlah Sistem");
        getContentPane().add(lbl_jumlahsistem, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 170, -1, -1));

        txt_keterangan.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_keterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_keteranganActionPerformed(evt);
            }
        });
        getContentPane().add(txt_keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 390, 30));

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

        lbl_katerangan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_katerangan.setForeground(new java.awt.Color(255, 255, 255));
        lbl_katerangan.setText("Keterangan");
        getContentPane().add(lbl_katerangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        txt_tanggalmasuk.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_tanggalmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tanggalmasukActionPerformed(evt);
            }
        });
        getContentPane().add(txt_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 190, 140, 30));

        lbl_selisih.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_selisih.setForeground(new java.awt.Color(255, 255, 255));
        lbl_selisih.setText("Selisih");
        getContentPane().add(lbl_selisih, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 110, -1, -1));

        txt_jumlahfisik.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_jumlahfisik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahfisikActionPerformed(evt);
            }
        });
        getContentPane().add(txt_jumlahfisik, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 130, 130, 30));

        lbl_tanggal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setText("Tanggal");
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 170, -1, -1));

        txt_jumlahsistem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_jumlahsistem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahsistemActionPerformed(evt);
            }
        });
        getContentPane().add(txt_jumlahsistem, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 190, 130, 30));

        tabel_opname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabel_opname.setModel(new javax.swing.table.DefaultTableModel(
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
                "Id Opname", "Id Barang", "Nama Barang", "Jumlah Fisik", "Jumlah Sistem", "Selisih", "Keterangan ", "Tanggal"
            }
        ));
        tabel_opname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_opnameMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_opname);

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
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        getContentPane().add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, -1, -1));

        btn_hapus.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 270, -1, -1));

        body.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Opname (1).png"))); // NOI18N
        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idopnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idopnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idopnameActionPerformed

    private void txt_idbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idbarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idbarangActionPerformed

    private void txt_selisihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_selisihActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_selisihActionPerformed

    private void txt_keteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_keteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_keteranganActionPerformed

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_tanggalmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tanggalmasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tanggalmasukActionPerformed

    private void txt_jumlahfisikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahfisikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahfisikActionPerformed

    private void txt_jumlahsistemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahsistemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahsistemActionPerformed

    private void tabel_opnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_opnameMouseClicked
        int baris = tabel_opname.rowAtPoint(evt.getPoint()); // Mendapatkan baris yang diklik pada tabel_opname
String id_barang = tabel_opname.getValueAt(baris, 0).toString(); // Mendapatkan nilai id_barang dari baris yang diklik
txt_idopname.setText(id_barang); // Mengatur nilai pada text field txt_idopname
System.out.println(id_barang); // Menampilkan id_barang pada console
txt_idopname.disable(); // Menonaktifkan text field txt_idopname

if (tabel_opname.getValueAt(baris, 1) == null) {
    txt_idbarang.setText("");
} else {
    txt_idbarang.setText(tabel_opname.getValueAt(baris, 1).toString());
}

if (tabel_opname.getValueAt(baris, 2) == null) {
    txt_namabarang.setText("");
} else {
    txt_namabarang.setText(tabel_opname.getValueAt(baris, 2).toString());
}

if (tabel_opname.getValueAt(baris, 3) == null) {
    txt_jumlahfisik.setText("");
} else {
    txt_jumlahfisik.setText(tabel_opname.getValueAt(baris, 3).toString());
}

if (tabel_opname.getValueAt(baris, 4) == null) {
    txt_jumlahsistem.setText("");
} else {
    txt_jumlahsistem.setText(tabel_opname.getValueAt(baris, 4).toString());
}

if (tabel_opname.getValueAt(baris, 5) == null) {
    txt_selisih.setText("");
} else {
    txt_selisih.setText(tabel_opname.getValueAt(baris, 5).toString());
}

if (tabel_opname.getValueAt(baris, 6) == null) {
    txt_keterangan.setText("");
} else {
    txt_keterangan.setText(tabel_opname.getValueAt(baris, 6).toString());
}

if (tabel_opname.getValueAt(baris, 7) == null) {
    txt_tanggalmasuk.setText("");
} else {
    txt_tanggalmasuk.setText(tabel_opname.getValueAt(baris, 7).toString());
}
    }//GEN-LAST:event_tabel_opnameMouseClicked

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        try {
    Connection conn = Config.configDB(); // Membuat koneksi ke database
    Statement statement = conn.createStatement(); // Membuat statement SQL
    String searchKeyword = txt_cari.getText(); // Mendapatkan nilai dari text field txt_cari
    String sql = "SELECT * FROM opname WHERE tanggal LIKE ?"; // Query SQL untuk mencari data opname berdasarkan tanggal
    PreparedStatement pst = conn.prepareStatement(sql); // Mempersiapkan statement SQL
    pst.setString(1, "%" + searchKeyword + "%"); // Mengatur parameter pada statement SQL
    ResultSet res = pst.executeQuery(); // Menjalankan perintah SQL untuk mendapatkan hasil pencarian

    DefaultTableModel model = new DefaultTableModel(); // Membuat model tabel
    model.addColumn("Id Opname");
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Jumlah Fisik");
    model.addColumn("Jumlah Sistem");
    model.addColumn("Selisih");
    model.addColumn("Keterangan");
    model.addColumn("Tanggal");
    tabel_opname.setModel(model); // Mengatur model tabel pada tabel_opname

    int no = 1;
    while (res.next()) {
        model.addRow(new Object[]{
            no,
            res.getString("id_opname"),
            res.getString("id_barang"),
            res.getString("nama_barang"),
            res.getString("jumlah_fisik"),
            res.getString("jumlah_sistem"),
            res.getString("selisih"),
            res.getString("keterangan"),
            res.getString("tanggal")
        });
        no++;
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(rootPane, "Gagal Mengambil Data: " + e.getMessage()); // Menampilkan pesan error jika terjadi exception
}
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        try {
    String idBarang = txt_idbarang.getText(); // Mendapatkan nilai dari text field txt_idbarang
    String namaBarang = txt_namabarang.getText(); // Mendapatkan nilai dari text field txt_namabarang
    String jumlahSistem = txt_jumlahsistem.getText(); // Mendapatkan nilai dari text field txt_jumlahsistem
    String tanggal = txt_tanggalmasuk.getText(); // Mendapatkan nilai dari text field txt_tanggalmasuk
    String jumlahFisik = txt_jumlahfisik.getText(); // Mendapatkan nilai dari text field txt_jumlahfisik
    String selisih = txt_selisih.getText(); // Mendapatkan nilai dari text field txt_selisih
    String keterangan = txt_keterangan.getText(); // Mendapatkan nilai dari text field txt_keterangan
    String idOpname = txt_idopname.getText(); // Mendapatkan nilai dari text field txt_idopname

    // Periksa apakah setiap field telah diisi
    if (idOpname.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Id Opname Harus Diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (idBarang.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Id Barang Harus Diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (namaBarang.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nama Barang Harus Diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (jumlahFisik.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Jumlah Fisik Harus Diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (jumlahSistem.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Jumlah Sistem Harus Diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (selisih.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Selisih Harus Diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (keterangan.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Keterangan Harus Diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (tanggal.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Tanggal Harus Diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        String sqlCheck = "SELECT * FROM opname WHERE id_opname=?"; // Query SQL untuk memeriksa keberadaan Id Opname dalam database
        java.sql.Connection conn = Aplikasi.Config.configDB(); // Membuat koneksi ke database
        java.sql.PreparedStatement pstCheck = conn.prepareStatement(sqlCheck); // Mempersiapkan statement SQL
        pstCheck.setString(1, idOpname); // Mengatur parameter pada statement SQL
        java.sql.ResultSet rsCheck = pstCheck.executeQuery(); // Menjalankan perintah SQL untuk memeriksa keberadaan Id Opname

        if (rsCheck.next()) {
            JOptionPane.showMessageDialog(null, "Id Opname Sudah Ada Dalam Database", "Error", JOptionPane.ERROR_MESSAGE); // Menampilkan pesan error jika Id Opname sudah ada dalam database
        } else {
            String sql = "INSERT INTO opname (id_opname, id_barang, nama_barang, jumlah_fisik, jumlah_sistem, selisih, keterangan, tanggal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // Query SQL untuk menyimpan data ke tabel opname
            java.sql.PreparedStatement pst = conn.prepareStatement(sql); // Mempersiapkan statement SQL
            pst.setString(1, idOpname); // Mengatur parameter pada statement SQL
            pst.setString(2, idBarang); // Mengatur parameter pada statement SQL
            pst.setString(3, namaBarang); // Mengatur parameter pada statement SQL
            pst.setString(4, jumlahFisik); // Mengatur parameter pada statement SQL
            pst.setString(5, jumlahSistem); // Mengatur parameter pada statement SQL
            pst.setString(6, selisih); // Mengatur parameter pada statement SQL
            pst.setString(7, keterangan); // Mengatur parameter pada statement SQL
            pst.setString(8, tanggal); // Mengatur parameter pada statement SQL
            pst.execute(); // Menjalankan perintah SQL untuk menyimpan data
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Berhasil", JOptionPane.INFORMATION_MESSAGE); // Menampilkan pesan sukses
            tabel_supplier(); // Memperbarui tabel_supplier
            txt_idopname.setText(getNextIdOpname()); // Mengatur nilai pada text field txt_idopname
            kosong(); // Mengosongkan input field
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // Menampilkan pesan error jika terjadi exception
}
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
    try {
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Mengedit Data Ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String idBarang = txt_idbarang.getText(); // Mendapatkan nilai dari text field txt_idbarang
        String namaBarang = txt_namabarang.getText(); // Mendapatkan nilai dari text field txt_namabarang
        String jumlahSistem = txt_jumlahsistem.getText(); // Mendapatkan nilai dari text field txt_jumlahsistem
        String tanggal = txt_tanggalmasuk.getText(); // Mendapatkan nilai dari text field txt_tanggalmasuk
        String jumlahFisik = txt_jumlahfisik.getText(); // Mendapatkan nilai dari text field txt_jumlahfisik
        String selisih = txt_selisih.getText(); // Mendapatkan nilai dari text field txt_selisih
        String keterangan = txt_keterangan.getText(); // Mendapatkan nilai dari text field txt_keterangan
        String idOpname = txt_idopname.getText(); // Mendapatkan nilai dari text field txt_idopname

        java.sql.Connection conn = Config.configDB(); // Membuat koneksi ke database
        String sql = "UPDATE barang SET id_barang=?, nama_barang=?, jumlah_fisik=?, jumlah_sistem=?, selisih=?, keterangan=?, tanggal=? WHERE Id_opname=?"; // Query SQL untuk mengupdate data barang
        java.sql.PreparedStatement pst = conn.prepareStatement(sql); // Mempersiapkan statement SQL
        pst.setString(1, idBarang); // Mengatur parameter pada statement SQL
        pst.setString(2, namaBarang); // Mengatur parameter pada statement SQL
        pst.setString(3, jumlahFisik); // Mengatur parameter pada statement SQL
        pst.setString(4, jumlahSistem); // Mengatur parameter pada statement SQL
        pst.setString(5, selisih); // Mengatur parameter pada statement SQL
        pst.setString(6, keterangan); // Mengatur parameter pada statement SQL
        pst.setString(7, tanggal); // Mengatur parameter pada statement SQL
        pst.setString(8, idOpname); // Mengatur parameter pada statement SQL
        pst.execute(); // Menjalankan perintah SQL untuk mengubah data
        JOptionPane.showMessageDialog(null, "Data Berhasil Diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE); // Menampilkan pesan sukses
        tabel_supplier(); // Memperbarui tabel_supplier
        txt_idopname.setText(getNextIdOpname()); // Mengatur nilai pada text field txt_idopname
        kosong(); // Mengosongkan input field
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal Mengubah Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // Menampilkan pesan error jika terjadi exception
}
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Menghapus Data Ini??", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String sqlbarang = "DELETE FROM opname WHERE id_opname=?"; // Query SQL untuk menghapus data dari tabel opname
        java.sql.Connection conn = Config.configDB(); // Membuat koneksi ke database
        java.sql.PreparedStatement pstbarang = conn.prepareStatement(sqlbarang); // Mempersiapkan statement SQL
        pstbarang.setString(1, txt_idopname.getText()); // Mengatur parameter pada statement SQL
        pstbarang.executeUpdate(); // Menjalankan perintah SQL untuk menghapus data
        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Sukses", JOptionPane.INFORMATION_MESSAGE); // Menampilkan pesan sukses
        txt_idopname.setText(getNextIdOpname()); // Mengatur nilai pada text field txt_idopname
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); // Menampilkan pesan error jika terjadi exception
}
tabel_supplier(); // Memperbarui tabel_barang
kosong(); // Mengosongkan input field
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_opnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opnameActionPerformed

    }//GEN-LAST:event_btn_opnameActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        this.dispose(); // Menutup frame saat ini
        new Login().setVisible(true); // Menampilkan frame Login
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void txt_idbarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idbarangKeyReleased
        String Nama = txt_idbarang.getText(); // Mendapatkan nilai dari text field txt_idbarang
try {
    String sql = "SELECT * FROM barang WHERE id_barang = ?"; // Query SQL untuk mengambil data barang berdasarkan id_barang
    java.sql.Connection conn = (Connection) Config.configDB(); // Membuat koneksi ke database
    java.sql.PreparedStatement stm = conn.prepareStatement(sql); // Mempersiapkan statement SQL
    stm.setString(1, Nama); // Mengatur parameter pada statement SQL
    java.sql.ResultSet res = stm.executeQuery(); // Menjalankan perintah SQL untuk mengambil data
    if (res.next()) {
        txt_namabarang.setText(res.getString("Nama_barang")); // Mengatur nilai pada text field txt_namabarang dengan data yang diambil dari ResultSet
    }
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage()); // Menampilkan pesan error jika terjadi exception
}
    }//GEN-LAST:event_txt_idbarangKeyReleased

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
 
    }//GEN-LAST:event_btn_printActionPerformed

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
            java.util.logging.Logger.getLogger(Opname.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Opname.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Opname.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Opname.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Opname().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel body;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_opname;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_idbarang;
    private javax.swing.JLabel lbl_idopname;
    private javax.swing.JLabel lbl_jumlahfisik;
    private javax.swing.JLabel lbl_jumlahsistem;
    private javax.swing.JLabel lbl_katerangan;
    private javax.swing.JLabel lbl_namabarang;
    private javax.swing.JLabel lbl_selisih;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JTable tabel_opname;
    private javax.swing.JFormattedTextField txt_cari;
    private javax.swing.JFormattedTextField txt_idbarang;
    private javax.swing.JFormattedTextField txt_idopname;
    private javax.swing.JFormattedTextField txt_jumlahfisik;
    private javax.swing.JFormattedTextField txt_jumlahsistem;
    private javax.swing.JFormattedTextField txt_keterangan;
    private javax.swing.JFormattedTextField txt_namabarang;
    private javax.swing.JFormattedTextField txt_selisih;
    private javax.swing.JLabel txt_tanggal;
    private javax.swing.JFormattedTextField txt_tanggalmasuk;
    // End of variables declaration//GEN-END:variables
}
