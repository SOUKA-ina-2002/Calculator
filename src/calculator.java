import javax.swing.*;
import java.awt.*;

public class calculator extends JFrame {

    public JButton[] buttons = new JButton[20];
    public JTextField output = new JTextField();

    private void initialiser() {

        this.setLayout(new BorderLayout(0, 2));
        Font font = new Font("Monospace", Font.BOLD, 14);

        buttons[0] = new JButton("MS");
        buttons[1] = new JButton("MR");

        buttons[1].setEnabled(false);

        buttons[2] = new JButton("(");
        buttons[3] = new JButton(")");
        buttons[4] = new JButton("7");
        buttons[5] = new JButton("8");
        buttons[6] = new JButton("9");
        buttons[7] = new JButton("/");
        buttons[8] = new JButton("4");
        buttons[9] = new JButton("5");
        buttons[10] = new JButton("6");
        buttons[11] = new JButton("*");
        buttons[12] = new JButton("1");
        buttons[13] = new JButton("2");
        buttons[14] = new JButton("3");
        buttons[15] = new JButton("+");
        buttons[16] = new JButton(".");
        buttons[17] = new JButton("0");
        buttons[18] = new JButton("=");
        buttons[19] = new JButton("-");

        output.setFont(font);
        // output.setMinimumSize(new Dimension(150,40));
        output.setPreferredSize(new Dimension(250, 40));
        output.setEditable(false);

        GridLayout layout = new GridLayout(5, 4, 2, 2);
        JPanel numerical = new JPanel(layout);
        for (JButton button : buttons) {
            button.setFont(font);
            numerical.add(button);
        }

        this.add(numerical, BorderLayout.CENTER);
        this.add(output, BorderLayout.NORTH);

    }

    private void initEvents() {
        Control controler = new Control(this);
        secondConroller secondcontroler = new secondConroller(this);

        for (JButton button : buttons) {
            button.addActionListener(controler);
        }
        buttons[0].removeActionListener(controler);
        buttons[1].removeActionListener(controler);
        buttons[18].removeActionListener(controler);

        buttons[0].addActionListener(secondcontroler);
        buttons[1].addActionListener(secondcontroler);
        buttons[18].addActionListener(secondcontroler);
    }

    public calculator() {
        this.setTitle("calculator");
        this.setBounds(200, 100, 250, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        initialiser();
        this.initEvents();
        this.setVisible(true);
    }
}
