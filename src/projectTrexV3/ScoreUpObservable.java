package projectTrexV3;

public interface ScoreUpObservable {
	public void attach(ScoreUpObserver o);

	public boolean detach(ScoreUpObserver o);

	public void notifyScoreUpObserver();
}
