package projectTrexV3.mainState;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public interface TrexState {

	public void draw(Graphics g);

	public void tuneParameter();

	public void keyPressed(KeyEvent e);

	public void keyReleased(KeyEvent e);

}
