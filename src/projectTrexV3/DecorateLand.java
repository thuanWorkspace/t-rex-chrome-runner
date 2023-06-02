package projectTrexV3;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DecorateLand extends DecoratorGeneralJFrame implements ScoreUpObserver {
	private GeneraJFrame generalJFrame;
	private BufferedImage imgLand1, imgLand2, imgLand3;
	// create number of MaximumLand can make
	private int numberLand;
	private List<ImageLand> lands;
	private int speed;

	public DecorateLand(GeneraJFrame generalJFrame, ScoreUpObservable scoreUpObservable) {
		super(generalJFrame);
		this.generalJFrame = generalJFrame;
		imgLand1 = Resource.getResouceImage("data/land1.png");
		imgLand2 = Resource.getResouceImage("data/land2.png");
		imgLand3 = Resource.getResouceImage("data/land3.png");
		lands = new ArrayList<DecorateLand.ImageLand>();
		speed = 4;
		scoreUpObservable.attach(this);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		generalJFrame.draw(g);
		for (int i = 0; i < lands.size(); i++) {
			ImageLand land = lands.get(i);
			g.drawImage(land.image, land.x, land.y, null);
		}
	}

	@Override
	public void tuneParameter() {
		// TODO Auto-generated method stub
		generalJFrame.tuneParameter();
		// make numberlands!
		numberLand = getWidth() / imgLand1.getWidth() + 4;
		// create if land list is empty
		if (lands.isEmpty()) {
			lands.add(new ImageLand(getRandomLand(),0,getGroundy() - imgLand2.getHeight() / 2 - 7));
		} // if have-let's fullfill the numberLand
		else {
			while (lands.size() < numberLand) {
				lands.add(
						new ImageLand(getRandomLand(), lands.size() - 1, getGroundy() - imgLand2.getHeight() / 2 - 7));
			}
			
		}
		// remove lands out of screen!
		while (lands.get(0).isOutofScreen()) {
			lands.remove(0);
		}
		// tuneparameter for lands
		for (int i = 0; i < lands.size(); i++) {
			lands.get(i).tuneParameter();
		}
	}

	// get random image land
	public BufferedImage getRandomLand() {
		int random = (int) (Math.random() * 9);
		switch (random) {
		case 0:
			return imgLand1;
		case 1:
			return imgLand3;
		default:
			return imgLand2;
		}
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		generalJFrame.reset();
	}

	class ImageLand {
		BufferedImage image;
		int x;
		int y;

		public ImageLand(BufferedImage image, int x, int y) {
			super();
			this.image = image;
			this.x = x * image.getWidth();
			this.y = y;
		}

		public void tuneParameter() {
			x -= speed;
		}

		public boolean isOutofScreen() {
			return (x + image.getWidth()) < 0;
		}
	}

	@Override
	public void updateScoreUp(int currentScore) {
		// TODO Auto-generated method stub
		if (currentScore == 0) {
			speed = 4;
		} else {
			speed++;
		}
	}
}
