package projectTrexV3.mainState;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import projectTrexV3.DecorateTrex;
import projectTrexV3.Resource;

public class DieState implements TrexState {
	private DecorateTrex trex;
	private BufferedImage dieImg;
	private BufferedImage imageOver;
	private BufferedImage imageReplayButton;

	public DieState(DecorateTrex trex) {
		super();
		this.trex = trex;
		dieImg = Resource.getResouceImage("data/main-character4.png");
		imageOver = Resource.getResouceImage("data/gameover_text.png");
		imageReplayButton = Resource.getResouceImage("data/replay_button.png");
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		trex.getGeneralJFrame().draw(g);
		g.drawImage(trex.getCurrentImage(), trex.getTx(), trex.getTy(), null);

		g.drawImage(imageOver, (int) ((trex.getWidth() / 2) - imageOver.getWidth() / 2),
				(int) ((trex.getHeight() / 2) - imageOver.getHeight() / 2), null);
		g.drawImage(imageReplayButton, (int) ((trex.getWidth() / 2) - imageReplayButton.getWidth() / 2),
				(int) ((trex.getHeight() / 2) - imageReplayButton.getHeight() / 2 + imageOver.getHeight() * 2), null);

	}

	@Override
	public void tuneParameter() {
		// TODO Auto-generated method stub
		trex.setCurrentImage(dieImg);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		trex.reset();
		trex.setCollision(false);
		trex.setCurrentState(trex.getPlay());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
