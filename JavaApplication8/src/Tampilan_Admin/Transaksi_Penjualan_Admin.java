package Tampilan_Admin;

import Config.Config;
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

public class Transaksi_Penjualan_Admin extends javax.swing.JFrame {
String Tanggal;
private DefaultTableModel model;

public void total() {
    int Jumlahbaris = tabel.getRowCount();
    int Subtotal = 0;
    int Total = 0;
    int Jumlah, Harga;
    for (int i = 0; i < Jumlahbaris; i++) {
        Jumlah = Integer.parseInt(tabel.getValueAt(i, 1).toString());
        Harga = Integer.parseInt(tabel.getValueAt(i, 3).toString());
        Subtotal = Subtotal + (Jumlah * Harga);
        Total += Subtotal;
    }
    txt_subtotal.setText(String.valueOf(Subtotal));
    txt_total.setText(String.valueOf(Total));
}

public void loaddata() {
    DefaultTableModel model = (DefaultTableModel) tabel.getModel();
    model.addRow(new Object[]{
        txt_idtransaksi.getText(),
        txt_idbarang.getText(),
        txt_namabarang.getText(),
        txt_hargajual.getText(),
        cmb_satuan.getSelectedItem(),
        txt_jumlah.getText(),
        txt_subtotal.getText()});
}

public void kosong() {
    DefaultTableModel model = (DefaultTableModel) tabel.getModel();
    while (model.getRowCount() > 0) {
        model.removeRow(0);
    }
}

public void utama() {
    txt_idbarang.setText("");
    txt_namabarang.setText("");
    txt_hargajual.setText("");
    cmb_satuan.setSelectedItem("");
    txt_jumlah.setText("");
    txt_subtotal.setText("");
    txt_idtransaksi.setText("");
}

public void clear1() {
    txt_idtransaksi.setText("");
    txt_idakun.setText("");
    txt_username.setText("");
    txt_idpelanggan.setText("");
    txt_namapelanggan.setText("");
    txt_tanggal.setText("");
    cmb_metode.setSelectedItem("");
    txt_total.setText("");
    txt_bayar.setText("");
    txt_kembalian.setText("");
}

public void clear2() {
    txt_idbarang.setText("");
    txt_namabarang.setText("");
    txt_hargajual.setText("");
    cmb_satuan.setSelectedItem("");
    txt_subtotal.setText("");
    txt_jumlah.setText("");
}

public int getStok() {
    int stok = 0;
    try {
        Connection conn = Config.configDB();
        Statement statement = conn.createStatement();
        String idBarang = txt_idbarang.getText();
        ResultSet res = statement.executeQuery("SELECT stok FROM barang WHERE Id_barang = '" + idBarang + "'");

        if (res.next()) {
            stok = res.getInt("stok");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Gagal Mengambil Data: " + e.getMessage());
    }
    return stok;
}

public void tambahtransaksi() {
    int jumlah, harga, total;
    jumlah = Integer.valueOf(txt_jumlah.getText());
    harga = Integer.valueOf(txt_hargajual.getText());

    // Cek stok
    int stok = getStok(); // Anda perlu mengimplementasikan metode ini
    if (stok == 0) {
        JOptionPane.showMessageDialog(null, "Stok habis untuk transaksi ini");
        return;
    } else if (stok < jumlah) {
        JOptionPane.showMessageDialog(null, "Stok tidak cukup untuk transaksi ini");
        return;
    } else if (stok <= 5) {
        JOptionPane.showMessageDialog(null, "Stok menipis");
    }

    total = jumlah * harga;
    txt_total.setText(String.valueOf(total));
    loaddata();
    total();
    clear2();
    txt_idbarang.requestFocus();
}

public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd-MM-yyyy HH:mm:ss");
    String formattedDateTime = dateTime.format(formatter);
    txt_tanggal.setText(formattedDateTime);
}

public Transaksi_Penjualan_Admin() {
    initComponents();
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setTitle("Aplikasi Kasir - Toko Imanuel Jember");
    model = new DefaultTableModel();
    tabel.setModel(model);
    model.addColumn("Id_transaksi");
    model.addColumn("Id Barang");
    model.addColumn("Nama Barang");
    model.addColumn("Harga ");
    model.addColumn("Satuan");
    model.addColumn("Jumlah");
    model.addColumn("SubTotal");

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(() -> {
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        txt_tanggal.setText(s.format(date));
    }, 0, 1, TimeUnit.SECONDS);

    try {
        String sql = "SELECT * FROM transaksi_penjualan order by id_transaksi desc limit 1";
        System.out.println(sql);
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            String noBaru = "" + (res.getInt("id_transaksi") + 1);
            txt_idtransaksi.setText(noBaru);
        } else {
            txt_idtransaksi.setText("1");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_tanggal = new javax.swing.JLabel();
        bab = new javax.swing.JLabel();
        btn_logout2 = new javax.swing.JButton();
        txt_namabarang = new javax.swing.JFormattedTextField();
        lbl_namabarang = new javax.swing.JLabel();
        lbl_hargajual = new javax.swing.JLabel();
        txt_hargajual = new javax.swing.JFormattedTextField();
        cmb_satuan = new javax.swing.JComboBox<>();
        lbl_hargabeli = new javax.swing.JLabel();
        lbl_stok = new javax.swing.JLabel();
        txt_jumlah = new javax.swing.JFormattedTextField();
        txt_subtotal = new javax.swing.JFormattedTextField();
        lbl_stok1 = new javax.swing.JLabel();
        lbl_namabarang1 = new javax.swing.JLabel();
        lbl_namabarang2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        txt_namapelanggan = new javax.swing.JFormattedTextField();
        btn_tambah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_bayar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        txt_total = new javax.swing.JFormattedTextField();
        txt_kembalian = new javax.swing.JFormattedTextField();
        txt_bayar = new javax.swing.JFormattedTextField();
        lbl_stok2 = new javax.swing.JLabel();
        lbl_stok3 = new javax.swing.JLabel();
        lbl_stok4 = new javax.swing.JLabel();
        btn_dashboard = new javax.swing.JButton();
        btn_datamaster = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        btn_opname1 = new javax.swing.JButton();
        btn_oprasional = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        cmb_metode = new javax.swing.JComboBox<>();
        lbl_stok5 = new javax.swing.JLabel();
        btn_cari = new javax.swing.JButton();
        txt_idtransaksi = new javax.swing.JFormattedTextField();
        lbl_image = new javax.swing.JLabel();
        txt_idbarang = new javax.swing.JFormattedTextField();
        txt_idpelanggan = new javax.swing.JFormattedTextField();
        txt_tanggal = new javax.swing.JFormattedTextField();
        txt_idakun = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_tanggal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        lbl_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lbl_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 450, 50));

