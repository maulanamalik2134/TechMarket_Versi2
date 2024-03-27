package Tampilan_Admin;

import Config.Config;
import Tampilan_Awal.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Laporan_Transaksi_Penjualan extends javax.swing.JFrame {
private DefaultTableModel model;

public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
    String formattedDateTime = dateTime.format(formatter);
    lbl_tanggal.setText(formattedDateTime);
}

public Laporan_Transaksi_Penjualan() {
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
    tabel_laporanpenjualan();
}

private void tabel_laporanpenjualan() {
    model = new DefaultTableModel();
    model.addColumn("Id");
    model.addColumn("Username");
    model.addColumn("Pelanggan");
    model.addColumn("Nama Barang");
    model.addColumn("Total");
    model.addColumn("Bayar");
    model.addColumn("Kembalian");
    model.addColumn("Metode Pembayaran");
    model.addColumn("Tanggal Transaksi");
    try {
        int no = 1;
        String sql = "SELECT laporan_penjualan.id_transaksi, laporan_penjualan.username, laporan_penjualan.nama_pelanggan, laporan_penjualan.nama_barang, laporan_penjualan.total,"
                + "laporan_penjualan.bayar, laporan_penjualan.kembalian, laporan_penjualan.metode_pembayaran, laporan_penjualan.tanggal_transaksi FROM laporan_penjualan";
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while (res.next()) {
            model.addRow(new Object[]{
                res.getString("id_transaksi"),
                res.getString("username"),
                res.getString("nama_pelanggan"),
                res.getString("nama_barang"),
                res.getString("total"),
                res.getString("bayar"),
                res.getString("kembalian"),
                res.getString("metode_pembayaran"),
                res.getString("tanggal_transaksi"),
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

        jProgressBar1 = new javax.swing.JProgressBar();
        bab = new javax.swing.JLabel();
        lbl_tanggal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_supplier = new javax.swing.JTable();
        btn_laporanpembelian = new javax.swing.JButton();
        btn_laporanreturnpelanggan = new javax.swing.JButton();
        btn_laporanabsen = new javax.swing.JButton();
        btn_laporanreturnsupplier = new javax.swing.JButton();
        btn_laporanopname = new javax.swing.JButton();
        btn_dashboard = new javax.swing.JButton();
        btn_datamaster = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_opname = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        gambar = new javax.swing.JLabel();
        txt_namasupplier = new javax.swing.JFormattedTextField();
        txt_namasupplier1 = new javax.swing.JFormattedTextField();
        btn_cari = new javax.swing.JButton();
        cetak = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();
        txt_nama = new javax.swing.JLabel();
        lbl_tanggalmasuk = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setForeground(new java.awt.Color(255, 255, 255));
        bab.setText("Hai Admin, Selamat datang Di Laporan Penjualan");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 1120, 50));

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        tabel_supplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_supplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_supplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_supplier);
        if (tabel_supplier.getColumnModel().getColumnCount() > 0) {
            tabel_supplier.getColumnModel().getColumn(0).setResizable(false);
            tabel_supplier.getColumnModel().getColumn(1).setResizable(false);
            tabel_supplier.getColumnModel().getColumn(2).setResizable(false);
            tabel_supplier.getColumnModel().getColumn(3).setResizable(false);
            tabel_supplier.getColumnModel().getColumn(4).setResizable(false);
            tabel_supplier.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 1070, 490));

        btn_laporanpembelian.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_laporanpembelian.setText("Laporan Transaksi Pembelian");
        btn_laporanpembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanpembelianActionPerformed(evt);
            }
        });
        getContentPane().add(btn_laporanpembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, 30));

        btn_laporanreturnpelanggan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_laporanreturnpelanggan.setText("Laporan Return Pelanggan");
        btn_laporanreturnpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanreturnpelangganActionPerformed(evt);
            }
        });
        getContentPane().add(btn_laporanreturnpelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 60, 270, 30));

        btn_laporanabsen.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_laporanabsen.setText("Laporan Absen");
        btn_laporanabsen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanabsenActionPerformed(evt);
            }
        });
        getContentPane().add(btn_laporanabsen, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 270, 30));

        btn_laporanreturnsupplier.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_laporanreturnsupplier.setText("Laporan Return Supplier");
        btn_laporanreturnsupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanreturnsupplierActionPerformed(evt);
            }
        });
        getContentPane().add(btn_laporanreturnsupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 270, 30));

        btn_laporanopname.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_laporanopname.setText("Laporan Opname");
        btn_laporanopname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanopnameActionPerformed(evt);
            }
        });
        getContentPane().add(btn_laporanopname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 270, 30));

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

        gambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Administrator Male (1).png"))); // NOI18N
        getContentPane().add(gambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 50, 190, 120));

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
        getContentPane().add(txt_namasupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 270, -1));

        txt_namasupplier1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_namasupplier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namasupplier1ActionPerformed(evt);
            }
        });
        txt_namasupplier1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_namasupplier1KeyReleased(evt);
            }
        });
        getContentPane().add(txt_namasupplier1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 270, -1));

        btn_cari.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Search.png"))); // NOI18N
        btn_cari.setText("Cari");
        btn_cari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 140, 130, 30));

        cetak.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Print (1).png"))); // NOI18N
        cetak.setText("Cetak");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        getContentPane().add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 140, 130, 30));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_nama.setText("jLabel2");
        getContentPane().add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 74, 130, 30));

        lbl_tanggalmasuk.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggalmasuk.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggalmasuk.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggalmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabel_supplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_supplierMouseClicked

    }//GEN-LAST:event_tabel_supplierMouseClicked

    private void btn_laporanpembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanpembelianActionPerformed
        this.setVisible(false);
        new Laporan_Transaksi_Pembelian().setVisible(true);
    }//GEN-LAST:event_btn_laporanpembelianActionPerformed

    private void btn_laporanreturnpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanreturnpelangganActionPerformed
        this.setVisible(false);
        new Laporan_Return_Pelanggan().setVisible(true);
    }//GEN-LAST:event_btn_laporanreturnpelangganActionPerformed

    private void btn_laporanabsenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanabsenActionPerformed
        this.setVisible(false);
        new Laporan_Absen().setVisible(true);
    }//GEN-LAST:event_btn_laporanabsenActionPerformed

    private void btn_laporanreturnsupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanreturnsupplierActionPerformed
        this.setVisible(false);
        new Laporan_Return_Supplier().setVisible(true);
    }//GEN-LAST:event_btn_laporanreturnsupplierActionPerformed

    private void btn_laporanopnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanopnameActionPerformed
        this.setVisible(false);
        new Laporan_Opname().setVisible(true);
    }//GEN-LAST:event_btn_laporanopnameActionPerformed

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        this.setVisible(false);
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_datamasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datamasterActionPerformed
        this.setVisible(false);
        new Akun().setVisible(true);
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

    private void txt_namasupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namasupplierActionPerformed

    }//GEN-LAST:event_txt_namasupplierActionPerformed

    private void txt_namasupplierKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namasupplierKeyReleased

    }//GEN-LAST:event_txt_namasupplierKeyReleased

    private void txt_namasupplier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namasupplier1ActionPerformed

    }//GEN-LAST:event_txt_namasupplier1ActionPerformed

    private void txt_namasupplier1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namasupplier1KeyReleased

    }//GEN-LAST:event_txt_namasupplier1KeyReleased

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed

    }//GEN-LAST:event_btn_cariActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
       try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("Laporan_Penjualan.jasper"), null, Config.configDB());
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_cetakActionPerformed

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
            java.util.logging.Logger.getLogger(Laporan_Transaksi_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Laporan_Transaksi_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Laporan_Transaksi_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Laporan_Transaksi_Penjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Laporan_Transaksi_Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_datamaster;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_laporanabsen;
    private javax.swing.JButton btn_laporanopname;
    private javax.swing.JButton btn_laporanpembelian;
    private javax.swing.JButton btn_laporanreturnpelanggan;
    private javax.swing.JButton btn_laporanreturnsupplier;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_opname;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JButton cetak;
    private javax.swing.JLabel gambar;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JLabel lbl_tanggalmasuk;
    private javax.swing.JTable tabel_supplier;
    private javax.swing.JLabel txt_nama;
    private javax.swing.JFormattedTextField txt_namasupplier;
    private javax.swing.JFormattedTextField txt_namasupplier1;
    // End of variables declaration//GEN-END:variables
}