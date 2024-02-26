package Tampilan_Admin;

import Config.Config;
import Tampilan_Awal.Absen;
import Tampilan_Awal.Login;
import Tampilan_Kasir.Transaks_Penjualan_Kasir;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class Dashboard1 extends javax.swing.JFrame {
  String Tanggal; // Variabel untuk menyimpan tanggal
private DefaultTableModel model; // Model tabel default

/**
 * Mengatur tanggal dan waktu saat ini.
 */
public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
    String formattedDate = dateTime.format(formatter);
    lbl_tanggal.setText(formattedDate); // Mengatur label tanggal dengan tanggal yang diformat
}

public Dashboard1() {
    initComponents();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");
    
    // Mengatur penjadwalan untuk memperbarui tanggal dan waktu secara periodik
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(new Runnable() {
        @Override
        public void run() {
            setTanggalDanWaktuSekarang();
            label_akun();
            label_barang();
            label_pelanggan();
            label_supplier();
            tabel_top10pelanggan();
            tabel_top10barang();
            tabel_stok_menipis();
            tabel_terjual();
        }
    }, 0, 1, TimeUnit.SECONDS);
}

private void label_akun() {
    try {
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        String query = "SELECT Total FROM view_akun";
        ResultSet res = stm.executeQuery(query);
        
        if (res.next()) {
            int akun = res.getInt("Total");
            label_akun.setText(String.valueOf(akun));
        }
        res.close();
        stm.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void label_supplier() {
    try {
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        String query = "SELECT Total FROM view_supplier";
        ResultSet res = stm.executeQuery(query);
        
        if (res.next()) {
            int akun = res.getInt("Total");
            label_supplier.setText(String.valueOf(akun));
        }
        res.close();
        stm.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void label_pelanggan() {
    try {
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        String query = "SELECT Total FROM view_pelanggan";
        ResultSet res = stm.executeQuery(query);
        
        if (res.next()) {
            int akun = res.getInt("Total");
            label_pelanggan.setText(String.valueOf(akun));
        }
        res.close();
        stm.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void label_barang() {
    try {
        Connection conn = Config.configDB();
        Statement stm = conn.createStatement();
        String query = "SELECT Total FROM view_barang";
        ResultSet res = stm.executeQuery(query);
        
        if (res.next()) {
            int akun = res.getInt("Total");
            label_barang.setText(String.valueOf(akun));
        }
        res.close();
        stm.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
     
    private void tabel_top10pelanggan() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Pelanggan");
    model.addColumn("Nama Pelanggan");
    model.addColumn("Gmail");
    model.addColumn("telepon");
    model.addColumn("Transaksi");

    try {
        int no = 1;
        String sql = "SELECT view_top10pelanggan.id_pelanggan, view_top10pelanggan.nama_pelanggan, view_top10pelanggan.email, view_top10pelanggan.telepon, view_top10pelanggan.total_transaksi FROM view_top10pelanggan";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                    res.getString("id_pelanggan"),
                    res.getString("nama_pelanggan"),
                    res.getString("email"),
                    res.getString("telepon"),
                    res.getString("total_transaksi"),
            });
        }
        tabel_1.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
} 
    private void tabel_top10barang() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Kategori");
    model.addColumn("Harga");
    model.addColumn("Jumlah");
    
    try {
        int no = 1;
        String sql = "SELECT view_top10barang.id_barang, view_top10barang.nama_barang, view_top10barang.kategori, view_top10barang.harga, view_top10barang.total_penjualan FROM view_top10barang";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("kategori"),
                    res.getString("harga"),
                    res.getString("total_penjualan"),
            });
        }
        tabel_2.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
} 
    
    private void tabel_stok_menipis() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Kategori");
    model.addColumn("Harga");
    model.addColumn("Stok");
    
    try {
        int no = 1;
        String sql = "SELECT view_stok_menipis.id_barang, view_stok_menipis.nama_barang, view_stok_menipis.kategori, view_stok_menipis.harga, view_stok_menipis.stok FROM view_stok_menipis";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("kategori"),
                    res.getString("harga"),
                    res.getString("stok"),
            });
        }
        tabel_4.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
} 
    
    private void tabel_terjual() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Kategori");
    model.addColumn("Harga");
    model.addColumn("Jumlah");
    
    try {
        int no = 1;
        String sql = "SELECT view_jumlah_penjualan.id_barang, view_jumlah_penjualan.nama_barang, view_jumlah_penjualan.kategori, view_jumlah_penjualan.harga, view_jumlah_penjualan.total_penjualan FROM view_jumlah_penjualan";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                    res.getString("id_barang"),
                    res.getString("nama_barang"),
                    res.getString("kategori"),
                    res.getString("harga"),
                    res.getString("total_penjualan"),
            });
        }
        tabel_3.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
} 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_tanggal = new javax.swing.JLabel();
        bab = new javax.swing.JLabel();
        btn_dashboard = new javax.swing.JButton();
        btn_datamaster = new javax.swing.JButton();
        btn_opname = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_oprasional = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        btn_logout2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_3 = new javax.swing.JTable();
        bab1 = new javax.swing.JLabel();
        bab2 = new javax.swing.JLabel();
        bab3 = new javax.swing.JLabel();
        label_akun = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_4 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabel_1 = new javax.swing.JTable();
        label_supplier = new javax.swing.JLabel();
        label_pelanggan = new javax.swing.JLabel();
        label_barang = new javax.swing.JLabel();
        bab8 = new javax.swing.JLabel();
        btn_next = new javax.swing.JButton();
        lbl_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bab.setText("Top 10 Barang");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 260, 540, 50));

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

        tabel_2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        tabel_2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane1.setViewportView(tabel_2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, 540, 160));

        tabel_3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        tabel_3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane2.setViewportView(tabel_3);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 540, 160));

        bab1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bab1.setText("Barang terjual Hari Ini");
        getContentPane().add(bab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 540, 50));

        bab2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab2.setText("Hai Admin, Selamat Datang Di Menu Dashboard");
        getContentPane().add(bab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 1120, 50));

        bab3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bab3.setText("Stok Menipis");
        getContentPane().add(bab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 470, 540, 50));

        label_akun.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        label_akun.setForeground(new java.awt.Color(255, 255, 255));
        label_akun.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(label_akun, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 250, 50));

        tabel_4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        tabel_4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane3.setViewportView(tabel_4);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 520, 540, 160));

        tabel_1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        tabel_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane4.setViewportView(tabel_1);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 540, 160));

        label_supplier.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        label_supplier.setForeground(new java.awt.Color(255, 255, 255));
        label_supplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(label_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 250, 50));

        label_pelanggan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        label_pelanggan.setForeground(new java.awt.Color(255, 255, 255));
        label_pelanggan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(label_pelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 170, 240, 50));

        label_barang.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        label_barang.setForeground(new java.awt.Color(255, 255, 255));
        label_barang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(label_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 170, 250, 50));

        bab8.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bab8.setText("Top 10 Pelanggan");
        getContentPane().add(bab8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 540, 50));

        btn_next.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        btn_next.setText("< Next ");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });
        getContentPane().add(btn_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(1243, 73, 100, 40));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Dashboard (5).png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed

    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_datamasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datamasterActionPerformed
        this.setVisible(false);
            new Menu_master().setVisible(true);
    }//GEN-LAST:event_btn_datamasterActionPerformed

    private void btn_opnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opnameActionPerformed
        this.setVisible(false);
            new Opname().setVisible(true);
    }//GEN-LAST:event_btn_opnameActionPerformed

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        this.setVisible(false);
            new Return().setVisible(true);
    }//GEN-LAST:event_btn_returnActionPerformed

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
        int result = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin logout?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btn_logout2ActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        this.setVisible(false);
            new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_nextActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JLabel bab1;
    private javax.swing.JLabel bab2;
    private javax.swing.JLabel bab3;
    private javax.swing.JLabel bab8;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_datamaster;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout2;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_opname;
    private javax.swing.JButton btn_oprasional;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel label_akun;
    private javax.swing.JLabel label_barang;
    private javax.swing.JLabel label_pelanggan;
    private javax.swing.JLabel label_supplier;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JTable tabel_1;
    private javax.swing.JTable tabel_2;
    private javax.swing.JTable tabel_3;
    private javax.swing.JTable tabel_4;
    // End of variables declaration//GEN-END:variables
}