        bab.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        bab.setText("Hai Admin, Selamat Datang Di Transaksi Penjualan");
        getContentPane().add(bab, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 1120, 50));

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

        txt_namabarang.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarangActionPerformed(evt);
            }
        });
        txt_namabarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_namabarangKeyReleased(evt);
            }
        });
        getContentPane().add(txt_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 310, -1));

        lbl_namabarang.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namabarang.setText("Username");
        getContentPane().add(lbl_namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        lbl_hargajual.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargajual.setText("Harga Jual");
        getContentPane().add(lbl_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, -1, -1));

        txt_hargajual.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_hargajual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargajualActionPerformed(evt);
            }
        });
        getContentPane().add(txt_hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 140, -1));

        cmb_satuan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        cmb_satuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pcs" }));
        getContentPane().add(cmb_satuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 120, 140, 30));

        lbl_hargabeli.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_hargabeli.setText("Satuan");
        getContentPane().add(lbl_hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, -1, -1));

        lbl_stok.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok.setText("Subtotal");
        getContentPane().add(lbl_stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 100, -1, -1));

        txt_jumlah.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });
        txt_jumlah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlahKeyReleased(evt);
            }
        });
        getContentPane().add(txt_jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 120, 140, -1));

        txt_subtotal.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_subtotalActionPerformed(evt);
            }
        });
        getContentPane().add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 120, 140, -1));

        lbl_stok1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok1.setText("Metode Pembayaran");
        getContentPane().add(lbl_stok1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 170, -1, -1));

        lbl_namabarang1.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namabarang1.setText("Pelanggan");
        getContentPane().add(lbl_namabarang1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, -1, -1));

        lbl_namabarang2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_namabarang2.setText("Nama Barang");
        getContentPane().add(lbl_namabarang2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

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
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 310, -1));

        txt_namapelanggan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        txt_namapelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namapelangganActionPerformed(evt);
            }
        });
        txt_namapelanggan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_namapelangganKeyReleased(evt);
            }
        });
        getContentPane().add(txt_namapelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 310, -1));

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

        btn_bayar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_bayar.setForeground(new java.awt.Color(153, 153, 0));
        btn_bayar.setText("Bayar");
        btn_bayar.setContentAreaFilled(false);
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 220, -1, -1));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
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
                "Nama Barang", "Harga", "Satuan", "Jumlah", "Subtotal"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 1070, 220));

        txt_total.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        getContentPane().add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 520, 260, -1));

        txt_kembalian.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        txt_kembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kembalianActionPerformed(evt);
            }
        });
        getContentPane().add(txt_kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 640, 260, -1));

        txt_bayar.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        txt_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bayarActionPerformed(evt);
            }
        });
        txt_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_bayarKeyReleased(evt);
            }
        });
        getContentPane().add(txt_bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 580, 260, -1));

        lbl_stok2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok2.setText("Bayar");
        getContentPane().add(lbl_stok2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, -1, -1));

        lbl_stok3.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok3.setText("Kembalian");
        getContentPane().add(lbl_stok3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 620, -1, -1));

        lbl_stok4.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok4.setText("Total");
        getContentPane().add(lbl_stok4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, -1, -1));

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

        cmb_metode.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 18)); // NOI18N
        cmb_metode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tunai", "Non Tunai" }));
        getContentPane().add(cmb_metode, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 190, 140, 30));

        lbl_stok5.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 14)); // NOI18N
        lbl_stok5.setText("Jumlah");
        getContentPane().add(lbl_stok5, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, -1, -1));

        btn_cari.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 24)); // NOI18N
        btn_cari.setText("Cari Nama Barang?");
        btn_cari.setContentAreaFilled(false);
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        txt_idtransaksi.setText("jFormattedTextField1");
        getContentPane().add(txt_idtransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 160, -1, -1));

        lbl_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Tampilan_Backend.png"))); // NOI18N
        getContentPane().add(lbl_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txt_idbarang.setText("jFormattedTextField2");
        getContentPane().add(txt_idbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 180, -1, -1));

        txt_idpelanggan.setText("jFormattedTextField3");
        txt_idpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idpelangganActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idpelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 200, -1, -1));

        txt_tanggal.setText("jFormattedTextField4");
        getContentPane().add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 170, -1, -1));

        txt_idakun.setText("jFormattedTextField3");
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout2ActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin logout?", "Konfirmasi Transaksi", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }//GEN-LAST:event_btn_logout2ActionPerformed

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void txt_hargajualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargajualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargajualActionPerformed

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlahActionPerformed

    private void txt_subtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_subtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_subtotalActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_namapelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namapelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namapelangganActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        tambahtransaksi();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        int row = tabel.getSelectedRow();
        model.removeRow(row);
        total();
        txt_bayar.setText("0");
        txt_kembalian.setText("0");
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        try {
    int Total, Bayar, Kembalian;
    Total = Integer.parseInt(txt_total.getText());
    Bayar = Integer.parseInt(txt_bayar.getText());
    System.out.println("Total: " + Total);
    System.out.println("Bayar: " + Bayar);
    if (Total > Bayar) {
        JOptionPane.showMessageDialog(null, "Uang Tidak Cukup Untuk Melakukan Pembayaran");
    } else {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin melakukan pembayaran?", "Konfirmasi", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            Kembalian = Bayar - Total;
            System.out.println("Kembalian: " + Kembalian);
            txt_kembalian.setText(String.valueOf(Kembalian));
            DefaultTableModel model = (DefaultTableModel) tabel.getModel();
            String Id_transaksi = txt_idtransaksi.getText();
            String Id_akun = txt_idakun.getText();
            String Username = txt_username.getText();
            String Id_pelanggan = txt_idpelanggan.getText();
            String Nama_pelanggan = txt_namapelanggan.getText();
            String TotalString = txt_total.getText();
            String Metode = (String) cmb_metode.getSelectedItem();
            String Tanggal = txt_tanggal.getText();
            System.out.println(Id_transaksi + " " + Id_akun + " " + Username + " " + Id_pelanggan + " " + Nama_pelanggan + " " + Total + " " + Metode + " " + Tanggal);
            try {
                Connection c = Config.configDB();
                String sql = "INSERT INTO transaksi_penjualan VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement p = c.prepareStatement(sql);
                p.setInt(1, Integer.parseInt(Id_transaksi));
                p.setInt(2, Integer.parseInt(Id_akun));
                p.setString(3, Username);
                p.setInt(4, Integer.parseInt(Id_pelanggan));
                p.setString(5, Nama_pelanggan);
                p.setInt(6, Total);
                p.setString(7, Metode);
                p.setString(8, Tanggal);
                p.executeUpdate();
                p.close();
            } catch (Exception e) {
                System.out.println("Simpan Pembelian Error 1" + e);
            }

            try {
                Connection c = Config.configDB();
                int baris = tabel.getRowCount();
                for (int i = 0; i < baris; i++) {
                    String sql = "INSERT INTO detail_transaksi_penjualan (id_transaksi, id_barang, nama_barang, harga_barang, satuan, jumlah, subtotal) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement p = c.prepareStatement(sql);
                    
                    p.setString(1, (String) tabel.getValueAt(i, 0));
                    p.setString(2, (String) tabel.getValueAt(i, 1));
                    p.setString(3, (String) tabel.getValueAt(i, 2));
                    p.setString(4, (String) tabel.getValueAt(i, 3));
                    p.setString(5, (String) tabel.getValueAt(i, 4));
                    p.setString(6, (String) tabel.getValueAt(i, 5));
                    p.setString(7, (String) tabel.getValueAt(i, 6));
                    p.executeUpdate();
                    p.close();
                }
            } catch (Exception e) {
                System.out.println("Simpan Pembelian Error 2: " + e);
            }
            clear1();
            utama();
            kosong();
        }
    }
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Masukkan Angka Yang Valid");
    txt_bayar.setText("0");
    txt_kembalian.setText("0");
}
    }//GEN-LAST:event_btn_bayarActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        try{
            int baris = tabel.rowAtPoint(evt.getPoint());
            Connection conn = Config.configDB();
            Statement stm = conn.createStatement();

            // Ambil nilai ID akun dari baris yang dipilih
            String id_barang = tabel.getValueAt(baris, 0).toString();
            txt_idbarang.setText(id_barang);
            System.out.println(id_barang);
            txt_idbarang.setEnabled(false);

            // Set nilai username
            txt_namabarang.setText(tabel.getValueAt(baris, 1) == null ? "" : tabel.getValueAt(baris, 1).toString());

            // Set nilai telepon
            txt_hargajual.setText(tabel.getValueAt(baris, 2) == null ? "" : tabel.getValueAt(baris, 2).toString(
            ));

            // Set nilai username
            cmb_satuan.setSelectedItem(tabel.getValueAt(baris, 3) == null ? "" : tabel.getValueAt(baris, 3).toString());
            // Set nilai username

            txt_jumlah.setText(tabel.getValueAt(baris, 4) == null ? "" : tabel.getValueAt(baris, 4).toString());

            // set nilai namabarang
            txt_subtotal.setText(tabel.getValueAt(baris,5) == null ? "" : tabel.getValueAt(baris, 5).toString());

        }
        catch(SQLException ex){
            Logger.getLogger(Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tabelMouseClicked

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_kembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kembalianActionPerformed

    private void txt_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bayarActionPerformed

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

    private void btn_opname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_opname1ActionPerformed
        this.setVisible(false);
        new Opname().setVisible(true);
    }//GEN-LAST:event_btn_opname1ActionPerformed

    private void btn_oprasionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_oprasionalActionPerformed
        this.setVisible(false);
        new Oprasional().setVisible(true);
    }//GEN-LAST:event_btn_oprasionalActionPerformed

    private void btn_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanActionPerformed
        this.setVisible(false);
        new Menu_Laporan().setVisible(true);
    }//GEN-LAST:event_btn_laporanActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cariActionPerformed

    private void txt_namabarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namabarangKeyReleased
        String Nama = txt_namabarang.getText();
    try {
        String sql = "SELECT * FROM barang WHERE Nama_barang = ?";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, Nama);
        java.sql.ResultSet res = stm.executeQuery();
        if (res.next()) {
            txt_namabarang.setText(res.getString("Nama_barang"));
            txt_idbarang.setText(res.getString("Id_barang"));
            txt_hargajual.setText(res.getString("harga"));
            cmb_satuan.setSelectedItem(res.getString("satuan"));
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    }//GEN-LAST:event_txt_namabarangKeyReleased

    private void txt_usernameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usernameKeyReleased
        String Nama = txt_username.getText();
    try {
        String sql = "SELECT * FROM akun WHERE username = ?";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, Nama);
        java.sql.ResultSet res = stm.executeQuery();
        if (res.next()) {
            txt_username.setText(res.getString("username"));
            txt_idakun.setText(res.getString("Id_akun"));
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    }//GEN-LAST:event_txt_usernameKeyReleased

    private void txt_namapelangganKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_namapelangganKeyReleased
        String Nama = txt_namapelanggan.getText();
    try {
        String sql = "SELECT * FROM pelanggan WHERE nama_pelanggan = ?";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, Nama);
        java.sql.ResultSet res = stm.executeQuery();
        if (res.next()) {
            txt_namapelanggan.setText(res.getString("nama_pelanggan"));
            txt_idpelanggan.setText(res.getString("Id_pelanggan"));
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    }//GEN-LAST:event_txt_namapelangganKeyReleased

    private void txt_idpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idpelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idpelangganActionPerformed

    private void txt_jumlahKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahKeyReleased
        int Harga = Integer.parseInt(txt_hargajual.getText());
        int Jumlah = Integer.parseInt(txt_jumlah.getText());
        String Hasil = "" + (Harga * Jumlah);
        txt_subtotal.setText(Hasil);
    }//GEN-LAST:event_txt_jumlahKeyReleased

    private void txt_bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_bayarKeyReleased
        int Total = Integer.parseInt(txt_total.getText());
        int Bayar = Integer.parseInt(txt_bayar.getText());
        if (Total == 0 || Bayar < Total || Bayar == 0) {
            txt_kembalian.setText("0");
            return;
        }
        String Hasil = "" + (Bayar - Total);
        txt_kembalian.setText(Hasil);
    }//GEN-LAST:event_txt_bayarKeyReleased

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
            java.util.logging.Logger.getLogger(Transaksi_Penjualan_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Penjualan_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Penjualan_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Penjualan_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Transaksi_Penjualan_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bab;
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_datamaster;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout2;
    private javax.swing.JButton btn_opname1;
    private javax.swing.JButton btn_oprasional;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.JComboBox<String> cmb_metode;
    private javax.swing.JComboBox<String> cmb_satuan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_hargabeli;
    private javax.swing.JLabel lbl_hargajual;
    private javax.swing.JLabel lbl_image;
    private javax.swing.JLabel lbl_namabarang;
    private javax.swing.JLabel lbl_namabarang1;
    private javax.swing.JLabel lbl_namabarang2;
    private javax.swing.JLabel lbl_stok;
    private javax.swing.JLabel lbl_stok1;
    private javax.swing.JLabel lbl_stok2;
    private javax.swing.JLabel lbl_stok3;
    private javax.swing.JLabel lbl_stok4;
    private javax.swing.JLabel lbl_stok5;
    private javax.swing.JLabel lbl_tanggal;
    private javax.swing.JTable tabel;
    private javax.swing.JFormattedTextField txt_bayar;
    private javax.swing.JFormattedTextField txt_hargajual;
    private javax.swing.JFormattedTextField txt_idakun;
    private javax.swing.JFormattedTextField txt_idbarang;
    private javax.swing.JFormattedTextField txt_idpelanggan;
    private javax.swing.JFormattedTextField txt_idtransaksi;
    private javax.swing.JFormattedTextField txt_jumlah;
    private javax.swing.JFormattedTextField txt_kembalian;
    private javax.swing.JFormattedTextField txt_namabarang;
    private javax.swing.JFormattedTextField txt_namapelanggan;
    private javax.swing.JFormattedTextField txt_subtotal;
    private javax.swing.JFormattedTextField txt_tanggal;
    private javax.swing.JFormattedTextField txt_total;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
