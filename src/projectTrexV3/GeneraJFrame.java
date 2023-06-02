package projectTrexV3;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class GeneraJFrame extends JPanel implements KeyListener {
	private Timer timer;
	private TimerTask task;

	public void createJFrame() {
		JFrame f = new JFrame("project t-rex v3");
		f.setVisible(true);
		f.setSize(1000, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.add(this, BorderLayout.CENTER);
		f.addKeyListener(this);
		timer = new Timer();
		task = new TimerTask() {

			// template method!
			@Override
			public void run() {
				// TODO Auto-generated method stub
				tuneParameter();
				repaint();
				setWidthAndHeight(getWidth(), getHeight());
			}
		};
		timer.schedule(task, 0, 1);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		// template method!
		draw(g);
	}

	public abstract void draw(Graphics g);

	public abstract void tuneParameter();

	public abstract void reset();

	public abstract int getGroundy();

	public abstract void setWidthAndHeight(int width, int height);

	// these are hooks!
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
