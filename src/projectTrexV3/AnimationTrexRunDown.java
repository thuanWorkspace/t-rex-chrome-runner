package projectTrexV3;

import java.awt.image.BufferedImage;

public class AnimationTrexRunDown extends Animation {
	private BufferedImage runDownimg1, runDownimg2;

	public AnimationTrexRunDown() {
		super();
		runDownimg1 = Resource.getResouceImage("data/main-character5.png");
		runDownimg2 = Resource.getResouceImage("data/main-character6.png");
		images.add(runDownimg1);
		images.add(runDownimg2);
	}
}
