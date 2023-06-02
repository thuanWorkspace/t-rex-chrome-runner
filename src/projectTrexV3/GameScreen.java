package projectTrexV3;

import java.awt.Color;
import java.awt.Graphics;

public class GameScreen extends GeneraJFrame {

	public GameScreen() {
		// TODO Auto-generated constructor stub

	}

	@Override
	public void tuneParameter() {
		// TODO Auto-generated method stub
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.decode("#f7f7f7"));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
	}

	@Override
	public int getGroundy() {
		return (int) (getHeight() * 0.9);
	}

	@Override
	public void setWidthAndHeight(int width, int height) {
		// TODO Auto-generated method stub
		setSize(width, height);
	}

}
