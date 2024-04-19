import javax.swing.*;
import java.awt.*;

public class Opname extends JFrame {
    public Opname(String title) {
        super(title);
        initComponents();
    }

    private void initComponents() {
        JLabel messageLabel = new JLabel("Welcome to Opname!");
        messageLabel.setFont(new Font("Serif", Font.BOLD, 24));

        setLayout(new FlowLayout());
        add(messageLabel);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Opname opname = new Opname("Opname");
            opname.setVisible(true);
        });
    }
}
