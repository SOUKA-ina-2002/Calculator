import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class main extends JFrame {

    private String[] boutons = { "7", "8", "9", "*",
            "4", "5", "6", "/",
            "1", "2", "3", "+",
            ".", "0", "=", "-" };
    JPanel panel = new JPanel();

    public main() {

        super("Calculatrice");

        for (String content : boutons) {

            JButton bouton = new JButton(content);
            panel.add(bouton);

        }

        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        panel.setLayout(new GridLayout(4, 4));

        this.getContentPane().add(panel);




        // Centrer la frame au milieu de l'écran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new main();
            }
        });
    }
}
