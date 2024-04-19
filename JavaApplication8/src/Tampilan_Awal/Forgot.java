package Tampilan_Awal;

import Config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Forgot extends javax.swing.JFrame {
    private DefaultTableModel model;
    private LocalDateTime dateTime;
    private DateTimeFormatter formatter;
    private Connection conn;

    public Forgot() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setTitle("Aplikasi TechMarket - Toko Remaja Elektronik");

        dateTime = LocalDateTime.now();
        formatter = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy HH:mm:ss", new Locale("id", "ID"));
        lbl_tanggal.setText(dateTime.format(formatter));

        String lokasiToko = "Jl. Raya Situbondo, Blk. Gardu, Cindogo, Tapen, Kabupaten Bondowoso, Jawa Timur 68282";
        lbl_lokasi.setText(lokasiToko);

        try {
            conn = Config.configDB();
        } catch (SQLException ex) {
            Logger.getLogger(Forgot.class.getName()).log(Level.SEVERE, null, ex);
        }

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            dateTime = LocalDateTime.now();
            lbl_tanggal.setText(dateTime.format(formatter));
        }, 0, 1, TimeUnit.SECONDS);
    }

    // ... Rest of the code ...

}
