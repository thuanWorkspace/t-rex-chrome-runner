package projectTrexV3.mainState;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import projectTrexV3.Animation;
import projectTrexV3.AnimationTrexRun;
import projectTrexV3.AnimationTrexRunDown;
import projectTrexV3.DecorateTrex;
import projectTrexV3.Resource;

public class PlayState implements TrexState {
	private DecorateTrex trex;
	private Animation animationRun;
	private Animation animationRunDown;
	private Animation currentAnimation;
	private AudioClip jumpSound;
	private AudioClip deadSound;
	private BufferedImage jumpImage;

//	private 
	public PlayState(DecorateTrex trex) {
		super();
		this.trex = trex;
		animationRun = new AnimationTrexRun();
		animationRunDown = new AnimationTrexRunDown();

		currentAnimation = animationRun;
		jumpImage = Resource.getResouceImage("data/main-character3.png");
		try {
			jumpSound = Applet.newAudioClip(new URL("file", "", "data/jump.wav"));
			deadSound = Applet.newAudioClip(new URL("file", "", "data/dead.wav"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		trex.getGeneralJFrame().draw(g);
		g.drawImage(trex.getCurrentImage(), trex.getTx(), trex.getTy(), null);
	}

	@Override
	public void tuneParameter() {
		// TODO Auto-generated method stub
		trex.getGeneralJFrame().tuneParameter();
		trex.MakeGrounding();
		if (trex.getTy() < trex.getGroundy() - trex.getCurrentImage().getHeight()) {
			trex.setCurrentImage(jumpImage);
		} else
			trex.setCurrentImage(currentAnimation.getCurrentImage());
		if (trex.isCollision()) {
			trex.setCurrentState(trex.getDie());
			deadSound.play();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_SPACE) {
			trex.jump();
			jumpSound.play();
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			currentAnimation = animationRunDown;
			trex.down();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		currentAnimation = animationRun;
	}

}
