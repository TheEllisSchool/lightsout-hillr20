import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class LightButton extends JButton {
	private static final int SIZE = 200;
	
	boolean ison = false;
	Dimension size = new Dimension (SIZE, SIZE);
	
	public boolean getIsOn() {
		return ison;
	}

	//public int setIsOn() {
	
	/*public String color() {
		terrain[r][c].setBackground(Color.BLUE);
		terrain[r][c].setBackground(Color.WHITE);
		
		
	}*/
		
	//}
	
	public void toggle() {
		//if off, turn it to on, if on, turn it to off
		if (ison) {
			ison = false;
			setBackground(Color.BLUE);
				
		}
		else {
			ison = true;
			setBackground(Color.WHITE);
		}
	}
	public void reset() {
		ison = false;
		setText("");
		setBackground(null);
	}
}

