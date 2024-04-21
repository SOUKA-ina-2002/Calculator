import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control implements ActionListener {
	
    private calculator cal;
    
    public Control(calculator cal){
        this.cal=cal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        cal.output.setText((cal.output.getText()+source.getText()));

    }
}
