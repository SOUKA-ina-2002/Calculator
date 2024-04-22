import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JButton;
import javax.swing.JOptionPane;

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
		// Le bouton "=" a été cliqué
		if (source.equals(this.cal.buttons[18])) {
			if (!this.cal.output.getText().equals("")) {
				try {
					// Créer une instance du ScriptEngine
					ScriptEngineManager manager = new ScriptEngineManager();
					ScriptEngine engine = manager.getEngineByName("JavaScript");
					// Si le ScriptEngine est créé correctement
					if (engine != null) {
						// Evaluer le résultat
						Object result = engine.eval(this.cal.output.getText());
						// Afficher le résultat
						this.cal.output.setText(result.toString());
					}
					// Sinon, utiliser la fonction ci-dessous
					else {
						double result = eval(this.cal.output.getText());
						this.cal.output.setText(Double.toString(result));
					}
				}
				// En cas d'expression mal formée
				catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Expression mal formée", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

	}

	// Credit : Boann (Stackoverflow pseudo)
	// https://stackoverflow.com/questions/3422673/how-to-evaluate-a-math-expression-given-in-string-form
	public static double eval(final String str) {
		return new Object() {
			int pos = -1, ch;
			void nextChar() {
				ch = (++pos < str.length()) ? str.charAt(pos) : -1;
			}
			boolean eat(int charToEat) {
				while (ch == ' ') nextChar();
				if (ch == charToEat) {
					nextChar();
					return true;
				}
				return false;
			}
			double parse() {
				nextChar();
				double x = parseExpression();
				if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
				return x;
			}
			double parseExpression() {
				double x = parseTerm();
				for (;;) {
					if      (eat('+')) x += parseTerm(); // addition
					else if (eat('-')) x -= parseTerm(); // subtraction
					else return x;
				}
			}
			double parseTerm() {
				double x = parseFactor();
				for (;;) {
					if      (eat('*')) x *= parseFactor(); // multiplication
					else if (eat('/')) x /= parseFactor(); // division
					else return x;
				}
			}
			double parseFactor() {
				if (eat('+')) return +parseFactor(); // unary plus
				if (eat('-')) return -parseFactor(); // unary minus
				double x;
				int startPos = this.pos;
				if (eat('(')) { // parentheses
					x = parseExpression();
					if (!eat(')')) throw new RuntimeException("Missing ')'");
				} else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
					while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
					x = Double.parseDouble(str.substring(startPos, this.pos));
				} else if (ch >= 'a' && ch <= 'z') { // functions
					while (ch >= 'a' && ch <= 'z') nextChar();
					String func = str.substring(startPos, this.pos);
					if (eat('(')) {
						x = parseExpression();
						if (!eat(')')) throw new RuntimeException("Missing ')' after argument to " + func);
					} else {
						x = parseFactor();
					}
					if (func.equals("sqrt")) x = Math.sqrt(x);
					else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
					else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
					else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
					else throw new RuntimeException("Unknown function: " + func);
				} else {
					throw new RuntimeException("Unexpected: " + (char)ch);
				}

				if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

				return x;
			}
		}.parse();
	}

}
