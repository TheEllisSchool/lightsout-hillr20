import java.awt.Dimension;

import javax.swing.JButton;

public class LightButton extends JButton {
	private static final int SIZE = 50;
	
	boolean ison = false;
	Dimension size = new Dimension (SIZE, SIZE);
	
	public boolean getIsOn() {
		return ison;
	}

	//public int setIsOn() {
		
	//}
	
	public void toggle() {
		//if off, turn it to on, if on, turn it to off
		if (ison) {
			ison = false;
			
		}
		else {
			ison = true;
		}
	}
	public void reset() {
		ison = false;
		setText("");
		setBackground(null);
	}
}

