package projectTrexV3;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DecorateCactus extends DecoratorGeneralJFrame implements Enemy, ScoreUpObserver {
	private GeneraJFrame generalJFrame;
	private BufferedImage imgCactus1, imgCactus2;
	private int currentTime, timeMax;
	private List<ImageCactus> cactuses;
	private IMainCharacter main;
	private int speed;

	public DecorateCactus(GeneraJFrame generalJFrame, ScoreUpObservable scoreUpObservable) {
		super(generalJFrame);
		this.generalJFrame = generalJFrame;
		imgCactus1 = new Resource().getResouceImage("data/cactus1.png");
		
		BufferedImage originalImage = Resource.getResouceImage("data/dinoObstacle.png");
		imgCactus2 = originalImage;
		
//		imgCactus2 = resizeImage(originalImage, 23, 46);
		
		System.out.println("cactus1: width= " + imgCactus1.getWidth() + " height: " + imgCactus1.getHeight());
		cactuses = new ArrayList<DecorateCactus.ImageCactus>();
		timeMax = 60;
		speed = 4;
		scoreUpObservable.attach(this);
	}

	// resize image
	public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight)
			throws IOException {
		BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2D = resizedImage.createGraphics();
		graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
		graphics2D.dispose();
		return resizedImage;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		generalJFrame.draw(g);
		for (int i = 0; i < cactuses.size(); i++) {
			ImageCactus cactus = cactuses.get(i);
			g.drawImage(cactus.image, cactus.x, cactus.y, null);
		}
	}

	@Override
	public void tuneParameter() {
		// TODO Auto-generated method stub
		generalJFrame.tuneParameter();
		if (currentTime >= timeMax) {
			createRandomCactus();
			currentTime = 0;
		} else
			currentTime++;
		if (!cactuses.isEmpty()) {
			while (cactuses.get(0).isOutofScreen()) {
				cactuses.remove(0);
				if (cactuses.isEmpty())
					break;
			}
		}
		for (int i = 0; i < cactuses.size(); i++) {
			cactuses.get(i).tuneParameter();
		}
		if (main != null) {
			checkCollison();
		}
	}

	// get rate return image-> 50 %
	// it can increate cactus - or not.
	public void createRandomCactus() {
		int random = (int) (Math.random() * 2);
		if (random == 0) {
			cactuses.add(new ImageCactus(getRandomImage(), getWidth(), getGroundy()));
		}
	}

	// get randomImage;
	public BufferedImage getRandomImage() {
		int random = (int) (Math.random() * 2);
//		if (random == 0) {
//			return imgCactus1;
//		} else
			return imgCactus2;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		generalJFrame.reset();
		while (!cactuses.isEmpty()) {
			cactuses.remove(0);
		}
	}

	class ImageCactus {
		BufferedImage image;
		int x;
		int y;
		Rectangle bound;

		public ImageCactus(BufferedImage image, int x, int y) {
			super();
			this.image = image;
			this.x = x;
			this.y = y - image.getHeight();
			bound = new Rectangle();
		}

		public void tuneParameter() {
			x -= speed;
		}

		public boolean isOutofScreen() {
			return (x + image.getWidth()) < 0;
		}

		public Rectangle getBound() {
			bound.x = x;
			bound.y = y;
			bound.width = image.getWidth();
			bound.height = image.getHeight();
			return bound;
		}
	}

	@Override
	public void setCollisionObject(IMainCharacter main) {
		// TODO Auto-generated method stub
		this.main = main;
	}

	@Override
	public boolean checkCollison() {
		// TODO Auto-generated method stub
		for (int i = 0; i < cactuses.size(); i++) {
			if (cactuses.get(i).getBound().intersects(main.getBound())) {
				main.setCollision(true);
				return true;
			}
		}
		return false;
	}

	@Override
	public void updateScoreUp(int currentScore) {
		// TODO Auto-generated method stub
		if (currentScore == 0) {
			speed = 4;
			timeMax = 60;
		} else {
			speed++;
			if (timeMax == 60)
				timeMax -= 10;
			else
				timeMax -= 5;
		}
	}

}
