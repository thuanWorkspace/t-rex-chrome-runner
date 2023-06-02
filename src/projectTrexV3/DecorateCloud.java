package projectTrexV3;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DecorateCloud extends DecoratorGeneralJFrame {
	private GeneraJFrame generalJFrame;
	private BufferedImage imgCloud;
	// set time to create cloud
	private int currentTime, timeMax;
	private List<ImageCloud> clouds;

	public DecorateCloud(GeneraJFrame generalJFrame) {
		super(generalJFrame);
		this.generalJFrame = generalJFrame;
		imgCloud = Resource.getResouceImage("data/cloud.png");
		clouds = new ArrayList<DecorateCloud.ImageCloud>();
		timeMax = 120;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		generalJFrame.draw(g);
		for (int i = 0; i < clouds.size(); i++) {
			ImageCloud cloud = clouds.get(i);
			g.drawImage(cloud.image, cloud.x, cloud.y, null);
		}
	}

	@Override
	public void tuneParameter() {
		// TODO Auto-generated method stub
		generalJFrame.tuneParameter();
		if (currentTime >= timeMax) {
			getRandomPercentImage();
			currentTime = 0;
		} else {
			currentTime++;
		}
		
		// delete sky out of screen!
		if (!clouds.isEmpty()) {
			while (clouds.get(0).isOutofScreen()) {
				clouds.remove(0);
				if(clouds.isEmpty())
					break;
			}
		}
		//tune parameter for clouds
		for (int i = 0; i < clouds.size(); i++) {
			clouds.get(i).tuneParameter();
		}
	}

	public void getRandomPercentImage() {
		int random = (int) (Math.random() * 3);
		if (random == 0) {
			clouds.add(new ImageCloud(imgCloud, getWidth(), getRandomSky()));
		}
	}

	public int getRandomSky() {
		int number = (int) (Math.random() * (getGroundy() / (2)));
		return number;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		generalJFrame.reset();
		while (!clouds.isEmpty()) {
			clouds.remove(0);
		}
	}

	class ImageCloud {
		BufferedImage image;
		int x;
		int y;

		public ImageCloud(BufferedImage image, int x, int y) {
			super();
			this.image = image;
			this.x = x;
			this.y = y;
		}

		public void tuneParameter() {
			x--;
		}

		public boolean isOutofScreen() {
			return (x + image.getWidth()) < 0;
		}
	}
}
