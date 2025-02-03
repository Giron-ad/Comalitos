import javax.swing.*;
import java.awt.*;

public class Proyecto extends JFrame {

    public Proyecto() {
        setTitle("Gestión de Datos");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Proyecto().setVisible(true);
            }
        });
    }
}