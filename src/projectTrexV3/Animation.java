package projectTrexV3;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public abstract class Animation {
	protected List<BufferedImage> images;
	private int currentTime, timeMax;
	private int iterateNum;

	public Animation() {
		// TODO Auto-generated constructor stub
		images = new ArrayList<BufferedImage>();
		timeMax = 10;
	}

	public BufferedImage getCurrentImage() {
		if (currentTime >= timeMax) {
			currentTime = 0;
			return images.get(getIterateNum());
		} else {
			currentTime++;
			return images.get(iterateNum);
		}
	}

	public int getIterateNum() {
		if (iterateNum >= images.size() - 1) {
			return iterateNum = 0;
		} else {
			return iterateNum++;
		}

	}

}
