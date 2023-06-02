package projectTrexV3.mainState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import projectTrexV3.DecorateTrex;
import projectTrexV3.Resource;

public class StartState implements TrexState {
	private DecorateTrex trex;
	private BufferedImage image;
	private int timerun;
	private int x;
	private boolean isDown;
	private int tuneOne;

	public StartState(DecorateTrex trex) {
		super();
		this.trex = trex;
		image = Resource.getResouceImage("data/main-character1.png");
		trex.setCurrentImage(image);
		
		x= 50;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		trex.getGeneralJFrame().draw(g);
		g.drawImage(trex.getCurrentImage(), trex.getTx(), 0, null);
		String string = "spess  \"space\"  to start";
		Font font = new Font("SansSerif", Font.PLAIN, 30);
		g.setFont(font);
		int stringWidth = g.getFontMetrics().stringWidth(string);
		g.setColor(Color.decode("#f7f7f7"));
		g.fillRect(x, 0, trex.getWidth(), trex.getHeight());
		g.setColor(Color.BLACK);
		if (isDown == false)
			g.drawString(string, (int) (trex.getWidth() / 2) - stringWidth / 2, (int) (trex.getHeight() / 2));
	}

	@Override
	public void tuneParameter() {
		// TODO Auto-generated method stub
		if (tuneOne < 15) {
			trex.getGeneralJFrame().tuneParameter();
			tuneOne++;
		}
		if (isDown == true) {
			x+=10;
		}
		if (isDown == true && x >= trex.getWidth())
			trex.setCurrentState(trex.getPlay());

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			isDown = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
