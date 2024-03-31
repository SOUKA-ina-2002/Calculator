import javax.swing.*;
import java.awt.*;

public class calculator extends JFrame {

    JButton[] buttons=new JButton[20];
    JTextField output= new JTextField();

    private void initialiser() {

        this.setLayout(new BorderLayout(0, 5));

        buttons[0]=new JButton("MS");
        buttons[1]=new JButton("MR");
        buttons[2]=new JButton("(");
        buttons[3]=new JButton(")");
        buttons[4]=new JButton("7");
        buttons[5]=new JButton("8");
        buttons[6]=new JButton("9");
        buttons[7]=new JButton("/");
        buttons[8]=new JButton("4");
        buttons[9]=new JButton("5");
        buttons[10]=new JButton("6");
        buttons[11]=new JButton("*");
        buttons[12]=new JButton("1");
        buttons[13]=new JButton("2");
        buttons[14]=new JButton("3");
        buttons[15]=new JButton("+");
        buttons[16]=new JButton(".");
        buttons[17]=new JButton("0");
        buttons[18]=new JButton("=");
        buttons[19]=new JButton("-");

        GridLayout layout=new GridLayout(5,4,5,5);
        JPanel numerical= new JPanel(layout);
        for (JButton button : buttons){
            numerical.add(button);
        }

        this.add(numerical,BorderLayout.CENTER);
        this.add(output,BorderLayout.NORTH);

    }

    public calculator() {
        this.setTitle("calculator");
        this.setBounds(200,100,250,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        initialiser();
        this.setVisible(true);
    }
}
