import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class secondConroller implements ActionListener {

	private calculator cal;
	private String memory="";

    public secondConroller(calculator cal){
        this.cal=cal;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
          JButton source = (JButton) e.getSource(); //cast

          //button "ms"
		  if (source==this.cal.buttons[0]) {
			if (!cal.output.getText().equals("")) {
				this.memory=cal.output.getText();
				cal.buttons[1].setEnabled(true);
				cal.output.setText("");
			}
			
		  }
          //button "mr"
		  if (source==this.cal.buttons[1]) {
			cal.output.setText(memory);
		  }
          //button "="
		  if (source==this.cal.buttons[18]) {
			
		  }

	}

}
