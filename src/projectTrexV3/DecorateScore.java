package projectTrexV3;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DecorateScore extends DecoratorGeneralJFrame implements ScoreUpObservable {
	private GeneraJFrame generalJFrame;
	private int currentScore, highScore;
	private int currentTime, timeMax;
	private List<ScoreUpObserver> scoreUpObservers;
	private AudioClip scoreUpSound;

	public DecorateScore(GeneraJFrame generalJFrame) {
		super(generalJFrame);
		this.generalJFrame = generalJFrame;
		scoreUpObservers = new ArrayList<ScoreUpObserver>();
		timeMax = 10;
		try {
			scoreUpSound = Applet.newAudioClip(new URL("file", "", "data/scoreup.wav"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		generalJFrame.draw(g);
		g.setColor(Color.BLACK);
		g.drawString("hi: " + highScore, (int) (getWidth() * 0.75), (int) (getHeight() * 0.1));
		g.drawString("score: " + currentScore, (int) (getWidth() * 0.85), (int) (getHeight() * 0.1));

	}

	@Override
	public void tuneParameter() {
		// TODO Auto-generated method stub
		generalJFrame.tuneParameter();
		if (currentTime > timeMax) {
			// create sound and notifyScoreUpObserver.
			if (currentScore != 0 && currentScore % 50 == 0) {
				scoreUpSound.play();
				if (currentScore < 201) {
					notifyScoreUpObserver();
					timeMax--;
				}
			}
			updateScore();
			currentTime = 0;
		} else {
			currentTime++;
		}
	}

	public void updateScore() {
		currentScore++;
		if (highScore < currentScore)
			highScore++;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		generalJFrame.reset();
		currentScore = 0;
		timeMax = 10;
		notifyScoreUpObserver();
	}

	@Override
	public void attach(ScoreUpObserver o) {
		// TODO Auto-generated method stub
		scoreUpObservers.add(o);
	}

	@Override
	public boolean detach(ScoreUpObserver o) {
		// TODO Auto-generated method stub
		return scoreUpObservers.remove(o);
	}

	@Override
	public void notifyScoreUpObserver() {
		// TODO Auto-generated method stub
		for (int i = 0; i < scoreUpObservers.size(); i++) {
			scoreUpObservers.get(i).updateScoreUp(currentScore);
		}
	}

}
