package projectTrexV3;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import projectTrexV3.mainState.DieState;
import projectTrexV3.mainState.PlayState;
import projectTrexV3.mainState.StartState;
import projectTrexV3.mainState.TrexState;

public class DecorateTrex extends DecoratorGeneralJFrame implements IMainCharacter {
	private GeneraJFrame generalJFrame;
	private BufferedImage currentImage;
	private int tx, ty;
	private double gravity, speed;
	// to check collision
	private Rectangle bound;
	private boolean isCollision;
	// state
	private TrexState start;
	private TrexState play;
	private TrexState die;
	private TrexState currentState;

	public DecorateTrex(GeneraJFrame generalJFrame) {
		super(generalJFrame);
		this.generalJFrame = generalJFrame;
		gravity = 0.4;
		bound = new Rectangle();

		start = new StartState(this);
		play = new PlayState(this);
		die = new DieState(this);
		currentState = start;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
//		generalJFrame.draw(g);
//		g.drawImage(currentImage, tx, ty, null);
		currentState.draw(g);
	}

	@Override
	public void tuneParameter() {
		// TODO Auto-generated method stub
//		generalJFrame.tuneParameter();
//		tx =(int)(getWidth()*0.1);
//		MakeGrounding();
		currentState.tuneParameter();
	}

	// set grounding
	public void MakeGrounding() {
		// set x
		tx = (int) (getWidth() * 0.1);
		// make grounding!
		speed += gravity;
		if (ty + currentImage.getHeight() < getGroundy()) {
			ty += speed;
		} else {
			ty = getGroundy() - currentImage.getHeight();
		}
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		generalJFrame.reset();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		generalJFrame.keyPressed(e);
		currentState.keyPressed(e);
	}

	public void jump() {
		if (ty == getGroundy() - currentImage.getHeight()) {
			speed = -8;
			ty += speed;
		}
	}

	public void down() {
		if (ty < getGroundy() - currentImage.getHeight()) {
			speed = +5;
			ty += speed;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		generalJFrame.keyReleased(e);
		currentState.keyReleased(e);
	}

	@Override
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		bound.x = tx;
		bound.y = ty;
		bound.width = currentImage.getWidth();
		bound.height = currentImage.getHeight();
		return bound;
	}

	public final boolean isCollision() {
		return isCollision;
	}

	@Override
	public void setCollision(boolean isCollision) {
		// TODO Auto-generated method stub
		this.isCollision = isCollision;
	}

	public final TrexState getCurrentState() {
		return currentState;
	}

	public final void setCurrentState(TrexState currentState) {
		this.currentState = currentState;
	}

	public final GeneraJFrame getGeneralJFrame() {
		return generalJFrame;
	}

	public final BufferedImage getCurrentImage() {
		return currentImage;
	}

	public final void setCurrentImage(BufferedImage currentImage) {
		this.currentImage = currentImage;
	}

	public final int getTx() {
		return tx;
	}

	public final void setTx(int tx) {
		this.tx = tx;
	}

	public final int getTy() {
		return ty;
	}

	public final void setTy(int ty) {
		this.ty = ty;
	}

	public final TrexState getStart() {
		return start;
	}

	public final TrexState getPlay() {
		return play;
	}

	public final TrexState getDie() {
		return die;
	}
	// other relevent getter and setter

	public final double getSpeed() {
		return speed;
	}

	public final void setSpeed(double speed) {
		this.speed = speed;
	}

	public final double getGravity() {
		return gravity;
	}

}
