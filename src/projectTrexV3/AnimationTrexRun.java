package projectTrexV3;

import java.awt.image.BufferedImage;

public class AnimationTrexRun extends Animation {
	private BufferedImage imgRun1, imgRun2;

	public AnimationTrexRun() {
		super();
		imgRun1 = Resource.getResouceImage("data/main-character1.png");
		imgRun2 = Resource.getResouceImage("data/main-character2.png");
		
		images.add(imgRun1);
		images.add(imgRun2);
		
	}

}
