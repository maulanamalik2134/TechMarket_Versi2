package Aplikasi;

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

public class Absen extends javax.swing.JFrame {
    String Tanggal;
    private DefaultTableModel model;
     
    public void setTanggalDanWaktuSekarang() {
    LocalDateTime dateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss");
    String formattedDateTime = dateTime.format(formatter);
    txt_tanggal.setText(formattedDateTime);
}
    public Absen() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat s = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
                txt_tanggal.setText(s.format(date));
            }
        }, 0, 1, TimeUnit.SECONDS);
          tabel_akun();
          txt_idakun.setText(getNextIdAkun());
          kosong1();
    }
    
     private String getNextIdAkun() {
    try {
        String sql = "SELECT MAX(Id_akun) AS max_id FROM akun";
        System.out.println(sql);
        java.sql.Connection conn = Aplikasi.Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);
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
     
    private void kosong1(){
        txt_username.setText(null);
        txt_password.setText(null);
        cmb_role.setSelectedItem(null);
        txt_gmail.setText(null);
        txt_telepon.setText(null);
        txt_alamat.setText(null);
    }
    
    private void tabel_akun() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Akun");
    model.addColumn("Username");
    model.addColumn("Password");
    model.addColumn("Role");
    model.addColumn("Gmail");
    model.addColumn("Telepon");
    model.addColumn("Alamat");

    try {
        int no = 1;
        String sql = "SELECT akun.id_akun, akun.username, akun.password, akun.role, akun.gmail, akun.telepon, akun.alamat FROM akun";
        java.sql.Connection conn = (Connection) Config.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            model.addRow(new Object[]{
                    res.getString("id_akun"),
                    res.getString("username"),
                    res.getString("password"),
                    res.getString("role"),
                    res.getString("gmail"),
                    res.getString("telepon"),
                    res.getString("alamat"),
            });
        }
        tabel_akun.setModel(model);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_akun = new javax.swing.JButton();
        btn_supplier = new javax.swing.JButton();
        btn_barang = new javax.swing.JButton();
        btn_absen = new javax.swing.JButton();
        btn_dashboard = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        btn_laporan = new javax.swing.JButton();
        txt_tanggal = new javax.swing.JLabel();
        lbl_idakun = new javax.swing.JLabel();
        txt_idakun = new javax.swing.JFormattedTextField();
        lbl_gmail = new javax.swing.JLabel();
        txt_gmail = new javax.swing.JFormattedTextField();
        lbl_alamat = new javax.swing.JLabel();
        txt_password = new javax.swing.JFormattedTextField();
        lbl_username = new javax.swing.JLabel();
        txt_username = new javax.swing.JFormattedTextField();
        lbl_password = new javax.swing.JLabel();
        txt_alamat = new javax.swing.JFormattedTextField();
        lbl_telepon = new javax.swing.JLabel();
        txt_telepon = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_akun = new javax.swing.JTable();
        txt_cari = new javax.swing.JFormattedTextField();
        btn_cari = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_tambah = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        cmb_role = new javax.swing.JComboBox<>();
        body = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_akun.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_akun.setForeground(new java.awt.Color(255, 255, 255));
        btn_akun.setText("Akun");
        btn_akun.setContentAreaFilled(false);
        btn_akun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_akunActionPerformed(evt);
            }
        });
        getContentPane().add(btn_akun, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 250, -1));

        btn_supplier.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_supplier.setForeground(new java.awt.Color(255, 255, 255));
        btn_supplier.setText("Supplier");
        btn_supplier.setContentAreaFilled(false);
        btn_supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supplierActionPerformed(evt);
            }
        });
        getContentPane().add(btn_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 250, -1));

        btn_barang.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_barang.setForeground(new java.awt.Color(255, 255, 255));
        btn_barang.setText("Barang");
        btn_barang.setContentAreaFilled(false);
        btn_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_barangActionPerformed(evt);
            }
        });
        getContentPane().add(btn_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 250, -1));

        btn_absen.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_absen.setForeground(new java.awt.Color(255, 255, 255));
        btn_absen.setText("Absen");
        btn_absen.setContentAreaFilled(false);
        btn_absen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_absenActionPerformed(evt);
            }
        });
        getContentPane().add(btn_absen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 250, -1));

        btn_dashboard.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_dashboard.setForeground(new java.awt.Color(255, 255, 255));
        btn_dashboard.setText("Dashboard");
        btn_dashboard.setContentAreaFilled(false);
        btn_dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dashboardActionPerformed(evt);
            }
        });
        getContentPane().add(btn_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 250, -1));

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

        btn_laporan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_laporan.setForeground(new java.awt.Color(255, 255, 255));
        btn_laporan.setText("Laporan");
        btn_laporan.setContentAreaFilled(false);
        btn_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanActionPerformed(evt);
            }
        });
        getContentPane().add(btn_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 250, -1));

        txt_tanggal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_tanggal.setForeground(new java.awt.Color(255, 255, 255));
        txt_tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, 450, 50));

        lbl_idakun.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_idakun.setForeground(new java.awt.Color(255, 255, 255));
        lbl_idakun.setText("Id Akun");
        getContentPane().add(lbl_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        txt_idakun.setEnabled(false);
        txt_idakun.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_idakun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idakunActionPerformed(evt);
            }
        });
        getContentPane().add(txt_idakun, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 100, 30));

        lbl_gmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_gmail.setForeground(new java.awt.Color(255, 255, 255));
        lbl_gmail.setText("Gmail");
        getContentPane().add(lbl_gmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, -1, -1));

        txt_gmail.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_gmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_gmailActionPerformed(evt);
            }
        });
        getContentPane().add(txt_gmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 290, 30));

        lbl_alamat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_alamat.setForeground(new java.awt.Color(255, 255, 255));
        lbl_alamat.setText("Alamat");
        getContentPane().add(lbl_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, -1, -1));

        txt_password.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_passwordActionPerformed(evt);
            }
        });
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 190, 30));

        lbl_username.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 255, 255));
        lbl_username.setText("Username ");
        getContentPane().add(lbl_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 110, -1, -1));

        txt_username.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 190, 30));

        lbl_password.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_password.setForeground(new java.awt.Color(255, 255, 255));
        lbl_password.setText("Password");
        getContentPane().add(lbl_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, -1, -1));

        txt_alamat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_alamatActionPerformed(evt);
            }
        });
        getContentPane().add(txt_alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 190, 290, 30));

        lbl_telepon.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_telepon.setForeground(new java.awt.Color(255, 255, 255));
        lbl_telepon.setText("Telepon");
        getContentPane().add(lbl_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 110, -1, -1));

        txt_telepon.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_telepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teleponActionPerformed(evt);
            }
        });
        getContentPane().add(txt_telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 130, 180, 30));

        tabel_akun.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabel_akun.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Barang", "Id Supplier", "Nama Barang", "Harga", "Stok", "Diskon", "Garansi"
            }
        ));
        tabel_akun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_akunMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_akun);

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
        getContentPane().add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, -1, -1));

        btn_hapus.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 270, -1, -1));

        cmb_role.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cmb_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Kasir", "Karyawan" }));
        getContentPane().add(cmb_role, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 100, 30));

        body.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Small (1).png"))); // NOI18N
        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idakunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idakunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idakunActionPerformed

    private void txt_gmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_gmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_gmailActionPerformed

    private void txt_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordActionPerformed

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_alamatActionPerformed

    private void txt_teleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teleponActionPerformed

    private void tabel_akunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_akunMouseClicked
        int baris = tabel_akun.rowAtPoint(evt.getPoint());
        String id_akun= tabel_akun.getValueAt(baris, 0).toString();
        txt_idakun.setText(id_akun);
        System.out.println(id_akun);
        txt_idakun.disable();
        if (tabel_akun.getValueAt(baris, 1)==null){
            txt_username.setText("");
        } else {
            txt_username.setText(tabel_akun.getValueAt(baris, 1).toString());
        }
        if (tabel_akun.getValueAt(baris, 2)==null){
            txt_password.setText("");
        } else {
            txt_password.setText(tabel_akun.getValueAt(baris, 2).toString());
        }
        if (tabel_akun.getValueAt(baris, 3)==null){
            cmb_role.setSelectedItem("");
        } else {
            cmb_role.setSelectedItem(tabel_akun.getValueAt(baris, 3).toString());
        }
        if (tabel_akun.getValueAt(baris, 4)==null){
            txt_gmail.setText("");
        } else {
            txt_gmail.setText(tabel_akun.getValueAt(baris, 4).toString());
        }
        if (tabel_akun.getValueAt(baris, 5)==null){
            txt_telepon.setText("");
        } else {
            txt_telepon.setText(tabel_akun.getValueAt(baris, 5).toString());
        }
        if (tabel_akun.getValueAt(baris, 6)==null){
            txt_alamat.setText("");
        } else {
            txt_alamat.setText(tabel_akun.getValueAt(baris, 6).toString());
        }
    }//GEN-LAST:event_tabel_akunMouseClicked

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        try {
    Connection conn = Config.configDB();
    Statement statement = conn.createStatement();
    String searchKeyword = txt_cari.getText();
    String sql = "SELECT * FROM akun WHERE username LIKE ?";
    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setString(1, "%" + searchKeyword + "%");
    ResultSet res = pst.executeQuery();

    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Id Akun");
    model.addColumn("Username");
    model.addColumn("Password");
    model.addColumn("Role");
    model.addColumn("Gmail");
    model.addColumn("Telepon");
    model.addColumn("Alamat");
    tabel_akun.setModel(model);

    int no = 1;
    while (res.next()) {
        model.addRow(new Object[]{
            res.getString("id_akun"),
                    res.getString("username"),
                    res.getString("password"),
                    res.getString("role"),
                    res.getString("gmail"),
                    res.getString("telepon"),
                    res.getString("alamat"),
        });
        no++;
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(rootPane, "Gagal Mengambil Data: " + e.getMessage());
}
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        try {
    String idakun = txt_idakun.getText();
    String username = txt_username.getText();
    String password = txt_password.getText();
    String role = (String) cmb_role.getSelectedItem();
    String gmail = txt_gmail.getText();
    String telepon = txt_telepon.getText();
    String alamat = txt_alamat.getText();

    // Periksa apakah setiap field telah diisi
    if (idakun.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Id Akun harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (username.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Username harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (password.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Password harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (role.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Role harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (gmail.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Gmail harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (telepon.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Telepon harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else if (alamat.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Alamat harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        String sqlCheck = "SELECT * FROM akun WHERE username=?";
        java.sql.Connection conn = Aplikasi.Config.configDB();
        java.sql.PreparedStatement pstCheck = conn.prepareStatement(sqlCheck);
        pstCheck.setString(1, username);
        java.sql.ResultSet rsCheck = pstCheck.executeQuery();

        if (rsCheck.next()) {
            JOptionPane.showMessageDialog(null, "Username sudah ada dalam database", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String sql = "INSERT INTO akun (id_akun, username, password, role, gmail, telepon, alamat) VALUES (?, ?, ?, ?, ?, ?, ?)";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, idakun);
            pst.setString(2, username);
            pst.setString(3, password);
            pst.setString(4, role);
            pst.setString(5, gmail);
            pst.setString(6, telepon);
            pst.setString(7, alamat);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            tabel_akun();
            txt_idakun.setText(getNextIdAkun()); // Update ID barang berikutnya setelah penyimpanan berhasil
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
        kosong1();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        try {
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengedit data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        String username = txt_username.getText();
        String password = txt_password.getText();
        String role = (String) cmb_role.getSelectedItem();
        String gmail = txt_gmail.getText();
        String telepon = txt_telepon.getText();
        String alamat = txt_alamat.getText();
        String idakun = txt_idakun.getText();

        // Periksa apakah nama barang yang diedit sudah ada dalam database
        String sqlCheck = "SELECT * FROM akun WHERE username=? AND Id_akun!=?";
        java.sql.Connection conn = Config.configDB();
        java.sql.PreparedStatement pstCheck = conn.prepareStatement(sqlCheck);
        pstCheck.setString(1, username);
        pstCheck.setString(2, idakun);
        java.sql.ResultSet rsCheck = pstCheck.executeQuery();

        if (rsCheck.next()) {
            JOptionPane.showMessageDialog(null, "Username sudah ada dalam database", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String sql = "UPDATE akun SET username=?, password=?, role=?, gmail=?, telepon=?, alamat=? WHERE Id_akun=?";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, role);
            pst.setString(4, gmail);
            pst.setString(5, telepon);
            pst.setString(6, alamat);
            pst.setString(7, idakun);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil diubah", "Berhasil", JOptionPane.INFORMATION_MESSAGE);
            tabel_akun();
            txt_idakun.setText(getNextIdAkun());
            kosong1();
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        try {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this data?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String sqlbarang = "DELETE FROM akun WHERE id_akun=?";
            java.sql.Connection conn = Config.configDB();
            java.sql.PreparedStatement pstbarang = conn.prepareStatement(sqlbarang);
            pstbarang.setString(1, txt_idakun.getText());
            pstbarang.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
            txt_idakun.setText(getNextIdAkun());
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Failed to delete data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    tabel_akun();
    kosong1();
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dashboardActionPerformed
        this.dispose();
        new Dashboard().setVisible(true);
    }//GEN-LAST:event_btn_dashboardActionPerformed

    private void btn_supplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supplierActionPerformed
        this.dispose();
        new Supplier().setVisible(true);
    }//GEN-LAST:event_btn_supplierActionPerformed

    private void btn_barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_barangActionPerformed
        this.dispose();
        new Barang().setVisible(true);
    }//GEN-LAST:event_btn_barangActionPerformed

    private void btn_absenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_absenActionPerformed
        
    }//GEN-LAST:event_btn_absenActionPerformed

    private void btn_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanActionPerformed
        this.dispose();
        new Laporan().setVisible(true);
    }//GEN-LAST:event_btn_laporanActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_akunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_akunActionPerformed
        this.dispose();
        new Akun().setVisible(true);
    }//GEN-LAST:event_btn_akunActionPerformed

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
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Absen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Absen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel body;
    private javax.swing.JButton btn_absen;
    private javax.swing.JButton btn_akun;
    private javax.swing.JButton btn_barang;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_dashboard;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_laporan;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_supplier;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JComboBox<String> cmb_role;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_gmail;
    private javax.swing.JLabel lbl_idakun;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_telepon;
    private javax.swing.JLabel lbl_username;
    private javax.swing.JTable tabel_akun;
    private javax.swing.JFormattedTextField txt_alamat;
    private javax.swing.JFormattedTextField txt_cari;
    private javax.swing.JFormattedTextField txt_gmail;
    private javax.swing.JFormattedTextField txt_idakun;
    private javax.swing.JFormattedTextField txt_password;
    private javax.swing.JLabel txt_tanggal;
    private javax.swing.JFormattedTextField txt_telepon;
    private javax.swing.JFormattedTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
