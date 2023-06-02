package projectTrexV3;

import java.awt.Graphics;

public abstract class DecoratorGeneralJFrame extends GeneraJFrame {
	private GeneraJFrame generalJFrame;
	
	public DecoratorGeneralJFrame(GeneraJFrame generalJFrame) {
		super();
		this.generalJFrame = generalJFrame;
	}

	@Override
	public int getGroundy() {
		// TODO Auto-generated method stub
		return generalJFrame.getGroundy();
	}

	@Override
	public void setWidthAndHeight(int width, int height) {
		// TODO Auto-generated method stub
		setSize(width, height);
		generalJFrame.setWidthAndHeight(width, height);
	}

}
